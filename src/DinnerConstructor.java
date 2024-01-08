import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dinnerMenu = new HashMap<>();
    ArrayList<ArrayList<String>> newCombos = new ArrayList<>();
    ArrayList<String> contentOfType = new ArrayList<>();
    Random random = new Random();

    public void addNewDinner(String dishType, String dishName) {
        if (dinnerMenu.containsKey(dishType)) {
            contentOfType = dinnerMenu.get(dishType);
            contentOfType.add(dishName);
        } else {
            ArrayList<String> contentOfType = new ArrayList<>();
            contentOfType.add(dishName);
            dinnerMenu.put(dishType, contentOfType);
        }
    }

    public ArrayList<ArrayList<String>> generateDinner(int numberOfCombos, String line) {
        for (int i = 0; i < numberOfCombos; i++) {
            if (newCombos.size() < numberOfCombos) {
                ArrayList<String> combo = new ArrayList<>();
                combo.add(generateCombo(line));
                newCombos.add(combo);
            } else {
                ArrayList<String> combo = newCombos.get(i);
                String dish = String.valueOf(generateCombo(line));
                combo.add(dish);
            }
        }
        return newCombos;
    }

    public String generateCombo(String line) {
        ArrayList<String> availableDishes = dinnerMenu.get(line);
        int numbersOfDishesForType = availableDishes.size();
        int dishIndex = random.nextInt(numbersOfDishesForType);
        return availableDishes.get(dishIndex);
    }

    public void printCombos() {
        for (int i = 0; i < newCombos.size(); i++) {
            System.out.println("Комбо " + (i + 1));
            System.out.println(newCombos.get(i));
        }
        newCombos = new ArrayList<>();
    }
}
