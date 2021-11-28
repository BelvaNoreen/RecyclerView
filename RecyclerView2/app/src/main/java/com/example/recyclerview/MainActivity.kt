package com.example.recyclerview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val superheroList = listOf<Superhero>(
            Superhero(
                R.drawable.aku1,
                "TikTok : @gruxeonz",
                "Jangan Lupa Follow ya ges ya"
            ),
            Superhero(
                R.drawable.aku2,
                "TikTok : @gruxeonz",
                "Kontennya Keren Keren Kok!"
            ),
            Superhero(
                R.drawable.aku3,
                "TikTok : @gruxeonz",
                "Kontennya juga Macem Macem Kok Tenang aja"
            ),
            Superhero(
                R.drawable.aku4,
                "TikTok : @gruxeonz",
                "Jadi Kalian Gabakal Bosen"
            )
        )
        val recyclerView = findViewById<RecyclerView>(R.id.rv_hero)
        recyclerView.layoutManager = LinearLayoutManager( this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = SuperheroAdapter( this,superheroList){
            val intent = Intent (this, DetailSuperheroActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)

        }
    }
}