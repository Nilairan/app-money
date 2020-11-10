package com.helptoyou.appdengi.ui.credits

import androidx.lifecycle.*
import com.github.terrakok.cicerone.Router
import com.helptoyou.appdengi.common.*
import com.helptoyou.domain.model.Credit
import com.helptoyou.domain.usecase.GetCreditsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.inject

@KoinApiExtension
class CreditsViewModel : BaseViewModel() {
    private val getCreditsUseCase: GetCreditsUseCase by inject()
    private val router: Router by inject()

    private val _creditsListLiveData = MutableLiveData<Event<List<Credit>>>()
    val creditsListLiveData: LiveData<Event<List<Credit>>> = _creditsListLiveData

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun fetchCredits() {
        _creditsListLiveData.postValue(Loading())
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val credits = getCreditsUseCase.invoke()
                _creditsListLiveData.postValue(Success(credits))
            } catch (e: Exception) {
                e.printStackTrace()
                _creditsListLiveData.postValue(Error())
            }
        }
    }

    fun onBackPressed() {
        router.exit()
    }
}