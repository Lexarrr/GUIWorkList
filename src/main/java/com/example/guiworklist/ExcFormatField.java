package com.example.guiworklist;

public class ExcFormatField extends Exception{

    int badExpirience;


    public ExcFormatField(int badData) {
        this.badExpirience = badData;

    }

    @Override
    public String toString() {
        return "ExcFormatField{" +
                "badExpirience='" + badExpirience + '\'' +
                '}';
    }
}

