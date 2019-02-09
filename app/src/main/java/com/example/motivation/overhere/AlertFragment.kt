package com.example.motivation.overhere


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import AlertRecyclerviewAdapter


class AlertFragment : Fragment() {

    var alertList = arrayListOf<Alert>()
    lateinit var adapter: AlertRecyclerviewAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_alert, container, false)
        val list = rootView.findViewById<RecyclerView>(R.id.alert_recyclerview)
        list.layoutManager = LinearLayoutManager(activity)
        adapter = AlertRecyclerviewAdapter(initData1())
        list.adapter = adapter

        return rootView
    }

    fun initData1(): ArrayList<Alert> {
        for (i in 1..20) {
            alertList.add(Alert(R.drawable.photo2, "기리보이님께서 위치를 요챙했습니다.", "2019년 2월 10일 일요일"))
        }

        return alertList
    }
}
