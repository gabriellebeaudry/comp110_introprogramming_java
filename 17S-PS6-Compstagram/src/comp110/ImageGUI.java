package comp110;

import comp110.support.ImageUtils;
import comp110.support.ImageViewController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/*
 * This file is support code which you should not change before submitting for full credit.
 */

public class ImageGUI extends Application {

	public static void main(String[] args) {
		ImageGUI.launch(args);
	}

	public void start(Stage stage) throws Exception {

		Image image = ImageUtils.load("file:photos/old-well.jpg");

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("support/ImageView.fxml"));
		Parent view = fxmlLoader.load();

		ImageViewController controller = (ImageViewController) fxmlLoader.getController();
		controller.init(image);

		Scene scene = new Scene(view, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
		stage.setTitle("Image Viewer");
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();

	}

}