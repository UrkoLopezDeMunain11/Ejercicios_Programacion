import Modelo.Estudio;
import Modelo.Pelicula;

import java.util.ArrayList;


public class Main {
    private static ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
    private static ArrayList<Estudio> estudios = new ArrayList<Estudio>();
    private static  Pelicula pelicula;


    public static void main(String[] args) {

        //CREACION DE PELICULAS
        pelicula = new Pelicula("titanic",1990,220,"drama",estudios);//creo la primera pelicula
        peliculas.add(pelicula);//la guardo en mi lista de peliculas

        pelicula = new Pelicula("Piratas del caribe", 2000, 100,"accion",estudios);//creo la ssegunda pelicula
        peliculas.add(pelicula);//la guardo en mi lista de peliculas

        pelicula = new Pelicula("indiana jones", 1890,350,"accion",estudios);//creo la tercera pelicula
        peliculas.add(pelicula);//la guardo en mi lista de peliculas


        //CREACION DE ESTUDIOS
        Estudio estudio1 = new Estudio("Universal","Madrid","arriaga","universal.com","1901 ", "Francia","123456789", peliculas); //creo el primer estudio
        estudios.add(estudio1);//lo guardo en la lsta de estudios

        Estudio estudio2 = new Estudio("Warner", "Barcelona", "Salburua", "warner.com", "2000","Alemania","987654321",  peliculas);//creo el segundo estudio
        estudios.add(estudio2);//lo guardo en la lsta de estudios

        Estudio estudio3 = new Estudio("Paramount", "Malaga", "Arana", "paramount.com", "2008","Portugal","123654301", peliculas);//creo el tercer estudio
        estudios.add(estudio3);//lo guardo en la lsta de estudios

        //SACAR EL NOMBRE DEL ESTUDIO CON LA PELICULA MAS LARGA
        Pelicula peliculaMaslarga = null;
        int maxDuracion = 0;
        //recorro primero las peliculas para sacar la pelicula mas larga
        for (Pelicula p : peliculas) {//para recorrer la lista de peliculas, todas
            if(p.getDuracionMinutos() > maxDuracion){ // si la duracion de minutos de p es mayor a maxDuracion q es 0 entra aqui
                maxDuracion = p.getDuracionMinutos();//guarda los minutos de primea pelicula q pasa por aqui en maxDracion ej: 220 ahora guardarlo en maxDuracion y luego si la segubda peicula es mas larga 230 pues cambia el 220 por 230 y asi con las siguientes
                peliculaMaslarga = p;//guarda el nombre de esa primera pelicula en peliculaMaslarga y aqui pues cambia el nombre q habia por uno nuevo si esq la sigueinte pelicula es mas larga
            }
        }

        //miramos primero q la pelicula mas larga no sea null, sino no tendria ninguna y no mentraria aqui y no daria estudio
        if (peliculaMaslarga != null) {
            System.out.println("La película más larga es: " + peliculaMaslarga.getTitulo() + "con duracion de: " + maxDuracion + " minutos.");

            System.out.println("Estudios que la produjeron:");
            for (Estudio estudio : peliculaMaslarga.getListaEstudios()) {
                System.out.println("- " + estudio.getNombre());
            }
        }

    /*
    //IGUAL Q EL FOR DE ARRIIBA PERO DE MAREA MAS SIMPLE, NO TAN COMPLEJA
        Pelicula peliculaMaslarga = null;
        int maxDuracion = 0;
        for (int i = 0; i < peliculas.size(); i++) {
            if (pelicula.getDuracionMinutos() > maxDuracion) {
                maxDuracion = pelicula.getDuracionMinutos();
                peliculaMaslarga = pelicula;
            }
        }

    */


        Estudio estudioMax = null;
        int maxPeliculas = 0;

        for (Estudio e : estudios) {//recorro todos los estudios
            int contador = 0;//contador en cero porque todavia no he contado nada de cual es el que mas peliculas tiene
            for (Pelicula p : peliculas) {//recorro peliculas para saber cual esta en cada estudio
                if (p.getListaEstudios().contains(e)) {//si ese estudio contiene esa pelicula
                    contador++;//pues si esa pelicula esta en warner sumarle un 1 a warner si esta en Universal pues sumarle a universal
                }
            }
            if (contador > maxPeliculas) {//si el contador es mayor al maxPeliculas q lo empiezo a 0
                maxPeliculas = contador;//pues en ese Maxcontador guardar el numero de peliculas del estudio q mas peliculas tiene
                estudioMax = e; //aqui pues arriba la cantidad aqui el nombre
            }
        }

        System.out.println("El estudio que más películas ha producido es: " + estudioMax.getNombre());

    }
}