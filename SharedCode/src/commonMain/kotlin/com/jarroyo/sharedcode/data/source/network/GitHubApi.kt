package com.jarroyo.kotlinmultiplatform.source.network


import com.jarroyo.sharedcode.base.Response
import com.jarroyo.sharedcode.base.exception.NetworkConnectionException
import com.jarroyo.sharedcode.domain.model.github.GitHubRepo
import com.jarroyo.sharedcode.utils.networkSystem.isNetworkAvailable
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.url
import kotlinx.serialization.json.Json
import kotlinx.serialization.list

class GitHubApi {

    private val httpClient = HttpClient()

    suspend fun getGitHubRepoList(username: String): Response<List<GitHubRepo>> {
        return try {
            if (isNetworkAvailable()) {
                val url =
                    "https://api.github.com/users/${username}/repos"
                val json = httpClient.get<String>(url)
                val response = Json.nonstrict.parse(GitHubRepo.serializer().list, json)
                Response.Success(response)
            } else {
                Response.Error(NetworkConnectionException())
            }
        } catch (ex: Exception) {
            Response.Error(ex)
        }
    }
}