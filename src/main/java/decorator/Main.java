package decorator;

public class Main {
    public static void main(String[] args) {
        Printer printer;
        printer = new BasicPrinter();
        printer.print("Decorator Assignment");

        printer = new XMLPrinter(new BasicPrinter());
        printer.print("Decorator Assignment");
        printer = new EncryptedPrinter(new BasicPrinter());
        printer.print("Decorator Assignment");
        printer = new EncryptedPrinter(new XMLPrinter(new BasicPrinter()));
        printer.print("Decorator Assignment");
        printer= new XMLPrinter(new EncryptedPrinter(new BasicPrinter()));
        printer.print("Decorator Assignment");
    }
}
