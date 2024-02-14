package ua.javarush.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandLineInterfaceImpl implements CommandLineInterface{
    @Override
    public void readParameters() {
        try(BufferedReader buffereReader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Type the path to file that has to be crypted");
            String path = buffereReader.readLine();
            System.out.println("Choose the desired option for procceding the text:/n [e]ncrypt  [d]ecrypt  [b]rute force");
            String option = buffereReader.readLine();
            if(!option.equals("b") || !option.equals("e") || !option.equals("d")) {
                System.out.println("Misspetl. Choose the option once again");
                option = buffereReader.readLine();
            }else if (option.equals("e") || option.equals("d")) {
                System.out.println();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
