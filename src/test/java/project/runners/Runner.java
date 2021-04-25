package project.runners;

import org.junit.Test;
import project.tests.BookingTests;

public class Runner {
    BookingTests bookingTests = new BookingTests();
    
    @Test
    public void runTests() {

        bookingTests.filterMaxPrice();
        bookingTests.registerUser();
    }

}
