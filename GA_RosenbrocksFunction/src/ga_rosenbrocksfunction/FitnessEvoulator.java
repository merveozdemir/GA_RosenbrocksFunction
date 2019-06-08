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
public class FitnessEvoulator {
    double fitnessResult;
    Individual x;

    public FitnessEvoulator(Individual x) {
        this.x = x;
    }

    double evulateFitness() { // calculate 
        fitnessResult = GeneticAlgortihm.problem.getResult(x);
        return fitnessResult;
    }
}
