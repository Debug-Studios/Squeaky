package debugstudios.squeaky.app.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import debugstudios.squeaky.app.R
import debugstudios.squeaky.app.databinding.MainFragmentBinding

class MainFragment : androidx.fragment.app.Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val binding : MainFragmentBinding = DataBindingUtil.
                inflate(inflater, R.layout.main_fragment, container, false)
        binding.setLifecycleOwner(this)
        binding.mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        lifecycle.addObserver(viewModel)
        viewModel.getTestString().observe(this, Observer { test ->  Log.d("TEST", test) })

    }

}
