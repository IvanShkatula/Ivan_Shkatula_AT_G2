package project.tests;

import gherkin.lexer.Pa;
import org.junit.Assert;
import org.junit.Test;
import project.driver.BaseSteps;
import project.pages.bookingPages.PageWithResults;
import project.pages.bookingPages.StartPage;
import project.pages.workWithMails.MailRu;
import project.pages.workWithMails.TrashMail;
import project.utils.Utils;

import java.util.Calendar;

public class BookingTests extends BaseSteps {

    TrashMail newTrashMail = new TrashMail();
    StartPage startPage = new StartPage();
    PageWithResults pageWithResults = new PageWithResults();
    Utils utils = new Utils();
    MailRu mailRu = new MailRu();


    public void registerUser() {
        String mail = newTrashMail.registerMailOnTrashmail();
        startPage.openStartPage();
        startPage.registration(mail);
        mailRu.confirmRegistration(mail);
    }

//    @Test
//    public void checkHeaders() {
//        startPage.openStartPage();
//        startPage.registration();
//    }


    public void filterMaxPrice() {

        Calendar dayOfArrival = utils.setDate(1);
        Calendar dayOfDeparture = utils.setDate(8);
        String arrivalDay = utils.parseCalendarToString(dayOfArrival);
        String departureDay = utils.parseCalendarToString(dayOfDeparture);

        startPage.openStartPage();
        startPage.searchDestinationInput("париж");
        startPage.guestsInput();
        startPage.increaseNumberOfAdults();
        startPage.increaseNumberOfAdults();
        startPage.dateFieldSelect();
        startPage.setDate(arrivalDay);
        startPage.setDate(departureDay);
        startPage.submit();
        pageWithResults.filterByHighestPrice();
        pageWithResults.sortLowPriceFirst();
        //       pageWithResults.waitSpinnerPass();
        int maxFilterPrice = utils.parseStringToInt(pageWithResults.maxPriceInFilter());
        int hotelPrice = utils.parseStringToInt(pageWithResults.hotelMaxPrice());
        int stayDays = utils.calculateDifferenceInDaysBetweenTwoDates(dayOfArrival, dayOfDeparture);
        boolean result = maxFilterPrice < hotelPrice / stayDays;
        Assert.assertTrue("expect price per day > " + maxFilterPrice +
                        "\n actual price per day is " + hotelPrice / stayDays,
                result);
    }

}
