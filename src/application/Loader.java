package application;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class Loader {
	
	private Pane view;
	
	public Pane getPage(String fileName) {
	try {
		URL fileUrl = HomePageController.class.getResource(fileName +".fxml");
		
		if (fileUrl == null) {
			throw new java.io.FileNotFoundException("File not found.");
		}
		
		new FXMLLoader();
		view = FXMLLoader.load(fileUrl); 
		}
	
		catch (Exception e) {
			System.out.println("no page");
		}
	return view;
	}

}
