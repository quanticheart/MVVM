package com.master.killercode.mvvm;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.master.killercode.mvvm.databinding.ActivityMvvmBinding;

import java.util.List;

@SuppressLint("Registered")
public class mvvmView extends AppCompatActivity {

    ActivityMvvmBinding binding;
    mvvmActivityVM model;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = new mvvmActivityVM(this);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        binding.setViewModel(model);
        binding.executePendingBindings();

        initVars();
        initActions();

    }

    private void initVars() {
//        View view = binding.getRoot(); // for FindView ...
//        listView = view.findViewById(R.id.avJob);
    }

    private void initActions() {
        searshJobs();
    }

    public void onAddJob(View view) {
        binding.getViewModel().onAddJob();
        searshJobs();
    }

    public void searshJobs() {
        final List<String> jobsList = binding.getViewModel().getJobsList();
        binding.list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, jobsList.toArray(new String[]{})));

        binding.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id) {

                final TextView v = (TextView) view;

                binding.getViewModel().deleteJob(v.getText().toString().trim());
                searshJobs();
            }
        });
    }
}
