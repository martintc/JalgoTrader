package dev.toddmartin.Jalgo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import net.jacobpeterson.alpaca.AlpacaAPI;
import net.jacobpeterson.alpaca.enums.api.EndpointAPIType;
import net.jacobpeterson.alpaca.enums.api.DataAPIType;
import org.json.JSONObject;

public class Configuration {

    private final String PATH;
    private final File configFolder;

    public Configuration () {
        PATH = System.getProperty("user.home") + File.separator +
            ".jalgo";
        configFolder = new File(PATH);
    }

    /**
     * Check for config folder. If it doesnt exist, create it
     */
    public void checkForConfigFolder () {
        if (!configFolder.exists()) {
            configFolder.mkdir();
        }
    }

    public boolean doesConfigFileExist () {
        String configFile = PATH + File.separator + ".conf";
        File f = new File(configFile);
        if (f.exists())
            return true;
        else
            return false;
    }

    // TODO
    public void createConfFile (String apiKey, String secretKey) {
        JSONObject obj = new JSONObject();
        obj.put("api_key", apiKey);
        obj.put("secret_key", secretKey);
        try (PrintWriter fw = new PrintWriter(PATH + File.separator + ".conf")) {
            fw.print(obj.toString());
        } catch (IOException e) {
            // catch here
        }
    }

    /**
     * Get the AlpacaAPI instance based on information in the config file
     * @return AlpacaAPI based on locally store information
     */
    public AlpacaAPI getAccount () {
        String contents = this.getFileContents();
        return this.readAccount(contents);
    }

    /**
     * Read in the cotents of the config file
     * @return contents of file in String form
     */
    private String getFileContents () {
        try (Scanner scan = new Scanner(new File(PATH + File.separator + ".conf"))) {
            String contents = "";
            while (scan.hasNext()) {
                contents = contents + scan.next();
            }
            return contents;
        } catch (FileNotFoundException fe) {
            return null;
        }
    }

    /**
     * Read in the JSON and generate AlpacaAPI object
     * @return the account generate from the json contents that were read information
     */
    private AlpacaAPI readAccount (String json) {
        JSONObject obj = new JSONObject(json);
        String apiKey = "";
        String secretKey = "";
        apiKey = obj.getString("api_key");
        secretKey = obj.getString("secret_key");
        return new AlpacaAPI(apiKey, secretKey, EndpointAPIType.LIVE, DataAPIType.IEX);
    }



}
