import org.example.math;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class mathTest {
    @Test
    public void testAdd() {
        math math = new math();
        assertEquals(4, math.add(2, 3));
    }
}
