import java.util.Random;
import java.util.Scanner;

public class Juego {
    int puntajeTotalJugador = 0;
    int puntajeTotalPC = 0;
    String[] opciones = {"Piedra", "Papel", "Tijera"};

    public void jugar() {
        System.out.println("Vamos a jugar al Piedra, Papel o Tijera!");

        for (int i = 0; i < 3; i++) {
            jugarRonda();
        }

        if(puntajeTotalJugador > puntajeTotalPC){
            System.out.println("**** Felicitaciones, has jagado el juego! ****");
        }else {
            System.out.println("**** Ha ganado la PC ****");
        }
        System.out.println("Has obtenido "+ puntajeTotalJugador + " puntos y la PC ha obtenido " + puntajeTotalPC +" puntos.");
    }

    private void jugarRonda(){
        int seleccionJugador = seleccionarOpcionJugador();
        int seleccionPC = generateRandomNumber();

        if(seleccionPC == seleccionJugador){
            System.out.println("Ambos han elegido "+ this.opciones[seleccionJugador - 1]+". Se repite la ronda:");
            jugarRonda();
        }else{
            asignarPuntajesRonda(seleccionJugador, seleccionPC);
        }
    }

    private int seleccionarOpcionJugador() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Selecciona una opción:");
        System.out.println("1) Piedra");
        System.out.println("2) Papel");
        System.out.println("3) Tijeras");
        int opcionSeleccionada = teclado.nextInt();
        while(opcionSeleccionada < 1 || opcionSeleccionada > 3){
            System.out.println("Solo puedes elegir una de las opciones mencionadas arriba (1, 2 o 3)");
            opcionSeleccionada = teclado.nextInt();
        }

        return opcionSeleccionada;
    }

    private int generateRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(3) + 1;
    }

    private void asignarPuntajesRonda(int seleccionJugador, int seleccionPC){
        System.out.println("Has a elegido "+ this.opciones[seleccionJugador - 1] + " y la Pc ha elegido " + this.opciones[seleccionPC - 1]);
        switch(seleccionJugador){
            case 1:
                if(seleccionPC == 2){
                    System.out.println("Punto para la PC :(");
                    this.puntajeTotalPC++;
                }else{
                    System.out.println("Punto para ti :)");
                    this.puntajeTotalJugador++;
                }
                break;

            case 2:
                if(seleccionPC == 3){
                    System.out.println("Punto para la PC :(");
                    this.puntajeTotalPC++;
                }else{
                    System.out.println("Punto para ti :)");
                    this.puntajeTotalJugador++;
                }
                break;

            case 3:
                if(seleccionPC == 2){
                    System.out.println("Punto para ti :)");
                    this.puntajeTotalJugador++;
                }else{
                    System.out.println("Punto para la PC :(");
                    this.puntajeTotalPC++;
                }
                break;
        }
    }
}
