package com.alibaba.fastjson;

public enum PropertyNamingStrategy {
    CamelCase,
    PascalCase,
    SnakeCase,
    KebabCase;

    /* renamed from: com.alibaba.fastjson.PropertyNamingStrategy$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|5|6|7|8|(3:9|10|12)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001c */
        static {
            /*
                com.alibaba.fastjson.PropertyNamingStrategy[] r0 = com.alibaba.fastjson.PropertyNamingStrategy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy = r0
                r1 = 1
                r2 = 2
                com.alibaba.fastjson.PropertyNamingStrategy r3 = com.alibaba.fastjson.PropertyNamingStrategy.SnakeCase     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 3
                int[] r3 = $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.alibaba.fastjson.PropertyNamingStrategy r4 = com.alibaba.fastjson.PropertyNamingStrategy.KebabCase     // Catch:{ NoSuchFieldError -> 0x0016 }
                r3[r0] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r2 = $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy     // Catch:{ NoSuchFieldError -> 0x001c }
                com.alibaba.fastjson.PropertyNamingStrategy r3 = com.alibaba.fastjson.PropertyNamingStrategy.PascalCase     // Catch:{ NoSuchFieldError -> 0x001c }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                int[] r0 = $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.alibaba.fastjson.PropertyNamingStrategy r1 = com.alibaba.fastjson.PropertyNamingStrategy.CamelCase     // Catch:{ NoSuchFieldError -> 0x0024 }
                r1 = 0
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.PropertyNamingStrategy.AnonymousClass1.<clinit>():void");
        }
    }

    public String translate(String str) {
        int ordinal = ordinal();
        int i = 0;
        if (ordinal == 0) {
            char charAt = str.charAt(0);
            if (charAt < 'A' || charAt > 'Z') {
                return str;
            }
            char[] charArray = str.toCharArray();
            charArray[0] = (char) (charArray[0] + ' ');
            return new String(charArray);
        } else if (ordinal == 1) {
            char charAt2 = str.charAt(0);
            if (charAt2 < 'a' || charAt2 > 'z') {
                return str;
            }
            char[] charArray2 = str.toCharArray();
            charArray2[0] = (char) (charArray2[0] - ' ');
            return new String(charArray2);
        } else if (ordinal == 2) {
            StringBuilder sb = new StringBuilder();
            while (i < str.length()) {
                char charAt3 = str.charAt(i);
                if (charAt3 >= 'A' && charAt3 <= 'Z') {
                    charAt3 = (char) (charAt3 + ' ');
                    if (i > 0) {
                        sb.append('_');
                    }
                }
                sb.append(charAt3);
                i++;
            }
            return sb.toString();
        } else if (ordinal != 3) {
            return str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            while (i < str.length()) {
                char charAt4 = str.charAt(i);
                if (charAt4 >= 'A' && charAt4 <= 'Z') {
                    charAt4 = (char) (charAt4 + ' ');
                    if (i > 0) {
                        sb2.append('-');
                    }
                }
                sb2.append(charAt4);
                i++;
            }
            return sb2.toString();
        }
    }
}
