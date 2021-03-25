package com.tuya.smart.android.common.task;

import a.a.a.a.a;
import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class Coordinator {
    public static final String TAG = "Coord";
    public static final Executor mExecutor;
    public static final Queue<TaggedRunnable> mIdleTasks = new LinkedList();
    public static final BlockingQueue<Runnable> mPoolWorkQueue = new LinkedBlockingQueue(128);

    public static class CoordinatorRejectHandler implements RejectedExecutionHandler {
        private Object getOuterClass(Object obj) {
            try {
                Field declaredField = obj.getClass().getDeclaredField("this$0");
                declaredField.setAccessible(true);
                return declaredField.get(obj);
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
                return obj;
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
                return obj;
            } catch (IllegalArgumentException e4) {
                e4.printStackTrace();
                return obj;
            }
        }

        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Object[] array = Coordinator.mPoolWorkQueue.toArray();
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (Object obj : array) {
                sb.append(obj.getClass().isAnonymousClass() ? getOuterClass(obj) : obj.getClass());
                sb.append(',');
                sb.append(' ');
            }
            sb.append(']');
            StringBuilder n = a.n("Task ");
            n.append(runnable.toString());
            n.append(" rejected from ");
            n.append(threadPoolExecutor.toString());
            n.append(" in ");
            n.append(sb.toString());
            throw new RejectedExecutionException(n.toString());
        }
    }

    public static class StandaloneTask extends AsyncTask<Void, Void, Void> {
        public final TaggedRunnable mRunnable;

        public StandaloneTask(TaggedRunnable taggedRunnable) {
            this.mRunnable = taggedRunnable;
        }

        public Void doInBackground(Void... voidArr) {
            Coordinator.runWithTiming(this.mRunnable);
            return null;
        }

        public String toString() {
            return StandaloneTask.class.getSimpleName() + '@' + this.mRunnable;
        }
    }

    public static abstract class TaggedRunnable implements Runnable {
        public final String tag;

        public TaggedRunnable(String str) {
            this.tag = str;
        }

        public String toString() {
            return TaggedRunnable.class.getName() + '@' + this.tag;
        }
    }

    static {
        ExecutorService executorService = TuyaExecutor.getInstance().getExecutorService();
        mExecutor = executorService;
        SaturativeExecutor.installAsDefaultAsyncTaskExecutor((ThreadPoolExecutor) executorService);
    }

    public static Executor getCurrentExecutor() {
        return mExecutor;
    }

    public static Executor getDefaultAsyncTaskExecutor() {
        return AsyncTask.SERIAL_EXECUTOR;
    }

    @TargetApi(11)
    public static ThreadPoolExecutor getDefaultThreadPoolExecutor() {
        try {
            return (ThreadPoolExecutor) AsyncTask.THREAD_POOL_EXECUTOR;
        } catch (Throwable th) {
            Log.e(TAG, "Unexpected failure to get default ThreadPoolExecutor of AsyncTask.", th);
            return null;
        }
    }

    public static void postIdleTask(TaggedRunnable taggedRunnable) {
        mIdleTasks.add(taggedRunnable);
    }

    public static void postTask(TaggedRunnable taggedRunnable) {
        new StandaloneTask(taggedRunnable).executeOnExecutor(mExecutor, new Void[0]);
    }

    public static void postTasks(TaggedRunnable... taggedRunnableArr) {
        for (TaggedRunnable taggedRunnable : taggedRunnableArr) {
            if (taggedRunnable != null) {
                postTask(taggedRunnable);
            }
        }
    }

    public static void runTask(TaggedRunnable taggedRunnable) {
        runWithTiming(taggedRunnable);
    }

    public static void runTasks(TaggedRunnable... taggedRunnableArr) {
        for (TaggedRunnable taggedRunnable : taggedRunnableArr) {
            if (taggedRunnable != null) {
                runWithTiming(taggedRunnable);
            }
        }
    }

    public static void runWithTiming(TaggedRunnable taggedRunnable) {
        try {
            taggedRunnable.run();
        } catch (RuntimeException e2) {
            Log.w(TAG, "Exception in " + taggedRunnable.tag, e2);
        }
    }

    public static void scheduleIdleTasks() {
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            public boolean queueIdle() {
                TaggedRunnable taggedRunnable = (TaggedRunnable) Coordinator.mIdleTasks.poll();
                if (taggedRunnable == null) {
                    return false;
                }
                Coordinator.postTask(taggedRunnable);
                return !Coordinator.mIdleTasks.isEmpty();
            }
        });
    }
}
