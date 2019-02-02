package com.example.antoine.mytv.jsonpojo7;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.antoine.mytv.MainActivity;
import com.example.antoine.mytv.MoviesAdapter;
import com.example.antoine.mytv.R;
import com.example.antoine.mytv.RecyclerTouchListener;
import com.example.antoine.mytv.apitv7j.TV7JAPI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Antoine on 02/12/2017.
 */

public class UnRV {

    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<ADiffusion> movieList = new ArrayList<>();
    private int chaine;
    private MainActivity mainActivity;

    public UnRV(final MainActivity mainActivity, RecyclerView recyclerView,
                TV7JAPI tvapi, int chaine) {

        Date d = new Date();
        this.chaine = chaine;
        this.mainActivity=mainActivity;
        mAdapter = new MoviesAdapter(movieList);
        mLayoutManager = new LinearLayoutManager(mainActivity.getApplicationContext(),LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(mainActivity, LinearLayoutManager.VERTICAL));
        recyclerView.addItemDecoration(new DividerItemDecoration(mainActivity, LinearLayoutManager.HORIZONTAL));

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(mainActivity.getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
               ADiffusion movie = movieList.get(position);
                mainActivity.clicProgramme(movie,1);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        recyclerView.setAdapter(mAdapter);
        mAdapter.setNumChaine(chaine);
        tvapi.pgChaine(chaine,d,TV7JAPI.soir);


    }




    public List<ADiffusion> getMovieList() {
        return movieList;
    }

    public MoviesAdapter getMAdapter() {
        return mAdapter;
    }

    public boolean isChaineName(String nom) {
        return TV7JAPI.getNomChaine(chaine).equals(nom);
    }

    public void decalage(int position) {
        RecyclerView.SmoothScroller smoothScroller = new
                LinearSmoothScroller(mainActivity.getApplicationContext()) {
                    @Override protected int getHorizontalSnapPreference() {
                        return LinearSmoothScroller.SNAP_TO_START;
                    }
                };
        smoothScroller.setTargetPosition(position);
        mLayoutManager.startSmoothScroll(smoothScroller);

    }

}
