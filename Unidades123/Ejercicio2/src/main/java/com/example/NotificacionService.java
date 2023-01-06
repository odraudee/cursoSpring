package com.example;

import org.springframework.stereotype.Component;

@Component
public class NotificacionService {
    public NotificacionService(){
        System.out.println("Ejecutando constructor de NotificacionService");
    }

    public void imprimirSaludo(){
        System.out.println("Hola que tal estas");
    }


}
