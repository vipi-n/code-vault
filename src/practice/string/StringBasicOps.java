package practice.string;

public class StringBasicOps {

    public static void main(String[] args) {

        String s = "Vipin";
        String s1 = s;
        System.out.println("s1 is " +s1+ " and hashcode is " +s1.hashCode());
        s1 = s1 + "kumar";
        System.out.println("s1 is " +s1+ " and hashcode is " +s1.hashCode());

        String name = new String("Biplob");
        System.out.println(name.hashCode());
        name = name + "rohan";
        System.out.println("name is " +name+ " and the hashcode is " +name.hashCode());

        String str = "India";
        String str1 = new String("India");
        String str2 = str + str1;
        System.out.println(str == str1);
        System.out.println(str2 + " hashcode is " + str2.hashCode());
    }
}
