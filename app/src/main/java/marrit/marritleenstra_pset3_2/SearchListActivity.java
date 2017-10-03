package marrit.marritleenstra_pset3_2;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SearchListActivity extends AppCompatActivity {
    TextView mTextViewResult;
    ListView mListViewItems;

    ArrayList<String> songsFound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list);

        mTextViewResult = (TextView) findViewById(R.id.tvFound);
        mListViewItems = (ListView) findViewById(R.id.listview_id);

        Bundle extras = getIntent().getExtras();
        songsFound = (ArrayList<String>) extras.getSerializable("data");

        makeTrackAdapter();
    }

    public void makeTrackAdapter() {
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, songsFound);
        mListViewItems = (ListView) findViewById(R.id.listview_id);
        assert mListViewItems != null;
        mListViewItems.setAdapter(arrayAdapter);
    }

}
    /*// declare variables
    private ArrayList<String> mSearchedSongs = new ArrayList<String>();
    private SongSearchAdapter mSongSearchAdapter;

    // add static strings for key-value pairs
    public static final String EXTRA_SONG_ID = "marrit.marritleenstra_pset31.SongId";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list);


        mSearchedSongs = new ArrayList<String>();

        Bundle extras = getIntent().getExtras();
        mSearchedSongs = (ArrayList<String>) extras.getSerializable("data");

        //populate list for testing purposes
        *//*for (int i = 0; i < 10; i++) {
            Song song = new Song();
            song.setTitle("Song #" + i);
            song.setArtist("Artist #" + i);
            mSearchedSongs.add(song);
        }*//*

        // instantiate the SongAdapter class
        mSongSearchAdapter = new SongSearchAdapter(this, R.layout.searched_list_item, mSearchedSongs);
        setListAdapter(mSongSearchAdapter);

        ListView lv = getListView();
    }

}

*/