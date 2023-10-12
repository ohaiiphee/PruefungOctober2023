package at.campus02.iwi;

public class OLED  extends TV{
    protected int oledGeneration;

    public OLED(String modelName, int size, int productionYear, int oledGeneration) {
        super(modelName, size, productionYear);
        this.oledGeneration = oledGeneration;
    }

    public OLED(String modelName, int size, int productionYear, Promotion p, int oledGeneration) {
        super(modelName, size, productionYear, p);
        this.oledGeneration = oledGeneration;
    }

    public int getOledGeneration() {
        return oledGeneration;
    }

    @Override
    public int calculateWarranty() {
        int purchaseYear = TVDataBase.getPurchaseYear(serial);
        // oled Generation 4 has 5 years warranty
        if(oledGeneration == 4){
            return purchaseYear+5;
        }else {
        // everything else has 3 years warranty
            return purchaseYear+3;
        }
    }

    @Override
    public double calculatePrice(int year) {
        double price = 0;
        //tv up to 55
        if(size <= 55){
            if(getOledGeneration() == 1 || getOledGeneration() == 2){
                price = 1200;
            } else if(getOledGeneration() == 3){
                price = 1500;
            } else if(getOledGeneration() == 4){
                price = 2000;
            }
        //tv up to 65
        }else if(size <= 65){
            if(getOledGeneration() == 1 || getOledGeneration() == 2){
                price = 2500;
            }else if(getOledGeneration() == 3){
                price = 3200;
            } else if(getOledGeneration() == 4){
                price = 3500;
            }
        //tv up to 75
        }else if(size <= 75){
            if(getOledGeneration() == 1 || getOledGeneration() == 2){
                price = 4000;
            }else if(getOledGeneration() == 3){
                price = 5500;
            } else if(getOledGeneration() == 4){
                price = 8000;
            }
        }
        return price;
    }

    @Override
    public String toString() {
        return "OLED{" +
                "oledGeneration=" + oledGeneration +
                ", modelName='" + modelName + '\'' +
                ", size=" + size +
                ", productionYear=" + productionYear +
                ", p=" + p +
                ", serial='" + serial + '\'' +
                '}';
    }
}
