package application;

import java.io.IOException;
import java.net.URL;

import controllers.Controller;
import controllers.HomePageController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

public class Loader {
	
	private Pane view;
	private FXMLLoader loader = new FXMLLoader();

	public Pane getPage(String fileName) throws IOException {
		URL fileUrl = HomePageController.class.getResource("/view" + fileName +".fxml");
		loader.setLocation(fileUrl);
		view = loader.load(fileUrl);
		return view;

	}



}
