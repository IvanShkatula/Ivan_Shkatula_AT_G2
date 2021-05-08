package project.day20.homework.runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import project.day20.homework.tests.TestClass;
import project.tests.BookingTests;
import project.tests.DemoQATests;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestClass.class
})
public class Junit4Runner {
}
