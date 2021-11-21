package com.jjrp.paises.placeholder;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;

import com.jjrp.paises.R;

import java.util.ArrayList;
import java.util.List;

public class PlaceholderContent {

    public static final List<Pais> PAISES = new ArrayList<Pais>();

    public PlaceholderContent(Resources resources, String packageName) {
        if (PAISES.size() == 0) {
            String[] countries = resources.getStringArray(R.array.paises);
            for (int i = 0; i < countries.length; i++) {
                PAISES.add(getItem(resources, packageName, countries[i], i));
            }
        }
    }

    private static Pais getItem(Resources resources, String packageName, String country, int id) {
        String[] countryDetail = resources.getStringArray(resources.getIdentifier(country, "array", packageName));
        return new Pais(id + "", countryDetail[0], countryDetail[1], countryDetail[2]);
    }


    public static class Pais implements Parcelable {
        public final String id;
        public final String nombre;
        public final String foto;
        public final String detalles;

        public Pais(String id, String nombre, String foto, String detalles) {
            this.id = id;
            this.nombre = nombre;
            this.foto = foto;
            this.detalles = detalles;
        }

        protected Pais(Parcel in) {
            id = in.readString();
            nombre = in.readString();
            foto = in.readString();
            detalles = in.readString();
        }

        public static final Creator<Pais> CREATOR = new Creator<Pais>() {
            @Override
            public Pais createFromParcel(Parcel in) {
                return new Pais(in);
            }

            @Override
            public Pais[] newArray(int size) {
                return new Pais[size];
            }
        };

        @Override
        public String toString() {
            return foto;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(id);
            parcel.writeString(nombre);
            parcel.writeString(foto);
            parcel.writeString(detalles);
        }
    }
}