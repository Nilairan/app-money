package com.helptoyou.appdengi.ui.news

import androidx.lifecycle.*
import com.github.terrakok.cicerone.Router
import com.helptoyou.appdengi.common.*
import com.helptoyou.appdengi.routing.Screens
import com.helptoyou.domain.model.News
import com.helptoyou.domain.usecase.GetAllNewsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.inject

@KoinApiExtension
class NewsViewModel : BaseViewModel() {

    private val getCardsUseCase: GetAllNewsUseCase by inject()
    private val router: Router by inject()

    private val _newsListLiveData = MutableLiveData<Event<List<News>>>()
    val newsListLiveData: LiveData<Event<List<News>>> = _newsListLiveData

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun fetchCards() {
        _newsListLiveData.postValue(Loading())
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val credits = getCardsUseCase.invoke()
                _newsListLiveData.postValue(Success(credits))
            } catch (e: Exception) {
                e.printStackTrace()
                _newsListLiveData.postValue(Error())
            }
        }
    }

    fun openNews(news: News) {
        router.navigateTo(Screens.NewsInfo(news))
    }

    fun onBackPressed() {
        router.exit()
    }
}