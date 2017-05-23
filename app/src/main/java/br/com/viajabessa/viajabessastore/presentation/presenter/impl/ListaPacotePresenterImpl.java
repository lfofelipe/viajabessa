package br.com.viajabessa.viajabessastore.presentation.presenter.impl;

import android.util.Log;

import java.util.List;

import br.com.viajabessa.viajabessastore.interactor.PacoteInteractor;
import br.com.viajabessa.viajabessastore.model.Pacote;
import br.com.viajabessa.viajabessastore.presentation.presenter.ListaPacotePresenter;
import br.com.viajabessa.viajabessastore.ui.activity.ListaPacoteActivity;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;



public class ListaPacotePresenterImpl implements ListaPacotePresenter {

    private ListaPacoteActivity mView;
    private PacoteInteractor interactor;

    public ListaPacotePresenterImpl(ListaPacoteActivity mView, PacoteInteractor interactor) {
        this.mView =  mView;
        this.interactor = interactor;
    }

    @Override
    public void carregarLista(String version, String brand, String model) {
        Observable<List<Pacote>> observable = interactor.obter(version, brand, model);

        observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Pacote>>() {
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
                    public void onNext(List<Pacote> pacotes) {
                        if( pacotes != null ){
                            mView.addAll(pacotes);
                        }
                    }
                });
    }
}
