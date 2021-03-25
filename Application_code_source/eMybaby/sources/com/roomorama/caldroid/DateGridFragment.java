package com.roomorama.caldroid;

import a.b.e;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import androidx.fragment.app.Fragment;

public class DateGridFragment extends Fragment {
    public CaldroidGridAdapter gridAdapter;
    public GridView gridView;
    public AdapterView.OnItemClickListener onItemClickListener;
    public AdapterView.OnItemLongClickListener onItemLongClickListener;

    public CaldroidGridAdapter getGridAdapter() {
        return this.gridAdapter;
    }

    public GridView getGridView() {
        return this.gridView;
    }

    public AdapterView.OnItemClickListener getOnItemClickListener() {
        return this.onItemClickListener;
    }

    public AdapterView.OnItemLongClickListener getOnItemLongClickListener() {
        return this.onItemLongClickListener;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        GridView gridView2 = (GridView) layoutInflater.inflate(e.date_grid_fragment, viewGroup, false);
        this.gridView = gridView2;
        CaldroidGridAdapter caldroidGridAdapter = this.gridAdapter;
        if (caldroidGridAdapter != null) {
            gridView2.setAdapter(caldroidGridAdapter);
        }
        AdapterView.OnItemClickListener onItemClickListener2 = this.onItemClickListener;
        if (onItemClickListener2 != null) {
            this.gridView.setOnItemClickListener(onItemClickListener2);
        }
        AdapterView.OnItemLongClickListener onItemLongClickListener2 = this.onItemLongClickListener;
        if (onItemLongClickListener2 != null) {
            this.gridView.setOnItemLongClickListener(onItemLongClickListener2);
        }
        return this.gridView;
    }

    public void setGridAdapter(CaldroidGridAdapter caldroidGridAdapter) {
        this.gridAdapter = caldroidGridAdapter;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener2) {
        this.onItemClickListener = onItemClickListener2;
    }

    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener2) {
        this.onItemLongClickListener = onItemLongClickListener2;
    }
}
