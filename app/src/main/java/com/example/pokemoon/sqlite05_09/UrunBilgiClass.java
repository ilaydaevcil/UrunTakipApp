package com.example.pokemoon.sqlite05_09;

public class UrunBilgiClass {
    int key;
    String urunadi;
    int adet;
    int fiyat;


    public UrunBilgiClass(String urunadi, int adet, int fiyat) {
        this.urunadi = urunadi;
        this.adet = adet;
        this.fiyat = fiyat;
    }

    public UrunBilgiClass(int ınt, String string, int dataInt, int i) {
this.urunadi=string;
this.key=ınt;
this.adet=i;
this.fiyat=dataInt;

    }

    public UrunBilgiClass() {

    }


    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getUrunadi() {
        return urunadi;
    }

    public void setUrunadi(String urunadi) {
        this.urunadi = urunadi;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }



}
