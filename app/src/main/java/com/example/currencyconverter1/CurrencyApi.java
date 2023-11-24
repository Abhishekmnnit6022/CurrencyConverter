package com.example.currencyconverter1;

import retrofit2.Call;
import retrofit2.http.GET;;
import java.util.Map;


public interface CurrencyApi {
    @GET("v4/latest/USD") // Adjust the endpoint based on the API documentation
    Call<ExchangeRateResponse> getExchangeRates();
}
