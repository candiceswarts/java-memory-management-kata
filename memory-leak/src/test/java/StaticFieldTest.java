import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StaticFieldTest {

    @Test
    public void givenStaticField_whenLotsOfOperations_thenMemoryLeak() throws InterruptedException {
        StaticField staticField = new StaticField();
        staticField.addRandomDoubleToList();
        System.gc();
        Thread.sleep(10000); // to allow GC do its job
    }

}