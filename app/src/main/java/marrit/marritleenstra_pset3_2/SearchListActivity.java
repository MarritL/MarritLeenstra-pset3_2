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
    // declare vies
    TextView mTextViewResult;
    ListView mListViewItems;

    // declare variables
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
