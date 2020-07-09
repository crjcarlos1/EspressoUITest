package com.cralos.espressouitest.ui

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.cralos.espressouitest.R
import com.cralos.espressouitest.factory.MovieFragmentFactory
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class StarActorsFragmentTest{

    @Test
    fun test_isActorsListVisible() {
        //Given
        val actors = arrayListOf("Dwayne Johnson", "Seann William Scott", "Rosario Dawson", "Christopher Walken")
        val fragmentFactory = MovieFragmentFactory(null,null)
        val bundle = Bundle()
        bundle.putStringArrayList("args_actors",actors)
        val scenario = launchFragmentInContainer<StarActorsFragment>(fragmentArgs = bundle,factory = fragmentFactory)

        //verify
        Espresso.onView(ViewMatchers.withId(R.id.star_actors_text)).check(
            ViewAssertions.matches(
                ViewMatchers.withText(
                    StarActorsFragment.stringBuilderForStarActors(actors)
                )
            )
        )
    }

}