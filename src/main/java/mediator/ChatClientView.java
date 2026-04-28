package mediator;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.List;

public class ChatClientView extends Stage implements ChatClientUI {

  private final ChatClientController controller;

  private TextArea messagesArea;
  private TextField messageField;
  private ComboBox<String> recipientBox;
  private Button sendButton;

  public ChatClientView(ChatClientController controller) {
    this.controller = controller;
    this.controller.setUI(this);

    setTitle("Chat - " + controller.getUsername());
    initUI();
    controller.updateUserList(controller.getMediator().getUsernames());
  }

  private void initUI() {
    messagesArea = new TextArea();
    messagesArea.setEditable(false);

    messageField = new TextField();
    messageField.setPromptText("Type your message...");

    recipientBox = new ComboBox<>();
    recipientBox.setPromptText("Select recipient");

    sendButton = new Button("Send");
    sendButton.setOnAction(e -> {
      controller.sendMessage(recipientBox.getValue(), messageField.getText());
      messageField.clear();
    });

    HBox bottom = new HBox(5, new Label("To:"), recipientBox, messageField, sendButton);
    bottom.setPadding(new Insets(5));

    BorderPane root = new BorderPane();
    root.setCenter(messagesArea);
    root.setBottom(bottom);
    root.setPadding(new Insets(5));

    Scene scene = new Scene(root, 450, 300);
    setScene(scene);
  }

  @Override
  public void showMessage(String text) {
    messagesArea.appendText(text + "\n");
  }

  @Override
  public void updateUserList(List<String> usernames) {
    String myName = controller.getUsername();
    recipientBox.getItems().setAll(
        usernames.stream()
            .filter(name -> !name.equals(myName))
            .toList()
    );

    if (!recipientBox.getItems().isEmpty() && recipientBox.getValue() == null) {
      recipientBox.getSelectionModel().selectFirst();
    }
  }
}
