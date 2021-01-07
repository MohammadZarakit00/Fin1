package application;

import java.net.URL;

import controllers.HomePageController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

public class Loader {
	
	private Pane view;
	private Main main;

	public Pane getPage(String fileName) {
	try {
		URL fileUrl = HomePageController.class.getResource("/view" + fileName +".fxml");
		
		if (fileUrl == null) {
			throw new java.io.FileNotFoundException("File not found.");
		}

		new FXMLLoader();
		view = FXMLLoader.load(fileUrl);

		}
	
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	return view;
	}

	public void setMain(Main main){
		this.main = main;
	}

	public Parent setPage(String filePath) {
		try {
			return FXMLLoader.load(this.getClass().getResource("/view/Homepage.fxml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
