package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //Creamos el contexto de la aplicacion
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //creamos el objeto obteniendo su bean y casteando al tipo del objeto
        Saludo saludador = (Saludo) context.getBean("Saludo");
        saludador.imprimirSaludo();
    }
}
