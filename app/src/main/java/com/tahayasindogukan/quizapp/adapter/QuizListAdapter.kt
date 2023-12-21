package com.tahayasindogukan.quizapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tahayasindogukan.quizapp.databinding.EachQuizBinding
import com.tahayasindogukan.quizapp.entity.Quiz

class QuizListAdapter(var quizList: List<Quiz>) :
RecyclerView.Adapter<QuizListAdapter.QuizListViewHolder>() {

    inner class QuizListViewHolder(var view:EachQuizBinding) : RecyclerView.ViewHolder(view.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):QuizListViewHolder {
        val binding=EachQuizBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return QuizListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuizListAdapter.QuizListViewHolder, position: Int) {
        val quizPosition= quizList[position]
        val t=holder.view

        t.quizTitleList.text=quizPosition.title
        val url=quizPosition.image.toString()

        Glide.with(holder.itemView.context)
            .load(url)
            .fitCenter()
            .into(holder.view.quizImageList)
    }

    override fun getItemCount(): Int {
            return quizList.size
    }
}