import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
class Neuron{
    public int neuronID;
    public int neuronLayerNo;
    public double[] weights;
    public float[] inputs;
    public double bias;
    public double netInput;
    public String activationFunction;
    public double output;
    public int neuronCount;

    public Neuron(int neuronCount) {
        this.netInput = netInput();
        this.output = output();
        this.neuronCount = neuronCount;
    }

    
    public double netInput() {
        netInput = 0;

        for (int i = 0; i < inputs.length; i++) {
            netInput += inputs[i] * weights[i];
        }
        
        bias = randomBias();
        netInput += bias;
        return netInput;
    }
    
    public double output() {
        return sigmoid(this.netInput);
    }
    
    public double randomWeight() {
        return Math.random() * 2 - 1;
    }
    
    public double randomBias() {
        return Math.random() * 2 - 1;
    }
    
    public static double sigmoid(double x) {
        return (double) (1 / (1 + Math.exp(-x)));
    }
    
    public double getOutput() {
        return output;
    }
}

class Layer{

    List<Neuron> neuronList = new ArrayList<>();

    public Layer (List<Integer> layerSizes){

        for (int i = 0; i < layerSizes.size(); i++){
            for(int j = 0; j< layerSizes.get(i); j++){
                Neuron neuron = new Neuron(layerSizes.get(i));
                neuronList.add(neuron);
            }
        }
        

        }
    }
}


public class weird_nn {

    static void main(String[] args) {

        Layer layer1 = new Layer(Arrays.asList(2, 3, 4, 1));

        System.out.println(layer1);


    }
}*/