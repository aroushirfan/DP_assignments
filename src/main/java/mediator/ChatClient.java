package mediator;

public interface ChatClient {

  String getUsername();

  void receiveMessage(String from, String to, String message);
}
