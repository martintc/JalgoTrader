package dev.toddmartin.Jalgo.ds;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Random;

public class TestTradeList {

    @Test
    public void TradeListOneElement () {
        TradeList tl = new TradeList();
        tl.addNode(2.3);
        assertEquals(1, tl.getSize(), 0);
    }

    @Test
    public void TradeListMultipleElements() {
        TradeList tl = new TradeList();
        tl.addNode(1.34);
        tl.addNode(2.34);
        tl.addNode(5.145);
        tl.addNode(10.9889);
        tl.addNode(0.234);
        assertEquals(5, tl.getSize(), 0);
    }

    @Test
    public void TradeListMoreThan200Adds () {
        Random r = new Random();
        TradeList tl = new TradeList();
        for (int i = 0; i < 210; i++) {
            tl.addNode(r.nextDouble());
        }

        assertEquals(200, tl.getSize(), 0);

    }

    @Test
    public void testGetLastPrice () {
        TradeList tl = new TradeList();
        tl.addNode(0.5);
        assertEquals(0.5, tl.getLastPrice(), 0);
        tl.addNode(0.234);
        assertEquals(0.234, tl.getLastPrice(), 0);
    }

    @Test
    public void testMovingAverageCalculationArbitraryAmounts () {
        TradeList tl = new TradeList();
        Random r = new Random();
        int size = (r.nextInt()) % 199;
        double halfCalc = 0;
        double fullCalc = 0;
        for (int i = 0; i < size; i++) {
            double tmp = r.nextDouble();
            fullCalc = fullCalc + tmp;
            if (i <= (size/2)) {
                halfCalc = halfCalc + tmp;
            }
            tl.addNode(tmp);
        }
        double finalCalc = (halfCalc/(size/2)) - (fullCalc/size);
        assertEquals(finalCalc, tl.calculateMovingAverage(), 0.1);
    }

    @Test
    public void testMovingAverageFullCalculation () {
        TradeList tl = new TradeList();
        Random r = new Random();
        int size = 200;
        double halfCalc = 0;
        double fullCalc = 0;
        for (int i = 0; i < size; i++) {
            double tmp = r.nextDouble();
            fullCalc = fullCalc + tmp;
            if (i < (size/2)) {
                halfCalc = halfCalc + tmp;
            }
            tl.addNode(tmp);
        }
        double finalCalc = (halfCalc/(size/2)) - (fullCalc/size);
        assertEquals(finalCalc, tl.calculateMovingAverage(), 0.1);
    }        

}
