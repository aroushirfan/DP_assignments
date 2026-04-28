package mediator;

import java.util.*;

public class ChatRoom implements ChatMediator {

  private Map<String, ChatClient> clients = new LinkedHashMap<>();

  @Override
  public synchronized void registerClient(ChatClient client) {
    clients.put(client.getUsername(), client);
    broadcastUserList();
  }

  @Override
  public synchronized void sendPrivateMessage(String from, String to, String message) {
    ChatClient receiver = clients.get(to);
    if (receiver != null) {
      receiver.receiveMessage(from, to, message);
    }

    ChatClient sender = clients.get(from);
    if (sender != null && sender != receiver) {
      sender.receiveMessage(from, to, message);
    }
  }

  @Override
  public synchronized List<String> getUsernames() {
    return new ArrayList<>(clients.keySet());
  }

  private void broadcastUserList() {
    List<String> names = getUsernames();
    for (ChatClient client : clients.values()) {
      if (client instanceof ChatClientController controller) {
        controller.updateUserList(names);
      }
    }
  }
}
