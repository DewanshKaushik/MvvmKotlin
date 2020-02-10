package com.mymvvmkotlin.data

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.mymvvmkotlin.data.local.db.AppDbHelper
import com.mymvvmkotlin.data.local.db.DbHelper
import com.mymvvmkotlin.data.local.prefs.AppPreferencesHelper
import com.mymvvmkotlin.data.local.prefs.PreferencesHelper
import com.mymvvmkotlin.data.model.db.MyModel
import com.mymvvmkotlin.data.model.others.MyModelData
import com.mymvvmkotlin.data.remote.NewsRepository
import com.webaddicted.network.apiutils.ApiResponse
import com.webaddicted.network.apiutils.ApiServices
import com.webaddicted.network.apiutils.DataFetchCall
import kotlinx.coroutines.Deferred
import retrofit2.Response

//d model
class AppDataManager (
    private val mContext: Context,
    private val dbHelper: AppDbHelper,
    private val preferencesHelper: AppPreferencesHelper,
    private val newsRepository: NewsRepository,
    private val apiServices: ApiServices,

    private val gson: Gson
) : DataManager {
    private val mDbHelper: DbHelper
    private val mGson: Gson
    private val mPreferencesHelper: PreferencesHelper
    private val news: NewsRepository



    companion object {
        private const val TAG = "AppDataManager"
    }

    init {
        mDbHelper = dbHelper
        mPreferencesHelper = preferencesHelper
        mGson = gson
        news=newsRepository
    }

    override fun getData(){
        mDbHelper.getData()
    }

    override fun getname(){
        mPreferencesHelper.getname()
    }

    fun getNewsChannel(strUrl: String, loginResponse: MutableLiveData<ApiResponse<MyModel>>) {
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