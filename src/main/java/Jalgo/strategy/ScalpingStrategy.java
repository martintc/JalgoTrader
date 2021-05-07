package dev.toddmartin.Jalgo.strategy;

import dev.toddmartin.Jalgo.ds.TradeList;

public class ScalpingStrategy implements Strategy {

    private double lastBuyPrice;
    private double lastSellPrice;
    private double lastTradePrice;
    private TradeList history;
    private boolean isOwned;

    public ScalpingStrategy () {
        lastBuyPrice = 0;
        lastSellPrice = 0;
        history = new TradeList();
        isOwned = false;
    }

    public DecisionEnum evaluate (double price) {
        history.addNode(price);
        // System.out.println(history.calculateMovingAverage());
        if (lastBuyPrice == 0 && lastSellPrice == 0) {
            lastBuyPrice = price;
            isOwned = true;
            return DecisionEnum.BUY;
        }

        if (price > lastBuyPrice && isOwned) {
            lastSellPrice = price;
            isOwned = false;
            return DecisionEnum.SELL;
        }

        if (lastSellPrice != 0 && !isOwned && price < lastSellPrice) {
            lastBuyPrice = price;
            isOwned = true;
            return DecisionEnum.BUY;
        }



        return DecisionEnum.HOLD;
    }

}
