package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterHelper;
import java.util.List;

public class OpReorderer {
    public final Callback mCallback;

    public interface Callback {
        AdapterHelper.UpdateOp obtainUpdateOp(int i, int i2, int i3, Object obj);

        void recycleUpdateOp(AdapterHelper.UpdateOp updateOp);
    }

    public OpReorderer(Callback callback) {
        this.mCallback = callback;
    }

    private int getLastMoveOutOfOrder(List<AdapterHelper.UpdateOp> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).cmd != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }

    private void swapMoveAdd(List<AdapterHelper.UpdateOp> list, int i, AdapterHelper.UpdateOp updateOp, int i2, AdapterHelper.UpdateOp updateOp2) {
        int i3 = updateOp.itemCount < updateOp2.positionStart ? -1 : 0;
        if (updateOp.positionStart < updateOp2.positionStart) {
            i3++;
        }
        int i4 = updateOp2.positionStart;
        int i5 = updateOp.positionStart;
        if (i4 <= i5) {
            updateOp.positionStart = i5 + updateOp2.itemCount;
        }
        int i6 = updateOp2.positionStart;
        int i7 = updateOp.itemCount;
        if (i6 <= i7) {
            updateOp.itemCount = i7 + updateOp2.itemCount;
        }
        updateOp2.positionStart += i3;
        list.set(i, updateOp2);
        list.set(i2, updateOp);
    }

    private void swapMoveOp(List<AdapterHelper.UpdateOp> list, int i, int i2) {
        AdapterHelper.UpdateOp updateOp = list.get(i);
        AdapterHelper.UpdateOp updateOp2 = list.get(i2);
        int i3 = updateOp2.cmd;
        if (i3 == 1) {
            swapMoveAdd(list, i, updateOp, i2, updateOp2);
        } else if (i3 == 2) {
            swapMoveRemove(list, i, updateOp, i2, updateOp2);
        } else if (i3 == 4) {
            swapMoveUpdate(list, i, updateOp, i2, updateOp2);
        }
    }

    public void reorderOps(List<AdapterHelper.UpdateOp> list) {
        while (true) {
            int lastMoveOutOfOrder = getLastMoveOutOfOrder(list);
            if (lastMoveOutOfOrder != -1) {
                swapMoveOp(list, lastMoveOutOfOrder, lastMoveOutOfOrder + 1);
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x009e, code lost:
        if (r0 > r14.positionStart) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00c8, code lost:
        if (r0 >= r14.positionStart) goto L_0x00ca;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void swapMoveRemove(java.util.List<androidx.recyclerview.widget.AdapterHelper.UpdateOp> r10, int r11, androidx.recyclerview.widget.AdapterHelper.UpdateOp r12, int r13, androidx.recyclerview.widget.AdapterHelper.UpdateOp r14) {
        /*
            r9 = this;
            int r0 = r12.positionStart
            int r1 = r12.itemCount
            r2 = 0
            r3 = 1
            int r4 = r14.positionStart
            if (r0 >= r1) goto L_0x0015
            if (r4 != r0) goto L_0x0013
            int r4 = r14.itemCount
            int r1 = r1 - r0
            if (r4 != r1) goto L_0x0013
            r0 = 0
            goto L_0x001f
        L_0x0013:
            r0 = 0
            goto L_0x0022
        L_0x0015:
            int r5 = r1 + 1
            if (r4 != r5) goto L_0x0021
            int r4 = r14.itemCount
            int r0 = r0 - r1
            if (r4 != r0) goto L_0x0021
            r0 = 1
        L_0x001f:
            r2 = 1
            goto L_0x0022
        L_0x0021:
            r0 = 1
        L_0x0022:
            int r1 = r12.itemCount
            int r4 = r14.positionStart
            r5 = 2
            if (r1 >= r4) goto L_0x002d
            int r4 = r4 - r3
            r14.positionStart = r4
            goto L_0x0046
        L_0x002d:
            int r6 = r14.itemCount
            int r4 = r4 + r6
            if (r1 >= r4) goto L_0x0046
            int r6 = r6 - r3
            r14.itemCount = r6
            r12.cmd = r5
            r12.itemCount = r3
            int r11 = r14.itemCount
            if (r11 != 0) goto L_0x0045
            r10.remove(r13)
            androidx.recyclerview.widget.OpReorderer$Callback r10 = r9.mCallback
            r10.recycleUpdateOp(r14)
        L_0x0045:
            return
        L_0x0046:
            int r1 = r12.positionStart
            int r4 = r14.positionStart
            r6 = 0
            if (r1 > r4) goto L_0x0051
            int r4 = r4 + r3
            r14.positionStart = r4
            goto L_0x0067
        L_0x0051:
            int r7 = r14.itemCount
            int r8 = r4 + r7
            if (r1 >= r8) goto L_0x0067
            int r4 = r4 + r7
            int r4 = r4 - r1
            androidx.recyclerview.widget.OpReorderer$Callback r7 = r9.mCallback
            int r1 = r1 + r3
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r6 = r7.obtainUpdateOp(r5, r1, r4, r6)
            int r1 = r12.positionStart
            int r3 = r14.positionStart
            int r1 = r1 - r3
            r14.itemCount = r1
        L_0x0067:
            if (r2 == 0) goto L_0x0075
            r10.set(r11, r14)
            r10.remove(r13)
            androidx.recyclerview.widget.OpReorderer$Callback r10 = r9.mCallback
            r10.recycleUpdateOp(r12)
            return
        L_0x0075:
            if (r0 == 0) goto L_0x00a1
            if (r6 == 0) goto L_0x008f
            int r0 = r12.positionStart
            int r1 = r6.positionStart
            if (r0 <= r1) goto L_0x0084
            int r1 = r6.itemCount
            int r0 = r0 - r1
            r12.positionStart = r0
        L_0x0084:
            int r0 = r12.itemCount
            int r1 = r6.positionStart
            if (r0 <= r1) goto L_0x008f
            int r1 = r6.itemCount
            int r0 = r0 - r1
            r12.itemCount = r0
        L_0x008f:
            int r0 = r12.positionStart
            int r1 = r14.positionStart
            if (r0 <= r1) goto L_0x009a
            int r1 = r14.itemCount
            int r0 = r0 - r1
            r12.positionStart = r0
        L_0x009a:
            int r0 = r12.itemCount
            int r1 = r14.positionStart
            if (r0 <= r1) goto L_0x00cf
            goto L_0x00ca
        L_0x00a1:
            if (r6 == 0) goto L_0x00b9
            int r0 = r12.positionStart
            int r1 = r6.positionStart
            if (r0 < r1) goto L_0x00ae
            int r1 = r6.itemCount
            int r0 = r0 - r1
            r12.positionStart = r0
        L_0x00ae:
            int r0 = r12.itemCount
            int r1 = r6.positionStart
            if (r0 < r1) goto L_0x00b9
            int r1 = r6.itemCount
            int r0 = r0 - r1
            r12.itemCount = r0
        L_0x00b9:
            int r0 = r12.positionStart
            int r1 = r14.positionStart
            if (r0 < r1) goto L_0x00c4
            int r1 = r14.itemCount
            int r0 = r0 - r1
            r12.positionStart = r0
        L_0x00c4:
            int r0 = r12.itemCount
            int r1 = r14.positionStart
            if (r0 < r1) goto L_0x00cf
        L_0x00ca:
            int r1 = r14.itemCount
            int r0 = r0 - r1
            r12.itemCount = r0
        L_0x00cf:
            r10.set(r11, r14)
            int r14 = r12.positionStart
            int r0 = r12.itemCount
            if (r14 == r0) goto L_0x00dc
            r10.set(r13, r12)
            goto L_0x00df
        L_0x00dc:
            r10.remove(r13)
        L_0x00df:
            if (r6 == 0) goto L_0x00e4
            r10.add(r11, r6)
        L_0x00e4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.OpReorderer.swapMoveRemove(java.util.List, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void swapMoveUpdate(java.util.List<androidx.recyclerview.widget.AdapterHelper.UpdateOp> r9, int r10, androidx.recyclerview.widget.AdapterHelper.UpdateOp r11, int r12, androidx.recyclerview.widget.AdapterHelper.UpdateOp r13) {
        /*
            r8 = this;
            int r0 = r11.itemCount
            int r1 = r13.positionStart
            r2 = 4
            r3 = 0
            r4 = 1
            if (r0 >= r1) goto L_0x000d
            int r1 = r1 - r4
            r13.positionStart = r1
            goto L_0x0020
        L_0x000d:
            int r5 = r13.itemCount
            int r1 = r1 + r5
            if (r0 >= r1) goto L_0x0020
            int r5 = r5 - r4
            r13.itemCount = r5
            androidx.recyclerview.widget.OpReorderer$Callback r0 = r8.mCallback
            int r1 = r11.positionStart
            java.lang.Object r5 = r13.payload
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r0 = r0.obtainUpdateOp(r2, r1, r4, r5)
            goto L_0x0021
        L_0x0020:
            r0 = r3
        L_0x0021:
            int r1 = r11.positionStart
            int r5 = r13.positionStart
            if (r1 > r5) goto L_0x002b
            int r5 = r5 + r4
            r13.positionStart = r5
            goto L_0x0041
        L_0x002b:
            int r6 = r13.itemCount
            int r7 = r5 + r6
            if (r1 >= r7) goto L_0x0041
            int r5 = r5 + r6
            int r5 = r5 - r1
            androidx.recyclerview.widget.OpReorderer$Callback r3 = r8.mCallback
            int r1 = r1 + r4
            java.lang.Object r4 = r13.payload
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r3 = r3.obtainUpdateOp(r2, r1, r5, r4)
            int r1 = r13.itemCount
            int r1 = r1 - r5
            r13.itemCount = r1
        L_0x0041:
            r9.set(r12, r11)
            int r11 = r13.itemCount
            if (r11 <= 0) goto L_0x004c
            r9.set(r10, r13)
            goto L_0x0054
        L_0x004c:
            r9.remove(r10)
            androidx.recyclerview.widget.OpReorderer$Callback r11 = r8.mCallback
            r11.recycleUpdateOp(r13)
        L_0x0054:
            if (r0 == 0) goto L_0x0059
            r9.add(r10, r0)
        L_0x0059:
            if (r3 == 0) goto L_0x005e
            r9.add(r10, r3)
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.OpReorderer.swapMoveUpdate(java.util.List, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp):void");
    }
}
