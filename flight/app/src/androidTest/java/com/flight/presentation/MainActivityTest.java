package com.flight.presentation;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.flight.R;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

//    @Rule
//    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction button = onView(
                allOf(withId(R.id.search_flights_bttn_id), withText("SEARCH FLIGHTS"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        button.check(matches(isDisplayed()));

        ViewInteraction switch_ = onView(
                allOf(withId(R.id.select_trip_type_id), withText("Round Trip"),
                        withParent(allOf(withId(R.id.linearLayout5),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        switch_.check(matches(isDisplayed()));

        ViewInteraction editText = onView(
                allOf(withId(R.id.departure_city_edit_id), withText("Flying From"),
                        withParent(allOf(withId(R.id.linearLayout),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        editText.check(matches(withText("Flying From")));

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.departure_city_edit_id), withText("Flying From"),
                        withParent(allOf(withId(R.id.linearLayout),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        editText2.check(matches(isDisplayed()));

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.arrival_city_edit_id), withText("Flying To"),
                        withParent(allOf(withId(R.id.linearLayout),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        editText3.check(matches(isDisplayed()));

        ViewInteraction editText4 = onView(
                allOf(withId(R.id.arrival_city_edit_id), withText("Flying To"),
                        withParent(allOf(withId(R.id.linearLayout),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        editText4.check(matches(withText("Flying To")));

        ViewInteraction editText5 = onView(
                allOf(withId(R.id.select_dates_edit), withText("Dates"),
                        withParent(allOf(withId(R.id.linearLayout2),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        editText5.check(matches(isDisplayed()));

        ViewInteraction editText6 = onView(
                allOf(withId(R.id.select_dates_edit), withText("Dates"),
                        withParent(allOf(withId(R.id.linearLayout2),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        editText6.check(matches(withText("Dates")));

        ViewInteraction checkBox = onView(
                allOf(withId(R.id.adult_checkbox_id), withText("Adults"),
                        withParent(withParent(withId(R.id.linearLayout3))),
                        isDisplayed()));
        checkBox.check(matches(isDisplayed()));

        ViewInteraction editText7 = onView(
                allOf(withId(R.id.adult_num_edit_id), withText("1"),
                        withParent(withParent(withId(R.id.linearLayout3))),
                        isDisplayed()));
        editText7.check(matches(isDisplayed()));

        ViewInteraction editText8 = onView(
                allOf(withId(R.id.adult_num_edit_id), withText("1"),
                        withParent(withParent(withId(R.id.linearLayout3))),
                        isDisplayed()));
        editText8.check(matches(withText("1")));

        ViewInteraction checkBox2 = onView(
                allOf(withId(R.id.child_checkbox_id), withText("Children"),
                        withParent(withParent(withId(R.id.linearLayout3))),
                        isDisplayed()));
        checkBox2.check(matches(isDisplayed()));

        ViewInteraction button2 = onView(
                allOf(withId(R.id.search_flights_bttn_id), withText("SEARCH FLIGHTS"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        button2.check(matches(isDisplayed()));

        ViewInteraction button3 = onView(
                allOf(withId(R.id.search_flights_bttn_id), withText("SEARCH FLIGHTS"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        button3.check(matches(isDisplayed()));

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.departure_city_edit_id), withText("Flying From"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                0),
                        isDisplayed()));
        appCompatEditText.perform(click());
        appCompatEditText.perform(click());

        DataInteraction materialTextView = onData(anything())
                .inAdapterView(allOf(withId(R.id.CityCode_listview),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                1)))
                .atPosition(0);
        materialTextView.perform(click());

        ViewInteraction editText9 = onView(
                allOf(withId(R.id.departure_city_edit_id), withText("Calgary YYC"),
                        withParent(allOf(withId(R.id.linearLayout),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        editText9.check(matches(withText("Calgary YYC")));

        ViewInteraction editText10 = onView(
                allOf(withId(R.id.departure_city_edit_id), withText("Calgary YYC"),
                        withParent(allOf(withId(R.id.linearLayout),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        editText10.check(matches(withText("Calgary YYC")));

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.arrival_city_edit_id), withText("Flying To"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(click());
        appCompatEditText2.perform(click());

        DataInteraction materialTextView2 = onData(anything())
                .inAdapterView(allOf(withId(R.id.CityCode_listview),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                1)))
                .atPosition(1);
        materialTextView2.perform(click());

        ViewInteraction editText11 = onView(
                allOf(withId(R.id.arrival_city_edit_id), withText("Edmonton YEG"),
                        withParent(allOf(withId(R.id.linearLayout),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        editText11.check(matches(withText("Edmonton YEG")));

        ViewInteraction button4 = onView(
                allOf(withId(R.id.search_flights_bttn_id), withText("SEARCH FLIGHTS"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        button4.check(matches(isDisplayed()));

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.select_dates_edit), withText("Dates"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout2),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText3.perform(click());

//        DataInteraction materialTextView3 = onData(anything())
//                .inAdapterView(allOf(withId(androidx.appcompat.R.id.month_grid),
//                        childAtPosition(
//                                withClassName(is("android.widget.LinearLayout")),
//                                1)))
//                .atPosition(29);
//        materialTextView3.perform(click());
//
//
//        DataInteraction materialTextView4 = onData(anything())
//                .inAdapterView(allOf(withId(androidx.appcompat.R.id.month_grid),
//                        childAtPosition(
//                                withClassName(is("android.widget.LinearLayout")),
//                                1)))
//                .atPosition(30);
//        materialTextView4.perform(click());
//
//        ViewInteraction materialButton = onView(
//                allOf(withId(androidx.appcompat.R.id.confirm_button), withText("Save"), withContentDescription("Save"),
//                        childAtPosition(
//                                childAtPosition(
//                                        withClassName(is("android.widget.LinearLayout")),
//                                        2),
//                                0),
//                        isDisplayed()));
//        materialButton.perform(click());
//        ViewInteraction appCompatEditText9 = onView(
//                allOf(withId(R.id.select_dates_edit), withText("Dates"),
//                        childAtPosition(
//                                allOf(withId(R.id.linearLayout2),
//                                        childAtPosition(
//                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
//                                                0)),
//                                0),
//                        isDisplayed()));
//        appCompatEditText9.perform(replaceText("May 30 每 May 31"));
//        appCompatEditText9.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.select_dates_edit), isDisplayed()));
        appCompatEditText9.perform(replaceText("May 30 每 May 31"));
        appCompatEditText9.perform(closeSoftKeyboard());

//        ViewInteraction appCompatEditText10 = onView(
//                allOf(withId(R.id.select_dates_edit), withText("May 30 每 May 31"),
//                        childAtPosition(
//                                allOf(withId(R.id.linearLayout2),
//                                        childAtPosition(
//                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
//                                                0)),
//                                0),
//                        isDisplayed()));
//        appCompatEditText10.perform(closeSoftKeyboard());

//        ViewInteraction editText12 = onView(
//                allOf(withId(R.id.select_dates_edit), withText("May 30 每 May 31"),
//                        withParent(allOf(withId(R.id.linearLayout2),
//                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
//                        isDisplayed()));
//        editText12.check(matches(withText("May 30 每 May 31")));
//
//        ViewInteraction editText13 = onView(
//                allOf(withId(R.id.select_dates_edit), withText("May 30 每 May 31"),
//                        withParent(allOf(withId(R.id.linearLayout2),
//                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
//                        isDisplayed()));
//        editText13.check(matches(withText("May 30 每 May 31")));

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.search_flights_bttn_id), withText("Search Flights"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.flights_recycler_view_id),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        recyclerView.check(matches(isDisplayed()));

        ViewInteraction textView = onView(
                allOf(firstView(withId(R.id.dep_city1_txt_id)), withText("YYC"),
                        withParent(withParent(withId(R.id.linearLayout4))),
                        isDisplayed()));
        textView.check(matches(withText("YYC")));

        ViewInteraction textView2 = onView(
                allOf(firstView(withId(R.id.dep_city2_txt_id)), withText("YEG"),
                        withParent(withParent(withId(R.id.linearLayout3))),
                        isDisplayed()));
        textView2.check(matches(withText("YEG")));

        ViewInteraction button5 = onView(
                allOf(firstView(withId(R.id.button)), withText("RESERVE"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class))),
                        isDisplayed()));
        button5.check(matches(isDisplayed()));

        ViewInteraction button6 = onView(
                allOf(firstView(withId(R.id.button)), withText("RESERVE"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class))),
                        isDisplayed()));
        button6.check(matches(isDisplayed()));

        ViewInteraction materialButton3 = onView(
                allOf(firstView(withId(R.id.button)), withText("Reserve"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        2),
                                1),
                        isDisplayed()));
        materialButton3.perform(click());

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.flight_info_txtview_id), withText("Flight Summary For May 30 每 May 31"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView3.check(matches(isDisplayed()));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.flight_info_txtview_id), withText("Flight Summary For May 30 每 May 31"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView4.check(matches(withText("Flight Summary For May 30 每 May 31")));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.dep_city_txt_id), withText("YYC"),
                        withParent(allOf(withId(R.id.linearLayout),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        textView5.check(matches(isDisplayed()));

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.dep_city_txt_id), withText("YYC"),
                        withParent(allOf(withId(R.id.linearLayout),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        textView6.check(matches(withText("YYC")));

        ViewInteraction textView7 = onView(
                allOf(withId(R.id.return_city_txt_id), withText("YEG"),
                        withParent(allOf(withId(R.id.linearLayout),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        textView7.check(matches(isDisplayed()));

        ViewInteraction textView8 = onView(
                allOf(withId(R.id.return_city_txt_id), withText("YEG"),
                        withParent(allOf(withId(R.id.linearLayout),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        textView8.check(matches(withText("YEG")));

        ViewInteraction editText14 = onView(
                allOf(withId(R.id.form_name_edit_id),
                        withParent(allOf(withId(R.id.linearLayout2),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        editText14.check(matches(isDisplayed()));

        ViewInteraction editText15 = onView(
                allOf(withId(R.id.form_name_edit_id),
                        withParent(allOf(withId(R.id.linearLayout2),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        editText15.check(matches(withText("")));

        ViewInteraction editText16 = onView(
                allOf(withId(R.id.form_email_edit_id),
                        withParent(allOf(withId(R.id.linearLayout2),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        editText16.check(matches(isDisplayed()));

        ViewInteraction editText17 = onView(
                allOf(withId(R.id.form_email_edit_id),
                        withParent(allOf(withId(R.id.linearLayout2),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        editText17.check(matches(withText("")));

        ViewInteraction button7 = onView(
                allOf(withId(R.id.form_save_bttn_id), withText("SAVE"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        button7.check(matches(isDisplayed()));

        ViewInteraction button8 = onView(
                allOf(withId(R.id.form_save_bttn_id), withText("SAVE"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        button8.check(matches(isDisplayed()));

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.form_name_edit_id),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout2),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                3)),
                                1),
                        isDisplayed()));
        appCompatEditText4.perform(replaceText("qwe@gmail.com"), closeSoftKeyboard());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.form_name_edit_id), withText("qwe@gmail.com"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout2),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                3)),
                                1),
                        isDisplayed()));
        appCompatEditText5.perform(pressImeActionButton());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.form_email_edit_id),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout2),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                3)),
                                2),
                        isDisplayed()));
        appCompatEditText6.perform(replaceText("qwe@gmail.com"), closeSoftKeyboard());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.form_email_edit_id), withText("qwe@gmail.com"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout2),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                3)),
                                2),
                        isDisplayed()));
        appCompatEditText7.perform(pressImeActionButton());

        ViewInteraction editText18 = onView(
                allOf(withId(R.id.form_name_edit_id), withText("qwe@gmail.com"),
                        withParent(allOf(withId(R.id.linearLayout2),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        editText18.check(matches(withText("qwe@gmail.com")));

        ViewInteraction editText19 = onView(
                allOf(withId(R.id.form_email_edit_id), withText("qwe@gmail.com"),
                        withParent(allOf(withId(R.id.linearLayout2),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        editText19.check(matches(withText("qwe@gmail.com")));

        ViewInteraction editText20 = onView(
                allOf(withId(R.id.form_email_edit_id), withText("qwe@gmail.com"),
                        withParent(allOf(withId(R.id.linearLayout2),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        editText20.check(matches(withText("qwe@gmail.com")));

        ViewInteraction materialButton4 = onView(
                allOf(withId(R.id.form_save_bttn_id), withText("Save"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        materialButton4.perform(click());

        ViewInteraction linearLayout = onView(
                allOf(withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        linearLayout.check(matches(isDisplayed()));

        ViewInteraction textView9 = onView(
                allOf(withId(R.id.form_saved_txt_id), withText("Reservation Saved"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class))),
                        isDisplayed()));
        textView9.check(matches(isDisplayed()));

        ViewInteraction textView10 = onView(
                allOf(withId(R.id.form_saved_txt_id), withText("Reservation Saved"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class))),
                        isDisplayed()));
        textView10.check(matches(withText("Reservation Saved")));

        ViewInteraction button9 = onView(
                allOf(withId(R.id.return_main_bttn_id), withText("OK"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class))),
                        isDisplayed()));
        button9.check(matches(isDisplayed()));

        ViewInteraction button10 = onView(
                allOf(withId(R.id.return_main_bttn_id), withText("OK"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class))),
                        isDisplayed()));
        button10.check(matches(isDisplayed()));

        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.return_main_bttn_id), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                2),
                        isDisplayed()));
        materialButton5.perform(click());

//        ViewInteraction linearLayout2 = onView(
//                allOf(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class)),
//                        isDisplayed()));
//        linearLayout2.check(matches(isDisplayed()));

        ViewInteraction editText21 = onView(
                allOf(withId(R.id.departure_city_edit_id), withText("Flying From"),
                        withParent(allOf(withId(R.id.linearLayout),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        editText21.check(matches(isDisplayed()));

        ViewInteraction editText22 = onView(
                allOf(withId(R.id.departure_city_edit_id), withText("Flying From"),
                        withParent(allOf(withId(R.id.linearLayout),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        editText22.check(matches(withText("Flying From")));

        ViewInteraction editText23 = onView(
                allOf(withId(R.id.arrival_city_edit_id), withText("Flying To"),
                        withParent(allOf(withId(R.id.linearLayout),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        editText23.check(matches(isDisplayed()));

        ViewInteraction editText24 = onView(
                allOf(withId(R.id.arrival_city_edit_id), withText("Flying To"),
                        withParent(allOf(withId(R.id.linearLayout),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        editText24.check(matches(withText("Flying To")));

        ViewInteraction editText25 = onView(
                allOf(withId(R.id.select_dates_edit), withText("Dates"),
                        withParent(allOf(withId(R.id.linearLayout2),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        editText25.check(matches(isDisplayed()));

        ViewInteraction editText26 = onView(
                allOf(withId(R.id.select_dates_edit), withText("Dates"),
                        withParent(allOf(withId(R.id.linearLayout2),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        editText26.check(matches(withText("Dates")));

        ViewInteraction editText27 = onView(
                allOf(withId(R.id.select_dates_edit), withText("Dates"),
                        withParent(allOf(withId(R.id.linearLayout2),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        editText27.check(matches(withText("Dates")));

        ViewInteraction button11 = onView(
                allOf(withId(R.id.search_flights_bttn_id), withText("SEARCH FLIGHTS"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        button11.check(matches(isDisplayed()));

        ViewInteraction button12 = onView(
                allOf(withId(R.id.search_flights_bttn_id), withText("SEARCH FLIGHTS"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        button12.check(matches(isDisplayed()));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    private <T> Matcher<T> firstView(final Matcher<T> matcher) {
        return new BaseMatcher<T>() {

            boolean isFirst = true;

            @Override
            public boolean matches(Object item) {
                if (isFirst && matcher.matches(item)) {
                    isFirst = false;
                    return true;
                }

                return false;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("should return first matching item");
            }
        };
    }

}
