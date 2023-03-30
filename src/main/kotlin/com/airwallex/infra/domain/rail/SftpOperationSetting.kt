package com.airwallex.infra.domain.rail

data class SftpOperationSetting(
    val path: String,
    val filename: String?,
    /** the regular expression of filename to fuzzy filter the files in SFTP */
    val fileNameRegex: String?
)
