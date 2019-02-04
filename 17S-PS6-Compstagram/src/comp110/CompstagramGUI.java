package comp110;

import comp110.filters.CompstagramModel;
import comp110.support.CompstagramViewController;
import comp110.support.ImageUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/*
 * This file is support code which you should not change before submitting for full credit.
 * 
 * This GUI will not work until you reach Part 3.
 */

public class CompstagramGUI extends Application {

	public static void main(String[] args) {
		CompstagramGUI.launch(args);
	}

	public void start(Stage stage) throws Exception {

		CompstagramModel model = new CompstagramModel();
		model.setInput(ImageUtils.load("file:photos/old-well.jpg"));

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("support/CompstagramView.fxml"));
		Parent view = fxmlLoader.load();

		CompstagramViewController controller = (CompstagramViewController) fxmlLoader.getController();
		controller.init(model);

		Scene scene = new Scene(view, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
		stage.setTitle("Compstagram");
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();

	}

}