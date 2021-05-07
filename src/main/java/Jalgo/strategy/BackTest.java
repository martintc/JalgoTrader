package dev.toddmartin.Jalgo.strategy;

public class BackTest {

    public static void main (String[] args) {
        System.out.println("Back testing");
        if (args.length < 1) {
            System.out.println("Need a data file to analyze, pass in as argument");
            System.exit(0);
        }
    }

}
