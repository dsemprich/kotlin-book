package de.affinitas.test.kotlinbook

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import de.affinitas.test.kotlinbook.domain.commands.RequestForecastCommand
import de.affinitas.test.kotlinbook.domain.model.ForecastList
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    private val url = "http://api.openweathermap.org/data/2.5/weather?q=Berlin&appid=bd5e378503939ddaee76f12ad7a97608"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forecast_list.layoutManager = LinearLayoutManager(this)

        doAsync{
           val result = RequestForecastCommand("10777").execute()
            uiThread { forecast_list.adapter = ForecastListAdapter(result) }
        }
    }


    class ForecastListAdapter(val weekForecast: ForecastList) :
            RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
            return ViewHolder(TextView(parent.context))
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            with(weekForecast.dailyForecast[position]) {
                holder.textView.text = "$date - $description - $high/$low"
            }
        }

        override fun getItemCount(): Int = weekForecast.dailyForecast.size

        class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
    }

}
