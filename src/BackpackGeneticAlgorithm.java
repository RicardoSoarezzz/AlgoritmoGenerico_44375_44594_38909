import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BackpackGeneticAlgorithm {
    private static final int POPULATION_SIZE = 100;
    private static final int MAX_GENERATIONS = 250;
    private static final double MUTATION_RATE = 0.01;
    private static final int MAX_WEIGHT = 100;
    private static final int MAX_VOLUME = 50;

    private final List<Object> objects;

    public BackpackGeneticAlgorithm(List<Object> objects) {
        this.objects = objects;
    }

    /**
     * Solves the backpack problem using a genetic algorithm and returns a list of selected objects
     * that represent the optimal solution found by the algorithm.
     *
     * @return A list of selected objects representing the optimal solution.
     */
    public List<Object> solve() {
        List<Chromosome> population = initializePopulation();

        for (int generation = 0; generation < MAX_GENERATIONS; generation++) {
            evaluatePopulation(population);
            List<Chromosome> newPopulation = new ArrayList<>();

            while (newPopulation.size() < POPULATION_SIZE) {
                Chromosome parent1 = selectParent(population);
                Chromosome parent2 = selectParent(population);

                Chromosome child = crossover(parent1, parent2);
                mutate(child);

                newPopulation.add(child);
            }

            population = newPopulation;
        }

        evaluatePopulation(population);

        Chromosome bestSolution = getBestSolution(population);

        System.out.println("\nSolution in an array of booleans: ");
        System.out.println(bestSolution);
        return getSelectedObjects(bestSolution);
    }


    private List<Chromosome> initializePopulation() {
        List<Chromosome> population = new ArrayList<>();

        for (int i = 0; i < POPULATION_SIZE; i++) {
            Chromosome chromosome = new Chromosome(objects.size());
            for (int j = 0; j < objects.size(); j++) {
                chromosome.genes[j] = new Random().nextBoolean();
            }
            population.add(chromosome);
        }

        return population;
    }

    private void evaluatePopulation(List<Chromosome> population) {
        for (Chromosome chromosome : population) {
            int totalWeight = 0;
            int totalVolume = 0;
            int totalValue = 0;

            for (int i = 0; i < chromosome.genes.length; i++) {
                if (chromosome.genes[i]) {
                    totalWeight += objects.get(i).weight;
                    totalVolume += objects.get(i).volume;
                    totalValue += objects.get(i).value;
                }
            }

            if (totalWeight > MAX_WEIGHT || totalVolume > MAX_VOLUME) {
                chromosome.fitness = 0;
            } else {
                chromosome.fitness = totalValue;
            }
        }
    }

    private Chromosome selectParent(List<Chromosome> population) {
        int index1 = new Random().nextInt(population.size());
        int index2 = new Random().nextInt(population.size());

        return (population.get(index1).fitness > population.get(index2).fitness) ?
                population.get(index1) : population.get(index2);
    }

    private Chromosome crossover(Chromosome parent1, Chromosome parent2) {
        Chromosome child = new Chromosome(parent1.genes.length);

        int crossoverPoint = new Random().nextInt(parent1.genes.length);
        System.arraycopy(parent1.genes, 0, child.genes, 0, crossoverPoint);
        System.arraycopy(parent2.genes, crossoverPoint, child.genes, crossoverPoint, parent2.genes.length - crossoverPoint);

        return child;
    }

    private void mutate(Chromosome chromosome) {
        for (int i = 0; i < chromosome.genes.length; i++) {
            if (Math.random() < MUTATION_RATE) {
                chromosome.genes[i] = !chromosome.genes[i];
            }
        }
    }

    private Chromosome getBestSolution(List<Chromosome> population) {
        Chromosome bestSolution = population.get(0);

        for (Chromosome chromosome : population) {
            if (chromosome.fitness > bestSolution.fitness) {
                bestSolution = chromosome;
            }
        }

        return bestSolution;
    }

    private List<Object> getSelectedObjects(Chromosome chromosome) {
        List<Object> selectedObjects = new ArrayList<>();

        for (int i = 0; i < chromosome.genes.length; i++) {
            if (chromosome.genes[i]) {
                selectedObjects.add(objects.get(i));
            }
        }

        return selectedObjects;
    }

}