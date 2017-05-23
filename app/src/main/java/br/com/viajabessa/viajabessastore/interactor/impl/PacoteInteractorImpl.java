package br.com.viajabessa.viajabessastore.interactor.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import br.com.viajabessa.viajabessastore.interactor.PacoteInteractor;
import br.com.viajabessa.viajabessastore.model.Pacote;
import br.com.viajabessa.viajabessastore.service.PacoteService;
import br.com.viajabessa.viajabessastore.service.impl.PacoteServiceImpl;
import rx.Observable;

public class PacoteInteractorImpl implements PacoteInteractor {

    private PacoteService service;

    public PacoteInteractorImpl() {
        this.service = new PacoteServiceImpl();
    }

    @Override
    public Observable<List<Pacote>> obter(String version, String brand, String model) {
        return service.obter(version, brand, model).map(pacotes->{
            for(Pacote pacote: pacotes){
                URL url = null;
                try {
                    url = new URL(pacote.getLinkImagem());
                    Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                    if (bmp != null) {
                        pacote.setBitmap(bmp);
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return pacotes;
        });
    }

    @Override
    public Observable<Pacote> detalhar(Long idPacote, String version, String brand, String model) {
        return service.detalhar(idPacote, version, brand, model).map(pacote->{
                URL url = null;
                try {
                    url = new URL(pacote.getLinkImagem());
                    Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                    if (bmp != null) {
                        pacote.setBitmap(bmp);
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return pacote;
        });
    }
}
