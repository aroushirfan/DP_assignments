package mediator;

import java.util.List;

public interface ChatMediator {

  void registerClient(ChatClient client);

  void sendPrivateMessage(String from, String to, String message);

  List<String> getUsernames();
}
