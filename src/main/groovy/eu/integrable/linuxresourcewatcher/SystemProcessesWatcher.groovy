package eu.integrable.linuxresourcewatcher

class SystemProcessesWatcher {

    Report<Long> getNumberOfProcesses() {
        def value = new ProcessCommand("ps -eo nlwp").by {
            def sum = 0
            def lines = it.split("\n")
            for (int i=1; i<lines.size(); i++) {
                def line = lines[i]
                sum += Integer.valueOf(line.trim())
            }
            sum
        }
        return new Report<Long>(value)
    }

}
