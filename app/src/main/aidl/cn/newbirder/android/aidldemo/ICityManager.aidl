// ICityManager.aidl
package cn.newbirder.android.aidldemo;

// Declare any non-default types here with import statements
import cn.newbirder.android.aidldemo.City;

interface ICityManager {
    List<City> getCityList();
    void addCity(in City city);
}
