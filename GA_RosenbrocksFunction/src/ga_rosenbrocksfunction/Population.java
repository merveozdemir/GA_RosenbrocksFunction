package ga_rosenbrocksfunction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Merve
 */
public class Population {
//    private final double maxValue = 100.0;
//    private final double minValue = -100.0;
    private int POPULATION_SIZE;
    private Individual[] individuals;
    double fitness;
    Individual bestIndividual = null;
  
    
    public Population(int size){
         POPULATION_SIZE = size;
         individuals = new Individual[POPULATION_SIZE];
    }
    
   public Individual [] initializePopulation(){
        
        for (int i = 0; i < individuals.length; i++) {
            Individual in = new Individual(10, -10, 10);
            individuals[i] = in;
        }
        return individuals;
    }
    
    public Individual [] getIndividuals(){
        return individuals;
      }
    
    public Individual  getIndividual(int index){
        return individuals[index];
      }
    
    void addIndividual(int i, Individual fittest) {
         individuals[i] = fittest;
    }
    
    public int getSize(){
        return POPULATION_SIZE;
                
    }
    
    public Individual getFittest() {
		Individual fittest = individuals[0];
		
		for (int i = 1; i < individuals.length; i++) {
			if(individuals[i].fitness < fittest.fitness) {
				fittest = individuals[i];
			}
		}
		return fittest;
	}

   
    
    
    
}
