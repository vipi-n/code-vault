package practice.interviews;

import java.util.*;

/**
 * given a list of weekdays sort it with natural order
 */
public class SortWeekDays {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Monday", "Tuesday", "Sunday");
        Collections.sort(list, new SortDays());
        System.out.println(list);
    }
}
class SortDays implements Comparator<String>{
    HashMap<String, Integer> map;
    SortDays(){
         map = new HashMap<>();
         map.put("Sunday", 0);
        map.put("Monday", 1);
        map.put("Tuesday", 2);
        map.put("Wednesday", 3);
        map.put("Thursday", 4);
        map.put("Friday", 5);
        map.put("Saturday", 6);
    }
    public int compare(String s1, String s2){
        return map.get(s1).compareTo(map.get(s2));
    }
}
