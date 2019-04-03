package io;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.application.Platform;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/*
 * This class allows user to import their own audio files
 * it opens up their personal file explorer where the user can navigate
 * and add any wav file they want
 * 
 * 
 */
public class ImportFiles {

	private Stage stage;
	private Path to;
	private Path from;
	//private String src = "sound_samples/";
	public String name;
	public File file;
	
	
	/*
	 * This acts as the visible stage of their file explorer
	 */
	public void init(Stage stage) {
		this.stage = stage;
	}
	
	/*
	 * This opens their file explorer and copies the chosen audio
	 * to src/Audio
	 */
	public void open(String s) {
		FileChooser fc = new FileChooser();
		file = fc.showOpenDialog(stage);
		name = file.getName();
		to = Paths.get(s + file.getName());
		from = file.toPath();
		/*This sets the initial directory when the file explorer opens
		 works on MACS but not windows. Windows default directory is "This PC"
		 */
		fc.setInitialDirectory(new File(System.getProperty("user.home")));
		if(file != null) {
		try {
			Files.copy(from, to); //Copies files from personal directory to src/Audio
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	}
	
	public File LoggerOpen() {
		FileChooser fc = new FileChooser();
		file = fc.showOpenDialog(stage);
		return file;
	}
	
	
	/*
	 * Closes file explorer
	 */
	public void close() {
		Platform.exit();
	}

}