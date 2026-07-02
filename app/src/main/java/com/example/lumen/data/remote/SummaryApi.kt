package com.example.lumen.data.remote

import kotlinx.serialization.Serializable
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

@Serializable
data class Message(
    val role: String,
    val content: String
)
@Serializable
data class SummaryRequest(
    val model: String,
    val messages: List<Message>
)

@Serializable data class Choice(
    val message: Message
)

@Serializable
data class SummaryResponse(
    val choices: List<Choice>
)

interface SummaryApi {
    @POST("v1/chat/completions")
    suspend fun summarize(@Header("Authorization") authHeader: String,
                          @Body request: SummaryRequest    ): SummaryResponse
}