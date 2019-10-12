package com.cathy.datanbindingdemo.bean;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class UserBean implements Serializable {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @NonNull
    @Override
    public String toString() {
        return "name=" + name + ";age=" + age;
    }
}
