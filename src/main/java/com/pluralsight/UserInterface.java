package com.pluralsight;


import java.util.ArrayList;

public class UserInterface {


    private static Dealership d;
    private static Console console = new Console();


    public static void display(){
        d  = DealershipFileManager.getDealership();


        int input;
        String homeScreenPrompt = """
                What do you want to do:\s
                 1 - Find vehicles within a price range\s
                 2 - Find vehicles by make / model\s
                 3 -  Find vehicles by year range
                 4 -  Find vehicles by color
                 5 -  Find vehicles by mileage range
                 6 -  Find vehicles by type (car, truck, SUV, van)
                 7 - List ALL vehicles
                 8 - Add a vehicle
                 9 - Remove a vehicle
                 0 - Quit
                Enter your command(number 1-9):\s""";


        do{
            input = console.promptForInt(homeScreenPrompt);
            switch (input){
                case 1: processGetByPriceRequest();
                break;
                case 2: processGetByMakeModelRequest();
                break;
                case 3: processGetByYearRequest();
                break;
                case 4: processGetByColorRequest();
                break;
                case 5: processGetByMileageRequest();
                break;
                case 6: processGetByVehicleTypeRequest();
                break;
                case 7: processGetByAllVehiclesRequest();
                break;
                case 8: processAddVehicleRequest();
                break;
                case 9: processRemoveVehicleRequest();
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


    public static void processGetByPriceRequest() {


        double min = console.promptForDouble("Input the minimum price: ");
        double max = console.promptForDouble("Input the maximum price: ");

        ArrayList<Vehicle> priceResult = d.getVehicleByPrice(min, max);


        if (priceResult.isEmpty()) {
            System.out.println("No Vehicles found within price range");
        } else {
            System.out.println("These are the vehicles found within" + " " + min + " and " + max);
            System.out.println(Vehicle.getFormattedHeader());
            for (Vehicle v : priceResult) {
                System.out.println(v.toString());
            }
        }


    }




    public static void processGetByMakeModelRequest(){

        String make = console.promptForString("Input Make you want to search for: ");
        String model = console.promptForString("Input Model you want to search for: ");

        ArrayList<Vehicle> makeModelResult = d.getVehicleByMakeModel(make, model);

        if(makeModelResult.isEmpty()){
            System.out.println("No Vehicles found within " +  make + " " + model);

        } else {
            System.out.println("These are the Vehicles found for this " + make + " " + model);
            System.out.println(Vehicle.getFormattedHeader());
            for(Vehicle v : makeModelResult){
                System.out.println(v.toString());
            }
        }

    }


    public static void processGetByYearRequest(){
            int year = console.promptForInt("Enter in a year: ");
            ArrayList<Vehicle> yearResult = d.getVehicleByYear(year);


            if(yearResult.isEmpty()){
                System.out.println("No Vehicle found for " + year);

            } else {
                System.out.println("These Vehicles are inside of this year: " + year);
                System.out.println(Vehicle.getFormattedHeader());
                for(Vehicle v : yearResult){
                    System.out.println(v.toString());
                }
            }






    }
    public static void processGetByColorRequest(){

        String color = console.promptForString("Enter in a color: ");
        ArrayList<Vehicle> colorResult = d.getVehicleByColor(color);


        if(colorResult.isEmpty()){
            System.out.println("No Vehicles of this color: " + color);
        } else {
            System.out.println("These are the Vehicles of this color: " + color);
            System.out.println(Vehicle.getFormattedHeader());
            for(Vehicle v : colorResult){
                System.out.println(v.toString());
            }
        }



    }
    public static void processGetByMileageRequest(){

        int startingMileage = console.promptForInt("Enter in the starting Mileage you want to search: ");
        int endingMileage = console.promptForInt("Enter in the ending Mileage you want to search: ");

        ArrayList<Vehicle> mileageResult = d.getVehicleByMileage(startingMileage,endingMileage);

        if(mileageResult.isEmpty()){
            System.out.println("No Vehicles have a mileage between these two numbers " + startingMileage + " " + endingMileage);
        } else {
            System.out.println("These Vehicles have a mileage between " + startingMileage + " " + endingMileage);
            System.out.println(Vehicle.getFormattedHeader());
            for(Vehicle v : mileageResult){
                System.out.println(v.toString());
            }
        }



    }

    public static void processGetByVehicleTypeRequest(){
        String type = console.promptForString("Enter Vehicle Type ");

        ArrayList<Vehicle> typeResult = d.getVehicleByType(type);

        if(typeResult.isEmpty()){
            System.out.println("There are no Vehicles with the type of " + type);
        } else {
            System.out.println("These are the Vehicles with the type of " + type);
            System.out.println(Vehicle.getFormattedHeader());
            for(Vehicle v : typeResult){
                System.out.println(v.toString());
            }
        }


    }

    public static void processGetByAllVehiclesRequest(){
        System.out.println("Here are all the vehicles");
        System.out.println(Vehicle.getFormattedHeader());

        for(Vehicle v : d.getAllVehicles()){
            System.out.println(v.toString());
        }

    }


    public static void processAddVehicleRequest(){
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
        d.addVehicle(vehicle);
        DealershipFileManager.saveDealership(d);

    }


    public static void processRemoveVehicleRequest(){

            System.out.println("Which Vehicle do you want to Remove?: ");
            int vin = console.promptForInt("Enter Vehicle's Vin number: ");

            ArrayList<Vehicle> choiceResult = d.getVehicleByVinNumber(vin);

            if(choiceResult.isEmpty()){
                System.out.println("No Vehicle....");

            } else {
                for(Vehicle vehicle : choiceResult){
                    d.removeVehicle(vehicle);
                    System.out.println(choiceResult + " Was Removed....");

                }
            }
            DealershipFileManager.saveDealership(d);













    }


}
