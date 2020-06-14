package com.mymvvmkotlin.ui.splash.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class BaseFragment<V : BaseViewModel<*>?> :
    Fragment() {
    var baseActivity: BaseActivity<*>? = null
        private set
    private val mRootView: View? = null
    private var mViewModel: V? = null
    abstract val viewModel: V
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*>) {
            val activity = context
            baseActivity = activity
            activity.onFragmentAttached()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = viewModel
        setHasOptionsMenu(false)
    }

    /* @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        mRootView = mViewDataBinding.getRoot();
        return mRootView;
    }*/
    override fun onDetach() {
        baseActivity = null
        super.onDetach()
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun hideKeyboard() {
        if (baseActivity != null) {
            baseActivity!!.hideKeyboard()
        }
    }

    interface Callback {
        fun onFragmentAttached()
        fun onFragmentDetached(tag: String?)
    }
}