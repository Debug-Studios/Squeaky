package debugstudios.squeaky.app.ui.main

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import dagger.Component
import javax.inject.Inject

class MainViewModel : ViewModel(), LifecycleObserver {
    @Inject lateinit var info : Info
    private var testString = MutableLiveData<String>()

    init {
        DaggerMagicBox.create().inject(this)
        testString.value = info.text
    }

    fun getTestString(): LiveData<String>{
        return testString
    }
}

class Info @Inject constructor(){
    val text = "Hello String"
}

@Component
interface MagicBox{
    fun inject(app: MainViewModel)
}

