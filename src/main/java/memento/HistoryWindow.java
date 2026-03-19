package memento;

import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.List;

public class HistoryWindow {

    private Stage stage;
    private ListView<IMemento> listView;
    private Controller controller;

    public HistoryWindow(Controller controller) {
        this.controller = controller;

        stage = new Stage();
        stage.setTitle("History");

        listView = new ListView<>();

        listView.setOnMouseClicked(event -> {
            IMemento selected = listView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                controller.restoreFromHistory(selected);
            }
        });

        stage.setScene(new Scene(listView, 300, 400));
    }

    public void refresh(List<IMemento> history) {
        listView.getItems().setAll(history);
    }

    public void show() {
        stage.show();
    }
}