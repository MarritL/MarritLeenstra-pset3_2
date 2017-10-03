package marrit.marritleenstra_pset3_2;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Marrit on 3-10-2017.
 */

public class TrackAsyncTask extends AsyncTask<String, Integer, String> {
    private Context mContext;
    private SearchActivity mSearchActivity;

    public TrackAsyncTask(SearchActivity act) {
        this.mSearchActivity = act;
        this.mContext = this.mSearchActivity.getApplicationContext();
    }

    // do before executing the AsyncTask
    @Override
    protected void onPreExecute() {
        Toast.makeText(mContext, "Searching...", Toast.LENGTH_SHORT).show();
    }

    // the AsyncTask = search in last.fm database
    @Override
    protected String doInBackground(String... params) {
        return HttpRequestHelper.downloadFromServer(params);
    }

    // return the result
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        ArrayList<String> mSongsList = new ArrayList<>();

        try {
            JSONObject trackStreamobj = new JSONObject(result);
            JSONObject resultsObj = trackStreamobj.getJSONObject("results");
            JSONObject trackmatchesObj = resultsObj.getJSONObject("trackmatches");
            JSONArray trackObj = trackmatchesObj.getJSONArray("track");
            for (int i = 0; i < trackObj.length(); i++) {
                JSONObject track = trackObj.getJSONObject(i);
                String title = track.getString("name");
                String artist = track.getString("artist");
                mSongsList.add(title + " , " + artist);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        // als je de gevonden data hebt naar volgende activiteit
        this.mSearchActivity.trackStartIntent(mSongsList);
    }

}
