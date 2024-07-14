package com.farhanhazmi.godzilla

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.ImageView
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.farhanhazmi.godzilla.model.Superhero
import com.farhanhazmi.godzilla.network.RetrofitInstance

//M Farhan Hazmi 10121081


class MainActivity : AppCompatActivity() {

    private lateinit var superheroImage: ImageView
    private lateinit var superheroName: TextView
    private lateinit var superheropower: TextView
    private lateinit var superheroBiography: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        superheroImage = findViewById(R.id.superheroImage)
        superheroName = findViewById(R.id.superheroName)
        superheropower = findViewById(R.id.Powerstats)
        superheroBiography = findViewById(R.id.Biography)
        fetchSuperheroData()

    }

    private fun fetchSuperheroData() {
        RetrofitInstance.api.getSuperhero().enqueue(object : Callback<Superhero> {
            override fun onFailure(call: Call<Superhero>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<Superhero>, response: Response<Superhero>) {
                if (response.isSuccessful) {
                    response.body()?.let { superhero ->
                        val imageUrl = superhero.image.url
                        val name = superhero.name

                        val powerstats = superhero.powerstats
                        val intelligence = powerstats.intelligence
                        val strength = powerstats.strength
                        val speed = powerstats.speed
                        val durability = powerstats.durability
                        val power = powerstats.power
                        val combat = powerstats.combat

                        val biography = superhero.biography
                        val fullname = biography.fullName
                        val aliases = biography.aliases?.joinToString(", ")
                        val birth = biography.placeOfBirth
                        val firtAppearance = biography.firstAppearance
                        val publisher = biography.publisher
                        val aligment = biography.alignment


                        val dbiography = """
                            Full Nama : $fullname
                            Alias : $aliases
                            Birth : $birth
                            First Apperance : $firtAppearance
                            Publisher : $publisher
                            Aligment : $aligment
                        """.trimIndent()

                        val dpower = """
                            Intelligence : $intelligence
                            Strength : $strength
                            Speed : $speed
                            Durability : $durability
                            Power : $power
                            Combat : $combat
                            
                        """.trimIndent()



                        Glide.with(this@MainActivity).load(imageUrl).into(superheroImage)
                        superheroName.text = name
                        superheroBiography.text = dbiography
                        superheropower.text = dpower
                    }
                }
            }
        })
    }
}