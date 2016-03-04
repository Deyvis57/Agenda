//Sustentación Practica 1 Programacion 
//Deyvis Negrete Angulo

package agenda;

import java.util.Scanner;

public class Agenda {
    
    public static void main(String[] args) {
        //PersonalData Datos = new PersonalData(); //Almacena Una persona
        Personal Datos[] = new Personal[100]; //Almacena 100 personas
         Prestamo Datos1[] = new Prestamo[100]; //Almacena 100 personas
        Scanner lector = new Scanner (System.in);
        int opc=0,modulo=0, contUs=0,contLS=0,band=0;  //contUs me permite saber cuantos usuarios hay en el sistema
        String name; //variable para actualizar, eliminar y buscar
         
       

                     do{
                     System.out.println("1. GESTION DE LIBROS ");
                     System.out.println("2. GESTION DE PRESTAMOS ");
                     System.out.println("3. SALIR ");
    
            modulo = lector.nextInt();
         switch(modulo){
        case 1:
                     System.out.println("Seleccione una opcion: ");

        do{
            System.out.println("\nMENU PRINCIPAL"); 
            System.out.println("1. Ingresar Libro");
            System.out.println("2. Actualizar Libro");
            System.out.println("3. Eliminar Libro");
            System.out.println("4. Buscar Libro");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opc = lector.nextInt();
            
            switch (opc) {
                case 1:
                    if (contUs<99){
                        Datos[contUs] = new Personal();
                       
                        System.out.println("\nINGRESO DE LIBROS");
                        System.out.print("Digite el nombre del Libro: ");
                        Datos[contUs].setnombre(lector.next());
                        System.out.print("Digite el autor: ");
                        Datos[contUs].setautor(lector.next());
                        System.out.print("Digite el año de publicación: ");
                        Datos[contUs].setFecha(lector.next());
                        System.out.print("Digite codigo: ");
                        Datos[contUs].setcodigo(lector.next());
                        System.out.print("Digite cantidad: ");
                        Datos[contUs].setcantidad(lector.nextInt());
                        System.out.print("Digite el nombre del area: química, física, tecnología, cálculo o programación: ");
                        Datos[contUs].setAreas(lector.next());  
                        contUs++;
                    }
                    else
                        System.out.println("NO HAY MAS MEMORIA");
                    break;
                case 2:
                        System.out.println("\nACTUALIZAR DATOS ");
                        System.out.print("Digite el nombre del libro a actualizar: ");
                        name = lector.next();
                        for (int i=0; i<contUs;i++){
                            if (name.equals(Datos[i].getnombre())){
                                band=1;
                                System.out.print("Digite el autor: ");
                                Datos[i].setautor(lector.next());
                                System.out.print("Digite cantidad: ");
                                Datos[i].setcantidad(lector.nextInt());
                                System.out.print("Digite el nombre del area: química, física, tecnología, cálculo o programación: ");
                                Datos[i].setAreas(lector.next());  
                            }
                        }
                        if(band==0)
                            System.out.println("\nLIBRO NO ENCONTRADO");
                        else
                            band=0;             
                    break;
                case 3:
                                          System.out.println("\nELIMINAR  LIBRO ");
                        System.out.print("Digite el nombre del libro a eliminar: ");
                        name = lector.next();
                        for (int i=0; i<contUs;i++){
                            if (name.equals(Datos[i].getnombre())){
                                band=1;
                                System.out.println("Los Datos del libro: "+name+ " se han eliminado: ");
                                Datos[i].setnombre("");
                                Datos[i].setautor("");
                                Datos[i].setFecha("");
                                Datos[i].setcodigo("");
                                Datos[i].setcantidad(0);
                                Datos[i].setAreas("");

                                 
                            }
                        }
                        if(band==0)
                            System.out.println("\nLIBRO NO ENCONTRADO");
                        else
                            band=0;  
                    break;
                case 4:
                      System.out.println("\nBUSCAR LIBRO ");
                        System.out.print("Digite el nombre del libro a buscar: ");
                        name = lector.next();
                        for (int i=0; i<contUs;i++){
                            if (name.equals(Datos[i].getnombre())){
                                band=1;
                                System.out.println("Los Datos del libro que busca son: ");
                                System.out.println("Nombre: "+Datos[i].getnombre());
                                 System.out.println("Autor: "+Datos[i].getautor());
                                 System.out.println("Año de publicación: "+Datos[i].getFecha());
                                 System.out.println("Codigo: "+Datos[i].getcodigo());
                                 System.out.println("Dirección: "+Datos[i].getcantidad());
                                 System.out.println("Area: "+Datos[i].getAreas());
                                 
                            }
                        }
                        if(band==0)
                            System.out.println("\nUSUARIO NO ENCONTRADO");
                        else
                            band=0;   
                    break;
                case 5:
                    break;

                default:
                    System.out.println("\nOPCION INCORRECTA!\n");
                    break;                              
            }
        }while(opc!=5);
        break;
        case 2:
        //******************************************
        // GESTION DE PRESTAMOS
            do{
             System.out.println("1. PRESTAR LIBROS ");
             System.out.println("2. DEVOLVER LIBROS ");
             System.out.println("3. MOSTRAR LIBROS PRESTADOS");
             System.out.println("4. SALIR");
    
            opc = lector.nextInt();
           //////////////////////////////////////////////////////////////////////////////////
         switch(opc){
        case 1:
            //++++++++++++++
                           
                        System.out.print("Digite el nombre del libro que quiere prestar: ");
                        name = lector.next();
                        for (int i=0; i<contUs;i++){
                              Datos1[contLS] = new Prestamo();
                              Datos[contUs] = new Personal();
                              
                            if (name.equals(Datos[i].getnombre())){
                                band=1;
                                Datos1[i].setLibro(Datos[i].getnombre());
                                System.out.println("Digite la cedula del usuario: ");
                                 Datos1[i].setCedula(lector.next()); 
                                 
                                 Datos[i].setcantidad((Datos[i].getcantidad()-1));
                                 Datos1[i].setInventario(Datos1[i].getInventario()+1);
                                  //System.out.println("Libros prestados =  "+Datos1[i].getInventario()+Datos1[i].getLibro()+Datos[i].getcantidad());
                                  contUs++;
                                                          
                                 
                            }
                        }
                        if(band==0)
                            System.out.println("\nLIBRO NO ENCONTRADO");
                        else
                            band=0;   
            break;
             case 2:
                 //+++++++++++++++++++++
                        System.out.print("Digite el nombre del libro que quiere devolver: ");
                        name = lector.next();
                        for (int i=0; i<contUs;i++){
                              Datos1[contLS] = new Prestamo();
                              
                            if (name.equals(Datos[i].getnombre())){
                                band=1;
                                Datos1[i].setLibro(Datos[i].getnombre());
                                Datos1[i].setCedula(""); 
                                 
                                 Datos[i].setcantidad((Datos[i].getcantidad()+1));
                                 Datos1[i].setInventario(Datos1[i].getInventario()-1);
                                                          
                                 
                            }
                        }
                        if(band==0)
                            System.out.println("\nLIBRO NO ENCONTRADO");
                        else
                            band=0;   
                 
            break;
             case 3:
                   System.out.println("entró");
                 //*********************+
                   contLS=0;
                               for (int i=0; i<contLS;i++){
                 
                                   
                                System.out.println("Los  libros prestados son: ");
                                System.out.println("Nombre: "+Datos1[i].getLibro());
                                System.out.println("Cantididad de libros prestados: "+Datos1[i].getInventario());
                                contLS++;
                               }
            break;
             case 4:
                 break;
             default:
                 System.out.println("OPCIÓN INVALIDA");
                 break;
         } }while(opc!=4);
                 
            
            
        //************************************************
         
        break;
        case 3:
                 System.out.println("GRACIAS POR UTILIZAR EL PROGRAMA, BYE");
            break;
        default:
        System.out.println("\nOPCION INCORRECTA!\n");
        break;  
    }
                     } while(modulo!=3);
    }    
}
