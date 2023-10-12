package at.campus02.iwi;

import java.util.Random;

// *****
// genau diesen Code statt *zufall* einsetzen.
// einfach Inhalt kopieren
//
// new Random().nextInt(100000)
//
// *****
public abstract class TV {

    protected String modelName;
    protected int size;
    protected int productionYear;
    protected Promotion p;
    protected String serial;

    public TV(String modelName, int size, int productionYear) {
        this.modelName = modelName;
        this.size = size;
        this.productionYear = productionYear;
        this.p = null;
        serial = size+"_"+modelName+"_"+new Random().nextInt(100000);
        TVDataBase.registerFactory(serial);
    }

    public TV(String modelName, int size, int productionYear, Promotion p) {
        this.modelName = modelName;
        this.size = size;
        this.productionYear = productionYear;
        this.p = p;
        serial = size+"_"+modelName+"_"+new Random().nextInt(100000);
        TVDataBase.registerFactory(serial);
    }

    public String getModelName() {
        return modelName;
    }

    public int getSize() {
        return size;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public Promotion getP() {
        return p;
    }

    public String getSerial() {
        return serial;
    }

    public abstract int calculateWarranty();

    public abstract double calculatePrice(int year);

    public boolean sold(int year){
        if(TVDataBase.registerConsumer(serial, year)){
            return true;
        } else return false;
    }


}
