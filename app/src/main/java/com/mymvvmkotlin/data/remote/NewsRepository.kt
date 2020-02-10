package com.mymvvmkotlin.data.remote

import androidx.lifecycle.MutableLiveData
import com.mymvvmkotlin.data.model.db.MyModel
import com.mymvvmkotlin.data.model.others.MyModelData
import com.webaddicted.network.apiutils.ApiResponse
import com.webaddicted.network.apiutils.ApiServices
import com.webaddicted.network.apiutils.DataFetchCall
import kotlinx.coroutines.Deferred
import retrofit2.Response


open class NewsRepository constructor(private val apiServices: ApiServices) {

  public  fun getNewsChannel(strUrl: String, loginResponse: MutableLiveData<ApiResponse<MyModel>>) {
        object : DataFetchCall<MyModel>(loginResponse) {
            override fun createCallAsync(): Deferred<Response<MyModel>> {
                return apiServices.getChannelListName(strUrl)
            }

            override fun shouldFetchFromDB(): Boolean {
                return false
            }
        }.execute()
    }
}