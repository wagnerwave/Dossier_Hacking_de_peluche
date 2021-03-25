package com.sozpic.miniland.modelos;

import a.c.d.r.j;
import a.e.a.a.r.b;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
import org.json.JSONObject;

public class Medica implements Parcelable {
    public static final int CITA = 2;
    public static final Parcelable.Creator<Medica> CREATOR = new Parcelable.Creator<Medica>() {
        public Medica createFromParcel(Parcel parcel) {
            return new Medica(parcel);
        }

        public Medica[] newArray(int i) {
            return new Medica[i];
        }
    };
    public static final int CRECIMIENTO = 1;
    public static final int VACUNA = 3;
    public String alturacrecimiento;
    public String bebibleinyectablevacuna;
    public Date citaMedicaDate;
    public String colegiadovacuna;
    public String especialistacita;
    public String fechacita;
    public String fechacrecimiento;
    public String fechavacuna;
    public String horacita = "";
    public String id;
    public String laboratoriovacuna;
    public String lotevacuna;
    public String lugarcita;
    public String medicocita;
    public String medidaCabCrecimiento;
    public String observacionesvacuna;
    public String pesocrecimiento;
    public String tallacrecimiento;
    public int tipo = 0;
    public String tratamientocita;
    public String vacunavacuna;

    public Medica() {
    }

    public Medica(Parcel parcel) {
        this.id = parcel.readString();
        this.tipo = parcel.readInt();
        this.fechacrecimiento = parcel.readString();
        this.alturacrecimiento = parcel.readString();
        this.pesocrecimiento = parcel.readString();
        this.tallacrecimiento = parcel.readString();
        this.medidaCabCrecimiento = parcel.readString();
        this.fechavacuna = parcel.readString();
        this.vacunavacuna = parcel.readString();
        this.bebibleinyectablevacuna = parcel.readString();
        this.colegiadovacuna = parcel.readString();
        this.lotevacuna = parcel.readString();
        this.laboratoriovacuna = parcel.readString();
        this.observacionesvacuna = parcel.readString();
        this.fechacita = parcel.readString();
        this.horacita = parcel.readString();
        this.especialistacita = parcel.readString();
        this.medicocita = parcel.readString();
        this.lugarcita = parcel.readString();
        this.tratamientocita = parcel.readString();
        long readLong = parcel.readLong();
        this.citaMedicaDate = readLong == -1 ? null : new Date(readLong);
    }

