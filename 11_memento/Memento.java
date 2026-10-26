package memento.guistate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Memento implements IMemento {
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final String[] COLOR_NAMES = {"Red", "Blue", "Yellow"};

    private int[] options;
    private boolean isSelected;
    private LocalDateTime timestamp;

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone(); // Copy options array
        this.isSelected = isSelected;
        this.timestamp = LocalDateTime.now();
        System.out.println("Memento created");
    }

    public int[] getOptions() {
        return options.clone(); // Copy so restored model can't modify the memento
    }

    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String getDescription() {
        return timestamp.format(TIME_FORMAT) + "  -  "
                + COLOR_NAMES[options[0]] + ", "
                + COLOR_NAMES[options[1]] + ", "
                + COLOR_NAMES[options[2]] + ", "
                + (isSelected ? "checked" : "unchecked");
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
