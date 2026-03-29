package visitor;


public class SizeCalculatorVisitor implements FileSystemVisitor {

    private int totalSize = 0;

    public int getTotalSize() {
        return totalSize;
    }

    @Override
    public void visit(FileElement file) {
        totalSize += file.getSizeMB();
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement element : directory.getChildren()) {
            element.accept(this);
        }
    }
}
