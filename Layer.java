import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Layer {
    List<Integer> neuronList = new ArrayList<>(Arrays.asList(2, 4, 3, 2));
    List<Neuron> neurons = new ArrayList<Neuron>();
    List<Double> outputs = new ArrayList<>();

    public int inputLayer;
    public int outputLayer;
    public int listSize;
    public Neuron neuron;


    public Layer() {
        inputLayer = neuronList.getFirst();
        outputLayer = neuronList.getLast();
        this.listSize = neuronList.size();


        for (int i = 0; i < listSize; i++) {
            for (int j = 0; j < neuronList.get(i); j++) {
                neuron = new Neuron();
                neurons.add(neuron);
                neuron.currentLayerIndex = i;

                if (i == 0) {
                    //neuron.weights.add(0.0);
                    for (int k = 0; k < neuronList.get(i); k++) {
                        neuron.inputs.addAll(neuron.firstInputs);
                    }
                    neuron.output = neuron.inputs.get(j);
                    outputs.add(neuron.output);
                    //System.out.println(outputs);
                    //System.out.println("Input: " +  neuron.inputs.get(j));
                    //System.out.println("Output: " +  neuron.output);


                } else {
                    neuron.calculateWeights(neuronList.get(neuron.currentLayerIndex - 1));
                    neuron.bias = neuron.randomBias();
                    neuron.netInput = calculateNetInput(neuronList.get(neuron.currentLayerIndex - 1));

                    setInputOutput();

                    // neuron.netInput = neuron.netInput();
                    // neuron.output = neuron.output(neuron.netInput);
                    // System.out.println("Output: " +  neuron.output);
                }

                // neuron.inputs.get(j), neuron.weights.get(j), neuron.bias


                //System.out.println("LayerID: " + i + ", NeuronID: " + j + ", Current Layer Index: " + neuron.currentLayerIndex + ", Weigths: " + neuron.weights + ", Bias: " + neuron.bias);

            }
        }


    }

    public int getCurrentLayerNeurons() {
        return neuron.currentLayerIndex;
    }

    //nöronların bulunduğu layerdan bir önceki layerdaki nöronların outputunu alacağım

    public void setInputOutput() {

        for (int i = 1; i < neuronList.size(); i++) {
            for (int j = 0; j < neuronList.get(i); j++) {
                if (neuron.currentLayerIndex == i) {
                    int aq = neuron.currentLayerIndex - 1;
                    for (int k = 0; k < neuronList.get(j); k++) {
                        outputs.add(neuron.inputs.get(j));
                    }
                    neuron.inputs.add(outputs.get(j));
                }
                System.out.println("Outputs: " +outputs);
                System.out.println("Inputs: " +neuron.inputs);
            }
        }
    }

    public double calculateNetInput(int index){
        neuron.netInput = 0;
        for(int i = 0; i<index; i++){
            neuron.netInput += neuron.weights.get(i) * neuron.inputs.get(i);
            System.out.println("Weights: " +neuron.weights.get(i));
            System.out.println("Inputs: " + neuron.inputs.get(i));
        }
        neuron.netInput += neuron.bias;
        return neuron.netInput;
    }
}
