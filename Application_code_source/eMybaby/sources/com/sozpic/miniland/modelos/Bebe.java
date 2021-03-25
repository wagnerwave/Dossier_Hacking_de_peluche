package com.sozpic.miniland.modelos;

import a.c.a.d.a;
import android.os.Parcel;
import android.os.Parcelable;

public class Bebe implements Parcelable {
    public static final Parcelable.Creator<Bebe> CREATOR = new Parcelable.Creator<Bebe>() {
        public Bebe createFromParcel(Parcel parcel) {
            return new Bebe(parcel);
        }

        public Bebe[] newArray(int i) {
            return new Bebe[i];
        }
    };
    public Float altura;
    public String apellidos;
    public String colorojos;
    public String cp;
    public String domicilio;
    public String fechanacimiento;
    public String foto;
    public String ginecologo;
    public String hospital;
    public int id;
    public String matron;
    public Float medidacabeza;
    public String nombre;
    public String pais;
    public String pelo;
    public Float peso;
    public String piel;
    public String poblacion;
    public String provincia;
    public String sexo;

    public Bebe() {
    }

    public Bebe(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19) {
        this.id = i;
        this.nombre = str;
        this.apellidos = str2;
        this.fechanacimiento = str3;
        this.sexo = str4;
        try {
            this.altura = Float.valueOf(Float.parseFloat(str5));
        } catch (NumberFormatException unused) {
            this.altura = Float.valueOf(0.0f);
        }
        try {
            this.peso = Float.valueOf(Float.parseFloat(str6));
        } catch (NumberFormatException unused2) {
            this.peso = Float.valueOf(0.0f);
        }
        try {
            this.medidacabeza = Float.valueOf(Float.parseFloat(str7));
        } catch (NumberFormatException unused3) {
            this.medidacabeza = Float.valueOf(0.0f);
        }
        this.colorojos = str8;
        this.pelo = str9;
        this.piel = str10;
        this.domicilio = str11;
        this.poblacion = str12;
        this.cp = str13;
        this.provincia = str14;
        this.pais = str15;
        this.hospital = str16;
        this.ginecologo = str17;
        this.matron = str18;
        this.foto = str19;
    }

    public Bebe(Parcel parcel) {
        this.id = parcel.readInt();
        this.nombre = parcel.readString();
        this.apellidos = parcel.readString();
        this.fechanacimiento = parcel.readString();
        this.sexo = parcel.readString();
        this.altura = Float.valueOf(parcel.readFloat());
        this.peso = Float.valueOf(parcel.readFloat());
        this.medidacabeza = Float.valueOf(parcel.readFloat());
        this.colorojos = parcel.readString();
        this.pelo = parcel.readString();
        this.piel = parcel.readString();
        this.domicilio = parcel.readString();
        this.poblacion = parcel.readString();
        this.cp = parcel.readString();
        this.provincia = parcel.readString();
        this.pais = parcel.readString();
        this.hospital = parcel.readString();
        this.ginecologo = parcel.readString();
        this.matron = parcel.readString();
        this.foto = parcel.readString();
    }

    public Bebe(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19) {
        this.nombre = str;
        this.apellidos = str2;
        this.fechanacimiento = str3;
        this.sexo = str4;
        try {
            this.altura = Float.valueOf(Float.parseFloat(str5));
        } catch (NumberFormatException unused) {
            this.altura = Float.valueOf(0.0f);
        }
        try {
            this.peso = Float.valueOf(Float.parseFloat(str6));
        } catch (NumberFormatException unused2) {
            this.peso = Float.valueOf(0.0f);
        }
        try {
            this.medidacabeza = Float.valueOf(Float.parseFloat(str7));
        } catch (NumberFormatException unused3) {
            this.medidacabeza = Float.valueOf(0.0f);
        }
        this.colorojos = str8;
        this.pelo = str9;
        this.piel = str10;
        this.domicilio = str11;
        this.poblacion = str12;
        this.cp = str13;
        this.provincia = str14;
        this.pais = str15;
        this.hospital = str16;
        this.ginecologo = str17;
        this.matron = str18;
        this.foto = str19;
    }

    public int describeContents() {
        return 0;
    }

