package app.rigs.theanimationfactory

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.rigs.theanimationfactory.customview.CustomViewAnimationActivity
import app.rigs.theanimationfactory.motionlayout.MotionLayoutActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBackground()
        setupButtons()
    }

    private fun setupBackground() {
        // Set cut corner background for API 23+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            constraintLayoutMain.background = baseContext.getDrawable(R.drawable.background_corner_radius)
        }
    }

    private fun setupButtons() {
        buttonAvd.setOnClickListener {
           startActivity(Intent(this, AnimatedVectorDrawablesActivity::class.java))
        }

        buttonLottie.setOnClickListener {
            startActivity(Intent(this, LottieActivity::class.java))
        }

        buttonCustomView.setOnClickListener {
            startActivity(Intent(this, CustomViewAnimationActivity::class.java))
        }

        buttonMotionLayout.setOnClickListener {
            startActivity(Intent(this, MotionLayoutActivity::class.java))
        }

        buttonPhysicsBasedAnim.setOnClickListener {
            startActivity(Intent(this, PhysicsBasedAnimationActivity::class.java))
        }

        buttonViewPropertyAnimator.setOnClickListener {
            startActivity(Intent(this, ViewPropertyAnimatorActivity::class.java))
        }
    }
}
