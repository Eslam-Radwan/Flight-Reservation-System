package edu.asu.mainPackage;

import java.io.Serializable;

public class Payment  implements Serializable {
    private static int previousPaymentId;
    private int paymentId;
    private double paymentAmount;
    private String paymentMethod;
    private boolean paymentState;
    private String cardNumber;
    private String cvv;
    private String expiryDate;

    public Payment( int numberOfPassengers, double priceOfClass) {
        paymentAmount = CalcPayment(numberOfPassengers, priceOfClass);
        paymentId = previousPaymentId + 1;
        previousPaymentId++;
    }

    //complete payment and make it valid :called in payment process
    public void ValidPayment(String paymentMethod,String cardNumber,String cvv ,String expiryDate){
        paymentState=true;
        this.paymentMethod=paymentMethod;
        this.cardNumber=cardNumber;
        this.cvv=cvv;
        this.expiryDate=expiryDate;
    }
    public double CalcPayment(int numberOfPassengers, double priceOfClass) {
        return numberOfPassengers * priceOfClass;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean isPaymentState() {
        return paymentState;
    }

    public void setPaymentState(boolean paymentState) {
        this.paymentState = paymentState;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public String getExpiryDate() {
        return expiryDate;
    }
}
