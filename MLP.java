import java.util.ArrayList;
import java.util.List;

public class MLP {
    public Layer[] layerList;


    public MLP(int... data) {
        List<Integer> datas = new ArrayList<>();
        for (int a : data) {
            datas.add(a);
        }
        this.layerList = new Layer[datas.size() - 1];
        createLayer(datas);
    }

    public void createLayer(List<Integer> layerCount) {
        for (int i = 1; i < layerCount.size(); i++) {
            Layer layer = new Layer(layerCount.get(i), layerCount.get(i - 1));
            layerList[i - 1] = layer;
        }
    }

    public double[] feedForward(double[] inputs) {
        for (int i = 0; i < layerList.length; i++) {
            inputs = layerList[i].feedForward(inputs);
        }
        return inputs;
    }

}


