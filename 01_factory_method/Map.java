public abstract class Map {
  private Tile[][] map;

  public abstract Tile createTile();

  public void display() {
    for (int y = 0; y < map.length; y++) {
      for (int x = 0; x < map[0].length; x++) {
        System.out.printf("%c", map[y][x].getCharacter());
      }
      System.out.printf("\n");
    }
  }

  public void generate(int width, int height) {
    map = new Tile[height][width];
    for (int y = 0; y < height; y++)
      for (int x = 0; x < width; x++) {
        map[y][x] = createTile();
      }
  }
}
