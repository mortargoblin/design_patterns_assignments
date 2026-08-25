public class ButtonA extends Button{
  public void display() {
    System.out.printf("""
        +----BUTTON----+
        |%-14s|
        +--------------+
        """, text);
  }
}
