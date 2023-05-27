package com.example.legalline.data.utils

import android.content.Context
import androidx.compose.runtime.MutableState
import com.google.mlkit.nl.languageid.LanguageIdentifier
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.Locale
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun String.identifierLanguage(
    identifierLanguage: LanguageIdentifier,
    _language: MutableStateFlow<String>
) = suspendCoroutine { response ->
    identifierLanguage.identifyPossibleLanguages(this)
        .addOnSuccessListener { identifiedLanguages ->
            for (identifiedLanguage in identifiedLanguages) {
                if (identifiedLanguage.languageTag != "es" && _language.value == "es") {
                    response.resume(
                        "Soy un letrado español y no tengo conocimientos " +
                                "sobre otros idiomas, por favor hableme en español."
                    )
                    return@addOnSuccessListener
                } else if (identifiedLanguage.languageTag != "en" && _language.value == "en") {
                    response.resume(
                        "I am a English lawyer and I have no knowledge " +
                                "of other languages, please speak to me in English."
                    )
                    return@addOnSuccessListener
                }
            }
            response.resume(this)
        }
}

fun updateLanguage(context: Context, language: MutableState<Locale>){
    val recursos = context.resources
    val configuration = recursos.configuration
    configuration.setLocale(language.value)
    recursos.updateConfiguration(configuration, recursos.displayMetrics)
}

