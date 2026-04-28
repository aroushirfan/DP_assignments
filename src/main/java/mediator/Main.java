package mediator;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) {
    ChatMediator mediator = new ChatRoom();

    ChatClientController c1 = new ChatClientController("Alice", mediator);
    ChatClientController c2 = new ChatClientController("Bob", mediator);
    ChatClientController c3 = new ChatClientController("Charlie", mediator);

    ChatClientView w1 = new ChatClientView(c1);
    ChatClientView w2 = new ChatClientView(c2);
    ChatClientView w3 = new ChatClientView(c3);

    w1.setX(100);
    w1.setY(100);

    w2.setX(600);
    w2.setY(100);

    w3.setX(350);
    w3.setY(450);

    w1.show();
    w2.show();
    w3.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
