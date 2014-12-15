package com.pratamawijaya.examplepallete.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pratamawijaya.examplepallete.R;
import com.pratamawijaya.examplepallete.model.CoverItem;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by pratama on 12/11/14.
 */
public class CoverAdapter extends RecyclerView.Adapter<CoverAdapter.CoverHolder> {
    private Context context;
    private List<CoverItem> coverItems;

    public CoverAdapter(Context context, List<CoverItem> coverItems) {
        this.context = context;
        this.coverItems = coverItems;
    }

    @Override
    public CoverHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cover, parent, false);
        return new CoverHolder(view);
    }

    @Override
    public void onBindViewHolder(final CoverHolder holder, int position) {

        holder.thumb.setImageResource(coverItems.get(position).getThumbnail());
        holder.title.setText(coverItems.get(position).getTilte());

        Palette.generateAsync(BitmapFactory.decodeResource(context.getResources(), coverItems.get(position).getThumbnail()), new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch vibrantSwatch = palette.getVibrantSwatch();
                Log.d("tag", "test ->body " + vibrantSwatch.getBodyTextColor() + ",title" + vibrantSwatch.getTitleTextColor());
                holder.containerText.setBackgroundColor(vibrantSwatch.getTitleTextColor());
            }
        });
    }

    @Override
    public int getItemCount() {
        return coverItems.size();
    }

    public static class CoverHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.thumbnail)
        ImageView thumb;
        @InjectView(R.id.title)
        TextView title;
        @InjectView(R.id.containerText)
        LinearLayout containerText;

        public CoverHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }
}
