package com.ryudith.simpleretrofitget

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ryudith.simpleretrofitget.movie.Movie

class MovieListAdapter : RecyclerView.Adapter<MovieListAdapter.MovieItem>() {
    class MovieItem(itemView: View) : RecyclerView.ViewHolder(itemView)
    private var moviesData : List<Movie> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItem {
        return MovieItem(LayoutInflater.from(parent.context).inflate(R.layout.layout_movie_item, parent, false))
    }

    override fun onBindViewHolder(holder: MovieItem, position: Int) {
        val currentItem = moviesData[position]

        holder.itemView.findViewById<TextView>(R.id.tv_rvActivityMain_movieName).text = currentItem.name
        holder.itemView.findViewById<TextView>(R.id.tv_rvActivityMain_movieYear).text = "Year : ${currentItem.year}"
    }

    override fun getItemCount(): Int {
        return moviesData.size
    }

    fun setMovieData (listMovie : List<Movie>) {
        moviesData = listMovie
        notifyDataSetChanged()
    }
}