package a.h.a.k0;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.sozpic.miniland.R;
import com.sozpic.miniland.modelos.ElementoMenu;

public class e extends ArrayAdapter<ElementoMenu> {

    /* renamed from: a  reason: collision with root package name */
    public final Activity f3502a;

    /* renamed from: b  reason: collision with root package name */
    public final ElementoMenu[] f3503b;

    public e(Activity activity, ElementoMenu[] elementoMenuArr) {
        super(activity, R.layout.row_menu, elementoMenuArr);
        this.f3502a = activity;
        this.f3503b = elementoMenuArr;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = this.f3502a.getLayoutInflater().inflate(R.layout.row_menu, (ViewGroup) null, true);
        ElementoMenu elementoMenu = this.f3503b[i];
        ((TextView) inflate.findViewById(R.id.topmenu_section_title)).setText(elementoMenu.getNombre().toUpperCase());
        ((ImageView) inflate.findViewById(R.id.image)).setImageResource(elementoMenu.getImagen());
        return inflate;
    }
}
