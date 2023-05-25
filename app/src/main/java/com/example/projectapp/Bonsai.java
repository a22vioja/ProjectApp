package com.example.projectapp;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("WeakerAccess")
public class Bonsai {
    @SerializedName("name")
    public String name;
    @SerializedName("ID")
    public String id;

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @SerializedName("size")
    public String height;

    @SerializedName("cost")
    public int price;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @SerializedName("category")
    public String category;

    @SerializedName("login")
    public String login;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @SerializedName("auxdata")
    public String image;



    public Bonsai(String name, String id, String height, int price, String category, String login, String image) {
        this.name = name;
        this.id = id;
        this.height = height;
        this.price = price;
        this.category = category;
        this.login = login;
        this.image = image;
    }

    public Bonsai(String name, int price){
        this.name = name;
        this.price = price;
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
    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }



}

