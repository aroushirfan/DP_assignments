package command;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PixelArtApp extends Application {

  public void start(Stage stage) {
    PixelGrid grid = new PixelGrid();
    PixelGridView view = new PixelGridView(grid);

    Command up = new MoveCursorUpCommand(grid);
    Command down = new MoveCursorDownCommand(grid);
    Command left = new MoveCursorLeftCommand(grid);
    Command right = new MoveCursorRightCommand(grid);
    Command toggle = new TogglePixelCommand(grid);
    Command generate = new GenerateCodeCommand(grid);

    Button generateButton = new Button("Create Code");
    generateButton.setOnAction(e -> generate.execute());

    BorderPane root = new BorderPane();
    root.setCenter(view);
    root.setBottom(generateButton);

    Scene scene = new Scene(root, 350, 400);

    scene.setOnKeyPressed(e -> {
      switch (e.getCode()) {
        case UP -> up.execute();
        case DOWN -> down.execute();
        case LEFT -> left.execute();
        case RIGHT -> right.execute();
        case SPACE -> toggle.execute();
      }
    });

    stage.setScene(scene);
    stage.setTitle("Pixel Art Editor");
    stage.show();
    scene.getRoot().requestFocus();
  }
}
