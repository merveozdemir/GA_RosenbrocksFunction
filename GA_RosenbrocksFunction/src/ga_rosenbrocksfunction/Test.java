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
public class Test {
    public static void main(String[] args) {
        Problem p = new Problem(10);
        GeneticAlgortihm geneticAlgorithm = new GeneticAlgortihm(10, p, 100);
        geneticAlgorithm.run();
        
        System.out.println("Minimum fitness value: "+ geneticAlgorithm.fitness+ "\nAnd coordinate of the minimum fitness value in 10-dimensional space:");
        for (double d : geneticAlgorithm.bestIndividual.genes) {
             System.out.print(d+"  ");
        }
        
        
    }
}
