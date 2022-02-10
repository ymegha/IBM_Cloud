package org.example;

public class Customer {
    private int customerId;
    private String customerName;
    private String customerEmail;
    private Address address;
    public Customer() {

    }
    //Dependency Injection(Constructor)
    public Customer(Address address) {
        this.address = address;
    }
/*	public Customer(int customerId) {
		this.customerId = customerId;
	}
	public Customer(int customerId, String customerName, String customerEmail) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
	}*/

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Override
    public String toString() {

        return "Customer ID: " + customerId + " Customer Name: " + customerName + " Customer Email: " + customerEmail+" Address: \n"+address;
    }

}