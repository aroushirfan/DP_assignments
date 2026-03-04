package chain_of_responsibility;

public class Main {
    public static void main(String[] args) {
        Handler compensation= new CompensationHandler();
        Handler contactRequest= new ContactRequestHandler();
        Handler suggestion= new SuggestionHandler();
        Handler general= new GeneralFeedbackHandler();

        compensation.setNext(contactRequest);
        contactRequest.setNext(suggestion);
        suggestion.setNext(general);
        Handler chain = compensation;

        Message m1 = new Message(MessageType.COMPENSATION, "I want a refund for my order.", "Alice");
        Message m2 = new Message(MessageType.CONTACT_REQUEST, "I need help with my account.", "Bob");
        Message m3 = new Message(MessageType.SUGGESTION, "Please add more payment options.", "Charlie");
        Message m4 = new Message(MessageType.GENERAL_FEEDBACK, "Great service, keep it up!", "Diana");

        chain.handle(m1);
        chain.handle(m2);
        chain.handle(m3);
        chain.handle(m4);
    }
}