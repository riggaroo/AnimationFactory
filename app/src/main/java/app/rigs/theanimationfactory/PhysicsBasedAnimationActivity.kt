package app.rigs.theanimationfactory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.FlingAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import kotlinx.android.synthetic.main.activity_physics_based_animation.*

/**
 * This class demonstrates how to use Physics Based animations.
 *
 * Why use?
 * --------
 * ViewPropertyAnimators have a fixed and static duration, requiring you to stop and start the animation yourself.
 * Physics based animations look natural as they apply real world physics to them.
 *
 * When to use?
 * ----------
 * When you want an animation driven by force, ie flinging something with a certain velocity
 *
 * More Info:
 * ---------
 * https://developer.android.com/guide/topics/graphics/spring-animation.html
 * https://developer.android.com/guide/topics/graphics/fling-animation.html
 */
class PhysicsBasedAnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physics_based_animation)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setTitle(R.string.title_physics_based_animation)
        }

        setupPhysicsAnimation()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private var animatedSpring = false
    private var animatedFling = false

    private fun setupPhysicsAnimation(){
        buttonAnimatePhysics.setOnClickListener {
            if (!animatedSpring){
                SpringAnimation(imageViewGoldenTicket, DynamicAnimation.TRANSLATION_Y, 700f).apply {
                    spring.stiffness = 60f
                    spring.dampingRatio = 0.3f
                }.start()
            } else {
                SpringAnimation(imageViewGoldenTicket, DynamicAnimation.TRANSLATION_Y, 0f).apply {
                    spring.stiffness = 60f
                    spring.dampingRatio = 0.3f
                }.start()
            }

            animatedSpring = !animatedSpring
        }

        buttonFlingAnimation.setOnClickListener {
            if (!animatedFling){
                FlingAnimation(imageViewGoldenTicket, DynamicAnimation.TRANSLATION_Y).apply {
                    setStartVelocity(700f) // Pixels per second
                    friction = 0.1f
                }.start()
            } else {
                FlingAnimation(imageViewGoldenTicket, DynamicAnimation.TRANSLATION_Y).apply {
                    setStartVelocity(-700f) // Pixels per second
                    friction = 0.1f
                }.start()
            }
            animatedFling = !animatedFling
        }
    }
}