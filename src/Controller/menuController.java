package Controller;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import java.util.Locale;
import java.util.ResourceBundle;


import com.company.*;

import com.company.Animation.Shake;
import com.jfoenix.controls.*;
import com.jfoenix.validation.DoubleValidator;
import com.jfoenix.validation.RegexValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class menuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton buttonMyAccount;

    @FXML
    private AnchorPane backForAll;

    @FXML
    private JFXButton buttonOperation;

    @FXML
    private Pane paneForAddForAcc;

    @FXML
    private JFXTextField textFieldNameOfAccountForAcc;

    @FXML
    private JFXTextField textFieldCurrentBalanceForAcc;

    @FXML
    private JFXComboBox<String> kindOfAccountForAcc;

    @FXML
    private JFXButton saveAccountForAcc;

    @FXML
    private JFXComboBox<String> kindOfMoneyForAcc;

    @FXML
    private Pane panelForMainForAcc;

    @FXML
    private JFXButton addAccountForAcc;

    @FXML
    private Text balanceText;

    @FXML
    private Text cashNameText1;

    @FXML
    private Text cashlessNameText1;

    @FXML
    private Text cashDataText1;

    @FXML
    private Text cashlessDataText1;

    @FXML
    private Text cashNameText2;

    @FXML
    private Text cashDataText2;

    @FXML
    private Text cashlessNameText2;

    @FXML
    private Text cashNameText3;

    @FXML
    private Text cashlessNameText3;

    @FXML
    private Text cashlessDataText2;

    @FXML
    private Text cashDataText3;

    @FXML
    private Text cashlessDataText3;

    @FXML
    private Text balanceText1;

    @FXML
    private Text balanceText11;

    @FXML
    private Pane panelForDebt;

    @FXML
    private JFXTextField textFieldNameForDebt;

    @FXML
    private JFXRadioButton radioBIGotForDebt;

    @FXML
    private ToggleGroup mygroup;

    @FXML
    private JFXDatePicker dateForDebt;

    @FXML
    private JFXTextField textFieldWhoForDebt;

    @FXML
    private JFXTextField textFieldSumForDebt;

    @FXML
    private JFXComboBox<String> checkBoxAccountForDebt;

    @FXML
    private JFXButton saveRecordDebt;

    @FXML
    private JFXRadioButton radioBIGiveForDebt;

    @FXML
    private Pane panelForTable;

    @FXML
    private JFXButton buttonDebt;

    @FXML
    private AnchorPane anchorPaneMyAcc;

    @FXML
    private AnchorPane anchorPaneOperation;

    @FXML
    private JFXDatePicker DatedateForDebt;

    @FXML
    private TableView<Operation> tableForOperation;

    @FXML
    private TableColumn<Operation, String> ColumIdOperation;

    @FXML
    private TableColumn<Operation, String> columNameOfOperation;

    @FXML
    private TableColumn<Operation, String> columTypeOfOperation;

    @FXML
    private TableColumn<Operation, String> columDateOfOperation;

    @FXML
    private TableColumn<Operation, String> columSumOfOperation;

    @FXML
    private JFXTextField textFIeldSeachForDebt;

    @FXML
    private JFXButton deleteButtonForDebt;

    @FXML
    private JFXButton cancelForDebt;

    @FXML
    private JFXButton ButtonDetailedForDebt;
    @FXML
    private JFXButton buttonConsumption;

    @FXML
    private JFXButton buttonIncome;

    @FXML
    private JFXButton buttonTransfer;


    @FXML
    private Pane panelForIncome;

    @FXML
    private JFXTextField textFieldNameForIncome;

    @FXML
    private JFXTextField textFieldSumForIncome;

    @FXML
    private JFXComboBox<String> checkBoxAccountForIncome;

    @FXML
    private JFXButton saveRecordIncome;

    @FXML
    private JFXDatePicker DatedateForIncome;

    @FXML
    private JFXButton cancelForIncome;

    @FXML
    private JFXTextField textFieldPayerForIncome;

    @FXML
    private Pane panelForConsumption;

    @FXML
    private JFXTextField textFieldNameForConsumption;

    @FXML
    private JFXTextField textFieldSumForConsumption;

    @FXML
    private JFXComboBox<String> checkBoxAccountForConsumption;

    @FXML
    private JFXButton saveRecordConsumption;

    @FXML
    private JFXDatePicker DatedateForConsumption;

    @FXML
    private JFXButton cancelForIConsumption;

    @FXML
    private JFXComboBox<Categories> checkBoxCategoriaForConsumption;

    @FXML
    private Pane panelForTransfer;

    @FXML
    private JFXTextField textFieldNameForTransfer;

    @FXML
    private JFXTextField textFieldSumForTransfer;

    @FXML
    private JFXComboBox<String> checkBoxAccountTOForTransfer;

    @FXML
    private JFXButton saveRecordForTransfer;

    @FXML
    private JFXDatePicker DatedateForTransfer;

    @FXML
    private JFXButton cancelForTransfer;

    @FXML
    private JFXComboBox<String> checkBoxAccountFROMForTransfer;

    @FXML
    private Pane panelForCommonAcces;

    @FXML
    private JFXButton sendEmailForComAcces;

    @FXML
    private JFXTextField textFieldEmailForComAcces;

    @FXML
    private TableView<User> tableviewForUser;

    @FXML
    private TableColumn<User, String> tablecolumnForComAcces;

    @FXML
    private TableColumn<User, String> columnRoleForComAcces;

    @FXML
    private JFXButton deleteEmailForComAcces;

    @FXML
    private JFXCheckBox checkBoxForComAcces;

    @FXML
    private JFXButton ButtonCommonAccess;

    @FXML
    private AnchorPane anchorPaneCommonAcces;

    @FXML
    private AnchorPane anchorPaneAnalysis;

    @FXML
    private Pane panePieConsumption;

    @FXML
    private PieChart piechartConsumption;

    @FXML
    private JFXDatePicker dataPickerFromAnalysis;

    @FXML
    private JFXDatePicker dataPickerToAnalysis;

    @FXML
    private JFXButton buttonCreateReport;

    @FXML
    private JFXButton buttonCreatePieConsumption;

    @FXML
    private JFXComboBox<String> checkComboBoxAccountForAnalysis;

    @FXML
    private JFXButton buttonCancelAddAccount;
    @FXML
    private JFXButton buttonAnalysis;

    @FXML
    private JFXButton buttonUpdateTableUser;

    @FXML
    private JFXButton buttonBackFromPie;

    @FXML
    private Pane paneForAddForChangeAcc;

    @FXML
    private JFXTextField textFieldCurrentBalanceForChangeAcc;

    @FXML
    private JFXComboBox<String> checkBoxAccountForChangeAcc;

    @FXML
    private JFXButton saveAccountForChangeAcc;

    @FXML
    private JFXButton buttonCancelChangeAcc;

    @FXML
    private JFXTextField textFieldNameForChangeAcc;

    @FXML
    private JFXButton buttonUpdateForMainAcc;
    ClientSomthing cl = AdapterToClient.get();

    ArrayList<Account> accounts;

    ArrayList<Debt> debts;

    ArrayList<Income> incomes;

    ArrayList<Transfer> transfers;

    ArrayList<Operation> operations;

    ArrayList<User> users;

    ArrayList<Consumption> consumptions;
    Operation operationTemp = null;
    ObservableList<Operation> dataForTable;

    ObservableList<User> dataForTableUser;
    FilteredList<Operation> filterData;
    String ROLE;
    String changeAcc;

    User userTemp;


    @FXML
    void initialize() {

        buttonCreatePieConsumption.setDisable(true);

        sendEmailForComAcces.setOnAction(actionEvent -> {

            addUser();
            initTableUsers();


        });



        ROLE = cl.getRole();
        System.out.println("role" + ROLE);
        if (ROLE.equals("User")) {
            deleteEmailForComAcces.setDisable(true);
            deleteButtonForDebt.setDisable(true);
            sendEmailForComAcces.setDisable(true);
            addAccountForAcc.setDisable(true);
            buttonUpdateForMainAcc.setDisable(true);
        }

        tableForOperation.setEditable(false);
        buttonOperation.setOnAction(actionEvent -> {
            anchorPaneOperation.toFront();
        });

        buttonConsumption.setOnAction(actionEvent -> {
            panelForConsumption.toFront();
        });

        buttonIncome.setOnAction(actionEvent -> {
            panelForIncome.toFront();
        });

        buttonTransfer.setOnAction(actionEvent -> {
            panelForTransfer.toFront();
        });

        ButtonCommonAccess.setOnAction(actionEvent -> {
            anchorPaneCommonAcces.toFront();
        });

        cancelForIConsumption.setOnAction(actionEvent -> {
            panelForTable.toFront();
        });

        cancelForIncome.setOnAction(actionEvent -> {
            panelForTable.toFront();
        });

        cancelForTransfer.setOnAction(actionEvent -> {
            panelForTable.toFront();
        });

        cancelForDebt.setOnAction(actionEvent -> {
            panelForDebt.toBack();
        });

        deleteButtonForDebt.setOnAction(actionEvent -> {
            removeOperation();
            initTableOperation();
        });

        buttonCancelAddAccount.setOnAction(actionEvent -> {
            panelForMainForAcc.toFront();
        });


        buttonDebt.setOnAction(actionEvent -> {

            panelForDebt.toFront();
        });

        buttonAnalysis.setOnAction(actionEvent -> {
            anchorPaneAnalysis.toFront();
        });

        buttonUpdateForMainAcc.setOnAction(actionEvent -> {
            changeAcc =new String();
            checkBoxAccountForChangeAcc.getEditor().clear();
            paneForAddForChangeAcc.toFront();
            initChangeAcc();
        });



        initAccount();
        initDebt();
        initTransfer();
        initIncome();
        initTableOperation();
        initConsumption();
        initCommonAccess();
        initTableUsers();
        initAnalysis();
      //  initChangeAcc();


    }

    void initChangeAcc(){

        ObservableList<String> types = FXCollections.observableArrayList();

        for (int i = 0; i < accounts.size(); i++) {
            types.add(accounts.get(i).getName() + "(" + accounts.get(i).getKindOfMoney() + ")");
        }

        checkBoxAccountForChangeAcc.setItems(types);

        checkBoxAccountForChangeAcc.setOnAction(actionEvent -> {

            changeAcc = checkBoxAccountForChangeAcc.getValue();
            if(changeAcc!=null){

            for(int i = 0;i<accounts.size();i++){

                if(changeAcc.equals(accounts.get(i).getName() + "("+ accounts.get(i).getKindOfMoney() + ")")){
                   changeAcc  = accounts.get(i).getUniqueNumber();
                }

            }
            int k = Integer.valueOf(changeAcc) ;
            textFieldNameForChangeAcc.setText(accounts.get(k).getName());
            textFieldCurrentBalanceForChangeAcc.setText(accounts.get(k).getCurrencyBalance());}
        });

        buttonCancelChangeAcc.setOnAction(actionEvent -> {
            paneForAddForChangeAcc.toBack();
            checkBoxAccountForChangeAcc.setValue(null);
            textFieldCurrentBalanceForChangeAcc.clear();
            textFieldNameForChangeAcc.clear();

        });

        saveAccountForChangeAcc.setOnAction(actionEvent -> {
            paneForAddForChangeAcc.toFront();
            addUpdateAcc();



        });


    }

    public void initAccount() {
        checkAccount();
        buttonMyAccount.setOnAction(actionEvent -> {

            anchorPaneMyAcc.toFront();
        });
        initBalance();

        //System.out.println(accountArrayList.get(0).getKindOfAccount());

        ObservableList<String> types = FXCollections.observableArrayList("Карта", "Наличные");
        ObservableList<String> kindOfMoney = FXCollections.observableArrayList("USD", "BYR", "EUR");
        kindOfAccountForAcc.setItems(types);
        kindOfMoneyForAcc.setItems(kindOfMoney);


//        balanceText.setText("1000$");
//        Text text1 = new Text("hello");Text text2 = new Text("hello");
//        paneBalanceForAcc.getChildren().setAll(text1);

        addAccountForAcc.setOnAction(actionEvent -> {
            paneForAddForAcc.toFront();

        });

        saveAccountForAcc.setOnAction(actionEvent -> {
            addAccount(cl);
            initBalance();

        });

    }

    public void initBalance() {

        accounts = cl.receiveDataForAccount();

        double sumBalanceUSD = 0;
        double sumBalanceEUR = 0;
        double sumBalanceBYR = 0;

        ArrayList<Text> dataField = new ArrayList<>();
        ArrayList<Text> textField = new ArrayList<>();

        dataField.add(cashDataText1);
        dataField.add(cashlessDataText1);
        dataField.add(cashDataText2);
        dataField.add(cashlessDataText2);
        dataField.add(cashDataText3);
        dataField.add(cashlessDataText3);

        textField.add(cashNameText1);
        textField.add(cashlessNameText1);
        textField.add(cashNameText2);
        textField.add(cashlessNameText2);
        textField.add(cashNameText3);
        textField.add(cashlessNameText3);


        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getKindOfMoney().equals("USD")) {
                sumBalanceUSD += Double.valueOf(accounts.get(i).getCurrencyBalance());
            } else if (accounts.get(i).getKindOfMoney().equals("EUR")) {
                sumBalanceEUR += Double.valueOf(accounts.get(i).getCurrencyBalance());
            } else sumBalanceBYR += Double.valueOf(accounts.get(i).getCurrencyBalance());

        }

        balanceText1.setText(String.valueOf(sumBalanceUSD + " " + "USD"));
        balanceText11.setText(String.valueOf(sumBalanceEUR + " " + "EUR"));
        balanceText.setText(String.valueOf(sumBalanceBYR + " " + "BYR"));


        for (int i = 0; i < accounts.size(); i++) {
            double sum = Double.valueOf(accounts.get(i).getCurrencyBalance());
            textField.get(i).setText(accounts.get(i).getName() + "(" + accounts.get(i).getKindOfAccount() + ")");
            dataField.get(i).setText(String.valueOf(sum) + " " + accounts.get(i).getKindOfMoney());
        }


    }

    public void initDebt() {

        checkInputForDebt();
        saveRecordDebt.setOnAction(actionEvent -> {


            addDebt();

        });

        ButtonDetailedForDebt.setOnAction(actionEvent -> {
            if (operationTemp != null) {
                detailedDebt();
            }
        });

        ObservableList<String> types = FXCollections.observableArrayList();

        for (int i = 0; i < accounts.size(); i++) {
            types.add(accounts.get(i).getName() + "(" + accounts.get(i).getKindOfMoney() + ")");
        }

        checkBoxAccountForDebt.setItems(types);

    }

    public void initAnalysis() {
        buttonCreateReport.setOnAction(actionEvent -> {

                addReport();


        });

        buttonCreatePieConsumption.setOnAction(actionEvent -> {
            panePieConsumption.toFront();
        });
        ObservableList<String> types = FXCollections.observableArrayList();

        for (int i = 0; i < accounts.size(); i++) {
            types.add(accounts.get(i).getName() + "(" + accounts.get(i).getKindOfMoney() + ")");
        }

        checkComboBoxAccountForAnalysis.setItems(types);
    }


    public void addReport()  {
        String account;

        double commonSum = 0;
        double sumConsumption = 0, sumIncome = 0;
        Double sumCategory[] = new Double[6];
        for(int i=0;i<sumCategory.length; i++){
            sumCategory[i]=0.0;
        }

        LocalDate dateFrom, dateTo;
        account = checkComboBoxAccountForAnalysis.getValue();
        dateFrom = dataPickerFromAnalysis.getValue();
        dateTo = dataPickerToAnalysis.getValue();

        if(dateFrom==null )
        {
            Shake shake = new Shake(dataPickerFromAnalysis);
            shake.playAnim();
        }
        else if(dateTo==null){
            Shake shake = new Shake(dataPickerToAnalysis);
            shake.playAnim();
        }



        else if(account==null){
            Shake shake = new Shake(checkComboBoxAccountForAnalysis);
            shake.playAnim();
        }
        else {

        String date1 = dateFrom.toString();
        String date2 = dateTo.toString();

        for (int i = 0; i < accounts.size(); i++) {
            if (account.equals(accounts.get(i).getName() + "(" + accounts.get(i).getKindOfMoney() + ")")) {
                account = accounts.get(i).getUniqueNumber();
            }
        }

        FileWriter writer = null;
        File file = new File("D:\\курсовая 5 сем\\Client\\src\\Report\\report.txt");


        try {
            if(file.createNewFile()) {
                System.out.println("Файл создан!");

            }
            else{

            writer = new FileWriter("D:\\курсовая 5 сем\\Client\\src\\Report\\report.txt");
                writer.write("          ОТЧЁТ c "+date1+" по "+date2+"\n");
                writer.write("=================================================================================\n");

            for (int i = 0; i < debts.size(); i++) {

                int k = Integer.valueOf(debts.get(i).getAccount());
                if (k == Integer.parseInt(account)) {
                    LocalDate date = LocalDate.parse(debts.get(i).getDate());
                    if (date.compareTo(dateFrom) > 0 && dateTo.compareTo(date) > 0) {

                        Debt debt = debts.get(i);

                        if(debt.getKindOfDebt().equals("мне дали в долг/ мне вернули долг")){
                            sumIncome+=Double.valueOf(debt.getSum());
                        }
                        else {
                            sumConsumption+=Double.valueOf(debt.getSum());
                        }

                        commonSum+=Double.valueOf(debt.getSum());

                        writer.write("          ОТЧЁТ по операции Долг\n");
                        writer.write("\n");
                        writer.write("Номер операции:        " + debt.getId());
                        writer.write("\n");
                        writer.write("Название операции:     " + debt.getName());
                        writer.write("\n");
                        writer.write("Тип:                   " + debt.getKindOfDebt());
                        writer.write("\n");
                        writer.write("Кому или кто должен:   " + debt.getDestination());
                        writer.write("\n");
                        k = Integer.valueOf(debt.getAccount());
                        writer.write("Сумма операции:        " + debt.getSum() + " " + accounts.get(k).getKindOfMoney());
                        writer.write("\n");

                        writer.write("Счёт:                  " + accounts.get(k).getName() + "( " + accounts.get(k).getKindOfAccount() + ") ");
                        writer.write("\n");
                        writer.write("Дата операции:         " + debt.getDate());
                        writer.write("\n");
                        writer.write("=================================================================================\n");
                    }

                }
            }


            for (int i = 0; i < transfers.size(); i++) {

                    int k = Integer.valueOf(transfers.get(i).getAccount());
                    if (k == Integer.parseInt(account)) {
                        LocalDate date = LocalDate.parse(transfers.get(i).getDate());
                        if (date.compareTo(dateFrom) > 0 && dateTo.compareTo(date) > 0) {
                            Transfer transfer = transfers.get(i);

                            commonSum+=Double.valueOf(transfer.getSum());
                            writer.write("          ОТЧЁТ по операции Перевод\n");
                            writer.write("\n");
                            writer.write("Номер операции:        " + transfer.getId());
                            writer.write("\n");
                            writer.write("Название операции:     " + transfer.getName());
                            writer.write("\n");

                            k = Integer.valueOf(transfer.getAccount());
                            writer.write("Сумма операции:        " + transfer.getSum() + " " + accounts.get(k).getKindOfMoney());
                            writer.write("\n");

                            writer.write("Счёт:                  " + accounts.get(k).getName() + "( " + accounts.get(k).getKindOfAccount() + ") ");
                            writer.write("\n");
                            int kTo = Integer.valueOf(transfer.getId_accountTo());
                            writer.write("На Счёт:               " + accounts.get(kTo).getName() + "( " + accounts.get(kTo).getKindOfAccount() + ") ");
                            writer.write("\n");
                            writer.write("Дата операции:         " + transfer.getDate());
                            writer.write("\n");
                            writer.write("=================================================================================\n");
                        }

                    }
                }


            for (int i = 0; i < incomes.size(); i++) {

                    int k = Integer.valueOf(incomes.get(i).getAccount());
                    if (k == Integer.parseInt(account)) {
                        LocalDate date = LocalDate.parse(incomes.get(i).getDate());
                        if (date.compareTo(dateFrom) > 0 && dateTo.compareTo(date) > 0) {
                            Income income = incomes.get(i);
                            sumIncome+=Double.valueOf(income.getSum());
                            commonSum+=Double.valueOf(income.getSum());
                            writer.write("          ОТЧЁТ по операции Доход\n");
                            writer.write("\n");
                            writer.write("Номер операции:        " + income.getId());
                            writer.write("\n");
                            writer.write("Название операции:     " + income.getName());
                            writer.write("\n");
                            writer.write("Откого:                " + income.getPayer());
                            writer.write("\n");

                             k = Integer.valueOf(income.getAccount());
                            writer.write("Сумма операции:        " + income.getSum() + " " + accounts.get(k).getKindOfMoney());
                            writer.write("\n");

                            writer.write("Счёт:                  " + accounts.get(k).getName() + "( " + accounts.get(k).getKindOfAccount() + ") ");
                            writer.write("\n");
                            writer.write("Дата операции:         " +income.getDate());
                            writer.write("\n");
                            writer.write("=================================================================================\n");

                        }

                    }
                }

            for (int i = 0; i < consumptions.size(); i++) {

                    int k = Integer.valueOf(consumptions.get(i).getAccount());
                    if (k == Integer.parseInt(account)) {
                        LocalDate date = LocalDate.parse(consumptions.get(i).getDate());
                        if (date.compareTo(dateFrom) > 0 && dateTo.compareTo(date) > 0) {
                            Consumption consumption = consumptions.get(i);
                            commonSum+=Double.valueOf(consumption.getSum());
                            sumConsumption+=Double.valueOf(consumption.getSum());

                            if(consumption.getCategory().equals("Дети")){
                                sumCategory[0]+=Double.valueOf(consumption.getSum());
                            }
                                if(consumption.getCategory().equals("Продукты")){
                                    sumCategory[1]+=Double.valueOf(consumption.getSum());}

                                    if(consumption.getCategory().equals("Ресторан")){
                                        sumCategory[2]+=Double.valueOf(consumption.getSum());
                                    }

                                        if(consumption.getCategory().equals("Машина")){
                                            sumCategory[3]+=Double.valueOf(consumption.getSum());
                                        }

                                            if(consumption.getCategory().equals("Подарки")){
                                                sumCategory[4]+=Double.valueOf(consumption.getSum());
                                            }
                                                if(consumption.getCategory().equals("Прочее")){
                                                    sumCategory[5]+=Double.valueOf(consumption.getSum());
                                                }



                                                writer.write("          ОТЧЁТ по операции Расход\n");
                            writer.write("\n");
                            writer.write("Номер операции:        " + consumption.getId());
                            writer.write("\n");
                            writer.write("Название операции:     " + consumption.getName());
                            writer.write("\n");
                            writer.write("Категория:             " + consumption.getCategory());
                            writer.write("\n");

                            k = Integer.valueOf(consumption.getAccount());
                            writer.write("Сумма операции:        " + consumption.getSum() + " " + accounts.get(k).getKindOfMoney());
                            writer.write("\n");

                            writer.write("Счёт:                  " + accounts.get(k).getName() + "( " + accounts.get(k).getKindOfAccount() + ") ");
                            writer.write("\n");
                            writer.write("Дата операции:         " +consumption.getDate());
                            writer.write("\n");
                            writer.write("=================================================================================\n");

                        }

                    }
                }



                try {
                    writer.write("\n");
                    writer.write("Сумма доходов: "+sumIncome+" \n");
                    writer.write("Сумма расходов: " + sumConsumption+"\n");
                    writer.write("Cумма расходов по категориям\n");
                    writer.write("   Дети:       "+sumCategory[0]+"   \n");
                    writer.write("   Продукты:   "+sumCategory[1]+"   \n");
                    writer.write("   Ресторан:   "+sumCategory[2]+"   \n");
                    writer.write("   Машина:     "+sumCategory[3]+"   \n");
                    writer.write("   Подарки:    "+sumCategory[4]+"   \n");
                    writer.write("   Прочее:     "+sumCategory[5]+"   \n");

                    writer.write("=================================================================================\n");


                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                    new PieChart.Data("Дети",  sumCategory[0]),
                    new PieChart.Data("Продукты",  sumCategory[1]),
                    new PieChart.Data("Ресторан",  sumCategory[2]),
                    new PieChart.Data("Машина",  sumCategory[3]),
                    new PieChart.Data("Подарки",  sumCategory[4]),
                    new PieChart.Data("Прочее",  sumCategory[5]));


            piechartConsumption.setData(pieChartData);
            piechartConsumption.setStartAngle(90);

            buttonCreatePieConsumption.setDisable(false);
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataPickerToAnalysis.getEditor().clear();
        dataPickerFromAnalysis.getEditor().clear();
        checkComboBoxAccountForAnalysis.setValue(null);
        }
    }




    public void initTransfer(){

        checkInputForTransfer();
        saveRecordForTransfer.setOnAction(actionEvent -> {
            addTransfer();

        });


        ObservableList<String> types = FXCollections.observableArrayList();

        for(int i = 0; i < accounts.size();i++){
            types.add(accounts.get(i).getName() + "("+ accounts.get(i).getKindOfMoney() + ")");
        }

        checkBoxAccountFROMForTransfer.setItems(types);
        checkBoxAccountTOForTransfer.setItems(types);

    }

    public void initIncome(){

        checkInputForIncome();
        saveRecordIncome.setOnAction(actionEvent -> {
            addIncome();
        });

        ObservableList<String> types = FXCollections.observableArrayList();

        for(int i = 0; i < accounts.size();i++){
            types.add(accounts.get(i).getName() + "("+ accounts.get(i).getKindOfMoney() + ")");
        }

        checkBoxAccountForIncome.setItems(types);
        checkBoxAccountForIncome.setItems(types);

    }

    public void initConsumption(){

        checkInputForConsumption();

        saveRecordConsumption.setOnAction(actionEvent -> {

            addConsumption();

        });

        ButtonDetailedForDebt.setOnAction(actionEvent -> {
            if(operationTemp!=null){
                detailedDebt();}
        });

        ObservableList<String> types = FXCollections.observableArrayList();

        for(int i = 0; i < accounts.size();i++){
            types.add(accounts.get(i).getName() + "("+ accounts.get(i).getKindOfMoney() + ")");
        }

        checkBoxAccountForConsumption.setItems(types);

        ObservableList<Categories> categories = FXCollections.observableArrayList();
        categories.add(Categories.Дети);
        categories.add(Categories.Машина);
        categories.add(Categories.Подарки);
        categories.add(Categories.Продукты);
        categories.add(Categories.Рестораны);
        categories.add(Categories.Прочее);

        checkBoxCategoriaForConsumption.setItems(categories);

    }

    public void initTableOperation(){

        ColumIdOperation.setCellValueFactory(new PropertyValueFactory<>("number"));
        columTypeOfOperation.setCellValueFactory(new PropertyValueFactory<>("type"));
        columNameOfOperation.setCellValueFactory(new PropertyValueFactory<>("name"));
        columDateOfOperation.setCellValueFactory(new PropertyValueFactory<>("date"));
        columSumOfOperation.setCellValueFactory(new PropertyValueFactory<>("sum"));
        // debts.clear();
        debts = new ArrayList<>();
        operations= new ArrayList<>();
        dataForTable = FXCollections.observableArrayList();
        debts = cl.receiveDataForDebt();
        transfers = cl.receiveDataForTransfer();
        incomes = cl.receiveDataForIncome();
        consumptions = cl.receiveDataForConsumption();
        filterData = new FilteredList<>(dataForTable, e->true);


        for(int i =0 ;i<debts.size(); i++){

            Operation oper = new Operation();
            oper.setNumber(operations.size()+1);
            oper.setName(debts.get(i).getName());
            oper.setType(debts.get(i).getType());
            oper.setId(debts.get(i).getId());
            oper.setDate(debts.get(i).getDate());
            int k = Integer.valueOf(debts.get(i).getAccount()) ;

            oper.setSum(debts.get(i).getSum() +" "+ accounts.get(k).getKindOfMoney());
            operations.add(oper);
        }


        for(int i = 0; i < transfers.size();i++){
            Operation oper = new Operation();
            oper.setNumber(operations.size()+1);
            oper.setName(transfers.get(i).getName());
            oper.setType(transfers.get(i).getType());
            oper.setId(transfers.get(i).getId());
            oper.setDate(transfers.get(i).getDate());
            int k = Integer.valueOf(transfers.get(i).getAccount()) ;

            oper.setSum(transfers.get(i).getSum() +" "+ accounts.get(k).getKindOfMoney());
            operations.add(oper);

        }


        for(int i =0 ;i<incomes.size(); i++){

            Operation oper = new Operation();
            oper.setNumber(operations.size()+1);
            oper.setName(incomes.get(i).getName());
            oper.setType(incomes.get(i).getType());
            oper.setId(incomes.get(i).getId());
            oper.setDate(incomes.get(i).getDate());
            int k = Integer.valueOf(incomes.get(i).getAccount()) ;

            oper.setSum(incomes.get(i).getSum() +" "+ accounts.get(k).getKindOfMoney());
            operations.add(oper);
        }

        for(int i =0 ;i<consumptions.size(); i++){

            Operation oper = new Operation();
            oper.setNumber(operations.size()+1);
            oper.setName(consumptions.get(i).getName());
            oper.setType(consumptions.get(i).getType());
            oper.setId(consumptions.get(i).getId());
            oper.setDate(consumptions.get(i).getDate());
            int k = Integer.valueOf(consumptions.get(i).getAccount()) ;

            oper.setSum(consumptions.get(i).getSum() +" "+ accounts.get(k).getKindOfMoney());
            operations.add(oper);
        }


        for(int i = operations.size()-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){

                LocalDate date1 =LocalDate.parse(operations.get(j).getDate());
                LocalDate date2 =LocalDate.parse(operations.get(j+1).getDate());
                if( date1.compareTo(date2)>0 ){

                    Operation temp = operations.get(j);
                    operations.set(j,operations.get(j+1));
                    operations.set((j+1),temp);

                }
            }
        }


        for(int i =0;i<operations.size();i++){
            operations.get(i).setNumber((i+1));
            dataForTable.add(operations.get(i));
        }


        tableForOperation.setItems(dataForTable);
    }

    public void initTableUsers(){

        tablecolumnForComAcces.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnRoleForComAcces.setCellValueFactory(new PropertyValueFactory<>("role"));

        users = new ArrayList<>();
        dataForTableUser = FXCollections.observableArrayList();
        users = cl.receiveDataForAddUser();

        for(int i =0;i<users.size();i++){

            dataForTableUser.add(users.get(i));
        }

        tableviewForUser.setItems(dataForTableUser);
    }

    public void initCommonAccess(){
        checkInputForAddAccess();

        buttonBackFromPie.setOnAction(actionEvent -> {
            panePieConsumption.toBack();
        });


        deleteEmailForComAcces.setOnAction(actionEvent -> {
            removeUser();
            initTableUsers();

        });

    }

    public  void checkAccount(){

            DoubleValidator doubleValidator = new DoubleValidator();
            RegexValidator regexValidator = new RegexValidator();
            RegexValidator regexValidatorForVendorCode = new RegexValidator();

            // doubleValidator.getOnMouseClicked()
            doubleValidator.setMessage("Недопустимые символы");
            regexValidator.setRegexPattern("^[а-яА-ЯёЁa-zA-Z ]{0,20}");
            regexValidator.setMessage("Недопустимые символы");
            regexValidatorForVendorCode.setMessage("Недопустимые символы");
            regexValidatorForVendorCode.setRegexPattern("^[а-яА-ЯёЁa-zA-Z0-9]{5,15}$");

            textFieldCurrentBalanceForAcc.getValidators().add(doubleValidator);


            textFieldCurrentBalanceForAcc.focusedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                    if(!newValue){
                        textFieldCurrentBalanceForAcc.validate();
                    }
                }
            });

            textFieldNameOfAccountForAcc.getValidators().add(regexValidator);
            textFieldNameOfAccountForAcc.focusedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                    if(!newValue){

                        textFieldNameOfAccountForAcc.validate();
                    }
                }
            });



    }


    public void addUser(){
        String email, role = "User";
        email = textFieldEmailForComAcces.getText().trim();
        if(checkBoxForComAcces.isSelected()){
            role ="Admin";
        }
        if(email.equals("") || !textFieldEmailForComAcces.validate() )
        {
            Shake shake = new Shake(textFieldEmailForComAcces);
            shake.playAnim();
        }

        else {
            cl.sendDataForAddNewAccess(email, role);

        }
    }

    public void addAccount(ClientSomthing cl) {


        String name, typeOfMoney, typeOfAccount, balance;
        name = textFieldNameOfAccountForAcc.getText().trim();
        typeOfAccount = kindOfAccountForAcc.getValue();
        typeOfMoney = kindOfMoneyForAcc.getValue();
        balance = textFieldCurrentBalanceForAcc.getText().trim();



        if (name.equals("")) {
            Shake user = new Shake(textFieldNameOfAccountForAcc);
            user.playAnim();
        }
        else if (typeOfAccount ==null) {
            Shake user = new Shake(kindOfAccountForAcc);
            user.playAnim();
        } else if (typeOfMoney==null) {
            Shake user = new Shake(kindOfMoneyForAcc);
            user.playAnim();
        } else if (balance.equals("")) {
            Shake user = new Shake(textFieldCurrentBalanceForAcc);
            user.playAnim();
        }  else {


            cl.sendDataForAddAccount(name,typeOfAccount,typeOfMoney,balance, accounts.size());
            panelForMainForAcc.toFront();
            initAccount();
            initTransfer();
            initDebt();
            initIncome();
            initConsumption();
            initAnalysis();

        }

        textFieldNameOfAccountForAcc.clear();
        textFieldCurrentBalanceForAcc.clear();




    }

    public void addUpdateAcc() {


        String name;
        String balance;


        name = textFieldNameForChangeAcc.getText().trim();
        balance = textFieldCurrentBalanceForChangeAcc.getText().trim();


        if (name.equals("")) {
            Shake user = new Shake(textFieldNameForChangeAcc);
            user.playAnim();
        }

        else if(changeAcc==null){
            Shake user = new Shake(checkBoxAccountForChangeAcc);
            user.playAnim();
        }
         else if (balance.equals("")) {
            Shake user = new Shake(textFieldCurrentBalanceForChangeAcc);
            user.playAnim();
        }  else {


            cl.sendDataForUpdateAccount(changeAcc,name,balance);
            panelForMainForAcc.toFront();
            initAccount();
            initTransfer();
            initDebt();
            initIncome();
            initConsumption();
            initAnalysis();
            checkBoxAccountForChangeAcc.setValue(null);
            textFieldCurrentBalanceForChangeAcc.clear();
            textFieldNameForChangeAcc.clear();


        }

        textFieldNameOfAccountForAcc.clear();
        textFieldCurrentBalanceForAcc.clear();




    }

    public void addDebt(){

        String name,destination, kindOfDebt, sum, account;
        LocalDate date;
        name = textFieldNameForDebt.getText().trim();
        destination = textFieldWhoForDebt.getText().trim();
        account = checkBoxAccountForDebt.getValue();

        sum = textFieldSumForDebt.getText();
        date = DatedateForDebt.getValue();

        kindOfDebt = "я дал долг/ я вернул долг";

        if(radioBIGotForDebt.isSelected()){

            kindOfDebt = "мне дали в долг/ мне вернули долг";

        }



        if(name.equals("") || !textFieldNameForDebt.validate() )
        {
            Shake shake = new Shake(textFieldNameForDebt);
            shake.playAnim();
        }
        else if(account==null){
            Shake shake = new Shake(checkBoxAccountForDebt);
            shake.playAnim();
        }

        else if(sum.equals("") || !textFieldSumForDebt.validate()){
            Shake shake = new Shake(textFieldSumForDebt);
            shake.playAnim();
        }
        else if(destination.equals("") || !textFieldWhoForDebt.validate()){
            Shake shake = new Shake(textFieldWhoForDebt);
            shake.playAnim();
        }

        else if(date==null){
            Shake shake = new Shake(DatedateForDebt);
            shake.playAnim();
        }

        else {
            String date1 = date.toString();
            for(int i = 0;i<accounts.size();i++){
                if(account.equals(accounts.get(i).getName() + "("+ accounts.get(i).getKindOfMoney() + ")")){
                    account = accounts.get(i).getUniqueNumber();
                }
            }
            cl.sendDataForAddDebt(name, date1, destination, kindOfDebt, sum, account);

            textFieldNameForDebt.clear();
            textFieldSumForDebt.clear();
            textFieldWhoForDebt.clear();
            panelForTable.toFront();
            DatedateForDebt.getEditor().clear();
            checkBoxAccountForDebt.setValue(null);
            initAccount();
            initTableOperation();
        }



    }

    public void addTransfer(){

        String name, sum, accountFrom, accountTo;
        LocalDate date;
        name = textFieldNameForTransfer.getText().trim();
        accountFrom = checkBoxAccountFROMForTransfer.getValue();
        accountTo = checkBoxAccountTOForTransfer.getValue();


        sum = textFieldSumForTransfer.getText();
        date = DatedateForTransfer.getValue();

        if(name.equals("") || !textFieldNameForTransfer.validate() )
        {
            Shake shake = new Shake(textFieldNameForTransfer);
            shake.playAnim();
        }
        else if(accountFrom==null){
            Shake shake = new Shake(checkBoxAccountFROMForTransfer);
            shake.playAnim();
        }

        else if(accountTo==null){
            Shake shake = new Shake(checkBoxAccountTOForTransfer);
            shake.playAnim();
        }

        else if(sum.equals("") || !textFieldSumForTransfer.validate()){
            Shake shake = new Shake(textFieldSumForTransfer);
            shake.playAnim();
        }


        else if(date==null){
            Shake shake = new Shake(DatedateForTransfer);
            shake.playAnim();
        }
        else {

            int indexFrom = 0, indexTo = 0;

            for (int i = 0; i < accounts.size(); i++) {
                if (accountFrom.equals(accounts.get(i).getName() + "(" + accounts.get(i).getKindOfMoney() + ")")) {
                    accountFrom = accounts.get(i).getUniqueNumber();
                    indexFrom = i;
                }
            }

            for (int i = 0; i < accounts.size(); i++) {
                if (accountTo.equals(accounts.get(i).getName() + "(" + accounts.get(i).getKindOfMoney() + ")")) {
                    accountTo = accounts.get(i).getUniqueNumber();
                    indexTo = i;
                }
            }

            String date1 = date.toString();

            if (accounts.get(indexFrom).getKindOfMoney().equals(accounts.get(indexTo).getKindOfMoney())) {
                cl.sendDataForAddTransfer(name, accountFrom, accountTo, sum, date1);
                cl.sendDataForCountTransfer(accountFrom, accountTo, sum);

                panelForTable.toFront();
                DatedateForDebt.getEditor().clear();
                checkBoxAccountForDebt.setValue(null);
                textFieldNameForTransfer.clear();
                textFieldSumForTransfer.clear();
                initTableOperation();
                initAccount();

            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Неверные данные. Разная валюта!");
                alert.showAndWait();
            }


        }



    }

    public void addIncome(){
        String name, payer,  sum, account;
        LocalDate date;
        name = textFieldNameForIncome.getText().trim();
        payer = textFieldPayerForIncome.getText().trim();
        account = checkBoxAccountForIncome.getValue();


        sum = textFieldSumForIncome.getText();
        date = DatedateForIncome.getValue();


        if(name.equals("") || !textFieldNameForIncome.validate() )
        {
            Shake shake = new Shake(textFieldNameForIncome);
            shake.playAnim();
        }
        else if(account==null){
            Shake shake = new Shake(checkBoxAccountForIncome);
            shake.playAnim();
        }

        else if(sum.equals("") || !textFieldSumForIncome.validate()){
            Shake shake = new Shake(textFieldSumForIncome);
            shake.playAnim();
        }
        else if(payer.equals("") || !textFieldPayerForIncome.validate()){
            Shake shake = new Shake(textFieldPayerForIncome);
            shake.playAnim();
        }

        else if(date==null){
            Shake shake = new Shake(DatedateForIncome);
            shake.playAnim();
        }
        else {

            for(int i = 0;i<accounts.size();i++){
                if(account.equals(accounts.get(i).getName() + "("+ accounts.get(i).getKindOfMoney() + ")")){
                    account = accounts.get(i).getUniqueNumber();
                }
            }
            String date1 = date.toString();

            cl.sendDataForAddIncome(name, date1, payer, sum, account);

            textFieldNameForIncome.clear();
            textFieldSumForIncome.clear();
            textFieldPayerForIncome.clear();
            panelForTable.toFront();
            DatedateForIncome.getEditor().clear();
            checkBoxAccountForIncome.setValue(null);
            initAccount();
            initTableOperation();

        }


    }

    public void addConsumption(){
        String name, sum, account;
        String category;
        LocalDate date;
        name = textFieldNameForConsumption.getText().trim();
        account = checkBoxAccountForConsumption.getValue();
        sum = textFieldSumForConsumption.getText();
        date = DatedateForConsumption.getValue();
        category = String.valueOf(checkBoxCategoriaForConsumption.getValue());



        if(name.equals("") || !textFieldNameForConsumption.validate() )
        {
            Shake shake = new Shake(textFieldNameForConsumption);
            shake.playAnim();
        }
        else if(account==null){
            Shake shake = new Shake(checkBoxAccountForConsumption);
            shake.playAnim();
        }

        else if(sum.equals("") || !textFieldSumForConsumption.validate()){
            Shake shake = new Shake(textFieldSumForConsumption);
            shake.playAnim();
        }
        else if(category.equals("")){
            Shake shake = new Shake(checkBoxCategoriaForConsumption);
            shake.playAnim();
        }

        else if(date==null){
            Shake shake = new Shake(DatedateForConsumption);
            shake.playAnim();
        }

        else {
            for(int i = 0;i<accounts.size();i++){
                if(account.equals(accounts.get(i).getName() + "("+ accounts.get(i).getKindOfMoney() + ")")){
                    account = accounts.get(i).getUniqueNumber();
                }
            }

            String date1 = date.toString();

            cl.sendDataForAddConsumption(name, date1, category, sum, account);

            textFieldNameForConsumption.clear();
            textFieldSumForConsumption.clear();
            panelForTable.toFront();
            DatedateForConsumption.getEditor().clear();
            checkBoxAccountForConsumption.setValue(null);

            initAccount();
            initTableOperation();

        }


    }

    public void detailedDebt()  {


        try {
            File file = new File("D:\\курсовая 5 сем\\Client\\src\\Report\\report.txt");



            if(file.createNewFile()) {
                System.out.println("Файл создан!");

            }
            else{

                if(operationTemp.getType().equals("Долг")) {

                    Debt debt = new Debt();
                    for (int i = 0; i < debts.size(); i++) {
                        if (debts.get(i).getId().equals(operationTemp.getId())) {
                            debt = debts.get(i);
                        }
                    }
                    FileWriter writer = new FileWriter("D:\\курсовая 5 сем\\Client\\src\\Report\\report.txt");
                    writer.write("          ОТЧЁТ по операции Долг\n");
                    writer.write("\n");
                    writer.write("Номер операции:        " + debt.getId());
                    writer.write("\n");
                    writer.write("Название операции:     " + debt.getName());
                    writer.write("\n");
                    writer.write("Тип:                   " + debt.getKindOfDebt());
                    writer.write("\n");
                    writer.write("Кому или кто должен:   " + debt.getDestination());
                    writer.write("\n");
                    int k = Integer.valueOf(debt.getAccount());
                    writer.write("Сумма операции:        " + debt.getSum() + " " + accounts.get(k).getKindOfMoney());
                    writer.write("\n");

                    writer.write("Счёт:                  " + accounts.get(k).getName() + "( " + accounts.get(k).getKindOfAccount() + ") ");
                    writer.write("\n");
                    writer.write("Дата операции:         " + debt.getDate());
                    writer.write("\n");
                    writer.close();
                }



               else if(operationTemp.getType().equals("Перевод")) {

                    Transfer transfer = new Transfer();

                    for (int i = 0; i < transfers.size(); i++) {
                        if (transfers.get(i).getId().equals(operationTemp.getId())) {
                            transfer = transfers.get(i);
                        }
                    }
                    FileWriter writer = new FileWriter("D:\\курсовая 5 сем\\Client\\src\\Report\\report.txt");
                    writer.write("          ОТЧЁТ по операции Перевод\n");
                    writer.write("\n");
                    writer.write("Номер операции:        " + transfer.getId());
                    writer.write("\n");
                    writer.write("Название операции:     " + transfer.getName());
                    writer.write("\n");

                    int k = Integer.valueOf(transfer.getAccount());
                    writer.write("Сумма операции:        " + transfer.getSum() + " " + accounts.get(k).getKindOfMoney());
                    writer.write("\n");

                    writer.write("Счёт:                  " + accounts.get(k).getName() + "( " + accounts.get(k).getKindOfAccount() + ") ");
                    writer.write("\n");
                    int kTo = Integer.valueOf(transfer.getId_accountTo());
                    writer.write("На Счёт:               " + accounts.get(kTo).getName() + "( " + accounts.get(kTo).getKindOfAccount() + ") ");
                    writer.write("\n");
                    writer.write("Дата операции:         " + transfer.getDate());
                    writer.write("\n");
                    writer.close();
                }

               else if(operationTemp.getType().equals("Доход")) {

                    Income income = new Income();

                    for (int i = 0; i < incomes.size(); i++) {
                        if (incomes.get(i).getId().equals(operationTemp.getId())) {
                            income = incomes.get(i);
                        }
                    }
                    FileWriter writer = new FileWriter("D:\\курсовая 5 сем\\Client\\src\\Report\\report.txt");
                    writer.write("          ОТЧЁТ по операции Доход\n");
                    writer.write("\n");
                    writer.write("Номер операции:        " + income.getId());
                    writer.write("\n");
                    writer.write("Название операции:     " + income.getName());
                    writer.write("\n");
                    writer.write("Откого:                " + income.getPayer());
                    writer.write("\n");

                    int k = Integer.valueOf(income.getAccount());
                    writer.write("Сумма операции:        " + income.getSum() + " " + accounts.get(k).getKindOfMoney());
                    writer.write("\n");

                    writer.write("Счёт:                  " + accounts.get(k).getName() + "( " + accounts.get(k).getKindOfAccount() + ") ");
                    writer.write("\n");
                    writer.write("Дата операции:         " +income.getDate());
                    writer.write("\n");
                    writer.close();
                }

                else if(operationTemp.getType().equals("Расход")) {

                    Consumption consumption = new Consumption();

                    for (int i = 0; i < consumptions.size(); i++) {
                        if (consumptions.get(i).getId().equals(operationTemp.getId())) {
                            consumption = consumptions.get(i);
                        }
                    }
                    FileWriter writer = new FileWriter("D:\\курсовая 5 сем\\Client\\src\\Report\\report.txt");
                    writer.write("          ОТЧЁТ по операции Расход\n");
                    writer.write("\n");
                    writer.write("Номер операции:        " + consumption.getId());
                    writer.write("\n");
                    writer.write("Название операции:     " + consumption.getName());
                    writer.write("\n");
                    writer.write("Категория:             " + consumption.getCategory());
                    writer.write("\n");

                    int k = Integer.valueOf(consumption.getAccount());
                    writer.write("Сумма операции:        " + consumption.getSum() + " " + accounts.get(k).getKindOfMoney());
                    writer.write("\n");

                    writer.write("Счёт:                  " + accounts.get(k).getName() + "( " + accounts.get(k).getKindOfAccount() + ") ");
                    writer.write("\n");
                    writer.write("Дата операции:         " +consumption.getDate());
                    writer.write("\n");
                    writer.close();
                }
                Desktop.getDesktop().open(file);

            };



        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void onMouseClickedForOperation(MouseEvent event) {

        operationTemp =new Operation();
        ObservableList<Operation> operSelected = null;

        operSelected = tableForOperation.getSelectionModel().getSelectedItems();


        if(operSelected.size() != 0){

            operationTemp.setType(operSelected.get(0).getType());
            operationTemp.setId(operSelected.get(0).getId());

        }
    }

    @FXML
    public void OnActionSearch(ActionEvent actionEvent) {
        initTableOperation();
        filterData = new FilteredList<>(dataForTable, e->true);
        textFIeldSeachForDebt.textProperty().addListener((observableValue, oldValue, newValue)->{
            filterData.setPredicate((Operation operation)->{
                String newVal = newValue.toLowerCase();
                return operation.getId().toLowerCase().contains(newVal)
                        || operation.getSum().toLowerCase().contains(newVal)
                        || operation.getType().toLowerCase().contains(newVal)
                        || operation.getDate().toLowerCase().contains(newVal)
                        || operation.getName().toLowerCase().contains(newVal);


            });
            tableForOperation.setItems(filterData);
        });

    }

   public void removeOperation(){
       ObservableList<Operation> data;
       ObservableList<Operation> operSelected;
       data = tableForOperation.getItems();
       operSelected = tableForOperation.getSelectionModel().getSelectedItems();
       if(operSelected.size()!=0){
           cl.removeTableOperation(operSelected.get(0).getType(),operSelected.get(0).getId());

       }
   }

    public void removeUser(){
        ObservableList<User> data;
        ObservableList<User> userSelected;
        data = tableviewForUser.getItems();
        userSelected = tableviewForUser.getSelectionModel().getSelectedItems();
        if(userSelected.size()!=0){

            cl.removeTableOperation("Пользователь",userSelected.get(0).getEmail());

        }
    }


    public void checkInputForDebt(){

        DoubleValidator doubleValidator = new DoubleValidator();
        RegexValidator regexValidator = new RegexValidator();
        RegexValidator regexValidatorForVendorCode = new RegexValidator();

        // doubleValidator.getOnMouseClicked()
        doubleValidator.setMessage("Недопустимые символы");
        regexValidator.setRegexPattern("^[а-яА-ЯёЁa-zA-Z ]{0,20}");
        regexValidator.setMessage("Недопустимые символы");
        regexValidatorForVendorCode.setMessage("Недопустимые символы");
        regexValidatorForVendorCode.setRegexPattern("^[а-яА-ЯёЁa-zA-Z0-9]{5,15}$");

        textFieldSumForDebt.getValidators().add(doubleValidator);


        textFieldSumForDebt.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if(!newValue){
                    textFieldSumForDebt.validate();
                }
            }
        });

       textFieldNameForDebt.getValidators().add(regexValidator);
        textFieldNameForDebt.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if(!newValue){

                    textFieldNameForDebt.validate();
                }
            }
        });

        textFieldWhoForDebt.getValidators().add(regexValidator);
        textFieldWhoForDebt.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if(!newValue){

                    textFieldWhoForDebt.validate();
                }
            }
        });








    }

    public void checkInputForTransfer(){

        DoubleValidator doubleValidator = new DoubleValidator();
        RegexValidator regexValidator = new RegexValidator();
        RegexValidator regexValidatorForVendorCode = new RegexValidator();

        // doubleValidator.getOnMouseClicked()
        doubleValidator.setMessage("Недопустимые символы");
        regexValidator.setRegexPattern("^[а-яА-ЯёЁa-zA-Z ]{0,20}");
        regexValidator.setMessage("Недопустимые символы");
        regexValidatorForVendorCode.setMessage("Недопустимые символы");
        regexValidatorForVendorCode.setRegexPattern("^[а-яА-ЯёЁa-zA-Z0-9]{5,15}$");

        textFieldSumForTransfer.getValidators().add(doubleValidator);


        textFieldSumForTransfer.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if(!newValue){
                    textFieldSumForTransfer.validate();
                }
            }
        });

        textFieldNameForTransfer.getValidators().add(regexValidator);
        textFieldNameForTransfer.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if(!newValue){

                    textFieldNameForTransfer.validate();
                }
            }
        });


    }

    public void checkInputForIncome(){

        DoubleValidator doubleValidator = new DoubleValidator();
        RegexValidator regexValidator = new RegexValidator();
        RegexValidator regexValidatorForVendorCode = new RegexValidator();

        // doubleValidator.getOnMouseClicked()
        doubleValidator.setMessage("Недопустимые символы");
        regexValidator.setRegexPattern("^[а-яА-ЯёЁa-zA-Z ]{0,20}");
        regexValidator.setMessage("Недопустимые символы");
        regexValidatorForVendorCode.setMessage("Недопустимые символы");
        regexValidatorForVendorCode.setRegexPattern("^[а-яА-ЯёЁa-zA-Z0-9]{5,15}$");

        textFieldSumForIncome.getValidators().add(doubleValidator);


        textFieldSumForIncome.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if(!newValue){
                    textFieldSumForIncome.validate();
                }
            }
        });

        textFieldNameForIncome.getValidators().add(regexValidator);
        textFieldNameForIncome.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if(!newValue){

                    textFieldNameForIncome.validate();
                }
            }
        });

        textFieldPayerForIncome.getValidators().add(regexValidator);
        textFieldPayerForIncome.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if(!newValue){

                    textFieldPayerForIncome.validate();
                }
            }
        });


    }

    public void checkInputForConsumption(){

        DoubleValidator doubleValidator = new DoubleValidator();
        RegexValidator regexValidator = new RegexValidator();
        RegexValidator regexValidatorForVendorCode = new RegexValidator();

        // doubleValidator.getOnMouseClicked()
        doubleValidator.setMessage("Недопустимые символы");
        regexValidator.setRegexPattern("^[а-яА-ЯёЁa-zA-Z ]{0,20}");
        regexValidator.setMessage("Недопустимые символы");
        regexValidatorForVendorCode.setMessage("Недопустимые символы");
        regexValidatorForVendorCode.setRegexPattern("^[а-яА-ЯёЁa-zA-Z0-9]{5,15}$");

        textFieldSumForConsumption.getValidators().add(doubleValidator);


        textFieldSumForConsumption.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if(!newValue){
                    textFieldSumForConsumption.validate();
                }
            }
        });

        textFieldNameForConsumption.getValidators().add(regexValidator);
        textFieldNameForConsumption.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if(!newValue){

                    textFieldNameForConsumption.validate();
                }
            }
        });




    }

    public void checkInputForAddAccess() {

        DoubleValidator doubleValidator = new DoubleValidator();
        RegexValidator regexValidator = new RegexValidator();
        RegexValidator regexValidatorForEmail = new RegexValidator();


        doubleValidator.setMessage("Недопустимые символы");
        regexValidator.setRegexPattern(" ^[а-яА-ЯёЁa-zA-Z ]{0,20}");
        regexValidator.setMessage("Недопустимые символы");
        regexValidatorForEmail.setMessage("Недопустимые символы");

        regexValidatorForEmail.setRegexPattern("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");





        textFieldEmailForComAcces.getValidators().add(regexValidatorForEmail);
        textFieldEmailForComAcces.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if (!newValue) {

                    textFieldEmailForComAcces.validate();
                }
            }
        });


    }


    @FXML
    void onMouseClickedTableUser(MouseEvent event) {
        userTemp = new User();
        ObservableList<User> userSelected = null;

        userSelected = tableviewForUser.getSelectionModel().getSelectedItems();


        if(userSelected.size() != 0){

            userTemp.setEmail(userSelected.get(0).getEmail());


        }
    }
}
