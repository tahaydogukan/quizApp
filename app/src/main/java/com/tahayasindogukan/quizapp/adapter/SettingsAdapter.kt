package com.tahayasindogukan.quizapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.DocumentSnapshot
import com.tahayasindogukan.quizapp.databinding.SettingsCardViewBinding

class SettingsAdapter(var userList: List<DocumentSnapshot>) :
    RecyclerView.Adapter<SettingsAdapter.SettingsViewHolder>() {


    inner class SettingsViewHolder(var view: SettingsCardViewBinding) :
        RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingsViewHolder {
        val binding =
            SettingsCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SettingsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    //holder sayesinde card tasarımına ulaşıyoruz
    override fun onBindViewHolder(holder: SettingsViewHolder, position: Int) {
        val t = holder.view
        val document = userList[position]
        // DocumentSnapshot'ten verileri view'lara bağlayın
        t.rwName.text = document.get("name") as String
        var a = document.get("score") as Long
        t.rwScore.text = "${a}"
        t.rwSiraNumarasi.text = "${position + 1}"


    }

}