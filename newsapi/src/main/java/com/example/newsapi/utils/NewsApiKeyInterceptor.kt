package com.example.newsapi.utils

import okhttp3.Interceptor
import okhttp3.Response

internal class NewsApiKeyInterceptor(private val apiKey: String) : Interceptor {
    @Suppress("SuspiciousIndentation")
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .url(
                chain.request().url.newBuilder()
                    .addQueryParameter("apiKey", apiKey)
                    .build()
            )
            .build()
        return chain.proceed(request)
    }
}
