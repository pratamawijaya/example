package me.pratama.examplelayoutforandroiddev;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.view.CardGridView;
import me.pratama.examplelayoutforandroiddev.entity.Soal;


public class MainActivity extends Activity {

    private CardGridView grid;

    private List<Soal> listSoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grid = (CardGridView) findViewById(R.id.grid);

        //generate data soal
        loadSoal();

        initCard(listSoal);
    }

    private void initCard(List<Soal> listSoal) {
        List<Card> listCard = new ArrayList<Card>();
        for (Soal soal : listSoal)
            listCard.add(new CardNumberSoal(this, soal));

        CardArrayAdapter adapter = new CardArrayAdapter(this, listCard);
        grid.setAdapter(adapter);
    }

    private void loadSoal() {
        listSoal = new ArrayList<Soal>();
        listSoal.add(new Soal("1", R.drawable.cat1));
        listSoal.add(new Soal("2", R.drawable.cat2));
        listSoal.add(new Soal("3", R.drawable.cat3));
        listSoal.add(new Soal("4", R.drawable.cat4));
        listSoal.add(new Soal("5", R.drawable.cat5));
        listSoal.add(new Soal("6", R.drawable.cat6));
        listSoal.add(new Soal("7", R.drawable.cat7));
        listSoal.add(new Soal("8", R.drawable.cat8));
        listSoal.add(new Soal("9", R.drawable.cat9));
        listSoal.add(new Soal("10", R.drawable.cat10));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private class CardNumberSoal extends Card {
        private Soal soal;

        private CardNumberSoal(Context context, Soal soal) {
            super(context, R.layout.card_kategori_soal);
            this.soal = soal;
            init();
        }


        @Override
        public void setupInnerViewElements(ViewGroup parent, View view) {
            super.setupInnerViewElements(parent, view);
            TextView text = (TextView) parent.findViewById(R.id.card_text);
            text.setText(soal.getNomor());
        }

        private void init() {
            setOnClickListener(new OnCardClickListener() {
                @Override
                public void onClick(Card card, View view) {
                    startActivity(new Intent(MainActivity.this, SoalActivity.class).putExtra("img", soal.getImage()));
                }
            });
        }
    }


}
