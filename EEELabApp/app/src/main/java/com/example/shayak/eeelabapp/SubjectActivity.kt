package com.example.shayak.eeelabapp

/**
 * This is the activity that will load when the user clicks one of the subjects in the
 * MainActivity.
 *
 * Currently the list of experiments is hardcoded but soon it will be made dynamic.
 *
 * Clicking on 'WATCH VIDEO' will open the corresponding experiment's demonstration video
 * Clicking on 'VIEW MATERIAL' will open the corresponding experiment's writeup
 *
 * @author Shayak Banerjee
 * @version 0.1
 * @since 23rd Dec, 2018
 */

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_subject.*
import kotlinx.android.synthetic.main.experiment_card.view.*

class SubjectActivity : AppCompatActivity() {

    var listOfExperiments = ArrayList<Experiment>() // The list of experiments to be displayed
    var experimentsListAdapter: ExperimentsListAdapter? = null //The ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject)

        //load subjects
        listOfExperiments.add(Experiment("Measurement of resistance", "", ""))
        listOfExperiments.add(Experiment("Measurement of resistance", "", ""))
        listOfExperiments.add(Experiment("Measurement of resistance", "", ""))
        listOfExperiments.add(Experiment("Measurement of resistance", "", ""))
        listOfExperiments.add(Experiment("Measurement of resistance", "", ""))

        //setting ListAdapter
        experimentsListAdapter = ExperimentsListAdapter(this, listOfExperiments)
        listView.adapter = experimentsListAdapter

        //dynamically setting the size of the ListView to fit all the items
        var layoutParams = listView.layoutParams

        val scale = resources.displayMetrics.density
        layoutParams.height = ((scale * 190 + 0.5f) * listOfExperiments.size).toInt()

        listView.layoutParams = layoutParams

        //loads the view from the top, by preventing listView to gain focus on the start of activity
        listView.isFocusable = false
    }

    /**
     * Adapter class for the listView
     */
    class ExperimentsListAdapter(val context: Context, var listOfExperiments: ArrayList<Experiment>):BaseAdapter(){
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val experiment = listOfExperiments[p0]
            var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var listView = inflater.inflate(R.layout.experiment_card, null)
            listView.textViewExperimentName.text = experiment.experimentName
            return listView
        }

        /**
         * @return experiment of type Experiment. Contains details about the experiment
         * and must be passed in the intent to the ExperimentActivity
         */
        override fun getItem(p0: Int): Any = listOfExperiments[p0]

        override fun getItemId(p0: Int): Long = p0.toLong()

        /**
         * returns the number of items in the list.
         */
        override fun getCount(): Int = listOfExperiments.size

    }


}
