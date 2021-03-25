package com.sozpic.miniland.modelos;

import a.c.a.d.a;
import a.c.d.r.j;
import android.os.Parcel;
import android.os.Parcelable;
import com.sozpic.miniland.R;
import com.tuya.smart.common.oOO0O0O0;
import java.text.ParseException;
import java.util.Date;
import org.json.JSONObject;

public class Agenda implements Parcelable {
    public static final Parcelable.Creator<Agenda> CREATOR = new Parcelable.Creator<Agenda>() {
        public Agenda createFromParcel(Parcel parcel) {
            return new Agenda(parcel);
        }

        public Agenda[] newArray(int i) {
            return new Agenda[i];
        }
    };
    public Date endDate;
    public String fechafin;
    public String fechainicio;
    public String id;
    public Medica medicalRecord;
    public String nombre;
    public Date startDate;
    public String texto;
    public int tipo;
    public String tododia;

    public Agenda() {
        this.id = "";
        this.nombre = "";
        this.texto = "";
        this.tododia = "";
        this.fechainicio = "";
        this.fechafin = "";
        this.tipo = 0;
        this.startDate = null;
        this.endDate = null;
        this.id = oOO0O0O0.O0000oO0;
        this.nombre = a.h(R.string.TR_EMPTY);
    }

    public Agenda(Parcel parcel) {
        this.id = "";
        this.nombre = "";
        this.texto = "";
        this.tododia = "";
        this.fechainicio = "";
        this.fechafin = "";
        this.tipo = 0;
        this.startDate = null;
        this.endDate = null;
        this.id = parcel.readString();
        this.nombre = parcel.readString();
        this.texto = parcel.readString();
        this.tododia = parcel.readString();
        this.fechainicio = parcel.readString();
        this.fechafin = parcel.readString();
        this.tipo = parcel.readInt();
        this.medicalRecord = (Medica) parcel.readParcelable(Medica.class.getClassLoader());
    }

    public Agenda(JSONObject jSONObject) {
        Medica medica;
        this.id = "";
        this.nombre = "";
        this.texto = "";
        this.tododia = "";
        this.fechainicio = "";
        this.fechafin = "";
        this.tipo = 0;
        this.startDate = null;
        this.endDate = null;
        if (jSONObject.has("idActividad")) {
            this.id = jSONObject.getString("idActividad");
        }
        if (jSONObject.has("asunto")) {
            this.nombre = jSONObject.getString("asunto");
        }
        if (jSONObject.has("tododia")) {
            this.tododia = jSONObject.getString("tododia");
        }
        if (jSONObject.has("descripcion")) {
            this.texto = jSONObject.getString("descripcion");
        }
        if (jSONObject.has("fecha")) {
            this.fechainicio = jSONObject.getString("fecha");
        }
        if (jSONObject.has("fechafin")) {
            this.fechafin = jSONObject.getString("fechafin");
        }
        if (jSONObject.has("medical_record")) {
            if (jSONObject.get("medical_record") instanceof JSONObject) {
                medica = new Medica(jSONObject.getJSONObject("medical_record"));
            } else if (jSONObject.get("medical_record") instanceof String) {
                medica = new Medica(new JSONObject(jSONObject.getString("medical_record")));
            } else {
                return;
            }
            this.medicalRecord = medica;
        }
    }

    public int describeContents() {
        return 0;
    }

    public Date getEndDate() {
        this.endDate = null;
        if (0 == 0) {
            try {
                Date parse = j.i.parse(this.fechafin);
                this.endDate = parse;
                if (parse.getYear() < 0) {
                    this.endDate = j.j.parse(this.fechafin);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.endDate == null) {
                try {
                    this.endDate = j.f.parse(this.fechafin);
                } catch (ParseException e3) {
                    e3.printStackTrace();
                }
            }
        }
        return this.endDate;
    }

    public String getFechafin() {
        return this.fechafin;
    }

    public String getFechainicio() {
        return this.fechainicio;
    }

    public String getId() {
        return this.id;
    }

    public Medica getMedicalRecord() {
        return this.medicalRecord;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Date getStartDate() {
        if (this.startDate == null) {
            try {
                Date parse = j.i.parse(this.fechainicio);
                this.startDate = parse;
                if (parse.getYear() < 0) {
                    this.startDate = j.j.parse(this.fechainicio);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.startDate == null) {
                try {
                    this.startDate = j.f.parse(this.fechainicio);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        return this.startDate;
    }

    public String getTexto() {
        return this.texto;
    }

    public int getTipo() {
        return this.tipo;
    }

    public String getTododia() {
        return this.tododia;
    }

    public boolean isAllDay() {
        return "1".equals(getTododia());
    }

    public void setFechafin(String str) {
        this.fechafin = str;
    }

    public void setFechainicio(String str) {
        this.fechainicio = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMedicalRecord(Medica medica) {
        this.medicalRecord = medica;
    }

    public void setNombre(String str) {
        this.nombre = str;
    }

    public void setTexto(String str) {
        this.texto = str;
    }

    public void setTipo(int i) {
        this.tipo = i;
    }

    public void setTododia(String str) {
        this.tododia = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.nombre);
        parcel.writeString(this.texto);
        parcel.writeString(this.tododia);
        parcel.writeString(this.fechainicio);
        parcel.writeString(this.fechafin);
        parcel.writeInt(this.tipo);
        parcel.writeParcelable(this.medicalRecord, 0);
    }
}
