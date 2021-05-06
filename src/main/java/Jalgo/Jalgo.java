package dev.toddmartin.Jalgo;

import dev.toddmartin.Jalgo.ui.ConfCreator;
import dev.toddmartin.Jalgo.ui.gui.GuiConfCreator;
import dev.toddmartin.Jalgo.ui.text.TextConfCreator;
import java.time.ZonedDateTime;
import net.jacobpeterson.abstracts.websocket.exception.WebsocketException;
import net.jacobpeterson.alpaca.AlpacaAPI;
import net.jacobpeterson.alpaca.rest.exception.AlpacaAPIRequestException;
import net.jacobpeterson.alpaca.rest.exception.AlpacaAPIRequestException;
import net.jacobpeterson.alpaca.enums.api.EndpointAPIType;
import net.jacobpeterson.alpaca.enums.api.DataAPIType;
import net.jacobpeterson.domain.alpaca.account.Account;
import net.jacobpeterson.domain.alpaca.asset.Asset;
import net.jacobpeterson.domain.alpaca.clock.Clock;
import net.jacobpeterson.domain.alpaca.position.Position;
import net.jacobpeterson.domain.alpaca.marketdata.realtime.MarketDataMessage;
import net.jacobpeterson.domain.alpaca.marketdata.historical.quote.Quote;
import net.jacobpeterson.alpaca.websocket.marketdata.listener.MarketDataListener;
import net.jacobpeterson.alpaca.websocket.marketdata.listener.MarketDataListenerAdapter;
import net.jacobpeterson.alpaca.websocket.marketdata.message.MarketDataMessageType;
import net.jacobpeterson.domain.alpaca.marketdata.realtime.trade.TradeMessage;

public class Jalgo {

    /**
     * Main entry point of program.
     */
    public static void main (String[] args) {
        Clock clock = null;
        Account acc = null;
        if (args.length < 1) {
            System.err.println("Need an argument for the interface type");
            System.exit(1);
        } else if (args.length < 2) {
            System.err.println("Provide a ticker symbol");
            System.exit(1);
        }
        Configuration conf = new Configuration();
        conf.checkForConfigFolder();
        if (!conf.doesConfigFileExist()) {
            ConfCreator cc;
            if (args[0].equals("gui")) {
                cc = new GuiConfCreator();
                cc.newConfFile();
            } else if (args[0].equals("text")) {
                cc = new TextConfCreator();
                cc.newConfFile();
            }
        }
        AlpacaAPI api = conf.getAccount();
        try {
            acc = api.getAccount();
            clock = api.getClock();
        } catch (AlpacaAPIRequestException e) {
            System.err.println("Issue getting account, check network connction");
            System.exit(1); // exit program since account can not be gathered
        }

        System.out.println(clock.getIsOpen());
        System.out.println("Account cash: " + acc.getCash());
        System.out.println("Portfolio value: " + acc.getPortfolioValue());

        Asset asset = null;
        try {
            asset = api.getAssetBySymbol(args[1].toUpperCase());
        } catch (AlpacaAPIRequestException e) {
            
        }
        System.out.println(asset);

        MarketDataListener listener = null;

        try {

            listener = new MarketDataListenerAdapter(
                                                     args[1].toUpperCase(),
                                                     MarketDataMessageType.TRADE
                                                     ) {
            @Override
                public void onStreamUpdate(MarketDataMessageType streamMessageType, MarketDataMessage streamMessage) {
                    if (streamMessageType == MarketDataMessageType.TRADE) {
                        TradeMessage tradeMessage = (TradeMessage) streamMessage;
                        System.out.println("Price: " + tradeMessage.getPrice());
                    }
                }
            };
            api.addMarketDataStreamListener(listener);
            Thread.sleep(100);
        } catch (WebsocketException e) {
            System.err.println("Error occured in creating a market listener");
            System.exit(1);
        } catch (InterruptedException ie) {

        }

        // while(true) {
        //     while (clock.getIsOpen()) {
                
        //     }
        // }

    }


}
