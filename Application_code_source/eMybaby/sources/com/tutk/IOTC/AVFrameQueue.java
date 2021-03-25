package com.tutk.IOTC;

import java.io.PrintStream;
import java.util.LinkedList;

public class AVFrameQueue {
    public volatile LinkedList<AVFrame> listData = new LinkedList<>();
    public volatile int mSize = 0;

    public synchronized void addLast(AVFrame aVFrame) {
        int i;
        PrintStream printStream;
        String str;
        if (this.mSize > 1500) {
            boolean z = true;
            while (true) {
                if (this.listData.isEmpty()) {
                    break;
                }
                AVFrame aVFrame2 = this.listData.get(0);
                if (z) {
                    if (aVFrame2.isIFrame()) {
                        printStream = System.out;
                        str = "drop I frame";
                    } else {
                        printStream = System.out;
                        str = "drop p frame";
                    }
                    printStream.println(str);
                    this.listData.removeFirst();
                    i = this.mSize;
                } else if (aVFrame2.isIFrame()) {
                    break;
                } else {
                    System.out.println("drop p frame");
                    this.listData.removeFirst();
                    i = this.mSize;
                }
                this.mSize = i - 1;
                z = false;
            }
        }
        this.listData.addLast(aVFrame);
        this.mSize++;
    }

    public synchronized int getCount() {
        return this.mSize;
    }

    public synchronized boolean isFirstIFrame() {
        boolean z;
        z = false;
        if (this.listData != null && !this.listData.isEmpty() && this.listData.get(0).isIFrame()) {
            z = true;
        }
        return z;
    }

    public synchronized void removeAll() {
        if (!this.listData.isEmpty()) {
            this.listData.clear();
        }
        this.mSize = 0;
    }

    public synchronized AVFrame removeHead() {
        if (this.mSize == 0) {
            return null;
        }
        this.mSize--;
        return this.listData.removeFirst();
    }
}
