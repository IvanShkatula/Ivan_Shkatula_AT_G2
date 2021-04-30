package project.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import project.pages.BaseSteps;
import project.pages.booking.CarRentalsPage;
import project.pages.booking.ResultPage;
import project.pages.booking.MainPage;
import project.pages.workWithMails.MailRu;
import project.pages.workWithMails.TrashMail;
import project.utils.Utils;

import java.util.Calendar;

public class BookingTests extends BaseSteps {

    TrashMail newTrashMail = new TrashMail();
    MainPage mainPage = new MainPage();
    ResultPage resultPage = new ResultPage();
    Utils utils = new Utils();
    MailRu mailRu = new MailRu();
    CarRentalsPage carRentalsPage = new CarRentalsPage();

    @Test
    public void filterMaxPrice() {

        Calendar dayOfArrival = utils.setDate(1);
        Calendar dayOfDeparture = utils.setDate(8);
        String arrivalDay = utils.parseCalendarToString(dayOfArrival);
        String departureDay = utils.parseCalendarToString(dayOfDeparture);

        mainPage.openMainPage();
        mainPage.typeCity("париж");
        mainPage.guestsInput();
        mainPage.increaseNumberOfAdults();
        mainPage.increaseNumberOfAdults();
        mainPage.dateFieldSelect();
        mainPage.setDate(arrivalDay);
        mainPage.setDate(departureDay);
        mainPage.submit();
        resultPage.filterByHighestPrice();
        resultPage.sortLowPriceFirst();
        resultPage.waitSpinnerPass();
        int maxFilterPrice = utils.parseStringToInt(resultPage.maxPriceInFilter());
        int hotelPrice = utils.parseStringToInt(resultPage.hotelMaxPrice());
        int stayDays = utils.calculateDifferenceInDaysBetweenTwoDates(dayOfArrival, dayOfDeparture);
        boolean result = maxFilterPrice < hotelPrice / stayDays;
        Assert.assertTrue("expect price per day > " + maxFilterPrice +
                        "\n actual price per day is " + hotelPrice / stayDays,
                result);
    }

    @Test
    public void changeAndCompareHeaderAndBackGroundColors() {
        String backgroundColorExpected = "rgba(0, 128, 0, 1)";
        String headerColorExpected = "rgba(255, 0, 0, 1)";
        mainPage.openMainPage();
        mainPage.typeCity("москва");
        mainPage.submit();
        WebElement webElement = resultPage.chooseRaw(10);
        resultPage.scrollToRequiredLine(webElement);
        resultPage.setBackgroundColorOfRequiredLine("green", webElement);
        resultPage.setHeaderColorOfRequiredLine("red", webElement);
        String headerColor = resultPage.getHeaderColorOfRequiredLine(10);
        String backgroundColor = resultPage.getBackgroundColorOfRequiredLine(10);
        boolean isColorsEqualsExpectedColors = resultPage.isColorEqualsExpectedColor(headerColor, headerColorExpected) &&
                resultPage.isColorEqualsExpectedColor(backgroundColor, backgroundColorExpected);
        Assert.assertTrue("Expected background color: " + backgroundColorExpected + ", actual background color is: " + backgroundColor +
                ".\n Expected color is: " + headerColorExpected + ", actual color is: " + headerColor, isColorsEqualsExpectedColors);
    }

    @Test
    public void availabilityOfHotels() {

        Calendar dayOfArrival = utils.setDate(1);
        Calendar dayOfDeparture = utils.setDate(8);
        String arrivalDay = utils.parseCalendarToString(dayOfArrival);
        String departureDay = utils.parseCalendarToString(dayOfDeparture);

        mainPage.openMainPage();
        mainPage.typeCity("москва");
        mainPage.dateFieldSelect();
        mainPage.setDate(arrivalDay);
        mainPage.setDate(departureDay);
        mainPage.submit();
        Assert.assertTrue("There are no available hotels", resultPage.isHotelsPresented());
    }

    @Test
    public void ratingOverNine() {
        mainPage.openMainPage();
        mainPage.typeCity("москва");
        mainPage.submit();
        resultPage.sortHighestRating();
        resultPage.waitSpinnerPass();
        double ratingOfHotel = resultPage.getHotelRatingByLineNumber(1);
        Assert.assertTrue("Actual rating of hotel is: " + ratingOfHotel + ". It is less than 9 stars", ratingOfHotel >= 9);
    }

    @Test
    public void visibilityToolTipsCurrency() {
        mainPage.openMainPage();
        mainPage.hoverOnCurrencyTooltip();
        Assert.assertEquals("Choose your currency", mainPage.getTextOfToolTip());
    }

    @Test
    public void testsWithToolTipsLanguage() {
        mainPage.openMainPage();
        mainPage.hoverOnLanguageTooltip();
        Assert.assertEquals("Choose your language", mainPage.getTextOfToolTip());
    }

    @Test
    public void registerUser() {
        String mail = newTrashMail.registerMailOnTrashmail();
        mainPage.openMainPage();
        mainPage.registration(mail);
        mailRu.confirmRegistration(mail);
    }

    @Test
    public void checkHeaders() {
        mainPage.openMainPage();
        mainPage.login("charley.bogisich@mobiletrashmail.com", "Password1!");
    }

    @Test
    public void heartButtonBecomeRedAfterClickIt () {

        String arrivalDay = utils.parseCalendarToString(utils.setDate(30));
        String departureDay = utils.parseCalendarToString(utils.setDate(35));

        mainPage.openMainPage();
        mainPage.login("charley.bogisich@mobiletrashmail.com", "Password1!");
        mainPage.typeCity("Madrid");
        mainPage.dateFieldSelect();
        mainPage.setDate(arrivalDay);
        mainPage.setDate(departureDay);
        mainPage.submit();
    }

    @Test
    public void isAllDowntownHaveCityName() {

        Calendar startUseCarDay = utils.setDate(14);
        Calendar finishUseCarDay = utils.setDate(19);
        String startUseCar = utils.parseCalendarToString(startUseCarDay);
        String finishUseCar = utils.parseCalendarToString(finishUseCarDay);

        mainPage.openMainPage();
        mainPage.login("charley.bogisich@mobiletrashmail.com", "Password1!");
        mainPage.openCarRentalsTab();
        carRentalsPage.pickupLocation("London");
        carRentalsPage.chooseTarget();
        mainPage.dateFieldSelect();
        mainPage.setDate(startUseCar);
        mainPage.setDate(finishUseCar);
        mainPage.clickSearch();
    }

    @Test
    public void isAllOfferedLocationsCorrespondToLocationInSearchResult() {

        Calendar startUseCarDay = utils.setDate(21);
        Calendar finishUseCarDay = utils.setDate(24);
        String startUseCar = utils.parseCalendarToString(startUseCarDay);
        String finishUseCar = utils.parseCalendarToString(finishUseCarDay);
        String searchLocation;

        mainPage.openMainPage();
        mainPage.login("charley.bogisich@mobiletrashmail.com", "Password1!");
        mainPage.openCarRentalsTab();
        carRentalsPage.pickupLocation("London");
        searchLocation = carRentalsPage.getSearchLocation();
        carRentalsPage.chooseTarget();
        mainPage.dateFieldSelect();
        carRentalsPage.setStartCarUsingDate();
        carRentalsPage.setEndCarUsingDate();
        mainPage.clickSearch();
        carRentalsPage.showAllResults();
        boolean ifResultContainsSerch = carRentalsPage.ifResultContainsSearch(searchLocation);
        Assert.assertTrue("not all elements contains" + searchLocation, ifResultContainsSerch);
    }


}
