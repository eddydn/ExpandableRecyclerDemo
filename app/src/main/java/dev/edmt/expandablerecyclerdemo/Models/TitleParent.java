package dev.edmt.expandablerecyclerdemo.Models;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.List;
import java.util.UUID;

/**
 * Created by reale on 23/11/2016.
 */

public class TitleParent implements ParentObject{

    private List<Object> mChildrenList;
    private UUID _id;
    private String title;

    public TitleParent(String title) {
        this.title = title;
        _id = UUID.randomUUID();
    }

    public UUID get_id() {
        return _id;
    }

    public void set_id(UUID _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public List<Object> getChildObjectList() {
        return mChildrenList;
    }

    @Override
    public void setChildObjectList(List<Object> list) {
            mChildrenList = list;
    }
}
