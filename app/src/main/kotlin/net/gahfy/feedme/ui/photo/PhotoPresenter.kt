package net.gahfy.feedme.ui.photo

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import net.gahfy.feedme.R
import net.gahfy.feedme.base.BasePresenter
import net.gahfy.feedme.network.PhotoApi
import javax.inject.Inject

class PhotoPresenter(photoView: PhotoView) : BasePresenter<PhotoView>(photoView) {
    @Inject
    lateinit var photoApi: PhotoApi

    override fun onViewCreated() {
        loadPhotos()
    }

    fun loadPhotos() {
        view.showLoading()
        subscription = photoApi
                .getPhotos()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate { view.hideLoading() }
                .subscribe(
                        { photoList -> view.updatePhotos(photoList) },
                        { view.showError(R.string.unknown_error) }
                )
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }
}