package com.example.settlelahwaisiong;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;

import java.util.List;

public class maintenance_services extends AppCompatActivity {

    private static final String TAG = "mytag";
    private List<CityDataItem2> mDataList;
    private RecyclerView mRecyclerView;
    private com.example.settlelahwaisiong.MyDataAdapter2 mDataAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance_services);
        this.setTitle("Maintenance Services");
        mDataList = SampleDataProvider2.cityDataItemList;
        mRecyclerView = findViewById(R.id.list_city);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);

        mDataAdapter= new com.example.settlelahwaisiong.MyDataAdapter2(mDataList, this);
        mRecyclerView.setAdapter(mDataAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.app_bar_menu2,menu);

        MenuItem searchItem=menu.findItem(R.id.search_view);
        SearchView searchView= (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mDataAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return true;
    }
}
