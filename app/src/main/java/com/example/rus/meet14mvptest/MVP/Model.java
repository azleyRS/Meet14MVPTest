package com.example.rus.meet14mvptest.MVP;

import com.example.rus.meet14mvptest.DataBase.DBManager;
import com.example.rus.meet14mvptest.WeatherDay;

public class Model implements DetailedModel {
    DBManager manager;
    public Model(DBManager manager) {
        this.manager = manager;
    }

    @Override
    public WeatherDay getWeatherDay(int position) {
        return manager.getWeatherDay(position);
    }
}
