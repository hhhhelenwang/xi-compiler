package util.edu.cornell.cs.cs4120.util;

import java.io.File;

/**
 * FileUtil: include utilities for file-related actions including building output file,
 * building the full directory to put the processed file in, and generating
 * target files.
 */
public class FileUtil {

    /**
     * Constructs a new target file
     *
     * @param fileName, filename to the source file
     * @param path, path to put the diagnostic file in
     * @param fileType, type of file produced
     *
     * @return targetFile
     */
    public static File generateTargetFile(String fileName, String path, String fileType){
        // build the full directory to put the lexed file in
        String[] dirs = fileName.split("/");
        String fullPath = path + "/";
        for (int i = 0; i < dirs.length - 1; i ++) {
            fullPath += dirs[i] + "/";
        }

        // build the name of the lexed file
        String file = dirs[dirs.length - 1];
        String processedFile;
        String end = file.substring(file.length()-3);
        if(end.equals(".xi")) {
            processedFile =file.substring(0,file.length()-3)  + "." + fileType;
        }else{
            processedFile =file.substring(0,file.length()-4)  + "." + fileType;
        }

        // check if directory to put the lexed file in exists, create a new dir if doesn't
        File directory = new File(fullPath);
        if (!directory.exists()) {
            directory.mkdir();
        }

        File targetFile = new File(fullPath + processedFile);

        return targetFile;
    }

}
