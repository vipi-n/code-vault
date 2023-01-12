package practice.interviews.immutability;

import java.util.HashMap;
import java.util.Map;

/*
https://www.geeksforgeeks.org/create-immutable-class-java/
 */
final class ImmutableClass {

    // Member attributes of final class
    private final String name;
    private final int regNo;
    private final Map<String, String> metadata;

    //final List<String> courses;  -- if contains list

    // Constructor of immutable class
    // Parameterized constructor
    public ImmutableClass(String name, int regNo,
                          Map<String, String> metadata /*, List<String> courses*/) {

        // This keyword refers to current instance itself
        this.name = name;
        this.regNo = regNo;
        //this.courses = new ArrayList(courses);

        // Creating Map object with reference to HashMap Declaring object of string type
        Map<String, String> tempMap = new HashMap<>();

        // Iterating using for-each loop
        for (Map.Entry<String, String> entry :
                metadata.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }

        this.metadata = tempMap;
    }

    public String getName() {
        return name;
    }

    public int getRegNo() {
        return regNo;
    }

    /*
    public List<String> getCourses() {
        return new ArrayList(courses);
    }*/

    // Note that there should not be any setters
    public Map<String, String> getMetadata() {

        // Creating Map with HashMap reference
        Map<String, String> tempMap = new HashMap<>();

        for (Map.Entry<String, String> entry :
                this.metadata.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        return tempMap;
    }
}

class GFG {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();

        // Adding elements to Map object
        // using put() method
        map.put("1", "first");
        map.put("2", "second");

        ImmutableClass s = new ImmutableClass("ABC", 101, map);

        // Calling the above methods 1,2,3 of class1
        // inside main() method in class2 and
        // executing the print statement over them
        System.out.println(s.getName());
        System.out.println(s.getRegNo());
        System.out.println(s.getMetadata());

        // Uncommenting below line causes error
        // s.regNo = 102;

        map.put("3", "third");
        // Remains unchanged due to deep copy in constructor
        System.out.println(s.getMetadata());
        s.getMetadata().put("4", "fourth");
        // Remains unchanged due to deep copy in getter
        System.out.println(s.getMetadata());
    }
}


