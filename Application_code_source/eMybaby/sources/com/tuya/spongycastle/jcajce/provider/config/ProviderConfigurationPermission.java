package com.tuya.spongycastle.jcajce.provider.config;

import com.tuya.spongycastle.util.Strings;
import java.security.BasicPermission;
import java.security.Permission;
import java.util.StringTokenizer;

public class ProviderConfigurationPermission extends BasicPermission {
    public static final int ACCEPTABLE_EC_CURVES = 16;
    public static final String ACCEPTABLE_EC_CURVES_STR = "acceptableeccurves";
    public static final int ADDITIONAL_EC_PARAMETERS = 32;
    public static final String ADDITIONAL_EC_PARAMETERS_STR = "additionalecparameters";
    public static final int ALL = 63;
    public static final String ALL_STR = "all";
    public static final int DH_DEFAULT_PARAMS = 8;
    public static final String DH_DEFAULT_PARAMS_STR = "dhdefaultparams";
    public static final int EC_IMPLICITLY_CA = 2;
    public static final String EC_IMPLICITLY_CA_STR = "ecimplicitlyca";
    public static final int THREAD_LOCAL_DH_DEFAULT_PARAMS = 4;
    public static final String THREAD_LOCAL_DH_DEFAULT_PARAMS_STR = "threadlocaldhdefaultparams";
    public static final int THREAD_LOCAL_EC_IMPLICITLY_CA = 1;
    public static final String THREAD_LOCAL_EC_IMPLICITLY_CA_STR = "threadlocalecimplicitlyca";
    public final String actions;
    public final int permissionMask;

    public ProviderConfigurationPermission(String str) {
        super(str);
        this.actions = ALL_STR;
        this.permissionMask = 63;
    }

    public ProviderConfigurationPermission(String str, String str2) {
        super(str, str2);
        this.actions = str2;
        this.permissionMask = calculateMask(str2);
    }

    private int calculateMask(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(Strings.toLowerCase(str), " ,");
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (nextToken.equals(THREAD_LOCAL_EC_IMPLICITLY_CA_STR)) {
                i |= 1;
            } else if (nextToken.equals(EC_IMPLICITLY_CA_STR)) {
                i |= 2;
            } else if (nextToken.equals(THREAD_LOCAL_DH_DEFAULT_PARAMS_STR)) {
                i |= 4;
            } else if (nextToken.equals(DH_DEFAULT_PARAMS_STR)) {
                i |= 8;
            } else if (nextToken.equals(ACCEPTABLE_EC_CURVES_STR)) {
                i |= 16;
            } else if (nextToken.equals(ADDITIONAL_EC_PARAMETERS_STR)) {
                i |= 32;
            } else if (nextToken.equals(ALL_STR)) {
                i |= 63;
            }
        }
        if (i != 0) {
            return i;
        }
        throw new IllegalArgumentException("unknown permissions passed to mask");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProviderConfigurationPermission)) {
            return false;
        }
        ProviderConfigurationPermission providerConfigurationPermission = (ProviderConfigurationPermission) obj;
        return this.permissionMask == providerConfigurationPermission.permissionMask && getName().equals(providerConfigurationPermission.getName());
    }

    public String getActions() {
        return this.actions;
    }

    public int hashCode() {
        return getName().hashCode() + this.permissionMask;
    }

    public boolean implies(Permission permission) {
        if (!(permission instanceof ProviderConfigurationPermission) || !getName().equals(permission.getName())) {
            return false;
        }
        int i = this.permissionMask;
        int i2 = ((ProviderConfigurationPermission) permission).permissionMask;
        return (i & i2) == i2;
    }
}
