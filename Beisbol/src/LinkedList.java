/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LuisMarioR
 */
public class LinkedList {
        private Nodo first;
        
    public LinkedList(){
        first = null;
    }
    

    public Nodo getFirst() {
        return first;
    }
    

    public void setFirst(Nodo fir) {
             first = fir;
    }
    
    
        public void Add(Nodo nuevo) {
        if (first == null) {
            setFirst(nuevo);
        } else {
            Latest().setNext(nuevo);
        }

    }
        

    public Nodo Latest(){
        Nodo temp = first;
        while(temp != null){

        if(temp.getNext() == null){
            break;
    }
        else{ 
            temp = temp.getNext(); 
        }
    }
        return temp;
    }
    

    void AddBetweenNodos(Nodo nd, Nodo nuevo){
        nuevo.setNext(nd.getNext());
        nd.setNext(nuevo);
    }
    
    
    void AddFirst(Nodo nuevo){
        nuevo.setNext(first);
        setFirst(nuevo);
    }
    
    
    void Change(Nodo nod1, Nodo nod2){
        Nodo temp = new Nodo();
        temp.copiar(nod1); 
        nod1.copiar(nod2); 
        nod2.copiar(temp);
    }

    
    Nodo buscar(int ide){
    Nodo temp = first;
    while(temp != null){
        if(temp.getId() == ide){
            break;
        }
        else{
            temp = temp.getNext();
        }
    }
    return temp;
    }
    
    
    public void Delete(Nodo nd){
        Nodo anterior;
        if(nd == first){
        first = first.getNext();
    }
        else{
            anterior = first;
        while(anterior.getNext() != nd){
            anterior = anterior.getNext();
        }

        anterior.setNext(nd.getNext());
        }
        nd.setNext(null);
    }
    
    
    void OrganizeExchange(){
        Nodo ni;
        Nodo nj;
        ni = first;
    while(ni != null){
        nj = ni.getNext();
    while(nj != null){
    if(ni.promedio() < nj.promedio()){
        Change(ni,nj);
    }
        nj = nj.getNext();
    }
        ni = ni.getNext();
        }
    }
    
    
    public Nodo SearchLess(){
        Nodo temp = first;
        Nodo men= first;
        float menor=temp.promedio();
        while(temp != null){
            if(menor>temp.promedio()){
                menor=temp.promedio();
                men=temp;
            }
            else{
                temp = temp.getNext();
            }
        }
        return men;
    }
    
    
    public Nodo SearchHigher(){
        Nodo temp = first;
        Nodo may= first;
        float mayor=temp.promedio();
        while(temp != null){
            if(mayor<temp.promedio()){
                mayor=temp.promedio();
                may=temp;
            }
            else{
                temp = temp.getNext();
            }
        }
        return may;
        
    }   
    
    
    public float promAges(String pos){
        Nodo temp = first;
        int suma=0;
        int cont=0;
        while(temp != null){
            if(temp.getPosition().equals(pos)){
                suma=suma+temp.getAge();
                cont++;
            }
            temp = temp.getNext();            
        }
        if(cont==0){
            return 0;
        }
        float total=(float) suma/cont;
        return total;
    }
    
    
    public int countPos(String pos){
        Nodo temp = first;
        int cont=0;
        while(temp != null){
            if(temp.getPosition().equals(pos)){
                cont++;
            }
            temp = temp.getNext();            
        }
        return cont;
    }
    
    
}


