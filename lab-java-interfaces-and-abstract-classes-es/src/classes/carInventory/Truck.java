package classes.carInventory;

public class Truck extends Car {
    private double towingCapacity;

    public Truck(String vinNumber, String make, String model, int mileage) {
        super(vinNumber, make, model, mileage);
        towingCapacity = 1000;
    }

    public Truck(String vinNumber, String make, String model, int mileage, double towingCapacity) {
        super(vinNumber, make, model, mileage);
        setTowingCapacity(towingCapacity);
    }

    public double getTowingCapacity() {
        return towingCapacity;
    }

    public void setTowingCapacity(double towingCapacity) {
        this.towingCapacity = towingCapacity;
    }

    @Override
    public String getInfo() {
        return "Truck Information:\nVin number: " + getVinNumber() + "\nMake: " + getMake()
                + "\nModel: " + getModel() + "\nMileage: " + getMileage() + "\nTowing Capacity: "
                + getTowingCapacity() + "\n-------------------\n";
    }
}
