package a.d.a.a.h.g;

public enum s5 {
    DOUBLE(0, r4, k6.DOUBLE),
    FLOAT(1, r4, k6.FLOAT),
    INT64(2, r4, k6.LONG),
    UINT64(3, r4, k6.LONG),
    INT32(4, r4, k6.INT),
    FIXED64(5, r4, k6.LONG),
    FIXED32(6, r4, k6.INT),
    BOOL(7, r4, k6.BOOLEAN),
    STRING(8, r4, k6.STRING),
    MESSAGE(9, r4, k6.MESSAGE),
    BYTES(10, r4, k6.BYTE_STRING),
    UINT32(11, r4, k6.INT),
    ENUM(12, r4, k6.ENUM),
    SFIXED32(13, r4, k6.INT),
    SFIXED64(14, r4, k6.LONG),
    SINT32(15, r4, k6.INT),
    SINT64(16, r4, k6.LONG),
    GROUP(17, r4, k6.MESSAGE),
    DOUBLE_LIST(18, r4, k6.DOUBLE),
    FLOAT_LIST(19, r4, k6.FLOAT),
    INT64_LIST(20, r4, k6.LONG),
    UINT64_LIST(21, r4, k6.LONG),
    INT32_LIST(22, r4, k6.INT),
    FIXED64_LIST(23, r4, k6.LONG),
    FIXED32_LIST(24, r4, k6.INT),
    BOOL_LIST(25, r4, k6.BOOLEAN),
    STRING_LIST(26, r4, k6.STRING),
    MESSAGE_LIST(27, r4, k6.MESSAGE),
    BYTES_LIST(28, r4, k6.BYTE_STRING),
    UINT32_LIST(29, r4, k6.INT),
    ENUM_LIST(30, r4, k6.ENUM),
    SFIXED32_LIST(31, r4, k6.INT),
    SFIXED64_LIST(32, r4, k6.LONG),
    SINT32_LIST(33, r4, k6.INT),
    SINT64_LIST(34, r4, k6.LONG),
    DOUBLE_LIST_PACKED(35, r4, k6.DOUBLE),
    FLOAT_LIST_PACKED(36, r4, k6.FLOAT),
    INT64_LIST_PACKED(37, r4, k6.LONG),
    UINT64_LIST_PACKED(38, r4, k6.LONG),
    INT32_LIST_PACKED(39, r4, k6.INT),
    FIXED64_LIST_PACKED(40, r4, k6.LONG),
    FIXED32_LIST_PACKED(41, r4, k6.INT),
    BOOL_LIST_PACKED(42, r4, k6.BOOLEAN),
    UINT32_LIST_PACKED(43, r4, k6.INT),
    ENUM_LIST_PACKED(44, r4, k6.ENUM),
    SFIXED32_LIST_PACKED(45, r4, k6.INT),
    SFIXED64_LIST_PACKED(46, r4, k6.LONG),
    SINT32_LIST_PACKED(47, r4, k6.INT),
    SINT64_LIST_PACKED(48, r4, k6.LONG),
    GROUP_LIST(49, r7, k6.MESSAGE),
    MAP(50, u5.MAP, k6.VOID);
    
    public static final s5[] a0 = null;

    /* renamed from: a  reason: collision with root package name */
    public final int f1933a;

    /* access modifiers changed from: public */
    static {
        int i;
        s5[] values = values();
        a0 = new s5[values.length];
        for (s5 s5Var : values) {
            a0[s5Var.f1933a] = s5Var;
        }
    }

    /* access modifiers changed from: public */
    s5(int i, u5 u5Var, k6 k6Var) {
        this.f1933a = i;
        int i2 = v5.f1985a[u5Var.ordinal()];
        if (i2 == 1 || i2 == 2) {
            Class<?> cls = k6Var.f1774a;
        }
        if (u5Var == u5.SCALAR) {
            int i3 = v5.f1986b[k6Var.ordinal()];
        }
    }
}
