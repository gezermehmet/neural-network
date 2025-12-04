import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Neuron {

    public double bias;
    public double netInput;
    public double output;
    public String activationFunction;
    List<Double> weights = new ArrayList<Double>();
    List<Double> inputs = new ArrayList<Double>();
    List<Double> firstInputs = new ArrayList<Double>(Arrays.asList(2.0, 33.5));
    List<Double> nextInputs = new ArrayList<Double>();


    public int currentLayerIndex;




    public Neuron() {

    }


    public void calculateWeights(int index) {

        if (currentLayerIndex == 0) {
            return;
        } else {
            for (int i = 0; i < index; i++) {
                weights.add(randomWeight());
//            System.out.println("Weight " + weights.get(i));
//            System.out.println("Current Layer Index: " + currentLayerIndex);
//            System.out.println("Current Layer Index - 1 : " + (currentLayerIndex - 1));
            }
        }
    }


    public double netInput() {
        netInput = 0;
        for (int i = 0; i < weights.size(); i++) {
            netInput += weights.get(i) * inputs.get(i);
        }
        netInput += bias;
        return  netInput;
    }

    public double output(double input) {
        return sigmoid(input);
    }

    public static double randomWeight() {
        return Math.random() * 2 - 1;
    }

    public double randomBias() {
        return Math.random() * 2 - 1;
    }

    public static double sigmoid(double x) {
        return (double) (1 / (1 + Math.exp(-x)));
    }


}
