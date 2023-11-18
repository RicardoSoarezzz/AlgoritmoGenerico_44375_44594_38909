import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Object> objects = new ArrayList<>();
        objects.add(new Object(1, 500, 40, 5));
        objects.add(new Object(2, 25, 20, 6));
        objects.add(new Object(3, 55, 10, 8));
        objects.add(new Object(4, 65, 35, 6));
        objects.add(new Object(5, 400, 30, 6));
        objects.add(new Object(6, 25, 20, 5));
        objects.add(new Object(7, 20, 25, 5));
        objects.add(new Object(8, 10, 10, 4));
        objects.add(new Object(9, 450, 25, 10));
        objects.add(new Object(10, 10, 20, 3));
        objects.add(new Object(11, 5, 10, 2));
        objects.add(new Object(12, 15, 7, 9));
        objects.add(new Object(13, 25, 8, 3));
        objects.add(new Object(14, 35, 28, 7));
        objects.add(new Object(15, 45, 9, 12));
        objects.add(new Object(16, 35, 16, 14));

        BackpackGeneticAlgorithm geneticAlgorithm = new BackpackGeneticAlgorithm(objects);
        List<Object> solution = geneticAlgorithm.solve();

        System.out.println("\nSolution as Objects in the Backpack:");
        String objectsString = "Objects: ";
        int pesoMax = 0, volMax = 0, valMax = 0;
        for (Object selectedObject : solution) {
            pesoMax += selectedObject.weight;
            volMax += selectedObject.volume;
            valMax += selectedObject.value;
            objectsString += selectedObject.number + ", ";
        }

        objectsString = objectsString.substring(0, objectsString.length() - 2);
        System.out.println(objectsString);


        System.out.println("\nBackpack: ");
        System.out.println("    Weight: " + pesoMax);
        System.out.println("    Volume: " + volMax);
        System.out.println("    Value: " + valMax);


    }
}