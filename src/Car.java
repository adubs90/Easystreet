/*
 * TCSS 305 - Autumn 2011 
 * Homework 2: Easy Street 
 * Author: Alex Stringham 
 * UWNetID: ats3216
 */

import java.util.Map;

/**
 * The Car child class for the Easy Street program.
 * 
 * @author Alex
 * @version Oct 13 2011
 * 
 */
public class Car extends Vehicles
{

  /**
   * The death time.
   */
  private static final int DEATH_TIME = 10;

  /**
   * @param the_x sets the x-coordinate.
   * @param the_y sets the y-coordinate.
   * @param the_dir sets the direction of the car.
   * @param the_terrain sets the terrain which the car starts on.
   */

  public Car(final int the_x, final int the_y, final Direction the_dir,
             final Terrain the_terrain)
  {
    super(the_x, the_y, the_dir, the_terrain, DEATH_TIME, "Car");
  }

  /**
   * @param the_terrain sets the terrain in which cars drive on.
   * @param the_light sets the color of the light in which cars can drive
   *          through.
   * @return returns the terrains and lights which cars can drive on.
   */
  public final boolean canPass(final Terrain the_terrain, final Light the_light)
  {
    boolean car_can_pass = false;
    if (the_terrain == Terrain.STREET)
    {
      car_can_pass = true;
    }
    else if (the_terrain == Terrain.LIGHT && the_light == Light.GREEN)
    {
      car_can_pass = true;
    }
    else if (the_terrain == Terrain.LIGHT && the_light == Light.YELLOW)
    {
      car_can_pass = true;
    }
    return car_can_pass;
  }

  /**
   * @param the_neighbors sets type of terrain is adjacent to the car at current
   *          direction.
   * @param the_light sets how a car reacts when coming up to a light.
   * @return returns the direction in which the car moves after hitting an
   *         intersection.
   */

  public final Direction chooseDirection(final Map<Direction, Terrain> the_neighbors,
                                         final Light the_light)
  {

    Direction cars_direction = getDirection();

    if (the_neighbors.get(cars_direction) != Terrain.STREET || the_light != Light.RED)
    {
      final Direction[] car_array =
          new Direction[] {cars_direction, 
                           cars_direction.left(), 
                           cars_direction.right(),
                           cars_direction.reverse()};

      final int direction_num = car_array.length;

      for (int i = 0; i < direction_num; i++)
      {
        final Direction new_direction = car_array[i];

        if (canPass((Terrain) the_neighbors.get(new_direction), the_light))
        {
          return new_direction;
        }

      }
    }
    while (the_neighbors.get(cars_direction) == Terrain.LIGHT && the_light == Light.RED)
    {
      cars_direction = Direction.CENTER;
    }
    return cars_direction;

  }

}
