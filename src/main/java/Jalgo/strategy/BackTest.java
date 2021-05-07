package dev.toddmartin.Jalgo.strategy;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class BackTest {

    public static void main (String[] args) {
        System.out.println("Back testing");
        Strategy strat = new ScalpingStrategy();
        if (args.length < 1) {
            System.out.println("Need a data file to analyze, pass in as argument");
            System.exit(0);
        } else {
            System.out.println("Test file: " + args[0]);
        }

        File data = new File(args[0]);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(data));
            String contents = "";
            while ((contents = reader.readLine()) != null) {
                Double d = Double.parseDouble(contents);
                DecisionEnum e =strat.evaluate(d);
                System.out.println(d + " " + e);
            }
        } catch (IOException ex) {
            System.out.println("Issue reading file");
        }
    }
}
