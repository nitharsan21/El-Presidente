package Technic.Builder;

import Luncher.MainApp;
import Ressources.Island;
import Ressources.President;
import Technic.Tools.InputValue;

public class InitializePresident {
    /**
     * creating the president
     */
    public void initialize() {
        President elPresidente = new President();
        try{
            System.out.println("\nxxxxxxxxxxxxxxxxx				El Presidente					xxxxxxxxxxxxxxxxxxxxxx\n");

            String firstname = InputValue.getStringFor("\n Nom : ");
            elPresidente.setFirstName(firstname);

            String lastName = InputValue.getStringFor("\n Prenom : ");
            elPresidente.setLastName(lastName);

            int age = InputValue.getIntegerFor("\n Age : ");
            elPresidente.setAge(age);

            String sex = InputValue.getSexFor("\n Sexe (M/F): ");
            elPresidente.setSex(sex);

            MainApp.island.setElpresidente(elPresidente);

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
