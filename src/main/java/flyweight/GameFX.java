package flyweight;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GameFX extends Application {

  @Override
  public void start(Stage stage) {
    stage.setTitle("RPG Map - Flyweight Rendering");

    Map map = new WildernessMap(20, 15);
    //Map map = new CityMap(20, 15);
    StackPane root = new StackPane(MapRenderer.render(map));

    stage.setScene(new Scene(root));
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
