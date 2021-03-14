package com.ryudith.simpleretrofitget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.ryudith.simpleretrofitget.databinding.ActivityMainBinding
import com.ryudith.simpleretrofitget.movie.Movie
import com.ryudith.simpleretrofitget.util.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var refActivity : MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        refActivity = this
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rv = binding.rvActivityMainListMovie
        val moveAdapter : MovieListAdapter = MovieListAdapter()
        rv.adapter = moveAdapter

        val movie = RetrofitHelper.getMovieRetrofit()
        lifecycleScope.launch(Dispatchers.IO) {
            val result = movie.listMovie()
            val body = result.body()

            if (result.isSuccessful && body != null) {
                Log.d("DEBUG_DATA", "response code : ${body.code}")
                Log.d("DEBUG_DATA", "response message : ${body.message}")

                for (item : Movie in body.data) {
                    Log.d("DEBUG_DATA", "Movie name : (${item.id}) ${item.name} - ${item.year}")
                }

                refActivity.runOnUiThread {
                    moveAdapter.setMovieData(body.data)
                }
            }
        }
    }
}