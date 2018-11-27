package net.gahfy.feedme.ui.post

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import net.gahfy.feedme.R
import net.gahfy.feedme.base.BaseActivity
import net.gahfy.feedme.databinding.ActivityPostBinding
import net.gahfy.feedme.model.Post

/**
 * Activity displaying the list of posts
 */
class PostActivity : BaseActivity<PostPresenter>() {
    override var presenter: PostPresenter?
        get() = null
        set(value) {}

    override fun instantiatePresenter(): PostPresenter? {
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
                replace(R.id.content_container, PostFragment.newInstance(getContext()))
                addToBackStack(null)
            }.commit()
        }
    }
}