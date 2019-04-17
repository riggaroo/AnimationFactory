package app.rigs.theanimationfactory.customview

import android.animation.FloatEvaluator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.LinearGradient
import android.graphics.Matrix
import android.graphics.Shader
import android.util.AttributeSet
import android.view.animation.LinearInterpolator
import android.widget.TextView
import androidx.core.content.ContextCompat
import app.rigs.theanimationfactory.R

/**
 * This is another example of a Custom View performing its own complex animation using PropertyValuesHolder. Have a look at
 * AnimatedSimpleTextView for another example.
 * This TextView animates the text colour, using a LinearGradient Shader.
 *
 * Thanks to Chiu-Ki Chan for the inspiration.
 * Reference http://chiuki.github.io/android-shaders-filters/#/5
 */
class AnimatedRainbowTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : TextView(context, attrs, defStyleAttr) {

    private val rainbowColors: IntArray
        get() =
            intArrayOf(
                ContextCompat.getColor(context, R.color.rainbow_red),
                ContextCompat.getColor(context, R.color.rainbow_orange),
                ContextCompat.getColor(context, R.color.rainbow_yellow),
                ContextCompat.getColor(context, R.color.rainbow_green),
                ContextCompat.getColor(context, R.color.rainbow_blue),
                ContextCompat.getColor(context, R.color.rainbow_purple)
            )

    private var translateXPercentage = 0f

    private var shader: LinearGradient? = null

    private var animationMatrix = Matrix()

    init {
        animateRainbowTextView()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        val rainbow = rainbowColors
        shader = LinearGradient(
            0f, 0f, 0f, w.toFloat(), rainbow,
            null, Shader.TileMode.MIRROR
        )
    }

    private fun animateRainbowTextView() {

        val propertyValuesHolder = PropertyValuesHolder.ofFloat(ANIMATED_COLOR_FLOAT_PROPERTY, 0f, 100f)

        ValueAnimator.ofPropertyValuesHolder(propertyValuesHolder).apply {
            setEvaluator(FloatEvaluator())
            addUpdateListener { animator ->
                animationMatrix = Matrix().apply {
                    setRotate(90f)
                }
                translateXPercentage = animator.getAnimatedValue(ANIMATED_COLOR_FLOAT_PROPERTY) as Float
                animationMatrix.postTranslate(width * translateXPercentage, 0f) // provides the animation
                shader?.setLocalMatrix(animationMatrix)

                paint.shader = shader
                invalidate()
            }

            repeatCount = ValueAnimator.INFINITE
            interpolator = LinearInterpolator()
            duration = 60000 * 3
            start()
        }
    }

    companion object {
        const val ANIMATED_COLOR_FLOAT_PROPERTY = "animated_color"
    }
}