/**
Name: Kevin Zhou
<p>
Date: June 7, 2022
Description: Sprite for flappy bird
*/
import javafx.scene.image.ImageView;
import javafx.scene.canvas.GraphicsContext;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
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

public class Sprite
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
   private ImageView image;
   
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
   get the x position
   @return x position
   */
   public int getXPosition()
   {
      return this.xPosition;
   }
   
   /**
   get the y position
   @return y position
   */
   public int getYPosition()
   {
      return this.yPosition;
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
   @return if the two sprites are intersecting
   */
   public boolean isIntersect(Sprite s)
   {
      return image.intersects(s.getImage().getBoundsInParent());
   }
   
   /**
   adds the image to the group
   */
   public void addToGroup(Group g)
   {
      g.getChildren().add(this.image);
   }
   
   /**
   moves the sprite
   */
   public void move(int deltaX, int deltaY, int duration)
   {
      TranslateTransition tt = new TranslateTransition(Duration.millis(duration), this.image);
      tt.setByX(deltaX);
      tt.setByY(deltaY);
      tt.play();
   }
}