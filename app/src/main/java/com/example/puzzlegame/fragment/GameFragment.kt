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
                if (!(cardList[position].isOpen && cardList[position].isImagesMatched)) {
                    cardList[position] = cardList[position].copy(isOpen = true)
                    val indexList = cardList
                        .filter { (it.isOpen || (it.id == cardList[position].id)) && !it.isImagesMatched }
                        .map { cardList.indexOf(it) }

                    Handler(Looper.getMainLooper()).postDelayed({
                        if (indexList.size == 2) {
                            if (cardList[indexList[0]].imagePath == cardList[indexList[1]].imagePath) {
                                cardList[indexList[0]] = cardList[indexList[0]].copy(isOpen = true, isImagesMatched = true)
                                cardList[indexList[1]] = cardList[indexList[1]].copy(isOpen = true, isImagesMatched = true)
                                score += 1
                                if (score == 10) {
                                    val scoreFragment = ScoreFragment()
                                    activity?.supportFragmentManager?.beginTransaction()
                                        ?.replace(R.id.fragment, scoreFragment)?.commit()
                                }
                            } else {
                                cardList[indexList[0]] = cardList[indexList[0]].copy(isOpen = false, isImagesMatched = false)
                                cardList[indexList[1]] = cardList[indexList[1]].copy(isOpen = false, isImagesMatched = false)
                            }
                        } else {
                            cardList[indexList[0]] = cardList[indexList[0]].copy(isOpen = true, isImagesMatched = false)
                        }
                    }, 10)
                    adapter.submitList(cardList.toList())
                }
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
            add(CardModel(11, R.drawable.polat))
            add(CardModel(12, R.drawable.abdulhey))
            add(CardModel(13, R.drawable.aslan))
            add(CardModel(14, R.drawable.duran))
            add(CardModel(15, R.drawable.elif))
            add(CardModel(16, R.drawable.erhan))
            add(CardModel(17, R.drawable.mehmet))
            add(CardModel(18, R.drawable.memati))
            add(CardModel(19, R.drawable.suleyman))
            add(CardModel(20, R.drawable.ziya))
        }
        cardList.shuffle()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}





