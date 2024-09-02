package net.querix.api.language

import net.querix.api.Querix


/**
 * Utilities for working with the language system.
 * I dont quite understand why this is so, but everything is
 * according to the precepts of @MagicSweet
 */


/**
 * Find language [key] value for [user]
 */
fun lang(key: String, user: Any): String {
    return Querix.lookupService<LanguageService>().getUserLanguage(user).getString(key)
}

/**
 * Find language [key] value for [user]
 */
fun langList(key: String, user: Any): List<String> {
    return Querix.lookupService<LanguageService>().getUserLanguage(user).getList(key)
}

/**
 * Find language [key] value for [user]
 */
fun lang(key: String, user: Any, vararg arguments: Any): String {
    return Querix.lookupService<LanguageService>().getUserLanguage(user).getString(key, arguments)
}

/**
 * Find language [key] value for [user]
 */
fun langList(key: String, user: Any, vararg arguments: Any): List<String> {
    return Querix.lookupService<LanguageService>().getUserLanguage(user).getList(key, arguments)
}