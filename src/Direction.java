/*
 * TCSS 305 - Autumn 2011 
 * Homework 2: Easy Street 
 * Author: Daniel M. Zimmerman and Marty Stepp
 */

import java.util.Random;

/**
 * An enumeration (and associated functionality) for directions in which a
 * vehicle may travel.
 * 
 * @author Daniel M. Zimmerman
 * @author Marty Stepp
 * @version Autumn 2011
 */

public enum Direction
{
  /**
   * North (which is up on the screen).
   */
  NORTH('N'), 
  
  /**
   * West (which is left on the screen).
   */
  WEST('W'), 
  
  /**
   * South (which is down on the screen). 
   */
  SOUTH('S'), 
  
  /**
   * East (which is right on the screen).
   */
  EAST('E'), 
  
  /**
   * Center.
   */
  CENTER('C');

  /**
   * A Random that we use for generating random directions.
   */
  private static final Random RANDOM = new Random();
  
  /**
   * The letter corresponding to a particular value of the enumeration.
   */
  private final char my_letter;
  
  // Constructor
  
  /**
   * Constructs a new Terrain with the specified letter.
   * 
   * @param the_letter The letter.
   */
  private Direction(final char the_letter)
  {
    my_letter = the_letter;
  }
  
  // Instance Methods
  
  /**
   * Returns the Direction represented by the given letter.
   * 
   * @param the_letter The letter. 
   * @return the Direction represented by the given letter, 
   * or CENTER if no Direction is represented by the given letter.
   */
  public static Direction valueOf(final char the_letter)
  {
    Direction result = CENTER;
    
    for (Direction direction : Direction.values())
    {
      if (direction.letter() == the_letter)
      {
        result = direction;
        break;
      }
    }
    
    return result;
  }

  /**
   * Returns the letter corresponding to this direction.
   * 
   * @return the letter corresponding to this direction.
   */
  public char letter()
  {
    return my_letter;
  }
  
  /**
   * Returns the direction you get if you rotate this direction
   * counter-clockwise by 90 degrees.
   * 
   * @return the direction you get if you rotate this direction 
   * counter-clockwise by 90 degrees.
   */
  public Direction left()
  {
    Direction result;
    
    switch (this)
    {
      case NORTH: 
        result = WEST;
        break;
      
      case WEST:
        result = SOUTH;
        break;
      
      case SOUTH:
        result = EAST;
        break;
      
      case EAST:
        result = NORTH;
        break;
        
      default:
        result = CENTER;
        break;
    }

    return result;
  }

  /** 
   * Returns a random Direction, other than CENTER. 
   * 
   * @return a random Direction, other than CENTER.
   */
  public static Direction random()
  {
    Direction result = CENTER;
   
    while (result == CENTER)
    {
      result = values()[RANDOM.nextInt(values().length)];
    }

    return result;
  }

  /**
   * Returns the direction you get if you rotate this direction
   * clockwise by 90 degrees.
   * 
   * @return the direction you get if you rotate this direction 
   * clockwise by 90 degrees.
   */
  public Direction right()
  {
    return left().left().left();
  }

  /**
   * Returns the direction opposite this one.
   * 
   * @return the direction opposite this one.
   */
  public Direction reverse()
  {
    return left().left();
  }
  
  /**
   * Returns the change in x-coordinate by moving one space in this
   * direction (for example, WEST would be -1, and NORTH would be 0).
   * 
   * @return the change in x-coordinate.
   */
  public int dx()
  {
    int result = 0;
    
    switch (this)
    {
      case WEST:
        result = -1;
        break;
        
      case EAST:
        result = 1;
        break;
        
      default:
    }
    
    return result; 
  }
  
  /**
   * Returns the change in y-coordinate by moving one space in this
   * direction (for example, WEST would be 0, and NORTH would be 1).
   * 
   * @return the change in x-coordinate.
   */
  public int dy()
  {
    int result = 0;
    
    switch (this)
    {
      case SOUTH:
        result = 1;
        break;
        
      case NORTH:
        result = -1;
        break; 
        
      default:
    }
    
    return result; 
  }
}

// end of class Direction
