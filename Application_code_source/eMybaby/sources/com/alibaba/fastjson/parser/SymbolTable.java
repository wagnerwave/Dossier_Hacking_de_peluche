package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;

public class SymbolTable {
    public final int indexMask;
    public final Entry[] symbols;

    public static class Entry {
        public final char[] chars;
        public final int hashCode;
        public final String value;

        public Entry(String str, int i) {
            this.value = str;
            this.chars = str.toCharArray();
            this.hashCode = i;
        }
    }

    public SymbolTable(int i) {
        this.indexMask = i - 1;
        this.symbols = new Entry[i];
        addSymbol("$ref", 0, 4, 1185263);
        addSymbol(JSON.DEFAULT_TYPE_KEY, 0, 5, 62680954);
    }

    public static String subString(String str, int i, int i2) {
        char[] cArr = new char[i2];
        str.getChars(i, i2 + i, cArr, 0);
        return new String(cArr);
    }

    public String addSymbol(String str, int i, int i2, int i3) {
        int i4 = this.indexMask & i3;
        Entry entry = this.symbols[i4];
        if (entry != null) {
            return (i3 == entry.hashCode && i2 == entry.chars.length && str.regionMatches(i, entry.value, 0, i2)) ? entry.value : subString(str, i, i2);
        }
        if (i2 != str.length()) {
            str = subString(str, i, i2);
        }
        String intern = str.intern();
        this.symbols[i4] = new Entry(intern, i3);
        return intern;
    }

    public String addSymbol(char[] cArr, int i, int i2, int i3) {
        int i4 = this.indexMask & i3;
        Entry entry = this.symbols[i4];
        if (entry != null) {
            boolean z = false;
            if (i3 == entry.hashCode && i2 == entry.chars.length) {
                int i5 = 0;
                while (true) {
                    if (i5 >= i2) {
                        z = true;
                        break;
                    } else if (cArr[i + i5] != entry.chars[i5]) {
                        break;
                    } else {
                        i5++;
                    }
                }
            }
            return z ? entry.value : new String(cArr, i, i2);
        }
        String intern = new String(cArr, i, i2).intern();
        this.symbols[i4] = new Entry(intern, i3);
        return intern;
    }
}
