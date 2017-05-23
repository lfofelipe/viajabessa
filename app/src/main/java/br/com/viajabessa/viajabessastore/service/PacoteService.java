package br.com.viajabessa.viajabessastore.service;


import java.util.List;

import br.com.viajabessa.viajabessastore.model.Pacote;

public interface PacoteService {

    rx.Observable<List<Pacote>> obter(String version, String brand, String model);

    rx.Observable<Pacote> detalhar(Long idPacote, String version, String brand, String model);
}
