package AnimalFarm;

import java.util.Locale;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {
        if (name.length() >= 1) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    private void setAge(int age) {
        if (age <= 15 && age >= 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
    }

    public double productPerDay() {
        return calculateProductPerDay(); //скрила съм си логиката
    }

    @Override
    public String toString() {
        return String.format(Locale.US,"Chicken %s (age %d) can produce %.2f eggs per%n" +
                "day.", this.name, this.age,this.productPerDay());
    }

    private double calculateProductPerDay() {
        if (this.age >= 0 && this.age < 6){
            return 2;
        } else if (this.age >= 6 && this.age <= 11) {
            return 1;
        } else {
            return 0.75;
        }
    }
}
