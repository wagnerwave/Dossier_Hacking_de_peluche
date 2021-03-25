package a.c.d.r.k;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.annotation.IdRes;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public abstract class a<ItemType> extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<ItemType> f803a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    public boolean f804b;

    /* renamed from: c  reason: collision with root package name */
    public Comparator<ItemType> f805c;

    /* renamed from: a.c.d.r.k.a$a  reason: collision with other inner class name */
    public static class C0042a {

        /* renamed from: a  reason: collision with root package name */
        public final View f806a;

        /* renamed from: b  reason: collision with root package name */
        public SparseArray<View> f807b = new SparseArray<>();

        public C0042a(View view) {
            this.f806a = view;
        }

        public void a(@IdRes int i) {
            this.f807b.put(i, this.f806a.findViewById(i));
        }

        public Context b() {
            return this.f806a.getContext();
        }

        public View c(@IdRes int i) {
            return this.f807b.get(i);
        }
    }

    public abstract void a(C0042a aVar);

    public abstract void b(int i, ItemType itemtype, C0042a aVar);

    public abstract long c(int i, ItemType itemtype);

    public abstract View d(Context context, ViewGroup viewGroup);

    public int getCount() {
        return this.f803a.size();
    }

    public ItemType getItem(int i) {
        return this.f803a.get(i);
    }

    public long getItemId(int i) {
        return c(i, this.f803a.get(i));
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = d(viewGroup.getContext(), viewGroup);
            C0042a aVar = new C0042a(view);
            a(aVar);
            view.setTag(aVar);
        }
        b(i, this.f803a.get(i), (C0042a) view.getTag());
        return view;
    }

    public void notifyDataSetChanged() {
        if (this.f804b) {
            Collections.sort(this.f803a, this.f805c);
        }
        super.notifyDataSetChanged();
    }
}
