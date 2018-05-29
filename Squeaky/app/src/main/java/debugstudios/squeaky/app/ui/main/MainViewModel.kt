package debugstudios.squeaky.app.ui.main

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainViewModel : ViewModel(), LifecycleObserver {
    val testString = MutableLiveData<String>()

    fun someLongRunningFunction() {
        testString.value = "Test"
    }

    fun getTestString(): LiveData<String>{
        return testString
    }


}
