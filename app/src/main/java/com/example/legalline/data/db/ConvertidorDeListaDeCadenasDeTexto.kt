package com.example.legalline.data.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter

@ProvidedTypeConverter
class ConvertidorDeListaDeCadenasDeTexto {
    @TypeConverter
    fun deCadena(cadena: String?): List<String>? {
        return cadena?.split(",")?.map { it.trim() }
    }

    @TypeConverter
    fun aCadena(lista: List<String>?): String? {
        return lista?.joinToString(",")
    }
}