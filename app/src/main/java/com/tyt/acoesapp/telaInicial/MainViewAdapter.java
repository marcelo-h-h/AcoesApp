package com.tyt.acoesapp.telaInicial;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tyt.acoesapp.Entity.AcaoSocial;
import com.tyt.acoesapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by marcelo on 18/12/17.
 */

//O adapter constroi os itens da lista de itens
public class MainViewAdapter extends RecyclerView.Adapter<MainViewAdapter.ViewHolder>{
    private List<AcaoSocial> actionsList;
    private Context context;
    OnRecyclerViewSelect onRecyclerViewSelected;

    public MainViewAdapter(List<AcaoSocial> actionsList, Context context){
        this.actionsList = actionsList;
        this.actionsList.add(new AcaoSocial());
        this.actionsList.add(new AcaoSocial());
        this.actionsList.add(new AcaoSocial());
        this.context = context;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.acaolistitem, parent, false);
        return new ViewHolder(v);
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(context)
                .load(actionsList.get(position).getImage())
                .centerCrop()
                .fit()
                .into(holder.ivBackground);
        holder.tvHeading.setText(actionsList.get(position).getName());
    }

    @Override public int getItemCount() {
        return actionsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_background) ImageView ivBackground;
        @BindView(R.id.iv_heading) TextView tvHeading;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        //seta o clique rápido
        @OnClick(R.id.container)
        void onItemClick(View view){
            if(onRecyclerViewSelected != null)
                onRecyclerViewSelected.onClick(view, getAdapterPosition());

        }
    }

    public void setOnRecyclerViewSelected(OnRecyclerViewSelect onRecyclerViewSelected){
        this.onRecyclerViewSelected = onRecyclerViewSelected;
    }
}

