package com.gamatechno.exampleglidevspicasso.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gamatechno.exampleglidevspicasso.MainActivity;
import com.gamatechno.exampleglidevspicasso.R;
import com.gamatechno.exampleglidevspicasso.model.ImageModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by pratama on 3/28/15.
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private Context context;
    private List<ImageModel> imageModelList;
    private int status;

    public ImageAdapter(Context context, List<ImageModel> imageModelList, int useLib) {
        this.context = context;
        this.imageModelList = imageModelList;
        status = useLib;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.image_text, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(imageModelList.get(position).getTitle());
        if (status == MainActivity.GLIDE) {
            Glide.with(context)
                    .load(imageModelList.get(position).getImgUrl())
                    .into(holder.mImageView);
        } else {
            Picasso.with(context)
                    .load(imageModelList.get(position).getImgUrl())
                    .into(holder.mImageView);
        }
    }

    @Override
    public int getItemCount() {
        return imageModelList.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        @InjectView(R.id.textImg)
        TextView mTextView;
        @InjectView(R.id.img)
        ImageView mImageView;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.inject(this, v);
        }
    }
}
