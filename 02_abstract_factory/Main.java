public class Main {

  public static void main(String[] args) {
    System.out.printf("\n");

    UIFactory a = new AFactory();
    UIFactory b = new BFactory();

    Button btnA = a.createButton("button-a");
    Button btnB = b.createButton("button-b");
    TextField fldA = a.createTextField("field-a");
    TextField fldB = b.createTextField("field-b");
    Checkbox cbA = a.createCheckbox("checkbox-a");
    Checkbox cbB = b.createCheckbox("checkbox-b");

    btnA.display();
    fldA.display();
    cbA.display();
    cbA.setText("alternative-checkbox-a");
    cbA.display();

    System.out.printf("\n\n");

    btnB.display();
    fldB.display();
    cbB.display();
    cbB.setText("alternative-checkbox-b");
    cbB.display();
    System.out.printf("\n");
  }

}
