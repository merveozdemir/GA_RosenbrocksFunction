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
public class Problem {
     String name;
    double result = 0;
    private int dimension;

    public Problem(int dimension) {
        this.dimension = dimension;
    }

    double getResult(Individual i) {
        return calculate(i);
    }

    double calculate(Individual in) {
        double fitnessResult = 0;
        double x[] = in.genes;
        for (int i = 0; i < dimension - 1; i++) {
            fitnessResult += 100 * Math.pow((x[i + 1] - Math.pow(x[i], 2)), 2) + Math.pow((x[i] - 1), 2);
         }

        return fitnessResult;
    }
}
