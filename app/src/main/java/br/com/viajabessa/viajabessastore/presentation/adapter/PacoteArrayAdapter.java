package br.com.viajabessa.viajabessastore.presentation.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.viajabessa.viajabessastore.R;
import br.com.viajabessa.viajabessastore.model.Pacote;
import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func0;
import rx.schedulers.Schedulers;

import static br.com.viajabessa.viajabessastore.R.id.txt_titulo_pacote;

/**
 * Created by Felipe-PC on 22/05/2017.
 */

public class PacoteArrayAdapter extends ArrayAdapter<Pacote> {

    private Context context;
    private List<Pacote> pacotes = new ArrayList<>();

    public PacoteArrayAdapter(Context context, int resource) {
        super(context, resource);
        this.context = context;
    }


    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Nullable
    @Override
    public Pacote getItem(int position) {
        return pacotes.get(position);
    }

    @Override
    public int getPosition(Pacote item) {
        return pacotes.indexOf(item);
    }

    @Override
    public void clear() {
        pacotes.clear();
    }

    @Override
    public void addAll(Collection<? extends Pacote> collection) {
        pacotes.addAll(collection);
        notifyDataSetChanged();
    }

    @Override
    public void add(Pacote object) {
        pacotes.add(object);
        notifyDataSetChanged();
    }

    @Override
    public void remove(Pacote object) {
        pacotes.remove(object);
        notifyDataSetChanged();
    }


    public List<Pacote> getPacotes() {
        return pacotes;
    }

    public void setPacotes(List<Pacote> pacotes) {
        this.pacotes = pacotes;
        notifyDataSetChanged();
    }

    @BindView(R.id.imagem_pacote)
    ImageView imgPacote;
    @BindView(txt_titulo_pacote)
    TextView txtTitulo;
    @BindView(R.id.txt_valor_pacote)
    TextView txtValor;

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Pacote pacote = getItem(position);

        if( convertView == null ){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_pacote, null);
        }

        ButterKnife.bind(this, convertView);

        imgPacote.setImageBitmap(pacote.getBitmap());
        txtTitulo.setText(pacote.getTitulo());
        txtValor.setText(String.format("R$ %s", pacote.getValor()));
        return convertView;
    }


}
