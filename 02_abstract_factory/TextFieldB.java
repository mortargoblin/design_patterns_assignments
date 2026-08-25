public class TextFieldB extends TextField {
  public void display() {
    System.out.printf("""
        +========TEXT=========+
        ||%-19s||
        +=====================+
        """, text);
  }
}
