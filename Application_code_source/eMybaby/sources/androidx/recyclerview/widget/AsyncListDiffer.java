package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

public class AsyncListDiffer<T> {
    public static final Executor sMainThreadExecutor = new MainThreadExecutor();
    public final AsyncDifferConfig<T> mConfig;
    @Nullable
    public List<T> mList;
    public final List<ListListener<T>> mListeners;
    public Executor mMainThreadExecutor;
    public int mMaxScheduledGeneration;
    @NonNull
    public List<T> mReadOnlyList;
    public final ListUpdateCallback mUpdateCallback;

    public interface ListListener<T> {
        void onCurrentListChanged(@NonNull List<T> list, @NonNull List<T> list2);
    }

    public static class MainThreadExecutor implements Executor {
        public final Handler mHandler = new Handler(Looper.getMainLooper());

        public void execute(@NonNull Runnable runnable) {
            this.mHandler.post(runnable);
        }
    }

    public AsyncListDiffer(@NonNull ListUpdateCallback listUpdateCallback, @NonNull AsyncDifferConfig<T> asyncDifferConfig) {
        this.mListeners = new CopyOnWriteArrayList();
        this.mReadOnlyList = Collections.emptyList();
        this.mUpdateCallback = listUpdateCallback;
        this.mConfig = asyncDifferConfig;
        this.mMainThreadExecutor = asyncDifferConfig.getMainThreadExecutor() != null ? asyncDifferConfig.getMainThreadExecutor() : sMainThreadExecutor;
    }

    public AsyncListDiffer(@NonNull RecyclerView.Adapter adapter, @NonNull DiffUtil.ItemCallback<T> itemCallback) {
        this((ListUpdateCallback) new AdapterListUpdateCallback(adapter), new AsyncDifferConfig.Builder(itemCallback).build());
    }

    private void onCurrentListChanged(@NonNull List<T> list, @Nullable Runnable runnable) {
        for (ListListener<T> onCurrentListChanged : this.mListeners) {
            onCurrentListChanged.onCurrentListChanged(list, this.mReadOnlyList);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void addListListener(@NonNull ListListener<T> listListener) {
        this.mListeners.add(listListener);
    }

    @NonNull
    public List<T> getCurrentList() {
        return this.mReadOnlyList;
    }

    public void latchList(@NonNull List<T> list, @NonNull DiffUtil.DiffResult diffResult, @Nullable Runnable runnable) {
        List<T> list2 = this.mReadOnlyList;
        this.mList = list;
        this.mReadOnlyList = Collections.unmodifiableList(list);
        diffResult.dispatchUpdatesTo(this.mUpdateCallback);
        onCurrentListChanged(list2, runnable);
    }

    public void removeListListener(@NonNull ListListener<T> listListener) {
        this.mListeners.remove(listListener);
    }

    public void submitList(@Nullable List<T> list) {
        submitList(list, (Runnable) null);
    }

    public void submitList(@Nullable List<T> list, @Nullable Runnable runnable) {
        final int i = this.mMaxScheduledGeneration + 1;
        this.mMaxScheduledGeneration = i;
        final List<T> list2 = this.mList;
        if (list != list2) {
            List<T> list3 = this.mReadOnlyList;
            if (list == null) {
                int size = list2.size();
                this.mList = null;
                this.mReadOnlyList = Collections.emptyList();
                this.mUpdateCallback.onRemoved(0, size);
                onCurrentListChanged(list3, runnable);
            } else if (list2 == null) {
                this.mList = list;
                this.mReadOnlyList = Collections.unmodifiableList(list);
                this.mUpdateCallback.onInserted(0, list.size());
                onCurrentListChanged(list3, runnable);
            } else {
                final List<T> list4 = list;
                final Runnable runnable2 = runnable;
                this.mConfig.getBackgroundThreadExecutor().execute(new Runnable() {
                    public void run() {
                        final DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                            public boolean areContentsTheSame(int i, int i2) {
                                Object obj = list2.get(i);
                                Object obj2 = list4.get(i2);
                                if (obj != null && obj2 != null) {
                                    return AsyncListDiffer.this.mConfig.getDiffCallback().areContentsTheSame(obj, obj2);
                                }
                                if (obj == null && obj2 == null) {
                                    return true;
                                }
                                throw new AssertionError();
                            }

                            public boolean areItemsTheSame(int i, int i2) {
                                Object obj = list2.get(i);
                                Object obj2 = list4.get(i2);
                                return (obj == null || obj2 == null) ? obj == null && obj2 == null : AsyncListDiffer.this.mConfig.getDiffCallback().areItemsTheSame(obj, obj2);
                            }

                            @Nullable
                            public Object getChangePayload(int i, int i2) {
                                Object obj = list2.get(i);
                                Object obj2 = list4.get(i2);
                                if (obj != null && obj2 != null) {
                                    return AsyncListDiffer.this.mConfig.getDiffCallback().getChangePayload(obj, obj2);
                                }
                                throw new AssertionError();
                            }

                            public int getNewListSize() {
                                return list4.size();
                            }

                            public int getOldListSize() {
                                return list2.size();
                            }
                        });
                        AsyncListDiffer.this.mMainThreadExecutor.execute(new Runnable() {
                            public void run() {
                                AnonymousClass1 r0 = AnonymousClass1.this;
                                AsyncListDiffer asyncListDiffer = AsyncListDiffer.this;
                                if (asyncListDiffer.mMaxScheduledGeneration == i) {
                                    asyncListDiffer.latchList(list4, calculateDiff, runnable2);
                                }
                            }
                        });
                    }
                });
            }
        } else if (runnable != null) {
            runnable.run();
        }
    }
}
