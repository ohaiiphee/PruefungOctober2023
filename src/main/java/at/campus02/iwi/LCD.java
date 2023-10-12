package at.campus02.iwi;

public class LCD extends TV {
    protected int nrLed;


    public LCD(String modelName, int size, int productionYear, int nrLed) {
        super(modelName, size, productionYear);
        this.nrLed = nrLed;
    }

    public LCD(String modelName, int size, int productionYear, Promotion p, int nrLed) {
        super(modelName, size, productionYear, p);
        this.nrLed = nrLed;
    }

    public int getNrLed() {
        return nrLed;
    }

    @Override
    public int calculateWarranty() {
        int purchaseYear = TVDataBase.getPurchaseYear(serial);
        if(sold(purchaseYear)){
            if (purchaseYear < 2023) {
                // if sold before 2023, has 2 years warranty
                return TVDataBase.getPurchaseYear(serial) + 2;
            } else {
                // everything else has 3 years warranty
                return purchaseYear + 3;
            }
        }
        else return 0;
    }

    @Override
    public double calculatePrice(int year) {
        double basePrice = 900;
        //if size is up to 55, price is 900
        if (size <= 55) {
            basePrice = 900;
            //else if size is up to 65, price goes up+500
        } else if (size <= 65) {
            basePrice += 500;
            //else if size is up to 75, price goes up+1700
        } else if (size <= 75) {
            basePrice += 500;
        }

        //year difference between when bought and when produced
        int diff = TVDataBase.getPurchaseYear(serial) - productionYear;

        switch (diff) {
            //1 year old
            case 1:
                if (nrLed >= 2000) {
                    //5% discount
                    basePrice = basePrice - (basePrice * 0.05);
                } else {
                    //10% discount
                    basePrice = basePrice - (basePrice * 0.10);
                }
                break;
            //2 years old
            case 2:
                if (nrLed >= 2000) {
                    //10% discount
                    basePrice = basePrice - (basePrice * 0.10);
                } else {
                    basePrice = basePrice - (basePrice * 0.20);
                }
                break;
            //3 years old
            case 3:
                if (nrLed >= 2000) {
                    //15% discount
                    basePrice = basePrice - (basePrice * 0.15);
                } else {
                    basePrice = basePrice - (basePrice * 0.30);
                }
                break;
            //4 years old
            case 4:
                if (nrLed >= 2000) {
                    //20% discount
                    basePrice = basePrice - (basePrice * 0.20);
                } else {
                    basePrice = basePrice - (basePrice * 0.40);
                }
                break;
        }
        //for tvs 5 years old or more, max 50% discount
        if (diff >= 5) {
            if(nrLed >=2000){
                //25% discount
                basePrice = basePrice - (basePrice*0.25);
            } else {
                basePrice = basePrice - (basePrice * 0.50);
            }
        }
        return basePrice;
    }

    @Override
    public String toString() {
        return "LCD{" +
                "nrLed=" + nrLed +
                ", modelName='" + modelName + '\'' +
                ", size=" + size +
                ", productionYear=" + productionYear +
                ", p=" + p +
                ", serial='" + serial + '\'' +
                '}';
    }
}
