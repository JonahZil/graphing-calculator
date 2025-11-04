package graphcalc;
import java.util.ArrayList;

//A class to handle derivatives
public class Derivative extends Formula {
    
    private ArrayList<Object> function;
    private Function equation;
    private double xVal;

    public Derivative(double xVal, ArrayList<Object> function) {
        this.function = function;
        this.xVal = xVal;
        equation = new Function(function, 0);
    }

    //Evaluates the derivative using the limit definition with an approximation of the limit as h -> 0. 
    public double evaluate() {
        double difference = 0.00000001;
        double fplush = equation.evaluate(xVal + difference, new ArrayList<Object>((ArrayList<Object>)function), 0, false);
        double fx = equation.evaluate(xVal, new ArrayList<Object>((ArrayList<Object>)function), 0, false);
        return (fplush - fx)/difference;
    }
}
