package com.nineoldandroids.view;

import android.view.View;
import com.nineoldandroids.view.animation.AnimatorProxy;

public final class ViewHelper {

    public static final class Honeycomb {
        public static float getAlpha(View view) {
            return view.getAlpha();
        }

        public static float getPivotX(View view) {
            return view.getPivotX();
        }

        public static float getPivotY(View view) {
            return view.getPivotY();
        }

        public static float getRotation(View view) {
            return view.getRotation();
        }

        public static float getRotationX(View view) {
            return view.getRotationX();
        }

        public static float getRotationY(View view) {
            return view.getRotationY();
        }

        public static float getScaleX(View view) {
            return view.getScaleX();
        }

        public static float getScaleY(View view) {
            return view.getScaleY();
        }

        public static float getScrollX(View view) {
            return (float) view.getScrollX();
        }

        public static float getScrollY(View view) {
            return (float) view.getScrollY();
        }

        public static float getTranslationX(View view) {
            return view.getTranslationX();
        }

        public static float getTranslationY(View view) {
            return view.getTranslationY();
        }

        public static float getX(View view) {
            return view.getX();
        }

        public static float getY(View view) {
            return view.getY();
        }

        public static void setAlpha(View view, float f) {
            view.setAlpha(f);
        }

        public static void setPivotX(View view, float f) {
            view.setPivotX(f);
        }

        public static void setPivotY(View view, float f) {
            view.setPivotY(f);
        }

        public static void setRotation(View view, float f) {
            view.setRotation(f);
        }

        public static void setRotationX(View view, float f) {
            view.setRotationX(f);
        }

        public static void setRotationY(View view, float f) {
            view.setRotationY(f);
        }

        public static void setScaleX(View view, float f) {
            view.setScaleX(f);
        }

        public static void setScaleY(View view, float f) {
            view.setScaleY(f);
        }

        public static void setScrollX(View view, int i) {
            view.setScrollX(i);
        }

        public static void setScrollY(View view, int i) {
            view.setScrollY(i);
        }

        public static void setTranslationX(View view, float f) {
            view.setTranslationX(f);
        }

        public static void setTranslationY(View view, float f) {
            view.setTranslationY(f);
        }

        public static void setX(View view, float f) {
            view.setX(f);
        }

        public static void setY(View view, float f) {
            view.setY(f);
        }
    }

    public static float getAlpha(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getAlpha() : Honeycomb.getAlpha(view);
    }

    public static float getPivotX(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getPivotX() : Honeycomb.getPivotX(view);
    }

    public static float getPivotY(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getPivotY() : Honeycomb.getPivotY(view);
    }

    public static float getRotation(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getRotation() : Honeycomb.getRotation(view);
    }

    public static float getRotationX(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getRotationX() : Honeycomb.getRotationX(view);
    }

    public static float getRotationY(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getRotationY() : Honeycomb.getRotationY(view);
    }

    public static float getScaleX(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getScaleX() : Honeycomb.getScaleX(view);
    }

    public static float getScaleY(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getScaleY() : Honeycomb.getScaleY(view);
    }

    public static float getScrollX(View view) {
        return AnimatorProxy.NEEDS_PROXY ? (float) AnimatorProxy.wrap(view).getScrollX() : Honeycomb.getScrollX(view);
    }

    public static float getScrollY(View view) {
        return AnimatorProxy.NEEDS_PROXY ? (float) AnimatorProxy.wrap(view).getScrollY() : Honeycomb.getScrollY(view);
    }

    public static float getTranslationX(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getTranslationX() : Honeycomb.getTranslationX(view);
    }

    public static float getTranslationY(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getTranslationY() : Honeycomb.getTranslationY(view);
    }

    public static float getX(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getX() : Honeycomb.getX(view);
    }

    public static float getY(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getY() : Honeycomb.getY(view);
    }

    public static void setAlpha(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setAlpha(f);
        } else {
            Honeycomb.setAlpha(view, f);
        }
    }

    public static void setPivotX(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setPivotX(f);
        } else {
            Honeycomb.setPivotX(view, f);
        }
    }

    public static void setPivotY(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setPivotY(f);
        } else {
            Honeycomb.setPivotY(view, f);
        }
    }

    public static void setRotation(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setRotation(f);
        } else {
            Honeycomb.setRotation(view, f);
        }
    }

    public static void setRotationX(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setRotationX(f);
        } else {
            Honeycomb.setRotationX(view, f);
        }
    }

    public static void setRotationY(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setRotationY(f);
        } else {
            Honeycomb.setRotationY(view, f);
        }
    }

    public static void setScaleX(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScaleX(f);
        } else {
            Honeycomb.setScaleX(view, f);
        }
    }

    public static void setScaleY(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScaleY(f);
        } else {
            Honeycomb.setScaleY(view, f);
        }
    }

    public static void setScrollX(View view, int i) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScrollX(i);
        } else {
            Honeycomb.setScrollX(view, i);
        }
    }

    public static void setScrollY(View view, int i) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScrollY(i);
        } else {
            Honeycomb.setScrollY(view, i);
        }
    }

    public static void setTranslationX(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setTranslationX(f);
        } else {
            Honeycomb.setTranslationX(view, f);
        }
    }

    public static void setTranslationY(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setTranslationY(f);
        } else {
            Honeycomb.setTranslationY(view, f);
        }
    }

    public static void setX(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setX(f);
        } else {
            Honeycomb.setX(view, f);
        }
    }

    public static void setY(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setY(f);
        } else {
            Honeycomb.setY(view, f);
        }
    }
}
