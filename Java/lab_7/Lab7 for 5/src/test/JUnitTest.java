package test;

import lab.Main;
import lab.MyException;
import lab.Tax;
import lab.Tax_work_place;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Юля on 19.05.2017.
 */
public class JUnitTest {
    @Before
    public void before() {
        System.out.println("Test begin");
    }

    @After
    public void after() {
        System.out.println("Test complete");
    }

    @Test
    public void test1() {
        Tax_work_place tax1 = new Tax_work_place(100);
        Assert.assertEquals((int)tax1.getTax(),100);
    }

    @Test(expected = MyException.class)
    public void test2() {
        ArrayList<Tax> taxes = new ArrayList<Tax>();
        Main.sortSum(taxes);

    }
}
