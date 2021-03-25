package com.nineoldandroids.util;

import a.a.a.a.a;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectiveProperty<T, V> extends Property<T, V> {
    public static final String PREFIX_GET = "get";
    public static final String PREFIX_IS = "is";
    public static final String PREFIX_SET = "set";
    public Field mField;
    public Method mGetter;
    public Method mSetter;

    /* JADX WARNING: Can't wrap try/catch for region: R(3:19|20|(1:22)(2:23|24)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:6|5|7|8|9|10) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:0|1|2|3|4|11|(4:13|14|15|28)(2:17|18)) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r7 = r11.getDeclaredMethod(r7, (java.lang.Class[]) null);
        r10.mGetter = r7;
        r7.setAccessible(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r11 = r11.getField(r13);
        r10.mField = r11;
        r11 = r11.getType();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a5, code lost:
        if (typesMatch(r12, r11) != false) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a7, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00c8, code lost:
        throw new com.nineoldandroids.util.NoSuchPropertyException("Underlying type (" + r11 + ") " + "does not match Property type (" + r12 + ")");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00d4, code lost:
        throw new com.nineoldandroids.util.NoSuchPropertyException(a.a.a.a.a.k("No accessor method or field found for property with name ", r13));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0040, code lost:
        r7 = a.a.a.a.a.k(PREFIX_IS, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r10.mGetter = r11.getMethod(r7, (java.lang.Class[]) null);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0097 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0036 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x004d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ReflectiveProperty(java.lang.Class<T> r11, java.lang.Class<V> r12, java.lang.String r13) {
        /*
            r10 = this;
            java.lang.String r0 = ")"
            java.lang.String r1 = "does not match Property type ("
            java.lang.String r2 = ") "
            java.lang.String r3 = "Underlying type ("
            r10.<init>(r12, r13)
            r4 = 0
            char r5 = r13.charAt(r4)
            char r5 = java.lang.Character.toUpperCase(r5)
            r6 = 1
            java.lang.String r7 = r13.substring(r6)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r5)
            r8.append(r7)
            java.lang.String r5 = r8.toString()
            java.lang.String r7 = "get"
            java.lang.String r7 = a.a.a.a.a.k(r7, r5)
            r8 = 0
            java.lang.reflect.Method r9 = r11.getMethod(r7, r8)     // Catch:{ NoSuchMethodException -> 0x0036 }
            r10.mGetter = r9     // Catch:{ NoSuchMethodException -> 0x0036 }
            goto L_0x0056
        L_0x0036:
            java.lang.reflect.Method r7 = r11.getDeclaredMethod(r7, r8)     // Catch:{ NoSuchMethodException -> 0x0040 }
            r10.mGetter = r7     // Catch:{ NoSuchMethodException -> 0x0040 }
            r7.setAccessible(r6)     // Catch:{ NoSuchMethodException -> 0x0040 }
            goto L_0x0056
        L_0x0040:
            java.lang.String r7 = "is"
            java.lang.String r7 = a.a.a.a.a.k(r7, r5)
            java.lang.reflect.Method r9 = r11.getMethod(r7, r8)     // Catch:{ NoSuchMethodException -> 0x004d }
            r10.mGetter = r9     // Catch:{ NoSuchMethodException -> 0x004d }
            goto L_0x0056
        L_0x004d:
            java.lang.reflect.Method r7 = r11.getDeclaredMethod(r7, r8)     // Catch:{ NoSuchMethodException -> 0x0097 }
            r10.mGetter = r7     // Catch:{ NoSuchMethodException -> 0x0097 }
            r7.setAccessible(r6)     // Catch:{ NoSuchMethodException -> 0x0097 }
        L_0x0056:
            java.lang.reflect.Method r13 = r10.mGetter
            java.lang.Class r13 = r13.getReturnType()
            boolean r7 = r10.typesMatch(r12, r13)
            if (r7 == 0) goto L_0x0076
            java.lang.String r12 = "set"
            java.lang.String r12 = a.a.a.a.a.k(r12, r5)
            java.lang.Class[] r0 = new java.lang.Class[r6]     // Catch:{ NoSuchMethodException -> 0x0075 }
            r0[r4] = r13     // Catch:{ NoSuchMethodException -> 0x0075 }
            java.lang.reflect.Method r11 = r11.getDeclaredMethod(r12, r0)     // Catch:{ NoSuchMethodException -> 0x0075 }
            r10.mSetter = r11     // Catch:{ NoSuchMethodException -> 0x0075 }
            r11.setAccessible(r6)     // Catch:{ NoSuchMethodException -> 0x0075 }
        L_0x0075:
            return
        L_0x0076:
            com.nineoldandroids.util.NoSuchPropertyException r11 = new com.nineoldandroids.util.NoSuchPropertyException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            r4.append(r13)
            r4.append(r2)
            r4.append(r1)
            r4.append(r12)
            r4.append(r0)
            java.lang.String r12 = r4.toString()
            r11.<init>(r12)
            throw r11
        L_0x0097:
            java.lang.reflect.Field r11 = r11.getField(r13)     // Catch:{ NoSuchFieldException -> 0x00c9 }
            r10.mField = r11     // Catch:{ NoSuchFieldException -> 0x00c9 }
            java.lang.Class r11 = r11.getType()     // Catch:{ NoSuchFieldException -> 0x00c9 }
            boolean r4 = r10.typesMatch(r12, r11)     // Catch:{ NoSuchFieldException -> 0x00c9 }
            if (r4 == 0) goto L_0x00a8
            return
        L_0x00a8:
            com.nineoldandroids.util.NoSuchPropertyException r4 = new com.nineoldandroids.util.NoSuchPropertyException     // Catch:{ NoSuchFieldException -> 0x00c9 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ NoSuchFieldException -> 0x00c9 }
            r5.<init>()     // Catch:{ NoSuchFieldException -> 0x00c9 }
            r5.append(r3)     // Catch:{ NoSuchFieldException -> 0x00c9 }
            r5.append(r11)     // Catch:{ NoSuchFieldException -> 0x00c9 }
            r5.append(r2)     // Catch:{ NoSuchFieldException -> 0x00c9 }
            r5.append(r1)     // Catch:{ NoSuchFieldException -> 0x00c9 }
            r5.append(r12)     // Catch:{ NoSuchFieldException -> 0x00c9 }
            r5.append(r0)     // Catch:{ NoSuchFieldException -> 0x00c9 }
            java.lang.String r11 = r5.toString()     // Catch:{ NoSuchFieldException -> 0x00c9 }
            r4.<init>(r11)     // Catch:{ NoSuchFieldException -> 0x00c9 }
            throw r4     // Catch:{ NoSuchFieldException -> 0x00c9 }
        L_0x00c9:
            com.nineoldandroids.util.NoSuchPropertyException r11 = new com.nineoldandroids.util.NoSuchPropertyException
            java.lang.String r12 = "No accessor method or field found for property with name "
            java.lang.String r12 = a.a.a.a.a.k(r12, r13)
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nineoldandroids.util.ReflectiveProperty.<init>(java.lang.Class, java.lang.Class, java.lang.String):void");
    }

    private boolean typesMatch(Class<V> cls, Class cls2) {
        if (cls2 == cls) {
            return true;
        }
        if (!cls2.isPrimitive()) {
            return false;
        }
        if (cls2 == Float.TYPE && cls == Float.class) {
            return true;
        }
        if (cls2 == Integer.TYPE && cls == Integer.class) {
            return true;
        }
        if (cls2 == Boolean.TYPE && cls == Boolean.class) {
            return true;
        }
        if (cls2 == Long.TYPE && cls == Long.class) {
            return true;
        }
        if (cls2 == Double.TYPE && cls == Double.class) {
            return true;
        }
        if (cls2 == Short.TYPE && cls == Short.class) {
            return true;
        }
        if (cls2 == Byte.TYPE && cls == Byte.class) {
            return true;
        }
        return cls2 == Character.TYPE && cls == Character.class;
    }

    public V get(T t) {
        Method method = this.mGetter;
        if (method != null) {
            try {
                return method.invoke(t, (Object[]) null);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        } else {
            Field field = this.mField;
            if (field != null) {
                try {
                    return field.get(t);
                } catch (IllegalAccessException unused2) {
                    throw new AssertionError();
                }
            } else {
                throw new AssertionError();
            }
        }
    }

    public boolean isReadOnly() {
        return this.mSetter == null && this.mField == null;
    }

    public void set(T t, V v) {
        Method method = this.mSetter;
        if (method != null) {
            try {
                method.invoke(t, new Object[]{v});
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        } else {
            Field field = this.mField;
            if (field != null) {
                try {
                    field.set(t, v);
                } catch (IllegalAccessException unused2) {
                    throw new AssertionError();
                }
            } else {
                StringBuilder n = a.n("Property ");
                n.append(getName());
                n.append(" is read-only");
                throw new UnsupportedOperationException(n.toString());
            }
        }
    }
}
