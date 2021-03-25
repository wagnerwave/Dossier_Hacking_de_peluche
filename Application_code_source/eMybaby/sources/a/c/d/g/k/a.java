package a.c.d.g.k;

import a.c.d.r.j;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.cuatroochenta.miniland.downloader.FileDownloaderService;
import com.sozpic.miniland.R;

public class a extends DialogFragment implements a.c.d.f.a {

    /* renamed from: a  reason: collision with root package name */
    public e f100a;

    /* renamed from: b  reason: collision with root package name */
    public int f101b = -1;

    /* renamed from: c  reason: collision with root package name */
    public long f102c = -1;

    /* renamed from: d  reason: collision with root package name */
    public ProgressBar f103d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f104e;
    public TextView f;
    public TextView g;
    public TextView h;
    public ViewGroup i;
    public ViewGroup j;

    /* renamed from: a.c.d.g.k.a$a  reason: collision with other inner class name */
    public class C0002a implements View.OnClickListener {
        public C0002a() {
        }

        public void onClick(View view) {
            if (a.this.i.getVisibility() == 0) {
                Intent intent = new Intent(a.this.getActivity(), FileDownloaderService.class);
                intent.putExtra("KEY_INTENT_DOWNLOADER_MODE", 1);
                a.this.getActivity().startService(intent);
                return;
            }
            a.this.dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            Intent intent = new Intent(a.this.getActivity(), FileDownloaderService.class);
            intent.putExtra("KEY_INTENT_DOWNLOADER_MODE", 0);
            a.this.getActivity().startService(intent);
            j.b().a(a.this);
            a.this.g.setText(a.c.a.d.a.h(R.string.TR_CANCEL));
            a.this.h.setVisibility(8);
            a.this.j.setVisibility(8);
            a.this.i.setVisibility(0);
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f107a;

        public c(boolean z) {
            this.f107a = z;
        }

        public void run() {
            if (!this.f107a) {
                Toast.makeText(a.this.getActivity(), a.c.a.d.a.h(R.string.TR_ERROR_DOWNLOADING_SONG), 0).show();
            }
            a.c.a.f.b.x0(a.this.getContext());
        }
    }

    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f109a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f110b;

        public d(long j, long j2) {
            this.f109a = j;
            this.f110b = j2;
        }

        public void run() {
            int i = (int) (((((float) this.f109a) * 1.0f) / ((float) this.f110b)) * 1.0f * 100.0f);
            a.this.f104e.setText(String.format("%d%%", new Object[]{Integer.valueOf(i)}));
            a.this.f103d.setProgress(i);
            a.this.f.setText(String.format("%s/%s", new Object[]{a.c.a.f.b.u0(this.f109a), a.c.a.f.b.u0(this.f110b)}));
        }
    }

    public interface e {
    }

    public void d(int i2, boolean z) {
        e eVar = this.f100a;
        if (eVar != null) {
            a.c.d.g.e eVar2 = (a.c.d.g.e) eVar;
        }
        if (isAdded()) {
            getActivity().runOnUiThread(new c(z));
        }
        dismiss();
    }

    public void e(long j2, long j3) {
        getActivity().runOnUiThread(new d(j2, j3));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f101b = arguments.getInt("PENDING_SONGS", -1);
            this.f102c = arguments.getLong("PENDING_SIZE", -1);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2;
        TextView textView;
        View inflate = layoutInflater.inflate(R.layout.fragment_default_dialog, viewGroup, false);
        this.i = (ViewGroup) inflate.findViewById(R.id.default_dialog_progress_container);
        this.f103d = (ProgressBar) inflate.findViewById(R.id.default_dialog_progress);
        this.f104e = (TextView) inflate.findViewById(R.id.default_dialog_progress_porcentaje);
        this.f = (TextView) inflate.findViewById(R.id.default_dialog_progress_size);
        TextView textView2 = (TextView) inflate.findViewById(R.id.default_dialog_title);
        TextView textView3 = (TextView) inflate.findViewById(R.id.default_dialog_left);
        this.g = textView3;
        textView3.setBackgroundResource(R.drawable.bg_red_leftbottom_rounded);
        this.g.setTextColor(getActivity().getResources().getColor(R.color.button_textcolor_selector));
        TextView textView4 = (TextView) inflate.findViewById(R.id.default_dialog_right);
        this.h = textView4;
        textView4.setBackgroundResource(R.drawable.bg_green_rightbottom_rounded);
        this.h.setTextColor(getActivity().getResources().getColor(R.color.button_textcolor_selector));
        this.j = (ViewGroup) inflate.findViewById(R.id.default_dialog_button_container);
        ((EditText) inflate.findViewById(R.id.default_dialog_edit)).setVisibility(8);
        this.g.setOnClickListener(new C0002a());
        this.h.setOnClickListener(new b());
        this.g.setText(a.c.a.d.a.h(R.string.TR_DOWNLOAD_LATER));
        if (this.f101b > 0) {
            textView2.setText(String.format(a.c.a.d.a.i(R.string.TR_CONTINUE_DOWNLOAD_MESSAGE), new Object[]{a.c.a.f.b.u0(this.f102c)}));
            textView = this.h;
            i2 = R.string.TR_CONTINUE;
        } else {
            textView2.setText(String.format(a.c.a.d.a.i(R.string.TR_START_DOWNLOAD_MESSAGE), new Object[]{a.c.a.f.b.u0(this.f102c)}));
            textView = this.h;
            i2 = R.string.TR_START_DOWNLOADING;
        }
        textView.setText(a.c.a.d.a.h(i2));
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().setBackgroundDrawableResource(17170445);
        return inflate;
    }

    public void onDetach() {
        super.onDetach();
        this.f100a = null;
        j b2 = j.b();
        if (b2.f800a.contains(this)) {
            b2.f800a.remove(this);
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        e eVar = this.f100a;
        if (eVar != null) {
            a.c.d.g.e eVar2 = (a.c.d.g.e) eVar;
        }
        super.onDismiss(dialogInterface);
    }

    public void show(FragmentManager fragmentManager, String str) {
        try {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add((Fragment) this, str);
            beginTransaction.commit();
        } catch (IllegalStateException e2) {
            a.c.a.f.e.c(e2.getMessage());
        }
    }
}
