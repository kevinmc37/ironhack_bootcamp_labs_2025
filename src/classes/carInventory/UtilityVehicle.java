package classes.carInventory;

public class UtilityVehicle extends Car {
    private boolean fourWheelDrive;

    public UtilityVehicle(String vinNumber, String make, String model, int mileage) {
        super(vinNumber, make, model, mileage);
        this.fourWheelDrive = false;
    }

    public UtilityVehicle(String vinNumber, String make, String model, int mileage, boolean fourWheelDrive) {
        super(vinNumber, make, model, mileage);
        setFourWheelDrive(fourWheelDrive);
    }

    public boolean isFourWheelDrive() {
        return fourWheelDrive;
    }

    public void setFourWheelDrive(boolean fourWheelDrive) {
        this.fourWheelDrive = fourWheelDrive;
    }

    @Override
    public String getInfo() {
        return "Utility Vehicle Information:\nVin number: " + getVinNumber() + "\nMake: " + getMake()
                + "\nModel: " + getModel() + "\nMileage: " + getMileage() + "\nIs Four Wheel Drive?: "
                + isFourWheelDrive() + "\n-------------------\n";
    }
}
