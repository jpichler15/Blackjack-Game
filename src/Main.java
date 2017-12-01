import javafx.*;
import java.util.*;
import java.io.*;
import javafx.application.*;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
public class Main extends Application{
	
	public static void main(String[] args) {
		launch(args); 
	}

	@Override
	public void start(Stage Stage) throws Exception { 
		OpeningWindow ow = new OpeningWindow();
		ow.Display();
		
		
	}


	
}
