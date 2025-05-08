package com.pluralsight;

import java.util.ArrayList;


public class Dealership {
    private String name;
    private String address;
    private String phone;

    private static ArrayList<Vehicle> inventory;
    private static Console console = new Console();


    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }


    public ArrayList<Vehicle> getVehicleByPrice(double min , double max){
        ArrayList<Vehicle>endResult = new ArrayList<>();
            for(Vehicle v : inventory){
               if(v.getPrice() >= min && v.getPrice() <= max){
                   endResult.add(v);
                }
            }
            return endResult;

    }
    public ArrayList<Vehicle> getVehicleByMakeModel(String make, String model){
        ArrayList<Vehicle>endResult = new ArrayList<>();
        for(Vehicle v : inventory){
            if(v.getMake().equalsIgnoreCase(make)){
                endResult.add(v);
            }
        }

        for (Vehicle v : inventory){
            if (v.getModel().equalsIgnoreCase(model)){
                endResult.add(v);
            }
        }

        return endResult;


    }
    public ArrayList<Vehicle> getVehicleByYear(int year){
        ArrayList<Vehicle>endResult = new ArrayList<>();
        for ( Vehicle v : inventory){
            if(v.getYear() == year){
                endResult.add(v);
            }
        }
        return endResult;


    }
    public ArrayList<Vehicle> getVehicleByColor(String color){
        ArrayList<Vehicle>endResult = new ArrayList<>();
        for(Vehicle v : inventory){
            if(v.getColor().equalsIgnoreCase(color)){
                endResult.add(v);
            }
        }

        return endResult;
    }
    public ArrayList<Vehicle> getVehicleByMileage(int min, int max){
        ArrayList<Vehicle>endResult = new ArrayList<>();
        for(Vehicle v : inventory){
            if(v.getOdometer() >= min && v.getOdometer() <= max){
                endResult.add(v);
            }
        }


        return endResult;

    }
    public ArrayList<Vehicle> getVehicleByType(String type){
        ArrayList<Vehicle>endResult = new ArrayList<>();
        for(Vehicle v : inventory){
            if(v.getVehicleType().equalsIgnoreCase(type)){
                endResult.add(v);
            }
        }



        return endResult;
    }
    public ArrayList<Vehicle> getAllVehicles(){
        return inventory;
    }

    public static void addVehicle(Vehicle vehicle){

        inventory.add(vehicle);




    }

    public static void removeVehicle(Vehicle vehicle){

        inventory.remove(vehicle);
    }



}
