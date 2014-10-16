/*
 * TCSS 305 - Autumn 2011 
 * Homework 2: Easy Street 
 * Author: Alex Stringham 
 * UWNetID: ats3216
 */

import java.util.Map;

/**
 * The Human child class for the Easy Street program.
 * 
 * @author Alex
 * @version Oct 13 2011
 * 
 */
public class Human extends Vehicles
{

  /**
   * The death time.
   */
  private static final int DEATH_TIME = 50;

  /**
   * @param the_x sets the x-coordinate.
   * @param the_y sets the y-coordinate.
   * @param the_dir sets the direction of the human.
   * @param the_terrain sets the terrain which the human starts on.
   */

  public Human(final int the_x, final int the_y, final Direction the_dir,
               final Terrain the_terrain)
  {
    super(the_x, the_y, the_dir, the_terrain, DEATH_TIME, "Human");
  }

  /**
   * @param the_terrain sets the terrain in which humans walk on.
   * @param the_light sets the color of the light in which humans can walk
   *          through.
   * @return returns the terrains and lights which humans can walk on.
   */
  public final boolean canPass(final Terrain the_terrain, final Light the_light)
  {
    final Terrain initial_terrain = initialTerrain();
    if (initial_terrain == Terrain.STREET)
    {
      return the_terrain == Terrain.LIGHT || the_terrain == Terrain.STREET;
    }

    return the_terrain.equals(initial_terrain);
  }

  /**
   * @param the_neighbors sets type of terrain is adjacent to the human at
   *          current direction.
   * @param the_light sets how a human reacts when coming up to a light.
   * @return returns the direction in which the human moves after hitting an
   *         intersection.
   */

  public final Direction chooseDirection(final Map<Direction, Terrain> the_neighbors,
                                         final Light the_light)
  {
    Direction human_direction = Direction.random();

    while (the_neighbors.get(human_direction) != initialTerrain())
    {
      human_direction = human_direction.left();
    }

    return human_direction;

  }

}
