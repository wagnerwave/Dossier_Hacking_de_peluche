package a.c.d.h;

import android.content.DialogInterface;
import com.cuatroochenta.miniland.emyscale.MyScaleBabyActivity;

public class c implements DialogInterface.OnClickListener {
    public c(MyScaleBabyActivity myScaleBabyActivity) {
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
