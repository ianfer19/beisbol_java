/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LuisMarioR
 */
import javax.swing.JOptionPane;

    public class Main { 
        
        

    public static void llenar(Nodo nod){
        int cod = Integer.parseInt(JOptionPane.showInputDialog("Por favor ingrese la Identificacion de Jugador"));
        nod.setId(cod);
        String nom = JOptionPane.showInputDialog("Por favor ingrese nombre del Jugador");
        nod.setName(nom);
        int ed = Integer.parseInt(JOptionPane.showInputDialog("Por favor ingrese la edad del Jugador: "));
        nod.setAge(ed);
        int pos = Integer.parseInt(JOptionPane.showInputDialog("Por favor ingrese la posición del Jugador: \n 1.pitcher \n 2.catcher \n 3.primera base \n 4.segunda base"
                + "\n 5.shortstop \n 6.jardinero"));
        while(pos>6 || pos<1){
            JOptionPane.showMessageDialog(null,"Por favor ingrese el numero de la posición");
            pos = Integer.parseInt(JOptionPane.showInputDialog("Por favor ingrese la posición del Jugador: \n 1.pitcher \n 2.catcher \n 3.primera base \n 4.segunda base"
                + "\n 5.shortstop \n 6.jardinero"));
        }
       nod.setPosition(Posit(pos));
  
        int bat = Integer.parseInt(JOptionPane.showInputDialog("Por favor ingrese la cantidad total de bateos del Jugador: "));
        nod.setBats(bat);
        int acert = Integer.parseInt(JOptionPane.showInputDialog("Por favor ingrese la cantidad de bateos acertados del Jugador: "));
        nod.setSuccessful(acert);
        
    }
    
    
    public static String Posit(int x){
        if(x==1){
            return "Pitcher";
        }
        if(x==2){
            return "Catcher";
        }
        if(x==3){
            return "Primera base";
        }
        if(x==4){
            return "Segunda base";
        }
        if(x==5){
            return "Shortstop";
        }else{
            return "Jardinero";
        }
    }
    
    
    
    public static void Show(Nodo nod){
        String datosNodo = "";
        datosNodo = datosNodo+String.valueOf(""+"IDENTIFICACION: "+nod.getId()+"\n"+"NOMBRE: "+nod.getName()+"\n"+"EDAD: "+nod.getAge()+"\n"+"Posición: "+nod.getPosition()+"\n"+"Bateos: "+nod.getBats()+"\n"+"Acertados: "+nod.getSuccessful()+"\n"+"Promedio: "+nod.promedio()+"%\n \n");
        JOptionPane.showMessageDialog(null, "=========== LISTA DE JUGADORES =========== \n"+ datosNodo);
    }
    
    
    public static void List(Nodo nod){
        Nodo temp = nod;
        while(temp != null){
            Show(temp);
            temp = temp.getNext();
        }
    }
    
    
    public static int Navigation(){
        int opcion = 0;
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog("=========== SELECCIONE UNA OPCIÓN =========== \n"+
                    "1. Agregar un jugador \n"+
                    "2. Agregar Entre Dos Nodos \n"+
                    "3. Agregar un jugador por la Cabeza \n"+
                    "4. Buscar la Información del jugador \n"+
                    "5. Eliminar jugador de la Lista \n"+
                    "6. Ordenar por mejor promedio \n"+
                    "7. Mostrar lista de jugadores \n"+
                    "8. Informe con promedio de edades por posición \n"+
                    "9. Listado discriminando por la posición de juego\n"+
                    "10. Mayor y menor promedio de bateo\n"+
                    "11. Cantidad de jugadores por posición\n"+
                    "0. Salir"+
                    "\n \nSeleccione una opción del 1 al 9: "));
        }
        while(opcion <0 || opcion > 11);
        return opcion;
    }
    
    
    public static void main(String[] args) {
        LinkedList lis = new LinkedList();
        int opcion, cod;
    Nodo aux;
    do
    {
    opcion = Navigation();
        switch(opcion) {
            case 1:
                aux = new Nodo();
                llenar(aux);
                lis.Add(aux);
                if(lis.getFirst() != null){
                List(lis.getFirst());
            }
                else
                {
                    JOptionPane.showMessageDialog(null, "La Lista Está Vacía...."); 
                }
                         break; 
            case 2: 
                          cod= Integer.parseInt(JOptionPane.showInputDialog("CODIGO del jugador Despues del que Quiere Agregar"));
                         Nodo nd = lis.buscar(cod);
                             if (nd !=null){
                                   aux = new Nodo();
                                   llenar(aux);
                                    lis.AddBetweenNodos(nd, aux);
                } 
                else{
                             JOptionPane.showMessageDialog(null, "El codigo del jugador NO EXISTE en la Lista");
                }
                        break;
            case 3: 
                aux=new Nodo();
                llenar(aux);
                lis.AddFirst(aux);
                         break;
            case 4:
                cod = Integer.parseInt(JOptionPane.showInputDialog("Digite CODIGO del jugador a Buscar: "));
                aux = lis.buscar(cod);
                    if(aux != null){
                Show(aux);
            }
                    else
                {
                JOptionPane.showMessageDialog(null, "La información del jugador No se encuentra en la lista");
                }
                         break; 
            case 5: 
                cod = Integer.parseInt(JOptionPane.showInputDialog("Digite CODIGO del jugador a Eliminar: "));
                aux = lis.buscar(cod);
                    if(aux != null){
                    lis.Delete(aux);
                    JOptionPane.showMessageDialog(null, "La información fue eliminada correctamente....");
                }
                    else
                {
                    JOptionPane.showMessageDialog(null, "El código del jugador NO EXISTE en la Lista");
                }
                         break;
            case 6:
                lis.OrganizeExchange();
                         break;
            case 7:
                if(lis.getFirst() != null){
                List(lis.getFirst());
            }
                else
                {
                    JOptionPane.showMessageDialog(null, "La Lista Está Vacía...."); 
                }
                          break;
            case 8:
                ReportOne(lis);
                          break;

            case 9:
                ReportTwo(lis);
                          break;
            case 10:
                JOptionPane.showMessageDialog(null, "El mayor promedio de bateo es:");
                Show(lis.SearchHigher());
                JOptionPane.showMessageDialog(null, "El menor promedio de bateo es:");
                Show(lis.SearchLess());
                          break;
            
            case 11:
                ReportThree(lis);
                          break;
            
            default:
                          break;
                
        }
    }
    while(opcion != 0);
    }
    
    public static void ReportOne(LinkedList lis){
        String mensaje="Promedio edades: \n Pitcher: "+lis.promAges("pitcher")+"\n catcher: "+lis.promAges("catcher")+"\n primera base: "+lis.promAges("primera base")
                +"\n segunda base: "+lis.promAges("segunda base")+"\n shortstop: "+lis.promAges("shortstop")+"\n jardinero: "+lis.promAges("jardinero");
        
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    public static void ReportTwo(LinkedList lis){

        JOptionPane.showMessageDialog(null,"Judadores en la posición de pitcher:");
        Nodo temp = lis.getFirst();
        while(temp != null){
            if(temp.getPosition().equals("pitcher")){
                Show(temp);
            }
            temp = temp.getNext();
        }

        JOptionPane.showMessageDialog(null,"Judadores en la posición de catcher:");
        temp = lis.getFirst();
        while(temp != null){
            if(temp.getPosition().equals("catcher")){
                Show(temp);
            }
            temp = temp.getNext();
        }

        JOptionPane.showMessageDialog(null,"Judadores en la posición primera base:");
        temp = lis.getFirst();
        while(temp != null){
            if(temp.getPosition().equals("primera base")){
                Show(temp);
            }
            temp = temp.getNext();
        }

        JOptionPane.showMessageDialog(null,"Judadores en la posición segunda base:");
        temp = lis.getFirst();
        while(temp != null){
            if(temp.getPosition().equals("segunda base")){
                Show(temp);
            }
            temp = temp.getNext();
        }
 
        JOptionPane.showMessageDialog(null,"Judadores en la posición de shortstop:");
        temp = lis.getFirst();
        while(temp != null){
            if(temp.getPosition().equals("Shortstop")){
                Show(temp);
            }
            temp = temp.getNext();
        }
 
        JOptionPane.showMessageDialog(null,"Judadores en la posición de jardinero:");
        temp = lis.getFirst();
        while(temp != null){
            if(temp.getPosition().equals("jardinero")){
                Show(temp);
            }
            temp = temp.getNext();
        }
        
    }
    
    
    public static void ReportThree(LinkedList lis){
        String mensaje="Jugadores por posición: \n Pitcher: "+lis.countPos("pitcher")+"\n catcher: "+lis.countPos("catcher")+"\n primera base: "+lis.countPos("primera base")
                +"\n segunda base: "+lis.countPos("segunda base")+"\n shortstop: "+lis.countPos("shortstop")+"\n jardinero: "+lis.countPos("jardinero");
        
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    
    
}
        

