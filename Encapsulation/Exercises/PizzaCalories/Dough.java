package PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (flourType.equals("White") || flourType.equals("Wholegrain")) {
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        switch (bakingTechnique) {
            case "Crispy":
            case "Chewy":
            case "Homemade":
                this.bakingTechnique = bakingTechnique;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 200) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

        public double calculateCalories () {
        //коеф. спрямо вида на тестото
        double flourTypeCoeficient = 0;
        if (flourType.equals("White")){
            flourTypeCoeficient = 1.5;
        } else if (flourType.equals("Wholegrain")){
            flourTypeCoeficient = 1;
        }
        //коеф.според вида на техниката на печене
        double bakingTechniqueCoeficient = 0;
        if (bakingTechnique.equals("Crispy")){
            bakingTechniqueCoeficient = 0.9;
        } else if (bakingTechnique.equals("Chewy")){
            bakingTechniqueCoeficient = 1.1;
        } else if (bakingTechnique.equals("Homemade")){
            bakingTechniqueCoeficient = 1;
        }
           return 2 * this.weight *flourTypeCoeficient * bakingTechniqueCoeficient;
        }



    }
