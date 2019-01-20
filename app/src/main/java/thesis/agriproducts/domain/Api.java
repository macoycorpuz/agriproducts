package thesis.agriproducts.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    private static Api instance = null;

    // Keep your services here, build them in buildRetrofit method later
    private ApiServices apiServices;

    public static Api getInstance() {
        if (instance == null) {
            instance = new Api();
        }

        return instance;
    }

    private Api() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiServices.MAIN_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        // Build your services once
        this.apiServices = retrofit.create(ApiServices.class);
    }

    public ApiServices getApiServices() {
        return this.apiServices;
    }
}