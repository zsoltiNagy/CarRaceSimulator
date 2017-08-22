package CarRaceSimulator;
public class Motorcycle {
    int speed = 100;
    String name;
    static int nameNumber; // The number of the instance created. Used for its name.
    int distanceTraveled = 0;

    public void setName(){
        this.name = "Motorcycle " + String.valueOf(nameNumber);
        nameNumber += 1;
        // Are called "Motorcycle 1", "Motorcycle 2", "Motorcycle 3",... Unique.
    }

    public void moveForAnHour(boolean rain){
        if (rain) {
            // If rains, travels with 5-50km/h slower (randomly).
            int deceleration = (int) (Math.random() * (50 - 5)) + 5;
            distanceTraveled += (speed - deceleration);
        } else {
            distanceTraveled += speed;
        }
    }
}
