package dev.toddmartin.Jalgo.strategy;

public interface Strategy {

    /**
     * Core component. Algorithm to decide buy, sell, hold is in this method.
     * @param float current price that stock sold at
     */
    public DecisionEnum evaluate (double price);

}
