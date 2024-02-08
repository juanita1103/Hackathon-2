package agendaTelefonicaContactos;
import javax.swing.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opciones = 0;
        int numeroCelular;
        String nombre;
        Contacto contact;
        int tamanoAgenda;

        //Solicita al usuario ingresar la cantidad de contactos y crea la agenda
        tamanoAgenda = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad de contactos para su agenda : "));
        Agenda agendaTelefonica = new Agenda(tamanoAgenda);

        while (opciones != 8){
            System.out.println("AGENDA TELEFONICA DE CONTACTOS");
            System.out.println("1 . Añadir contacto");
            System.out.println("2 . Buscar contacto");
            System.out.println("3 . Listar contacto");
            System.out.println("4 . Comprobar si existe un contacto");
            System.out.println("5 . Comprobar disponibilidad");
            System.out.println("6 . Comprobar si la agenda esta llena");
            System.out.println("7 . Eliminar contacto");
            System.out.println("8 . Salir");
            System.out.print("Ingrese una opcion: ");
            opciones = scan.nextInt();

            switch (opciones){
                case 1:
                    System.out.print("Digite su nombre : ");
                    nombre = scan.next();

                    System.out.print("Digite su celular : ");
                    numeroCelular = scan.nextInt();

                    contact = new Contacto(nombre,numeroCelular);
                    agendaTelefonica.añadirContacto(contact);
                    break;

                case 2:
                    System.out.print("Digite un nombre : ");
                    nombre = scan.next();

                    agendaTelefonica.buscaContacto(nombre);
                    break;

                case 3:
                    agendaTelefonica.listarContactos();
                    break;

                case 4:
                    System.out.print("Digite su nombre : ");
                    nombre = scan.next();

                    contact = new Contacto(nombre);
                    if(agendaTelefonica.existeContacto(contact)){
                        System.out.println("El contacto existe");
                    }
                    else{
                        System.out.println("El contacto no existe");
                    }
                    break;

                case 5:
                    System.out.println("Cantidad de espacios disponibles: " + agendaTelefonica.espacioLibres());
                    break;

                case 6:
                    if(agendaTelefonica.agendaLlena()){
                        System.out.println("La agenda esta llena");
                    }else{
                        System.out.println("Hay espacio para más contactos");
                    }
                    break;

                case 7:
                    System.out.print("Digite su nombre : ");
                    nombre = scan.next();

                    contact = new Contacto(nombre);
                    agendaTelefonica.eliminarContacto(contact);
                    break;

                case 8:
                    System.out.println("Vuelve pronto");
                    break;

                default:
                    System.out.println("Opcion no valida , intente de nuevo");
                    break;


            }
        }
    }
}