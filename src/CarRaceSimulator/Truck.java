package CarRaceSimulator;

public class Truck {
    int speed = 100;
    String name;
    int breakdownTurnsLeft = 0;
    int distanceTraveled = 0;

    public void setName(String name){
        this.name = name;
    }

    public void moveForAnHour(){
        if (breakdownTurnsLeft == 0) {
            double breakDownChance = Math.random() * 100;
            if (breakDownChance <= 5) {
                breakdownTurnsLeft = 2;
            } else {
                this.distanceTraveled += speed;
            }
        } else {
            breakdownTurnsLeft -= 1;
        }

    }
}
