/**
Name: Kevin Zhou
<p>
Date: June 7, 2022
Description: Moveable Pipe for flappy bird
*/

import javafx.scene.shape.*; 

/**
A pipe that moves horizontally with random vertical position
*/
public class Pipe extends Sprite
{
   //variables & constants
   final int START_X = 1120;
   final int END_X = -120;
   final int MIN_Y = -200;
   final int MAX_Y = 0;
   final int GAP = 200;

   private int currentY;
   private boolean isTopPipe;
   private Pipe pipeTop;
   
   /**
   constructor for character
   @param xPosition the initial x position
   @param yPosition the initial y position
   @param imageName the name of the image
   @param isTopPipe is this pipe the top or bottom pipe
   */
   public Pipe(int xPosition, int yPosition, String imageName, boolean isTopPipe)
   {
      super(xPosition, yPosition, imageName);
      this.isTopPipe = isTopPipe;
   }
   
   /**
   gets the current y value of the pipe
   @return the current y value of the pipe
   */
   public int getCurrentY()
   {
      return currentY;
   }
   
   /**
   sets the top pipe for a down one, pairing the two pipes
   @param pipeTop the top pipe
   */
   public void setPipeTop(Pipe pipeTop)
   {
      this.pipeTop = pipeTop;
   }      
   
   /**
   creates a path for the pipe with random vertical position
   @return the path that the pipes moves on
   */
   public Path createPath()
   { 
      Path p = new Path();
      int y;
      
      //If a top pipe, uses random vertical position, otherwise the down pipe has the fixed gap with its pair of the top pipe.  
      if (this.isTopPipe)
      {      
         y = super.getRandomNumber(MIN_Y, MAX_Y);
      }
      else
      {
         y = this.pipeTop.getCurrentY() + GAP + (int)image.getImage().getHeight();
      }

      p.getElements().add(new MoveTo(START_X, y));
      p.getElements().add(new LineTo(END_X, y));

      //update current y position of the top pipe      
      this.currentY = y;
      return p;
   }
}