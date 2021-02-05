import java.time.LocalDateTime

class Report {
    LocalDateTime localDateTime
    def value

    Report(value) {
        localDateTime = LocalDateTime.now()
        this.value = value
    }
}

