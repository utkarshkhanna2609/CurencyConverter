package com.example.curencyconverter.main

import com.example.curencyconverter.data.CurrencyApi
import com.example.curencyconverter.data.models.CurrencyResponse
import com.example.curencyconverter.util.Resource
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

class DefaultMainRepository @Inject constructor(
    private val api:CurrencyApi
) : MainRepository{
    override suspend fun getRates(base: String): Resource<CurrencyResponse> {
        return try{
            val response=api.getRates(base)
            val result=response.body()
            if(response.isSuccessful && result != null){
                Resource.Success(result)
            }else{
                Resource.Error(response.message())
            }
        }catch (e:Exception)
        {
            Resource.Error(e.message?:"An Error Occurred")
        }

    }

}