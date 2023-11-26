package io.github.kamilszewc.resourcewatcher.watchers.macos;

import io.github.kamilszewc.resourcewatcher.watchers.interfaces.FilesWatcher;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesWatcherMac implements FilesWatcher {
    @Override
    public boolean isFileLocked(Path path) throws IOException, InterruptedException {

        if (!Files.exists(path)) {
            throw new FileNotFoundException();
        }

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("lsof", "-w", path.toString());
        try {
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
            if (exitCode == 0) return true;
            else return false;
        } catch (IOException | InterruptedException ex) {
            throw ex;
        }
    }
}
