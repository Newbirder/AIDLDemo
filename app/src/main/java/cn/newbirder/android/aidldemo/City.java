package cn.newbirder.android.aidldemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by NewBirder on 16/11/20.
 */

public class City implements Parcelable {

    private int cityId;
    private String cityName;

    public City(int cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    protected City(Parcel in) {
        cityId = in.readInt();
        cityName = in.readString();
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(cityId);
        parcel.writeString(cityName);
    }

    @Override
    public String toString() {
        return "[" + this.cityId + "," + this.cityName + "]";
    }
}
