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
public class EvolutionaryOperation {

    static final double crossoverRate = 1.0;
    static final double mutationRate = 0.5;
    private static final int tournamentSize = 4;
    private static final boolean elitism = true;
    static final double upperBoundary = 50;
    static final double lowerBoundary = 10;

    //evolve
    public static Population evolvePopulation(Population currentPopulation) {
        Population newPopulation = new Population(currentPopulation.getSize());
       
        if(elitism){
          newPopulation.addIndividual(0, currentPopulation.getFittest());
        }
        
        int elitismOffset = 0;
		if (elitism) {
			elitismOffset = 1;
		}

        for (int i = elitismOffset; i < currentPopulation.getSize(); i++) {
            Individual parent1 = tournamentSelection(currentPopulation);
            Individual parent2 = tournamentSelection(currentPopulation);
            Individual child = crossover(parent1, parent2);
            child.fitness = 0;
            newPopulation.addIndividual(i, child);

        }
        //calculate fitness
        for (int i = elitismOffset; i < newPopulation.getSize(); i++) {
            mutation(newPopulation.getIndividual(i));
            }
        
        return newPopulation;
    }

    //selection 
    private static Individual tournamentSelection(Population pop) {
        Population tournement = new Population(tournamentSize);
        for (int i = 0; i < tournamentSize; i++) {
            int index = (int) (Math.random() * pop.getSize());
            tournement.addIndividual(i, pop.getIndividual(index));
        }
        Individual parent = tournement.getFittest();
        return parent;
    }

    //crossover
    private static Individual crossover(Individual parent1, Individual parent2) {
        Individual child = new Individual(10, 10, -10);
        int index = (int) (Math.random() * parent1.genes.length);
        
        for (int i = 0; i < parent1.genes.length; i++) {
            if (i <= index) {
                child.genes[i] = parent1.genes[i];
            } else {
                child.genes[i] = parent2.genes[i];
            }
        }
        return child;
    }

    //mutation
    private static void mutation(Individual ind) {
        if (Math.random() <= mutationRate) {
            int index = (int) (Math.random() * ind.genes.length);
            if(index != ind.genes.length-1)
            ind.genes[index] = ind.minValue + Math.random() * (ind.maxValue - ind.minValue);
            
        }
        
    }
}
