package com.nineoldandroids.animation;

import a.a.a.a.a;
import android.util.Log;
import com.nineoldandroids.util.FloatProperty;
import com.nineoldandroids.util.IntProperty;
import com.nineoldandroids.util.Property;
import com.nineoldandroids.util.ReflectiveProperty;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PropertyValuesHolder implements Cloneable {
    public static Class[] DOUBLE_VARIANTS;
    public static Class[] FLOAT_VARIANTS;
    public static Class[] INTEGER_VARIANTS;
    public static final TypeEvaluator sFloatEvaluator = new FloatEvaluator();
    public static final HashMap<Class, HashMap<String, Method>> sGetterPropertyMap = new HashMap<>();
    public static final TypeEvaluator sIntEvaluator = new IntEvaluator();
    public static final HashMap<Class, HashMap<String, Method>> sSetterPropertyMap = new HashMap<>();
    public Object mAnimatedValue;
    public TypeEvaluator mEvaluator;
    public Method mGetter;
    public KeyframeSet mKeyframeSet;
    public Property mProperty;
    public final ReentrantReadWriteLock mPropertyMapLock;
    public String mPropertyName;
    public Method mSetter;
    public final Object[] mTmpValueArray;
    public Class mValueType;

    public static class FloatPropertyValuesHolder extends PropertyValuesHolder {
        public float mFloatAnimatedValue;
        public FloatKeyframeSet mFloatKeyframeSet;
        public FloatProperty mFloatProperty;

        public FloatPropertyValuesHolder(Property property, FloatKeyframeSet floatKeyframeSet) {
            super(property);
            this.mValueType = Float.TYPE;
            this.mKeyframeSet = floatKeyframeSet;
            this.mFloatKeyframeSet = floatKeyframeSet;
            if (property instanceof FloatProperty) {
                this.mFloatProperty = (FloatProperty) this.mProperty;
            }
        }

        public FloatPropertyValuesHolder(Property property, float... fArr) {
            super(property);
            setFloatValues(fArr);
            if (property instanceof FloatProperty) {
                this.mFloatProperty = (FloatProperty) this.mProperty;
            }
        }

        public FloatPropertyValuesHolder(String str, FloatKeyframeSet floatKeyframeSet) {
            super(str);
            this.mValueType = Float.TYPE;
            this.mKeyframeSet = floatKeyframeSet;
            this.mFloatKeyframeSet = floatKeyframeSet;
        }

        public FloatPropertyValuesHolder(String str, float... fArr) {
            super(str);
            setFloatValues(fArr);
        }

        public void calculateValue(float f) {
            this.mFloatAnimatedValue = this.mFloatKeyframeSet.getFloatValue(f);
        }

        public FloatPropertyValuesHolder clone() {
            FloatPropertyValuesHolder floatPropertyValuesHolder = (FloatPropertyValuesHolder) PropertyValuesHolder.super.clone();
            floatPropertyValuesHolder.mFloatKeyframeSet = (FloatKeyframeSet) floatPropertyValuesHolder.mKeyframeSet;
            return floatPropertyValuesHolder;
        }

        public Object getAnimatedValue() {
            return Float.valueOf(this.mFloatAnimatedValue);
        }

        public void setAnimatedValue(Object obj) {
            String str;
            FloatProperty floatProperty = this.mFloatProperty;
            if (floatProperty != null) {
                floatProperty.setValue(obj, this.mFloatAnimatedValue);
                return;
            }
            Property property = this.mProperty;
            if (property != null) {
                property.set(obj, Float.valueOf(this.mFloatAnimatedValue));
                return;
            } else if (this.mSetter != null) {
                try {
                    this.mTmpValueArray[0] = Float.valueOf(this.mFloatAnimatedValue);
                    this.mSetter.invoke(obj, this.mTmpValueArray);
                    return;
                } catch (InvocationTargetException e2) {
                    str = e2.toString();
                } catch (IllegalAccessException e3) {
                    str = e3.toString();
                }
            } else {
                return;
            }
            Log.e("PropertyValuesHolder", str);
        }

        public void setFloatValues(float... fArr) {
            PropertyValuesHolder.super.setFloatValues(fArr);
            this.mFloatKeyframeSet = (FloatKeyframeSet) this.mKeyframeSet;
        }

        public void setupSetter(Class cls) {
            if (this.mProperty == null) {
                PropertyValuesHolder.super.setupSetter(cls);
            }
        }
    }

    public static class IntPropertyValuesHolder extends PropertyValuesHolder {
        public int mIntAnimatedValue;
        public IntKeyframeSet mIntKeyframeSet;
        public IntProperty mIntProperty;

        public IntPropertyValuesHolder(Property property, IntKeyframeSet intKeyframeSet) {
            super(property);
            this.mValueType = Integer.TYPE;
            this.mKeyframeSet = intKeyframeSet;
            this.mIntKeyframeSet = intKeyframeSet;
            if (property instanceof IntProperty) {
                this.mIntProperty = (IntProperty) this.mProperty;
            }
        }

        public IntPropertyValuesHolder(Property property, int... iArr) {
            super(property);
            setIntValues(iArr);
            if (property instanceof IntProperty) {
                this.mIntProperty = (IntProperty) this.mProperty;
            }
        }

        public IntPropertyValuesHolder(String str, IntKeyframeSet intKeyframeSet) {
            super(str);
            this.mValueType = Integer.TYPE;
            this.mKeyframeSet = intKeyframeSet;
            this.mIntKeyframeSet = intKeyframeSet;
        }

        public IntPropertyValuesHolder(String str, int... iArr) {
            super(str);
            setIntValues(iArr);
        }

        public void calculateValue(float f) {
            this.mIntAnimatedValue = this.mIntKeyframeSet.getIntValue(f);
        }

        public IntPropertyValuesHolder clone() {
            IntPropertyValuesHolder intPropertyValuesHolder = (IntPropertyValuesHolder) PropertyValuesHolder.super.clone();
            intPropertyValuesHolder.mIntKeyframeSet = (IntKeyframeSet) intPropertyValuesHolder.mKeyframeSet;
            return intPropertyValuesHolder;
        }

        public Object getAnimatedValue() {
            return Integer.valueOf(this.mIntAnimatedValue);
        }

        public void setAnimatedValue(Object obj) {
            String str;
            IntProperty intProperty = this.mIntProperty;
            if (intProperty != null) {
                intProperty.setValue(obj, this.mIntAnimatedValue);
                return;
            }
            Property property = this.mProperty;
            if (property != null) {
                property.set(obj, Integer.valueOf(this.mIntAnimatedValue));
                return;
            } else if (this.mSetter != null) {
                try {
                    this.mTmpValueArray[0] = Integer.valueOf(this.mIntAnimatedValue);
                    this.mSetter.invoke(obj, this.mTmpValueArray);
                    return;
                } catch (InvocationTargetException e2) {
                    str = e2.toString();
                } catch (IllegalAccessException e3) {
                    str = e3.toString();
                }
            } else {
                return;
            }
            Log.e("PropertyValuesHolder", str);
        }

        public void setIntValues(int... iArr) {
            PropertyValuesHolder.super.setIntValues(iArr);
            this.mIntKeyframeSet = (IntKeyframeSet) this.mKeyframeSet;
        }

        public void setupSetter(Class cls) {
            if (this.mProperty == null) {
                PropertyValuesHolder.super.setupSetter(cls);
            }
        }
    }

    static {
        Class<Integer> cls = Integer.class;
        Class<Double> cls2 = Double.class;
        Class<Float> cls3 = Float.class;
        Class cls4 = Integer.TYPE;
        FLOAT_VARIANTS = new Class[]{Float.TYPE, cls3, Double.TYPE, cls4, cls2, cls};
        Class cls5 = Double.TYPE;
        INTEGER_VARIANTS = new Class[]{cls4, cls, Float.TYPE, cls5, cls3, cls2};
        DOUBLE_VARIANTS = new Class[]{cls5, cls2, Float.TYPE, Integer.TYPE, cls3, cls};
    }

    public PropertyValuesHolder(Property property) {
        this.mSetter = null;
        this.mGetter = null;
        this.mKeyframeSet = null;
        this.mPropertyMapLock = new ReentrantReadWriteLock();
        this.mTmpValueArray = new Object[1];
        this.mProperty = property;
        if (property != null) {
            this.mPropertyName = property.getName();
        }
    }

    public PropertyValuesHolder(String str) {
        this.mSetter = null;
        this.mGetter = null;
        this.mKeyframeSet = null;
        this.mPropertyMapLock = new ReentrantReadWriteLock();
        this.mTmpValueArray = new Object[1];
        this.mPropertyName = str;
    }

    public static String getMethodName(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        char upperCase = Character.toUpperCase(str2.charAt(0));
        String substring = str2.substring(1);
        return str + upperCase + substring;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006e, code lost:
        return r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x006f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.reflect.Method getPropertyFunction(java.lang.Class r9, java.lang.String r10, java.lang.Class r11) {
        /*
            r8 = this;
            java.lang.String r0 = r8.mPropertyName
            java.lang.String r10 = getMethodName(r10, r0)
            java.lang.String r0 = "PropertyValuesHolder"
            r1 = 0
            r2 = 1
            if (r11 != 0) goto L_0x0030
            java.lang.reflect.Method r9 = r9.getMethod(r10, r1)     // Catch:{ NoSuchMethodException -> 0x0012 }
            goto L_0x0099
        L_0x0012:
            r11 = move-exception
            java.lang.reflect.Method r1 = r9.getDeclaredMethod(r10, r1)     // Catch:{ NoSuchMethodException -> 0x001c }
            r1.setAccessible(r2)     // Catch:{ NoSuchMethodException -> 0x001c }
            goto L_0x0098
        L_0x001c:
            java.lang.String r9 = "Couldn't find no-arg method for property "
            java.lang.StringBuilder r9 = a.a.a.a.a.n(r9)
            java.lang.String r10 = r8.mPropertyName
            r9.append(r10)
            java.lang.String r10 = ": "
            r9.append(r10)
            r9.append(r11)
            goto L_0x0091
        L_0x0030:
            java.lang.Class[] r11 = new java.lang.Class[r2]
            java.lang.Class r3 = r8.mValueType
            java.lang.Class<java.lang.Float> r4 = java.lang.Float.class
            boolean r3 = r3.equals(r4)
            r4 = 0
            if (r3 == 0) goto L_0x0040
            java.lang.Class[] r3 = FLOAT_VARIANTS
            goto L_0x0060
        L_0x0040:
            java.lang.Class r3 = r8.mValueType
            java.lang.Class<java.lang.Integer> r5 = java.lang.Integer.class
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x004d
            java.lang.Class[] r3 = INTEGER_VARIANTS
            goto L_0x0060
        L_0x004d:
            java.lang.Class r3 = r8.mValueType
            java.lang.Class<java.lang.Double> r5 = java.lang.Double.class
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x005a
            java.lang.Class[] r3 = DOUBLE_VARIANTS
            goto L_0x0060
        L_0x005a:
            java.lang.Class[] r3 = new java.lang.Class[r2]
            java.lang.Class r5 = r8.mValueType
            r3[r4] = r5
        L_0x0060:
            int r5 = r3.length
            r6 = 0
        L_0x0062:
            if (r6 >= r5) goto L_0x007c
            r7 = r3[r6]
            r11[r4] = r7
            java.lang.reflect.Method r1 = r9.getMethod(r10, r11)     // Catch:{ NoSuchMethodException -> 0x006f }
            r8.mValueType = r7     // Catch:{ NoSuchMethodException -> 0x006f }
            return r1
        L_0x006f:
            java.lang.reflect.Method r1 = r9.getDeclaredMethod(r10, r11)     // Catch:{ NoSuchMethodException -> 0x0079 }
            r1.setAccessible(r2)     // Catch:{ NoSuchMethodException -> 0x0079 }
            r8.mValueType = r7     // Catch:{ NoSuchMethodException -> 0x0079 }
            return r1
        L_0x0079:
            int r6 = r6 + 1
            goto L_0x0062
        L_0x007c:
            java.lang.String r9 = "Couldn't find setter/getter for property "
            java.lang.StringBuilder r9 = a.a.a.a.a.n(r9)
            java.lang.String r10 = r8.mPropertyName
            r9.append(r10)
            java.lang.String r10 = " with value type "
            r9.append(r10)
            java.lang.Class r10 = r8.mValueType
            r9.append(r10)
        L_0x0091:
            java.lang.String r9 = r9.toString()
            android.util.Log.e(r0, r9)
        L_0x0098:
            r9 = r1
        L_0x0099:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nineoldandroids.animation.PropertyValuesHolder.getPropertyFunction(java.lang.Class, java.lang.String, java.lang.Class):java.lang.reflect.Method");
    }

    public static PropertyValuesHolder ofFloat(Property<?, Float> property, float... fArr) {
        return new FloatPropertyValuesHolder((Property) property, fArr);
    }

    public static PropertyValuesHolder ofFloat(String str, float... fArr) {
        return new FloatPropertyValuesHolder(str, fArr);
    }

    public static PropertyValuesHolder ofInt(Property<?, Integer> property, int... iArr) {
        return new IntPropertyValuesHolder((Property) property, iArr);
    }

    public static PropertyValuesHolder ofInt(String str, int... iArr) {
        return new IntPropertyValuesHolder(str, iArr);
    }

    public static PropertyValuesHolder ofKeyframe(Property property, Keyframe... keyframeArr) {
        KeyframeSet ofKeyframe = KeyframeSet.ofKeyframe(keyframeArr);
        if (ofKeyframe instanceof IntKeyframeSet) {
            return new IntPropertyValuesHolder(property, (IntKeyframeSet) ofKeyframe);
        }
        if (ofKeyframe instanceof FloatKeyframeSet) {
            return new FloatPropertyValuesHolder(property, (FloatKeyframeSet) ofKeyframe);
        }
        PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(property);
        propertyValuesHolder.mKeyframeSet = ofKeyframe;
        propertyValuesHolder.mValueType = keyframeArr[0].getType();
        return propertyValuesHolder;
    }

    public static PropertyValuesHolder ofKeyframe(String str, Keyframe... keyframeArr) {
        KeyframeSet ofKeyframe = KeyframeSet.ofKeyframe(keyframeArr);
        if (ofKeyframe instanceof IntKeyframeSet) {
            return new IntPropertyValuesHolder(str, (IntKeyframeSet) ofKeyframe);
        }
        if (ofKeyframe instanceof FloatKeyframeSet) {
            return new FloatPropertyValuesHolder(str, (FloatKeyframeSet) ofKeyframe);
        }
        PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(str);
        propertyValuesHolder.mKeyframeSet = ofKeyframe;
        propertyValuesHolder.mValueType = keyframeArr[0].getType();
        return propertyValuesHolder;
    }

    public static <V> PropertyValuesHolder ofObject(Property property, TypeEvaluator<V> typeEvaluator, V... vArr) {
        PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(property);
        propertyValuesHolder.setObjectValues(vArr);
        propertyValuesHolder.setEvaluator(typeEvaluator);
        return propertyValuesHolder;
    }

    public static PropertyValuesHolder ofObject(String str, TypeEvaluator typeEvaluator, Object... objArr) {
        PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(str);
        propertyValuesHolder.setObjectValues(objArr);
        propertyValuesHolder.setEvaluator(typeEvaluator);
        return propertyValuesHolder;
    }

    private void setupGetter(Class cls) {
        this.mGetter = setupSetterOrGetter(cls, sGetterPropertyMap, ReflectiveProperty.PREFIX_GET, (Class) null);
    }

    private Method setupSetterOrGetter(Class cls, HashMap<Class, HashMap<String, Method>> hashMap, String str, Class cls2) {
        try {
            this.mPropertyMapLock.writeLock().lock();
            HashMap hashMap2 = hashMap.get(cls);
            Method method = hashMap2 != null ? (Method) hashMap2.get(this.mPropertyName) : null;
            if (method == null) {
                method = getPropertyFunction(cls, str, cls2);
                if (hashMap2 == null) {
                    hashMap2 = new HashMap();
                    hashMap.put(cls, hashMap2);
                }
                hashMap2.put(this.mPropertyName, method);
            }
            return method;
        } finally {
            this.mPropertyMapLock.writeLock().unlock();
        }
    }

    private void setupValue(Object obj, Keyframe keyframe) {
        String str;
        Property property = this.mProperty;
        if (property != null) {
            keyframe.setValue(property.get(obj));
        }
        try {
            if (this.mGetter == null) {
                setupGetter(obj.getClass());
            }
            keyframe.setValue(this.mGetter.invoke(obj, new Object[0]));
        } catch (InvocationTargetException e2) {
            str = e2.toString();
            Log.e("PropertyValuesHolder", str);
        } catch (IllegalAccessException e3) {
            str = e3.toString();
            Log.e("PropertyValuesHolder", str);
        }
    }

    public void calculateValue(float f) {
        this.mAnimatedValue = this.mKeyframeSet.getValue(f);
    }

    public PropertyValuesHolder clone() {
        try {
            PropertyValuesHolder propertyValuesHolder = (PropertyValuesHolder) super.clone();
            propertyValuesHolder.mPropertyName = this.mPropertyName;
            propertyValuesHolder.mProperty = this.mProperty;
            propertyValuesHolder.mKeyframeSet = this.mKeyframeSet.clone();
            propertyValuesHolder.mEvaluator = this.mEvaluator;
            return propertyValuesHolder;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Object getAnimatedValue() {
        return this.mAnimatedValue;
    }

    public String getPropertyName() {
        return this.mPropertyName;
    }

    public void init() {
        if (this.mEvaluator == null) {
            Class<Float> cls = this.mValueType;
            this.mEvaluator = cls == Integer.class ? sIntEvaluator : cls == Float.class ? sFloatEvaluator : null;
        }
        TypeEvaluator typeEvaluator = this.mEvaluator;
        if (typeEvaluator != null) {
            this.mKeyframeSet.setEvaluator(typeEvaluator);
        }
    }

    public void setAnimatedValue(Object obj) {
        String str;
        Property property = this.mProperty;
        if (property != null) {
            property.set(obj, getAnimatedValue());
        }
        if (this.mSetter != null) {
            try {
                this.mTmpValueArray[0] = getAnimatedValue();
                this.mSetter.invoke(obj, this.mTmpValueArray);
                return;
            } catch (InvocationTargetException e2) {
                str = e2.toString();
            } catch (IllegalAccessException e3) {
                str = e3.toString();
            }
        } else {
            return;
        }
        Log.e("PropertyValuesHolder", str);
    }

    public void setEvaluator(TypeEvaluator typeEvaluator) {
        this.mEvaluator = typeEvaluator;
        this.mKeyframeSet.setEvaluator(typeEvaluator);
    }

    public void setFloatValues(float... fArr) {
        this.mValueType = Float.TYPE;
        this.mKeyframeSet = KeyframeSet.ofFloat(fArr);
    }

    public void setIntValues(int... iArr) {
        this.mValueType = Integer.TYPE;
        this.mKeyframeSet = KeyframeSet.ofInt(iArr);
    }

    public void setKeyframes(Keyframe... keyframeArr) {
        int length = keyframeArr.length;
        Keyframe[] keyframeArr2 = new Keyframe[Math.max(length, 2)];
        this.mValueType = keyframeArr[0].getType();
        for (int i = 0; i < length; i++) {
            keyframeArr2[i] = keyframeArr[i];
        }
        this.mKeyframeSet = new KeyframeSet(keyframeArr2);
    }

    public void setObjectValues(Object... objArr) {
        this.mValueType = objArr[0].getClass();
        this.mKeyframeSet = KeyframeSet.ofObject(objArr);
    }

    public void setProperty(Property property) {
        this.mProperty = property;
    }

    public void setPropertyName(String str) {
        this.mPropertyName = str;
    }

    public void setupEndValue(Object obj) {
        ArrayList<Keyframe> arrayList = this.mKeyframeSet.mKeyframes;
        setupValue(obj, arrayList.get(arrayList.size() - 1));
    }

    public void setupSetter(Class cls) {
        this.mSetter = setupSetterOrGetter(cls, sSetterPropertyMap, ReflectiveProperty.PREFIX_SET, this.mValueType);
    }

    public void setupSetterAndGetter(Object obj) {
        String str;
        Property property = this.mProperty;
        if (property != null) {
            try {
                property.get(obj);
                Iterator<Keyframe> it = this.mKeyframeSet.mKeyframes.iterator();
                while (it.hasNext()) {
                    Keyframe next = it.next();
                    if (!next.hasValue()) {
                        next.setValue(this.mProperty.get(obj));
                    }
                }
                return;
            } catch (ClassCastException unused) {
                StringBuilder n = a.n("No such property (");
                n.append(this.mProperty.getName());
                n.append(") on target object ");
                n.append(obj);
                n.append(". Trying reflection instead");
                Log.e("PropertyValuesHolder", n.toString());
                this.mProperty = null;
            }
        }
        Class<?> cls = obj.getClass();
        if (this.mSetter == null) {
            setupSetter(cls);
        }
        Iterator<Keyframe> it2 = this.mKeyframeSet.mKeyframes.iterator();
        while (it2.hasNext()) {
            Keyframe next2 = it2.next();
            if (!next2.hasValue()) {
                if (this.mGetter == null) {
                    setupGetter(cls);
                }
                try {
                    next2.setValue(this.mGetter.invoke(obj, new Object[0]));
                } catch (InvocationTargetException e2) {
                    str = e2.toString();
                } catch (IllegalAccessException e3) {
                    str = e3.toString();
                }
            }
        }
        return;
        Log.e("PropertyValuesHolder", str);
    }

    public void setupStartValue(Object obj) {
        setupValue(obj, this.mKeyframeSet.mKeyframes.get(0));
    }

    public String toString() {
        return this.mPropertyName + ": " + this.mKeyframeSet.toString();
    }
}
