package dev.toddmartin.Jalgo.ui.text;

import dev.toddmartin.Jalgo.ui.ConfCreator;
import dev.toddmartin.Jalgo.Configuration;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TextConfCreator implements ConfCreator {

    /**
     * Code that implements the handling of getting in user input for credentials.
     */
    public void newConfFile() {
        Scanner scan = new Scanner(System.in);
        String apiKey, secretKey;
        try {
            System.out.print("Enter in the api key: ");
            apiKey = scan.nextLine();
            System.out.print("Enter in the scret key: ");
            secretKey = scan.nextLine();
            Configuration.createConfFile(apiKey, secretKey);
        } catch (NoSuchElementException e) {
            
        }
    }

}
