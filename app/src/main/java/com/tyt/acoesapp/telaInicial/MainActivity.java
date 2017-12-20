package com.tyt.acoesapp.telaInicial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.tyt.acoesapp.Acoes.Acao;
import com.tyt.acoesapp.Entity.AcaoSocial;
import com.tyt.acoesapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements mainView{

    //Realiza os binds com o butterknife com as views do xml
    @BindView(R.id.rv_actions) RecyclerView rvActions;
    @BindView(R.id.linear_layout_loading) LinearLayout loadingLayout;

    //Instancia um presenter
    MainPresenter mainPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mainPresenter = new MainPresenter(this);
        mainPresenter.updateList();
    }


    @Override public void updateList(List<AcaoSocial> actionsList) {
        //seta o adapter
        MainViewAdapter actionsAdapter = new MainViewAdapter(actionsList, this);
        actionsAdapter.setOnRecyclerViewSelected(new OnRecyclerViewSelect() {
            @Override
            public void onClick(View view, int position) {
                Intent openActionDetail = new Intent(MainActivity.this, Acao.class);
                openActionDetail.putExtra("id",mainPresenter.getActionId(position));
                openActionDetail.putExtra("name",mainPresenter.getActionName(position));
                openActionDetail.putExtra("image",mainPresenter.getActionImage(position));
                openActionDetail.putExtra("description",mainPresenter.getActionDescription(position));
                openActionDetail.putExtra("site",mainPresenter.getActionSite(position));
                startActivity(openActionDetail);
            }
        });

        //Criação do gerenciador de layouts
        rvActions.setAdapter(actionsAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvActions.setLayoutManager(layoutManager);

        //Criação do divisor de itens
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        rvActions.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

    }

    //Exibe o loading
    @Override
    public void showLoading() {
        loadingLayout.setVisibility(View.VISIBLE);
    }

    //Esconde o loading
    @Override
    public void hideLoading() {
        loadingLayout.setVisibility(View.GONE);
    }
}
