package dev.edmt.expandablerecyclerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.ArrayList;
import java.util.List;

import dev.edmt.expandablerecyclerdemo.Adapter.MyAdapter;
import dev.edmt.expandablerecyclerdemo.Models.TitleChild;
import dev.edmt.expandablerecyclerdemo.Models.TitleCreator;
import dev.edmt.expandablerecyclerdemo.Models.TitleParent;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ((MyAdapter)recyclerView.getAdapter()).onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.myRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyAdapter adapter = new MyAdapter(this,initData());
        adapter.setParentClickableViewAnimationDefaultDuration();
        adapter.setParentAndIconExpandOnClick(true);

        recyclerView.setAdapter(adapter);
    }

    private List<ParentObject> initData() {
        TitleCreator titleCreator = TitleCreator.get(this);
        List<TitleParent> titles = titleCreator.getAll();
        List<ParentObject> parentObject = new ArrayList<>();
        for(TitleParent title:titles)
        {
            List<Object> childList = new ArrayList<>();
            childList.add(new TitleChild("Add to contacts","Send message"));
            title.setChildObjectList(childList);
            parentObject.add(title);
        }
        return parentObject;

    }
}
