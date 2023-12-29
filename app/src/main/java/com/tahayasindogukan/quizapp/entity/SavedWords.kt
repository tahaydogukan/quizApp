package com.tahayasindogukan.quizapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
@Entity(tableName = "savedWords")
data class SavedWords(@PrimaryKey(autoGenerate = true)
                      var word_id:Int = 0,
                      var english_word:String,
                      var turkish_word:String):Serializable {
}