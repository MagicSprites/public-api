package net.querix.api.language

// key names: <namespace>.<key>
interface LanguageService {
    /**
     * Method which downloads language from Tolgee, and than parse it all
     * intro our kotlin language system
     */
    fun downloadLanguages()

    /**
     * Find language by [id]
     */
    fun getLanguage(id: String): Language

    /**
     * Find every downloaded language
     */
    fun getLanguages(): Collection<Language>

    /**
     * Find every downloaded language ids
     */
    fun getLanguagesIds(): Collection<String>

    /**
     * Get a default language identifier, like "ru"
     */
    fun getDefaultLanguageId(): String

    /**
     * Getting the language [from] any user on any platform that we have
     */
    fun getUserLanguage(from: Any): Language
}