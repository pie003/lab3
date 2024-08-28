/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sem6lab3.reactors;
import java.io.FileInputStream;
import org.yaml.snakeyaml.Yaml;
/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.Map;

public class YamlReactorHandler extends BaseReactorHandler {

    @Override
    public ArrayList<Reactor> handleFile(String filePath) throws Exception {
        if (filePath.endsWith(".yaml") || filePath.endsWith(".yml")) {
            try (FileInputStream inputStream = new FileInputStream(filePath)) {
                Yaml yaml = new Yaml();
                ArrayList<Map<String, Object>> data = yaml.load(inputStream);

                ArrayList<Reactor> reactors = new ArrayList<>();
                for (Map<String, Object> entry : data) {
                    Reactor reactor = new Reactor(
                        (String) entry.get("class"),
                        ((Number) entry.get("burnup")).intValue(),
                        ((Number) entry.get("kpd")).doubleValue(),
                        ((Number) entry.get("enrichment")).doubleValue(),
                        ((Number) entry.get("termal_capacity")).intValue(),
                        ((Number) entry.get("electrical_capacity")).intValue(),
                        ((Number) entry.get("life_time")).intValue(),
                        ((Number) entry.get("first_load")).intValue(),
                        insertType.YAML
                    );
                    reactors.add(reactor);
                }
                return reactors;
            }
        } else if (nextHandler != null) {
            return nextHandler.handleFile(filePath);
        } else {
            throw new UnsupportedOperationException("Unsupported file format");
        }
    }
}

