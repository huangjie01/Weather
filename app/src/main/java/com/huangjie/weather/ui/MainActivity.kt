package com.huangjie.weather.ui

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import com.huangjie.weather.R
import com.huangjie.weather.base.BaseActivity
import com.huangjie.weather.databinding.ActivityMainBinding
import com.huangjie.weather.ui.city.ChoiceCityActivity
import com.huangjie.weather.utils.LogUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_app_main.*
import kotlinx.coroutines.*
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFullScreen()
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setSupportActionBar(mToolbar)
        initView()
        GlobalScope.launch {
            delay(1000)
            println("word")
        }
        println("hello ")

        CoroutineScope(Dispatchers.Main).launch {
            LogUtils.error("当前线程" + Thread.currentThread().name)
            val bitmap = withContext(Dispatchers.IO) {
                LogUtils.error("当前线程" + Thread.currentThread().name)
                getImage()
            }
            weather_icon_image_view.setImageBitmap(bitmap)
        }
    }

    private fun getImage(): Bitmap {
        val urlParams = URL("http://img4.imgtn.bdimg.com/it/u=1694681277,1453280371&fm=26&gp=0.jpg")
        val connection = urlParams.openConnection() as HttpURLConnection
          connection.requestMethod="GET"
        connection.connect()
        val inputStream: InputStream = connection.inputStream
        return BitmapFactory.decodeStream(inputStream)
        //inputStream.close()
    }


    /**
     * 全屏显示
     */
    private fun setFullScreen() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    private fun initView() {
        val toggle = ActionBarDrawerToggle(
            this,
            mDrawerLayout,
            mToolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        mDrawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_add_city -> {
                ChoiceCityActivity.launch(this)
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
