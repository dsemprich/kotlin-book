package de.affinitas.test.kotlinbook

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import de.affinitas.test.kotlinbook.domain.commands.RequestForecastCommand
import de.affinitas.test.kotlinbook.view.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    private val url = "http://api.openweathermap.org/data/2.5/weather?q=Berlin&appid=bd5e378503939ddaee76f12ad7a97608"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forecast_list.layoutManager = LinearLayoutManager(this)

        doAsync{
           val result = RequestForecastCommand("16356").execute()
            uiThread { forecast_list.adapter = ForecastListAdapter(result, { toast(it.date) }) }
        }
    }
}
