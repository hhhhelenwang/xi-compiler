package jw795.util;

import java.io.File;
import java.util.Optional;

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
        return generateTargetFileWithFuncName(fileName, path, fileType, Optional.empty(), Optional.empty());
    }

    /**
     * Constructs a new target file
     *
     * @param fileName, filename to the source file
     * @param path, path to put the diagnostic file in
     * @param fileType, type of file produced
     * @param funcName, function name of the function for the generated file
     *
     * @return targetFile
     */
    public static File generateTargetFileWithFuncName(String fileName, String path,
                                                      String fileType, Optional<String> funcName,
                                                      Optional<String> phase) {
        // build the full directory to put the generated file in
        String[] dirs = fileName.split("/");
        String fullPath = path + "/";
        for (int i = 0; i < dirs.length - 1; i ++) {
            fullPath += dirs[i] + "/";
        }

        // build the name of the file
        String file = dirs[dirs.length - 1];
        String processedFile;
        String end = file.substring(file.length()-3);
        String xiFileName = file.substring(0,file.length()-3);
        String ixiFileName = file.substring(0,file.length()-4);
        String phaseName = phase.isPresent() ? "_" + phase.get() : "";
        String funName = funcName.isPresent() ? funcName.get(): "";

        if(end.equals(".xi")) {
            processedFile = xiFileName + funName + phaseName + "." + fileType;
        }else{
            processedFile = ixiFileName + funName + phaseName + "." + fileType;
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
