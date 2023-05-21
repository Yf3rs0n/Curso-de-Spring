package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService saludar = (UserService)context.getBean("userService");
        System.out.println(saludar.notificationService.imprimirSaludo());

    }
}