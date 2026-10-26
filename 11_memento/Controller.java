package memento.guistate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history (undo list)
    private List<IMemento> redoHistory; // Undone states that can be redone

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        model.setOption(optionNumber, choice);
        gui.updateHistory();
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        model.setIsSelected(isSelected);
        gui.updateHistory();
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (stepBack()) {
            gui.updateGui();
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            System.out.println("Memento found in redo history");
            history.add(model.createMemento());
            IMemento nextState = redoHistory.remove(redoHistory.size() - 1);
            model.restoreState(nextState);
            gui.updateGui();
        }
    }

    // Restore the state at the given index of the history. All states after it,
    // as well as the current state, are moved to the redo list, so this is the
    // same as pressing undo repeatedly until that state is reached.
    public void restoreFromHistory(int index) {
        if (index < 0 || index >= history.size()) {
            return;
        }
        while (history.size() > index) {
            stepBack();
        }
        gui.updateGui();
    }

    public List<IMemento> getHistory() {
        return Collections.unmodifiableList(history);
    }

    private boolean stepBack() {
        if (history.isEmpty()) {
            return false;
        }
        System.out.println("Memento found in history");
        redoHistory.add(model.createMemento());
        IMemento previousState = history.remove(history.size() - 1);
        model.restoreState(previousState);
        return true;
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
        redoHistory.clear(); // a new change invalidates the redo history
    }
}
