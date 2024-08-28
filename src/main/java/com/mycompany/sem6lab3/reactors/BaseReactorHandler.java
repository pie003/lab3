/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sem6lab3.reactors;

/**
 *
 * @author User
 */
import java.util.ArrayList;

public abstract class BaseReactorHandler implements ReactorHandler {
    protected ReactorHandler nextHandler;

    @Override
    public void setNext(ReactorHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public ArrayList<Reactor> handleFile(String filePath) throws Exception {
        if (nextHandler != null) {
            return nextHandler.handleFile(filePath);
        } else {
            throw new UnsupportedOperationException("No handler available for file format");
        }
    }
}

