package app.rigs.theanimationfactory.customview

import android.animation.ArgbEvaluator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import app.rigs.theanimationfactory.R

/**
 * This View demonstrates how you can write a custom animation for your own Custom View, using PropertyValuesHolder
 * and calling `.invalidate()`, which will trigger a redraw of the View.
 *
 * Take a look at `animateTextSizeColorChange()` for the animation logic.
 */
class AnimatedSimpleTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var text: String = "I got a Golden Ticket!"

    @ColorInt
    private var textColor: Int

    private var size: Float = 80f

    init {
        textColor = ContextCompat.getColor(context, R.color.startColorAnimation)
    }

    private var textPaint: Paint = Paint().apply {
        color = textColor
        textSize = size
        typeface = ResourcesCompat.getFont(context, R.font.willywonka)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawText(text, 0f, height / 2f, textPaint)
    }

    private fun setTextSizeColor(textSize: Float, textColor: Int) {
        this.size = textSize
        this.textColor = textColor
        textPaint.textSize = size
        textPaint.color = textColor
        invalidate()
    }

    fun animateTextSizeColorChange(toSize: Float, @ColorInt toColor: Int) {
        val propertyTextColor = PropertyValuesHolder.ofInt(PROPERTY_TEXT_COLOR, textColor, toColor)
        val propertyTextSize = PropertyValuesHolder.ofFloat(PROPERTY_TEXT_SIZE, size, toSize)
        ValueAnimator.ofPropertyValuesHolder(propertyTextColor, propertyTextSize).apply {
            setEvaluator(ArgbEvaluator())
            duration = 500
            addUpdateListener { animation ->
                val textSize = animation.getAnimatedValue(PROPERTY_TEXT_SIZE) as Float
                val textColor = animation.getAnimatedValue(PROPERTY_TEXT_COLOR) as Int
                setTextSizeColor(textSize, textColor)
            }
            start()
        }
    }

    companion object {
        private const val PROPERTY_TEXT_COLOR = "textColor"
        private const val PROPERTY_TEXT_SIZE = "size"
    }
}