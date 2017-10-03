package marrit.marritleenstra_pset3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    EditText mSearchArtist;
    EditText mSearchTrack;

    Button mSearchArtistButton;
    Button mSearchTrackButton;

    private static final String TAG = "ERRORTAG";

    @Override
    protected void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Log.i(TAG,"created searchActivity");

        //initialise EditText fields
        mSearchArtist = (EditText) findViewById(R.id.search_artist);
        assert mSearchArtist != null;
        mSearchTrack = (EditText) findViewById(R.id.search_track);
        assert mSearchArtist != null;

        //initialise buttons
        mSearchArtistButton = (Button) findViewById(R.id.button_search_artist);
        mSearchTrackButton = (Button) findViewById(R.id.button_search_track);

        //handle click
        mSearchTrackButton.setOnClickListener(new onButtonClickListener());

    }

    public void trackSearch(View view) {
        String trackSearch = mSearchTrack.getText().toString();
        TrackAsyncTask asyncTask = new TrackAsyncTask(this);
        Log.d(TAG, "calling asyncTask.execute()");
        asyncTask.execute(trackSearch);
        Log.d(TAG, "after asyncTask.execute(trackSearch)");

        mSearchTrack.getText().clear();
    }

    public void trackStartIntent(ArrayList<String> songs) {
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra("data", songs);
        this.startActivity(intent);
    }

    private class onButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            if (view == mSearchTrackButton) {
                trackSearch(view);
                Log.d(TAG,"after trackSearch(View)");
            }
            else {

            }
        }

    }
}