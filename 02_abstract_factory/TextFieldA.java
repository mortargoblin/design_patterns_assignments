public class TextFieldA extends TextField {
  public void display() {
    System.out.printf("""
        +--------TEXT---------+
        |%-21s|
        +---------------------+
        """, text);
  }
}
