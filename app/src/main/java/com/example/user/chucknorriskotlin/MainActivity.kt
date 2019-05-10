package com.example.user.chucknorriskotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.example.user.chucknorriskotlin.Model.ChuckNorrisInterface
import com.example.user.chucknorriskotlin.Model.NeverEndingPojo
import com.example.user.chucknorriskotlin.View.JokeAdapter
import com.example.user.chucknorriskotlin.View.TabAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_never_ending.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(){

    private val TAG = MainActivity::class.java.simpleName

    private val BASE_URL = "http://api.icndb.com/jokes/"

    private var mCompositeDisposable: CompositeDisposable? = null

    private var mJokeArrayList: NeverEndingPojo? = null

    private var mAdapter: JokeAdapter? = null

    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)

        tabLayout!!.addTab(tabLayout!!.newTab().setText("Random Joke"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Change Character"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("List of Jokes"))
        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = TabAdapter(this, supportFragmentManager, tabLayout!!.tabCount)
        viewPager!!.adapter = adapter

        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

    }


}
