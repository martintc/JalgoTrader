package dev.toddmartin.Jalgo.strategy;

import dev.toddmartin.Jalgo.ds.TradeList;

public class ScalpingStrategy implements Strategy {

    private double lastBuyPrice;
    private double lastSellPrice;
    private double lastTradePrice;
    private TradeList history;

    public ScalpingStrategy () {
        lastBuyPrice = 0;
        lastSellPrice = 0;
        history = new TradeList();
    }

    public DecisionEnum evaluate (double price) {
        history.addNode(price);
        System.out.println(history.calculateMovingAverage());
        if (lastBuyPrice == 0 && lastSellPrice == 0) {
            lastBuyPrice = price;
            return DecisionEnum.BUY;
        }

        if (price < lastSellPrice && lastBuyPrice != 0 && history.calculateMovingAverage() < 0) {
            lastSellPrice = price;
            lastBuyPrice = 0;
            return DecisionEnum.SELL;
        }

        if (price < lastBuyPrice && lastBuyPrice == 0) {
            lastBuyPrice = price;
            return DecisionEnum.BUY;
        }

        if (price > lastBuyPrice) {
            lastSellPrice = price;
            lastBuyPrice = 0;
            return DecisionEnum.SELL;
        }

        if (lastBuyPrice == 0 && price < lastSellPrice) {
            if (history.calculateMovingAverage() < 0) {
                return DecisionEnum.HOLD;
            }
            lastBuyPrice = price;
            return DecisionEnum.BUY;
        }

        return DecisionEnum.HOLD;
    }

}
