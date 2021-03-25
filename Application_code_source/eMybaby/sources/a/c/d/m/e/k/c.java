package a.c.d.m.e.k;

import com.cuatroochenta.miniland.model.MedicalDataEntry;
import java.util.Comparator;

public class c implements Comparator<MedicalDataEntry> {
    public c(i iVar) {
    }

    public int compare(Object obj, Object obj2) {
        return ((MedicalDataEntry) obj2).getDate().compareTo(((MedicalDataEntry) obj).getDate());
    }
}
