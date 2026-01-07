abstract class Vehicle {
    private String brand;
    private int speed;

    public Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public int getSpeed() { return speed; }
    public void setSpeed(int speed) { this.speed = speed; }

    public abstract void move();
}

interface Fuel {
    void refuel(String type);
}

class Car extends Vehicle implements Fuel {
    private int doors;

    public Car(String brand, int speed, int doors) {
        super(brand, speed);
        this.doors = doors;
    }

    public int getDoors() { return doors; }

    @Override
    public void move() {
        System.out.println(getBrand() + " car drives at " + getSpeed() + " km/h with " + doors + " doors.");
    }

    @Override
    public void refuel(String type) {
        System.out.println(getBrand() + " car refueled with " + type);
    }
}

class Bike extends Vehicle implements Fuel {
    private boolean hasGear;

    public Bike(String brand, int speed, boolean hasGear) {
        super(brand, speed);
        this.hasGear = hasGear;
    }

    public boolean getHasGear() { return hasGear; }

    @Override
    public void move() {
        System.out.println(getBrand() + " bike rides at " + getSpeed() + " km/h. Gear: " + hasGear);
    }

    @Override
    public void refuel(String type) {
        System.out.println(getBrand() + " bike refueled with " + type);
    }
}

public class OOPDemo {
    public static void main(String[] args) {
        Vehicle v1 = new Car("Toyota", 120, 4);
        Vehicle v2 = new Bike("Yamaha", 80, true);

        v1.move();
        v2.move();

        if (v1 instanceof Car) {
            ((Car) v1).refuel("Petrol");
        }
        if (v2 instanceof Bike) {
            ((Bike) v2).refuel("Petrol");
        }

        v1.setSpeed(130);
        System.out.println(v1.getBrand() + " new speed: " + v1.getSpeed());
    }
}