package com.huangjie.weather.ui.city

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.huangjie.weather.R
import com.huangjie.weather.adapter.CityAdapter
import com.huangjie.weather.base.BaseActivity
import com.huangjie.weather.data.City
import com.huangjie.weather.databinding.ActivityChoiceCityBinding
import com.huangjie.weather.utils.InjectUtils
import com.huangjie.weather.viewmodels.CityViewModel
import kotlinx.android.synthetic.main.activity_choice_city.*
import kotlinx.android.synthetic.main.layout_app_main.*

/**
 * @blame 黄杰
 * @version 2020-02-02 11:33
 * @author huangjie
 */

class ChoiceCityActivity : BaseActivity() {
    private lateinit var cityViewModel: CityViewModel
    private lateinit var mAdapter: CityAdapter
    private lateinit var mCityList: List<City>

    companion object {

        fun launch(context: Context) {
            val intent = Intent(context, ChoiceCityActivity::class.java)
            context.startActivity(intent)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityChoiceCityBinding>(
            this,
            R.layout.activity_choice_city
        )
        cityViewModel =
            InjectUtils.providerCityViewModelFactory(this).create(CityViewModel::class.java)

        initView()
        mAdapter = CityAdapter()
        binding.mRecycleCity.adapter = mAdapter
        subscribeUi()
        loadData()
        initEvent()
    }


    /**
     * 处理点击事件
     */
    private fun initEvent() {
        mAdapter.itemClickListener = object : CityAdapter.ItemClickListener {
            override fun click(city: City?) {
                Toast.makeText(this@ChoiceCityActivity, city?.cityName, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadData() {
        cityViewModel.loadData()
    }

    private fun initView() {

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        setSupportActionBar(mToolbar)

        mRecycleCity.setHasFixedSize(true)
        mRecycleCity.setItemViewCacheSize(20)
        mRecycleCity.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
    }


    private fun subscribeUi() {
        cityViewModel.cityList.observe(this, Observer {
            mCityList = it
            mAdapter.submitList(it)
        })
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_city, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
            R.id.action_search -> {
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(object : OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        return false
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        filterData(newText)
                        return false
                    }
                })
            }
        }
        return super.onOptionsItemSelected(item)
    }


    /**
     * 数据过滤
     */
    private fun filterData(newText: String?) {
        if (!newText.isNullOrEmpty()) {
            val content = newText.toLowerCase()
            val dataList = ArrayList<City>()
            mCityList.stream()
                .filter({
                    it.cityName.contains(content) || it.cityNameEn.contains(content) || it.parent.contains(
                        content
                    ) || it.root.contains(content)
                }).forEach {
                    dataList.add(it)
                }
            mAdapter.submitList(dataList)
        }
    }


}