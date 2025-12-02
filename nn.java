
class activisionFunction {
    public static double relu(double u) {
        return Math.max(0, u);
    }

    public static double sigmoid(double x) {
        return (float) (1 / (1 + Math.exp(-x)));
    }

    public static double tanh(double x) {
        return (float) Math.tanh(x);
    }
}


class inputs{

}
class neuron {

    public double[] weights;
    public float[] inputs;
    public double bias;
    public double u;
    public String activationFunction;
    public activisionFunction af;
    public double output;
    public double delta;
    public double gradient;

    public neuron(int inputSize, String activationFunction) {
        this.bias = Math.random() * 2 - 1;
        this.activationFunction = activationFunction;
        double u = sumOfWeightsAndInputs();
        this.u = u;
        this.output = applyActivationFunction(u);
    }

    public double sumOfWeightsAndInputs() {
        double sum = 0;
        for (int i = 0; i < inputs.length; i++) {
            sum += inputs[i] * weights[i];
        }
        u = sum + bias;
        return u;
    }

    public double applyActivationFunction(double u) {
    if (activationFunction.equals("relu")) {
        return activisionFunction.relu(u);
    } else if (activationFunction.equals("sigmoid")) {
        return activisionFunction.sigmoid(u);
    } else if (activationFunction.equals("tanh")) {
        return activisionFunction.tanh(u);
    } else {
        throw new IllegalArgumentException("Bilinmeyen aktivasyon fonksiyonu: " + activationFunction);
    }
}
}

class layer{
    public int numberOfInputs;
    public int[] numberOfHiddenLayers;
    public neuron[] numberOfNeurons;

    public layer[] layers;
    //public String activationFunction;

    public layer(int numberOfInputs, int numberOfNeurons, int numberOfLayer) {
        neurons = new neuron[ numberOfNeurons];
        layers = new layer[numberOfLayer];
        this.numberOfInputs = numberOfInputs;

    }
}
class forwardPropagation {


}

class backPropagation {

}

public class nn {
    public static void main(String[] args) {
        neuron n = new neuron(3, "sigmoid");

        System.out.println(n);
        System.out.println(activisionFunction.sigmoid(0.5f));
    }
}
