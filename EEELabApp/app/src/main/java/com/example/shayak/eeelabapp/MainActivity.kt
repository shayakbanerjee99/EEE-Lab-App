package com.example.shayak.eeelabapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.subject_card.view.*

class MainActivity : AppCompatActivity() {


    var listOfSubjects = ArrayList<Pair<String, String>>() // Pair<SubjectName, SubjectCode>
    var subjectsListAdapter: SubjectsListAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //load subjects (dummy)
        listOfSubjects.add(Pair("Electrical Engineering Practices", "15EE102L"))
        listOfSubjects.add(Pair("Electric Circuits Laboratory", "15EE103L"))
        listOfSubjects.add(Pair("Electric Machines", "15EE104L"))
        listOfSubjects.add(Pair("Electrical Other Machines", "15EE104L"))

        subjectsListAdapter = SubjectsListAdapter(this, listOfSubjects)
        subjectsListView.adapter = subjectsListAdapter


    }

    fun startSubjectActivity(view: View){
        val intent = Intent(this, SubjectActivity::class.java)
        //TODO: intent.putExtra( /*An ArrayList containing contents to be displayed*/)
        startActivity(intent)
    }

    class SubjectsListAdapter(val context: Context, var listOfSubjects: ArrayList<Pair<String, String>>):BaseAdapter(){
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val subject = listOfSubjects[p0]
            var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var listView = inflater.inflate(R.layout.subject_card, null)
            listView.textViewSubjectName.text = subject.first;
            listView.textViewSubjectCode.text = subject.second;
            return listView
        }

        override fun getItem(p0: Int): Any = listOfSubjects[p0]

        override fun getItemId(p0: Int): Long = p0.toLong()

        override fun getCount(): Int = listOfSubjects.size

    }


}
