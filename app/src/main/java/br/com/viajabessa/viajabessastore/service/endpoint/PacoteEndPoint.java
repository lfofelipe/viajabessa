package br.com.viajabessa.viajabessastore.service.endpoint;

import java.util.List;

import br.com.viajabessa.viajabessastore.model.Pacote;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface PacoteEndPoint {
    @GET("pacotes/")
    rx.Observable<List<Pacote>> obter(@Query("version") String version,
                                      @Query("brand")String brand,
                                      @Query("model")String model);
    @GET("pacote/{id}")
    rx.Observable<Pacote> detalhar(@Path("id") Long idPacote,
                                   @Query("version") String version,
                                   @Query("brand")String brand,
                                   @Query("model")String model);
}
