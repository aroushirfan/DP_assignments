package mediator;

import java.util.List;

public interface ChatClientUI {

  void showMessage(String text);

  void updateUserList(List<String> usernames);
}
