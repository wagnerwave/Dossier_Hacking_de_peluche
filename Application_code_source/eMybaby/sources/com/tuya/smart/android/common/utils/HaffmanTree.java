package com.tuya.smart.android.common.utils;

import a.a.a.a.a;
import java.io.PrintStream;

public class HaffmanTree {
    public static final int MAXVALUE = 1000;
    public int nodeNum;

    public static final class Code {
        public int[] bit;
        public int start;
        public int weight;

        public Code(int i) {
            this.bit = new int[i];
            this.start = i - 1;
        }
    }

    public static class HaffNode {
        public int flag;
        public int leftChild;
        public int parent;
        public int rightChild;
        public int weight;
    }

    public HaffmanTree(int i) {
        this.nodeNum = i;
    }

    public static void main(String[] strArr) {
        System.out.println(23);
        HaffmanTree haffmanTree = new HaffmanTree(23);
        HaffNode[] haffNodeArr = new HaffNode[45];
        Code[] codeArr = new Code[23];
        haffmanTree.haffman(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 3, 5, 14, 1, 1}, haffNodeArr);
        haffmanTree.haffmanCode(haffNodeArr, codeArr);
        for (int i = 0; i < 23; i++) {
            PrintStream printStream = System.out;
            StringBuilder n = a.n("Weight=");
            n.append(codeArr[i].weight);
            n.append(" Code=");
            printStream.print(n.toString());
            int i2 = codeArr[i].start;
            while (true) {
                i2++;
                if (i2 >= 23) {
                    break;
                }
                System.out.print(codeArr[i].bit[i2]);
            }
            System.out.println();
        }
    }

    public void haffman(int[] iArr, HaffNode[] haffNodeArr) {
        int i;
        int i2 = this.nodeNum;
        for (int i3 = 0; i3 < (i2 * 2) - 1; i3++) {
            HaffNode haffNode = new HaffNode();
            if (i3 < i2) {
                haffNode.weight = iArr[i3];
            } else {
                haffNode.weight = 0;
            }
            haffNode.parent = 0;
            haffNode.flag = 0;
            haffNode.leftChild = -1;
            haffNode.rightChild = -1;
            haffNodeArr[i3] = haffNode;
        }
        for (int i4 = 0; i4 < i2 - 1; i4++) {
            int i5 = 1000;
            int i6 = 1000;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (true) {
                i = i2 + i4;
                if (i7 >= i) {
                    break;
                }
                if (haffNodeArr[i7].weight < i5 && haffNodeArr[i7].flag == 0) {
                    i9 = i8;
                    i8 = i7;
                    i6 = i5;
                    i5 = haffNodeArr[i7].weight;
                } else if (haffNodeArr[i7].weight < i6 && haffNodeArr[i7].flag == 0) {
                    i6 = haffNodeArr[i7].weight;
                    i9 = i7;
                }
                i7++;
            }
            haffNodeArr[i8].parent = i;
            haffNodeArr[i9].parent = i;
            haffNodeArr[i8].flag = 1;
            haffNodeArr[i9].flag = 1;
            haffNodeArr[i].weight = haffNodeArr[i8].weight + haffNodeArr[i9].weight;
            haffNodeArr[i].leftChild = i8;
            haffNodeArr[i].rightChild = i9;
        }
    }

    public void haffmanCode(HaffNode[] haffNodeArr, Code[] codeArr) {
        int i = this.nodeNum;
        Code code = new Code(i);
        for (int i2 = 0; i2 < i; i2++) {
            code.start = i - 1;
            code.weight = haffNodeArr[i2].weight;
            int i3 = haffNodeArr[i2].parent;
            int i4 = i2;
            while (i3 != 0) {
                if (haffNodeArr[i3].leftChild == i4) {
                    code.bit[code.start] = 0;
                } else {
                    code.bit[code.start] = 1;
                }
                code.start--;
                i4 = i3;
                i3 = haffNodeArr[i3].parent;
            }
            Code code2 = new Code(i);
            for (int i5 = code.start + 1; i5 < i; i5++) {
                code2.bit[i5] = code.bit[i5];
            }
            code2.weight = code.weight;
            code2.start = code.start;
            codeArr[i2] = code2;
        }
    }
}
