package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
//import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
	ArrayList<Image> cards = new ArrayList<Image>();
	
	private ImageView iv;
	
	private HBox hb1, hb2;
    
	@Override
	public void start(Stage primaryStage) {
		try {

			primaryStage.setTitle("World's coolest Blackjack");

			Button btn1 = new Button();
			Button btn2 = new Button();
			btn2.setText("Add");
			btn2.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {

					hb2.getChildren().add(createIV());

				}
			});

			btn1.setText("Remove");
			btn1.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					hb2.getChildren().remove(0);
				}
			});

			hb1 = new HBox();
			hb1.setAlignment(Pos.CENTER);
			hb1.getChildren().add(btn2);
			hb1.getChildren().add(btn1);

			hb2 = new HBox();
			// hb2.getChildren().add(createIVandAddToHbox());
			hb2.setAlignment(Pos.CENTER);
			// StackPane root = new StackPane();
			BorderPane border = new BorderPane();
			border.setBottom(hb1);
			border.setCenter(hb2);

			Scene scene = new Scene(border, 400, 400);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Node createIV() {
        int rand=(int)(Math.random()*3);
        ArrayList<Image> images = new ArrayList<Image>();
        Image img = new Image("1.jpg");
        Image img1 = new Image("2.jpg");
        Image img2 = new Image("3.jpg");
        images.add(img);
        images.add(img1);
        images.add(img2);
		iv = new ImageView(images.get(rand));
		iv.setFitWidth(100);
		iv.setPreserveRatio(true);
		return iv;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
