package debugstudios.squeaky.app.ui.main

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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

