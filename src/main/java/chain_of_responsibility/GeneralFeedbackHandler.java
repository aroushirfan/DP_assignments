package chain_of_responsibility;

public class GeneralFeedbackHandler extends Handler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.GENERAL_FEEDBACK) {
            System.out.println("GeneralFeedbackHandler: Logging general feedback...");
            System.out.println("Feedback: " + message.getContent());
            System.out.println("Sending thank you to: " + message.getSender() + "\n");
        } else {
            super.handle(message);
        }
    }
}
