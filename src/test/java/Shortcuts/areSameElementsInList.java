package Shortcuts;

import java.util.HashSet;
import java.util.List;


public class areSameElementsInList {

    public static boolean isSame(List<String> list){

        for (String each : list){
            if (!each.equals(list.get(0))){
                return false;
            }
        }
                 return true;
    }

    public static boolean issame(List<String> list){
        return new HashSet<String>(list).size() <= 1;
    }
}
