public class Main {
  static Map createMap(int width, int height, char type) {
    Map map;

    if (type == 'c')
      map = new CityMap();
    else if (type == 'w')
      map = new WildernessMap();
    else return null;

    map.generate(width, height);
    return map;
  }

  public static void main() {
    Map city = createMap(30, 20, 'c');
    Map wild = createMap(30, 20, 'w');

    System.out.println("CITY MAP");
    city.display();
    System.out.println("WILDERNESS MAP");
    wild.display();
  }
}
