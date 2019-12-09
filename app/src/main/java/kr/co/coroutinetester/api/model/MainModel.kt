package kr.co.coroutinetester.api.model

data class MainModel(
    var login: String? = null,
    var id: Int? = null,
    var node_id: String? = null,
    var avatar_url: String? = null,
    var gravatar_id: String? = null,
    var url: String? = null,
    var html_url: String? = null,
    var followers_url: String? = null,
    var following_url: String? = null,
    var gists_url: String? = null,
    var starred_url: String? = null,
    var subscriptions_url: String? = null,
    var organizations_url: String? = null,
    var repos_url: String? = null,
    var events_url: String? = null,
    var received_events_url: String? = null,
    var type: String? = null,
    var site_admin: Boolean? = null,
    var score: Double? = null
)

/**
 * login
 * id
 * node_id
 * avatar_url
 * gravatar_id
 * url
 * html_url
 * followers_url
 * following_url
 * gists_url
 * starred_url
 * subscriptions_url
 * organizations_url
 * repos_url
 * events_url
 * received_events_url
 * type
 * site_admin
 * score
 */