package io.github.kamilszewc.resourcewatcher.macos

import io.github.kamilszewc.resourcewatcher.watchers.interfaces.FilesWatcher
import io.github.kamilszewc.resourcewatcher.watchers.macos.FilesWatcherMac
import spock.lang.Specification

import java.nio.channels.FileChannel
import java.nio.channels.FileLock
import java.nio.file.Files
import java.nio.file.Path

class FilesWatcherMacTest extends Specification {

    private final static Path playgroundPath = Path.of("playground")
    private final static Path filePath = playgroundPath.resolve("file1.txt")

    def setupSpec() {
        if (!Files.exists(playgroundPath)) {
            Files.createDirectory(playgroundPath)
        }
    }

    def "FilesWatcherMac correctly detects file lock"() {
        given:
        createFileWithRandomContent(filePath)

        when:
        RandomAccessFile file = new RandomAccessFile(filePath.toString(), "rw")
        FileChannel channel = file.getChannel()
        FileLock lock = channel.lock()

        FilesWatcher filesWatcher = new FilesWatcherMac();

        then:
        filesWatcher.isFileLocked(filePath)

        lock.release()
        Files.delete(filePath)
    }


    private static void createFileWithRandomContent(Path path) {
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            bw.write("dfjdfiuhdhsidsnindsindsinciucn")
        }
    }
}
