package Jalgo;

public class Jalgo {
    public static void main (String[] args) {
        if (args.length != 1) {
            System.err.println("Need 1 argument to run. -Pconfig={filename}");
            System.exit(1);
        }
        System.out.println("Welcome to Jago.\nInitializing......");
    }
}
