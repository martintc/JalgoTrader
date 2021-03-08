package Jalgo;

import org.json.JSONObject;
import net.jacobpeterson.alpaca.rest.exception.AlpacaAPIRequestException;

import net.jacobpeterson.alpaca.AlpacaAPI;
import net.jacobpeterson.domain.alpaca.account.Account;
import net.jacobpeterson.alpaca.rest.exception.AlpacaAPIRequestException;
import net.jacobpeterson.alpaca.enums.api.EndpointAPIType;
import net.jacobpeterson.alpaca.enums.api.DataAPIType;


import java.io.IOException;
import java.io.File;

import org.json.JSONObject;

// import org.slf4j.impl.StaticLoggerBinder;

import java.util.Scanner;

public class Jalgo {
    public static void main (String[] args) {
        Account account = null;
        if (args.length != 1) {
            System.err.println("Need 1 argument to run. -Pconfig={filename}");
            System.exit(1);
        }
        System.out.println("Welcome to Jago.\nInitializing......");
        JSONObject keyJSON = new JSONObject(readFile(new File(args[0])));
        Keys keys = new Keys(keyJSON.getString("api_key"), keyJSON.getString("secret_key"), keyJSON.getString("live_trading_endpoint"), keyJSON.getString("paper_trading_endpoint"));
        AlpacaAPI api = new AlpacaAPI(keys.getAPIKey(), keys.getSecretKey(), EndpointAPIType.LIVE, DataAPIType.IEX);
        try {
            account = api.getAccount();
        } catch (AlpacaAPIRequestException e) {
            System.err.println("Account does not exist with those credentials");
            System.exit(1);
        }
        System.out.println("Successfully logged in.");
        printAccountOverview(account);
    }

    private static String readFile (File file) {
        try {
            Scanner scan = new Scanner(file);
            String fileContents = "";
            while (scan.hasNext())
                fileContents = fileContents + scan.nextLine();
            return fileContents;
        } catch (IOException e) {
            System.err.println("Config file does not exist. Please checkw file path or create a config file for keys.");
            System.exit(1);
        }
        return null;
    }

    private static void printAccountOverview (Account account) {
        System.out.print("\tCase: ");
        System.out.print(account.getCash() + "\n");
        System.out.print("\tPortfolio value: ");
        System.out.print(account.getPortfolioValue() + "\n");
    }
}
