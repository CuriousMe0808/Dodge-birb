/**
Name: Kevin Zhou
<p>
Date: June 7, 2022
Description: Sprite for flappy bird
*/
import javafx.scene.image.ImageView;
import javafx.scene.Group; 
import javafx.scene.shape.Path; 
import javafx.util.Duration; 
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.animation.PathTransition;
import javafx.util.Duration; 
import javafx.scene.shape.*;
import java.lang.Math;

/**
An abstract class representing a sprite in the game.
*/
public abstract class Sprite
{
   /**
   x position of sprite
   */
   private int xPosition;
   
   /**
   y position of sprite
   */
   private int yPosition;
   
   
   /**
   image of sprite
   */
   protected ImageView image;
   
   /**
   Default constructor
   */
   public Sprite()
   {
      this.xPosition = 0;
      this.yPosition = 0;
      this.image = null;
   }
   
   /**
   Not default constructor
   @param xPosition the initial x position of the sprite
   @param yPosition the initial y position of the sprite
   @param imageName the name of the sprite
   */
   public Sprite(int xPosition, int yPosition, String imageName)
   {
      this.xPosition = xPosition;
      this.yPosition = yPosition;
      this.image = new ImageView(imageName);
      this.image.setX(xPosition);
      this.image.setY(yPosition);
   }   
    
   /**
   get the image
   @return the image
   */
   public ImageView getImage()
   {
      return this.image;
   }
   
   /**
   see's if the sprite is intersecting with another sprite
   @param s another Sprite object, to which this Sprite object is intersecting
   @return true if the two sprites are intersecting
   */
   public boolean isIntersect(Sprite s)
   {
      return image.getBoundsInParent().intersects(s.image.getBoundsInParent());
   }
   
   /**
   adds the image to the group
   @param g a Group object which this Sprite object is added to.
   */
   public void addToGroup(Group g)
   {
      g.getChildren().add(this.image);
   }
   
   /**
   removes the sprite from the group
   @param g a Group object which this Sprite object to be removed from.
   */
   public void removeFromGroup(Group g)
   {
      g.getChildren().remove(this.image);
   }

   /**
   moves the sprite, continuously following a path.
   @param duration the duration that the sprite will move
   */
   public void move(int duration)
   {
      PathTransition pt = new PathTransition(Duration.millis(duration), createPath(), this.image);
      pt.setOnFinished(e -> {
         pt.setPath(createPath());              
         pt.play();
         
      });
      pt.play();
   }   

   //Abstract method, holds place for sub-class to provide detailed path
   public abstract Path createPath();
      
   /**
   Return a random position within the range
   @param min the minimum the number can be
   @param max the maxmimum the number can be 
   */
   public int getRandomNumber(int min, int max)
   {
      int range = max - min + 1;
      return (int)(Math.random() * range) + min;
   }
}