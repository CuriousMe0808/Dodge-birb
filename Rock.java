/**
Name: Kevin Zhou
<p>
Date: June 7, 2022
Description: Moveable Pipe for flappy bird
*/

import javafx.scene.shape.*;

/**
A rock that can hit from random top horizontal position, down to ground, extends from Sprite
*/
public class Rock extends Sprite
{
   final int MINSTART_X = 300;
   final int MAXSTART_X = 1000;
   final int START_Y = 0;
   final int END_Y = 600;
   final int END_X = 0;
   
   /**
   Constructor for rock
   @param xPosition initial x position of rock
   @param yPosition initial y position of rock
   @param imageName name of the image file
   */
   public Rock(int xPosition, int yPosition, String imageName)
   {
      super(xPosition, yPosition, imageName);
      super.image.setFitHeight(50);
      super.image.setPreserveRatio(true);
   }
   
   /**
   creates path for rock to follow, with random horizontal position
   @return the path that the rock goes
   */
   public Path createPath()
   {
      Path p = new Path();
      int x = getRandomNumber(MINSTART_X, MAXSTART_X);

      p.getElements().add(new MoveTo(x, START_Y));
      p.getElements().add(new LineTo(END_X, END_Y));
      
      return p;
   }  
}