package com.simplemobiletools.calendar.pro.views.lessons

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.simplemobiletools.calendar.pro.R
import com.simplemobiletools.calendar.pro.databinding.LessonRvItemBinding
import com.simplemobiletools.calendar.pro.model.OnlineLearningPlatform
import com.squareup.picasso.Picasso


/**
 * Created by mikaware on 16/03/21.
 */
class OnlineLearningPlatformAdapter(
    var listener: OnItemClickListener
) : ListAdapter<OnlineLearningPlatform, OnlineLearningPlatformAdapter.ItemViewHolder>(
    DiffCallback
) {

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<OnlineLearningPlatform>() {
            override fun areItemsTheSame(
                oldItem: OnlineLearningPlatform,
                newItem: OnlineLearningPlatform
            ): Boolean {
                return oldItem.olpUrl == newItem.olpUrl
            }

            override fun areContentsTheSame(
                oldItem: OnlineLearningPlatform,
                newItem: OnlineLearningPlatform
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LessonRvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val lesson = getItem(position)
        holder.bind(lesson)
        holder.itemView.setOnClickListener {
            listener.onItemClick(lesson)
        }


    }

    inner class ItemViewHolder(
        private var binding: LessonRvItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(lesson: OnlineLearningPlatform) {
            binding.tvTitle.text = lesson.olpTitle
            Picasso.get()
                .load(lesson.olpLogo)
                .placeholder(R.mipmap.ic_launcher)
                .into(binding.ivThumbnail)
        }
    }


    //interface
    interface OnItemClickListener {
        fun onItemClick(lesson: OnlineLearningPlatform)
    }


}