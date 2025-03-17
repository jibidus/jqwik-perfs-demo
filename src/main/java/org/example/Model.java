package org.example;

import java.util.Objects;

public class Model {
    int integer1;
    int integer2;
    int integer3;
    int integer4;
    int integer5;
    int integer6;
    int integer7;
    int integer8;
    int integer9;

    public Model(int integer1, int integer2, int integer3, int integer4, int integer5, int integer6, int integer7, int integer8, int integer9) {
        this.integer1 = integer1;
        this.integer2 = integer2;
        this.integer3 = integer3;
        this.integer4 = integer4;
        this.integer5 = integer5;
        this.integer6 = integer6;
        this.integer7 = integer7;
        this.integer8 = integer8;
        this.integer9 = integer9;
    }

    @Override
    public String toString() {
        return "Model{" +
                "integer1=" + integer1 +
                ", integer2=" + integer2 +
                ", integer3=" + integer3 +
                ", integer4=" + integer4 +
                ", integer5=" + integer5 +
                ", integer6=" + integer6 +
                ", integer7=" + integer7 +
                ", integer8=" + integer8 +
                ", integer9=" + integer9 +
                '}';
    }
}
