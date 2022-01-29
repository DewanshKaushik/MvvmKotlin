package com.mymvvmkotlin.ui.splash

import com.mymvvmkotlin.data.AppDataManager
import com.mymvvmkotlin.rx.TestSchedulerProvider
import com.mymvvmkotlin.testing.MathApplication
import com.mymvvmkotlin.utils.rx.AppSchedulerProvider
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.spy
import org.mockito.Mockito.verify
import org.powermock.core.classloader.annotations.PowerMockIgnore
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
@PowerMockIgnore()
@PrepareForTest()
class SplashViewModelTest {
 //   @Rule
 //    var powerMockRunner:PowerMockRunner = PowerMockRunner()

    @InjectMocks
    var mathApplication = MathApplication()

    @Mock
    lateinit var mLoginCallback: SplashContract

    @Mock
    lateinit var dataManager: AppDataManager;

    @Mock
    lateinit var appDataManager: AppSchedulerProvider
    lateinit var splashViewModel: SplashViewModel;
    lateinit var mTestScheduler: TestScheduler

    @Before
    @Throws(Exception::class)
    fun setUp() {
        mTestScheduler = TestScheduler()
        val testSchedulerProvider = TestSchedulerProvider(mTestScheduler)
        splashViewModel = spy(SplashViewModel(dataManager, appDataManager))
        splashViewModel.setNavigator(mLoginCallback)

    }

    @Test
    fun doLogin() {
        splashViewModel.doLogin()
        verify(splashViewModel).doLogin()
    }

}
