package a.c.d.r.k;

import a.c.d.m.e.k.d;
import a.c.d.m.e.k.e;
import android.content.Context;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.cuatroochenta.miniland.pregnancy.baby.MyPregnancyFragmentContainerActivity;
import com.sozpic.miniland.R;
import java.util.ArrayList;
import java.util.List;

public abstract class f<ItemType> extends a<ItemType> {

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f814d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public Context f815e;
    public boolean f = false;
    public a g;
    public b h;
    public SparseArray<View> i = new SparseArray<>();
    public int j = -1;

    public interface a {
    }

    public interface b {
    }

    public static void e(f fVar) {
        fVar.f = true;
        a aVar = fVar.g;
        if (aVar != null) {
            d dVar = (d) aVar;
            if (dVar.f367a.getActivity() instanceof MyPregnancyFragmentContainerActivity) {
                ((MyPregnancyFragmentContainerActivity) dVar.f367a.getActivity()).q();
            }
        }
    }

    public final void f() {
        this.f = false;
        b bVar = this.h;
        if (bVar != null) {
            e eVar = (e) bVar;
            if (eVar.f368a.getActivity() instanceof MyPregnancyFragmentContainerActivity) {
                ((MyPregnancyFragmentContainerActivity) eVar.f368a.getActivity()).r();
            }
        }
    }

    public ItemType g() {
        int i2 = this.j;
        if (i2 == -1) {
            return null;
        }
        return getItem(i2);
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        this.f815e = viewGroup.getContext();
        if (view != null) {
            super.getView(i2, ((FrameLayout) view).getChildAt(0), viewGroup);
            view.setOnLongClickListener(new c(this, i2));
            this.i.put(i2, view);
            if (this.j == i2) {
                i(i2);
            } else {
                h(i2);
            }
            return view;
        }
        View view2 = super.getView(i2, (View) null, viewGroup);
        FrameLayout frameLayout = new FrameLayout(this.f815e);
        frameLayout.addView(view2);
        TypedValue typedValue = new TypedValue();
        this.f815e.getTheme().resolveAttribute(R.attr.selectableItemBackground, typedValue, true);
        frameLayout.setBackgroundResource(typedValue.resourceId);
        frameLayout.setOnLongClickListener(new d(this, i2));
        frameLayout.setOnClickListener(new e(this));
        this.i.put(i2, frameLayout);
        if (this.j == i2) {
            i(i2);
        } else {
            h(i2);
        }
        return frameLayout;
    }

    public final void h(int i2) {
        View view = this.i.get(i2);
        if (view != null) {
            TypedValue typedValue = new TypedValue();
            this.f815e.getTheme().resolveAttribute(R.attr.selectableItemBackground, typedValue, true);
            view.setBackgroundResource(typedValue.resourceId);
        }
    }

    public final void i(int i2) {
        if (this.f) {
            int i3 = this.j;
            if (i3 != -1) {
                h(i3);
            }
            this.j = i2;
            this.f814d.add(Integer.valueOf(i2));
            View view = this.i.get(i2);
            if (view != null) {
                view.setBackgroundColor(-3223086);
            }
        }
    }
}
