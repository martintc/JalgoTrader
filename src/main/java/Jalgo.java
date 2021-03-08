package Jalgo;

import org.json.JSONObject;

import java.io.IOException;
import java.io.File;

import org.json.JSONObject;

import java.util.Scanner;

public class Jalgo {
    public static void main (String[] args) {
        if (args.length != 1) {
            System.err.println("Need 1 argument to run. -Pconfig={filename}");
            System.exit(1);
        }
        System.out.println("Welcome to Jago.\nInitializing......");
        JSONObject keyJSON = new JSONObject(readFile(new File(args[0])));
        Keys keys = new Keys(keyJSON.getString("api_key"), keyJSON.getString("secret_key"));

        

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
}
