package com.epam.datahandling;

/**
 * Demo class demonstrating program capabilities of working with files, text parsing and displaying reports
 */
public class Runner {
    public static void main(String[] args) {
        DataController dataController = new DataController();
        dataController.run(Integer.parseInt(args[0]));
    }
}
