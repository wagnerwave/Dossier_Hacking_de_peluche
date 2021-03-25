package a.c.d.m.e.l;

import a.i.a.e;
import a.i.a.t;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import com.cuatroochenta.miniland.pregnancy.baby.MyPregnancyFragmentContainerActivity;
import com.sozpic.miniland.R;
import java.util.LinkedList;
import java.util.List;

public class n extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<String> f428a = new LinkedList();

    public class a implements View.OnLongClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f429a;

        public a(n nVar, ViewGroup viewGroup) {
            this.f429a = viewGroup;
        }

        public boolean onLongClick(View view) {
            if (!(this.f429a.getContext() instanceof MyPregnancyFragmentContainerActivity)) {
                return true;
            }
            ((MyPregnancyFragmentContainerActivity) this.f429a.getContext()).q();
            return true;
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f430a;

        public b(n nVar, ViewGroup viewGroup) {
            this.f430a = viewGroup;
        }

        public void onClick(View view) {
            if (this.f430a.getContext() instanceof MyPregnancyFragmentContainerActivity) {
                ((MyPregnancyFragmentContainerActivity) this.f430a.getContext()).r();
            }
        }
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public int getCount() {
        return this.f428a.size();
    }

    public int getItemPosition(Object obj) {
        return -2;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        String str = this.f428a.get(i);
        ImageView imageView = new ImageView(viewGroup.getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.drawable.ic_baby_diary_transparent);
        imageView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        imageView.setOnLongClickListener(new a(this, viewGroup));
        imageView.setOnClickListener(new b(this, viewGroup));
        if (str.startsWith("http")) {
            t.f(viewGroup.getContext()).d(str.replace(" ", "%20")).b(imageView, (e) null);
        } else {
            imageView.setImageBitmap(BitmapFactory.decodeFile(str));
        }
        viewGroup.addView(imageView);
        return imageView;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
