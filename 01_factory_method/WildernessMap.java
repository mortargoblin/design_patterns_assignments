import java.util.Random;

public class WildernessMap extends Map {
  private static final Random rand = new Random();

  public Tile createTile() {
    return switch (rand.nextInt(3)) {
      case 0 -> new SwampTile();
      case 1 -> new WaterTile();
      default -> new ForestTile();
    };
  }
}
