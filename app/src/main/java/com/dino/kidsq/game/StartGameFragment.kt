package com.dino.kidsq.game

import android.graphics.Color
import android.os.Bundle
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.dino.kidsq.R
import com.dino.kidsq.database.PlayerDao
import com.dino.kidsq.database.PlayerDatabase
import com.dino.kidsq.database.PlayerDatabase.Companion.getInstance
import com.dino.kidsq.databinding.StartGameFragmentBinding

class StartGameFragment : Fragment() {
    private lateinit var binding: StartGameFragmentBinding

    companion object {
        fun newInstance() = StartGameFragment()
    }

    private lateinit var viewModel: StartGameViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.start_game_fragment, container, false)
        setStatusIconColors()

        val application = requireNotNull(this.activity).application
        val dataSource = PlayerDatabase.getInstance(application).playerDao

        val viewModelFactory = StartGameViewModelFactory(dataSource, application)

        val viewModel =
            ViewModelProvider(this, viewModelFactory).get(StartGameViewModel::class.java)

//        viewModel = ViewModelProvider(this).get(StartGameViewModel::class.java)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.startGameViewModel = viewModel

        viewModel.startGame.observe(viewLifecycleOwner, Observer { isStarted ->
            if (isStarted) gameStarted()
        })

        viewModel.highScore.observe(viewLifecycleOwner, Observer { highScore ->
            Toast.makeText(activity, "" + highScore?.userName, Toast.LENGTH_LONG).show()
        })

        return binding.root
    }

    private fun gameStarted() {
        findNavController().navigate(R.id.startGame)
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
