package com.traderevolution.utils

import android.util.Xml
import com.traderevolution.data.Color
import org.xmlpull.v1.XmlPullParser
import java.io.InputStream

class XmlPullParserHandler {

    fun parse(inputStream: InputStream): List<Color> {
        val colorsList = mutableListOf<Color>()
        var color = Color()
        val parser: XmlPullParser = Xml.newPullParser()
        parser.setInput(inputStream, null)
        var eventType = parser.eventType
        while (eventType != XmlPullParser.END_DOCUMENT) {
            when (eventType) {
                XmlPullParser.START_TAG -> if (parser.name.equals("color")) {
                    color.name = parser.getAttributeValue(0)
                }
                XmlPullParser.TEXT -> {
                    color.code = parser.text
                }
                XmlPullParser.END_TAG  -> if (parser.name.equals("color")) {
                    colorsList.add(color)
                    color = Color()
                }

            }
            eventType = parser.next()
        }
        return colorsList
    }
}