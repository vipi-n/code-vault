package practice.designpatters.creational;

import java.util.ArrayList;
import java.util.List;

// when you want to avoid multiple object creation for same instance-clone
// instead yu copy the object to new object and then we can modify as our need
public class PrototypeDP {
}

class Vehicle3 implements Cloneable {
    private List<String> vehicleList;

    public Vehicle3() {
        this.vehicleList = new ArrayList<>();
    }

    public Vehicle3(List<String> list) {
        this.vehicleList = list;
    }

    public void insertData() {
        vehicleList.add("Honda amaze");
        vehicleList.add("Audi A4");
        vehicleList.add("Hyundai Creta");
        vehicleList.add("Maruti Baleno");
        vehicleList.add("Renault Duster");
    }

    public List<String> getVehicleList() {
        return this.vehicleList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        List<String> tempList = new ArrayList<String>();

        for(String s : this.getVehicleList()) {
            tempList.add(s);
        }

        return new Vehicle3(tempList);
    }
}

 class PrototypePatternExample {

    public static void main(String[] args) throws CloneNotSupportedException {
        Vehicle3 a = new Vehicle3();
        a.insertData();

        Vehicle3 b = (Vehicle3) a.clone();
        List<String> list = b.getVehicleList();
        list.add("Honda new Amaze");

        System.out.println(a.getVehicleList());
        System.out.println(list);

        b.getVehicleList().remove("Audi A4");
        System.out.println(list);
        System.out.println(a.getVehicleList());
    }

}
