/*
 * TCSS 305 - Autumn 2011 
 * Homework 2: Easy Street 
 * Author: Alex Stringham 
 * UWNetID: ats3216
 */

import java.util.Map;

/**
 * The Truck child class for the Easy Street program.
 * 
 * @author Alex
 * @version Oct 13 2011
 * 
 */
public class Truck extends Vehicles
{

  /**
   * @param the_x sets the x-coordinate.
   * @param the_y sets the y-coordinate.
   * @param the_dir sets the direction of the truck.
   * @param the_terrain sets the terrain which the truck starts on.
   */
  public Truck(final int the_x, final int the_y, final Direction the_dir,
               final Terrain the_terrain)
  {
    super(the_x, the_y, the_dir, the_terrain, 0, "Truck");
  }

  /**
   * @param the_terrain sets the terrain in which trucks drive on.
   * @param the_light sets the color of the light in which trucks can drive
   *          through.
   * @return returns the terrains and lights which trucks can drive on.
   */

  public final boolean canPass(final Terrain the_terrain, final Light the_light)
  {
    return the_terrain == Terrain.STREET || the_terrain == Terrain.LIGHT;
  }

  /**
   * @param the_neighbors sets type of terrain is adjacent to the truck at
   *          current direction.
   * @param the_light sets how a truck reacts when coming up to a light.
   * @return returns the direction in which the truck moves after hitting an
   *         intersection.
   */

  public final Direction chooseDirection(final Map<Direction, Terrain> the_neighbors,
                                         final Light the_light)
  {
    Direction rand_direction = Direction.random();
    if (vehicMoves(the_neighbors, the_light))
    {
      while (the_neighbors.get(rand_direction) != Terrain.STREET &&
             the_neighbors.get(rand_direction) != Terrain.LIGHT ||
             rand_direction == getDirection().reverse())
      {
        rand_direction = Direction.random();
      }
    }
    else
    {
      setDirection(rand_direction.reverse());
    }

    return rand_direction;
  }
}
