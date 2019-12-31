package ahmed.atwa.popularmovies.ui.movies

import ahmed.atwa.popularmovies.R
import ahmed.atwa.popularmovies.data.remote.model.Movie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import android.widget.ImageView


/**
 * Created by Ahmed Atwa on 10/19/18.
 */

class MovieAdapter(var mMoviesList: MutableList<Movie>, val mContext: Context) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {


    val mLayoutInflater = LayoutInflater.from(mContext);
    private lateinit var listener :callback

    override fun getItemCount(): Int {
        return mMoviesList.size
    }

    fun setListener(mCallback:callback){
        listener=mCallback
    }

    fun addItems(mList: ArrayList<Movie>) {
        clearItems()
        mMoviesList.addAll(mList)
        notifyDataSetChanged()
    }

    private fun clearItems() {
        mMoviesList.clear()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = mLayoutInflater.inflate(R.layout.item_movie_view, parent, false)
        return MovieViewHolder(view)
    }

    // stores and recycles views as they are scrolled off screen
    inner class MovieViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var myImgView: ImageView

        init {
            myImgView = itemView.findViewById(ahmed.atwa.popularmovies.R.id.movieImg) as ImageView
        }

    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val moviePoster = mMoviesList[position].poster_path
        if (moviePoster != null)
            Glide.with(mContext).load("http://image.tmdb.org/t/p/w185$moviePoster").into(holder.myImgView)
        holder.myImgView.setOnClickListener { listener.onItemClick(mMoviesList[position]) }
    }

    interface callback{
        fun onItemClick(movie: Movie)
    }

}
