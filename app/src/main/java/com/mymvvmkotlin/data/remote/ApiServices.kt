package com.webaddicted.network.apiutils

import com.mymvvmkotlin.data.model.db.MyModel
import com.mymvvmkotlin.data.model.others.MyModelData
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url


interface ApiServices {
    @GET
    fun getChannelListName(@Url strUrl: String): Deferred<Response<MyModel>>
}