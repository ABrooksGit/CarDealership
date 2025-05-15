package com.pluralsight;


public class Main {
    public static void main(String[] args) {


       uiManagement();


    }




















    private static void uiManagement(){
        Console console = new Console();
        String password;

        System.out.println("Welcome to the Car Dealership");
        System.out.println("If you are an Admin, please sign in with your password");
        System.out.println("If you are a User, Just ignore the password and press Enter");
        System.out.println("If you want to quit please Enter the 0 key");
        do {
            System.out.println("If you are a User, Just ignore the password and press Enter");


            password = console.promptForString("Enter your password: ");

            if(password.equalsIgnoreCase("Admin")){
                System.out.println("Correct Password... Moving to Admin UI");

                AdminUserInterface UI = new AdminUserInterface();

                UI.displayMenu();



            } else if(password.isEmpty()){
                System.out.println("Moving to User Interface");

                UserInterface UI = new UserInterface();

                UI.displayMenu();
                break;
            } else if (password.equalsIgnoreCase("0")) {
                System.out.println("Quitting application...");
                break;

            } else {
                System.out.println("Wrong Password...");

            }

        } while(!password.equalsIgnoreCase("AdminPassword"));


    }

}







//        Vehicle vehicle = new Vehicle(10112,1993,"Ford","Explorer","SUV","Red",2750,31995.00);
//        SalesContract salescontract = new SalesContract("20210928", "Dana Wyatt", "dana@texas.com",  vehicle, vehicle.getPrice(), true);
//        SalesContract salesContractFalse = new SalesContract("20210928", "Dana Wyatt", "dana@texas.com", vehicle, vehicle.getPrice(), false);
//
//        LeaseContract leaseContract = new LeaseContract("20210928", "Zachary Westly","zach@texas.com",vehicle, vehicle.getPrice(), vehicle.getPrice());
//
//
//        System.out.println(salescontract);
//        System.out.println(salesContractFalse);
//
//        System.out.println(leaseContract);
