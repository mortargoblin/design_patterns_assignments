public class AFactory extends UIFactory {

  public Button createButton(String text) {
    Button element = new ButtonA();
    element.setText(text);
    return element;
  }

  public TextField createTextField(String text) {
    TextField element = new TextFieldA();
    element.setText(text);
    return element;
  }

  public Checkbox createCheckbox(String text) {
    Checkbox element = new CheckboxA();
    element.setText(text);
    return element;
  }

}
