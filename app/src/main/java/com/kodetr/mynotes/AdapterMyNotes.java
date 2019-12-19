package com.kodetr.mynotes;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterMyNotes extends RecyclerView.Adapter<AdapterMyNotes.MyNotesViewHolder>{

    private MyNotesOnClikListener clikListener;
    private List<MyNotes> notesList;

    public AdapterMyNotes(MyNotesOnClikListener clikListener, List<MyNotes> notesList) {
        this.notesList = notesList;
        this.clikListener = clikListener;
    }

    @NonNull
    @Override
    public MyNotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.items, parent, false);
        return new MyNotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyNotesViewHolder holder, final int position) {

//        Picasso.with(holder.itemView.getContext())
//                .load(notesList.get(position).getImage())
//                .into(holder.iv_image);
//
        new DownloadImageTask(holder.iv_image).execute(notesList.get(position).getImage());

        holder.tv_title.setText(notesList.get(position).getTitle());
        holder.tv_desc.setText(notesList.get(position).getDesc());
        holder.ll_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clikListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public class MyNotesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private LinearLayout ll_container;
        private ImageView iv_image;
        private TextView tv_title;
        private TextView tv_desc;

        public MyNotesViewHolder(@NonNull View itemView) {
            super(itemView);
            ll_container = itemView.findViewById(R.id.ll_container);
            iv_image = itemView.findViewById(R.id.iv_image);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_desc = itemView.findViewById(R.id.tv_desc);
            ll_container.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clikListener.onClick(getLayoutPosition());
        }
    }

    interface MyNotesOnClikListener{
        void onClick(int posisi);
    }
}
