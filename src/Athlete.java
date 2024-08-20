public class Athlete extends Person {


    private String trainingPlan;
    private String weightCategory;
    private int competitions;
    private int coachingHours;

    public Athlete(String name, String trainingPlan, double currentWeight, String weightCategory, int competitions, int coachingHours) {
        super(name, currentWeight);
        this.trainingPlan = trainingPlan;
        this.weightCategory = weightCategory;
        this.competitions = competitions;
        this.coachingHours = coachingHours;
    }

    public double calculateTrainingCost() {
        double cost = 0;
        String plan = trainingPlan.toLowerCase();
        switch (plan) {
            case "beginner":
                cost = 25 * 4;
                break;
            case "intermediate":
                cost = 30 * 4;
                break;
            case "elite":
                cost = 35 * 4;
                break;
        }
        return cost;
    }

    public double calculateCompetitionCost() {
        if (trainingPlan.equals("Intermediate") || trainingPlan.equals("Elite")) {
            return competitions * 22;
        }
        return 0;
    }

    public double calculateCoachingCost() {
        return coachingHours * 9;
    }

    public double calculateTotalCost() {
        return calculateTrainingCost() + calculateCompetitionCost() + calculateCoachingCost();
    }

    public String compareWeight() {
        double weightLimit = 0;
        double lowerLimit = 0;
        String formattedWeightCategory = weightCategory.substring(0, 1).toUpperCase() + weightCategory.substring(1).toLowerCase();
        // Convert the first letter of weightCategory to uppercase and the rest to lowercase
        switch (formattedWeightCategory) {
            case "Heavyweight":
                weightLimit = Double.POSITIVE_INFINITY;
                lowerLimit = 100.01;
                break;
            case "Light-heavyweight":
                weightLimit = 100;
                lowerLimit = 90.01;
                break;
            case "Middleweight":
                weightLimit = 90;
                lowerLimit = 81.01;
                break;
            case "Light-Middleweight":
                weightLimit = 81;
                lowerLimit = 73.01;
                break;
            case "Lightweight":
                weightLimit = 73;
                lowerLimit = 66.01;
                break;
            case "Flyweight":
                weightLimit = 66;
                lowerLimit = 0;
                break;
        }
        if (getCurrentWeight() > weightLimit) {
            return String.format ("Overweight, you need %.2fkg less to meet the requirement",  (getCurrentWeight() - weightLimit));
        } else if (getCurrentWeight() >= lowerLimit && getCurrentWeight() <= weightLimit) {
            return "On target";
        } else {
            return String.format("Underweight, you need %.2fkg more to meet the requirement", (lowerLimit - getCurrentWeight()));
        }
    }

    public void displayCosts() {
        System.out.println("Athlete: " + getName());
        System.out.println("Training cost: $" + String.format("%.2f", calculateTrainingCost()));
        System.out.println("Competition cost: $" + String.format("%.2f", calculateCompetitionCost()));
        System.out.println("Coaching cost: $" + String.format("%.2f", calculateCoachingCost()));
        System.out.println("Total cost: $" + String.format("%.2f", calculateTotalCost()));
        System.out.println("Weight status: " + compareWeight());
        System.out.println("------------------------------------------------------------------");
    }
}
