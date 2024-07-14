package com.farhanhazmi.godzilla.model

//M Farhan Hazmi 10121081

import com.google.gson.annotations.SerializedName

data class Superhero(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("powerstats")
    val powerstats: Powerstats,
    @SerializedName("biography")
    val biography: Biography,
    @SerializedName("image")
    val image: Image
)

data class Powerstats(
    @SerializedName("intelligence") val intelligence: String?,
    @SerializedName("strength") val strength: String?,
    @SerializedName("speed") val speed: String?,
    @SerializedName("durability") val durability: String?,
    @SerializedName("power") val power: String?,
    @SerializedName("combat") val combat: String?
)

data class Biography(
    @SerializedName("full-name") val fullName: String?,
    @SerializedName("alter-egos") val alterEgos: String?,
    @SerializedName("aliases") val aliases: List<String>?,
    @SerializedName("place-of-birth") val placeOfBirth: String?,
    @SerializedName("first-appearance") val firstAppearance: String?,
    @SerializedName("publisher") val publisher: String?,
    @SerializedName("alignment") val alignment: String?
)

data class Image(
    @SerializedName("url") val url: String?
)