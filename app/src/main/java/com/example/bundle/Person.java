package com.example.bundle;

import java.io.Serializable;

public class Person implements Serializable {
    private String mName;
    private int mAge;

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int mAge) {
        this.mAge = mAge;
    }
}
