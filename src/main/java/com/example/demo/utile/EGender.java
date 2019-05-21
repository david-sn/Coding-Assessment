package com.example.demo.utile;

/**
 *
 * @author david
 */
public enum EGender {

    MALE('m'), FEMALE('f');
    private final char gender;

    EGender(char levelCode) {
        this.gender = levelCode;
    }

    public char getGender() {
        return gender;
    }

}
