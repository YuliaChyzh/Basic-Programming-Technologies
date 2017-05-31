package test;

import lab7.Coll;
import lab7.Tax;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        Coll<Tax> b = new Coll<Tax>() {};
        b.add(new Tax(1));
        Assert.assertEquals(b.size(), 19);
    }

    @Test
    public void test2() {
        Coll<Tax> b = new Coll<Tax>() {};
        b.add(new Tax(1));
        Assert.assertFalse(b.isEmpty());
    }

    @Test
    public void test3() {
        Tax a = new Tax(1);
        Tax c = new Tax(2);
        Coll<Tax> b = new Coll<Tax>() {};
        b.add(a);
        Assert.assertFalse(b.contains(c));
    }

    @Test
    public void test4() {
        Tax a = new Tax(1);
        Coll<Tax> b = new Coll<Tax>() {};
        b.add(a);
        Assert.assertEquals(b.get(0),a);
    }

    @Test
    public void test5() {
        Tax[] mass = new Tax[3];
        Tax a = new Tax(1);
        mass[0]=a;
        Coll<Tax> b = new Coll<Tax>() {};
        b.setMass(mass);
        Assert.assertEquals(b.getMass(),mass);
    }

}
