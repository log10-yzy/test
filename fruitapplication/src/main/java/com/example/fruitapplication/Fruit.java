package com.example.fruitapplication;

public class Fruit {
    String name;
    private int res;

    public Fruit(String name, int res) {
        this.name = name;
        this.res = res;
    }

    public Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", res=" + res +
                '}';
    }
}
