package com.huangjie.weather.ui.city

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.huangjie.weather.R
import com.huangjie.weather.adapter.CityAdapter
import com.huangjie.weather.base.BaseActivity
import com.huangjie.weather.databinding.ActivityChoiceCityBinding
import com.huangjie.weather.ui.city.viewmodel.CityViewModel
import com.huangjie.weather.utils.InjectUtils
import kotlinx.android.synthetic.main.layout_app_main.*

/**
 * @blame 黄杰
 * @version 2020-02-02 11:33
 * @author huangjie
 */

class ChoiceCityActivity : BaseActivity() {
    private lateinit var cityViewModel: CityViewModel

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
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        setSupportActionBar(mToolbar)
        val adapter = CityAdapter()
        binding.mRecycleCity.adapter = adapter
        subscribeUi(adapter)
    }

    private fun subscribeUi(adapter: CityAdapter) {
        cityViewModel.cityList.observe(this, Observer {
            adapter.submitList(it)
        })
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_city, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()

        }
        return super.onOptionsItemSelected(item)
    }


}