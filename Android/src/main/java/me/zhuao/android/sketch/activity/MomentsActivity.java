package me.zhuao.android.sketch.activity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;

import me.zhuao.android.sketch.R;

public class MomentsActivity extends Activity {

    private String jsmith = "jsmith";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moments);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ProfileTask profileTask = new ProfileTask();
        profileTask.execute(jsmith);
    }

    private static class ProfileTask extends AsyncTask<String, Void, Void>{

        @Override
        protected Void doInBackground(String... params) {
            return null;
        }
    }
}