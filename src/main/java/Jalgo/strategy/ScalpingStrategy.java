package dev.toddmartin.Jalgo.strategy;

public class ScalpingStrategy implements Strategy {

    private float lastBuyPrice;
    private float lastSellPrice;

    public ScalpingStrategy () {
        lastBuyPrice = 0;
        lastSellPrice = 0;
    }

    public DecisionEnum evaluate (float price) {
        if (lastBuyPrice == 0) {
            lastBuyPrice = price;
            return DecisionEnum.BUY;
        }

        if (price < lastBuyPrice) {
            lastSellPrice = price;
            return DecisionEnum.BUY;
        }

        if (true) {
            
        }

        return DecisionEnum.HOLD;
    }

}
