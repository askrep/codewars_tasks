import com.kas.descending_order.main.DescendingOrder;
import org.junit.Assert;
import org.junit.Test;


public class TestDescendingOrder {
    @Test
    public void firstTest() {
        Assert.assertEquals(0, DescendingOrder.sortDesc(0));
    }

    @Test
    public void secondTest() {
        Assert.assertEquals(51, DescendingOrder.sortDesc(15));
    }

    @Test
    public void thirdTest() {
        Assert.assertEquals(987654321, DescendingOrder.sortDesc(123456789));
    }
}
