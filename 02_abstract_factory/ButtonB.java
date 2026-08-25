public class ButtonB extends Button{
  public void display() {
    System.out.printf("""
        +====BUTTON====+
        ||%-12s||
        +==============+
        """, text);
  }
}