    public Medica(JSONObject jSONObject) {
        if (jSONObject.has("idCita")) {
            this.id = jSONObject.getString("idCita");
            this.tipo = 2;
        }
        if (jSONObject.has("fechacita")) {
            this.fechacita = jSONObject.getString("fechacita");
        }
        if (jSONObject.has("especialista")) {
            this.especialistacita = jSONObject.getString("especialista");
        }
        if (jSONObject.has("medico")) {
            this.medicocita = jSONObject.getString("medico");
        }
        if (jSONObject.has("lugar")) {
            this.lugarcita = jSONObject.getString("lugar");
        }
        if (jSONObject.has("tratamiento")) {
            this.tratamientocita = jSONObject.getString("tratamiento");
        }
        if (jSONObject.has("idCrecimiento")) {
            this.id = jSONObject.getString("idCrecimiento");
            this.tipo = 1;
        }
        if (jSONObject.has("fecharevision")) {
            this.fechacrecimiento = jSONObject.getString("fecharevision");
        }
        if (jSONObject.has("altura")) {
            this.alturacrecimiento = jSONObject.getString("altura");
        }
        if (jSONObject.has("peso")) {
            this.pesocrecimiento = jSONObject.getString("peso");
        }
        if (jSONObject.has("talla")) {
            this.medidaCabCrecimiento = jSONObject.getString("talla");
        }
        if (jSONObject.has("idVacuna")) {
            this.id = jSONObject.getString("idVacuna");
            this.tipo = 3;
        }
        if (jSONObject.has("fechavacuna")) {
            this.fechavacuna = jSONObject.getString("fechavacuna");
        }
        if (jSONObject.has("vacuna")) {
            this.vacunavacuna = jSONObject.getString("vacuna");
        }
        if (jSONObject.has("tipo")) {
            this.bebibleinyectablevacuna = jSONObject.getString("tipo");
        }
        if (jSONObject.has("numcolegiado")) {
            this.colegiadovacuna = jSONObject.getString("numcolegiado");
        }
        if (jSONObject.has("lote")) {
            this.lotevacuna = jSONObject.getString("lote");
        }
        if (jSONObject.has("laboratorio")) {
            this.laboratoriovacuna = jSONObject.getString("laboratorio");
        }
        if (jSONObject.has("observaciones")) {
            this.observacionesvacuna = jSONObject.getString("observaciones");
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getAlturacrecimiento() {
        return this.alturacrecimiento;
    }

    public String getBebibleinyectablevacuna() {
        return this.bebibleinyectablevacuna;
    }

    public String getColegiadovacuna() {
        return this.colegiadovacuna;
    }

    public String getEspecialistacita() {
        return this.especialistacita;
    }

    public String getFechacita() {
        return this.fechacita;
    }

    public String getFechacitaCorta() {
        Date date = this.citaMedicaDate;
        if (date != null) {
            return j.f.format(date);
        }
        String str = this.fechacita;
        if (str != null) {
            String[] a0 = b.a0(str, " ");
            if (a0.length >= 2) {
                return a0[0];
            }
        }
        return this.fechacita;
    }

    public String getFechacrecimiento() {
        return this.fechacrecimiento;
    }

    public String getFechavacuna() {
        return this.fechavacuna;
    }

    public String getFechavacunaCorta() {
        String str = this.fechavacuna;
        if (str != null) {
            String[] a0 = b.a0(str, " ");
            if (a0.length >= 2) {
                return a0[0];
            }
        }
        return this.fechavacuna;
    }

    public String getHoraCitaCorta() {
        String str = this.fechacita;
        if (str != null) {
            String[] a0 = b.a0(str, " ");
            if (a0.length >= 2) {
                return a0[1];
            }
        }
        return this.fechacita;
    }

    public String getHoracita() {
        return this.horacita;
    }

    public String getHoracitaCorta() {
        Date date = this.citaMedicaDate;
        if (date != null) {
            return j.l.format(date);
        }
        String str = this.fechacita;
        if (str != null) {
            String[] a0 = b.a0(str, " ");
            if (a0.length >= 2) {
                return a0[1];
            }
        }
        return this.fechacita;
    }

    public String getId() {
        return this.id;
    }

    public String getLaboratoriovacuna() {
        return this.laboratoriovacuna;
    }

    public String getLotevacuna() {
        return this.lotevacuna;
    }

    public String getLugarcita() {
        return this.lugarcita;
    }

    public String getMedicocita() {
        return this.medicocita;
    }

    public String getMedidaCabCrecimiento() {
        return this.medidaCabCrecimiento;
    }

    public String getObservacionesvacuna() {
        return this.observacionesvacuna;
    }

    public String getPesocrecimiento() {
        return this.pesocrecimiento;
    }

    public String getTallacrecimiento() {
        return this.tallacrecimiento;
    }

    public int getTipo() {
        return this.tipo;
    }

    public String getTratamientocita() {
        return this.tratamientocita;
    }

    public String getVacunavacuna() {
        return this.vacunavacuna;
    }

    public void setAlturacrecimiento(String str) {
        this.alturacrecimiento = str;
    }

    public void setBebibleinyectablevacuna(String str) {
        this.bebibleinyectablevacuna = str;
    }

    public void setColegiadovacuna(String str) {
        this.colegiadovacuna = str;
    }

    public void setEspecialistacita(String str) {
        this.especialistacita = str;
    }

    public void setFechacita(String str) {
        this.fechacita = str;
    }

    public void setFechacrecimiento(String str) {
        this.fechacrecimiento = str;
    }

    public void setFechavacuna(String str) {
        this.fechavacuna = str;
    }

    public void setHoracita(String str) {
        this.horacita = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLaboratoriovacuna(String str) {
        this.laboratoriovacuna = str;
    }

    public void setLotevacuna(String str) {
        this.lotevacuna = str;
    }

    public void setLugarcita(String str) {
        this.lugarcita = str;
    }

    public void setMedicocita(String str) {
        this.medicocita = str;
    }

    public void setMedidaCabCrecimiento(String str) {
        this.medidaCabCrecimiento = str;
    }

    public void setObservacionesvacuna(String str) {
        this.observacionesvacuna = str;
    }

    public void setPesocrecimiento(String str) {
        this.pesocrecimiento = str;
    }

    public void setTallacrecimiento(String str) {
        this.tallacrecimiento = str;
    }

    public void setTipo(int i) {
        this.tipo = i;
    }

    public void setTratamientocita(String str) {
        this.tratamientocita = str;
    }

    public void setVacunavacuna(String str) {
        this.vacunavacuna = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeInt(this.tipo);
        parcel.writeString(this.fechacrecimiento);
        parcel.writeString(this.alturacrecimiento);
        parcel.writeString(this.pesocrecimiento);
        parcel.writeString(this.tallacrecimiento);
        parcel.writeString(this.medidaCabCrecimiento);
        parcel.writeString(this.fechavacuna);
        parcel.writeString(this.vacunavacuna);
        parcel.writeString(this.bebibleinyectablevacuna);
        parcel.writeString(this.colegiadovacuna);
        parcel.writeString(this.lotevacuna);
        parcel.writeString(this.laboratoriovacuna);
        parcel.writeString(this.observacionesvacuna);
        parcel.writeString(this.fechacita);
        parcel.writeString(this.horacita);
        parcel.writeString(this.especialistacita);
        parcel.writeString(this.medicocita);
        parcel.writeString(this.lugarcita);
        parcel.writeString(this.tratamientocita);
        Date date = this.citaMedicaDate;
        parcel.writeLong(date != null ? date.getTime() : -1);
    }
}
