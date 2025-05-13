package com.pluralsight;


public class SalesContract extends Contract {

    private Vehicle v;
    private double salesTax =  0.05;
    private double recordingFee = 100 ;
    private double processingFee;
    private boolean finance;


    public SalesContract(String date, String customerName, String customerEmail, String vehicleSold, double totalPrice, double monthlyPayment, Vehicle v, double salesTax, double recordingFee, double processingFee, boolean finance) {
        super(date, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
        this.v = v;
        this.salesTax = salesTax;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.finance = finance;
    }


    public Vehicle getV() {
        return v;
    }

    public void setV(Vehicle v) {
        this.v = v;
    }



    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public boolean isFinance() {
        return finance;
    }


    @Override
    public double getTotalPrice() {
        double totalVehiclePrice = v.getPrice();
        double salesTax = totalVehiclePrice * this.salesTax;

        return totalVehiclePrice + salesTax + this.recordingFee;
    }

    @Override
    public double getMonthlyPayment() {

        return 0;
    }
}
