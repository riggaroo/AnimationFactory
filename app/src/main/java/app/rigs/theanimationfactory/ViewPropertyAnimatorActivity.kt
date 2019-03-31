package app.rigs.theanimationfactory

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_view_property_animator.*

/**
 * This example demonstrates how to use ViewPropertyAnimators to achieve animations concurrently.
 * The API is simple and easy to use. A property animation changes a property's (a field in an object) value over a specified length of time.
 *
 * Why use?
 * -------
 * Simple and effective. Quick to do a small animation, not much setup required.
 *
 * When to use?
 * -----------
 * Animating a certain view's properties at the same time.
 *
 * More Info:
 * ---------
 * https://developer.android.com/training/animation/reveal-or-hide-view
 */
class ViewPropertyAnimatorActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_property_animator)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setTitle(R.string.title_view_property_animator)
        }

        setupViewPropertyAnimations()
    }

    private var animated = false

    private fun setupViewPropertyAnimations() {
        buttonAnimateViewProperty.setOnClickListener {
            if (!animated){
                imageViewGoldenTicket.animate()
                    .alpha(0f)
                    .rotationBy(360f)
                    .scaleX(0f)
                    .scaleY(0f)
                    .setDuration(2000)
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            // Animation finished.
                        }
                    })
                    .start()
            } else {
                imageViewGoldenTicket.animate()
                    .alpha(1f)
                    .rotationBy(360f)
                    .scaleX(1f)
                    .scaleY(1f)
                    .setDuration(2000)
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            // Animation finished.
                        }
                    })
                    .start()
            }
            animated = !animated
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
