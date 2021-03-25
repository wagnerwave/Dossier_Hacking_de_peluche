package a.c.d.n;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.sozpic.miniland.R;

public class b extends DialogFragment {

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            b.this.dismiss();
        }
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_thanks_for_rating, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.dialog_rate_app_title)).setText(a.c.a.d.a.h(R.string.TR_MUCHISIMAS_GRACIAS_POR_TU_VALORACION));
        ((TextView) inflate.findViewById(R.id.dialog_rate_app_subtitle)).setText(a.c.a.d.a.h(R.string.TR_QUE_TENGAS_UN_BUEN_DIA));
        inflate.setOnClickListener(new a());
        getDialog().getWindow().requestFeature(1);
        return inflate;
    }
}
