package eu.integrable.linuxresourcewatcher.core

import java.time.LocalDateTime

class Report<T> {
    LocalDateTime localDateTime
    T value

    Report(value) {
        localDateTime = LocalDateTime.now()
        this.value = value
    }
}

