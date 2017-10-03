package marrit.marritleenstra_pset3_2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.UUID;

import static android.content.ContentValues.TAG;

public class ListenListActivity extends AppCompatActivity {

    // declare variables
    private ArrayList<String> mSongs = new ArrayList<String>();

    // declare views
    TextView mTextViewResult;
    ListView mListViewSongsList;

    // add static strings for key-value pairs
    public static final String EXTRA_SONG_ID = "marrit.marritleenstra_pset31.SongId";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen_list);

        // get Songs
        //populate list for testing purposes
        for (int i = 0; i < 10; i++) {
            String title = "title #"+i;
            String artist = "artist #"+i;
            mSongs.add(title + " , " + artist);
        }

        makeArrayAdapter();

    }


    public void makeArrayAdapter() {
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, mSongs);
        mListViewSongsList = (ListView) findViewById(R.id.listview_ListenList);
        assert mListViewSongsList != null;
        mListViewSongsList.setAdapter(arrayAdapter);
    }

    /*public static Intent newIntent(Context packageContext, UUID mId) {
        Intent intent = new Intent(packageContext, SongActivity.class);
        intent.putExtra(EXTRA_SONG_ID, mId);
        return intent;
    }*/

    // inflate menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_listen_list, menu);
        return true;
    }

    // handle clicks on menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.add_song:

                // go to SearchActivity to add the song the user wants
                Intent intent = new Intent(this, SearchActivity.class);
                this.startActivity(intent);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}



