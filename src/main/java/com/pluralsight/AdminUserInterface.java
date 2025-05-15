package com.pluralsight;

import java.util.ArrayList;

public class AdminUserInterface {


    private  ArrayList<Contract> c = new ArrayList<>();
    private final  Console console = new Console();


    private  void init(){
        c = ContractFileManager.getContracts();


    }

    public void displayMenu() {
        init();

        display();
    }

    private void displayContracts(ArrayList<Contract> contracts){

        for (Contract c : contracts){
            System.out.println(c);
        }



    }


    private void display(){

        int input;
        String homeScreenPrompt = """
                Welcome Admin What do you want to do:\s
                 1 - Make Vehicle Lease\s
                 2 - Make Vehicle Sale\s
                 3 - Display All\s
                 4 - Display Leases\s
                 5 - Display Sales\s
                 0 - Quit
                Enter your command(number 1-9):\s""";


        do{
            input = console.promptForInt(homeScreenPrompt);
            switch (input){
                case 1: processVehicleByLease();
                    break;
                case 2: processVehicleBySale();
                    break;
                case 3: displayAllContacts();
                    break;
                case 4:displayLease(c);
                    break;
                case 5:displaySales(c);
                    break;
                case 0:
                    System.out.println("Quitting...");
                    break;
                default:
                    System.out.println("Not a valid input");
                    break;
            }


        } while(input != 0);

    }




    private void displayLease(ArrayList<Contract> contracts){

        System.out.println(LeaseContract.getFormattedHeader());
        for(Contract contract : contracts){
            if(contract instanceof LeaseContract){
                System.out.println(contract);
            }
        }


    }

    private void displaySales(ArrayList<Contract> contracts){
        System.out.println(SalesContract.getFormattedHeader());
        for (Contract contract : contracts){
            if(contract instanceof  SalesContract){
                System.out.println(contract);
            }
        }


    }

    private void processVehicleByLease(){
        String date = console.promptForString("Enter the Date");
        String name = console.promptForString("Enter your name");
        String email = console.promptForString("Enter your email");
        System.out.println("Enter vehicle information");
        int vin = console.promptForInt("Enter VIN: ");
        int year = console.promptForInt("Enter Year: ");
        String  make = console.promptForString("Enter Make: ");
        String model = console.promptForString("Enter Model: ");
        String type = console.promptForString("Vehicle Type: ");
        String color = console.promptForString("Enter Color: ");
        int odometer = console.promptForInt("Enter Distance ");
        double price = console.promptForDouble("Enter Price: ");
        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        LeaseContract leaseContract = new LeaseContract(date, name, email, vehicle, vehicle.getPrice(), vehicle.getPrice());
        c.add(leaseContract);
        System.out.println(LeaseContract.getFormattedHeader());
        displayLease(c);
        ContractFileManager.saveContracts(leaseContract);
    }


    private void processVehicleBySale(){
        String date = console.promptForString("Enter the Date: ");
        String name = console.promptForString("Enter your name: ");
        String email = console.promptForString("Enter your email: ");
        System.out.println("Enter vehicle information: ");
        int vin = console.promptForInt("Enter VIN: ");
        int year = console.promptForInt("Enter Year: ");
        String  make = console.promptForString("Enter Make: ");
        String model = console.promptForString("Enter Model: ");
        String type = console.promptForString("Vehicle Type: ");
        String color = console.promptForString("Enter Color: ");
        int odometer = console.promptForInt("Enter Distance ");
        double price = console.promptForDouble("Enter Price: ");
        int finance = console.promptForInt("Do you want finance? Yes = 1. No = 0: ");
        boolean financeSelected = (finance == 1);
        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        SalesContract salesContract = new SalesContract(date, name, email, vehicle, vehicle.getPrice(), financeSelected);
        c.add(salesContract);
        System.out.println(SalesContract.getFormattedHeader());
        displaySales(c);
        ContractFileManager.saveContracts(salesContract);




    }

    private void displayAllContacts(){
        displayContracts(c);



    }



}
