package me.pratama.examplematerial.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import me.pratama.examplematerial.R;
import me.pratama.examplematerial.model.Singer;

/**
 * Created by pratama on 12/24/14.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private Context context;
    private List<Singer> singerList;

    public RecyclerAdapter(Context context, List<Singer> singerList) {
        this.context = context;
        this.singerList = singerList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.thumbnail.setImageResource(singerList.get(i).getThumb());
        viewHolder.title.setText(singerList.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return singerList.size();
    }

    public static final class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.thumbnail)
        ImageView thumbnail;
        @InjectView(R.id.title)
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }
}
