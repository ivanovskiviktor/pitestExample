package pitTest;

import java.util.ArrayList;
import java.util.List;

public class Conference {

    public static double TICKET_PRICE = 8.67;
    public static double AFFILIATE_DISCOUNT = 0.1;
    public static double FACULTY_EMPLOYEE_DISCOUNT = 0.7;

    private List<Person> attendees;
    private int capacity;

    public Conference(int capacity) {
        this.attendees = new ArrayList<>(capacity);
        this.capacity = capacity;
    }

    public double calculateTotalPricePaid() {
        double price = 0;

        for (Person p : attendees) {

            if (p.getRole().name().equals("AFFILIATE"))
                price += (1 - AFFILIATE_DISCOUNT) * TICKET_PRICE;
            else if (p.getRole().name().equals("FACULTY_EMPLOYEE"))
                price += (1 - FACULTY_EMPLOYEE_DISCOUNT) * TICKET_PRICE;
            else if (p.getRole().name().equals("OTHER"))
                price += TICKET_PRICE;
        }
        return price;
    }

    public boolean addAttendeeToConference(Person person) {
        if((this.attendees.size() < capacity) || doubleCapacity()) {
           this.attendees.add(person);
           return true;
        }else return false;
    }

    public boolean doubleCapacity() {
        if(this.capacity * 2 > 10000)
            return false;
        this.capacity *= 2;
        return true;
    }

    public List<Person> getAttendees() {
        return attendees;
    }

    public int getCapacity() {
        return capacity;
    }
}
