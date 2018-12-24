package com.example.shayak.eeelabapp

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

    class ExperimentsListAdapter(val context: Context, var listOfExperiments: ArrayList<Experiment>):BaseAdapter(){
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val experiment = listOfExperiments[p0]
            var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var listView = inflater.inflate(R.layout.experiment_card, null)
            listView.textViewExperimentName.text = experiment.experimentName
            return listView
        }

        override fun getItem(p0: Int): Any = listOfExperiments[p0]

        override fun getItemId(p0: Int): Long = p0.toLong()

        override fun getCount(): Int = listOfExperiments.size

    }


}
