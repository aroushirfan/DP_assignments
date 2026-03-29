package visitor;

public class FileElement implements FileSystemElement {
    private String name;
    private int sizeMB;

    public FileElement(String name, int sizeMB) {
        this.name = name;
        this.sizeMB = sizeMB;
    }

    public String getName() {
        return name;
    }

    public int getSizeMB() {
        return sizeMB;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
