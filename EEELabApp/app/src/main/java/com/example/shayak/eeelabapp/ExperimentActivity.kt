package com.example.shayak.eeelabapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_experiment.*

/**
 * This activity displays written material corresponding to the experiment selected in the SubjectActivity.
 * Currently it contains dummy text and a dummy diagram but as soon as some test data is obtained, it
 * will be updated with the real data and it will work a lot better.
 *
 * @author Shayak Banerjee
 * @version 0.1
 * @since 3rd Jan, 2019
 */
class ExperimentActivity : AppCompatActivity() {

    /** Creates and displays activity_experiment and also loads the name of the experiment as the title.*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_experiment)

        val experimentName = intent.getStringExtra("experimentName")

        experimentNameTextView.text = experimentName
    }
}
