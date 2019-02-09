package com.example.motivation.overhere

import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_curation.*

class CurationFragment : Fragment() {

    var curationList: ArrayList<Curation> = arrayListOf()
    var curationList2: ArrayList<Curation> = arrayListOf()
    var curationList3: ArrayList<Curation> = arrayListOf()
    lateinit var adapter: CurationRecyclerviewAdapter
    lateinit var adapter2: CurationRecyclerviewAdapter
    lateinit var adapter3: CurationRecyclerviewAdapter
    var isClicked = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_curation, container, false)
        val list = rootView.findViewById<RecyclerView>(R.id.curation_list)
        val list2 = rootView.findViewById<RecyclerView>(R.id.curation_list2)
        val list3 = rootView.findViewById<RecyclerView>(R.id.curation_list3)
        list.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
        list2.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
        list3.layoutManager = LinearLayoutManager(activity)
        adapter = CurationRecyclerviewAdapter(initData1())
        adapter2 = CurationRecyclerviewAdapter(initData2())
        adapter3 = CurationRecyclerviewAdapter(initData3())
        list.adapter = adapter
        list2.adapter= adapter2
        list3.adapter= adapter3
        list.scrollToPosition(curationList.size - 1)
        list2.scrollToPosition(curationList2.size - 1)
        list.addItemDecoration(RecyclerViewDecoration(25))

        val plusFab = rootView.findViewById<FloatingActionButton>(R.id.fab_plus)
        val addFab  = rootView.findViewById<FloatingActionButton>(R.id.fab_add)
        val locationFab = rootView.findViewById<FloatingActionButton>(R.id.fab_location)
        plusFab.setOnClickListener {
            if(!isClicked){
                addFab.show()
                locationFab.show()
                isClicked = true
            } else {
                addFab.hide()
                locationFab.hide()
                isClicked = false
            }
        }

        return rootView
    }

    fun initData1(): ArrayList<Curation> {
        for (i in 1..10) {
            curationList.add(Curation(R.mipmap.photo, "구디 맛집을 찾아서", "4시간 소요"))
        }
        return curationList
    }

    fun initData2(): ArrayList<Curation> {
        for (i in 1..10) {
            curationList2.add(Curation(R.drawable.photo2, "한옥거리 데이트", "6시간 소요"))
        }
        return curationList2
    }

    fun initData3(): ArrayList<Curation> {
        for (i in 1..10) {
            curationList3.add(Curation(R.drawable.photo2, "한옥거리 데이트", "6시간 소요"))
        }
        return curationList3
    }




}
