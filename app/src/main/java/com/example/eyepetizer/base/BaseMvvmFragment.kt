package com.example.eyepetizer.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType

/**
 * 所有Fragment基类
 *
 * @author Afeng
 * @date 23/3/1
 */
abstract class BaseMvvmFragment<VM : BaseViewModel, VB : ViewDataBinding>(private val contenViewResId: Int) :
    Fragment() {

    private lateinit var mViewModel: VM
    private lateinit var mBinding: VB
    protected lateinit var mRootView: View
    protected val TAG: String = this.javaClass.simpleName

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, contenViewResId, container, false);
        mBinding.lifecycleOwner = this;
        initViewModel();
        initView();
        initViewObservable(mViewModel);
        mRootView = mBinding.getRoot();
        return mRootView;
    }

    protected fun initViewModel() {
        val type: Class<VM> =
            (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<VM>
        mViewModel
        mViewModel = ViewModelProvider(this).get(type)
    }

    protected fun initView() {}

    protected fun initViewObservable(mViewModel: VM) {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData(mViewModel)
    }
    protected fun initData(mViewModel: VM) {}
}