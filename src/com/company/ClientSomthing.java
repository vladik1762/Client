package com.company;




import javax.management.relation.Role;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class ClientSomthing {

    private Socket socket;
    private BufferedReader in;          // поток чтения из сокета
    protected BufferedWriter out;         // поток чтения в сокет
    protected BufferedReader inputUser;   // поток чтения с консоли
    static private String addr; // ip адрес клиента
    static private int port; // порт соединения
    private String resultFromServer ;
    private ArrayList<String> res= new ArrayList<>(); // сам вектор с данными
    private int countRecord = 0 ;
    static private String userName;

    private String ROLE;
    public static double getPrice() {
        return price;
    }

    public static void setPrice(double price) {
        ClientSomthing.price = price;
    }

    static private double price;//для конроля вектора
    public ClientSomthing(){

    }

    public String getRole(){
        return ROLE;
    }
    public ClientSomthing(String addr, int port) {
        this.addr = addr;
        this.port = port;
        try {
            this.socket = new Socket(addr, port);
        } catch (IOException e) {
            System.err.println("Socket failed");
        }
        try {

            inputUser = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));


            new WriteMsg().start(); // нить пишущая сообщения в сокет приходящие с консоли в бесконечном цикле
        } catch (IOException e) {
            // Сокет должен быть закрыт при любой
            // ошибке, кроме ошибки конструктора сокета:
            ClientSomthing.this.downService();
        }

    }

    private void downService() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
            }
        } catch (IOException ignored) {
        }
    }






    public void sizeServ() {
        try {
            out.write( "Подключение\n");
            out.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeTableOperation(String type, String id) {
       

            try {
                out.write( "УдалитьИнформациюизТаблицы\n");
                out.flush();
                sleep(1100);

                out.write(type + "\n");
                out.flush();

                out.write(id + "\n");
                out.flush();


            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }



    }

    public class WriteMsg extends Thread {


        @Override
        public void run() {


            try {
                while(true) {

                    resultFromServer = in.readLine();
                    res.add(resultFromServer);
                    out.flush(); // чистим
                }
            } catch (IOException e) {
                ClientSomthing.this.downService(); // в случае исключения тоже харакири

            }

        }

    }

    public String getStr(){

        return resultFromServer;
    }


    public String sendDataForRegistration(String target, String firstName,String userName,  String password,  String email){
        try {


            out.write(target +"\n");
            out.flush();
            out.write(firstName +"\n");
            out.flush();
            out.write(userName +"\n");
            out.flush();
            out.write(password +"\n");
            out.flush();
            out.write(email +"\n");
            out.flush();
            out.write("Admin" +"\n");
            out.flush();
            sleep(1100);

            return resultFromServer;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "";
        }}

    public String isUserName(String userName){
        try {
            String strIn;

            out.write( "УникальностьЛогина\n");
            out.flush();
            out.write( userName + "\n");
            out.flush();
            sleep(1100);


            return resultFromServer;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "";
        }}

    public String sendDataForSignIn(String targer,String login,String password) {
        try {
            res.clear();
            countRecord =0;
            String strIn;
            out.write(targer + "\n");
            out.flush();
            userName = login;
            out.write(login + "\n");
            out.flush();
            out.write(password + "\n");
            out.flush();

            new WriteMsg().sleep(2000);



            if(!res.get(0).equals("Конец")){

                do{

                    ROLE = res.get(countRecord);
                    countRecord++;
                    System.out.println(ROLE);
                    resultFromServer =res.get(countRecord);
                    countRecord++;
                    System.out.println(resultFromServer);


                }
                while (!res.get(countRecord).equals("Конец"));
            }





            return resultFromServer;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String sendDataForAddAccount( String name, String typeOfAccount,String typeOfMany,  String balance, int uniqueNumber){
        try {
            String target = "ДобавитьАккаунт";

            String temp = String.valueOf(uniqueNumber);
            out.write(target +"\n");
            out.flush();

            out.write(userName +"\n");
            out.flush();

            out.write(name +"\n");
            out.flush();
            out.write(typeOfAccount +"\n");
            out.flush();
            out.write(typeOfMany +"\n");
            out.flush();
            out.write(balance +"\n");
            out.flush();

            out.write(temp +"\n");
            out.flush();
            sleep(1100);

            return resultFromServer;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "";
        }}


    public ArrayList<Account> receiveDataForAccount() { // Функция для инициализации данных пришедших с сервера
        try {
            res.clear();
            countRecord =0;

            ArrayList<Account> arrayListAccounts = new ArrayList<>();
            //arrayListRings = null;
            out.write( "ДанныеАккаунтов\n");
            out.flush();
            out.write( userName+"\n");
            out.flush();

            sleep(1100);
            if(!res.get(0).equals("Конец")){

                do{

                    Account account = new Account();

                    account.setId(res.get(countRecord));
                    countRecord++;
                    account.setUser_id(res.get(countRecord));
                    countRecord ++;
                    account.setName(res.get(countRecord));
                    countRecord++;
                    account.setKindOfAccount(res.get(countRecord));
                    countRecord++;
                    account.setKindOfMoney(res.get(countRecord));
                    countRecord++;
                    account.setCurrencyBalance(res.get(countRecord));
                    countRecord++;
                    account.setUniqueNumber(res.get(countRecord));
                    countRecord++;





                    arrayListAccounts.add(account);

                }
                while (!res.get(countRecord).equals("Конец"));
            }
            countRecord = 0;
            res.clear();



            return arrayListAccounts;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String sendDataForAddDebt(String name,String date, String destination, String kindOfDebt,String sum,String account){
        try {
            String target = "ДобавитьДолг";

            out.write(target +"\n");
            out.flush();



            out.write(name +"\n");
            out.flush();
            out.write( kindOfDebt +"\n");
            out.flush();
            out.write(account +"\n");
            out.flush();
            out.write(sum +"\n");
            out.flush();
            out.write(destination +"\n");
            out.flush();
            out.write(date +"\n");
            out.flush();

            out.write(userName +"\n");
            out.flush();
            sleep(1100);

            return resultFromServer;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "";
        }}

    public ArrayList<Debt> receiveDataForDebt() { // Функция для инициализации данных пришедших с сервера
        try {
            res.clear();
            countRecord =0;

            ArrayList<Debt> arrayListDebts = new ArrayList<>();
            //arrayListRings = null;
            out.write( "ДанныеДолг\n");
            out.flush();
            out.write( userName+"\n");
            out.flush();

            sleep(1100);
            if(!res.get(0).equals("Конец")){

                do{

                    Debt debt = new Debt();

                    debt.setId(res.get(countRecord));
                    countRecord++;

                    debt.setName(res.get(countRecord));
                    countRecord++;
                    debt.setSum(res.get(countRecord));
                    countRecord++;

                    debt.setDate(res.get(countRecord));
                    countRecord++;

                    debt.setKindOfDebt(res.get(countRecord));
                    countRecord++;

                    debt.setDestination(res.get(countRecord));
                    countRecord++;

                    debt.setAccount(res.get(countRecord));
                    countRecord++;





                    arrayListDebts.add(debt);

                }
                while (!res.get(countRecord).equals("Конец"));
            }
            countRecord = 0;
            res.clear();



            return arrayListDebts;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }


    public String sendDataForAddTransfer(String name,String accountFrom, String accountTo, String sum,String date){
        try {
            String target = "ДобавитьПеревод";

            out.write(target +"\n");
            out.flush();



            out.write(name +"\n");
            out.flush();
            out.write( accountFrom +"\n");
            out.flush();
            out.write(accountTo +"\n");
            out.flush();
            out.write(sum +"\n");
            out.flush();
            out.write(date +"\n");
            out.flush();

            out.write(userName +"\n");
            out.flush();
            sleep(1100);

            return resultFromServer;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "";
        }}

    public ArrayList<Transfer> receiveDataForTransfer() { // Функция для инициализации данных пришедших с сервера
        try {
            res.clear();
            countRecord =0;

            ArrayList<Transfer> arrayListTransfers = new ArrayList<>();
            //arrayListRings = null;
            out.write( "ДанныеПеревод\n");
            out.flush();
            out.write( userName+"\n");
            out.flush();

            sleep(1100);
            if(!res.get(0).equals("Конец")){

                do{

                    Transfer transfer = new Transfer();

                    transfer.setId(res.get(countRecord));
                    countRecord++;

                    transfer.setName(res.get(countRecord));
                    countRecord++;

                    transfer.setSum(res.get(countRecord));
                    countRecord++;

                    transfer.setDate(res.get(countRecord));
                    countRecord++;

                    transfer.setAccount(res.get(countRecord));
                    countRecord++;

                    transfer.setId_accountTo(res.get(countRecord));
                    countRecord++;



                    System.out.println(transfer.getName());

                    arrayListTransfers.add(transfer);

                }
                while (!res.get(countRecord).equals("Конец"));
            }
            countRecord = 0;
            res.clear();



            return arrayListTransfers;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String sendDataForCountTransfer(String accountFrom, String accountTo, String sum){
        try {
            String target = "ПодсчётПеревод";

            out.write(target +"\n");
            out.flush();

            System.out.println(accountFrom);
            System.out.println(accountTo);


            out.write( accountFrom +"\n");
            out.flush();
            out.write(accountTo +"\n");
            out.flush();
            out.write(sum +"\n");
            out.flush();

            out.write(userName +"\n");
            out.flush();

            sleep(1100);

            return resultFromServer;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "";
        }}


    public String sendDataForAddIncome(String name,String date, String payer,String sum,String account){
        try {
            String target = "ДобавитьДоход";

            out.write(target +"\n");
            out.flush();



            out.write(name +"\n");
            out.flush();
            out.write( payer +"\n");
            out.flush();
            out.write(account +"\n");
            out.flush();
            out.write(sum +"\n");
            out.flush();

            out.write(date +"\n");
            out.flush();

            out.write(userName +"\n");
            out.flush();
            sleep(1100);

            return resultFromServer;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "";
        }}


    public ArrayList<Income> receiveDataForIncome() { // Функция для инициализации данных пришедших с сервера
        try {
            res.clear();
            countRecord =0;

            ArrayList<Income> arrayListIncomes = new ArrayList<>();
            //arrayListRings = null;
            out.write( "ДанныеДоход\n");
            out.flush();
            out.write( userName+"\n");
            out.flush();

            sleep(1100);
            if(!res.get(0).equals("Конец")){

                do{

                    Income income = new Income();

                    income.setId(res.get(countRecord));
                    countRecord++;

                    income.setName(res.get(countRecord));
                    countRecord++;
                    income.setSum(res.get(countRecord));
                    countRecord++;

                    income.setDate(res.get(countRecord));
                    countRecord++;

                    income.setPayer(res.get(countRecord));
                    countRecord++;
                    income.setAccount(res.get(countRecord));
                    countRecord++;


                    arrayListIncomes.add(income);

                }
                while (!res.get(countRecord).equals("Конец"));
            }
            countRecord = 0;
            res.clear();



            return arrayListIncomes;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String sendDataForAddConsumption(String name,String date, String category,String sum,String account){
        try {
            String target = "ДобавитьРасход";

            out.write(target +"\n");
            out.flush();



            out.write(name +"\n");
            out.flush();
            out.write( category +"\n");
            out.flush();
            out.write(account +"\n");
            out.flush();
            out.write(sum +"\n");
            out.flush();

            out.write(date +"\n");
            out.flush();

            out.write(userName +"\n");
            out.flush();
            sleep(1100);

            return resultFromServer;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "";
        }}

    public ArrayList<Consumption> receiveDataForConsumption() { // Функция для инициализации данных пришедших с сервера
        try {
            res.clear();
            countRecord =0;

            ArrayList<Consumption> arrayListConsumptions = new ArrayList<>();
            //arrayListRings = null;
            out.write( "ДанныеРасход\n");
            out.flush();
            out.write( userName+"\n");
            out.flush();

            sleep(1100);
            if(!res.get(0).equals("Конец")){

                do{

                    Consumption consumption = new Consumption();

                    consumption.setId(res.get(countRecord));
                    countRecord++;

                    consumption.setName(res.get(countRecord));
                    countRecord++;
                    consumption.setSum(res.get(countRecord));
                    countRecord++;

                    consumption.setDate(res.get(countRecord));
                    countRecord++;

                    consumption.setCategory(res.get(countRecord));
                    countRecord++;
                    consumption.setAccount(res.get(countRecord));
                    countRecord++;


                    arrayListConsumptions.add(consumption);

                }
                while (!res.get(countRecord).equals("Конец"));
            }
            countRecord = 0;
            res.clear();



            return arrayListConsumptions;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String sendDataForAddNewAccess(String email,String role){
        try {
            String target = "ДобавитьДоступ";

            out.write(target +"\n");
            out.flush();


            out.write(userName +"\n");
            out.flush();

            out.write(email +"\n");
            out.flush();
            out.write( role +"\n");
            out.flush();


            sleep(9000);

            return resultFromServer;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "";
        }}

    public ArrayList<User> receiveDataForAddUser() { // Функция для инициализации данных пришедших с сервера
        try {
            res.clear();
            countRecord =0;

            ArrayList<User> arrayListUsers = new ArrayList<>();
            //arrayListRings = null;
            out.write( "ДанныеПользователь\n");
            out.flush();
            out.write( userName+"\n");
            out.flush();

            sleep(1100);
            if(!res.get(0).equals("Конец")){

                do{

                    User user = new User();
                    user.setEmail(res.get(countRecord));
                    countRecord++;

                    user.setRole(res.get(countRecord));
                    countRecord++;

                    arrayListUsers.add(user);

                }
                while (!res.get(countRecord).equals("Конец"));
            }
            countRecord = 0;
            res.clear();



            return arrayListUsers;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }


    public String sendDataForUpdateAccount(String uniqueN, String name,  String balance){
        try {
            String target = "ОбновитьАккаунт";


            out.write(target +"\n");
            out.flush();

            out.write(userName +"\n");
            out.flush();
            out.write(uniqueN +"\n");
            out.flush();
            out.write(name +"\n");
            out.flush();

            out.write(balance +"\n");
            out.flush();

            sleep(1100);

            return resultFromServer;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "";
        }}
}










