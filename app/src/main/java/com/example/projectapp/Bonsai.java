package com.example.projectapp;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@SuppressWarnings("WeakerAccess")
public class Bonsai implements Serializable {
    @SerializedName("name")
    public String name;
    @SerializedName("ID")
    public String id;
    @SerializedName("size")
    public int height;
    @SerializedName("cost")
    public int price;
    @SerializedName("category")
    public String category;
    @SerializedName("login")
    public String login;
    @SerializedName("auxdata")
    public String image;


    public Bonsai(String name, String id, int size, int price, String category, String login, String image) {
        this.name = name;
        this.id = id;
        this.height = size;
        this.price = price;
        this.category = category;
        this.login = login;
        this.image = image;
    }

    public Bonsai(int size){
        this.height = size;
    }

  /*  public String info() {
        String tmp = new String();
        tmp += "Name:" + name + " ID:" + id + "Cost: " + price;
        return tmp;
    }*/

    /*
        public Bonsai(String name, String ID, int size, int price, Context context) {
            super(context);
            this.name = name;
            this.id = id;
            this.height = height;
            this.price = price;
        }

        public Bonsai(String s, String i, Context context) {
            super(context);
            name = "No name";
            id = "No id";
            height = "No height";
            price = 0;
        }
    */

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return name;
    }

    public int getPrice() {
        return price;
    }
    public String getImage() {
        return image;
    }

    public String getCategory() {
        return category;
    }

    public int getHeight() {
        return height;
    }

}

