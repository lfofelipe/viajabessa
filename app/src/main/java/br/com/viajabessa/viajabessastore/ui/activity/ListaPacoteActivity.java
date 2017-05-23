package br.com.viajabessa.viajabessastore.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.viajabessa.viajabessastore.R;
import br.com.viajabessa.viajabessastore.interactor.impl.PacoteInteractorImpl;
import br.com.viajabessa.viajabessastore.model.Pacote;
import br.com.viajabessa.viajabessastore.presentation.adapter.PacoteArrayAdapter;
import br.com.viajabessa.viajabessastore.presentation.presenter.ListaPacotePresenter;
import br.com.viajabessa.viajabessastore.presentation.presenter.impl.ListaPacotePresenterImpl;
import br.com.viajabessa.viajabessastore.presentation.view.PacoteView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ListaPacoteActivity extends BaseActivity implements PacoteView.Lista {

    @BindView(R.id.list_view_pacote)
    ListView listPacote;

    private PacoteArrayAdapter mAdapter;
    private ListaPacotePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacote);

        // Butterknife configuration
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAdapter = new PacoteArrayAdapter(getBaseContext(),R.layout.item_pacote);
        listPacote.setAdapter(mAdapter);
        mPresenter = new ListaPacotePresenterImpl(this, new PacoteInteractorImpl());

        listPacote.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pacote pacote = mAdapter.getItem(position);
                Intent intent = new Intent(getBaseContext(), DetalhePacoteActivity.class);
                intent.putExtra("id_pacote", pacote.getId());
                startActivity(intent);
            }
        });
        carregar();

    }
    void carregar(){
        mPresenter.carregarLista(Build.VERSION.RELEASE, Build.BRAND, Build.MANUFACTURER);
    }

    public void addAll(List<Pacote> pacotes) {
        if(mAdapter == null){
            return;
        }
        mAdapter.addAll(pacotes);
        listPacote.setEmptyView( findViewById(R.id.layout_listview_empty) );
    }


}
