package com.mymvvmkotlin.ui.splash.main

import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.mymvvmkotlin.R
import com.mymvvmkotlin.data.model.db.MyModel
import com.mymvvmkotlin.ui.main.MainViewModel
import com.mymvvmkotlin.ui.splash.SplashContract
import com.mymvvmkotlin.ui.splash.base.BaseActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import com.mymvvmkotlin.ui.main.MainContract

// KOtlin Coroutines

class MainActivity : BaseActivity<MainViewModel?>(), MainContract {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.Main) {
           // val user = fetchUser() // fetch on IO thread
         //   showUser(user) // back on UI thread
        }
    }
/*
* coroutineScope {
                    val usersFromApiDeferred = async { apiHelper.getUsers() }
                    val moreUsersFromApiDeferred = async { apiHelper.getMoreUsers() }

                    val usersFromApi = usersFromApiDeferred.await()
                    val moreUsersFromApi = moreUsersFromApiDeferred.await()

                    val allUsersFromApi = mutableListOf<ApiUser>()
                    allUsersFromApi.addAll(usersFromApi)
                    allUsersFromApi.addAll(moreUsersFromApi)

                    users.postValue(Resource.success(allUsersFromApi))
                }*/
   // suspend fun fetchUser(): MyModel {
  //  try {
 //d       val usersDeferred = async {  getUsers() }
  //d      val moreUsersDeferred = async { getMoreUsers() }
        //d      val users = usersDeferred.await()
        //d val moreUsers = moreUsersDeferred.await()
  //  } catch (exception: Exception) {
        //d Log.d(TAG, "$exception handled !")
  //  }


  //  }

    suspend fun fetchAndShowUser() {
      //  val user = fetchUser() // fetch on IO thread
     //   showUser(user) // back on UI thread
    }

    fun showUser(user: MyModel) {
        // show user
    }



    override fun onFragmentDetached(tag: String?) {
    }

    override fun getViewModel(): MainViewModel? {
        TODO("Not yet implemented")
    }

    override fun getLayoutId(): Int {
        TODO("Not yet implemented")
    }


}
