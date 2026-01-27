package composite;

public abstract class OrganizationUnit {
    protected String name;

    public OrganizationUnit(String name) {
        this.name = name;
    }

    public void add(OrganizationUnit unit) {
        throw new UnsupportedOperationException("Not supported");
    }

    public void remove(OrganizationUnit unit) {
        throw new UnsupportedOperationException("Not supported");
    }

    public OrganizationUnit getChild(int index) {
        throw new UnsupportedOperationException("Not supported");
    }

    public double getSalary() {
        return 0.0;
    }

    public double getTotalSalary() {
        return getSalary();
    }

    protected String indent(int level) {
        return " ".repeat(level);
    }

    public abstract String toXML(int indentLevel);

    public void printXML() {
        System.out.println(toXML(0));
    }
}
