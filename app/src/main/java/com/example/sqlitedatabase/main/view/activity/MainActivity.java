package com.example.sqlitedatabase.main.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sqlitedatabase.R;
import com.example.sqlitedatabase.main.presenter.MainPresenter;
import com.example.sqlitedatabase.main.view.fragment.MainFragment;
import com.example.sqlitedatabase.utils.ActivityUtils;
import com.example.sqlitedatabase.utils.Injection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment mainFragment = MainFragment.newInstance();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mainFragment, R.id.fl_main);

        new MainPresenter(Injection.proviceMainRepository(this), mainFragment);
    }
}
