import code.DateTime;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateTimeTest {
    private static DateTime dateTime;
    @BeforeAll
    public static void setUp() {
        dateTime=new DateTime();
    }

    @Test
    public void testGetCurrentTime() {
        assertEquals("01/03/2024", dateTime.getFormattedDate());
    }

    @Test
    public void testGetEightDigitDate() {
        assertEquals("01032024", dateTime.getEightDigitDate());
    }

    @Test
    public void testDiffDays() {
        DateTime startDate = new DateTime(25, 2, 2022);
        DateTime endDate = new DateTime(28, 2, 2022);

        assertEquals(3, DateTime.diffDays(endDate, startDate));
    }

    @Test
    public void testSetAdvance() {
        DateTime dateTime = new DateTime(25, 2, 2022);
        dateTime.setAdvance(3,2,1);

        assertEquals("25/02/2022", dateTime.getFormattedDate());
    }

    @Test
    public void testGetNameOfDay() {
        assertEquals("Friday", dateTime.getNameOfDay());
    }
}
