package memento.guistate;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Gui extends Application {

    // create a GUI with three adjacent ColorBoxes and one CheckBox below them
    private Controller controller;
    private ColorBox colorBox1;
    private ColorBox colorBox2;
    private ColorBox colorBox3;
    private CheckBox checkBox;
    private ListView<IMemento> historyList;

    public void start(Stage stage) {

        controller = new Controller(this);

        // Insets for margin and padding
        Insets insets = new Insets(10, 10, 10, 10);

        // Create three ColorBoxes
        colorBox1 = new ColorBox(1, controller);
        colorBox2 = new ColorBox(2, controller);
        colorBox3 = new ColorBox(3, controller);

        // Create a CheckBox
        checkBox = new CheckBox("Click me!");
        checkBox.setPadding(insets);

        // Add the ColorBoxes and CheckBox to a HBox
        HBox hBox = new HBox(colorBox1.getRectangle(), colorBox2.getRectangle(), colorBox3.getRectangle());
        hBox.setSpacing(10);

        hBox.setMargin(colorBox1.getRectangle(), insets);
        hBox.setMargin(colorBox2.getRectangle(), insets);
        hBox.setMargin(colorBox3.getRectangle(), insets);


        Label label = new Label("Press Ctrl-Z to undo and Ctrl-Y to redo the last change.");
        label.setPadding(insets);

        // create a VBox that contains the HBox and the CheckBox
        VBox vBox = new VBox(hBox, checkBox, label);
        // call controller when the CheckBox is clicked
        checkBox.setOnAction(event -> {
            controller.setIsSelected(checkBox.isSelected());
        });

        // Set the HBox to be the root of the Scene
        Scene scene = new Scene(vBox);
        scene.setOnKeyPressed(this::handleKeyPressed);


        stage.setScene(scene);
        stage.setTitle("Memento Pattern Example");
        stage.show();

        createHistoryWindow(stage);
    }

    private void handleKeyPressed(KeyEvent event) {
        if (event.isControlDown() && event.getCode() == KeyCode.Z) {
            // Ctrl-Z: undo
            System.out.println("Undo key combination pressed");
            controller.undo();
        } else if (event.isControlDown() && event.getCode() == KeyCode.Y) {
            // Ctrl-Y: redo
            System.out.println("Redo key combination pressed");
            controller.redo();
        }
    }

    private void createHistoryWindow(Stage mainStage) {
        historyList = new ListView<>();
        historyList.setPlaceholder(new Label("No history yet."));
        // restore the clicked state
        historyList.setOnMouseClicked(event -> {
            int index = historyList.getSelectionModel().getSelectedIndex();
            if (index >= 0) {
                controller.restoreFromHistory(index);
            }
        });

        Label label = new Label("Click a state to restore it.");
        label.setPadding(new Insets(10, 10, 10, 10));

        Scene historyScene = new Scene(new VBox(label, historyList), 350, 300);
        historyScene.setOnKeyPressed(this::handleKeyPressed);

        Stage historyStage = new Stage();
        historyStage.setScene(historyScene);
        historyStage.setTitle("History");
        historyStage.setX(mainStage.getX() + mainStage.getWidth() + 10);
        historyStage.setY(mainStage.getY());
        historyStage.show();
    }

    public void updateHistory() {
        // refresh the history window with the saved states
        historyList.getItems().setAll(controller.getHistory());
    }

    public void updateGui() {
        // called after restoring state from a Memento
        colorBox1.setColor(controller.getOption(1));
        colorBox2.setColor(controller.getOption(2));
        colorBox3.setColor(controller.getOption(3));
        checkBox.setSelected(controller.getIsSelected());
        updateHistory();
    }
}
