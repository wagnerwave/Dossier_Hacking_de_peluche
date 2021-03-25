package a.c.d.r.k;

import a.c.d.m.f.n;
import a.c.d.r.k.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.cuatroochenta.miniland.model.BabyDiaryEntry;
import com.sozpic.miniland.R;
import java.util.Collections;
import java.util.Comparator;

public abstract class b<ItemType> extends a<ItemType> {

    public class a implements Comparator<ItemType> {
        public a() {
        }

        public int compare(ItemType itemtype, ItemType itemtype2) {
            if (((n) b.this) != null) {
                return ((BabyDiaryEntry) itemtype2).getDate().compareTo(((BabyDiaryEntry) itemtype).getDate());
            }
            throw null;
        }
    }

    public abstract void e(int i, ItemType itemtype, ItemType itemtype2, a.C0042a aVar);

    public final void f() {
        Collections.sort(this.f803a, new a());
    }

    public int getItemViewType(int i) {
        ItemType itemtype = null;
        Object item = i > 0 ? getItem(i - 1) : null;
        if (i < getCount()) {
            itemtype = this.f803a.get(i);
        }
        BabyDiaryEntry babyDiaryEntry = (BabyDiaryEntry) item;
        return babyDiaryEntry == null || babyDiaryEntry.getWeek() != ((BabyDiaryEntry) itemtype).getWeek() ? 0 : 1;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (getItemViewType(i) != 0) {
            return super.getView(i, view, viewGroup);
        }
        Object obj = null;
        if (view == null) {
            View view2 = super.getView(i, (View) null, viewGroup);
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_baby_diary_entry_header, viewGroup, false);
            a.C0042a aVar = new a.C0042a(inflate);
            aVar.a(R.id.baby_diary_entry_header_text_label_semana);
            aVar.a(R.id.baby_diary_entry_header_text_semana);
            inflate.setTag(aVar);
            if (i != 0) {
                obj = getItem(i - 1);
            }
            e(i, obj, this.f803a.get(i), aVar);
            int dividerHeight = ((ListView) viewGroup).getDividerHeight();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, dividerHeight, 0, 0);
            view2.setLayoutParams(layoutParams);
            LinearLayout linearLayout = new LinearLayout(inflate.getContext());
            linearLayout.setOrientation(1);
            linearLayout.addView(inflate);
            linearLayout.addView(view2);
            return linearLayout;
        }
        ViewGroup viewGroup2 = (ViewGroup) view;
        super.getView(i, viewGroup2.getChildAt(1), viewGroup);
        View childAt = viewGroup2.getChildAt(0);
        if (i != 0) {
            obj = getItem(i - 1);
        }
        e(i, obj, this.f803a.get(i), (a.C0042a) childAt.getTag());
        return view;
    }

    public int getViewTypeCount() {
        return 2;
    }
}
