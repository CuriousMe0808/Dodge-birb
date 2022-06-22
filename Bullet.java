/**
Name: Kevin Zhou
<p>
Date: June 7, 2022
Description: Moveable Pipe for flappy bird
*/

import javafx.scene.shape.*;

/**
A bullet that can be shot horizontally with random vertical position, extends from Sprite
*/
public class Bullet extends Sprite
{
   //constants
   final int START_X = 1000;
   final int END_X = -50;
   final int MIN_Y = 100;
   final int MAX_Y = 500;
   
   /**
   constructor, makes bullet object
   @param xPosition the initial x position of the bullet
   @param yPosition the initial y position of the bullet
   @param imageName the name of the image
   */
   public Bullet(int xPosition, int yPosition, String imageName)
   {
      super(xPosition, yPosition, imageName);
      super.image.setFitHeight(50);
      super.image.setPreserveRatio(true);
   }
   
   /**
   creates path for bullet to go, with random vertical postion and move horizontally
   @return the path the bullet goes on
   */
   public Path createPath()
   {
      Path p = new Path();
      int y = getRandomNumber(MIN_Y, MAX_Y);

      p.getElements().add(new MoveTo(START_X, y));
      p.getElements().add(new LineTo(END_X, y));
      
      return p;
   }  
}
