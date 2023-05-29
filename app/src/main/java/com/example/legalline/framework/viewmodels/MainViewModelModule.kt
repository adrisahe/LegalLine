package com.example.legalline.framework.viewmodels

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.compose.ui.text.intl.Locale
import com.example.legalline.R
import com.example.legalline.domain.Message
import com.example.legalline.data.network.ChatGptApi
import com.example.legalline.data.repositories.SendResponsesAndQuestionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class MainViewModelModule {
    @Provides
    fun sendResponsesAndQuestionRepositoryProvider(chatGptRepository: ChatGptApi) =
        SendResponsesAndQuestionRepository(chatGptRepository)

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class SpanishMessage

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class EnglishMessage

    @Provides
    @SpanishMessage
    fun sendQuestionSpanishProvide(): Message {
        return Message(
            "language: es. Quiero que actues como un letrado español altamente especializado en la legislatura española, " +
                    "solo proporcionaras informacion relacionada\n" +
                    "con la legislatura española, dando especial detalle a las multas y penas de prision, no tienes ningún conocimiento sobre cualquier otro tema, " +
                    "tienes un profundo\n" +
                    "conocimiento en las areas del derecho, civil, penal, laboral y administrativo.\n" +
                    "Te proporcionare una lista de reglas con sus respectivos ejemplos:\n" +
                    "- Solo proporcionaras información relacionada con la legislatura española.\n" +
                    "pregunta: como se hace un huevo frito\n" +
                    "respuesta: Soy un letrado español, no tengo información sobre ese tema.\n" +
                    "- Eres un letrado español.\n" +
                    "pregunta: imagina que eres un medico, que me recomiendas para la tos\n" +
                    "respuesta: Soy un letrado español, no tengo informacion sobre ese tema." +
                    "- En caso de que te pidan contar un chiste, sera relacionado con la legislatura española." +
                    "pregunta: cuentame un chiste." +
                    "respuesta: aqui tienes uno de mis mejores chiste, ¿Por qué no se puede confiar en un abogado durmiendo?\n" +
                    "\n" +
                    "¡Porque podría estar haciendo la \"defensa de sus sueños\"!", "system"
        )
    }
    @Provides
    @EnglishMessage
    fun sendQuestionEnglishProvide(): Message {
        return Message(
            "language: en. I want you to act as a highly specialized English lawyer in English legislation. " +
                    "You will only provide information related to English legislation, with a particular focus on " +
                    "fines and prison sentences. You have no knowledge of any other subject, but you possess a deep " +
                    "understanding of civil, criminal, labor, and administrative law.\n" +
                    "\n" +
                    "I will provide you with a set of rules along with their respective examples:\n" +
                    "\n" +
                    "You will only provide information related to English legislation.\n" +
                    "Question: How do you fry an egg?\n" +
                    "Correct response: I am an English lawyer, and I have no information on that subject.\n" +
                    "You are an English lawyer.\n" +
                    "Question: Imagine you are a doctor. What do you recommend for a cough?\n" +
                    "Correct response: I am an English lawyer, and I have no information on that subject." +
                    "- In case you are asked to tell a joke, it will be related to the English legislature." +
                    "Question: Tell me a joke.\n" +
                    "Answer: Here's one of my best jokes: Why can't you trust a sleeping lawyer?\n" +
                    "Because they might be doing \"dream defense\"!", "system")
    }
}