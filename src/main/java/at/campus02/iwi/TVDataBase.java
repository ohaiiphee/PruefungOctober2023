package at.campus02.iwi;

import java.util.ArrayList;
import java.util.HashMap;
// *************
// *************
// *************
// DO NOT CHANGE ANYTHING IN HERE - JUST USE THE METHODS
// *************
// *************
// *************
public class TVDataBase {
    private static ArrayList<String> tvProduced = new ArrayList<>();
    private static HashMap<String, Integer> tvConsumerRegistered = new HashMap<>();

    public static boolean registerFactory(String serial){
        if (tvProduced.contains(serial)){
            return false;
        }
        tvProduced.add(serial);
        return true;
    }

    public static boolean registerConsumer(String serial, int purchaseYear){
        if (tvProduced.contains(serial)){
            tvConsumerRegistered.put(serial, purchaseYear);
            return true;
        }
        return false;
    }
    public static int getPurchaseYear(String serial){
        return tvConsumerRegistered.getOrDefault(serial, -1);
    }
}
