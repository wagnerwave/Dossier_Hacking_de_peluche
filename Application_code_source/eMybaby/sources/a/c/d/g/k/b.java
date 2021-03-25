package a.c.d.g.k;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.DialogFragment;
import com.cuatroochenta.miniland.model.Song;
import com.sozpic.miniland.R;

public class b extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public String f112a;

    /* renamed from: b  reason: collision with root package name */
    public c f113b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f114c;

    /* renamed from: d  reason: collision with root package name */
    public int f115d;

    /* renamed from: e  reason: collision with root package name */
    public int f116e;
    public Song f;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            b.this.dismiss();
        }
    }

    /* renamed from: a.c.d.g.k.b$b  reason: collision with other inner class name */
    public class C0003b implements View.OnClickListener {
        public C0003b() {
        }

        public void onClick(View view) {
            b bVar = b.this;
            if (bVar.f116e == 3) {
                a.c.d.s.a.c.a.b bVar2 = new a.c.d.s.a.c.a.b();
                b bVar3 = b.this;
                bVar2.f829a = bVar3.f;
                c cVar = bVar3.f113b;
                if (cVar != null) {
                    cVar.f(bVar2);
                }
            } else if (a.c.a.d.a.j(bVar.f114c.getText().toString())) {
                Toast.makeText(b.this.getActivity(), a.c.a.d.a.h(R.string.TR_ERROR_SAVE_SONG_NAME_EMPTY), 0).show();
                return;
            } else {
                int i = b.this.f116e;
                if (i == 0) {
                    a.c.d.s.a.c.c.b bVar4 = new a.c.d.s.a.c.c.b();
                    b bVar5 = b.this;
                    bVar4.f845b = bVar5.f115d;
                    bVar4.f846c = bVar5.f114c.getText().toString();
                    b bVar6 = b.this;
                    bVar4.f844a = bVar6.f112a;
                    c cVar2 = bVar6.f113b;
                    if (cVar2 != null) {
                        cVar2.k(bVar4);
                    }
                } else if (i == 1) {
                    a.c.d.s.a.c.b.b bVar7 = new a.c.d.s.a.c.b.b();
                    b bVar8 = b.this;
                    bVar7.f836a = bVar8.f;
                    bVar7.f837b = bVar8.f114c.getText().toString();
                    c cVar3 = b.this.f113b;
                    if (cVar3 != null) {
                        cVar3.m(bVar7);
                    }
                } else {
                    return;
                }
            }
            b.this.dismiss();
        }
    }

    public interface c {
        void f(a.c.d.s.a.c.a.b bVar);

        void h();

        void k(a.c.d.s.a.c.c.b bVar);

        void m(a.c.d.s.a.c.b.b bVar);
    }

    public static b m(int i, Song song) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putParcelable("SONG", song);
        bundle.putInt("MODE", i);
        bVar.setArguments(bundle);
        return bVar;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f113b = (c) activity;
        } catch (ClassCastException unused) {
            throw new ClassCastException(activity.toString() + " must implement OnSoundSaveButtonClick");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            int i = arguments.getInt("MODE", -1);
            this.f116e = i;
            if (i == 0) {
                this.f112a = arguments.getString("ARG_FILE_ABSOLUTE_PATH");
                this.f115d = arguments.getInt("DURATION");
            } else if (arguments.containsKey("SONG")) {
                this.f = (Song) arguments.getParcelable("SONG");
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        View inflate = layoutInflater.inflate(R.layout.fragment_default_dialog, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.default_dialog_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.default_dialog_left);
        TextView textView3 = (TextView) inflate.findViewById(R.id.default_dialog_right);
        EditText editText = (EditText) inflate.findViewById(R.id.default_dialog_edit);
        this.f114c = editText;
        editText.setInputType(16384);
        int i2 = this.f116e;
        if (i2 == 1) {
            Song song = this.f;
            if (song != null) {
                this.f114c.setText(a.c.a.d.a.g(song.getTitle()));
            }
        } else if (i2 == 3) {
            this.f114c.setVisibility(8);
        }
        textView2.setOnClickListener(new a());
        textView3.setOnClickListener(new C0003b());
        int i3 = this.f116e;
        if (i3 == 0 || i3 == 1) {
            i = R.string.TR_ENTER_NAME_FOR_RECORDING;
        } else {
            if (i3 == 3) {
                i = R.string.TR_DELETE_RECORDING_CONFIRM;
            }
            textView2.setText(a.c.a.d.a.h(R.string.TR_CANCEL).toUpperCase());
            textView3.setText(a.c.a.d.a.h(R.string.TR_OK).toUpperCase());
            getDialog().getWindow().requestFeature(1);
            getDialog().getWindow().setBackgroundDrawableResource(17170445);
            return inflate;
        }
        textView.setText(a.c.a.d.a.h(i));
        textView2.setText(a.c.a.d.a.h(R.string.TR_CANCEL).toUpperCase());
        textView3.setText(a.c.a.d.a.h(R.string.TR_OK).toUpperCase());
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().setBackgroundDrawableResource(17170445);
        return inflate;
    }

    public void onDetach() {
        super.onDetach();
        this.f113b = null;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        c cVar = this.f113b;
        if (cVar != null) {
            cVar.h();
        }
        super.onDismiss(dialogInterface);
    }
}
