/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sem6lab3.reactors;

/**
 *
 * @author User
 */
public class Reactor {
    private String reactorClass;
    private double burnup;
    private double kpd;
    private double enrichment;
    private double termal_capacity;
    private double electrical_capacity;
    private double life_time;
    private double first_load;
    private insertType fileType;

    public Reactor(String reactorClass, double burnup, double kpd, double enrichment, double termal_capacity, double electrical_capacity, double life_time, double first_load, insertType fileType) {
        this.reactorClass = reactorClass;
        this.burnup = burnup;
        this.kpd = kpd;
        this.enrichment = enrichment;
        this.termal_capacity = termal_capacity;
        this.electrical_capacity = electrical_capacity;
        this.life_time = life_time;
        this.first_load = first_load;
        this.fileType = fileType;                
    }

    public void setReactorClass(String Class) {
        reactorClass = Class;
    }

    public void setBurnup(double burnup) {
        this.burnup = burnup;
    }

    public void setKpd(double kpd) {
        this.kpd=kpd;
    }

    public void setEnrichment(double enrichment) {
        this.enrichment=enrichment;
    }

    public void setTermalCapacity(double termal_capacity) {
        this.termal_capacity=termal_capacity;
    }

    public void setElectricalCapacity(double electrical_capacity) {
        this.electrical_capacity=electrical_capacity;
    }

    public void setLifeTime(double life_time) {
        this.life_time=life_time;
    }

    public void setFirstLoad(double first_load) {
        this.first_load=first_load;
    }

    public void setFileType(insertType fileType) {
        this.fileType=fileType;
    }
    
    public String getReactorClass() {
        return "Class "+ reactorClass;
    }

    public String getBurnup() {
        return "burnup "+Double.toString(burnup);
    }

    public String getKpd() {
        return "kpd "+Double.toString(kpd);
    }

    public String getEnrichment() {
        return "enrichment "+Double.toString(enrichment);
    }

    public String getTermalCapacity() {
        return "termal_capacity "+Double.toString(termal_capacity);
    }

    public String getElectricalCapacity() {
        return "electrical_capacity "+ Double.toString(electrical_capacity);
    }

    public String getLifeTime() {
        return "life_time "+Double.toString(life_time);
    }

    public String getFirstLoad() {
        return "first_load "+Double.toString(first_load);
    }

    public String getFileType() {
        return "Тип файла импорта "+(fileType.toString());
    }

    public String getInfo() {
        return "Класс "+ reactorClass+' '+"Выгорание "+Double.toString(burnup)+' '+"КПД "+Double.toString(kpd)+' '+"Обогащение "+Double.toString(enrichment)+' '+"Термальная емкость "+Double.toString(termal_capacity)+' '+"Электрическая емкость "+Double.toString(electrical_capacity)+' '+"Время жизни "+Double.toString(life_time)+' '+"Первая загрузка "+Double.toString(first_load)+' '+"Тип файла импорта "+(fileType.toString());
    }
    
   
}
