package dev.toddmartin.Jalgo;

import dev.toddmartin.Jalgo.ui.ConfCreator;
import dev.toddmartin.Jalgo.ui.gui.GuiConfCreator;
import dev.toddmartin.Jalgo.ui.text.TextConfCreator;
import net.jacobpeterson.domain.alpaca.account.Account;
import net.jacobpeterson.alpaca.AlpacaAPI;
import net.jacobpeterson.alpaca.rest.exception.AlpacaAPIRequestException;
import net.jacobpeterson.alpaca.rest.exception.AlpacaAPIRequestException;
import net.jacobpeterson.alpaca.enums.api.EndpointAPIType;
import net.jacobpeterson.alpaca.enums.api.DataAPIType;

public class Jalgo {

    /**
     * Main entry point of program.
     */
    public static void main (String[] args) {
        if (args.length < 1) {
            System.err.println("Need an argument for the interface type");
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
    }

}
