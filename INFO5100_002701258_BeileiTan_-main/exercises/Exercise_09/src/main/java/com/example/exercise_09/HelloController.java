package com.example.exercise_09;

import com.example.exercise_09.utils.EvaluateString;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class HelloController {
    @FXML
    private Label expression;

    @FXML
    private Label result;

    public void insertOperator(String operator){
        expression.setText(expression.getText() + " " + operator + " ");
    }

    public void insertNumber(String number){
        expression.setText(expression.getText() + number);
    }

    public void clearExpression(){
        expression.setText("");
    }

    public Label getExpression(){
        return expression;
    }

    public void setResult(String newResult){
        this.result.setText(newResult);
    }

    public void onMouseClick(MouseEvent mouseEvent) {
        Button button = (Button) mouseEvent.getSource();
        String buttonText =  button.getText();

        switch (buttonText){
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
                insertNumber(buttonText);
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                insertOperator(buttonText);
                break;
            case "AC":
                clearExpression();
                break;
            case "=":
                int result = EvaluateString.evaluate(this.getExpression().getText());
                setResult(String.valueOf(result));
                break;
        }
    }
}