package com.example.russ.m08_net_01.common;


import android.graphics.Color;

public enum NetColor {

    BLUE(22, 33, 44),
    RED(55, 44, 11),
    GREEN(66, 88, 99),
    WHITE(255, 255, 255),
    BLACK(0, 0, 0);

    private final int c_red;
    private final int c_green;
    private final int c_blue;

    NetColor() {
        this.c_red = 250;
        this.c_green = 200;
        this.c_blue = 33;
    }

    NetColor(int c) {
        this.c_red = (c & (255*256*256)) >> 16;
        this.c_green = (c & (255*256)) >> 8;
        this.c_blue = (c & 256);
    }

    NetColor(int r, int g, int b) {
        this.c_red = r;
        this.c_green = g;
        this.c_blue = b;
    }

    /**
     * AWT version
     *
     * @return
     */
    public int getColor() {
        int c = Color.rgb(c_red, c_blue, c_green);
        return c;
    }


}
