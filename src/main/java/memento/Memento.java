package memento;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Memento implements IMemento {

    private int[] options;
    private boolean isSelected;

    private String timestamp;
    private String label;

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone();
        this.isSelected = isSelected;

        this.timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        this.label = "Colors: [" + options[0] + "," + options[1] + "," + options[2] +
                "], Check: " + isSelected;
    }

    public int[] getOptions() {
        return options;
    }

    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return timestamp + " - " + label;
    }
}