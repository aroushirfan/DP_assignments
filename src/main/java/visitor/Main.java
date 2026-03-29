package visitor;

public class Main {
    public static void main(String[] args) {

        Directory root = new Directory("root");
        Directory images = new Directory("images");
        Directory docs = new Directory("docs");

        root.add(new FileElement("readme.txt", 1));
        root.add(images);
        root.add(docs);

        images.add(new FileElement("photo1.jpg", 5));
        images.add(new FileElement("photo2.png", 3));

        docs.add(new FileElement("report.pdf", 10));
        docs.add(new FileElement("notes.txt", 2));

        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total size: " + sizeVisitor.getTotalSize() + " MB");

        SearchVisitor searchVisitor = new SearchVisitor(".txt");
        root.accept(searchVisitor);

        System.out.println("Search results for '.txt':");
        for (FileElement file : searchVisitor.getMatches()) {
            System.out.println("- " + file.getName());
        }
    }
}
