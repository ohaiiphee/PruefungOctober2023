package at.campus02.iwi;

public class Laser extends TV{
    protected boolean highResolution;

    public Laser(String modelName, int size, int productionYear, boolean highResolution) {
        super(modelName, size, productionYear);
        this.highResolution = highResolution;
    }

    public Laser(String modelName, int size, int productionYear, Promotion p, boolean highResolution) {
        super(modelName, size, productionYear, p);
        this.highResolution = highResolution;
    }

    public boolean isHighResolution() {
        return highResolution;
    }

    @Override
    public int calculateWarranty() {
        int purchaseYear = TVDataBase.getPurchaseYear(serial);
        // if sold in 2022, has 7 years warranty
        if(purchaseYear == 2022){
            return purchaseYear+7;
        // otherwise, if it has high resolution, has 5 years warranty
        } else if(isHighResolution()){
            return purchaseYear+5;
        } else {
        // everything else has 3 years warranty
            return purchaseYear+3;
        }
    }

    @Override
    public double calculatePrice(int year) {
        double price = 0;
        if(highResolution){
            price = 9500;
        } else {
            price = 4000;
        }

        //check if tv is from a previous year to see if it gets a discount
        int diff = TVDataBase.getPurchaseYear(serial)-getProductionYear();
        if(diff == 1){
            price = price - (price*0.40);
        }
        return price;
    }

    @Override
    public String toString() {
        return "Laser{" +
                "highResolution=" + highResolution +
                ", modelName='" + modelName + '\'' +
                ", size=" + size +
                ", productionYear=" + productionYear +
                ", p=" + p +
                ", serial='" + serial + '\'' +
                '}';
    }
}
