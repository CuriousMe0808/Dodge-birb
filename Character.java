/**
Name: Kevin Zhou
<p>
Date: June 7, 2022
Description: Moveable character for flappy bird
*/
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.*; 

/**
The character that the gamer plays, as a bird with gravity, and can jump up a little bit, extends from Sprite.
*/
public class Character extends Sprite
{
   //variables & constants
   final int FALLDURATION = 5000;
   final int JUMPDURATION = 200;
   final int JUMP_HEIGHT = -50;
   final int BOTTOM_LIMIT = 560;
   
   /**
   constructor for character
   @param xPosition the initial x position
   @param yPosition the initial y position
   @param imageName the name of the image
   */
   public Character(int xPosition, int yPosition, String imageName)
   {
      super(xPosition, yPosition, imageName);
   }
   
   /**
   method to make the character fall
   @param height the height that the character falls to
   */
   public void fall(int height)
   {
      //the gravity movement of the character.
      TranslateTransition tt = new TranslateTransition(Duration.millis(FALLDURATION), image);
      tt.setByY(height);
      tt.play();
      
      image.getScene().addEventHandler(KeyEvent.KEY_PRESSED, (key) -> 
      {
         if(key.getCode()==KeyCode.SPACE) { //if spacebar is pressed, jump up
            tt.stop();
         
            // the jump up movement upon pressing the spacebar.
            TranslateTransition t2 = new TranslateTransition(Duration.millis(JUMPDURATION), image);
            t2.setByY(JUMP_HEIGHT);
            t2.setOnFinished(e -> {
               tt.play();
            });
            t2.play();
         }
      });
   }
   
   /**
   Checks if the character crossed the border of the screen
   @return whether the character has crossed the border or not
   */
   public boolean isCrossBorder()
   {
      int currentY = (int)image.localToScene(image.getX(), image.getY()).getY();
      return currentY > BOTTOM_LIMIT || currentY < 0;
   }
   
   /**
   Creates path for the character to move along
   @return the path that the character goes on
   */
   public Path createPath()
   {
      return new Path();       
   }
}