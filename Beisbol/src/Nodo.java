/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LuisMarioR
 */
    public class Nodo {
        
        private int id;
        private String name;
        private int age;
        private String position;
        private int bats;
        private int successful;
        private Nodo next;
    
        
    public void Nodo(){
        id = 0;
        name = "";
        age=0;
        position="";
        bats=0;
        successful=0;
        next = null;
    }
    

    public int getId() {
        return id;
    }
    

    public void setId(int id) {
        this.id = id;
    }
    

    public String getName() {
        return name;
    }
    

    public void setName(String name) {
        this.name = name;
    }
    

    public int getAge() {
        return age;
    }
    

    public void setAge(int age) {
        this.age = age;
    }
    

    public String getPosition() {
        return position;
    }
    

    public void setPosition(String position) {
        this.position = position;
    }
    

    public int getBats() {
        return bats;
    }
    

    public void setBats(int bats) {
        this.bats = bats;
    }

    
    public int getSuccessful() {
        return successful;
    }

    
    public void setSuccessful(int successful) {
        this.successful = successful;
    }
    

    public Nodo getNext() {
        return next;
    }
    

    public void setNext(Nodo next) {
        this.next = next;
    }
  
    

     public float promedio(){
        float prom =(float) successful/bats;
        return prom*100;
    }
     

    void copiar(Nodo nd){
        id = nd.id;
        name = nd.getName();
        age = nd.age;
        position=nd.position;
        bats=nd.bats;
        successful=nd.successful;
 }
    
    
}
