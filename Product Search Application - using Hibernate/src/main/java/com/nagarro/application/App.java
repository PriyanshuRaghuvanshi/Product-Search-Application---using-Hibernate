package com.nagarro.application;

import java.io.FileNotFoundException;
import java.util.List;
import com.nagarro.tshirt.Tshirt;
import com.nagarro.csvservices.CsvFileReader;
import com.nagarro.csvservices.CsvWatcher;
import com.nagarro.io.*;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		try {
			CsvWatcher csvWatcherTh = new CsvWatcher();
			Thread thread = new Thread(csvWatcherTh);
			thread.start();
			CsvFileReader csv = new CsvFileReader();
			Input input = new Input();
			Output output = new Output();

//Data stored in database			
//			csv.getmapData();

			while (true) {
				try {

					List<Tshirt> requiredTshirts = input.getInput();

					output.displayOutput(requiredTshirts);

				} catch (Exception exception) {
					System.out.println(exception.getMessage());
				}
				try {
					String newOutput = input.updatedOutput();
					if (newOutput.equalsIgnoreCase("N")) {
						System.out.println("Thanks for using our application !!!");
						// break;
						System.exit(0);
					}
				} catch (Exception ex) {
					System.out.println(ex.getMessage());

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
