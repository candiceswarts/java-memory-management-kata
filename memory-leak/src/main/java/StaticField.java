import java.util.ArrayList;
import java.util.Random;

public class StaticField {

    private Random random = new Random();
    public static final ArrayList<Double> list = new ArrayList<Double>(10000000);

    public void addRandomDoubleToList() {
        for (int i = 0; i < 10000000; i++) {
            list.add(random.nextDouble());
        }
    }
}
