package chain_of_responsibility;

public class SuggestionHandler extends Handler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.SUGGESTION) {
            System.out.println("SuggestionHandler: Logging development suggestion...");
            System.out.println("Suggestion: " + message.getContent());
            System.out.println("Sender: " + message.getSender() + "\n");
        } else {
            super.handle(message);
        }
    }
}
