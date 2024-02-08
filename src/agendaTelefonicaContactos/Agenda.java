package agendaTelefonicaContactos;
public class Agenda {
    private Contacto con[];
//Esteablecer cantidad de contactos por el usuario
    public Agenda(int tamano){
        con = new Contacto[tamano];
    }
    // Metodo para añadir contactos a la Agenda
    public void añadirContacto (Contacto contact){
        if(existeContacto (contact)){
            System.out.println("Ya existe un contacto con ese nombre, intente de nuevo.");
        } else if (agendaLlena()){
            System.out.println("La agenda esta llena.");
        } else {
            boolean registrado = false;
            for (int i=0; i < con.length && !registrado; i++){
                if(con[i] == null){
                    con[i] = contact;
                    registrado = true;
                }
            }
            if (registrado){
                System.out.println("El contacto se ha registrado con exito.");
            } else{
                System.out.println("El contacto no se ha podido registrar, intente de nuevo.");
            }
        }
    }
    // Metodo para comprobar si existe un contacto igual
    public boolean existeContacto(Contacto contact){
        for (Contacto contacto : con) {
            if (contacto != null && contacto.equals(contact)) {
                return true;
            }
        }
        return false;
    }
    // Metodo para comprobar si la agenda esta llena
    public boolean agendaLlena(){
        for (Contacto contacto : con) {
            if (contacto == null) {
                return false;
            }
        }
        return true;
    }
    //Comprobar espacios libres
    public int espacioLibres(){
        int contador = 0;
        for (Contacto contacto : con) {
            if (contacto == null) {
                contador++;
            }
        }
        return contador;
    }
    // Metodo para listar contactos
    public void listarContactos(){
        if(espacioLibres() == con.length){
            System.out.println("No hay contactos para listar");
        } else{
            for (Contacto contacto : con) {
                if (contacto != null) {
                    System.out.println("Nombre : " + contacto.getNombre());
                    System.out.println("Celular : " + contacto.getCelular());
                }
            }
        }

    }
    //Metodo para buscar contactos

    public void buscaContacto (String nombre){
        boolean buscado = false;
        for(int i = 0;i < con.length && !buscado; i++){
            if(con[i] != null && con[i].getNombre().trim().equalsIgnoreCase(nombre.trim())){
                System.out.println("Su contacto fue encontrado con exito , su celular es : " + con[i].getCelular());
                buscado = true;
            }
        }

        if(!buscado){
            System.out.println("No se encontro el contacto ingresado");
        }
    }
    //Metodo para eliminar contacto
    public void eliminarContacto(Contacto contact){
        boolean eliminado = false;
        for(int i = 0;i < con.length && !eliminado; i++){
            if(con[i] != null && con[i].equals(contact)){
                con[i] = null;
                eliminado = true;
            }
        }

        if(eliminado){
            System.out.println("El contacto fue eliminado con exito");
        }else{
            System.out.println("El contacto no se elimino, intente de nuevo");
        }
    }


}

