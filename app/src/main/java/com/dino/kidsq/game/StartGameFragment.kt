package com.dino.kidsq.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.dino.kidsq.R
import com.dino.kidsq.database.PlayerDatabase
import com.dino.kidsq.databinding.StartGameFragmentBinding
import com.dino.kidsq.questions.QuestionsFragmentDirections
import com.dino.kidsq.utils.Utils

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
        activity?.let { Utils.setStatusIconColors(it,"#FF9800") }

        val application = requireNotNull(this.activity).application
        val dataSource = PlayerDatabase.getInstance(application).playerDao

        val viewModelFactory = StartGameViewModelFactory(dataSource, application)

        val viewModel =
            ViewModelProvider(this, viewModelFactory).get(StartGameViewModel::class.java)

//        viewModel = ViewModelProvider(this).get(StartGameViewModel::class.java)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.startGameViewModel = viewModel

        viewModel.startGame.observe(viewLifecycleOwner, Observer { isStarted ->
            if (isStarted) {
                gameStarted()
            }else{
                showError()
            }
        })

//        viewModel.highScore.observe(viewLifecycleOwner, Observer { highScore ->
//            Toast.makeText(activity, "" + highScore?.userName, Toast.LENGTH_LONG).show()
//        })

        return binding.root
    }

    private fun showError() {
        Toast.makeText(activity,"Enter a Player Name",Toast.LENGTH_SHORT).show()
    }

    private fun gameStarted() {
        findNavController().navigate(StartGameFragmentDirections.startGame(binding.editTextTextPersonName.text.toString(),"1"))
    }


}
