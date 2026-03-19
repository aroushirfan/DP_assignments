package memento;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Gui extends Application {

    private Controller controller;
    private ColorBox colorBox1;
    private ColorBox colorBox2;
    private ColorBox colorBox3;
    private CheckBox checkBox;

    @Override
    public void start(Stage stage) {

        controller = new Controller(this);

        Insets insets = new Insets(10);

        colorBox1 = new ColorBox(1, controller);
        colorBox2 = new ColorBox(2, controller);
        colorBox3 = new ColorBox(3, controller);

        checkBox = new CheckBox("Click me!");
        checkBox.setPadding(insets);

        checkBox.setOnAction(e -> controller.setIsSelected(checkBox.isSelected()));

        HBox hBox = new HBox(colorBox1.getRectangle(),
                colorBox2.getRectangle(),
                colorBox3.getRectangle());
        hBox.setSpacing(10);

        Label label = new Label("Ctrl+Z = Undo, Ctrl+Y = Redo, H = History");
        label.setPadding(insets);

        VBox vBox = new VBox(hBox, checkBox, label);

        Scene scene = new Scene(vBox);

        scene.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.Z) {
                controller.undo();
            }
            if (event.isControlDown() && event.getCode() == KeyCode.Y) {
                controller.redo();
            }
            if (event.getCode() == KeyCode.H) {
                controller.showHistoryWindow();
            }
        });

        stage.setScene(scene);
        stage.setTitle("Memento Pattern Example");
        stage.show();
    }

    public void updateGui() {
        colorBox1.setColor(controller.getOption(1));
        colorBox2.setColor(controller.getOption(2));
        colorBox3.setColor(controller.getOption(3));
        checkBox.setSelected(controller.getIsSelected());
    }
}