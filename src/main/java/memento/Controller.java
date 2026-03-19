package memento;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private Model model;
    private Gui gui;

    private List<IMemento> undoHistory;
    private List<IMemento> redoHistory;

    private HistoryWindow historyWindow;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;

        undoHistory = new ArrayList<>();
        redoHistory = new ArrayList<>();

        historyWindow = new HistoryWindow(this);
    }

    public void setOption(int optionNumber, int choice) {
        saveToUndo();
        redoHistory.clear();
        model.setOption(optionNumber, choice);
        historyWindow.refresh(undoHistory);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToUndo();
        redoHistory.clear();
        model.setIsSelected(isSelected);
        historyWindow.refresh(undoHistory);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    private void saveToUndo() {
        undoHistory.add(model.createMemento());
        historyWindow.refresh(undoHistory);
    }

    public void undo() {
        if (!undoHistory.isEmpty()) {
            redoHistory.add(model.createMemento());
            IMemento m = undoHistory.remove(undoHistory.size() - 1);
            model.restoreState(m);
            gui.updateGui();
            historyWindow.refresh(undoHistory);
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            undoHistory.add(model.createMemento());
            IMemento m = redoHistory.remove(redoHistory.size() - 1);
            model.restoreState(m);
            gui.updateGui();
            historyWindow.refresh(undoHistory);
        }
    }

    public void restoreFromHistory(IMemento m) {
        undoHistory.add(model.createMemento());
        model.restoreState(m);
        gui.updateGui();
    }

    public void showHistoryWindow() {
        historyWindow.show();
    }
}