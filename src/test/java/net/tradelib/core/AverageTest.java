package net.tradelib.core;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * test the average work as expected
 * @author beswarm@gmail.com
 * @since 12/1/2016
 */
public class AverageTest {
    private Average average;
    @Before
    public void setUp() throws Exception {
        average=new Average();
    }

    @Test
    public void testFixedAverage() throws Exception {
        average.add(1.0);
        assertTrue(average.getSize()==1);
        assertEquals(1.0,average.get(),0.0);

        average.add(3.0);
        assertTrue(average.getSize()==2);
        assertEquals(2.0,average.get(),0.0);
    }

    @Test
    public void testRandomAverage() throws Exception {
        Random random=new Random();
        int num=random.nextInt(2000);
        double sum=0.0;
        for(int i=0;i<num;i++){
            double randomDouble=random.nextDouble();
            sum+=randomDouble;
            average.add(randomDouble);
        }
        assertTrue(average.getSize()==num);
        assertEquals(average.get(),sum/num,0.00000000001);
    }
}