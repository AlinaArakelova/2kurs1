package com.company;

public class MyArrayRowSizeException extends Exception {
    int i;

    public MyArrayRowSizeException(int i) {
        this.i = i;
    }
}