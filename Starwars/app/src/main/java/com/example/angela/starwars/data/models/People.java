package com.example.angela.starwars.data.models;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Angela on 16/01/2018.
 */

public class People implements Serializable, Parcelable{

    public String name;
    public String height;
    public String mass;
    public String gender;

    @SerializedName("hair_color")
    public String hairColor;

    @SerializedName("skin_color")
    public String skinColor;

    @SerializedName("eye_color")
    public String eyeColor;

    @SerializedName("birth_year")
    public String birthYear;

    public static final Creator<People> CREATOR = new Creator<People>() {
        @Override
        public People createFromParcel(Parcel in) {
            return new People(in);
        }

        @Override
        public People[] newArray(int size) {
            return new People[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) { this.eyeColor = eyeColor; }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    public People(Parcel in) {
        this.name = in.readString();
        this.height = in.readString();
        this.mass = in.readString();
        this.hairColor = in.readString();
        this.skinColor = in.readString();
        this.eyeColor = in.readString();
        this.birthYear = in.readString();
        this.gender = in.readString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.height);
        parcel.writeString(this.mass);
        parcel.writeString(this.hairColor);
        parcel.writeString(this.skinColor);
        parcel.writeString(this.eyeColor);
        parcel.writeString(this.birthYear);
        parcel.writeString(this.gender);
    }
}
