//package com.example.dvtweatherapplication.Fragment;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import androidx.lifecycle.Observer;
//import androidx.lifecycle.ViewModelProviders;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//
//import com.example.dvtweatherapplication.Model.CurrentWeatherResponse;
//import com.example.dvtweatherapplication.R;
//import com.example.dvtweatherapplication.ViewModel.WeatherForecastViewModel;
//
//public class WeatherFragment extends Fragment {
//
//
//    private WeatherForecastViewModel viewModel;
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        adapter = new CurrentWeatherAdapter();
//
//        viewModel = ViewModelProviders.of(this).get(WeatherForecastViewModel.class);
//        viewModel.init();
//        viewModel.getCurrentWeatherLiveData().observe(this, new Observer<CurrentWeatherResponse>() {
//            @Override
//            public void onChanged(CurrentWeatherResponse currentWeatherResponse) {
//                if (currentWeatherResponse != null) {
//
//                }
//            }
//
//
//        });
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_current_weather, container, false);
//
//        RecyclerView recyclerView = view.findViewById(R.id.fragment_currentweather);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.setAdapter(adapter);
//
//
//        return view;
//    }
//
//}
