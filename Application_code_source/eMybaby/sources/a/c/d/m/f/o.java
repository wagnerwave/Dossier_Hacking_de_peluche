package a.c.d.m.f;

import com.cuatroochenta.miniland.model.BabyDiaryEntry;
import java.util.Comparator;

public class o implements Comparator<n> {
    public o(p pVar) {
    }

    public int compare(Object obj, Object obj2) {
        return ((BabyDiaryEntry) ((n) obj2).getItem(0)).getWeek() - ((BabyDiaryEntry) ((n) obj).getItem(0)).getWeek();
    }
}
