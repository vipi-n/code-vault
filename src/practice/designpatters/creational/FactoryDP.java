package practice.designpatters.creational;

public class FactoryDP {
}

abstract class Vehicle1 {
    public abstract int getWheel();

    public String toString() {
        return "Wheel: " + this.getWheel();
    }
}

class Car extends Vehicle1 {
    int wheel;

    Car(int wheel) {
        this.wheel = wheel;
    }


    public int getWheel() {
        return this.wheel;
    }
}

class Bike extends Vehicle1 {
    int wheel;

    Bike(int wheel) {
        this.wheel = wheel;
    }


    public int getWheel() {
        return this.wheel;
    }
}

class VehicleFactory {
    public static Vehicle1 getInstance(String type, int wheel) {
        if(type == "car") {
            return new Car(wheel);
        } else if(type == "bike") {
            return new Bike(wheel);
        }

        return null;
    }
}

class FactoryPatternExample {

    public static void main(String[] args) {
        Vehicle1 car = VehicleFactory.getInstance("car", 4);
        System.out.println(car);

        Vehicle1 bike = VehicleFactory.getInstance("bike", 2);
        System.out.println(bike);
    }

}
