import java.util.ArrayList;
import java.util.List;

abstract class Vehicle {
    private String vehicleId;
    private String make;
    private String model;
    private double baseRentalRate;

    public Vehicle(String vehicleId, String make, String model, double baseRentalRate) {
        this.vehicleId = vehicleId;
        this.make = make;
        this.model = model;
        this.baseRentalRate = baseRentalRate;
    }

    public Vehicle(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleId() {
         return vehicleId; 
         }
    public String getMake() { 
        return make; 
        }
    public String getModel() { 
        return model; 
        }
    public double getBaseRentalRate() { 
        return baseRentalRate; 
        }

    public abstract double calculateRentalPrice(int days);

    @Override
    public String toString() {
        return String.format("ID: %s | %s %s | Base Rate: $%.2f/day", 
                             vehicleId, make, model, baseRentalRate);
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }
}

class Car extends Vehicle {
    public Car(String id, String make, String model, double rate) {
        super(id, make, model, rate);
    }

    @Override
    public double calculateRentalPrice(int days) {
        return getBaseRentalRate() * days; // Standard rate
    }
}

class Bike extends Vehicle {
    public Bike(String id, String make, String model, double rate) {
        super(id, make, model, rate);
    }

    @Override
    public double calculateRentalPrice(int days) {
        return (getBaseRentalRate() * days) * 0.9; // 10% discount for bikes
    }
}

class Truck extends Vehicle {
    private final double cargoCapacity;

    public Truck(String id, String make, String model, double rate, double cargoCapacity) {
        super(id, make, model, rate);
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public double calculateRentalPrice(int days) {
        return (getBaseRentalRate() * days) + (cargoCapacity * 2); // Price + cargo fee
    }
}

class RentalSystem {
    private final List<Vehicle> vehicles;

    public RentalSystem() {
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void rentVehicle(String vehicleId, int days) {
        for (Vehicle v : vehicles) {
            if (v.getVehicleId().equals(vehicleId)) {
                double price = v.calculateRentalPrice(days);
                System.out.println("Rented: " + v.getMake() + " " + v.getModel() + 
                                   " for " + days + " days. Total: $" + price);
                return;
            }
        }
        System.out.println("Vehicle ID " + vehicleId + " not found.");
    }

    public void displayVehicles() {
        System.out.println("\n--- Available Vehicles ---");
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        RentalSystem system = new RentalSystem();

        system.addVehicle(new Car("C01", "Toyota", "Camry", 150.0));
        system.addVehicle(new Bike("B01", "Yamaha", "R15", 20.0));
        system.addVehicle(new Truck("T01", "Ford", "F-150", 100.0, 500.0));

        system.displayVehicles();

        System.out.println("\n--- Processing Rentals ---");
        system.rentVehicle("C01", 15);
        system.rentVehicle("B01", 3);
        system.rentVehicle("T01", 2);
    }
}
