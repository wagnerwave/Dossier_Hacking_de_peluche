package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.PorterDuff;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class BlendModeUtils {

    /* renamed from: androidx.core.graphics.BlendModeUtils$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$core$graphics$BlendModeCompat;

        /* JADX WARNING: Can't wrap try/catch for region: R(60:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|29|30|31|(2:33|34)|35|(2:37|38)|39|(2:41|42)|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|61|62|63|(2:65|66)|67|(2:69|70)|71|(2:73|74)|75|(2:77|78)|79|(2:81|82)|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|(3:99|100|102)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(62:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|25|26|27|29|30|31|(2:33|34)|35|(2:37|38)|39|(2:41|42)|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|57|58|59|61|62|63|(2:65|66)|67|(2:69|70)|71|(2:73|74)|75|(2:77|78)|79|(2:81|82)|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|(3:99|100|102)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(69:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|25|26|27|29|30|31|(2:33|34)|35|(2:37|38)|39|(2:41|42)|43|(2:45|46)|47|49|50|51|53|54|55|57|58|59|61|62|63|(2:65|66)|67|(2:69|70)|71|(2:73|74)|75|(2:77|78)|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|102) */
        /* JADX WARNING: Can't wrap try/catch for region: R(73:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|(2:33|34)|35|(2:37|38)|39|(2:41|42)|43|45|46|47|49|50|51|53|54|55|57|58|59|61|62|63|(2:65|66)|67|(2:69|70)|71|(2:73|74)|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|102) */
        /* JADX WARNING: Can't wrap try/catch for region: R(76:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|(2:33|34)|35|(2:37|38)|39|41|42|43|45|46|47|49|50|51|53|54|55|57|58|59|61|62|63|(2:65|66)|67|(2:69|70)|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|102) */
        /* JADX WARNING: Can't wrap try/catch for region: R(79:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|(2:33|34)|35|37|38|39|41|42|43|45|46|47|49|50|51|53|54|55|57|58|59|61|62|63|(2:65|66)|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|102) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:87:0x00b1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:89:0x00b9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:91:0x00c3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:93:0x00cd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:95:0x00d7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:97:0x00e1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:99:0x00eb */
        static {
            /*
                androidx.core.graphics.BlendModeCompat[] r0 = androidx.core.graphics.BlendModeCompat.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$core$graphics$BlendModeCompat = r0
                r1 = 1
                androidx.core.graphics.BlendModeCompat r2 = androidx.core.graphics.BlendModeCompat.CLEAR     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = $SwitchMap$androidx$core$graphics$BlendModeCompat     // Catch:{ NoSuchFieldError -> 0x0016 }
                androidx.core.graphics.BlendModeCompat r3 = androidx.core.graphics.BlendModeCompat.SRC     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = $SwitchMap$androidx$core$graphics$BlendModeCompat     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.core.graphics.BlendModeCompat r3 = androidx.core.graphics.BlendModeCompat.DST     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r0 = 4
                int[] r2 = $SwitchMap$androidx$core$graphics$BlendModeCompat     // Catch:{ NoSuchFieldError -> 0x0024 }
                androidx.core.graphics.BlendModeCompat r3 = androidx.core.graphics.BlendModeCompat.SRC_OVER     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                r1 = 5
                int[] r2 = $SwitchMap$androidx$core$graphics$BlendModeCompat     // Catch:{ NoSuchFieldError -> 0x002b }
                androidx.core.graphics.BlendModeCompat r3 = androidx.core.graphics.BlendModeCompat.DST_OVER     // Catch:{ NoSuchFieldError -> 0x002b }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                r0 = 6
                int[] r2 = $SwitchMap$androidx$core$graphics$BlendModeCompat     // Catch:{ NoSuchFieldError -> 0x0032 }
                androidx.core.graphics.BlendModeCompat r3 = androidx.core.graphics.BlendModeCompat.SRC_IN     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                r1 = 7
                int[] r2 = $SwitchMap$androidx$core$graphics$BlendModeCompat     // Catch:{ NoSuchFieldError -> 0x0039 }
                androidx.core.graphics.BlendModeCompat r3 = androidx.core.graphics.BlendModeCompat.DST_IN     // Catch:{ NoSuchFieldError -> 0x0039 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                r0 = 8
                int[] r2 = $SwitchMap$androidx$core$graphics$BlendModeCompat     // Catch:{ NoSuchFieldError -> 0x0041 }
                androidx.core.graphics.BlendModeCompat r3 = androidx.core.graphics.BlendModeCompat.SRC_OUT     // Catch:{ NoSuchFieldError -> 0x0041 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0041 }
            L_0x0041:
                r1 = 9
                int[] r2 = $SwitchMap$androidx$core$graphics$BlendModeCompat     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.core.graphics.BlendModeCompat r3 = androidx.core.graphics.BlendModeCompat.DST_OUT     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r0 = 10
                int[] r2 = $SwitchMap$androidx$core$graphics$BlendModeCompat     // Catch:{ NoSuchFieldError -> 0x0051 }
                androidx.core.graphics.BlendModeCompat r3 = androidx.core.graphics.BlendModeCompat.SRC_ATOP     // Catch:{ NoSuchFieldError -> 0x0051 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0051 }
            L_0x0051:
                r1 = 11
                int[] r2 = $SwitchMap$androidx$core$graphics$BlendModeCompat     // Catch:{ NoSuchFieldError -> 0x0059 }
                androidx.core.graphics.BlendModeCompat r3 = androidx.core.graphics.BlendModeCompat.DST_ATOP     // Catch:{ NoSuchFieldError -> 0x0059 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                r0 = 12
                int[] r2 = $SwitchMap$androidx$core$graphics$BlendModeCompat     // Catch:{ NoSuchFieldError -> 0x0061 }
                androidx.core.graphics.BlendModeCompat r3 = androidx.core.graphics.BlendModeCompat.XOR     // Catch:{ NoSuchFieldError -> 0x0061 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0061 }
            L_0x0061:
                r1 = 13
                int[] r2 = $SwitchMap$androidx$core$graphics$BlendModeCompat     // Catch:{ NoSuchFieldError -> 0x0069 }
                androidx.core.graphics.BlendModeCompat r3 = androidx.core.graphics.BlendModeCompat.PLUS     // Catch:{ NoSuchFieldError -> 0x0069 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0069 }
            L_0x0069:
                r0 = 14
                int[] r2 = $SwitchMap$androidx$core$graphics$BlendModeCompat     // Catch:{ NoSuchFieldError -> 0x0071 }
                androidx.core.graphics.BlendModeCompat r3 = androidx.core.graphics.BlendModeCompat.MODULATE     // Catch:{ NoSuchFieldError -> 0x0071 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                r1 = 15
                int[] r2 = $SwitchMap$androidx$core$graphics$BlendModeCompat     // Catch:{ NoSuchFieldError -> 0x0079 }
                androidx.core.graphics.BlendModeCompat r3 = androidx.core.graphics.BlendModeCompat.SCREEN     // Catch:{ NoSuchFieldError -> 0x0079 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0079 }
            L_0x0079:
                r0 = 16
                int[] r2 = $SwitchMap$androidx$core$graphics$BlendModeCompat     // Catch:{ NoSuchFieldError -> 0x0081 }
                androidx.core.graphics.BlendModeCompat r3 = androidx.core.graphics.BlendModeCompat.OVERLAY     // Catch:{ NoSuchFieldError -> 0x0081 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0081 }
            L_0x0081:
                r1 = 17
                int[] r2 = $SwitchMap$androidx$core$graphics$BlendModeCompat     // Catch:{ NoSuchFieldError -> 0x0089 }
                androidx.core.graphics.BlendModeCompat r3 = androidx.core.graphics.BlendModeCompat.DARKEN     // Catch:{ NoSuchFieldError -> 0x0089 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0089 }
            L_0x0089:
                r0 = 18
                int[] r2 = $SwitchMap$androidx$core$graphics$BlendModeCompat     // Catch:{ NoSuchFieldError -> 0x0091 }
                androidx.core.graphics.BlendModeCompat r3 = androidx.core.graphics.BlendModeCompat.LIGHTEN     // Catch:{ NoSuchFieldError -> 0x0091 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0091 }
            L_0x0091:
                r1 = 19
                int[] r2 = $SwitchMap$androidx$core$graphics$BlendModeCompat     // Catch:{ NoSuchFieldError -> 0x0099 }
                androidx.core.graphics.BlendModeCompat r3 = androidx.core.graphics.BlendModeCompat.COLOR_DODGE     // Catch:{ NoSuchFieldError -> 0x0099 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0099 }
            L_0x0099:
                r0 = 20
                int[] r2 = $SwitchMap$androidx$core$graphics$BlendModeCompat     // Catch:{ NoSuchFieldError -> 0x00a1 }
                androidx.core.graphics.BlendModeCompat r3 = androidx.core.graphics.BlendModeCompat.COLOR_BURN     // Catch:{ NoSuchFieldError -> 0x00a1 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x00a1 }
            L_0x00a1:
                r1 = 21
                int[] r2 = $SwitchMap$androidx$core$graphics$BlendModeCompat     // Catch:{ NoSuchFieldError -> 0x00a9 }
                androidx.core.graphics.BlendModeCompat r3 = androidx.core.graphics.BlendModeCompat.HARD_LIGHT     // Catch:{ NoSuchFieldError -> 0x00a9 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x00a9 }
            L_0x00a9:
                r0 = 22
                int[] r2 = $SwitchMap$androidx$core$graphics$BlendModeCompat     // Catch:{ NoSuchFieldError -> 0x00b1 }
                androidx.core.graphics.BlendModeCompat r3 = androidx.core.graphics.BlendModeCompat.SOFT_LIGHT     // Catch:{ NoSuchFieldError -> 0x00b1 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x00b1 }
            L_0x00b1:
                int[] r1 = $SwitchMap$androidx$core$graphics$BlendModeCompat     // Catch:{ NoSuchFieldError -> 0x00b9 }
                androidx.core.graphics.BlendModeCompat r2 = androidx.core.graphics.BlendModeCompat.DIFFERENCE     // Catch:{ NoSuchFieldError -> 0x00b9 }
                r2 = 23
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x00b9 }
            L_0x00b9:
                int[] r0 = $SwitchMap$androidx$core$graphics$BlendModeCompat     // Catch:{ NoSuchFieldError -> 0x00c3 }
                androidx.core.graphics.BlendModeCompat r1 = androidx.core.graphics.BlendModeCompat.EXCLUSION     // Catch:{ NoSuchFieldError -> 0x00c3 }
                r1 = 23
                r2 = 24
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c3 }
            L_0x00c3:
                int[] r0 = $SwitchMap$androidx$core$graphics$BlendModeCompat     // Catch:{ NoSuchFieldError -> 0x00cd }
                androidx.core.graphics.BlendModeCompat r1 = androidx.core.graphics.BlendModeCompat.MULTIPLY     // Catch:{ NoSuchFieldError -> 0x00cd }
                r1 = 24
                r2 = 25
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cd }
            L_0x00cd:
                int[] r0 = $SwitchMap$androidx$core$graphics$BlendModeCompat     // Catch:{ NoSuchFieldError -> 0x00d7 }
                androidx.core.graphics.BlendModeCompat r1 = androidx.core.graphics.BlendModeCompat.HUE     // Catch:{ NoSuchFieldError -> 0x00d7 }
                r1 = 25
                r2 = 26
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d7 }
            L_0x00d7:
                int[] r0 = $SwitchMap$androidx$core$graphics$BlendModeCompat     // Catch:{ NoSuchFieldError -> 0x00e1 }
                androidx.core.graphics.BlendModeCompat r1 = androidx.core.graphics.BlendModeCompat.SATURATION     // Catch:{ NoSuchFieldError -> 0x00e1 }
                r1 = 26
                r2 = 27
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e1 }
            L_0x00e1:
                int[] r0 = $SwitchMap$androidx$core$graphics$BlendModeCompat     // Catch:{ NoSuchFieldError -> 0x00eb }
                androidx.core.graphics.BlendModeCompat r1 = androidx.core.graphics.BlendModeCompat.COLOR     // Catch:{ NoSuchFieldError -> 0x00eb }
                r1 = 27
                r2 = 28
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00eb }
            L_0x00eb:
                int[] r0 = $SwitchMap$androidx$core$graphics$BlendModeCompat     // Catch:{ NoSuchFieldError -> 0x00f5 }
                androidx.core.graphics.BlendModeCompat r1 = androidx.core.graphics.BlendModeCompat.LUMINOSITY     // Catch:{ NoSuchFieldError -> 0x00f5 }
                r1 = 28
                r2 = 29
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f5 }
            L_0x00f5:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.BlendModeUtils.AnonymousClass1.<clinit>():void");
        }
    }

    @RequiresApi(29)
    @Nullable
    public static BlendMode obtainBlendModeFromCompat(@NonNull BlendModeCompat blendModeCompat) {
        switch (blendModeCompat.ordinal()) {
            case 0:
                return BlendMode.CLEAR;
            case 1:
                return BlendMode.SRC;
            case 2:
                return BlendMode.DST;
            case 3:
                return BlendMode.SRC_OVER;
            case 4:
                return BlendMode.DST_OVER;
            case 5:
                return BlendMode.SRC_IN;
            case 6:
                return BlendMode.DST_IN;
            case 7:
                return BlendMode.SRC_OUT;
            case 8:
                return BlendMode.DST_OUT;
            case 9:
                return BlendMode.SRC_ATOP;
            case 10:
                return BlendMode.DST_ATOP;
            case 11:
                return BlendMode.XOR;
            case 12:
                return BlendMode.PLUS;
            case 13:
                return BlendMode.MODULATE;
            case 14:
                return BlendMode.SCREEN;
            case 15:
                return BlendMode.OVERLAY;
            case 16:
                return BlendMode.DARKEN;
            case 17:
                return BlendMode.LIGHTEN;
            case 18:
                return BlendMode.COLOR_DODGE;
            case 19:
                return BlendMode.COLOR_BURN;
            case 20:
                return BlendMode.HARD_LIGHT;
            case 21:
                return BlendMode.SOFT_LIGHT;
            case 22:
                return BlendMode.DIFFERENCE;
            case 23:
                return BlendMode.EXCLUSION;
            case 24:
                return BlendMode.MULTIPLY;
            case 25:
                return BlendMode.HUE;
            case 26:
                return BlendMode.SATURATION;
            case 27:
                return BlendMode.COLOR;
            case 28:
                return BlendMode.LUMINOSITY;
            default:
                return null;
        }
    }

    @Nullable
    public static PorterDuff.Mode obtainPorterDuffFromCompat(@Nullable BlendModeCompat blendModeCompat) {
        if (blendModeCompat == null) {
            return null;
        }
        switch (blendModeCompat.ordinal()) {
            case 0:
                return PorterDuff.Mode.CLEAR;
            case 1:
                return PorterDuff.Mode.SRC;
            case 2:
                return PorterDuff.Mode.DST;
            case 3:
                return PorterDuff.Mode.SRC_OVER;
            case 4:
                return PorterDuff.Mode.DST_OVER;
            case 5:
                return PorterDuff.Mode.SRC_IN;
            case 6:
                return PorterDuff.Mode.DST_IN;
            case 7:
                return PorterDuff.Mode.SRC_OUT;
            case 8:
                return PorterDuff.Mode.DST_OUT;
            case 9:
                return PorterDuff.Mode.SRC_ATOP;
            case 10:
                return PorterDuff.Mode.DST_ATOP;
            case 11:
                return PorterDuff.Mode.XOR;
            case 12:
                return PorterDuff.Mode.ADD;
            case 13:
                return PorterDuff.Mode.MULTIPLY;
            case 14:
                return PorterDuff.Mode.SCREEN;
            case 15:
                return PorterDuff.Mode.OVERLAY;
            case 16:
                return PorterDuff.Mode.DARKEN;
            case 17:
                return PorterDuff.Mode.LIGHTEN;
            default:
                return null;
        }
    }
}
