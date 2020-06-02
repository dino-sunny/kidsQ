package com.dino.kidsq.game

import android.graphics.Color
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.dino.kidsq.R
import com.dino.kidsq.databinding.StartGameFragmentBinding
import kotlinx.android.synthetic.main.start_game_fragment.view.*

class StartGameFragment : Fragment() {
    private lateinit var binding : StartGameFragmentBinding

    companion object {
        fun newInstance() = StartGameFragment()
    }

    private lateinit var viewModel: StartGameViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: StartGameFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.start_game_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(StartGameViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.start_game.setOnClickListener {
            findNavController().navigate(R.id.startGame)
        }
        setStatusIconColors()
    }

    /**
     * Make status bar transparent
     */
    private fun setStatusIconColors() {
        activity?.window?.decorView?.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        activity?.window?.statusBarColor = Color.parseColor("#FF9800")
    }
}