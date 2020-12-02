package com.example.kijjapp;

public class Booking {
    private int id;
    private PetSitter petSitter;
    private PetOwner petOwner;
    private  String endDate;
    private  String startDate;
    private String status;
    private String[] ed;

    public Booking(){}

    public Booking(int id, PetSitter petSitter, PetOwner petOwner, String endDate, String startDate,String status) {
        this.id = id;
        this.petSitter = petSitter;
        this.petOwner = petOwner;
        this.endDate = endDate;
        this.startDate = startDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public PetSitter getPetSitter() {
        return petSitter;
    }

    public void setPetSitter(PetSitter petSitter) {
        this.petSitter = petSitter;
    }

    public PetOwner getPetOwner() {
        return petOwner;
    }

    public void setPetOwner(PetOwner petOwner) {
        this.petOwner = petOwner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public  int startToEnd()
    {
        String[] sd = startDate.split("-");
         ed = startDate.split("-");
        return Integer.parseInt(sd[3]) -Integer.parseInt(this.ed[3]) ;
    }
}
