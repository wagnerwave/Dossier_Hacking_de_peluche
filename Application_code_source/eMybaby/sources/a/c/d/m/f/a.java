package a.c.d.m.f;

import a.c.a.f.b;
import com.cuatroochenta.miniland.model.BabyDiaryEntry;
import com.cuatroochenta.miniland.pregnancy.babyDiary.BabyDiaryActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a.c.d.s.e.a.a.d.a f431a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BabyDiaryActivity.b f432b;

    public a(BabyDiaryActivity.b bVar, a.c.d.s.e.a.a.d.a aVar) {
        this.f432b = bVar;
        this.f431a = aVar;
    }

    public void run() {
        this.f432b.f3972a.dismiss();
        if (this.f431a.f42a.booleanValue()) {
            BabyDiaryActivity babyDiaryActivity = BabyDiaryActivity.this;
            p pVar = babyDiaryActivity.k;
            ArrayList<BabyDiaryEntry> arrayList = this.f431a.f912c;
            if (babyDiaryActivity != null) {
                HashMap hashMap = new HashMap();
                for (BabyDiaryEntry next : arrayList) {
                    n nVar = (n) hashMap.get(Integer.valueOf(next.getWeek()));
                    if (nVar == null) {
                        nVar = new n();
                        hashMap.put(Integer.valueOf(next.getWeek()), nVar);
                    }
                    nVar.f803a.add(next);
                    nVar.f();
                }
                LinkedList linkedList = new LinkedList(hashMap.values());
                pVar.f457a = linkedList;
                Collections.sort(linkedList, new o(pVar));
                BabyDiaryActivity.this.k.notifyDataSetChanged();
                this.f432b.f3972a.dismiss();
                return;
            }
            throw null;
        }
        b.j0(BabyDiaryActivity.this, this.f431a.f43b);
    }
}
