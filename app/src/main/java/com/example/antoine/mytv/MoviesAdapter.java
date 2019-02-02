package com.example.antoine.mytv;

/**
 * Created by Antoine on 02/12/2017.
 */
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.antoine.mytv.apitv7j.TV7JAPI;
import com.example.antoine.mytv.jsonpojo7.ADiffusion;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<ADiffusion> moviesList;
    private int numChaine;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView titre, heure, nature,tmp,chaine;
        public ImageView photo;

        public MyViewHolder(View view) {
            super(view);
            titre = (TextView) view.findViewById(R.id.title);
            nature = (TextView) view.findViewById(R.id.genre);
            heure = (TextView) view.findViewById(R.id.year);
            photo =(ImageView) view.findViewById(R.id.thumbnail);
            tmp = (TextView) view.findViewById(R.id.tmp);
            chaine = (TextView) view.findViewById(R.id.chaine);
        }
    }


    public MoviesAdapter(List<ADiffusion> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ADiffusion movie = moviesList.get(position);
        holder.titre.setText(movie.getTitre());
        holder.nature.setText(movie.getNature());
        holder.heure.setText(movie.getHeureDif());
        //holder.tmp.setText(movie.getUrlDiff());
        holder.chaine.setText(TV7JAPI.getNomChaine(numChaine));

        Picasso.with(holder.photo.getContext()).load(movie.getPhoto()).into(holder.photo);
        //new DownloadImageTask(holder.photo).execute("http://java.sogeti.nl/JavaBlog/wp-content/uploads/2009/04/android_icon_256.png");
        //holder.photo.setImageURI(Uri.parse(movie.getPhoto()));
        //Log.i("Chaine",movie.toString());
        /*holder.photo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i("Click","hello");

            }
        });
*/
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }


    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

    public void setNumChaine(int numChaine) {
        this.numChaine = numChaine;
    }

    public int getNumChaine() {
        return numChaine;
    }
}