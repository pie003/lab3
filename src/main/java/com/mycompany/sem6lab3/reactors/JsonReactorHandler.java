/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sem6lab3.reactors;

/**
 *
 * @author User
 */

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

public class JsonReactorHandler extends BaseReactorHandler {

    @Override
    public ArrayList<Reactor> handleFile(String filePath) throws Exception {
        if (filePath.endsWith(".json")) {
            ArrayList<Reactor> reactors = new ArrayList<>();
            try (Reader reader = new FileReader(filePath)) {
                StringBuilder content = new StringBuilder();
                int c;
                while ((c = reader.read()) != -1) {
                    content.append((char) c);
                }
                JSONObject jsonObject = new JSONObject(content.toString());

                JSONArray jsonArray = jsonObject.getJSONArray("Reactors");

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject reactorJson = jsonArray.getJSONObject(i);

                    Reactor reactor = new Reactor(
                        reactorJson.getString("reactorClass"),
                        reactorJson.getInt("burnup"),
                        reactorJson.getDouble("kpd"),
                        reactorJson.getDouble("enrichment"),
                        reactorJson.getInt("thermalCapacity"),
                        reactorJson.getInt("electricalCapacity"),
                        reactorJson.getInt("lifeTime"),
                        reactorJson.getInt("firstLoad"),
                        insertType.JSON
                    );

                    reactors.add(reactor);
                }
            }
            return reactors;
        } else if (nextHandler != null) {
            return nextHandler.handleFile(filePath);
        } else {
            throw new UnsupportedOperationException("Unsupported file format");
        }
    }
}




