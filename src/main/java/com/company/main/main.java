package com.company.main;
import com.company.exceptions.UrlErrorException;
import org.apache.commons.validator.UrlValidator;

import java.util.Scanner;

public class main {
    public static void main(String[] args) throws UrlErrorException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ciao inserisci una URL valida: ");
        String url = sc.nextLine();

        //Controllo della URL
        UrlValidator urlValidator = new UrlValidator();

        try{
            if(urlValidator.isValid(url)){
                return;
            }
        }catch (Exception e) {
            if (!urlValidator.isValid(url)) {
                e.printStackTrace();
                throw new UrlErrorException("Inserisci una URL valida!");
            }
        }





        
    }
}
