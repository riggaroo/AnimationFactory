package app.rigs.theanimationfactory.customview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import app.rigs.theanimationfactory.R
import kotlinx.android.synthetic.main.activity_customviewanimations.*

/**
 * This class demonstrates how you might invoke an animation on a Custom View. Have a look at `AnimatedSimpleTextView`
 * and `AnimatedRainbowTextView` for the custom view animation implementation.
 */
class CustomViewAnimationActivity : AppCompatActivity() {

    var animated = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customviewanimations)
        setupCustomViewAnimation()
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setTitle(R.string.title_custom_view)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupCustomViewAnimation(){
        val startColor = ContextCompat.getColor(applicationContext,
            R.color.startColorAnimation
        )
        val startSize = 80f

        val endColor = ContextCompat.getColor(applicationContext,
            R.color.endColorAnimation
        )
        val endSize = 110f
        buttonAnimateCustomView.setOnClickListener {
            if (animated) {
                animatedSimpleTextView.animateTextSizeColorChange(startSize, startColor)
            } else {
                animatedSimpleTextView.animateTextSizeColorChange(endSize, endColor)
            }
            animated = !animated
        }
    }

}