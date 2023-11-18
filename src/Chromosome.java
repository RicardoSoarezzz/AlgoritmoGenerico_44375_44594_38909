/**
 * The Chromosome class represents a solution to the backpack problem.
 * It contains a set of genes (booleans) representing the selection of objects
 * and a fitness value indicating the quality of the solution.
 *
 * @author Ricardo Soares - 44375
 * @author Miguel Moreira - 44594
 * @author Manuel Brandão - 38909
 */
public class Chromosome {

    /**
     * The array of genes representing the selection of objects.
     */
    boolean[] genes;

    /**
     * The fitness value indicating the quality of the solution.
     */
    int fitness;

    /**
     * Constructor for creating a Chromosome with the specified size.
     *
     * @param size The size of the genes array.
     */
    public Chromosome(int size) {
        genes = new boolean[size];
        fitness = 0;
    }


}