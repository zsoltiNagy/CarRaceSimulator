package CarRaceSimulator;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;

public class CarRaceSimulator {
    static HashMap< Integer, Truck> trucks = new HashMap<>();
    static HashMap< Integer, Motorcycle> motorcycles = new HashMap<>();
    static HashMap< Integer, Car> cars = new HashMap<>();
    static boolean isRaining; //isRaining 30% chance of rain every hour
    static Random truckName = new Random();
    static Integer numberOfVehiclesByType = 0;
    public static void main(String[] args) {
        numberOfVehiclesByType = 10;
        createVehicles(); // creates 10 cars, 10 trucks and 10 motorcycles
        simulateRace(50); // simulates the race by calling moveForAnHour() on every vehicle 50 times and setting whether its raining.
        printRaceResults(); // prints each vehicle's name, distance traveled ant type.
    }

    public static void createVehicles(){
        for (Integer i = 0; i < numberOfVehiclesByType; i++) {
            trucks.put(i, new Truck());
            trucks.get(i).setName(String.valueOf(truckName.nextInt(1000)));
            motorcycles.put(i, new Motorcycle());
            motorcycles.get(i).setName();
            cars.put(i, new Car());
            cars.get(i).setName();
            cars.get(i).setNormalSpeed();
        }
    }

    public static void simulateRace(int finalHour){
        for (int hour = 0; hour < finalHour; hour++) {
            double rainChance = Math.random() * 100;
            if (rainChance >= 70) {
                isRaining = true;
            } else {
                isRaining = false;
            }
            for (Integer i = 0; i < numberOfVehiclesByType; i++) {
                trucks.get(i).moveForAnHour();
                motorcycles.get(i).moveForAnHour(isRaining);
                cars.get(i).moveForAnHour(cars.get(i).setSpeedLimit(70));
            }
        }
    }

    public static void printRaceResults(){
        TreeMap<Integer, String>results = new TreeMap<>();
        for (Integer j = 0; j< numberOfVehiclesByType; j++) {
            if (results.containsKey(cars.get(j).distanceTraveled)) {
                results.put(cars.get(j).distanceTraveled,
                            results.get(cars.get(j).distanceTraveled)
                            + ", "
                            + cars.get(j).name);
            } else {
                results.put(cars.get(j).distanceTraveled, cars.get(j).name);
            }
            if (results.containsKey(trucks.get(j).distanceTraveled)) {
                results.put(trucks.get(j).distanceTraveled,
                            results.get(trucks.get(j).distanceTraveled)
                            + ", "
                            + trucks.get(j).name);
            } else {
                results.put(trucks.get(j).distanceTraveled, trucks.get(j).name);
            }
            if (results.containsKey(motorcycles.get(j).distanceTraveled)) {
                results.put(motorcycles.get(j).distanceTraveled,
                        results.get(motorcycles.get(j).distanceTraveled)
                                + ", "
                                + motorcycles.get(j).name);
            } else {
                results.put(motorcycles.get(j).distanceTraveled, motorcycles.get(j).name);
            }
        }
        int thisIsTheEnd = results.size();
        for (int i = 0; i < thisIsTheEnd; i++) {
            System.out.println("Rank: "+String.valueOf(i+1)+"#");
            System.out.println("Distance travelled: " + String.valueOf(results.lastKey()));
            System.out.println("Name(s): " + results.get(results.lastKey()));
            results.remove(results.lastKey());
        }
    }
}