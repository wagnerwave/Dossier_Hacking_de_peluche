package com.google.android.material.resources;

public class TextAppearanceConfig {
    public static boolean shouldLoadFontSynchronously;

    public static void setShouldLoadFontSynchronously(boolean z) {
        shouldLoadFontSynchronously = z;
    }

    public static boolean shouldLoadFontSynchronously() {
        return shouldLoadFontSynchronously;
    }
}
