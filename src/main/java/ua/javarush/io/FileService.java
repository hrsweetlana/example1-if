package ua.javarush.io;

import ua.javarush.options.Option;

import java.io.*;
import java.nio.file.Path;

public class FileService {

    public static final int DEFAULT_BUFFER_CAPACITY = 32;
    private int bufferCapacity;
    private String filePath;

    public FileService(){
        this.bufferCapacity = DEFAULT_BUFFER_CAPACITY;
    }

    public FileService(int bufferCapacity){
        if(bufferCapacity < 0){
            throw new IllegalArgumentException("Buffer capacity should be possitive value, current value: " + bufferCapacity);
        }
        this.bufferCapacity = Math.max(DEFAULT_BUFFER_CAPACITY, bufferCapacity);
    }
    public void copyFromFileToFile(String sourceFileName, String targetFileName){
        File sourceFile = new File(sourceFileName);
        File targetFile = new File(targetFileName);

        //TODO: Files.isRegularFile(Path.of(sourceFileName));

        try(InputStream inputStream = new FileInputStream(sourceFileName);
            OutputStream outputStream = new FileOutputStream(targetFileName)){
            int numberOfBytes;
            byte[] buffer = new byte[bufferCapacity];
            while((numberOfBytes = inputStream.read(buffer)) != -1){
                System.out.println(new String(buffer, 0, numberOfBytes));
                outputStream.write(buffer, 0, numberOfBytes);
            }
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
    /*     1) "c:\\study\\source\\a.txt" ENCODE      ---> c:\\study\\source\\a.txt_ENCODE.txt
           2) "c:\\study\\source\\a.txt" DECODE      ---> c:\\study\\source\\a.txt_DECODE.txt
           3) "c:\\study\\source\\a.txt" BRUTE_FORCE ---> c:\\study\\source\\a.txt_BRUTE_FORCE.txt
    */
    public String createTargetFileName(Path path, Option option){
        String fileName = path.getFileName().toString();
        String directoryName = path.getParent().toString();

        switch(option){
            case ENCRYPT : return "1";
            case DECRYPT : return "2";
            case BRUTE_FORCE : return "3";
        }
        throw new UnsupportedOperationException();
    }
}
