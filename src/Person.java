public class Person {
    private String name;
    private double currentWeight;

    public  Person(String name, double currentWeight) {
        this.name = name;
        this.currentWeight = currentWeight;
        }

    public String getName() {
            return name;
    }

    public void setName(String name) {
            this.name = name;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }
}
