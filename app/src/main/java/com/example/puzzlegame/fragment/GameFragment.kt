package com.example.puzzlegame.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.puzzlegame.R
import com.example.puzzlegame.adapter.PuzzleGameAdapter
import com.example.puzzlegame.databinding.FragmentGameBinding
import com.example.puzzlegame.model.CardModel


class GameFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val cardList = ArrayList<CardModel>()
    private val tempCardList = ArrayList<Int>()
    private lateinit var adapter: PuzzleGameAdapter
    private var score = 0

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.recyclerView


        adapter = PuzzleGameAdapter { position ->

            if ((score >= 0 || score < 10)) {
                tempCardList.add(position)
                cardList[position].isOpen = true

                Handler(Looper.getMainLooper()).postDelayed({
                    if (tempCardList.size == 2) {
                        if (cardList[tempCardList[0]].id == cardList[tempCardList[1]].id) {
                            cardList[tempCardList[0]].isOpen = true
                            cardList[tempCardList[0]].isImagesMatched = true
                            cardList[tempCardList[1]].isOpen = true
                            cardList[tempCardList[1]].isImagesMatched = true
                            score += 1
                            if (score == 10){
                                val scoreFragment = ScoreFragment()
                                activity?.supportFragmentManager?.beginTransaction()
                                    ?.replace(R.id.fragment, scoreFragment)?.commit()
                            }
                        } else {
                            cardList[tempCardList[0]].isOpen = false
                            cardList[tempCardList[0]].isImagesMatched = false
                            cardList[tempCardList[1]].isOpen = false
                            cardList[tempCardList[1]].isImagesMatched = false
                        }
                        tempCardList.clear()
                    }
                }, 10)

                adapter.submitList(null)
                adapter.submitList(cardList)
            }
        }


        initContent()

        adapter.submitList(cardList)
        val layoutManger = GridLayoutManager(context, 4)
        recyclerView.layoutManager = layoutManger
        recyclerView.adapter = adapter
    }


    private fun initContent() {
        cardList.apply {
            add(CardModel(1, R.drawable.polat))
            add(CardModel(2, R.drawable.abdulhey))
            add(CardModel(3, R.drawable.aslan))
            add(CardModel(4, R.drawable.duran))
            add(CardModel(5, R.drawable.elif))
            add(CardModel(6, R.drawable.erhan))
            add(CardModel(7, R.drawable.mehmet))
            add(CardModel(8, R.drawable.memati))
            add(CardModel(9, R.drawable.suleyman))
            add(CardModel(10, R.drawable.ziya))
            add(CardModel(1, R.drawable.polat))
            add(CardModel(2, R.drawable.abdulhey))
            add(CardModel(3, R.drawable.aslan))
            add(CardModel(4, R.drawable.duran))
            add(CardModel(5, R.drawable.elif))
            add(CardModel(6, R.drawable.erhan))
            add(CardModel(7, R.drawable.mehmet))
            add(CardModel(8, R.drawable.memati))
            add(CardModel(9, R.drawable.suleyman))
            add(CardModel(10, R.drawable.ziya))
        }
        cardList.shuffle()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



