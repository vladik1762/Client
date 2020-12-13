package com.company;

public class AdapterToClient {
    static ClientSomthing cl = null;

    public AdapterToClient(){
        cl = new ClientSomthing("localhost", 8080);
    }

    static  public ClientSomthing get(){
        return cl;
    }

}
