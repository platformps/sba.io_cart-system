package com.github.perschola.utils;

/**
 * Created by leon on 8/24/2020.
 */

import java.io.File;

/**
 * @author leonhunter
 * @created 02/12/2020 - 8:58 PM
 * used to reference files from different one or more directories
 */
public enum DirectoryReference {
    RESOURCE_DIRECTORY(new StringBuilder()
            .append(System.getProperty("user.dir")) // local directory
            .append("/src/main/resources/")
            .toString());

    private final String path;

    DirectoryReference(String path) {
        this.path = path;
    }

    public File getDirectoryFile() {
        return new File(getDirectoryPath());
    }

    public String getDirectoryPath() {
        return path;
    }

    public File getFileFromDirectory(String fileName) {
        return new File(getDirectoryPath() + fileName);
    }
}