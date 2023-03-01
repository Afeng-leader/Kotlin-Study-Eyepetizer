package com.example.eyepetizer.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType

/**
 * 所有Activity 基类
 *
 * @author Afeng
 * @date 23/3/1
 */
abstract class BaseMvvmActivity<VM : BaseViewModel, VB : ViewDataBinding>(private val contenViewResId: Int) :
    AppCompatActivity() {

    private lateinit var mViewModel: VM
    private lateinit var mBinding: VB
    protected val TAG: String = this.javaClass.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(contenViewResId)
        mBinding = DataBindingUtil.setContentView(this, contenViewResId)
        initViewModel()
        initView(mBinding)
        initViewObservable(mViewModel)
        initData(mViewModel)
    }

    protected fun initViewModel() {
        val type: Class<VM> =
            (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<VM>
        mViewModel
        mViewModel = ViewModelProvider(this).get(type)
    }

    protected fun initView(mBinding: VB) {


    }

    protected fun initViewObservable(mViewModel: VM) {}

    protected fun initData(mViewModel: VM) {


    }


}