package com.cuatroochenta.miniland.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;

public class MyProfile implements Parcelable {
    public static final Parcelable.Creator<MyProfile> CREATOR = new Parcelable.Creator<MyProfile>() {
        public MyProfile createFromParcel(Parcel parcel) {
            return new MyProfile(parcel);
        }

        public MyProfile[] newArray(int i) {
            return new MyProfile[i];
        }
    };
    public String address;
    public String birthDate;
    public String children;
    public String countryCode;
    public String name;
    public String phone;
    public String postalCode;
    public String province;
    public String surname;
    public String town;

    public MyProfile() {
    }

    public MyProfile(Parcel parcel) {
        this.name = parcel.readString();
        this.surname = parcel.readString();
        this.birthDate = parcel.readString();
        this.countryCode = parcel.readString();
        this.children = parcel.readString();
        this.phone = parcel.readString();
        this.address = parcel.readString();
        this.postalCode = parcel.readString();
        this.town = parcel.readString();
        this.province = parcel.readString();
    }

    public MyProfile(JSONObject jSONObject) {
        this.name = jSONObject.optString("nombre");
        this.surname = jSONObject.optString("apellidos");
        this.birthDate = jSONObject.optString("fechanacimiento");
        this.countryCode = jSONObject.optString("pais");
        this.children = jSONObject.optString("hijos");
        this.phone = jSONObject.optString("telefono");
        this.address = jSONObject.optString("direccion");
        this.postalCode = jSONObject.optString("codigopostal");
        this.town = jSONObject.optString("localidad");
        this.province = jSONObject.optString("provincia");
    }

    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.address;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public String getChildren() {
        return this.children;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public String getProvince() {
        return this.province;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getTown() {
        return this.town;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setBirthDate(String str) {
        this.birthDate = str;
    }

    public void setChildren(String str) {
        this.children = str;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setPostalCode(String str) {
        this.postalCode = str;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public void setSurname(String str) {
        this.surname = str;
    }

    public void setTown(String str) {
        this.town = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.surname);
        parcel.writeString(this.birthDate);
        parcel.writeString(this.countryCode);
        parcel.writeString(this.children);
        parcel.writeString(this.phone);
        parcel.writeString(this.address);
        parcel.writeString(this.postalCode);
        parcel.writeString(this.town);
        parcel.writeString(this.province);
    }
}
