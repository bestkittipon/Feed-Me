package net.gahfy.feedme.ui.post

import android.databinding.DataBindingUtil
import android.os.Bundle
import net.gahfy.feedme.R
import net.gahfy.feedme.base.BaseActivity
import net.gahfy.feedme.base.BasePresenter
import net.gahfy.feedme.base.BaseView
import net.gahfy.feedme.databinding.ActivityPostBinding
import net.gahfy.feedme.ui.photo.PhotoFragment

/**
 * Activity displaying the list of posts
 */
class PostActivity : BaseActivity<BasePresenter<BaseView>>() {
    override var presenter: BasePresenter<BaseView>?
        get() = null
        set(value) {}

    override fun instantiatePresenter(): BasePresenter<BaseView>? {
        return presenter
    }

    /**
     * DataBinding instance
     */
    private lateinit var binding: ActivityPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_post)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.content_container_post, PostFragment.newInstance())
                addToBackStack(null)
            }.commit()

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.content_container_photo, PhotoFragment.newInstance())
                addToBackStack(null)
            }.commit()
        }
    }
}