package net.querix.api.language

interface Language {
    var languageId: String;

    /**
     * Get string value from language key.
     * If key will be null, we will get value from default
     * language, and then will return key
     *
     * key format: "namespace.key"
     */
    fun getString(key: String, vararg arguments: Any): String;

    /**
     * Get list value from language key.
     * If key will be null, we will get value from default
     * language, and then will return key
     *
     * If key is a String, we will create a Single-Row list
     *
     * key format: "namespace.key"
     */
    fun getList(key: String, vararg arguments: Any): List<String>;


    /**
     * Get string value from language key.
     * If key will be null, we will get value from default
     * language, and then will return key
     *
     * key format: "namespace.key"
     */
    fun getString(key: String): String;

    /**
     * Get list value from language key.
     * If key will be null, we will get value from default
     * language, and then will return key
     *
     * If key is a String, we will create a Single-Row list
     *
     * key format: "namespace.key"
     */
    fun getList(key: String): List<String>;

}