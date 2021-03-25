package a.c.d.m.l;

import a.c.a.e.f;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.cuatroochenta.miniland.model.HeartBeatSound;
import com.sozpic.miniland.R;
import com.tuya.smart.common.oOO0O0O0;
import java.util.ArrayList;

public class c extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f719a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<HeartBeatSound> f720b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f721c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public int f722d;

    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HeartBeatSound f723a;

        public a(HeartBeatSound heartBeatSound) {
            this.f723a = heartBeatSound;
        }

        public void onClick(View view) {
            if (c.this.f722d == 1) {
                f.c().d("MI_EMBARAZO", "SWEETBEAT_SHARE", "");
                Context context = view.getContext();
                HeartBeatSound heartBeatSound = this.f723a;
                if (heartBeatSound != null && !a.c.a.d.a.j(heartBeatSound.getMp3UrlFile())) {
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.TEXT", a.c.a.d.a.h(R.string.TR_SHARE_SOUND_FORMAT).replace("#TITLE#", heartBeatSound.getTitle()).replace("#URL#", heartBeatSound.getMp3UrlFile()));
                    context.startActivity(Intent.createChooser(intent, ""));
                }
            }
        }
    }

    public class b {

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f725a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f726b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f727c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f728d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f729e;
        public TextView f;

        public b(c cVar) {
        }
    }

    public c(Context context) {
        this.f719a = context;
        this.f722d = 1;
    }

    public void a() {
        if (this.f722d == 2) {
            this.f722d = 1;
            this.f721c.clear();
        } else {
            this.f722d = 2;
        }
        notifyDataSetChanged();
    }

    public void b(HeartBeatSound heartBeatSound) {
        if (heartBeatSound != null && !a.c.a.d.a.j(heartBeatSound.getId()) && this.f722d == 2) {
            if (this.f721c.contains(heartBeatSound.getId())) {
                this.f721c.remove(heartBeatSound.getId());
            } else {
                this.f721c.add(heartBeatSound.getId());
            }
            notifyDataSetChanged();
        }
    }

    public int getCount() {
        return this.f720b.size();
    }

    public Object getItem(int i) {
        return this.f720b.get(i);
    }

    public long getItemId(int i) {
        if (this.f720b.get(i) == null) {
            return 0;
        }
        return (long) this.f720b.get(i).hashCode();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2;
        TextView textView;
        String str;
        TextView textView2;
        if (view == null || !(view.getTag() instanceof b)) {
            view = ((LayoutInflater) this.f719a.getSystemService("layout_inflater")).inflate(R.layout.item_pregnancy_sounds, (ViewGroup) null);
            bVar = new b(this);
            bVar.f725a = (ViewGroup) view.findViewById(R.id.pregnancy_sound_list_root);
            bVar.f726b = (TextView) view.findViewById(R.id.pregnancy_sounds_item_icon_text);
            bVar.f727c = (ImageView) view.findViewById(R.id.pregnancy_sounds_item_right_image);
            bVar.f728d = (TextView) view.findViewById(R.id.pregnancy_sounds_item_item_name);
            bVar.f729e = (TextView) view.findViewById(R.id.pregnancy_sounds_item_date);
            bVar.f = (TextView) view.findViewById(R.id.pregnancy_sounds_item_duration);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        HeartBeatSound heartBeatSound = this.f720b.get(i);
        if (heartBeatSound != null) {
            int i3 = i + 1;
            int i4 = this.f722d;
            int i5 = R.color.pink_dark;
            if (i4 == 2) {
                bVar.f727c.setImageResource(R.drawable.ic_tick_green);
                bVar.f727c.setSelected(this.f721c.contains(heartBeatSound.getId()));
                bVar.f725a.setBackgroundColor(this.f719a.getResources().getColor(bVar.f727c.isSelected() ? R.color.grey_light : 17170443));
                bVar.f726b.setTextColor(this.f719a.getResources().getColor(bVar.f727c.isSelected() ? 17170443 : R.color.pink_dark));
                textView = bVar.f726b;
                Resources resources = this.f719a.getResources();
                if (!bVar.f727c.isSelected()) {
                    i5 = 17170443;
                }
                i2 = resources.getColor(i5);
            } else {
                bVar.f727c.setImageResource(R.drawable.ic_share_pink);
                i2 = -1;
                bVar.f725a.setBackgroundColor(-1);
                bVar.f725a.setBackgroundColor(-1);
                bVar.f726b.setTextColor(this.f719a.getResources().getColor(R.color.pink_dark));
                textView = bVar.f726b;
            }
            textView.setBackgroundColor(i2);
            if (i3 < 10) {
                textView2 = bVar.f726b;
                str = String.valueOf(oOO0O0O0.O0000oO0 + i3);
            } else {
                textView2 = bVar.f726b;
                str = String.valueOf(i3);
            }
            textView2.setText(str);
            bVar.f728d.setText(a.c.a.d.a.g(heartBeatSound.getTitle()));
            bVar.f729e.setText(heartBeatSound.getCaptureDateFormatted());
            bVar.f.setText(heartBeatSound.getDurationFormatted());
            bVar.f727c.setOnClickListener(new a(heartBeatSound));
        }
        return view;
    }
}
