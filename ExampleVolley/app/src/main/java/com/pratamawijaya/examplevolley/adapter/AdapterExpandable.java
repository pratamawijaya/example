package com.pratamawijaya.examplevolley.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.pratamawijaya.examplevolley.R;
import com.pratamawijaya.examplevolley.model.ExpandableModel;

import java.util.List;

/**
 * Created by pratama on 3/6/15.
 */
public class AdapterExpandable extends BaseExpandableListAdapter {
    private Context context;
    private List<ExpandableModel> expandableModels;


    public AdapterExpandable(Context context, List<ExpandableModel> expandableModels) {
        this.context = context;
        this.expandableModels = expandableModels;
    }

    @Override
    public int getGroupCount() {
        return expandableModels.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return expandableModels.get(groupPosition).getChildText().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return expandableModels.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return expandableModels.get(groupPosition).getChildText().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_group, parent, false);

        TextView header = (TextView) v.findViewById(R.id.txtGroup);
        header.setText(expandableModels.get(groupPosition).getGroupText());
        return v;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_child, parent, false);

        TextView child = (TextView) v.findViewById(R.id.txtChild);

        child.setText(expandableModels.get(groupPosition).getChildText().get(childPosition));

        return v;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
