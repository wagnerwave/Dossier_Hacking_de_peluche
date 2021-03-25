package com.tuya.smart.android.common.task;

import a.a.a.a.a;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TuyaExecutor {
    public static final int CORE_POOL_SIZE;
    public static final int CPU_COUNT;
    public static final long KEEP_ALIVE = 1;
    public static final int MAXIMUM_POOL_SIZE;
    public static final String TAG = "TuyaExecutor";
    public static final int TYPE_ABORT_POLICY = 0;
    public static final int TYPE_CALLER_RUNS_POLICY = 2;
    public static final int TYPE_DISCARD_OLDEST_POLICY = 1;
    public static final int TYPE_DISCARD_POLICY = 3;
    public static final BlockingQueue<Runnable> mPoolWorkQueue = new LinkedBlockingQueue(128);
    public static volatile TuyaExecutor mTuyaExecutor;
    public final ThreadPoolExecutor.AbortPolicy mAbortPolicy = new ThreadPoolExecutor.AbortPolicy();
    public final ThreadPoolExecutor.CallerRunsPolicy mCallerRunsPolicy = new ThreadPoolExecutor.CallerRunsPolicy();
    public final ThreadPoolExecutor.DiscardOldestPolicy mDiscardOldestPolicy = new ThreadPoolExecutor.DiscardOldestPolicy();
    public final ThreadPoolExecutor.DiscardPolicy mDiscardPolicy = new ThreadPoolExecutor.DiscardPolicy();
    public ThreadPoolExecutor mExecutorService = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 1, TimeUnit.SECONDS, mPoolWorkQueue, new ThreadFactory() {
        public final AtomicInteger mCount = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            StringBuilder n = a.n("TuyaThread #");
            n.append(this.mCount.getAndIncrement());
            return new Thread(runnable, n.toString());
        }
    }, new RejectedExecutionHandler() {
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if (runnable instanceof TuyaRunable) {
                TuyaRunable tuyaRunable = (TuyaRunable) runnable;
                if (tuyaRunable.type == 2) {
                    Log.d("TuyaRunable", "TYPE_CALLER_RUNS_POLICY");
                    TuyaExecutor.this.mCallerRunsPolicy.rejectedExecution(runnable, threadPoolExecutor);
                    return;
                } else if (tuyaRunable.type == 1) {
                    Log.d("TuyaRunable", "TYPE_DISCARD_OLDEST_POLICY");
                } else if (tuyaRunable.type == 3) {
                    Log.d("TuyaRunable", "TYPE_DISCARD_POLICY");
                    TuyaExecutor.this.mDiscardPolicy.rejectedExecution(runnable, threadPoolExecutor);
                    return;
                } else if (tuyaRunable.type == 0) {
                    Log.d("TuyaRunable", "TYPE_ABORT_POLICY");
                    return;
                } else {
                    return;
                }
            } else {
                Log.e("TuyaRunable", "TYPE_DISCARD_OLDEST_POLICY");
            }
            TuyaExecutor.this.mDiscardOldestPolicy.rejectedExecution(runnable, threadPoolExecutor);
        }
    });

    public static class TuyaRunable implements Runnable {
        public final Runnable runnable;
        public final int type;

        public TuyaRunable(int i, Runnable runnable2) {
            this.type = i;
            this.runnable = runnable2;
        }

        public void run() {
            Runnable runnable2 = this.runnable;
            if (runnable2 != null) {
                runnable2.run();
            }
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        CORE_POOL_SIZE = availableProcessors + 1;
        MAXIMUM_POOL_SIZE = (availableProcessors * 4) + 1;
    }

    private void excutorAbortPolicy(Runnable runnable) {
        getExecutorService().execute(new TuyaRunable(0, runnable));
    }

    public static TuyaExecutor getInstance() {
        if (mTuyaExecutor == null) {
            synchronized (TuyaExecutor.class) {
                if (mTuyaExecutor == null) {
                    mTuyaExecutor = new TuyaExecutor();
                }
            }
        }
        return mTuyaExecutor;
    }

    public void excutorCallerRunsPolicy(Runnable runnable) {
        getExecutorService().execute(new TuyaRunable(2, runnable));
    }

    public void excutorDiscardOldestPolicy(Runnable runnable) {
        getExecutorService().execute(new TuyaRunable(1, runnable));
    }

    public void excutorDiscardPolicy(Runnable runnable) {
        getExecutorService().execute(new TuyaRunable(3, runnable));
    }

    public ExecutorService getExecutorService() {
        return this.mExecutorService;
    }

    public ExecutorService getTuyaExecutorService() {
        return this.mExecutorService;
    }

    public void onDestroy() {
    }

    public void submitCallerRunsPolicy(Runnable runnable) {
        getExecutorService().submit(new TuyaRunable(2, runnable));
    }

    public void submitDiscardOldestPolicy(Runnable runnable) {
        getExecutorService().submit(new TuyaRunable(1, runnable));
    }

    public void submitDiscardPolicy(Runnable runnable) {
        getExecutorService().submit(new TuyaRunable(3, runnable));
    }
}
