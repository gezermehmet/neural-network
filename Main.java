import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        MLP mlp = new MLP(2, 4, 3, 2);

        double[] output = mlp.feedForward(new double[]{33, 15});

        System.out.println(Arrays.toString(output));


    }
}
