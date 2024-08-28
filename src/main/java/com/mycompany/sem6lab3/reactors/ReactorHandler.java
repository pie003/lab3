/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sem6lab3.reactors;

import java.util.ArrayList;

/**
 *
 * @author User
 */

public interface ReactorHandler {
    void setNext(ReactorHandler nextHandler);
    ArrayList<Reactor> handleFile(String filePath) throws Exception;
}


