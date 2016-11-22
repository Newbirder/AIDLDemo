package cn.newbirder.android.aidldemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import cn.newbirder.android.aidldemo.City;
import cn.newbirder.android.aidldemo.ICityManager;

/**
 * Created by NewBirder on 16/11/22.
 */

public class CityManagerService extends Service {

    private static final String TAG = "CityManagerService";

    private CopyOnWriteArrayList<City> mCityList = new CopyOnWriteArrayList<City>();

    private Binder mBinder = new ICityManager.Stub() {

        @Override
        public List<City> getCityList() throws RemoteException {
            return mCityList;
        }

        @Override
        public void addCity(City city) throws RemoteException {
            mCityList.add(city);
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        mCityList.add(new City(0, "Guangzhou"));
        mCityList.add(new City(1, "Shenzhen"));
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}
