package com.example.android.popularmovies;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.android.popularmovies.databinding.ActivityMovieDetailBinding;
import com.example.android.popularmovies.model.Movies;
import com.squareup.picasso.Picasso;

public class MovieDetailActivity extends AppCompatActivity
{

    private ActivityMovieDetailBinding movieDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        movieDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail);

        ActionBar actionBar = this.getSupportActionBar();

        // Set the action bar back button to look like an up button
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        Movies movies = getIntent().getParcelableExtra("movies");

        if(movies!=null)
        {
            movieDetailBinding.originalTitleTv.setText(movies.getOriginalTitle());
            movieDetailBinding.voteAverageTv.setText(movies.getVoteAverage());
            movieDetailBinding.releaseDateTv.setText(movies.getReleaseDate());
            movieDetailBinding.overviewTv.setText(movies.getOverview());

            Picasso.get()
                    .load(movies.getBackdropPath())
                    .into(movieDetailBinding.imageIv);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == android.R.id.home)
        {
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }

}
