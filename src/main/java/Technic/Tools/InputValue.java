package Technic.Tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputValue {

    public static int getIntegerFor(String name){
        boolean actif = true;
        int result = 0;
        while(actif){
            try{
                System.out.print(name);
                result = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
                actif = false;
            }
            catch (NumberFormatException | IOException ex){
                System.out.println(DisplayStyle.ANSI_RED+" !!! - Entrez un nombre - !!! "+ DisplayStyle.ANSI_RESET);
                actif = true;
            }
        }
        return result;
    }


    public static double getDoubleFor(String name){
        boolean actif = true;
        double result = 0;
        while(actif){
            try{
                System.out.print(name);
                result = Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine());
                actif = false;
            }
            catch (NumberFormatException | IOException ex){
                System.out.println(DisplayStyle.ANSI_RED+" !!! - Entrez un nombre - !!! "+ DisplayStyle.ANSI_RESET);
                actif = true;
            }
        }
        return result;
    }

    public static String getStringFor(String name){
        boolean actif = true;
        String result = "";
        while(actif){
            try{
                System.out.print(name);
                result = new BufferedReader(new InputStreamReader(System.in)).readLine();
                if(result.equals("")){
                    throw new Exception();
                }
                actif = false;
            }
            catch (Exception ex){
                System.out.println(DisplayStyle.ANSI_RED+" !!! - Entrez une chaine de character"+ DisplayStyle.ANSI_RESET);
                actif = true;
            }
        }
        return result;
    }


    public static String getSexFor(String name){
        boolean actif = true;
        String result = "";
        while(actif){
            try{
                System.out.print(name);
                result = new BufferedReader(new InputStreamReader(System.in)).readLine();
                if(result.equals("")){
                    throw new Exception();
                }
                if(!result.equalsIgnoreCase("M") && !result.equalsIgnoreCase("F")){
                    throw new Exception();
                }
                actif = false;
            }
            catch (Exception ex){
                System.out.println(DisplayStyle.ANSI_RED+" !!! - Entrez une character (M/F)"+ DisplayStyle.ANSI_RESET);
                actif = true;
            }
        }
        return result;
    }


}
