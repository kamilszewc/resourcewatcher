package io.github.kamilszewc.resourcewatcher.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Core class that simplifies the OS system calling.
 */
public class CommandCaller {

    /**
     * Call command
     * @param command os command
     * @return command response
     * @throws IOException if can not get information from os
     */
    static public String call(String command) throws IOException {
        return call(command, null);
    }

    /**
     * Call command with specific environmental variables
     * @param command os command
     * @param envVariables map of environmental variables (key, value)
     * @return command response
     * @throws IOException if can not get information from os
     */
    static public String call(String command, Map<String, String> envVariables) throws IOException {

        String[] splitCommand = command.split(" ");
        ProcessBuilder processBuilder = new ProcessBuilder(splitCommand);
        if (envVariables != null) {
            var env = processBuilder.environment();
            envVariables.forEach((key, value) -> {
                env.put(key, value);
            });
        }
        Process process = processBuilder.start();
        InputStream inputStream = process.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
