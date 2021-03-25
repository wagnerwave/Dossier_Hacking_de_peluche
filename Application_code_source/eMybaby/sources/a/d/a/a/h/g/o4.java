package a.d.a.a.h.g;

import a.d.a.a.h.g.o4;
import a.d.a.a.h.g.q4;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class o4<MessageType extends o4<MessageType, BuilderType>, BuilderType extends q4<MessageType, BuilderType>> implements i7 {
    public int zza = 0;

    public static <T> void i(Iterable<T> iterable, List<? super T> list) {
        a6.d(iterable);
        if (iterable instanceof p6) {
            List<?> b2 = ((p6) iterable).b();
            p6 p6Var = (p6) list;
            int size = list.size();
            for (Object next : b2) {
                if (next == null) {
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(p6Var.size() - size);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    int size2 = p6Var.size();
                    while (true) {
                        size2--;
                        if (size2 >= size) {
                            p6Var.remove(size2);
                        } else {
                            throw new NullPointerException(sb2);
                        }
                    }
                } else if (next instanceof w4) {
                    p6Var.g((w4) next);
                } else {
                    p6Var.add((String) next);
                }
            }
        } else if (iterable instanceof s7) {
            list.addAll((Collection) iterable);
        } else {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(((Collection) iterable).size() + list.size());
            }
            int size3 = list.size();
            for (T next2 : iterable) {
                if (next2 == null) {
                    StringBuilder sb3 = new StringBuilder(37);
                    sb3.append("Element at index ");
                    sb3.append(list.size() - size3);
                    sb3.append(" is null.");
                    String sb4 = sb3.toString();
                    int size4 = list.size();
                    while (true) {
                        size4--;
                        if (size4 >= size3) {
                            list.remove(size4);
                        } else {
                            throw new NullPointerException(sb4);
                        }
                    }
                } else {
                    list.add(next2);
                }
            }
        }
    }

    public final w4 b() {
        try {
            c5 p = w4.p(c());
            e(p.f1642a);
            return p.a();
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder("ByteString".length() + name.length() + 62);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    public final byte[] j() {
        try {
            byte[] bArr = new byte[c()];
            i5 d2 = i5.d(bArr);
            e(d2);
            if (d2.a() == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(10 + name.length() + 62);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }
}
