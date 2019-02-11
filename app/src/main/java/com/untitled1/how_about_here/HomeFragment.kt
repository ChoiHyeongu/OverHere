package com.untitled1.how_about_here


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.motivation.overhere.RecyclerViewDecoration

class HomeFragment : Fragment() {

    var curationList1: ArrayList<Curation> = arrayListOf()
    var curationList2: ArrayList<Curation> = arrayListOf()
    var curationList3: ArrayList<Curation> = arrayListOf()
    lateinit var curationRecyclerViewAdapter1: CurationRecyclerViewAdapter
    lateinit var curationRecyclerViewAdapter2: CurationRecyclerViewAdapter
    lateinit var curationRecyclerViewAdapter3: CurationRecyclerViewAdapter

    lateinit var list1: RecyclerView
    lateinit var list2: RecyclerView
    lateinit var list3: RecyclerView

    var opt = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        list1 = rootView.findViewById(R.id.home_curationView1)
        list2 = rootView.findViewById(R.id.home_curationView2)
        list3 = rootView.findViewById(R.id.home_curationView3)

        initView(1)
        initView(2)
        initView(3)

        return rootView
    }

    fun initView(opt: Int) {
        when (opt) {
            1 -> {
                curationRecyclerViewAdapter1 = CurationRecyclerViewAdapter(initData(opt), 1)
                list1.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
                list1.scrollToPosition(curationList1.size - 1)
                list1.addItemDecoration(RecyclerViewDecoration(25, opt))
                list1.adapter = curationRecyclerViewAdapter1
            }

            2 -> {
                curationRecyclerViewAdapter2 = CurationRecyclerViewAdapter(initData(opt), 1)
                list2.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
                list2.scrollToPosition(curationList2.size - 1)
                list2.addItemDecoration(RecyclerViewDecoration(25, opt))
                list2.adapter = curationRecyclerViewAdapter2
            }

            3->{
                curationRecyclerViewAdapter3 = CurationRecyclerViewAdapter(initData(opt), 2)
                list3.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                list3.addItemDecoration(RecyclerViewDecoration(25, opt))
                list3.adapter = curationRecyclerViewAdapter3
            }
        }
    }

    fun initData(opt: Int): ArrayList<Curation> {

        val text1 = "구디 맛집을 찾아서"
        val text2 = "한옥거리 데이트"
        val text3 = "롯데월드"
        var returnList = arrayListOf<Curation>()

        when (opt) {
            1 -> for (i in 1..10) {
                curationList1.add(Curation(R.mipmap.curation1, text1, "4시간 소요"))
                returnList = curationList1
            }
            2 -> for (i in 1..10) {
                curationList2.add(Curation(R.mipmap.curation2, text2, "6시간 소요"))
                returnList = curationList2
            }

            3 -> for (i in 1..10) {
                curationList3.add(Curation(R.mipmap.curation3, text3, "120m•자유 시간"))
                returnList = curationList3
            }
        }

        return returnList
    }
}
