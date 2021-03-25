package a.h.a.k0;

import a.c.a.d.a;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.sozpic.miniland.R;
import com.sozpic.miniland.modelos.Video;

public class g extends ArrayAdapter<Video> {

    /* renamed from: a  reason: collision with root package name */
    public final Activity f3506a;

    /* renamed from: b  reason: collision with root package name */
    public final Video[] f3507b;

    public g(Activity activity, Video[] videoArr) {
        super(activity, R.layout.row_video, videoArr);
        this.f3506a = activity;
        this.f3507b = videoArr;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView;
        View inflate = this.f3506a.getLayoutInflater().inflate(R.layout.row_video, (ViewGroup) null, true);
        Video video = this.f3507b[i];
        if (video != null) {
            if (video.getId() == 0) {
                textView = (TextView) inflate.findViewById(R.id.texto1);
                textView.setPadding(0, 10, 0, 0);
            } else {
                textView = (TextView) inflate.findViewById(R.id.texto1);
            }
            textView.setText(video.getNombre());
            Button button = (Button) inflate.findViewById(R.id.play);
            button.setText(a.h(R.string.TR_PLAY));
            button.setVisibility(8);
            ((ImageView) inflate.findViewById(R.id.lo)).setImageResource(video.getId() >= 7 ? R.drawable.cuadro_camara_ip : R.drawable.cuadro_camara);
        }
        return inflate;
    }
}
