package com.gamatechno.exampleglidevspicasso;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gamatechno.exampleglidevspicasso.adapter.ImageAdapter;
import com.gamatechno.exampleglidevspicasso.model.ImageModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class GlideActivity extends ActionBarActivity {

    @InjectView(R.id.recylerView)
    RecyclerView recyclerView;

    private ImageAdapter adapter;

    private List<ImageModel> imageModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        imageModelList = new ArrayList<>();
//        imageModelList.add(new ImageModel("Cita 1","http://images.jurnalasia.com/2015/02/cita.jpg"));
//        imageModelList.add(new ImageModel("Cita 2","https://yt3.ggpht.com/-0d4FFGugV8E/AAAAAAAAAAI/AAAAAAAAAAA/5V46vbtqiuk/s900-c-k-no/photo.jpg"));
//        imageModelList.add(new ImageModel("Cita 3","http://cdn-media.viva.id/images/2014/12/26/286968_cita-citata.jpg"));
//        imageModelList.add(new ImageModel("Cita 1","http://2.bp.blogspot.com/-DEtk1Pqs_xI/VEusvBqOyRI/AAAAAAAAAls/q1sub6aR2NM/s1600/Cita%2BCitata%2B(8).jpg"));
//        imageModelList.add(new ImageModel("Ayu 1","http://cdn.klimg.com/kapanlagi.com/p/ayu_ting_ting_33.jpg"));
//        imageModelList.add(new ImageModel("Ayu 1","http://sumutpos.co/wp-content/uploads/2015/03/Ayu-Ting-Ting.jpg"));
//        imageModelList.add(new ImageModel("Wulan 1","http://i272.photobucket.com/albums/jj166/darmarus/my%20goodies/faveindofemalecelebs/wulan01.jpg"));

        for (int i = 1; i <= 10; i++) {
            imageModelList.add(new ImageModel("image " + i, "http://lorempixel.com/500/500/sports/"+i));
        }

        adapter = new ImageAdapter(this, imageModelList, MainActivity.GLIDE);
        recyclerView.setAdapter(adapter);
    }

}
