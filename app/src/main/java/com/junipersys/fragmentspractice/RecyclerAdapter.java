package com.junipersys.fragmentspractice;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class RecyclerAdapter extends RecyclerView.Adapter {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(getLayoutId(), viewGroup, false));
    }

    protected abstract int getLayoutId();

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ListViewHolder) viewHolder).bindView(i);
    }

    @Override
    public int getItemCount() {
        return Recipes.names.length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textView;
        private ImageView imageView;
        private int index;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_text);
            imageView = itemView.findViewById(R.id.item_image);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position){
            textView.setText(Recipes.names[position]);
            imageView.setImageResource(Recipes.resourceIds[position]);
            index = position;
        }

        @Override
        public void onClick(View view) {
            onRecipeSelected(index);
        }
    }

    protected abstract void onRecipeSelected(int index);
}
