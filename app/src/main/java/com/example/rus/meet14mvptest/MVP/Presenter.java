package com.example.rus.meet14mvptest.MVP;

import android.util.Log;

import com.example.rus.meet14mvptest.WeatherDay;

public class Presenter implements DetailedPresenter {
    private DetailedModel model;
    private DetailedView detailedView;

    public Presenter(Model model) {
        this.model = model;
    }

    public void attachView(DetailedView view){
        detailedView = view;
    }

    @Override
    public void getInfo(int position) {
        Log.v("TAG", " Position recieved");
        WeatherDay weatherDay = model.getWeatherDay(position);
        detailedView.setDetailedViews(weatherDay);
    }
}
