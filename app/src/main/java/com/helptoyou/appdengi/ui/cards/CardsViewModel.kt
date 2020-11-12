package com.helptoyou.appdengi.ui.cards

import androidx.lifecycle.*
import com.github.terrakok.cicerone.Router
import com.helptoyou.appdengi.common.*
import com.helptoyou.appdengi.routing.Screens
import com.helptoyou.domain.model.Card
import com.helptoyou.domain.usecase.GetCardsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.inject

@KoinApiExtension
class CardsViewModel : BaseViewModel() {
    private val getCardsUseCase: GetCardsUseCase by inject()
    private val router: Router by inject()

    private val _cardsListLiveData = MutableLiveData<Event<List<Card>>>()
    val cardsListLiveData: LiveData<Event<List<Card>>> = _cardsListLiveData

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun fetchCards() {
        _cardsListLiveData.postValue(Loading())
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val credits = getCardsUseCase.invoke()
                _cardsListLiveData.postValue(Success(credits))
            } catch (e: Exception) {
                e.printStackTrace()
                _cardsListLiveData.postValue(Error())
            }
        }
    }

    fun onOpenUrl(url: String) {
        router.navigateTo(Screens.GoogleUrl(url))
    }

    fun onBackPressed() {
        router.exit()
    }
}