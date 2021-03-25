package a.c.d.j.d;

import com.cuatroochenta.miniland.humidificador.device.DeviceControlActivity;
import java.util.Comparator;

public class b implements Comparator<String> {
    public b(DeviceControlActivity deviceControlActivity) {
    }

    public int compare(Object obj, Object obj2) {
        return Integer.parseInt((String) obj) - Integer.parseInt((String) obj2);
    }
}
