import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Neuron {

    public double bias;
    public double output;
    public String activationFunction;
    public double[] weights;
    public int previousNeuronNumber;


    public Neuron(int previousNeuronNumber) {
        this.previousNeuronNumber = previousNeuronNumber;
        this.weights = new double[previousNeuronNumber];
        this.weights = weights();
        this.bias = randomBias();
    }

    public double[] weights() {
        for (int i = 0; i < weights.length; i++) {
            weights[i] = randomWeight();
        }
        return weights;
    }

    public double feedForward(double[] inputs) {
        double netInput = bias;

        for (int i = 0; i < weights.length; i++) {
            netInput += weights[i] * inputs[i];
        }
        return output(netInput);
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
