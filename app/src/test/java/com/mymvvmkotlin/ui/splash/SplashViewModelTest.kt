package com.mymvvmkotlin.ui.splash

import com.mymvvmkotlin.data.DataManager
import com.mymvvmkotlin.rx.TestSchedulerProvider
import com.mymvvmkotlin.testing.MathApplication
import io.reactivex.schedulers.TestScheduler
import org.junit.After
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SplashViewModelTest {

    @InjectMocks
    var mathApplication = MathApplication()

    @Mock
    lateinit var mLoginCallback: SplashContract

    @Mock
    lateinit var dataManager: DataManager;

  /*  @Mock
    lateinit var testScheduler: TestScheduler;*/

    private lateinit var splashViewModel:SplashViewModel;

    private lateinit var mTestScheduler: TestScheduler

    @Before
    @Throws(Exception::class)
    fun setUp() {
        mTestScheduler = TestScheduler()
        val testSchedulerProvider = TestSchedulerProvider(mTestScheduler)
        splashViewModel = SplashViewModel(dataManager, testSchedulerProvider)
        splashViewModel.setNavigator(mLoginCallback)
    }

    @Test
    fun doLogin() {

        splashViewModel.doLogin()

        mTestScheduler.triggerActions()

        verify(mLoginCallback).openMainActivity()
    }

    @After
    @Throws(java.lang.Exception::class)
    fun tearDown() {
      /*  mTestScheduler =null;
        mLoginViewModel = null
        mLoginCallback = null*/
    }
}
