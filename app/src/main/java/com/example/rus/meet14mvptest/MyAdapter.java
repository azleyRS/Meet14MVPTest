package com.example.rus.meet14mvptest;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rus.meet14mvptest.MVP.DetailedActivityMVP;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<WeatherDay> weatherDayList;

    public MyAdapter(List<WeatherDay> weatherDayList) {
        this.weatherDayList = weatherDayList;
    }

    public MyAdapter() {
        weatherDayList = new ArrayList<>();
    }

    public void update(List<WeatherDay> weatherDayList){
        this.weatherDayList = weatherDayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
/*        holder.time.setText(weatherDayList.get(position).getDate().toString());
        String result = "Avg temp in Moscow = " + weatherDayList.get(position).getTemp() +
                "\n Min temp = " + weatherDayList.get(position).getTempMin() +
                "\n Min temp = " + weatherDayList.get(position).getTempMax();
        holder.day.setText(result);*/
//holder.time.setText("123");

        holder.bindPosition(position);

        String date = String.format("%d.%d.%d %d",
                weatherDayList.get(position).getDate().get(Calendar.DAY_OF_MONTH),
                weatherDayList.get(position).getDate().get(Calendar.WEEK_OF_MONTH),
                weatherDayList.get(position).getDate().get(Calendar.YEAR),
                weatherDayList.get(position).getDate().get(Calendar.HOUR_OF_DAY));
        holder.mTime.setText(date);

        String result = "Avg temp in Moscow = " + weatherDayList.get(position).getTemp() +
                "\n Min temp = " + weatherDayList.get(position).getTempMin() +
                "\n Min temp = " + weatherDayList.get(position).getTempMax();
        holder.mName.setText(result);

    }

    @Override
    public int getItemCount() {
        return weatherDayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        int positionForBd;

        TextView mTime;
        TextView mName;

        public MyViewHolder(final View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.temp);
            mTime = itemView.findViewById(R.id.day);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.v("TAG", "OnClick");
                    //Intent intent = DetailedInfoActivity.newIntent(itemView.getContext(), positionForBd);
                    //Intent intent = DetailedActivityMVP.newIntent(itemView.getContext(), positionForBd);
                    Intent intent = DetailedActivityMVP.newIntent(itemView.getContext(), positionForBd);
                    itemView.getContext().startActivity(intent);
                }
            });
        }

        public void bindPosition(int position){
            positionForBd = position;
        }
    }
}
