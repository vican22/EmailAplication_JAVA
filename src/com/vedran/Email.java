package com.vedran;

import java.util.Scanner;

public class Email {
   private String firstName;
   private String lastName;
   private String email;
   private String password;
   private int defaultPasswordLength = 10;
   private String department;
   private int mailboxCapacity = 500;
   private String alternateEmail;

   private String companySuffix = ".aeycompany.com";

   //Contstructor to recive the first name and last name

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;


        //Call a method asking for the department
        this.department = setDepartment();


        //Call a method that returns random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("PASSWORD: " + this.password);

        //Combine elements to generate email
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + companySuffix;

    }


    //Ask for department
    private String setDepartment(){
        System.out.print("New worker: " + this.firstName +  ". DEPARMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner sc = new Scanner(System.in);
        int depChoice = sc.nextInt();

        if(depChoice == 1){
            return "sales";
        } else if (depChoice == 2){
            return "dev";
        } else if (depChoice == 3){
            return "acct";
        }else {
            return "";
        }
    }
    //Generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPRSTUWXYZ0123456789!@#$%";
        char[] password = new char[length];

        for(int i = 0; i < length; i++){
           int rand = (int)(Math.random() * passwordSet.length());
           password[i] = passwordSet.charAt(rand);
        }

        return new String(password);
    }
    //Set the mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    //Set the alternate email
    public void setAlternateEmail(String alternateEmail){
        this.alternateEmail = alternateEmail;
    }
    //Change the password
    public void  changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity(){
        return this.mailboxCapacity;
    }

    public String getAlternateEmail(){
        return this.alternateEmail;
    }

    public String getPassword(){
        return this.password;
    }

    public String showInfo(){
        return "DISPLAY NAME: " + this.firstName + " " + this.lastName +
                "\nCOMPANY EMAIL: " + this.email +
                "\nMAILBOX CAPACITY " + this.mailboxCapacity + "mb";
    }
}
