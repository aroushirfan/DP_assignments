package visitor;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {

    private String pattern;
    private List<FileElement> matches = new ArrayList<>();

    public SearchVisitor(String pattern) {
        this.pattern = pattern;
    }

    public List<FileElement> getMatches() {
        return matches;
    }

    @Override
    public void visit(FileElement file) {
        if (file.getName().contains(pattern)) {
            matches.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement element : directory.getChildren()) {
            element.accept(this);
        }
    }
}
