package com.joel.word

import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.joel.word.model.Notes

class NotesAdapter(
    val context: Context,
    private val deleteClick: OnDeleteClick,
    val noteClick: OnNoteClick
) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>()  {

    private val allNotes = ArrayList<Notes>()

    inner class NotesViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val ivImageView : ImageView = view.findViewById(R.id.imageView)
        val tvTitleTextView : TextView = view.findViewById(R.id.textViewTitle)
        val tvDescriptionTextView : TextView = view.findViewById(R.id.textViewDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return NotesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.tvTitleTextView.text = allNotes[position].title
        holder.tvDescriptionTextView.text = allNotes[position].description

        holder.ivImageView.setOnClickListener {
            deleteClick.onDeleteClick(allNotes[position])
        }

        holder.itemView.setOnClickListener {
            noteClick.onNoteClick(allNotes[position])
        }
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

}

interface OnDeleteClick{
    fun onDeleteClick(notes: Notes)
}

interface OnNoteClick{
    fun onNoteClick(notes: Notes)
}