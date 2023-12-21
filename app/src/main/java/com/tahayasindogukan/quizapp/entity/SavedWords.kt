package com.tahayasindogukan.quizapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName ="words")
class SavedWords(@PrimaryKey(autoGenerate = true)
                 @ColumnInfo(name = "word_id")@NotNull val words_id:Int,
                 @ColumnInfo(name = "turkish_word")@NotNull val turkish_word:String,
                 @ColumnInfo(name = "english_word")@NotNull val english_word:String):Serializable {
}