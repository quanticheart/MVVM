package com.master.killercode.mvvm;

import android.content.ContentValues;
import android.content.Context;
import android.databinding.ObservableField;

import com.master.killercode.mvvm.Helper.DataBaseUtil;
import com.master.killercode.mvvm.Helper.SQLiteHelper;

import java.util.List;

public class mvvmActivityVM {

    private DataBaseUtil dbUtil;

    mvvmActivityVM(Context context) {
        dbUtil = new DataBaseUtil(context);
    }

    public ObservableField<String> job = new ObservableField<>();

    public void onAddJob() {
        String text = job.get();

        ContentValues cv = new ContentValues();
        cv.put(SQLiteHelper.COLLUM, text);

        dbUtil.addJob(SQLiteHelper.TABLE_NAME, cv);
    }

    public void deleteJob(String field_params) {
        dbUtil.deleteJob(SQLiteHelper.TABLE_NAME, field_params);
    }

    public List<String> getJobsList() {
        return dbUtil.getList();
    }

}
