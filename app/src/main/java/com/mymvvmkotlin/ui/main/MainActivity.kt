package com.mymvvmkotlin.ui.splash.main

import android.os.Bundle
import android.util.Log
import com.mymvvmkotlin.R
import com.mymvvmkotlin.data.model.others.User
import com.mymvvmkotlin.ui.main.MainContract
import com.mymvvmkotlin.ui.main.MainViewModel
import com.mymvvmkotlin.ui.splash.base.BaseActivity
import kotlinx.coroutines.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.coroutines.CoroutineContext

/* Kotlin Coroutines
   https://blog.mindorks.com/mastering-kotlin-coroutines-in-android-step-by-step-guide*/

class MainActivity : BaseActivity<MainViewModel?>(), MainContract, CoroutineScope {

    val TAG = MainActivity::class.java.simpleName

    private val mViewModel: MainViewModel by viewModel()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private lateinit var job: Job


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // launch example
        GlobalScope.launch(Dispatchers.Main) {
            fetchAndShowUser()
        }

        // async used for parallel execution
        GlobalScope.launch(Dispatchers.Main) {
            val userOne = async(Dispatchers.IO) { fetchFirstUser() }
            val userTwo = async(Dispatchers.IO) { fetchSecondUser() }
            showUsers(userOne.await(), userTwo.await()) // back on UI thread
        }

        // withContext used for series execution
        GlobalScope.launch(Dispatchers.Main) {
            val userOne = withContext(Dispatchers.IO) { fetchFirstUser() }
            val userTwo = withContext(Dispatchers.IO) { fetchSecondUser() }
            showUsers(userOne, userTwo) // back on UI thread
        }

        // by using activity scopes
        launch {
            val userOne = async(Dispatchers.IO) { fetchFirstUser() }
            val userTwo = async(Dispatchers.IO) { fetchSecondUser() }
            showUsers(userOne.await(), userTwo.await())
        }

        // by using application scope
        GlobalScope.launch(Dispatchers.Main) {
            val userOne = async(Dispatchers.IO) { fetchFirstUser() }
            val userTwo = async(Dispatchers.IO) { fetchSecondUser() }
            userOne.await();
        }

        // exceptional handling
        launch {
            try {
                supervisorScope {
                    val usersDeferred = async { getUsers() }
                    val moreUsersDeferred = async { getMoreUsers() }
                    val users = try {
                        usersDeferred.await()
                    } catch (e: Exception) {
                        emptyList<User>()
                    }
                    val moreUsers = try {
                        moreUsersDeferred.await()
                    } catch (e: Exception) {
                        emptyList<User>()
                    }
                }
            } catch (exception: Exception) {
                Log.d(TAG, "$exception handled !")
            }
        }

        job = Job() // create the Job
    }

    fun getUsers() {

    }

    fun getMoreUsers() {

    }

    suspend fun fetchAndShowUser() {
        val user = fetchUser() // fetch on IO thread
        showUser(user) // back on UI thread
    }

    fun showUser(user: User) {
        Log.e("user", user.name + " " + user.id)
    }

    suspend fun fetchUser(): User {
        return GlobalScope.async(Dispatchers.IO) {
            User("name", 1)
        }.await()
    }

    override fun onFragmentDetached(tag: String?) {
    }

    override fun getViewModel(): MainViewModel? {
        return mViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    suspend fun fetchFirstUser(): User {
        return User("first user", 1)
    }

    suspend fun fetchSecondUser(): User {
        return User("second user", 2)
    }

    fun showUsers(userOne: User, userTwo: User) {
        Log.e("Show Users", userOne.toString() + " " + userTwo.toString())
    }


    override fun onDestroy() {
        job.cancel() // cancel the Job
        super.onDestroy()
    }

}


/*
The thumb-rules:

Use withContext when you do not need the parallel execution.
Use async only when you need the parallel execution.
Both withContext and async can be used to get the result which is not possible with the launch.
Use withContext to return the result of a single task.
Use async for results from multiple tasks that run in parallel.*/
