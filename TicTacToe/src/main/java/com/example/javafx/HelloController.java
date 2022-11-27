package com.example.javafx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    //deklaracje
    int znak=1;
    int[][] board = new int[3][3];
    int tmp,turn=0;

    @FXML
    private Button BtnB;

    @FXML
    private Button BtnC;

    @FXML
    private Button BtnD;

    @FXML
    private Button BtnE;

    @FXML
    private Button BtnF;

    @FXML
    private Button BtnG;

    @FXML
    private Button BtnH;

    @FXML
    private Button BtnI;

    @FXML
    private Button BtnA;

    @FXML
    private Button Restart;

    @FXML
    private Label info;

    @FXML
    void onBtnA(ActionEvent event) {
        //wywołanie funkcji działania przycisku
        btnAction(event);
        //wpisanie znaku do tablicy
        board[0][0]=znak;
        //inkrementacja tury
        turn++;
        //wywołanie funkcji sprawdzenia czy ktoś wygrał
        CheckWinner();

    }

    @FXML
    void onBtnB(ActionEvent event) {

        btnAction(event);
        board[0][1]=znak;
        turn++;
        CheckWinner();
    }

    @FXML
    void onBtnC(ActionEvent event) {

        btnAction(event);
        board[0][2]=znak;
        turn++;
        CheckWinner();
    }

    @FXML
    void onBtnD(ActionEvent event) {

        btnAction(event);
        board[1][0]=znak;
        turn++;
        CheckWinner();
    }

    @FXML
    void onBtnE(ActionEvent event) {

        btnAction(event);
        board[1][1]=znak;
        turn++;
        CheckWinner();
    }

    @FXML
    void onBtnF(ActionEvent event) {

        btnAction(event);
        board[1][2]=znak;
        turn++;
        CheckWinner();
    }

    @FXML
    void onBtnG(ActionEvent event) {

        btnAction(event);
        board[2][0]=znak;
        turn++;
        CheckWinner();
    }

    @FXML
    void onBtnH(ActionEvent event) {

        btnAction(event);
        board[2][1]=znak;
        turn++;
        CheckWinner();
    }

    @FXML
    void onBtnI(ActionEvent event) {

        btnAction(event);
        board[2][2]=znak;
        turn++;
        CheckWinner();
    }

    @FXML
    void onRestart(ActionEvent event){
        //pętla odpowiadająca za wyzerowanie tabeli
        for(int m=0;m<=2;m++){
            for(int n=0;n<=2;n++){
                board[m][n]=0;
            }
        }
        //czyszczenie przycisków i przywracanie ich do użytku
        BtnA.setText("");
        BtnA.setDisable(false);
        BtnB.setText("");
        BtnB.setDisable(false);
        BtnC.setText("");
        BtnC.setDisable(false);
        BtnD.setText("");
        BtnD.setDisable(false);
        BtnE.setText("");
        BtnE.setDisable(false);
        BtnF.setText("");
        BtnF.setDisable(false);
        BtnG.setText("");
        BtnG.setDisable(false);
        BtnH.setText("");
        BtnH.setDisable(false);
        BtnI.setText("");
        BtnI.setDisable(false);
        //zerowanie tury
        turn=0;
        //powrót do otwierającej wiadomości
        info.setText("Tic Tac Toe");

    }

    private void btnAction(ActionEvent event){
        //deklaracja przycisku
        Button b = (Button) event.getSource();
        //wyłączenie przycisku po użyciu
        b.setDisable(true);
        //sprawdzenie czy należy wstawić X czy O i zmienienie znaku na kolejną turę
        if(znak==1){
            b.setText("X");
            znak = 2;
        }
        else if(znak==2){
            b.setText("O");
            znak = 1;
        }

    }

    private void CheckWinner(){
        //sprawdzenie i wypisanie czyj ruch
        if(turn%2==0)
            info.setText("Ruch O");
        if(turn%2==1)
            info.setText("Ruch X");
        //sprawdzenie po wierszach czy wygrało O
        for(int i=0;i<=2;i++){
            //jeżeli pierwsza liczba w wierszu jest równa 1 to zmienna tymczasowa równa się 1, jeżeli nie to 0
            if(board[i][0]==1)
                tmp = 1;
            else
                tmp = 0;
            //sprawdza wierszami
            for(int j=0;j<=2;j++){
                //jeżeli liczba w danym miejscu w tabeli jest równa 1 i zmienna tymaczasowa równa się 1
                if(board[i][j] == 1  && tmp == 1)
                    tmp = 1;
                else
                    tmp = 0;
            }
            //jeżeli zmienna tymczasowa równa się 1 na koniec sprawdzania to O wygrało
            if(tmp == 1)
                info.setText("Wygrało O! Gratulacje!");
        }
        //sprawdzenie po kolumnach czy wygrało O
        for(int p=0;p<=2;p++) {
            //jeżeli pierwsza liczba w wierszu jest równa 1 to zmienna tymczasowa równa się 1, jeżeli nie to 0
            if (board[0][p] == 1)
                tmp = 1;
            else
                tmp = 0;
            for (int r = 0; r <= 2; r++) {
                //jeżeli liczba w danym miejscu w tabeli jest równa 1 i zmienna tymaczasowa równa się 1
                if (board[r][p] == 1 && tmp == 1)
                    tmp = 1;
                else
                    tmp = 0;
            }
            //jeżeli zmienna tymczasowa równa się 1 na koniec sprawdzania to O wygrało
            if (tmp == 1)
                info.setText("Wygrało O! Gratulacje!");
        }
        //sprawdzenie po kolumnach czy wygrało X
        for(int k=0;k<=2;k++) {
            //jeżeli pierwsza liczba w wierszu jest równa 2 to zmienna tymczasowa równa się 2, jeżeli nie to 0
            if(board[k][0]==2)
                tmp = 2;
            else
                tmp = 0;
            for (int l = 0; l <= 2; l++) {
                //jeżeli liczba w danym miejscu w tabeli jest równa 2 i zmienna tymaczasowa równa się 2
                if (board[k][l] == 2 && tmp == 2)
                    tmp = 2;
                else
                    tmp = 0;
            }
            //jeżeli zmienna tymczasowa równa się 2 na koniec sprawdzania to X wygrało
            if(tmp == 2)
                info.setText("Wygrało X! Gratulacje!");
        }
        //sprawdzenie po wierszach czy wygrało X
        for(int p=0;p<=2;p++) {
            //jeżeli pierwsza liczba w wierszu jest równa 2 to zmienna tymczasowa równa się 2, jeżeli nie to 0
            if (board[0][p] == 2)
                tmp = 2;
            else
                tmp = 0;
            for (int r = 0; r <= 2; r++) {
                //jeżeli liczba w danym miejscu w tabeli jest równa 2 i zmienna tymaczasowa równa się 2
                if (board[r][p] == 2 && tmp == 2)
                    tmp = 2;
                else
                    tmp = 0;
            }
            //jeżeli zmienna tymczasowa równa się 2 na koniec sprawdzania to X wygrało
            if (tmp == 2)
                info.setText("Wygrało X! Gratulacje!");
        }
        //sprawdzenie czy O wygrało po skosie
        if((board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1) || (board[0][2] == 1 && board[1][1] == 1 && board[2][0] == 1))
            info.setText("Wygrało O! Gratulacje!");
        //sprawdzenie czy X wygrało po skosie
        if((board[0][0] == 2 && board[1][1] == 2 && board[2][2] == 2) || (board[0][2] == 2 && board[1][1] == 2 && board[2][0] == 2))
            info.setText("Wygrało X! Gratulacje!");
        //jeżeli minęło 9 tur to remis
        if(turn==9)
            info.setText("Remis!");
    }
}