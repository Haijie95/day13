package haijie.workshop13.models;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class Contact {
    @NotNull(message = "Empty Name")
    @Size(min=3,max = 64,message = "Name must be between 3 and 64 characters")
    private String name;

    @Email(message = "Invalid Email!")
    private String email;

    @Min(value = 8,message = "Phone Number must be at least 8 digits")
    private int phoneNumber;
    
    //dont need to validate
    private String id;

    @Past(message = "Date of birth must be before today's date!")
    @NotNull(message = "Date of birth must be mandatory!")
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private LocalDate dateOfBirth;

    public Contact(){
        this.id=generateId(phoneNumber);
    }

    public Contact(String name, String email, int phoneNumber, LocalDate dob){
        this.name=name;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.dateOfBirth=dob;    }

    public Contact(String id, String name, String email, int phoneNumber){
        this.id=id;
        this.name=name;
        this.email=email;
        this.phoneNumber=phoneNumber;
    }

    public synchronized String generateId(int numOfChar){
        Random r = new Random();
        StringBuilder strBuilder = new StringBuilder();
        while(strBuilder.length()<numOfChar){
            strBuilder.append(Integer.toHexString(r.nextInt(numOfChar)));
        }
        return strBuilder.toString().substring(0, numOfChar);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
}
