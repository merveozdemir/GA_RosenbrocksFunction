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
public class Individual {

    final double maxValue;
    final double minValue;
    double genes[];
    double fitness;

    public Individual() {
        maxValue = 10;
        minValue = -10;
    }

    public Individual(int geneSize, double min, double max) {
        minValue = min;
        maxValue = max;
        genes = new double[geneSize];

        for (int i = 0; i < genes.length; i++) {
            genes[i] = minValue + Math.random() * (maxValue - minValue);
        }
        FitnessEvoulator fitnessEvu = new FitnessEvoulator(this);
        fitness = fitnessEvu.evulateFitness();
       // System.out.println(fitness);
    }

}
