package com.example.rus.meet14mvptest.MVP;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.rus.meet14mvptest.DataBase.DBManager;
import com.example.rus.meet14mvptest.R;
import com.example.rus.meet14mvptest.WeatherDay;

public class DetailedActivityMVP extends AppCompatActivity implements DetailedView {

    private TextView day;
    private TextView temp;
    private TextView minMaxTemp;
    private TextView pressure;
    private TextView seaLvl;
    private TextView grndLvl;
    private TextView humidity;
    private TextView tempKf;

    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_info);

        init();
    }

    private void init() {
        day = findViewById(R.id.detailed_day);
        temp = findViewById(R.id.detailed_temp);
        minMaxTemp = findViewById(R.id.min_max_temp);
        pressure = findViewById(R.id.pressure);
        seaLvl = findViewById(R.id.sea_level);
        grndLvl = findViewById(R.id.grnd_lvl);
        humidity = findViewById(R.id.humidity);
        tempKf = findViewById(R.id.temp_kd);
        DBManager manager = new DBManager(this);
        Model model = new Model(manager);
        presenter = new Presenter(model);
        presenter.attachView(this);

        Log.v("TAG", "init");

        presenter.getInfo(getIntent().getIntExtra("position",0));
    }

    @Override
    public void setDetailedViews(WeatherDay weatherDay) {
        Log.v("TAG", " DEtailes received");
        day.setText(android.text.format.DateFormat.format("EEE MMM d HH:mm:ss",weatherDay.getDate()));
        temp.setText("MVP Avg temp in Moscow = " + weatherDay.getTemp());
        minMaxTemp.setText("Min temp = " + weatherDay.getTempMin().toString() + "\n" + "Max Temp = " + weatherDay.getTempMax().toString());
        pressure.setText("Pressure = " + weatherDay.getPressure().toString());
        seaLvl.setText("Sea level = " + weatherDay.getSea_level().toString());
        grndLvl.setText("Ground level = " + weatherDay.getGrnd_level().toString());
        humidity.setText("Humidity = " + weatherDay.getHumidity().toString());
        tempKf.setText("Temp KF = " + weatherDay.getTemp_kf().toString());
    }

    public static Intent newIntent(Context context, int positionForBd) {
        Intent intent = new Intent(context, DetailedActivityMVP.class);
        intent.putExtra("position", positionForBd);
        return intent;
    }
}
