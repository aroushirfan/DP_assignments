package chain_of_responsibility;

public class CompensationHandler extends Handler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.COMPENSATION) {
            System.out.println("CompensationHandler: Reviewing compensation claim...");
            System.out.println("Claim content: " + message.getContent());
            System.out.println("Decision: Approved or Rejected.\n");
        } else {
            super.handle(message);
        }
    }
}
