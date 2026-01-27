package composite;

import java.util.ArrayList;
import java.util.List;

public class Department extends OrganizationUnit {
    private List<OrganizationUnit> units = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public void add(OrganizationUnit unit) {
        units.add(unit);
    }

    @Override
    public void remove(OrganizationUnit unit) {
        units.remove(unit);
    }

    @Override
    public OrganizationUnit getChild(int index) {
        return units.get(index);
    }

    @Override
    public double getTotalSalary() {
        double total = 0.0;
        for (OrganizationUnit unit : units) {
            total += unit.getTotalSalary();
        }
        return total;
    }

    @Override
    public String toXML(int indentLevel) {
        String indent = indent(indentLevel);
        String xml = indent + "<department name=\"" + name + "\">\n";
        for (OrganizationUnit unit : units) {
            xml += unit.toXML(indentLevel + 1);
        }
        xml += indent + "</department>\n";
        return xml;
    }
}
