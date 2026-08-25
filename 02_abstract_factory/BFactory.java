public class BFactory extends UIFactory {

  public Button createButton(String text) {
    Button element = new ButtonB();
    element.setText(text);
    return element;
  }

  public TextField createTextField(String text) {
    TextField element = new TextFieldB();
    element.setText(text);
    return element;
  }

  public Checkbox createCheckbox(String text) {
    Checkbox element = new CheckboxB();
    element.setText(text);
    return element;
  }

}
