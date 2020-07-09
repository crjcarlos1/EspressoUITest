package com.cralos.espressouitest.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.cralos.espressouitest.R
import com.cralos.espressouitest.data.FakeMovieData
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MovieListFragmentTest {

    @get : Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    val LIST_ITEM_IN_TEST = 4
    val MOVIE_IN_TEST = FakeMovieData.movies[LIST_ITEM_IN_TEST]

    /***
     * recyclerView comes into view
     */
    @Test
    fun test_isListFragmentVisible_onAppLaunch() {
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))
    }

    /**
     * select list item, nav to detail fragment
     * correct movie is in view
     */
    @Test
    fun test_selectListItem_isDetailFragmentVisible() {

        onView(withId(R.id.recycler_view)).perform(
            actionOnItemAtPosition<MoviesListAdapter.MovieViewHolder>(
                LIST_ITEM_IN_TEST,
                click()
            )
        )

        onView(withId(R.id.movie_title)).check(matches(withText(MOVIE_IN_TEST.title)))
    }

    /**
     * select list item, nav to detail fragment
     * pressBack
     */
    @Test
    fun test_bacNavigation_toMovieListFragment() {
        onView(withId(R.id.recycler_view)).perform(
            actionOnItemAtPosition<MoviesListAdapter.MovieViewHolder>(
                LIST_ITEM_IN_TEST,
                click()
            )
        )

        onView(withId(R.id.movie_title)).check(matches(withText(MOVIE_IN_TEST.title)))

        pressBack()

        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))
    }

    /***
     * selact list item, nav to detailFragment
     * select directorsTextView, nav to DirectorsFragment
     */
    @Test
    fun test_navDirectorsFragment_validateDirectorsList() {
        onView(withId(R.id.recycler_view)).perform(actionOnItemAtPosition<MoviesListAdapter.MovieViewHolder>(LIST_ITEM_IN_TEST, click()))

        onView(withId(R.id.movie_title)).check(matches(withText(MOVIE_IN_TEST.title)))

        onView(withId(R.id.movie_directiors)).perform(click())

        val directors = MOVIE_IN_TEST.directors
        val verifyDirectorsValue = DirectorsFragment.stringBuilderForDirectors(directors!!)

        onView(withId(R.id.directors_text)).check(matches(withText(verifyDirectorsValue)))
    }

    /***
     * select list item, nav to StarActorsFragment
     * select starActors textview,nav to starActorsFragment
     */
    @Test
    fun test_navStarActorsFragment_validateActorsList() {
        onView(withId(R.id.recycler_view)).perform(
            actionOnItemAtPosition<MoviesListAdapter.MovieViewHolder>(
                LIST_ITEM_IN_TEST,
                click()
            )
        )

        onView(withId(R.id.movie_title)).check(matches(withText(MOVIE_IN_TEST.title)))

        onView(withId(R.id.movie_star_actors)).perform(click())

        val actors = MOVIE_IN_TEST.star_actors
        val verifyActorsValue = StarActorsFragment.stringBuilderForStarActors(actors!!)

        onView(withId(R.id.star_actors_text)).check(matches(withText(verifyActorsValue)))
    }


}












