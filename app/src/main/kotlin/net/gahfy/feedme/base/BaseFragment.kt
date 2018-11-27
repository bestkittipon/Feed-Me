package net.gahfy.feedme.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment

abstract class BaseFragment<P : BasePresenter<BaseView>> : BaseView , Fragment() {
    protected lateinit var presenter: P
    private lateinit var mContext: Context

    protected abstract fun instantiatePresenter(): P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = instantiatePresenter()
    }

    protected fun setContext(context: Context) {
        mContext = context
    }

    override fun getContext(): Context {
        return this.mContext
    }
}