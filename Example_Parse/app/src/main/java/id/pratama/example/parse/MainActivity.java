package id.pratama.example.parse;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;

import id.pratama.example.parse.entity.Book;


public class MainActivity extends ActionBarActivity {

    private List<ParseObject> listBook;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");

        ParseQuery<Book> query = ParseQuery.getQuery(Book.class);
        query.findInBackground(new FindCallback<Book>() {
            @Override
            public void done(List<Book> books, ParseException e) {
                for (Book b : books){
                    String tes = b.getJudul();
                    Log.d("tag",""+tes);
                }

            }
        });

        listBook = new ArrayList<ParseObject>();
//        listBook.add(new Toko("Gramedia Lampung","Jl. Jenderal Sudirman"));
//        listBook.add(new Toko("Gramedia Jakarta","Jl. Malioboro"));


        progressDialog.show();
        // saving in background
        ParseObject.saveAllInBackground(listBook, new SaveCallback() {
            @Override
            public void done(ParseException e) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Finish", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
