package com.sozpic.miniland.modelos;

import a.c.a.d.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.sozpic.miniland.R;
import org.json.JSONObject;

public class Familia implements Parcelable {
    public static final Parcelable.Creator<Familia> CREATOR = new Parcelable.Creator<Familia>() {
        public Familia createFromParcel(Parcel parcel) {
            return new Familia(parcel);
        }

        public Familia[] newArray(int i) {
            return new Familia[i];
        }
    };
    public String apellidos;
    public String fechanacimiento;
    public String foto;
    public String id;
    public String nombre;
    public String ojos;
    public String pelo;
    public String piel;
    public String sexo;
    public String tipo;

    public Familia() {
    }

    public Familia(Parcel parcel) {
        this.id = parcel.readString();
        this.tipo = parcel.readString();
        this.nombre = parcel.readString();
        this.apellidos = parcel.readString();
        this.fechanacimiento = parcel.readString();
        this.ojos = parcel.readString();
        this.pelo = parcel.readString();
        this.piel = parcel.readString();
        this.sexo = parcel.readString();
        this.foto = parcel.readString();
    }

    public Familia(JSONObject jSONObject) {
        this.id = jSONObject.getString("idPersona");
        this.nombre = jSONObject.getString("nombre");
        this.apellidos = jSONObject.getString("apellidos");
        this.fechanacimiento = jSONObject.getString("fechanacimiento");
        this.sexo = jSONObject.getString("sexo");
        this.ojos = jSONObject.getString("colorojos");
        this.pelo = jSONObject.getString("pelo");
        this.piel = jSONObject.getString("piel");
        this.tipo = jSONObject.getString("tipo");
        this.foto = jSONObject.getString("foto");
    }

    public int describeContents() {
        return 0;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public String getFechanacimiento() {
        return this.fechanacimiento;
    }

    public String getFoto() {
        return this.foto;
    }

    public String getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getOjos() {
        return this.ojos;
    }

    public String getPelo() {
        return this.pelo;
    }

    public String getPiel() {
        return this.piel;
    }

    public String getSexo() {
        return this.sexo;
    }

    public String getTipo() {
        int i;
        String str = this.tipo;
        if (str.equals("01")) {
            i = R.string.TR_BROTHER_SISTER;
        } else if (str.equals("02")) {
            i = R.string.TR_MOTHER;
        } else if (str.equals("03")) {
            i = R.string.TR_FATHER;
        } else if (str.equals("04")) {
            i = R.string.TR_COUSIN;
        } else if (str.equals("05")) {
            i = R.string.TR_UNCLE_AUNT;
        } else if (str.equals("06")) {
            i = R.string.TR_GRAND_FATHER_MOTHER;
        } else if (!str.equals("07")) {
            return "";
        } else {
            i = R.string.TR_OTHER;
        }
        return a.h(i);
    }

    public String getTipoId() {
        return this.tipo;
    }

    public boolean isPhotoEmpty() {
        return a.j(getFoto()) || "https://emybaby.com/app/fotos//familia/".equals(getFoto());
    }

    public void setApellidos(String str) {
        this.apellidos = str;
    }

    public void setFechanacimiento(String str) {
        this.fechanacimiento = str;
    }

    public void setFoto(String str) {
        this.foto = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setNombre(String str) {
        this.nombre = str;
    }

    public void setOjos(String str) {
        this.ojos = str;
    }

    public void setPelo(String str) {
        this.pelo = str;
    }

    public void setPiel(String str) {
        this.piel = str;
    }

    public void setSexo(String str) {
        this.sexo = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.tipo);
        parcel.writeString(this.nombre);
        parcel.writeString(this.apellidos);
        parcel.writeString(this.fechanacimiento);
        parcel.writeString(this.ojos);
        parcel.writeString(this.pelo);
        parcel.writeString(this.piel);
        parcel.writeString(this.sexo);
        parcel.writeString(this.foto);
    }
}
