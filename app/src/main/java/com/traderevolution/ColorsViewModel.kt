package com.traderevolution

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.traderevolution.data.Color
import com.traderevolution.utils.XmlPullParserHandler


class ColorsViewModel(application: Application) : AndroidViewModel(application) {

    private lateinit var colors: MutableLiveData<List<Color>>

    fun getColors(): LiveData<List<Color>> {

        if (!::colors.isInitialized) {
            colors = MutableLiveData()
            loadColors()
        }

        return colors
    }

    private fun loadColors() {
        val inputStream = getApplication<Application>().resources.openRawResource(R.raw.colors)
        colors.value = XmlPullParserHandler().parse(inputStream)
    }
}