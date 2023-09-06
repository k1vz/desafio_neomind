package org.logica;

public class Main {
    public static void main(String[] args) {

        Clock clock = new Clock();
        System.out.println(clock.returnClockAngle(-30, 15));

        // Notei que no exemplo 2 (00:15) geraria um ângulo de 45ª,
        // entretanto pela lógica, seria a metade do ângulo do exemplo seguinte (00:30), logo, seria um ângulo de 90º.
        // Seguindo essa lógica, implementei esse código.
    }
}
