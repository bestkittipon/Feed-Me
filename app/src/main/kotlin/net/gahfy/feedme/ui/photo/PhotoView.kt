package net.gahfy.feedme.ui.photo

import android.support.annotation.StringRes
import net.gahfy.feedme.base.BaseView
import net.gahfy.feedme.model.Photo

/**
 * Interface providing required method for a view displaying posts
 */
interface PhotoView : BaseView {
    /**
     * Updates the previous posts by the specified ones
     * @param posts the list of posts that will replace existing ones
     */
    fun updatePhotos(photos: List<Photo>)

    /**
     * Displays an error in the view
     * @param error the error to display in the view
     */
    fun showError(error: String)

    /**
     * Displays an error in the view
     * @param errorResId the resource id of the error to display in the view
     */
    fun showError(@StringRes errorResId: Int) {
        this.showError(getContext().getString(errorResId))
    }

    /**
     * Displays the loading indicator of the view
     */
    fun showLoading()

    /**
     * Hides the loading indicator of the view
     */
    fun hideLoading()
}