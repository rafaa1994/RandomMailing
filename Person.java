package randomek;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rafał Stępień
 */
public class Person {
    
    private String name;
    private String address_email;
    private int number;
    
    public ArrayList<Person> persons = new ArrayList();
    
    public String getName(){
    return name;
    }

    public String getEmail(){
    return address_email;
    }
        
    public int getNumber(){
    return number;
    }
    
    public void setName( String name_){
    name = name_;
    }

    public void setEmail( String address_email_ ){
    address_email = address_email_ ;
    }
        
    public void setNumber( int number_ ){
    number = number_;
    }
    
    public Person(String name_, String address_email_, int number_){
    
    name = name_;
    address_email = address_email_;
    number = number_;
    
    }
        
    
    
}
