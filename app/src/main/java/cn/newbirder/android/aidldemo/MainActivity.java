package cn.newbirder.android.aidldemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import cn.newbirder.android.aidldemo.service.CityManagerService;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            ICityManager cityManager = ICityManager.Stub.asInterface(service);
            try {
                List<City> list = cityManager.getCityList();
                Log.d(TAG, "city list:" + list.toString());
                cityManager.addCity(new City(2, "Shanghai"));

                List<City> list1 = cityManager.getCityList();
                Log.d(TAG, "city list1:" + list1.toString());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, CityManagerService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        unbindService(mConnection);
        super.onDestroy();
    }

}
