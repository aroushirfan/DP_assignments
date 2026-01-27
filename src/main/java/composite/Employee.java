package composite;

public class Employee extends OrganizationUnit {
    private double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public double getTotalSalary() {
        return getSalary();
    }

    @Override
    public String toXML(int indentLevel) {
        String indent = indent(indentLevel);
        return indent + "<employee name=\"" + name + "\" salary=\"" + salary + "\"/>\n";
    }
}
