package ua.javarush.io;

import java.io.*;

public class FileService {

    public static final int DEFAULT_BUFFER_CAPACITY = 32;
    private int bufferCapacity;

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
    public String createTargetFileName(){
        throw new UnsupportedOperationException();
    }
}
