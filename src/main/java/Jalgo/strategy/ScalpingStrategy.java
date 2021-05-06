package dev.toddmartin.Jalgo.strategy;

import dev.toddmartin.Jalgo.ds.TradeList;

public class ScalpingStrategy implements Strategy {

    private float lastBuyPrice;
    private float lastSellPrice;
    private float lastTradePrice;
    private TradeList history;

    public ScalpingStrategy () {
        lastBuyPrice = 0;
        lastSellPrice = 0;
        history = new TradeList();
    }

    public DecisionEnum evaluate (float price) {
        history.addNode(price);
        if (lastBuyPrice == 0 && lastSellPrice == 0) {
            lastBuyPrice = price;
            return DecisionEnum.BUY;
        }

        if (price < lastBuyPrice) {
            lastSellPrice = price;
            lastBuyPrice = 0;
            return DecisionEnum.SELL;
        }

        if (price > lastBuyPrice) {
            lastSellPrice = price;
            lastBuyPrice = 0;
            return DecisionEnum.SELL;
        }

        if (lastBuyPrice == 0 && price < lastSellPrice) {
            lastBuyPrice = price;
            return DecisionEnum.BUY;
        }

        return DecisionEnum.HOLD;
    }

}
