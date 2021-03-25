package com.wnafee.vector.compat;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;

public class PathParser {
    public static final String LOGTAG = "PathParser";

    public static class ExtractFloatResult {
        public int mEndPosition;
        public boolean mEndWithNegSign;

        public ExtractFloatResult() {
        }
    }

    public static class PathDataNode {
        public float[] mParams;
        public char mType;

        public PathDataNode(char c2, float[] fArr) {
            this.mType = c2;
            this.mParams = fArr;
        }

        public PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            float[] fArr = pathDataNode.mParams;
            this.mParams = Arrays.copyOf(fArr, fArr.length);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00f1, code lost:
            r8 = r8 + r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0126, code lost:
            r8 = r8 + r2;
            r2 = r0;
            r3 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0129, code lost:
            r19 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x0215, code lost:
            r2 = r0;
            r3 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x02ba, code lost:
            r3 = r8;
            r2 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x02bd, code lost:
            r8 = r5;
            r9 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x02bf, code lost:
            r7 = r19 + r16;
            r0 = r23;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void addCommand(android.graphics.Path r20, float[] r21, char r22, char r23, float[] r24) {
            /*
                r10 = r20
                r11 = r24
                r12 = 0
                r0 = r21[r12]
                r13 = 1
                r1 = r21[r13]
                r14 = 2
                r2 = r21[r14]
                r15 = 3
                r3 = r21[r15]
                switch(r23) {
                    case 65: goto L_0x0025;
                    case 67: goto L_0x0021;
                    case 72: goto L_0x001e;
                    case 76: goto L_0x0013;
                    case 77: goto L_0x0013;
                    case 81: goto L_0x001a;
                    case 83: goto L_0x001a;
                    case 84: goto L_0x0013;
                    case 86: goto L_0x001e;
                    case 90: goto L_0x0016;
                    case 97: goto L_0x0025;
                    case 99: goto L_0x0021;
                    case 104: goto L_0x001e;
                    case 108: goto L_0x0013;
                    case 109: goto L_0x0013;
                    case 113: goto L_0x001a;
                    case 115: goto L_0x001a;
                    case 116: goto L_0x0013;
                    case 118: goto L_0x001e;
                    case 122: goto L_0x0016;
                    default: goto L_0x0013;
                }
            L_0x0013:
                r16 = 2
                goto L_0x0028
            L_0x0016:
                r20.close()
                return
            L_0x001a:
                r4 = 4
                r16 = 4
                goto L_0x0028
            L_0x001e:
                r16 = 1
                goto L_0x0028
            L_0x0021:
                r4 = 6
                r16 = 6
                goto L_0x0028
            L_0x0025:
                r4 = 7
                r16 = 7
            L_0x0028:
                r9 = r0
                r8 = r1
                r7 = 0
                r0 = r22
            L_0x002d:
                int r1 = r11.length
                if (r7 >= r1) goto L_0x02c9
                r1 = 84
                r5 = 81
                r6 = 67
                r15 = 116(0x74, float:1.63E-43)
                r14 = 115(0x73, float:1.61E-43)
                r13 = 113(0x71, float:1.58E-43)
                r12 = 99
                r17 = 1073741824(0x40000000, float:2.0)
                r4 = 0
                switch(r23) {
                    case 65: goto L_0x0278;
                    case 67: goto L_0x024d;
                    case 72: goto L_0x023f;
                    case 76: goto L_0x022c;
                    case 77: goto L_0x0219;
                    case 81: goto L_0x01f8;
                    case 83: goto L_0x01c0;
                    case 84: goto L_0x0195;
                    case 86: goto L_0x0187;
                    case 90: goto L_0x017c;
                    case 97: goto L_0x012d;
                    case 99: goto L_0x00fe;
                    case 104: goto L_0x00f3;
                    case 108: goto L_0x00e1;
                    case 109: goto L_0x00d0;
                    case 113: goto L_0x00b1;
                    case 115: goto L_0x007b;
                    case 116: goto L_0x0055;
                    case 118: goto L_0x004a;
                    case 122: goto L_0x017c;
                    default: goto L_0x0044;
                }
            L_0x0044:
                r19 = r7
                r5 = r8
                r7 = r9
                goto L_0x02bd
            L_0x004a:
                int r0 = r7 + 0
                r1 = r11[r0]
                r10.rLineTo(r4, r1)
                r0 = r11[r0]
                goto L_0x00f1
            L_0x0055:
                if (r0 == r13) goto L_0x0060
                if (r0 == r15) goto L_0x0060
                if (r0 == r5) goto L_0x0060
                if (r0 != r1) goto L_0x005e
                goto L_0x0060
            L_0x005e:
                r0 = 0
                goto L_0x0064
            L_0x0060:
                float r4 = r9 - r2
                float r0 = r8 - r3
            L_0x0064:
                int r1 = r7 + 0
                r2 = r11[r1]
                int r3 = r7 + 1
                r5 = r11[r3]
                r10.rQuadTo(r4, r0, r2, r5)
                float r4 = r4 + r9
                float r0 = r0 + r8
                r1 = r11[r1]
                float r9 = r9 + r1
                r1 = r11[r3]
                float r8 = r8 + r1
                r3 = r0
                r2 = r4
                goto L_0x0129
            L_0x007b:
                if (r0 == r12) goto L_0x0089
                if (r0 == r14) goto L_0x0089
                if (r0 == r6) goto L_0x0089
                r1 = 83
                if (r0 != r1) goto L_0x0086
                goto L_0x0089
            L_0x0086:
                r1 = 0
                r2 = 0
                goto L_0x008f
            L_0x0089:
                float r0 = r9 - r2
                float r1 = r8 - r3
                r2 = r1
                r1 = r0
            L_0x008f:
                int r12 = r7 + 0
                r3 = r11[r12]
                int r13 = r7 + 1
                r4 = r11[r13]
                int r14 = r7 + 2
                r5 = r11[r14]
                int r15 = r7 + 3
                r6 = r11[r15]
                r0 = r20
                r0.rCubicTo(r1, r2, r3, r4, r5, r6)
                r0 = r11[r12]
                float r0 = r0 + r9
                r1 = r11[r13]
                float r1 = r1 + r8
                r2 = r11[r14]
                float r9 = r9 + r2
                r2 = r11[r15]
                goto L_0x0126
            L_0x00b1:
                int r0 = r7 + 0
                r1 = r11[r0]
                int r2 = r7 + 1
                r3 = r11[r2]
                int r4 = r7 + 2
                r5 = r11[r4]
                int r6 = r7 + 3
                r12 = r11[r6]
                r10.rQuadTo(r1, r3, r5, r12)
                r0 = r11[r0]
                float r0 = r0 + r9
                r1 = r11[r2]
                float r1 = r1 + r8
                r2 = r11[r4]
                float r9 = r9 + r2
                r2 = r11[r6]
                goto L_0x0126
            L_0x00d0:
                int r0 = r7 + 0
                r1 = r11[r0]
                int r4 = r7 + 1
                r5 = r11[r4]
                r10.rMoveTo(r1, r5)
                r0 = r11[r0]
                float r9 = r9 + r0
                r0 = r11[r4]
                goto L_0x00f1
            L_0x00e1:
                int r0 = r7 + 0
                r1 = r11[r0]
                int r4 = r7 + 1
                r5 = r11[r4]
                r10.rLineTo(r1, r5)
                r0 = r11[r0]
                float r9 = r9 + r0
                r0 = r11[r4]
            L_0x00f1:
                float r8 = r8 + r0
                goto L_0x0129
            L_0x00f3:
                int r0 = r7 + 0
                r1 = r11[r0]
                r10.rLineTo(r1, r4)
                r0 = r11[r0]
                float r9 = r9 + r0
                goto L_0x0129
            L_0x00fe:
                int r0 = r7 + 0
                r1 = r11[r0]
                int r0 = r7 + 1
                r2 = r11[r0]
                int r12 = r7 + 2
                r3 = r11[r12]
                int r13 = r7 + 3
                r4 = r11[r13]
                int r14 = r7 + 4
                r5 = r11[r14]
                int r15 = r7 + 5
                r6 = r11[r15]
                r0 = r20
                r0.rCubicTo(r1, r2, r3, r4, r5, r6)
                r0 = r11[r12]
                float r0 = r0 + r9
                r1 = r11[r13]
                float r1 = r1 + r8
                r2 = r11[r14]
                float r9 = r9 + r2
                r2 = r11[r15]
            L_0x0126:
                float r8 = r8 + r2
                r2 = r0
                r3 = r1
            L_0x0129:
                r19 = r7
                goto L_0x02bf
            L_0x012d:
                int r12 = r7 + 5
                r0 = r11[r12]
                float r3 = r0 + r9
                int r13 = r7 + 6
                r0 = r11[r13]
                float r5 = r0 + r8
                int r0 = r7 + 0
                r6 = r11[r0]
                int r0 = r7 + 1
                r14 = r11[r0]
                int r0 = r7 + 2
                r15 = r11[r0]
                int r0 = r7 + 3
                r0 = r11[r0]
                int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r0 == 0) goto L_0x0150
                r17 = 1
                goto L_0x0152
            L_0x0150:
                r17 = 0
            L_0x0152:
                int r0 = r7 + 4
                r0 = r11[r0]
                int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r0 == 0) goto L_0x015d
                r18 = 1
                goto L_0x015f
            L_0x015d:
                r18 = 0
            L_0x015f:
                r0 = r20
                r1 = r9
                r2 = r8
                r4 = r5
                r5 = r6
                r6 = r14
                r19 = r7
                r7 = r15
                r14 = r8
                r8 = r17
                r15 = r9
                r9 = r18
                drawArc(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
                r0 = r11[r12]
                float r9 = r15 + r0
                r0 = r11[r13]
                float r8 = r14 + r0
                goto L_0x02ba
            L_0x017c:
                r19 = r7
                r14 = r8
                r15 = r9
                r20.close()
                r5 = r14
                r7 = r15
                goto L_0x02bd
            L_0x0187:
                r19 = r7
                r15 = r9
                int r7 = r19 + 0
                r0 = r11[r7]
                r10.lineTo(r15, r0)
                r8 = r11[r7]
                goto L_0x02bf
            L_0x0195:
                r19 = r7
                r14 = r8
                r7 = r9
                if (r0 == r13) goto L_0x01a5
                if (r0 == r15) goto L_0x01a5
                if (r0 == r5) goto L_0x01a5
                if (r0 != r1) goto L_0x01a2
                goto L_0x01a5
            L_0x01a2:
                r9 = r7
                r8 = r14
                goto L_0x01ab
            L_0x01a5:
                float r9 = r7 * r17
                float r9 = r9 - r2
                float r8 = r14 * r17
                float r8 = r8 - r3
            L_0x01ab:
                int r7 = r19 + 0
                r0 = r11[r7]
                int r1 = r19 + 1
                r2 = r11[r1]
                r10.quadTo(r9, r8, r0, r2)
                r0 = r11[r7]
                r1 = r11[r1]
                r3 = r8
                r2 = r9
                r9 = r0
                r8 = r1
                goto L_0x02bf
            L_0x01c0:
                r19 = r7
                r5 = r8
                r7 = r9
                if (r0 == r12) goto L_0x01d2
                if (r0 == r14) goto L_0x01d2
                if (r0 == r6) goto L_0x01d2
                r1 = 83
                if (r0 != r1) goto L_0x01cf
                goto L_0x01d2
            L_0x01cf:
                r2 = r5
                r1 = r7
                goto L_0x01da
            L_0x01d2:
                float r9 = r7 * r17
                float r9 = r9 - r2
                float r8 = r5 * r17
                float r8 = r8 - r3
                r2 = r8
                r1 = r9
            L_0x01da:
                int r7 = r19 + 0
                r3 = r11[r7]
                int r8 = r19 + 1
                r4 = r11[r8]
                int r9 = r19 + 2
                r5 = r11[r9]
                int r12 = r19 + 3
                r6 = r11[r12]
                r0 = r20
                r0.cubicTo(r1, r2, r3, r4, r5, r6)
                r0 = r11[r7]
                r1 = r11[r8]
                r9 = r11[r9]
                r8 = r11[r12]
                goto L_0x0215
            L_0x01f8:
                r19 = r7
                int r7 = r19 + 0
                r0 = r11[r7]
                int r1 = r19 + 1
                r2 = r11[r1]
                int r3 = r19 + 2
                r4 = r11[r3]
                int r5 = r19 + 3
                r6 = r11[r5]
                r10.quadTo(r0, r2, r4, r6)
                r0 = r11[r7]
                r1 = r11[r1]
                r9 = r11[r3]
                r8 = r11[r5]
            L_0x0215:
                r2 = r0
                r3 = r1
                goto L_0x02bf
            L_0x0219:
                r19 = r7
                int r7 = r19 + 0
                r0 = r11[r7]
                int r1 = r19 + 1
                r4 = r11[r1]
                r10.moveTo(r0, r4)
                r9 = r11[r7]
                r8 = r11[r1]
                goto L_0x02bf
            L_0x022c:
                r19 = r7
                int r7 = r19 + 0
                r0 = r11[r7]
                int r1 = r19 + 1
                r4 = r11[r1]
                r10.lineTo(r0, r4)
                r9 = r11[r7]
                r8 = r11[r1]
                goto L_0x02bf
            L_0x023f:
                r19 = r7
                r5 = r8
                int r7 = r19 + 0
                r0 = r11[r7]
                r10.lineTo(r0, r5)
                r9 = r11[r7]
                goto L_0x02bf
            L_0x024d:
                r19 = r7
                int r7 = r19 + 0
                r1 = r11[r7]
                int r7 = r19 + 1
                r2 = r11[r7]
                int r7 = r19 + 2
                r3 = r11[r7]
                int r8 = r19 + 3
                r4 = r11[r8]
                int r9 = r19 + 4
                r5 = r11[r9]
                int r12 = r19 + 5
                r6 = r11[r12]
                r0 = r20
                r0.cubicTo(r1, r2, r3, r4, r5, r6)
                r9 = r11[r9]
                r0 = r11[r12]
                r1 = r11[r7]
                r2 = r11[r8]
                r8 = r0
                r3 = r2
                r2 = r1
                goto L_0x02bf
            L_0x0278:
                r19 = r7
                r5 = r8
                r7 = r9
                int r12 = r19 + 5
                r3 = r11[r12]
                int r13 = r19 + 6
                r6 = r11[r13]
                int r0 = r19 + 0
                r8 = r11[r0]
                int r0 = r19 + 1
                r9 = r11[r0]
                int r0 = r19 + 2
                r14 = r11[r0]
                int r0 = r19 + 3
                r0 = r11[r0]
                int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r0 == 0) goto L_0x029a
                r15 = 1
                goto L_0x029b
            L_0x029a:
                r15 = 0
            L_0x029b:
                int r0 = r19 + 4
                r0 = r11[r0]
                int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r0 == 0) goto L_0x02a6
                r17 = 1
                goto L_0x02a8
            L_0x02a6:
                r17 = 0
            L_0x02a8:
                r0 = r20
                r1 = r7
                r2 = r5
                r4 = r6
                r5 = r8
                r6 = r9
                r7 = r14
                r8 = r15
                r9 = r17
                drawArc(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
                r9 = r11[r12]
                r8 = r11[r13]
            L_0x02ba:
                r3 = r8
                r2 = r9
                goto L_0x02bf
            L_0x02bd:
                r8 = r5
                r9 = r7
            L_0x02bf:
                int r7 = r19 + r16
                r0 = r23
                r12 = 0
                r13 = 1
                r14 = 2
                r15 = 3
                goto L_0x002d
            L_0x02c9:
                r5 = r8
                r7 = r9
                r0 = 0
                r21[r0] = r7
                r0 = 1
                r21[r0] = r5
                r0 = 2
                r21[r0] = r2
                r0 = 3
                r21[r0] = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wnafee.vector.compat.PathParser.PathDataNode.addCommand(android.graphics.Path, float[], char, char, float[]):void");
        }

        public static void arcToBezier(Path path, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
            double d11 = d4;
            int abs = Math.abs((int) Math.ceil((d10 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d8);
            double sin = Math.sin(d8);
            double cos2 = Math.cos(d9);
            double sin2 = Math.sin(d9);
            double d12 = -d11;
            double d13 = d12 * cos;
            double d14 = d5 * sin;
            double d15 = (d13 * sin2) - (d14 * cos2);
            double d16 = d12 * sin;
            double d17 = d5 * cos;
            double d18 = (cos2 * d17) + (sin2 * d16);
            double d19 = (double) abs;
            Double.isNaN(d19);
            double d20 = d10 / d19;
            double d21 = d9;
            double d22 = d18;
            double d23 = d15;
            int i = 0;
            double d24 = d6;
            double d25 = d7;
            while (i < abs) {
                double d26 = d21 + d20;
                double sin3 = Math.sin(d26);
                double cos3 = Math.cos(d26);
                double d27 = (((d11 * cos) * cos3) + d2) - (d14 * sin3);
                double d28 = (d17 * sin3) + (d11 * sin * cos3) + d3;
                double d29 = (d13 * sin3) - (d14 * cos3);
                double d30 = (cos3 * d17) + (sin3 * d16);
                double d31 = d26 - d21;
                double tan = Math.tan(d31 / 2.0d);
                double sqrt = ((Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d) * Math.sin(d31)) / 3.0d;
                double d32 = cos;
                float f = (float) (d27 - (sqrt * d29));
                path.cubicTo((float) ((d23 * sqrt) + d24), (float) ((d22 * sqrt) + d25), f, (float) (d28 - (sqrt * d30)), (float) d27, (float) d28);
                i++;
                d20 = d20;
                sin = sin;
                d25 = d28;
                d24 = d27;
                cos = d32;
                d21 = d26;
                d22 = d30;
                d23 = d29;
                abs = abs;
                d11 = d4;
            }
        }

        public static void drawArc(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d2;
            double d3;
            float f8 = f;
            float f9 = f3;
            float f10 = f5;
            boolean z3 = z2;
            double radians = Math.toRadians((double) f7);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d4 = (double) f8;
            Double.isNaN(d4);
            double d5 = d4 * cos;
            double d6 = d4;
            double d7 = (double) f2;
            Double.isNaN(d7);
            double d8 = (double) f10;
            Double.isNaN(d8);
            double d9 = ((d7 * sin) + d5) / d8;
            double d10 = (double) (-f8);
            Double.isNaN(d10);
            Double.isNaN(d7);
            double d11 = (d7 * cos) + (d10 * sin);
            double d12 = (double) f6;
            Double.isNaN(d12);
            double d13 = d11 / d12;
            double d14 = d7;
            double d15 = (double) f9;
            Double.isNaN(d15);
            double d16 = (double) f4;
            Double.isNaN(d16);
            Double.isNaN(d8);
            double d17 = ((d16 * sin) + (d15 * cos)) / d8;
            double d18 = (double) (-f9);
            Double.isNaN(d18);
            Double.isNaN(d16);
            Double.isNaN(d12);
            double d19 = ((d16 * cos) + (d18 * sin)) / d12;
            double d20 = d9 - d17;
            double d21 = d13 - d19;
            double d22 = (d9 + d17) / 2.0d;
            double d23 = (d13 + d19) / 2.0d;
            double d24 = sin;
            double d25 = (d21 * d21) + (d20 * d20);
            if (d25 == 0.0d) {
                Log.w(PathParser.LOGTAG, " Points are coincident");
                return;
            }
            double d26 = (1.0d / d25) - 0.25d;
            if (d26 < 0.0d) {
                String str = PathParser.LOGTAG;
                Log.w(str, "Points are too far apart " + d25);
                float sqrt = (float) (Math.sqrt(d25) / 1.99999d);
                drawArc(path, f, f2, f3, f4, f10 * sqrt, f6 * sqrt, f7, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(d26);
            double d27 = d20 * sqrt2;
            double d28 = sqrt2 * d21;
            boolean z4 = z2;
            if (z == z4) {
                d3 = d22 - d28;
                d2 = d23 + d27;
            } else {
                d3 = d22 + d28;
                d2 = d23 - d27;
            }
            double atan2 = Math.atan2(d13 - d2, d9 - d3);
            double atan22 = Math.atan2(d19 - d2, d17 - d3) - atan2;
            if (z4 != (atan22 >= 0.0d)) {
                atan22 = atan22 > 0.0d ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            Double.isNaN(d8);
            double d29 = d3 * d8;
            Double.isNaN(d12);
            double d30 = d2 * d12;
            arcToBezier(path, (d29 * cos) - (d30 * d24), (d30 * cos) + (d29 * d24), d8, d12, d6, d14, radians, atan2, atan22);
        }

        public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
            float[] fArr = new float[4];
            char c2 = 'm';
            for (int i = 0; i < pathDataNodeArr.length; i++) {
                addCommand(path, fArr, c2, pathDataNodeArr[i].mType, pathDataNodeArr[i].mParams);
                c2 = pathDataNodeArr[i].mType;
            }
        }

        public void interpolatePathDataNode(PathDataNode pathDataNode, PathDataNode pathDataNode2, float f) {
            int i = 0;
            while (true) {
                float[] fArr = pathDataNode.mParams;
                if (i < fArr.length) {
                    this.mParams[i] = (pathDataNode2.mParams[i] * f) + ((1.0f - f) * fArr[i]);
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public static void addNode(ArrayList<PathDataNode> arrayList, char c2, float[] fArr) {
        arrayList.add(new PathDataNode(c2, fArr));
    }

    public static boolean canMorph(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            if (pathDataNodeArr[i].mType != pathDataNodeArr2[i].mType || pathDataNodeArr[i].mParams.length != pathDataNodeArr2[i].mParams.length) {
                return false;
            }
        }
        return true;
    }

    public static PathDataNode[] createNodesFromPathData(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int nextStart = nextStart(str, i);
            String trim = str.substring(i2, nextStart).trim();
            if (trim.length() > 0) {
                addNode(arrayList, trim.charAt(0), getFloats(trim));
            }
            i2 = nextStart;
            i = nextStart + 1;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            addNode(arrayList, str.charAt(i2), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[arrayList.size()]);
    }

    public static Path createPathFromPathData(String str) {
        Path path = new Path();
        PathDataNode[] createNodesFromPathData = createNodesFromPathData(str);
        if (createNodesFromPathData == null) {
            return null;
        }
        PathDataNode.nodesToPath(createNodesFromPathData, path);
        return path;
    }

    public static PathDataNode[] deepCopyNodes(PathDataNode[] pathDataNodeArr) {
        if (pathDataNodeArr == null) {
            return null;
        }
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            pathDataNodeArr2[i] = new PathDataNode(pathDataNodeArr[i]);
        }
        return pathDataNodeArr2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0024 A[LOOP:0: B:1:0x0004->B:13:0x0024, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0027 A[EDGE_INSN: B:16:0x0027->B:14:0x0027 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void extract(java.lang.String r5, int r6, com.wnafee.vector.compat.PathParser.ExtractFloatResult r7) {
        /*
            r0 = 0
            r7.mEndWithNegSign = r0
            r1 = r6
        L_0x0004:
            int r2 = r5.length()
            if (r1 >= r2) goto L_0x0027
            char r2 = r5.charAt(r1)
            r3 = 32
            r4 = 1
            if (r2 == r3) goto L_0x0020
            r3 = 44
            if (r2 == r3) goto L_0x0020
            r3 = 45
            if (r2 == r3) goto L_0x001c
            goto L_0x0021
        L_0x001c:
            if (r1 == r6) goto L_0x0021
            r7.mEndWithNegSign = r4
        L_0x0020:
            r0 = 1
        L_0x0021:
            if (r0 == 0) goto L_0x0024
            goto L_0x0027
        L_0x0024:
            int r1 = r1 + 1
            goto L_0x0004
        L_0x0027:
            r7.mEndPosition = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wnafee.vector.compat.PathParser.extract(java.lang.String, int, com.wnafee.vector.compat.PathParser$ExtractFloatResult):void");
    }

    public static float[] getFloats(String str) {
        int i = 0;
        int i2 = 1;
        if ((str.charAt(0) == 'z') || (str.charAt(0) == 'Z')) {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int length = str.length();
            while (i2 < length) {
                extract(str, i2, extractFloatResult);
                int i3 = extractFloatResult.mEndPosition;
                if (i2 < i3) {
                    fArr[i] = Float.parseFloat(str.substring(i2, i3));
                    i++;
                }
                i2 = extractFloatResult.mEndWithNegSign ? i3 : i3 + 1;
            }
            return Arrays.copyOf(fArr, i);
        } catch (NumberFormatException e2) {
            String str2 = LOGTAG;
            Log.e(str2, "error in parsing \"" + str + "\"");
            throw e2;
        }
    }

    public static int nextStart(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if ((charAt - 'Z') * (charAt - 'A') <= 0) {
                break;
            }
            if ((charAt - 'z') * (charAt - 'a') <= 0) {
                break;
            }
            i++;
        }
        return i;
    }

    public static void updateNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        for (int i = 0; i < pathDataNodeArr2.length; i++) {
            char unused = pathDataNodeArr[i].mType = pathDataNodeArr2[i].mType;
            for (int i2 = 0; i2 < pathDataNodeArr2[i].mParams.length; i2++) {
                pathDataNodeArr[i].mParams[i2] = pathDataNodeArr2[i].mParams[i2];
            }
        }
    }
}
