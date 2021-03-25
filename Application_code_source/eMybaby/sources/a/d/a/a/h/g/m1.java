package a.d.a.a.h.g;

import a.d.a.a.h.g.k1;

public final class m1 implements e6 {

    /* renamed from: a  reason: collision with root package name */
    public static final e6 f1822a = new m1();

    public final boolean f(int i) {
        k1.b bVar;
        switch (i) {
            case 0:
                bVar = k1.b.UNDEFINED;
                break;
            case 1:
                bVar = k1.b.NULL;
                break;
            case 2:
                bVar = k1.b.STRING;
                break;
            case 3:
                bVar = k1.b.NUMBER;
                break;
            case 4:
                bVar = k1.b.BOOLEAN;
                break;
            case 5:
                bVar = k1.b.LIST;
                break;
            case 6:
                bVar = k1.b.MAP;
                break;
            case 7:
                bVar = k1.b.STATEMENT;
                break;
            default:
                bVar = null;
                break;
        }
        return bVar != null;
    }
}
