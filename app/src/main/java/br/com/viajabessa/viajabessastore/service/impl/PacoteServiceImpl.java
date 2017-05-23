package br.com.viajabessa.viajabessastore.service.impl;

import java.util.List;

import br.com.viajabessa.viajabessastore.model.Pacote;
import br.com.viajabessa.viajabessastore.service.PacoteService;
import br.com.viajabessa.viajabessastore.service.RetrofitConnection;
import br.com.viajabessa.viajabessastore.service.endpoint.PacoteEndPoint;
import rx.Observable;



public class PacoteServiceImpl implements PacoteService {
    @Override
    public Observable<List<Pacote>> obter(String version, String brand, String model) {
        return RetrofitConnection.connect(PacoteEndPoint.class).obter(version, brand, model);
    }

    @Override
    public Observable<Pacote> detalhar(Long idPacote, String version, String brand, String model) {
        return RetrofitConnection.connect(PacoteEndPoint.class).detalhar(idPacote, version, brand, model);
    }
}
