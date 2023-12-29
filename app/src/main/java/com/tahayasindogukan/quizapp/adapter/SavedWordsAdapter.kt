package com.tahayasindogukan.quizapp.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tahayasindogukan.quizapp.databinding.SavedWordsCardviewBinding
import com.tahayasindogukan.quizapp.entity.SavedWords

class SavedWordsAdapter(var savedWordsList:List<SavedWords>,
                        var wordInterface: WordInterface  ):
RecyclerView.Adapter<SavedWordsAdapter.SavedWordsViewHolder>() {


    inner class SavedWordsViewHolder(var view:SavedWordsCardviewBinding) : RecyclerView.ViewHolder(view.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedWordsViewHolder {
        val binding=SavedWordsCardviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SavedWordsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return savedWordsList.size
    }
    //holder sayesinde card tasarımına ulaşıyoruz
    override fun onBindViewHolder(holder: SavedWordsViewHolder, position: Int) {
        val savedWords= savedWordsList[position]
        val t=holder.view
        t.savedWordsEnglish.text = savedWords.english_word
        t.savedWordsTurkish.text = savedWords.turkish_word
        t.savedWordsIndeks.text= (position+1).toString()
        t.savedWordsDelete.setOnClickListener{
            wordInterface.delete(position)
        }

    }

    fun setData(word:List<SavedWords>){
        this.savedWordsList = word
        notifyDataSetChanged()
    }

    fun deleteWord(word:SavedWords){

    }
}