package br.com.viajabessa.viajabessastore.presentation.view;

import java.util.List;

import br.com.viajabessa.viajabessastore.model.Pacote;


public interface PacoteView extends BaseView {

    interface Lista {

        interface Activity extends PacoteView {

            void addAll(List<Pacote> pacotes);

        }

    }
    interface Detalhe {

        interface Activity extends PacoteView {

            void preencher(Pacote pacote);

        }


    }

}
