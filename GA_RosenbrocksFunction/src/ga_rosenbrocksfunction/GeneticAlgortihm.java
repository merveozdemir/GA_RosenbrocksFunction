/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ga_rosenbrocksfunction;

/**
 *
 * @author Merve
 */
public class GeneticAlgortihm {

    static public Problem problem;
    int POPULATION_SIZE;
    Individual ind[];
    int iteration = 1;
    private int maxIteration = 0;
    double fitness;
    Individual bestIndividual = null;

    public GeneticAlgortihm(int Population_size, Problem p, int max) {
        POPULATION_SIZE = Population_size;
        problem = p;
        maxIteration = max;
    }

    public void run() {
        Population population = new Population(POPULATION_SIZE);
        ind = population.initializePopulation();

        while (iteration <= maxIteration) {
            int generationCount = 0;
            //System.out.println("population fitness : " + population.fitness);
            while (generationCount < 10) {

                population = EvolutionaryOperation.evolvePopulation(population);
                calculateFitness(population);
                population.fitness = getMaxFitness(population);
                generationCount++;
            }

            System.out.println(iteration + ". run     -     Globasl Best Value: " + population.fitness);
            iteration++;
        }

    }

    double getMaxFitness(Population pop) {
        Individual in[] = pop.getIndividuals();
        pop.fitness = in[0].fitness;
        for (int i = 1; i < in.length; i++) {
            if (in[i].fitness < pop.fitness) {
                pop.fitness = in[i].fitness;
                pop.bestIndividual = in[i];
                this.bestIndividual = in[i];
                this.fitness = in[i].fitness;
            }
        }
        return pop.fitness;
    }
    
    void calculateFitness(Population p){
        for (Individual individual : p.getIndividuals()) {
            FitnessEvoulator f = new FitnessEvoulator(individual);
            individual.fitness = f.evulateFitness();
        }
        
    }

}
