package a.c.d.m.f;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class p extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<n> f457a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    public ViewPager f458b;

    /* renamed from: c  reason: collision with root package name */
    public Queue<Runnable> f459c = new PriorityQueue();

    public final n a() {
        return this.f457a.get(this.f458b.getCurrentItem());
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public int getCount() {
        return this.f457a.size();
    }

    public int getItemPosition(Object obj) {
        return -2;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (viewGroup instanceof ViewPager) {
            this.f458b = (ViewPager) viewGroup;
            Runnable poll = this.f459c.poll();
            if (poll != null) {
                poll.run();
            }
        }
        ListView listView = new ListView(viewGroup.getContext());
        listView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        listView.setAdapter(this.f457a.get(i));
        listView.setDivider((Drawable) null);
        listView.setSelector(new ColorDrawable(0));
        listView.setVerticalScrollBarEnabled(false);
        listView.setHorizontalScrollBarEnabled(false);
        listView.setDividerHeight((int) (((float) 10) * Resources.getSystem().getDisplayMetrics().density));
        listView.setOverScrollMode(2);
        viewGroup.addView(listView);
        return listView;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
