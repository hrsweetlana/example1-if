package ua.javarush.Controller;

import ua.javarush.io.FileService;

public class ApplicationController {
    private  final FileService fileService;

    public ApplicationController(FileService fileService) {
        this.fileService = fileService;
    }

    public void runApplication(){
        fileService.copyFromFileToFile("c:\\study\\source\\a.txt", "c:\\study\\source\\b.txt");
    }
}
