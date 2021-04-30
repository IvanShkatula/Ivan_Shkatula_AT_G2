package project.runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import project.tests.BookingTests;
import project.tests.DemoQATests;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BookingTests.class,
        DemoQATests.class
})
public class Junit4Run {
}
