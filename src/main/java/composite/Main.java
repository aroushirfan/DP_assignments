package composite;

public class Main {
    public static void main(String[] args) {
        Department root = new Department("Head Office");
        Department it = new Department("IT Department");
        Department hr = new Department("HR Department");

        Employee alice = new Employee("Alice", 5000);
        Employee bob = new Employee("Bob", 4500);
        Employee charlie = new Employee("Charlie", 4000);
        Employee diana = new Employee("Diana", 3800);

        root.add(alice);
        root.add(it);
        root.add(hr);

        it.add(bob);
        it.add(charlie);

        hr.add(diana);

        System.out.println("Total salary of organization: " + root.getTotalSalary());


        System.out.println("\nOrganizational structure in XML:\n");
        root.printXML();

        System.out.println("\nAdding new employee Eve to IT...\n");
        Employee eve = new Employee("Eve", 4200);
        it.add(eve);

        System.out.println("New total salary: " + root.getTotalSalary());
        System.out.println("\nUpdated XML:\n");
        root.printXML();

        System.out.println("\nRemoving Charlie from IT...\n");
        it.remove(charlie);

        System.out.println("New total salary: " + root.getTotalSalary());
        System.out.println("\nUpdated XML:\n");
        root.printXML();
    }
}
