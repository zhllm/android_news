package com.beyourself.android_news;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends AndroidViewModel {
    private int aBack, bBack;
    private final SavedStateHandle mHandle;

    public final String ATeamScore = "aTeamScore";
    public final String BTeamScore = "bTeamScore";

    public MyViewModel(@NonNull Application application, SavedStateHandle handle) {
        super(application);
        this.mHandle = handle;
        if (!handle.contains(ATeamScore) || !handle.contains(BTeamScore)) {
            load();
        }
    }

    public void load() {
        SharedPreferences shp = getApplication().getSharedPreferences("shp_name",
                Context.MODE_PRIVATE);
        int score = shp.getInt(ATeamScore, 0);
        mHandle.set(ATeamScore, score);
    }

    public void save() {
        SharedPreferences shp = getApplication().getSharedPreferences("shp_name",
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        editor.putInt(ATeamScore, getATeamScoreValue());
        editor.apply();
    }


    // 特别提醒     0000000*********   和xml中view的绑定，如果想liveData更新后能更新视图，一定要返回
    // liveData，而不是某个具体的   liveData.getValue  值！！！！！！
    public MutableLiveData<Integer> getATeamScore() {
        if (!mHandle.contains(ATeamScore)) {
            mHandle.set(ATeamScore, 0);
        }
        return mHandle.getLiveData(ATeamScore);
    }

    public int getATeamScoreValue() {
        return getATeamScore().getValue();
    }

    public int getBTeamScoreValue() {
        return getBTeamScore().getValue();
    }

    public MutableLiveData<Integer> getBTeamScore() {
        if (!mHandle.contains(BTeamScore)) {
            mHandle.set(BTeamScore, 0);
        }
        return mHandle.getLiveData(BTeamScore);
    }

    public void aTeamAdd(int n) {
        aBack = getATeamScore().getValue();
        bBack = getBTeamScore().getValue();
        getATeamScore().setValue(getATeamScore().getValue() + n);
    }

    public void bTeamAdd(int n) {
        aBack = getATeamScore().getValue();
        bBack = getBTeamScore().getValue();
        getBTeamScore().setValue(getBTeamScore().getValue() + n);
    }

    public void reset() {
        aBack = getATeamScore().getValue();
        bBack = getBTeamScore().getValue();
        getATeamScore().setValue(0);
        getBTeamScore().setValue(0);
    }

    public void undo() {
        getATeamScore().setValue(aBack);
        getBTeamScore().setValue(bBack);
    }

}
