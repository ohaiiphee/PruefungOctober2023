package at.campus02.iwi;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TVInventory {
    private ArrayList<TV> devices;

    public TVInventory() {
        devices = new ArrayList<TV>();
    }

    public void addTV(TV t) {
        devices.add(t);
    }

    public int nrTV(boolean sold){
        //checks which tvs in the list were sold and returns that value
        int total = 0;
        for (TV t:devices) {
            if(TVDataBase.getPurchaseYear(t.serial) != -1){
                total++;
            }
        }
        //if no tvs in the list were sold, return all tvs
        if(total == 0){
            return devices.size();
        }

        return total;
    }

    public ArrayList<TV> soldTVInYear(int year){
        //create a new list
        ArrayList<TV> extraList = new ArrayList<TV>();

        //put every tv with purchase year matching parameter year in extraList
        for (TV t:devices) {
            if(TVDataBase.getPurchaseYear(t.getSerial()) == year){
                extraList.add(t);
            }
        }
        //return new list
        return extraList;
    }

    public HashMap<Integer, Double> inventoryPriceBySize(int year){
        HashMap<Integer, Double> hm = new HashMap<Integer, Double>();
        for (TV t: devices) {
            int zoll = t.size;
            double price = t.calculatePrice(year);
            hm.put(zoll, price);

        }
        return hm;
    }

    public HashMap<Integer, Integer> givenPromotionsByYear(){
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int amount = 1;
        for (TV t:devices) {
            //check if tv has promotion
                if(hm.containsKey(TVDataBase.getPurchaseYear(t.getSerial()))){
                hm.put(TVDataBase.getPurchaseYear(t.getSerial()), amount+1);
            }else{
                    hm.put(TVDataBase.getPurchaseYear(t.getSerial()), amount);
                }

        }
        return null;
    }

    public void sortAndPrint(){
        Collections.sort(devices, new TVComparator());
        System.out.println(devices);
    }
}
