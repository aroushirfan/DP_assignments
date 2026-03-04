package chain_of_responsibility;

public class Handler {
    private Handler next;
    public void handle (Message message) {
        if (next!= null) {
            next.handle(message);
        } else {
            System.out.println("No handler available for message type: " + message.getType());
        }
    }
    public void setNext(Handler next) {
        this.next = next;
    }
}
