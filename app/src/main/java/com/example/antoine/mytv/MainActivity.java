package com.example.antoine.mytv;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.antoine.mytv.apitv7j.TV7JAPI;
import com.example.antoine.mytv.jsonpojo7.ADiffusion;
import com.example.antoine.mytv.jsonpojo7.UnRV;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {


    private UnRV[] lrv=new UnRV[11];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Data
        TV7JAPI tvapi = new TV7JAPI();

        lrv[0]=new UnRV(this,(RecyclerView) findViewById(R.id.recycler_view_ARTE),
                tvapi,TV7JAPI.ARTE);
        lrv[1]=new UnRV(this,(RecyclerView) findViewById(R.id.recycler_view_CPLUS),
                tvapi,TV7JAPI.CPLUS);
        lrv[2]=new UnRV(this,(RecyclerView) findViewById(R.id.recycler_view_CDECALE),
                tvapi,TV7JAPI.CDECALE);
        lrv[3]=new UnRV(this,(RecyclerView) findViewById(R.id.recycler_view_CCINEMA),
                tvapi,TV7JAPI.CCINEMA);
        lrv[4]=new UnRV(this,(RecyclerView) findViewById(R.id.recycler_view_CSERIE),
                tvapi,TV7JAPI.CSERIE);
        lrv[5]=new UnRV(this,(RecyclerView) findViewById(R.id.recycler_view_CFAMILY),
                tvapi,TV7JAPI.CFAMILY);
        lrv[6]=new UnRV(this,(RecyclerView) findViewById(R.id.recycler_view_CSPORT),
                tvapi,TV7JAPI.CSPORT);
        lrv[7]=new UnRV(this,(RecyclerView) findViewById(R.id.recycler_view_OCSMAX),
                tvapi,TV7JAPI.OCSMAX);
        lrv[8]=new UnRV(this,(RecyclerView) findViewById(R.id.recycler_view_OCSCHOC),
                tvapi,TV7JAPI.OCSCHOC);
        lrv[9]=new UnRV(this,(RecyclerView) findViewById(R.id.recycler_view_OCSCITY),
                tvapi,TV7JAPI.OCSCITY);
        lrv[10]=new UnRV(this,(RecyclerView) findViewById(R.id.recycler_view_SUNDANCE),
                tvapi,TV7JAPI.SUNDANCE);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            //Decalage de tous les programmes
            for(int i=0;i<lrv.length;i++) {
                //recherche le prime
                int positionPrime=0;
                for(int k=0; k<lrv[i].getMovieList().size();k++) {
                    if(lrv[i].getMovieList().get(k).getPrimetime()==1)
                        positionPrime=k;
                }
                if(positionPrime>0) lrv[i].decalage(positionPrime);
            }

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEventGrille event) {
        List<ADiffusion> movieList=null;
        MoviesAdapter mAdapterTmp=null;

        // Recherche le bon
        int position=-1;
        for(int i=0;i<lrv.length;i++) {
            if (lrv[i].isChaineName(event.getChaine())) {
                position =i;
            }
        }
        if(position!=-1) {
            movieList=lrv[position].getMovieList();
            mAdapterTmp=lrv[position].getMAdapter();
            for(int i=0; i<event.getListTitle().size();i++) {
                movieList.add(event.getListTitle().get(i));
            }
            mAdapterTmp.notifyDataSetChanged();
        }

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEventErreur event) {

    }

    public void clicProgramme(final ADiffusion movie, int imageOrWeb) {
        //Toast.makeText(getApplicationContext(), "OK "+TV7JAPI.ENTETE_TV7+movie.getUrlDiff(), Toast.LENGTH_SHORT).show();
        //Log.i("TTT ",TV7JAPI.ENTETE_TV7+movie.getUrlDiff());
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialogbox);
        //dialog.setTitle("Programme");


        // set the custom dialog components - text, image and button
        TextView text = (TextView) dialog.findViewById(R.id.titredialogbox);
        text.setText(movie.getTitre());

        WebView webview = (WebView) dialog.findViewById(R.id.webview);
        webview.setVisibility(View.INVISIBLE);
        final ImageView image = (ImageView) dialog.findViewById(R.id.imagedialogbox);
        image.setVisibility(View.VISIBLE);
        Picasso.with(getApplicationContext()).load(movie.getPhoto()).into(image);
        final String url = movie.getUrlDiff();
        final String titre = movie.getTitre();

        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonClose);
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        ImageButton buttonimdb = (ImageButton) dialog.findViewById(R.id.buttonimdb);
        buttonimdb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView image = (ImageView) dialog.findViewById(R.id.imagedialogbox);
                image.setVisibility(View.INVISIBLE);
                WebView webview = (WebView) dialog.findViewById(R.id.webview);
                webview.setVisibility(View.VISIBLE);
                webview.setWebViewClient(new WebViewClient());
                webview.getSettings().setJavaScriptEnabled(true);
                webview.loadUrl(TV7JAPI.ENTETE_IMDB+titre);
            }
        });

        ImageButton buttont7j = (ImageButton) dialog.findViewById(R.id.buttont7j);
        buttont7j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView image = (ImageView) dialog.findViewById(R.id.imagedialogbox);
                image.setVisibility(View.INVISIBLE);
                WebView webview = (WebView) dialog.findViewById(R.id.webview);
                webview.setVisibility(View.VISIBLE);
                webview.setWebViewClient(new WebViewClient());
                webview.getSettings().setJavaScriptEnabled(true);
                webview.loadUrl(TV7JAPI.ENTETE_TV7+url);
            }
        });

        ImageButton buttontelerama = (ImageButton) dialog.findViewById(R.id.buttontelerama);
        buttontelerama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView image = (ImageView) dialog.findViewById(R.id.imagedialogbox);
                image.setVisibility(View.INVISIBLE);
                WebView webview = (WebView) dialog.findViewById(R.id.webview);
                webview.setVisibility(View.VISIBLE);
                webview.setWebViewClient(new WebViewClient());
                webview.getSettings().setJavaScriptEnabled(true);
                webview.loadUrl(TV7JAPI.ENTETE_TELERAMA+titre);
            }
        });


        dialog.show();

    }

}
