package com.nagarro.csvservices;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import com.nagarro.constants.*;
import com.opencsv.exceptions.CsvValidationException;

public class CsvWatcher implements Runnable {

	CsvFileReader csv = new CsvFileReader();
	final long timeInterval = 10000;

	@Override
	public void run() {
		while (true) {
			WatchService watchService = null;
			try {
				watchService = FileSystems.getDefault().newWatchService();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Path path = Paths.get(Constants.DIRECTORY_PATH);

			try {
				path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
						StandardWatchEventKinds.ENTRY_MODIFY);
			} catch (IOException e) {
				e.printStackTrace();
			}

			WatchKey key;
			try {

				while ((key = watchService.take()) != null) {

					for (WatchEvent<?> event : key.pollEvents()) {
						Path filename = (Path) event.context();
						File file = path.resolve(filename).toFile();
						if (file.getName().endsWith(".csv")) {
							if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE
									|| event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
								csv.readFiles(file.toString());
							}
						}
					}
					key.reset();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (CsvValidationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				Thread.sleep(timeInterval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
