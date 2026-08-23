import java.util.Random;

public class CityMap extends Map {
  private static final Random rand = new Random();

  public Tile createTile() {
    return switch (rand.nextInt(3)) {
      case 0 -> new RoadTile();
      case 1 -> new ForestTile();
      default -> new BuildingTile();
    };
  }
}

