package com.computinglaboratory.resourcewatcher.watchers.interfaces;

import java.io.IOException;
import java.nio.file.Path;

/**
 * The class allows to get an information about files.
 */
public interface FilesWatcher {

    boolean isFileLocked(Path path) throws IOException, InterruptedException;
}
