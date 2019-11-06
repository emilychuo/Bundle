package com.example.bundle;

import android.os.Parcel;
import android.os.Parcelable;

public class AutoParcelable implements Parcelable {
    private String name;
    private int age;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.age);
    }

    public AutoParcelable() {
    }

    protected AutoParcelable(Parcel in) {
        this.name = in.readString();
        this.age = in.readInt();
    }

    public static final Parcelable.Creator<AutoParcelable> CREATOR = new Parcelable.Creator<AutoParcelable>() {
        @Override
        public AutoParcelable createFromParcel(Parcel source) {
            return new AutoParcelable(source);
        }

        @Override
        public AutoParcelable[] newArray(int size) {
            return new AutoParcelable[size];
        }
    };
}