    public String getAltura() {
        Float f = this.altura;
        return (f == null || f.floatValue() == 0.0f) ? "" : String.valueOf(this.altura);
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public String getColorojos() {
        return this.colorojos;
    }

    public String getCp() {
        return this.cp;
    }

    public String getDomicilio() {
        return this.domicilio;
    }

    public String getFechanacimiento() {
        return this.fechanacimiento;
    }

    public String getFoto() {
        return this.foto;
    }

    public String getFullName() {
        StringBuilder sb = new StringBuilder();
        sb.append(a.g(getNombre()));
        if (sb.length() > 0) {
            sb.append(" ");
        }
        sb.append(a.g(getApellidos()));
        return sb.toString();
    }

    public String getGinecologo() {
        return this.ginecologo;
    }

    public String getHospital() {
        return this.hospital;
    }

    public int getId() {
        return this.id;
    }

    public String getMatron() {
        return this.matron;
    }

    public String getMedidacabeza() {
        Float f = this.medidacabeza;
        return (f == null || f.floatValue() == 0.0f) ? "" : String.valueOf(this.medidacabeza);
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getPais() {
        return this.pais;
    }

    public String getPelo() {
        return this.pelo;
    }

    public String getPeso() {
        Float f = this.peso;
        return (f == null || f.floatValue() == 0.0f) ? "" : String.valueOf(this.peso);
    }

    public String getPiel() {
        return this.piel;
    }

    public String getPoblacion() {
        return this.poblacion;
    }

    public String getProvincia() {
        return this.provincia;
    }

    public String getSexo() {
        return this.sexo;
    }

    public String getTwoLineFormattName() {
        StringBuilder sb = new StringBuilder();
        sb.append(a.g(getNombre()));
        if (sb.length() > 0) {
            sb.append(10);
        }
        sb.append(a.g(getApellidos()));
        return sb.toString();
    }

    public boolean isPhotoEmpty() {
        return a.j(getFoto()) || "https://emybaby.com/app/fotos//bebe/".equals(getFoto());
    }

    public void setAltura(Float f) {
        this.altura = f;
    }

    public void setApellidos(String str) {
        this.apellidos = str;
    }

    public void setColorojos(String str) {
        this.colorojos = str;
    }

    public void setCp(String str) {
        this.cp = str;
    }

    public void setDomicilio(String str) {
        this.domicilio = str;
    }

    public void setFechanacimiento(String str) {
        this.fechanacimiento = str;
    }

    public void setFoto(String str) {
        this.foto = str;
    }

    public void setGinecologo(String str) {
        this.ginecologo = str;
    }

    public void setHospital(String str) {
        this.hospital = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setMatron(String str) {
        this.matron = str;
    }

    public void setMedidacabeza(Float f) {
        this.medidacabeza = f;
    }

    public void setNombre(String str) {
        this.nombre = str;
    }

    public void setPais(String str) {
        this.pais = str;
    }

    public void setPelo(String str) {
        this.pelo = str;
    }

    public void setPeso(Float f) {
        this.peso = f;
    }

    public void setPiel(String str) {
        this.piel = str;
    }

    public void setPoblacion(String str) {
        this.poblacion = str;
    }

    public void setProvincia(String str) {
        this.provincia = str;
    }

    public void setSexo(String str) {
        this.sexo = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.nombre);
        parcel.writeString(this.apellidos);
        parcel.writeString(this.fechanacimiento);
        parcel.writeString(this.sexo);
        parcel.writeFloat(this.altura.floatValue());
        parcel.writeFloat(this.peso.floatValue());
        parcel.writeFloat(this.medidacabeza.floatValue());
        parcel.writeString(this.colorojos);
        parcel.writeString(this.pelo);
        parcel.writeString(this.piel);
        parcel.writeString(this.domicilio);
        parcel.writeString(this.poblacion);
        parcel.writeString(this.cp);
        parcel.writeString(this.provincia);
        parcel.writeString(this.pais);
        parcel.writeString(this.hospital);
        parcel.writeString(this.ginecologo);
        parcel.writeString(this.matron);
        parcel.writeString(this.foto);
    }
}
