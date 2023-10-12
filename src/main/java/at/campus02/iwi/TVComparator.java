package at.campus02.iwi;

import java.util.Comparator;

public class TVComparator  implements Comparator<TV> {

    @Override
    public int compare(TV o1, TV o2) {
        //compare sold with not sold
        int s = Integer.compare(TVDataBase.getPurchaseYear(o1.serial), TVDataBase.getPurchaseYear(o2.serial));

        //the not sold get sorted by production year
        if(s == -1 ){
            return Integer.compare(o2.productionYear, o1.productionYear);
        }
        return s;
    }
}
