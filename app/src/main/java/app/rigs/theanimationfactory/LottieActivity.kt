package app.rigs.theanimationfactory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Lottie is a Third Party SDK that provides the ability to play complex animations that are not easily satisfied by AVDs,
 * or ViewPropertyAnimators. Use a plugin called BodyMovin on After Effects to convert an animation into a .json file that describes how the animator should behave.
 * The integration on Android, React Native and iOS is simple and provides the same complex animation across platforms.
 *
 * Why use?
 * -------
 * Easily animate complex things. Use After Effects files across platforms. Simple API, small JSON files.
 * Very flexible.
 *
 * When to use?
 * -----------
 * Complex image that needs to be animated. ie when your designer says "Can you make this watermelon smile?" 🍉😬
 *
 *
 * More info:
 * https://airbnb.design/lottie/
 * https://www.lottiefiles.com/
 *
 */
class LottieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lottie)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setTitle(R.string.title_lottie)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}