package practice.random;

import javax.swing.*;
import java.util.*;

public class FileIO {

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        
        list.add(new Student("Vipin", 10, "tifth"));
        list.add(new Student("Agnes", 1, "five"));
        list.add(new Student("Tom", 15, "twelve"));

        Collections.sort(list, (o1,o2) -> o1.age.compareTo(o2.age));
        //Collections.sort(list, Comparator.comparing(o ->o.getId()));
        //System.out.println(list);
        list.stream().filter(l -> l.getAge().startsWith("t")).forEach(System.out::println);

        HashMap<String , Integer> map = new HashMap<>();
        map.put("Vipin", 25);
        map.put("kumar", 20);
        map.put("Hitesh", 18);

        map.entrySet().forEach(System.out::println);
        map.forEach((key, value) -> System.out.println("key " +key+ " value " +value));
        map.entrySet().stream().filter(m -> m.getValue() > 20).forEach(System.out::println);

        System.out.println("------------sort--------");

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(25);
        arrayList.add(2);
        arrayList.add(250);
        arrayList.add(5);
        arrayList.add(28);

        arrayList.stream().sorted().forEach(System.out::println);
        arrayList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        //

        list.stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).forEach(System.out::println);
        list.stream().sorted(Comparator.comparing(s -> s.getId())).forEach(System.out::println);
        list.stream().sorted(Comparator.comparing(Student::getName)).forEach(System.out::println);

        System.out.println("------------sort Map--------");

        map.entrySet().stream().sorted(Comparator.comparing(m -> m.getKey())).forEach(System.out::println);
        map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).forEach(System.out::println);
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
    }


}
