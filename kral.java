
/*

public class layer {
    
    //public static void main(String[] args) {
        
    List<Integer> neuronList = new ArrayList<>(Arrays.asList(2, 3, 4, 1));
    List<neuron> neurons = new ArrayList<>();
    List<Double> nextInputs = new ArrayList<>();

    public int[] firstInputs = new int[]{10, 20};

    public layer(){

        for (int i = 0; i < neuronList.size(); i++) {
            for (int j = 0; j < neuronList.get(i); j++) {
                neuron n = new neuron(j, i, randomWeight());
                neurons.add(n);
                System.out.println(
                        "Layer: " + n.neuronLayer + ", Neuron ID: " + n.id + ", Weights: " + n.weights);
            }
        }

        double output = neurons.get(9).output();
        System.out.println(output);
    }

    public void inputLayer(){
        for(int i = 0; i<neuronList.get(0); i++){
            neuron n = new neuron(i, 0, randomWeight());

        }
    }

    public static double randomWeight() {
        return Math.random() * 2 - 1;
    }

}

class Neuron {
    public int id;
    public int neuronLayer;
    public double weights;
    public double netInput;
    public double bias;
    public  double output;
    public String activationFunction;
    public double nextInput;

    public List<Double> firstInputs = new ArrayList<>(Arrays.asList(0.5, 0.8));
    public List<Double> nextInputs = new ArrayList<>();


    public Neuron(int idNo, int layerNo, double weights) {
        this.id = idNo;
        this.neuronLayer = layerNo;
        this.weights = weights;
        this.netInput = calculateNetInput();
        this.output = output();
        this.nextInput = getOutput();
    }


    public double calculateNetInput() {
        netInput = 0;
        if(neuronLayer == 0){
            for(int i = 0; i<firstInputs.size(); i++){
                netInput = firstInputs.get(i);
            }
        }
        else{
            for (int i = 0; i < nextInputs.size(); i++) {
                netInput += nextInputs.get(i) * weights;
            }
        }
        bias = randomBias();
        netInput += bias;
        return netInput;
    }

    public double output() {
        return sigmoid(this.netInput);
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

*/
