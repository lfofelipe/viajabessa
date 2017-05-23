package br.com.viajabessa.viajabessastore.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConnection {

    private static final OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
    private static final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
    private static final HttpLoggingInterceptor.Level loggingLevel = HttpLoggingInterceptor.Level.BODY;
    private static final String BASE_URL = "https://private-283850-viajabessa45.apiary-mock.com/";
    public RetrofitConnection() {


    }

    public static <S> S connect(Class<S> serviceClass) {
        loggingInterceptor.setLevel(loggingLevel);
        httpClientBuilder.interceptors().add(loggingInterceptor);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();


        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());

        OkHttpClient httpClient = httpClientBuilder
                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(serviceClass);
    }
}
