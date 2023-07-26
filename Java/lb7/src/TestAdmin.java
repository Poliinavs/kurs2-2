
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.ArrayList;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class TestAdmin {

    private Admin testAdmin;
    private Client testClient1;
    private Client testClient2;

    @BeforeMethod
    public void setUp() {
        testAdmin = new Admin();
        testClient1 = new Client("Eva", 100, 200);
        testClient2 = new Client("Mike", 305, 120);
    }
    @Test(enabled = false)
    public void testsetProperty() {
        testAdmin.add(testClient1);
        assertTrue(testAdmin.clientList.contains(testClient1));
        System.out.println("Этот метод будет проигнорирован в момент проведения тестирования!");
    }
    @Test(timeOut = 1100)
    public void removeEmployee() throws InterruptedException {
        testAdmin.clientList.add(testClient1);
        testAdmin.removeEmployee(testClient1);
        Thread.sleep(1000); //эмуляция затраты времения для тайм аута
        assertFalse(testAdmin.clientList.contains(testClient1));
        }


        @Test
    public void testSum() throws Exception {
        Assert.assertEquals(300, testAdmin.summa(testClient1));
    }
    @AfterMethod
    public void end()
    {
        System.out.println("Тест закончен!");
    }

}
