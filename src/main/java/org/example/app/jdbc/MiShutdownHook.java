package org.example.app.jdbc;

public class MiShutdownHook extends Thread{

    @Override
    public void run(){
        MyJdbc.getInstance().disconnect();
        System.out.println("---Disconect---");
    }

}
