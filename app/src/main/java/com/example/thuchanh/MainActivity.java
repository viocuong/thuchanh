package com.example.thuchanh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.thuchanh.model.ThaThinh;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtName;
    private Button btnTime, btnAdd;
    private Spinner spinner;
    private RatingBar rating;
    private List<Integer> imgs = new ArrayList<>();
    private List<ThaThinh> list = new ArrayList<>();
    private RecyclerView rcv ;
    private ThathinhAdapter adapter;
    private String time;
    private int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    public void initView(){
        rcv = findViewById(R.id.rcv);
        txtName = findViewById(R.id.txtName);
        btnAdd = findViewById(R.id.btnThem);
        btnTime = findViewById(R.id.btnTime);
        spinner = findViewById(R.id.spiner);
        rating = findViewById(R.id.rating);
        btnAdd.setOnClickListener(this);
        btnTime.setOnClickListener(this);
        imgs.add(R.drawable.cat1);
        imgs.add(R.drawable.cat2);
        imgs.add(R.drawable.cat3);
        imgs.add(R.drawable.cat4);
        imgs.add(R.drawable.cat5);
        spinner.setAdapter(new SpinerAdapter(this,imgs));
        adapter = new ThathinhAdapter(this,list);
        rcv.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        rcv.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnThem:
                list.add(new ThaThinh((int)spinner.getSelectedItem(),txtName.getText().toString(),id++,time,rating.getRating()));
                adapter.notifyDataSetChanged();
                break;
            case R.id.btnTime:
                TimePickerDialog picker = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                             time = hourOfDay+":"+minute;
                    }
                },6,0,true);
                picker.show();
                break;
        }
    }
}