package com.example.curencyconverter.main

import com.example.curencyconverter.data.models.CurrencyResponse
import com.example.curencyconverter.util.Resource
import retrofit2.Response

interface MainRepository {
    suspend fun getRates(base:String): Resource<CurrencyResponse>
}