package a.d.c.u.p.f.c;

import a.a.a.a.a;
import a.d.c.i;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f3111a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final Object[][] f3112b = {new Object[]{"00", 18}, new Object[]{"01", 14}, new Object[]{"02", 14}, new Object[]{"10", f3111a, 20}, new Object[]{"11", 6}, new Object[]{"12", 6}, new Object[]{"13", 6}, new Object[]{"15", 6}, new Object[]{"17", 6}, new Object[]{"20", 2}, new Object[]{"21", f3111a, 20}, new Object[]{"22", f3111a, 29}, new Object[]{"30", f3111a, 8}, new Object[]{"37", f3111a, 8}, new Object[]{"90", f3111a, 30}, new Object[]{"91", f3111a, 30}, new Object[]{"92", f3111a, 30}, new Object[]{"93", f3111a, 30}, new Object[]{"94", f3111a, 30}, new Object[]{"95", f3111a, 30}, new Object[]{"96", f3111a, 30}, new Object[]{"97", f3111a, 30}, new Object[]{"98", f3111a, 30}, new Object[]{"99", f3111a, 30}};

    /* renamed from: c  reason: collision with root package name */
    public static final Object[][] f3113c = {new Object[]{"240", f3111a, 30}, new Object[]{"241", f3111a, 30}, new Object[]{"242", f3111a, 6}, new Object[]{"250", f3111a, 30}, new Object[]{"251", f3111a, 30}, new Object[]{"253", f3111a, 17}, new Object[]{"254", f3111a, 20}, new Object[]{"400", f3111a, 30}, new Object[]{"401", f3111a, 30}, new Object[]{"402", 17}, new Object[]{"403", f3111a, 30}, new Object[]{"410", 13}, new Object[]{"411", 13}, new Object[]{"412", 13}, new Object[]{"413", 13}, new Object[]{"414", 13}, new Object[]{"420", f3111a, 20}, new Object[]{"421", f3111a, 15}, new Object[]{"422", 3}, new Object[]{"423", f3111a, 15}, new Object[]{"424", 3}, new Object[]{"425", 3}, new Object[]{"426", 3}};

    /* renamed from: d  reason: collision with root package name */
    public static final Object[][] f3114d = {new Object[]{"310", 6}, new Object[]{"311", 6}, new Object[]{"312", 6}, new Object[]{"313", 6}, new Object[]{"314", 6}, new Object[]{"315", 6}, new Object[]{"316", 6}, new Object[]{"320", 6}, new Object[]{"321", 6}, new Object[]{"322", 6}, new Object[]{"323", 6}, new Object[]{"324", 6}, new Object[]{"325", 6}, new Object[]{"326", 6}, new Object[]{"327", 6}, new Object[]{"328", 6}, new Object[]{"329", 6}, new Object[]{"330", 6}, new Object[]{"331", 6}, new Object[]{"332", 6}, new Object[]{"333", 6}, new Object[]{"334", 6}, new Object[]{"335", 6}, new Object[]{"336", 6}, new Object[]{"340", 6}, new Object[]{"341", 6}, new Object[]{"342", 6}, new Object[]{"343", 6}, new Object[]{"344", 6}, new Object[]{"345", 6}, new Object[]{"346", 6}, new Object[]{"347", 6}, new Object[]{"348", 6}, new Object[]{"349", 6}, new Object[]{"350", 6}, new Object[]{"351", 6}, new Object[]{"352", 6}, new Object[]{"353", 6}, new Object[]{"354", 6}, new Object[]{"355", 6}, new Object[]{"356", 6}, new Object[]{"357", 6}, new Object[]{"360", 6}, new Object[]{"361", 6}, new Object[]{"362", 6}, new Object[]{"363", 6}, new Object[]{"364", 6}, new Object[]{"365", 6}, new Object[]{"366", 6}, new Object[]{"367", 6}, new Object[]{"368", 6}, new Object[]{"369", 6}, new Object[]{"390", f3111a, 15}, new Object[]{"391", f3111a, 18}, new Object[]{"392", f3111a, 15}, new Object[]{"393", f3111a, 18}, new Object[]{"703", f3111a, 30}};

    /* renamed from: e  reason: collision with root package name */
    public static final Object[][] f3115e = {new Object[]{"7001", 13}, new Object[]{"7002", f3111a, 30}, new Object[]{"7003", 10}, new Object[]{"8001", 14}, new Object[]{"8002", f3111a, 20}, new Object[]{"8003", f3111a, 30}, new Object[]{"8004", f3111a, 30}, new Object[]{"8005", 6}, new Object[]{"8006", 18}, new Object[]{"8007", f3111a, 30}, new Object[]{"8008", f3111a, 12}, new Object[]{"8018", 18}, new Object[]{"8020", f3111a, 25}, new Object[]{"8100", 6}, new Object[]{"8101", 10}, new Object[]{"8102", 2}, new Object[]{"8110", f3111a, 30}};

    public static String a(String str) {
        if (str.length() == 0) {
            return null;
        }
        if (str.length() >= 2) {
            String substring = str.substring(0, 2);
            for (Object[] objArr : f3112b) {
                if (objArr[0].equals(substring)) {
                    return objArr[1] == f3111a ? c(2, ((Integer) objArr[2]).intValue(), str) : b(2, ((Integer) objArr[1]).intValue(), str);
                }
            }
            if (str.length() >= 3) {
                String substring2 = str.substring(0, 3);
                for (Object[] objArr2 : f3113c) {
                    if (objArr2[0].equals(substring2)) {
                        return objArr2[1] == f3111a ? c(3, ((Integer) objArr2[2]).intValue(), str) : b(3, ((Integer) objArr2[1]).intValue(), str);
                    }
                }
                for (Object[] objArr3 : f3114d) {
                    if (objArr3[0].equals(substring2)) {
                        return objArr3[1] == f3111a ? c(4, ((Integer) objArr3[2]).intValue(), str) : b(4, ((Integer) objArr3[1]).intValue(), str);
                    }
                }
                if (str.length() >= 4) {
                    String substring3 = str.substring(0, 4);
                    for (Object[] objArr4 : f3115e) {
                        if (objArr4[0].equals(substring3)) {
                            return objArr4[1] == f3111a ? c(4, ((Integer) objArr4[2]).intValue(), str) : b(4, ((Integer) objArr4[1]).intValue(), str);
                        }
                    }
                    throw i.f2874a;
                }
                throw i.f2874a;
            }
            throw i.f2874a;
        }
        throw i.f2874a;
    }

    public static String b(int i, int i2, String str) {
        if (str.length() >= i) {
            String substring = str.substring(0, i);
            int i3 = i2 + i;
            if (str.length() >= i3) {
                String substring2 = str.substring(i, i3);
                String str2 = '(' + substring + ')' + substring2;
                String a2 = a(str.substring(i3));
                return a2 == null ? str2 : a.k(str2, a2);
            }
            throw i.f2874a;
        }
        throw i.f2874a;
    }

    public static String c(int i, int i2, String str) {
        String substring = str.substring(0, i);
        int i3 = i2 + i;
        if (str.length() < i3) {
            i3 = str.length();
        }
        String substring2 = str.substring(i, i3);
        String str2 = '(' + substring + ')' + substring2;
        String a2 = a(str.substring(i3));
        return a2 == null ? str2 : a.k(str2, a2);
    }
}
