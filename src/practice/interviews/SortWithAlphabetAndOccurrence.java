package practice.interviews;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * give a string print the string and occurrence of string in sorted order if occurrence is same then
 * sort in alphabetically
 *
 Input :    AAXbCXXXXxyC
 Output : X5 A2 C2 b1 x1 y1
 */
public class SortWithAlphabetAndOccurrence {
    public static void main(String[] args) {
        sort("AAXbCXXXXxyC");

    }

    public static void sort(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //map.entrySet().stream().sorted(new CompareMap()).forEach(System.out::println);
        map.entrySet().stream().sorted(
                (e1, e2) ->e1.getValue() == e2.getValue() ? e1.getKey().compareTo(e2.getKey()):
                        e2.getValue() - e1.getValue()).forEach(System.out::println);

    }

    static class CompareMap implements Comparator<Map.Entry<Character, Integer>>{
        public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2){
            return e1.getValue() == e2.getValue() ? e1.getKey().compareTo(e2.getKey()): e2.getValue() - e1.getValue();
        }
    }
    // with priorityQueue
    public void sorting(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(
                (e1, e2) ->e1.getValue() == e2.getValue() ? e1.getKey().compareTo(e2.getKey()):
                        e2.getValue() - e1.getValue());
        queue.addAll(map.entrySet());
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()){
            Map.Entry<Character, Integer> m = queue.poll();
            for (int i = 0; i < m.getValue() ; i++) {
                stringBuilder.append(m.getKey());
            }
        }

    }


}
