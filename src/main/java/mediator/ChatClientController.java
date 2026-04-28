package mediator;

import java.util.List;

public class ChatClientController implements ChatClient {

  private final String username;
  private final ChatMediator mediator;
  private ChatClientUI ui;

  public ChatClientController(String username, ChatMediator mediator) {
    this.username = username;
    this.mediator = mediator;
    mediator.registerClient(this);
  }

  public void setUI(ChatClientUI ui) {
    this.ui = ui;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public void receiveMessage(String from, String to, String message) {
    if (ui != null) {
      String direction = username.equals(from) ? "To " + to : "From " + from;
      ui.showMessage("[" + direction + "]: " + message);
    }
  }

  public void sendMessage(String to, String message) {
    if (to == null || to.isBlank() || message == null || message.isBlank()) {
      if (ui != null) {
        ui.showMessage("[System]: Select a recipient and type a message.");
      }
      return;
    }
    mediator.sendPrivateMessage(username, to, message);
  }

  public void updateUserList(List<String> usernames) {
    if (ui != null) {
      ui.updateUserList(usernames);
    }
  }
  public ChatMediator getMediator() {
    return mediator;
  }

}
