package app.rigs.theanimationfactory.motionlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.rigs.theanimationfactory.R
import kotlinx.android.synthetic.main.activity_motionlayout.*

/**
 * MotionLayout is part of ConstraintLayout 2.0 (which is still in alpha). It allows you to create complex UI animations that can depend on user interactions with your view.
 * For example, you can animate a bunch of items, when a user scrolls on a certain part of a view.
 *
 * When to use?
 * ----------
 * When you have a UI interaction that drives how your animations affect certain views. Ie a transformation in a view layout.
 *
 * Why use?
 * --------
 * Simplifies your animation code. Allows you to create complex animations based on user interactions without needing much knowledge.
 *
 * More info:
 * --------
 * https://developer.android.com/reference/android/support/constraint/motion/MotionLayout
 * https://github.com/googlesamples/android-ConstraintLayoutExamples
 */
class MotionLayoutActivity : AppCompatActivity() {

    private val statusAdapter: StatusAdapter = StatusAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motionlayout)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setTitle(R.string.title_motion_layout)
        }

        setupView()
    }

    private fun setupView() {
        recyclerViewStatus.adapter = statusAdapter
        recyclerViewStatus.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)

        val dummyStatuses = arrayListOf(
            Status("1", "I love chocolate", name = "Veruca Salt"),
            Status("2", "I WANT IT NOW", name = "Veruca Salt"),
            Status("3", "The blueberries taste like blueberries", name = "Veruca Salt"),
            Status("4", "I've been chewing this same piece of gum for 4 years now!", name = "Veruca Salt"),
            Status("5", "DADDY!!!!!", name = "Veruca Salt"),
            Status("6", "Please DADDY, buy this chocolate factory for me?🍫", name = "Veruca Salt"),
            Status("7", "I can't believe these other kids, eating all the candy from MY chocolate factory", name = "Veruca Salt")
        )
        statusAdapter.submitList(dummyStatuses)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}