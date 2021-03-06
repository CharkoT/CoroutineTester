package kr.co.coroutinetester.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenResumed
import androidx.lifecycle.whenStarted
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.coroutines.launch
import kr.co.coroutinetester.R
import kr.co.coroutinetester.databinding.MainFragmentBinding
import kr.co.coroutinetester.ui.main.adapter.MainAdapter
import kr.co.coroutinetester.ui.main.viewmodel.MainViewModel

class MainFragment : Fragment() {

	init {
		lifecycleScope.launch {
			whenStarted {
				Log.d(this.javaClass.name, "MainFragment init setp~~~~(started)")
			}

			whenResumed {
				Log.d(this.javaClass.name, "MainFragment init setp~~~~(resumed)")
			}
		}
	}

	companion object {
		fun newInstance() = MainFragment()
	}

	private lateinit var viewModel: MainViewModel

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		Log.d(this.javaClass.name, "MainFragment onCreateView setp~~~~")

		val binding: MainFragmentBinding =
			DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)

		viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
		binding.viewmodel = viewModel
		binding.lifecycleOwner = this

		return binding.root
	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		viewLifecycleOwner.lifecycleScope.launch {
			Log.d(this.javaClass.name, "MainFragment onActivityCreated setp~~~~")
			rvItems.adapter = MainAdapter()
		}
	}
}
