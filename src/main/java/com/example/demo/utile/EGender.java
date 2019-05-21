/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
