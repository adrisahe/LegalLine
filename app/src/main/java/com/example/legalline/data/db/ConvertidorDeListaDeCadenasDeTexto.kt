package com.example.legalline.data.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class ConvertidorDeListaDeCadenasDeTexto {
    @TypeConverter
    fun fromMessages(messages: List<String>): String {
        return Gson().toJson(messages)
    }

    @TypeConverter
    fun toMessages(messagesString: String): List<String> {
        return Gson().fromJson(messagesString, object : TypeToken<List<String>>() {}.type)
    }
}