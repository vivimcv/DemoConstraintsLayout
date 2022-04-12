package com.example.practica2.adapter

import android.app.LauncherActivity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.practica2.databinding.ActivityListItemBinding
import com.example.practica2.model.Movies



class MoviesAdapter(context: Context, listMovies: ArrayList<Movies>): BaseAdapter() {

    private val listMovies = listMovies
    private val layoutInflater = LayoutInflater.from(context)
    override fun getCount(): Int {
        return listMovies.size
    }

    override fun getItem(p0: Int): Any {
        return listMovies[p0]
    }

    override fun getItemId(p0: Int): Long {
        return listMovies[p0].id.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        //checar
        val binding = ActivityListItemBinding.inflate(layoutInflater)
        with(binding){
            tvTitle.text = listMovies[p0].title

            when(listMovies[p0].genre){
                0->{tvGenre.text= "Comedia"}
                1->{tvGenre.text= "Romance"}
                2->{tvGenre.text= "Terror"}
                3->{tvGenre.text= "Drama"}
                4->{tvGenre.text= "Suspenso"}
                5->{tvGenre.text= "Fantasía"}
            }

            //if (listMovies[p0].genre == "0")
            //{tvGenre.text= "Comedia"}
           // tvGenre.text = listMovies[p0].genre

            //checar si es string
            tvYear.text= listMovies[p0].Year.toString()
            tvDirector.text = listMovies[p0].Director
        }

        return binding.root
    }


}