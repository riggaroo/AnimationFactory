package app.rigs.theanimationfactory

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import kotlinx.android.synthetic.main.activity_animatedvectordrawable.*

/**
 * AnimatedVectorDrawables (or AVDs) are for animating VectorDrawable properties. A VectorDrawable is an
 * XML file that describes how to draw a graphic, you can think of it as Android's SVG format,
 * except there are some things that a VectorDrawable can't do, that an SVG can.
 * Creating AVDs can be complex if you try do it by hand, luckily there is this awesome Third Party tool called
 * ShapeShifter that helps you create these small animations.
 *
 * Why use?
 * -------
 * Powerful API - ie you can transform between paths, encapsulated in an XML file.
 *
 * When to use?
 * -----------
 * Small animations on vector graphics. Ie icon animations.
 *
 * More info:
 * ---------
 * https://developer.android.com/reference/android/graphics/drawable/AnimatedVectorDrawable
 * https://developer.android.com/reference/android/graphics/drawable/VectorDrawable
 * https://shapeshifter.design
 */
class AnimatedVectorDrawablesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animatedvectordrawable)
        setupAnimations()
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setTitle(R.string.title_avd)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupAnimations() {
        val drawable = AnimatedVectorDrawableCompat.create(applicationContext, R.drawable.avd_letter_spacing_black_24dp)
        imageViewAvd.setImageDrawable(drawable)

        imageViewAvd.setOnClickListener {
            val animatedDrawable = imageViewAvd.drawable as AnimatedVectorDrawableCompat
            animatedDrawable.registerAnimationCallback(object : Animatable2Compat.AnimationCallback() {
                override fun onAnimationEnd(drawable: Drawable?) {
                    super.onAnimationEnd(drawable)
                    Toast.makeText(applicationContext, "Animation finished", Toast.LENGTH_LONG).show()
                }
            })
            animatedDrawable.start()
        }

        val drawableBin: AnimatedVectorDrawableCompat? =
            AnimatedVectorDrawableCompat.create(applicationContext, R.drawable.avd_bin_open_close_black_24dp)
        imageViewAvd2.setImageDrawable(drawableBin)

        imageViewAvd2.setOnClickListener {
            val animatedDrawable = imageViewAvd2.drawable as AnimatedVectorDrawableCompat
            animatedDrawable.registerAnimationCallback(object : Animatable2Compat.AnimationCallback() {
                override fun onAnimationEnd(drawable: Drawable?) {
                    super.onAnimationEnd(drawable)
                    Toast.makeText(applicationContext, "Animation finished", Toast.LENGTH_LONG).show()
                }
            })
            animatedDrawable.start()
        }
    }


}