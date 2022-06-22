/**
Name: Kevin Zhou
<p>
Date: June 8, 2022
Description: it's the main method in here
*/
import javafx.application.Application; 
import static javafx.application.Application.launch; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.paint.Color; 
import javafx.stage.Stage; 
import javafx.scene.layout.*;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;

/**
Main class for Flappy Bird
*/
public class Main extends Application
{
   //variables & constants
   final int SCENE_HEIGHT = 600;
   final int SCENE_WIDTH = 1000;
   
   final Color BACKGROUND_COLOR = Color.CADETBLUE;
   
   final int PIPE_DURATION = 6000;
   final int BULLET_DURATION = 3000;
   final int ROCK_DURATION = 5000;
  
   final int CHARACTER_XPOS = 200;
   final int CHARACTER_YPOS = 300;
   final int CHARACTER_FALL = 600;
      
   final int PIPEBOT_XPOS = 1000;
   final int PIPEBOT_YPOS = 400;
   
   final int PIPETOP_XPOS = 1000;
   final int PIPETOP_YPOS = 0;
   
   final int BULLET_XPOS = 1000;
   final int BULLET_YPOS = 200;
   
   final int ROCK_XPOS = 300;
   final int ROCK_YPOS = 0;   
   
   /**
   Start a stage for the game
   @param stage the stage of the game
   */
   @Override
   public void start(Stage stage)
   {
      //initialize constructors
      Character bird = new Character(CHARACTER_XPOS, CHARACTER_YPOS, "yellowbird.png");
      Pipe pipeTop = new Pipe(PIPETOP_XPOS, PIPETOP_YPOS, "pipeTop.png", true);
      Pipe pipeBot = new Pipe(PIPEBOT_XPOS, PIPEBOT_YPOS, "pipeBot.png", false);
      Bullet bullet = new Bullet(BULLET_XPOS, BULLET_YPOS, "bullet.png");
      Rock rock = new Rock(ROCK_XPOS, ROCK_YPOS, "rock.png");

      //Create the root group
      Group root = new Group();
      
      //Add sprite nodes into group
      bird.addToGroup(root);
      pipeBot.addToGroup(root);
      pipeTop.addToGroup(root);
      bullet.addToGroup(root);
      rock.addToGroup(root);
      Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT, BACKGROUND_COLOR); //make scene
   
      //Pair the bottom pipe with top pipe
      pipeBot.setPipeTop(pipeTop);
      
      //Move the pipes
      pipeTop.move(PIPE_DURATION);
      pipeBot.move(PIPE_DURATION);
      
      //Move the bullet and rock 
      bullet.move(BULLET_DURATION);
      rock.move(ROCK_DURATION);
      
      //Let bird falls
      bird.fall(CHARACTER_FALL);
      
      //Display position coordinates
//       Text t = new Text(100, 100, "");
//       root.getChildren().add(t);
      
      new AnimationTimer()
      {
         public void handle(long currentNanoTime)
         {
            //check if the bird intersects with any obstacles
            if (
                  (bird.isIntersect(pipeBot)) || 
                  (bird.isIntersect(pipeTop)) || 
                  (bird.isIntersect(rock))    || 
                  (bird.isIntersect(bullet))  || 
                  (bird.isCrossBorder())
               )
            {
                stage.close(); //nukes the program
               
//                bird.removeFromGroup(root);
//                pipeBot.removeFromGroup(root);  
//                pipeTop.removeFromGroup(root);   
//                rock.removeFromGroup(root);
//                bullet.removeFromGroup(root);  
            }
            
            //String p = "xLayout = "+ pipeTop.getImage().localToScene(pipeTop.getImage().getX(), pipeTop.getImage().getY()) + "\nCurentY = " + bird.getImage().localToScene(bird.getImage().getX(), bird.getImage().getY());
            //t.setText(p);
         }
      }.start();
      
      stage.setScene(scene);
      stage.show(); //show scene
   } 
   
   /**
   Main method to run Flappy Bird
   */
   public static void main(String[] args)
   {
      launch(args); //run
   }  
}