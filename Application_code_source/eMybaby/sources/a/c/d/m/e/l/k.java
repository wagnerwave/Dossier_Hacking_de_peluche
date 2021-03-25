package a.c.d.m.e.l;

import a.c.a.a;
import a.c.d.s.e.a.c.b.b;
import com.cuatroochenta.miniland.model.UltrasoundPhoto;
import com.cuatroochenta.miniland.pregnancy.baby.MyPregnancyFragmentContainerActivity;
import com.sozpic.miniland.R;
import java.util.List;

public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f419a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f420b;

    public k(l lVar, b bVar) {
        this.f420b = lVar;
        this.f419a = bVar;
    }

    public void run() {
        this.f420b.f421a.dismiss();
        if (this.f419a.f42a.booleanValue()) {
            if (this.f420b.f422b.getActivity() instanceof MyPregnancyFragmentContainerActivity) {
                ((MyPregnancyFragmentContainerActivity) this.f420b.f422b.getActivity()).r();
            }
            m mVar = this.f420b.f422b;
            mVar.f.remove(mVar.f426d.getCurrentItem());
            m mVar2 = this.f420b.f422b;
            n nVar = mVar2.f427e;
            int currentItem = mVar2.f426d.getCurrentItem();
            if (!nVar.f428a.isEmpty()) {
                nVar.f428a.remove(currentItem);
            }
            this.f420b.f422b.f427e.notifyDataSetChanged();
            if (this.f420b.f422b.getActivity() instanceof MyPregnancyFragmentContainerActivity) {
                ((MyPregnancyFragmentContainerActivity) this.f420b.f422b.getActivity()).r();
            }
            List<UltrasoundPhoto> list = this.f420b.f422b.f;
            if (list == null || list.isEmpty()) {
                this.f420b.f422b.f423a.setText("");
                this.f420b.f422b.f424b.setText("");
                if (this.f420b.f422b.getActivity() instanceof MyPregnancyFragmentContainerActivity) {
                    ((MyPregnancyFragmentContainerActivity) this.f420b.f422b.getActivity()).s(1);
                }
                a.c.a.f.b.o0(this.f420b.f422b.getActivity(), a.f.c(a.c.a.d.a.h(R.string.TR_YA_NO_QUEDAN_ECOGRAFIAS)));
                return;
            }
            m mVar3 = this.f420b.f422b;
            mVar3.f423a.setText(mVar3.f.get(mVar3.f426d.getCurrentItem()).getDescription());
            m mVar4 = this.f420b.f422b;
            mVar4.f424b.setText(mVar4.f.get(mVar4.f426d.getCurrentItem()).getTitle());
            a.c.a.f.b.o0(this.f420b.f422b.getActivity(), a.c.a.d.a.h(R.string.TR_DELETE_ECOGRAFIA_OK));
            return;
        }
        a.c.a.f.b.j0(this.f420b.f422b.getActivity(), this.f419a.f43b);
    }
}
