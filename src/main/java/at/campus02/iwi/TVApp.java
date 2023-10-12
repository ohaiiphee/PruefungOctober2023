package at.campus02.iwi;

public class TVApp {
    public static void main(String[] args) {
        LCD lcd1 = new LCD("LCD1", 55, 2020, 1500);
        LCD lcd2 = new LCD("LCD2", 76, 2023, 3500);

        OLED oled1 = new OLED("OLED1", 55, 2020, 2);
        OLED oled2 = new OLED("OLED2", 55, 2023, 4);

        Laser l1 = new Laser("Laser1", 55, 2020, false);
        Laser l2 = new Laser("Laser2", 75, 2023, true);

        lcd1.sold(2021);
        lcd2.sold(2023);
        oled1.sold(2021);
        oled2.sold(2023);
        l1.sold(2021);
        l2.sold(2023);

        System.out.println("Warranty of " + lcd1.modelName + " is " + lcd1.calculateWarranty());
        System.out.println("Warranty of " + lcd2.modelName + " is " + lcd2.calculateWarranty());

        System.out.println("Warranty of " + oled1.modelName + " is " + oled1.calculateWarranty());
        System.out.println("Warranty of " + oled2.modelName + " is " + oled2.calculateWarranty());

        System.out.println("Warranty of " + l1.modelName + " is " + l1.calculateWarranty());
        System.out.println("Warranty of " + l2.modelName + " is " + l2.calculateWarranty());

        System.out.println("   ");
        System.out.println("Price of " + lcd1.modelName + " is " + lcd1.calculatePrice(2023));
        System.out.println("Price of " + lcd2.modelName + " is " + lcd2.calculatePrice(2023));
        System.out.println("Price of " + oled1.modelName + " is " + oled1.calculatePrice(2023));
        System.out.println("Price of " + oled2.modelName + " is " + oled2.calculatePrice(2023));
        System.out.println("Price of " + l1.modelName + " is " + l1.calculatePrice(2023));
        System.out.println("Price of " + l2.modelName + " is " + l2.calculatePrice(2023));

        TVInventory tvi = new TVInventory();
        tvi.addTV(lcd1);
        tvi.addTV(lcd2);
        tvi.addTV(oled1);
        tvi.addTV(oled2);
        tvi.addTV(l1);
        tvi.addTV(l2);

        System.out.println(tvi.nrTV(true));

        System.out.println("The following TVs were sold in 2023: "+tvi.soldTVInYear(2023));

        System.out.println(tvi.inventoryPriceBySize(2023));
        System.out.println(tvi.givenPromotionsByYear());
        tvi.sortAndPrint();
    }
}
