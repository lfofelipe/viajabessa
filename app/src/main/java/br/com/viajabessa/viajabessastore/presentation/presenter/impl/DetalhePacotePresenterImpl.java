package br.com.viajabessa.viajabessastore.presentation.presenter.impl;

import android.util.Log;

import br.com.viajabessa.viajabessastore.interactor.PacoteInteractor;
import br.com.viajabessa.viajabessastore.model.Pacote;
import br.com.viajabessa.viajabessastore.presentation.presenter.DetalhePacotePresenter;
import br.com.viajabessa.viajabessastore.ui.activity.DetalhePacoteActivity;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;



public class DetalhePacotePresenterImpl implements DetalhePacotePresenter {

    private DetalhePacoteActivity mView;
    private PacoteInteractor interactor;

    public DetalhePacotePresenterImpl(DetalhePacoteActivity view, PacoteInteractor interactor) {
        this.mView =  view;
        this.interactor = interactor;
    }

    @Override
    public void carregarDetalhe(Long id, String version, String brand, String model) {
        Observable<Pacote> observable = interactor.detalhar(id, version, brand, model);

        observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Pacote>() {
                    @Override
                    public void onStart() {
                        super.onStart();
                        mView.showProgress(true);
                    }

                    @Override
                    public void onCompleted() {
                        mView.showProgress(false);
                        mView.showRootView(true);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("VIAJABESSA", e.getMessage());
                        mView.showSnackbar("Não foi possível carregar os dados");
                        mView.showProgress(false);
                    }

                    @Override
                    public void onNext(Pacote pacote) {
                        if( pacote != null ){
                            mView.preencher(pacote);
                        }
                    }
                });
    }
}
