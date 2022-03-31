package com.flight.presentation;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isNotEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import com.flight.R;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest extends TestCase {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

//    @Rule
//    public ActivityScenarioRule<MainActivity> activityScenarioRule
//            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void tripTypeTest() {
        onView(withId(R.id.select_trip_type_id)).check(matches(isDisplayed()));
        onView(withId(R.id.select_dates_edit)).check(matches(isDisplayed()));
        onView(withId(R.id.select_trip_type_id)).check(matches(withText("Round Trip")));
        onView(withId(R.id.select_dates_edit)).check(matches(withText("Dates")));
        onView(withId(R.id.select_trip_type_id)).perform(click());
        // onView(withId(R.id.select_trip_type_id)).perform(matches(isChecked()));
        onView(withId(R.id.select_trip_type_id)).check(matches(withText("One way")));
        onView(withId(R.id.select_dates_edit)).check(matches(withText("Select One way Trip Dates")));
        onView(withId(R.id.select_trip_type_id)).perform(click());
        // onView(withId(R.id.select_trip_type_id)).perform(matches(isNotChecked()));
        onView(withId(R.id.select_dates_edit)).check(matches(withText("Select Round Trip Dates ")));
    }

    @Test
    public void adultTravelOptionTest() {
        onView(withId(R.id.adult_checkbox_id)).check(matches(isDisplayed()));
        onView(withId(R.id.adult_num_edit_id)).check(matches(isDisplayed()));
        onView(withId(R.id.adult_num_edit_id)).check(matches(isEnabled()));
        onView(withId(R.id.adult_num_edit_id)).check(matches(withText("1")));
        onView(withId(R.id.adult_checkbox_id)).perform(click());
        onView(withId(R.id.adult_num_edit_id)).check(matches(isNotEnabled()));
        onView(withId(R.id.adult_num_edit_id)).check(matches(withText("")));
    }

    @Test
    public void childrenTravelOptionTest() {
        onView(withId(R.id.child_checkbox_id)).check(matches(isDisplayed()));
        onView(withId(R.id.children_num_edit_id)).check(matches(isDisplayed()));
        onView(withId(R.id.children_num_edit_id)).check(matches(isNotEnabled())); // wrong
        onView(withId(R.id.children_num_edit_id)).check(matches(withText("")));
        onView(withId(R.id.child_checkbox_id)).perform(click());
        onView(withId(R.id.children_num_edit_id)).check(matches(isEnabled()));
        onView(withId(R.id.children_num_edit_id)).check(matches(withText("1")));
        onView(withId(R.id.child_checkbox_id)).perform(click());
        onView(withId(R.id.children_num_edit_id)).check(matches(isNotEnabled()));
        onView(withId(R.id.children_num_edit_id)).check(matches(withText("")));
    }

    @Test
    public void setDateTest() {
        onView(withId(R.id.select_dates_edit)).check(matches(isDisplayed()));
        onView(withId(R.id.select_trip_type_id)).check(matches(withText("Round Trip")));
        onView(withId(R.id.select_dates_edit)).check(matches(withText("Dates")));
        onView(withId(R.id.select_dates_edit)).perform(click());
        //
    }

    @Test
    public void departureCityClickTest() throws InterruptedException {
        onView(withId(R.id.departure_city_edit_id)).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.CityCode_listview))).check(matches(not(isDisplayed())));
        onView(allOf(withId(R.id.CityCode_searchview))).check(matches(not(isDisplayed())));
        onView(withId(R.id.departure_city_edit_id)).perform(click());
        onView(withId(R.id.departure_city_edit_id)).perform(click());
        // Thread.sleep(1000);
        onView(allOf(withId(R.id.CityCode_listview))).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.CityCode_searchview))).check(matches(isDisplayed()));
        onData(allOf(is(instanceOf(String.class)), is("Calgary YYC"))).perform(click());
        onView(withId(R.id.departure_city_edit_id)).check(matches(withText("Calgary YYC")));
        // check the Toast
        Thread.sleep(1000);
        onView(withText("Departure city is: Calgary YYC"))
                .inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()));
    }

    @Test
    public void departureCityInputTest() throws InterruptedException {
        onView(withId(R.id.departure_city_edit_id)).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.CityCode_listview))).check(matches(not(isDisplayed())));
        onView(allOf(withId(R.id.CityCode_searchview))).check(matches(not(isDisplayed())));
        onView(withId(R.id.departure_city_edit_id)).perform(click());
        onView(withId(R.id.departure_city_edit_id)).perform(click());
        // Thread.sleep(1000);
        onView(allOf(withId(R.id.CityCode_listview))).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.CityCode_searchview))).check(matches(isDisplayed()));
        onView(withId(R.id.CityCode_searchview))
                .perform(typeText("Calgary YYC"), closeSoftKeyboard());
        onView(withText("Calgary YYC")).check(matches(isDisplayed()));
        onData(allOf(is(instanceOf(String.class)), is("Calgary YYC"))).perform(click());
        onView(withId(R.id.departure_city_edit_id)).check(matches(withText("Calgary YYC")));
        // check the Toast
        Thread.sleep(1000);
        onView(withText("Departure city is: Calgary YYC"))
                .inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()));
    }

    @Test
    public void arrivalCityClickTest() throws InterruptedException {
        onView(withId(R.id.arrival_city_edit_id)).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.CityCode_searchview))).check(matches(not(isDisplayed())));
        onView(allOf(withId(R.id.CityCode_listview))).check(matches(not(isDisplayed())));
        onView(withId(R.id.arrival_city_edit_id)).perform(click());
        onView(withId(R.id.arrival_city_edit_id)).perform(click());
        // Thread.sleep(1000);
        onView(allOf(withId(R.id.CityCode_searchview))).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.CityCode_listview))).check(matches(isDisplayed()));
        onData(allOf(is(instanceOf(String.class)), is("Calgary YYC"))).perform(click());
        onView(withId(R.id.arrival_city_edit_id)).check(matches(withText("Calgary YYC")));
        // check the Toast
        Thread.sleep(1000);
        onView(withText("Arrival city is: Calgary YYC"))
                .inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()));
    }

    @Test
    public void arrivalCityInputTest() throws InterruptedException {
        onView(withId(R.id.arrival_city_edit_id)).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.CityCode_listview))).check(matches(not(isDisplayed())));
        onView(allOf(withId(R.id.CityCode_searchview))).check(matches(not(isDisplayed())));
        onView(withId(R.id.arrival_city_edit_id)).perform(click());
        onView(withId(R.id.arrival_city_edit_id)).perform(click());
        // Thread.sleep(1000);
        onView(allOf(withId(R.id.CityCode_listview))).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.CityCode_searchview))).check(matches(isDisplayed()));
        onView(withId(R.id.CityCode_searchview))
                .perform(typeText("Calgary YYC"), closeSoftKeyboard());
        onView(withText("Calgary YYC")).check(matches(isDisplayed()));
        onData(allOf(is(instanceOf(String.class)), is("Calgary YYC"))).perform(click());
        onView(withId(R.id.arrival_city_edit_id)).check(matches(withText("Calgary YYC")));
        // check the Toast
        Thread.sleep(1000);
        onView(withText("Departure city is: Calgary YYC"))
                .inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()));
    }

}