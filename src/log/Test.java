package log;


import java.io.*;
import java.util.Scanner;

public class Test {

    static public void Inscription (){
        try {
            Boolean ok = false;
            String line = "";
            File fichier = new File("BD.txt");
            FileReader fileReader = new FileReader(fichier);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(fichier, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Donnez votre username");
            String username = scanner.next();


            while ((line = bufferedReader.readLine()) != null) {
                String[] nom = line.split("/");
                if (username.equals(nom[0])) {
                    ok=true;
                }
            }

            if(ok){
                System.out.println("Username deja utilisé, essayez un autre");
                Inscription();
            }
            else{

                System.out.println("Donnez un password");
                String password = scanner.next();
                System.out.println("Confirmez votre password");
                String passwordConfirm = scanner.next();

                while (!passwordConfirm.equals(password)) {
                    System.out.println("Confirmation incorrect ");
                    System.out.println("Confirmez votre password");
                    passwordConfirm = scanner.next();
                }

                bufferedWriter.write(username + "/" + password);
                bufferedWriter.newLine();

                System.out.println("Inscription réussie !");

            }


            bufferedWriter.close();
            fileWriter.close();
            scanner.close();


        }catch(IOException e){
            System.err.println("erreur : " + e.getMessage());
        }
    }

    static public void Connexion (){
        try{
            Boolean ok =false;
            String line = "";
            File fichier = new File("BD.txt");
            FileReader fileReader = new FileReader(fichier);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Donnez votre username");
            String username = scanner.next();
            System.out.println("Donnez un password");
            String password = scanner.next();

            while ((line = bufferedReader.readLine()) != null) {
                String[] nom = line.split("/");
                if(username.equals(nom[0]) && password.equals(nom[1]) ){
                    ok=true;
                    break;
                }
            }

            if(ok){
                System.out.println("Connexion réussie !");
            }else{
                System.out.println("Username ou password incorrect");
                Connexion();
            }

            scanner.close();
        }catch(IOException e){
            System.err.println("erreur : " + e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in) ;
        int choix = 0 ;
        System.out.println("Voulez vous vous inscrire ou vous connecter ");
        System.out.println("Pour vous inscrire tapez 1 , pour vous connecter tapez 2 ");
        choix = scanner.nextInt();
        while(choix != 1 && choix !=2) {
            System.out.println("Choix invalide");
            System.out.println("Pour vous inscrire tapez 1 , pour vous connecter tapez 2 ");
            choix = scanner.nextInt();
        }
        switch (choix) {
            case 1 :
                Inscription();
                break;
            case 2 :
                Connexion();
                break;
        }

    }

}
