/**
Name: Kevin Zhou
<p>
Date: June 7, 2022
Description: Moveable character for flappy bird
*/
public class Character extends Sprite
{
   //variables & constants
   final int DURATION = 1000;
   
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
   moves the character by a certain height for when a certain button is pressed
   @param height the height to be changed by
   */
   public void onPressed(int height)
   {
      this.move(0, -height, DURATION);
   }
}