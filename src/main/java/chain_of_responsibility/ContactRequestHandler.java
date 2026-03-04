package chain_of_responsibility;

public class ContactRequestHandler extends Handler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.CONTACT_REQUEST) {
            System.out.println("ContactRequestHandler: Forwarding contact request to customer service...");
            System.out.println("Message: " + message.getContent());
            System.out.println("We will contact: " + message.getSender() + "\n");
        } else {
            super.handle(message);
        }
    }
}
