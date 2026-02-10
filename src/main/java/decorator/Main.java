package decorator;

public class Main {
    public static void main(String[] args) {
        Printer printer;
        System.out.println("--- Basic Printer ---");
        printer = new BasicPrinter();
        printer.print("Decorator Assignment");
        System.out.println();

        System.out.println("--- XML Printer ---");
        printer = new XMLPrinter(new BasicPrinter());
        printer.print("Decorator Assignment");
        System.out.println();

        System.out.println("--- Encrypted Printer ---");
        printer = new EncryptedPrinter(new BasicPrinter());
        printer.print("Decorator Assignment");
        System.out.println();
    }
}
