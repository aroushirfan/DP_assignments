package adapter;

public class Main {
    public static void main(String[] args) {

        NewDateInterface date = new CalendarToNewDateAdapter();

        date.setYear(2024);
        date.setMonth(3);
        date.setDay(25);

        System.out.println("Initial date: " +
                date.getDay() + "." + date.getMonth() + "." + date.getYear());

        date.advanceDays(10);

        System.out.println("After advancing 10 days: " +
                date.getDay() + "." + date.getMonth() + "." + date.getYear());

        date.advanceDays(40);

        System.out.println("After advancing 40 more days: " +
                date.getDay() + "." + date.getMonth() + "." + date.getYear());
    }
}
