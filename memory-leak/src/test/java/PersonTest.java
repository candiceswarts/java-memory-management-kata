import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class PersonTest {

    @Test(expected = OutOfMemoryError.class)
//    @Ignore("Ignore when person class has been optimized")
    public void givenMap_whenEqualsAndHashCodeNotOverridden_thenMemoryLeak() {
        Map<Person, Integer> map = new HashMap<>();
        for(int i=0; i<1000000000; i++) {
            map.put(new Person("1"), 1);
        }
        Assert.assertFalse(map.size() == 1);
    }

    @Test
    @Ignore("Ignore until person class has been optimized")
    public void givenMap_whenEqualsAndHashCodeIsOverridden_thenSingleEntryInMap() {
        Map<Person, Integer> map = new HashMap<>();
        for(int i=0; i<1000000000; i++) {
            map.put(new Person("1"), 1);
        }
        Assert.assertTrue(map.size() == 1);
    }

}