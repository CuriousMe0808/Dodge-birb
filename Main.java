/**
Name: Kevin Zhou
<p>
Date: June 8, 2022
Description: it's the main method in here
*/
import javafx.animation.ScaleTransition; 
import javafx.application.Application; 
import static javafx.application.Application.launch; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.paint.Color; 
import javafx.scene.shape.Circle; 
import javafx.stage.Stage; 
import javafx.util.Duration; 
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.animation.TranslateTransition; 
import javafx.util.Duration; 
import javafx.scene.shape.*;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.MoveTo;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;

public class Main extends Application
{
   @Override
   public void start(Stage stage)
   {
      //initialize constructors
      Character bird = new Character(300, 300, "yellowbird.png");
      Sprite pipeUp = new Sprite(500, 500, "pipeUp.png");
      Sprite pipeDown = new Sprite(500, 0, "pipeDown.png");
      
      Group root = new Group();
      //add sprite nodes into group
      bird.addToGroup(root);
      pipeUp.addToGroup(root);
      pipeDown.addToGroup(root);

      Scene scene = new Scene(root, 600, 600, Color.BLUE); //make scene 300 x 300 with background blue
      
      //move the pipes
      pipeUp.move(-600, 0, 4000);
      pipeDown.move(-600, 0, 4000);
      
      scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> 
      {
         if(key.getCode()==KeyCode.SPACE) { //if spacebar is pressed, move up by 50
               bird.onPressed(50);           
         }
      });
      
      stage.setScene(scene);
      stage.show(); //show scene
   } 
   
   public static void main(String[] args)
   {
      launch(args); //run
   }
}