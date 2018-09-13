package com.example.pokemoon.sqlite05_09;

import java.sql.Date;

public interface ISaleModel {
    int getId();
    String getBuyer();
    int getQuantity();
    Date getDate();
    int getProductId();
}
