package comp110;

import comp110.support.ColorViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

// Note - running this will result in errors until you complete the Color class!
public class ColorGUI extends Application {

	public static void main(String[] args) {
		ColorGUI.launch(args);
	}

	public void start(Stage stage) throws Exception {

		// TODO: 1.6 - Initialize the Sample Color Below
		Color sample = new Color(0.48, 0.90, 0.83);

		// The following code you should not change until after submission.
		// If you're curious as to how ColorViewController works, you can see
		// all
		// the code in:
		// Package Explorer > Referenced Libraries > ps05-support.jar
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("support/ColorView.fxml"));
		Parent view = fxmlLoader.load();

		ColorViewController controller = (ColorViewController) fxmlLoader.getController();
		controller.init(sample);

		Scene scene = new Scene(view, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
		stage.setTitle("Color Picker");
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();

	}

}