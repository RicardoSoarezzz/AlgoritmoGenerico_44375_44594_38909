/**
 * The Chromosome class represents a solution to the backpack problem.
 * It contains a set of genes (booleans) representing the selection of objects
 * and a fitness value indicating the quality of the solution.
 *
 * @author Ricardo Soares - 44375
 * @author Miguel Moreira - 44594
 * @author Manuel Brandão - 38909
 */
public class Chromosome implements Comparable<Chromosome>{

    /**
     * The array of genes representing the selection of objects.
     */
    boolean[] genes;

    /**
     * The fitness value indicating the quality of the solution.
     */
    int fitness;


    int counter;
    /**
     * Constructor for creating a Chromosome with the specified size.
     *
     * @param size The size of the genes array.
     */
    public Chromosome(int size) {
        genes = new boolean[size];
        fitness = 0;
        counter++;

    }

    @Override
    public int compareTo(Chromosome other) {
        // Implement comparison logic based on your criteria
        // Return a negative value if this < other, 0 if they are equal, and a positive value if this > other
        return Integer.compare(this.fitness, other.fitness);
    }

    @Override
    public String toString() {
        String string = "[";
        for(int i = 0; i<genes.length;i++){
            if(genes[i]){
                string += "1, ";
            }else {
                string += "0, ";
            }
        }
        string = string.substring(0, string.length() - 2);
        string +="]";
        return string;
    }
}
