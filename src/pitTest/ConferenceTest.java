package pitTest;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ConferenceTest {


    @Test
    public void testPersonToString()
    {
        Person person = new Person("Viktor","Ivanoski",Role.OTHER,20);
        person.setSurname("Ivanovski");
        person.setAge(21);
        person.setRole(Role.STUDENT);
        person.toString();
        Assert.assertEquals("pitTest.Person{name='Viktor', surname='Ivanovski', role=STUDENT, age=21}", person.toString());
    }

    @Test
    public void DoubleCapacityOne()
    {
        Conference conference = new Conference(10000);
        boolean netocno = false;
        Assert.assertEquals(netocno,conference.doubleCapacity());
    }

    @Test
    public void DoubleCapacityTwo()
    {
        Conference conference = new Conference(5000);
        Assert.assertTrue("true",conference.doubleCapacity());
    }

    @Test
    public void DoubleCapacityMultiplication()
    {
        Conference conference = new Conference(100);
        conference.doubleCapacity();
        Assert.assertEquals(200,conference.getCapacity());
    }

    @Test //for Affiliate
    public void TestCalculateTotalPricePaid()
    {
        Conference conference = new Conference(10);
        Person person = new Person("Ivona","Digalovska",Role.AFFILIATE,21);
        boolean added = conference.addAttendeeToConference(person);
        Assert.assertTrue(added);
        Assert.assertEquals(7.803 ,conference.calculateTotalPricePaid(),0);
    }

    @Test //for Faculty Employee
    public void TestCalculateTotalPricePaid1()
    {
        Conference conference = new Conference(10);
        Person person = new Person("Stojan","Stojanov",Role.FACULTY_EMPLOYEE,21);
        boolean added = conference.addAttendeeToConference(person);
        Assert.assertTrue(added);
        Assert.assertEquals( 2.6010000000000004 ,conference.calculateTotalPricePaid(),0);
    }

    @Test //for other roles
    public void TestCalculateTotalPricePaid2()
    {
        Conference conference = new Conference(10);
        Person person = new Person("Sara","Trajanova",Role.OTHER,21);
        boolean added = conference.addAttendeeToConference(person);
        Assert.assertTrue(added);
        Assert.assertEquals( 8.67 ,conference.calculateTotalPricePaid(),0);
    }

    @Test
    public void TestForGetters()
    {
        Conference conference = new Conference(30);
        Person attendee = new Person("Sasko", "Kocev", Role.ORGANIZER, 40);
        conference.addAttendeeToConference(attendee);
        List<Person> attendees = conference.getAttendees();
        Assert.assertEquals(1,attendees.size());
    }

    @Test
    public void addAttendeeToConferenceTestFalse() {
        Conference conference = new Conference(10000);
        for(int i=0; i<10000; i++) {
            Person attendee = new Person("Milan", "Jovanovski", Role.ORGANIZER, 32);
            boolean tocno = conference.addAttendeeToConference(attendee);
            Assert.assertEquals(true, tocno);
        }
        Person attendee = new Person("Milan", "Jovanovski", Role.ORGANIZER, 32);
        boolean netocno = conference.addAttendeeToConference(attendee);
        Assert.assertEquals(false, netocno);
    }
}

