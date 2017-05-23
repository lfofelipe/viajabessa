package br.com.viajabessa.viajabessastore.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.viajabessa.viajabessastore.R;
import br.com.viajabessa.viajabessastore.interactor.impl.PacoteInteractorImpl;
import br.com.viajabessa.viajabessastore.model.Pacote;
import br.com.viajabessa.viajabessastore.presentation.presenter.DetalhePacotePresenter;
import br.com.viajabessa.viajabessastore.presentation.presenter.ListaPacotePresenter;
import br.com.viajabessa.viajabessastore.presentation.presenter.impl.DetalhePacotePresenterImpl;
import br.com.viajabessa.viajabessastore.presentation.presenter.impl.ListaPacotePresenterImpl;
import br.com.viajabessa.viajabessastore.presentation.view.PacoteView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DetalhePacoteActivity extends BaseActivity implements PacoteView.Detalhe {

    @BindView(R.id.txt_titulo_pacote)
    TextView txtTitulo;
    @BindView(R.id.txt_descricao)
    TextView txtDescricao;
    @BindView(R.id.txt_valor)
    TextView txtValor;
    @BindView(R.id.imagem_pacote_large)
    ImageView imgPacote;

    private DetalhePacotePresenter presenter;
    private Pacote mPacote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_pacote);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);

        presenter = new DetalhePacotePresenterImpl(this, new PacoteInteractorImpl()) {
        };
        if (savedInstanceState == null) {
            Bundle args = getIntent().getExtras();
            if( args != null ){
                Long idPacote = args.getLong("id_pacote");

                presenter.carregarDetalhe(idPacote, Build.VERSION.RELEASE, Build.BRAND, Build.MANUFACTURER);
            }
        } else {
            mPacote = (Pacote) savedInstanceState.getSerializable("objeto_pacote");
            preencher(mPacote);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void preencher (Pacote pacote){
        txtTitulo.setText(pacote.getTitulo());
        txtDescricao.setText(pacote.getDescricao());
        txtValor.setText(String.format("R$ %s", pacote.getValor()));
        imgPacote.setImageBitmap(pacote.getBitmap());
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("objeto_pacote", mPacote);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}
