package CarRaceSimulator;
import java.util.Random;

public class Car {
    int distanceTraveled = 0;
    int normalSpeed;
    String name;
    Random generator = new Random();
    static String carNames[]= {"Supremacy", "Blend", "Scorpion", "Apex", "Spire", "Oracle", "Guardian", "Vindicator", "Silver", "Tempest"};

    public int setSpeedLimit(int limit){
        // Since cars are so fast there is a 30% chance that they can go only with 70km/h speed.
        double speedLimitChance =  Math.random() * 100;
        if (speedLimitChance >= 70) {
            return limit;
        } else {
            return this.normalSpeed;
        }

    }

    public void setNormalSpeed() {
        this.normalSpeed = (int) (Math.random() * (110 - 80)) + 80;
    }

    public void setName(){
        // Make a list from the words here: http://www.fantasynamegenerators.com/car-names.php and pick 2 randomly for each instance.
        int randomIndex1 = generator.nextInt(carNames.length);
        int randomIndex2 = generator.nextInt(carNames.length);
        int randomNumber = generator.nextInt(100);
        this.name = carNames[randomIndex1] + " " + carNames[randomIndex2] + " " + String.valueOf(randomNumber);
    }

    public void moveForAnHour(int speed){
        distanceTraveled += speed;
    }

}