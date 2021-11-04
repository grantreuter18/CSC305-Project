package application;
	

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//make gridPaneMain
			GridPane gridPaneMain = new GridPane();
			gridPaneMain.setAlignment(Pos.CENTER);
			Scene scene = new Scene(gridPaneMain, 900, 300);
			primaryStage.setTitle("My Schedule");
			gridPaneMain.setPadding(new Insets(10));
			gridPaneMain.setHgap(15); 
			gridPaneMain.setVgap(15); 
			
			//title for window
			Label wordLabel = new Label("Arches Semester Data to Calender");
			wordLabel.setFont(new Font("Arial", 20));
			gridPaneMain.add(wordLabel, 0, 0); 
			
			//name of text box 
			Label schedule = new Label("Insert Class Schedule:");
			gridPaneMain.add(schedule, 0, 2);
 
			//Creates text box
			TextArea userTextField = new TextArea();
			gridPaneMain.add(userTextField, 1, 2);
			
			//Creates submit button 
			Button submit = new Button("Submit");
			gridPaneMain.add(submit, 2, 2);
			
			//Submit Button
			submit.setOnAction(value -> {
				//pop-up window
				Stage popUpStage = new Stage();
				popUpStage.setTitle("Schedule View");
				GridPane gridPaneMessage = new GridPane();
				Scene scenePopUp = new Scene(gridPaneMessage, 300, 200);
				popUpStage.setScene(scenePopUp);
				popUpStage.show(); 
				
				//Storing data from class schedule
				String scheduleText = userTextField.getText();
				String[] classSchedule = scheduleText.split("\n");
				SubmitHandler submitted = new SubmitHandler(classSchedule);
				
				//FOR TESTING PURPOSES ONLY
				System.out.println(submitted.toString());
				
			});
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
