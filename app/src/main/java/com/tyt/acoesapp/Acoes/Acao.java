package com.tyt.acoesapp.Acoes;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.tyt.acoesapp.Entity.DetailEntity;
import com.tyt.acoesapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
//Ao selecionar uma ação, define que informações são exibidas e de onde elas vem
public class Acao extends AppCompatActivity implements AcaoView{

    AcaoPresenter presenter;

    @BindView(R.id.image_view_header) ImageView imagem;
    @BindView(R.id.action_nome) TextView nome;
    @BindView(R.id.action_description) TextView descricao;
    @BindView(R.id.linear_layout_loading) LinearLayout loadingLayout;

    long campo_id;
    String campo_nome;
    String campo_descricao;
    String campo_site;
    String campo_imagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acao);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        presenter = new AcaoPresenter(this);

        campo_id = intent.getLongExtra("id", 0);
        campo_nome = intent.getStringExtra("name");
        campo_descricao = intent.getStringExtra("description");
        campo_imagem = intent.getStringExtra("image");
        campo_site = intent.getStringExtra("site");
        presenter.getActionDetail(campo_id);
    }

    @Override public void showDetails(DetailEntity detailEntity) {
        Picasso.with(this)
                .load(campo_imagem)
                .centerCrop()
                .fit()
                .into(imagem);
        descricao.setText(campo_descricao);
        nome.setText(campo_nome);
        setTitle(campo_nome);
    }
    @Override public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    @Override public void showLoading() {
        loadingLayout.setVisibility(View.VISIBLE);
    }
    @Override public void hideLoading() {
        loadingLayout.setVisibility(View.GONE);
    }

    @OnClick(R.id.info) public void openSite(View view){
        if (campo_site != null || !campo_site.isEmpty()) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(campo_site));
            startActivity(i);
        }
    }

}
