package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.util.Map;

public class CalculatorController {

    Map<String, Runnable> operations = Map.of(
        "Suma", this::sum,
        "Resta", this::substract,
        "Multiplicación", this::multiply,
        "División", this::divide
    );

    @FXML
    private TextField number1;

    @FXML
    private TextField number2;

    @FXML
    private TextField result;

    @FXML
    private ToggleGroup operacion;

    @FXML
    private HBox result_container;

    /**
     * Muestra un cuadro de diálogo de error con el mensaje proporcionado.
     *
     * @param message El mensaje de error a mostrar.
     */
    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error en la operación");
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Muestra un cuadro de diálogo de error indicando que los números no son válidos.
     */
    private void notValidNumberAlert() {
        showErrorAlert("Los números no son válidos o están en blanco");
    }

    /**
     * Convierte una cadena de texto en un número decimal (Double).
     *
     * @param number La cadena de texto que se va a convertir.
     * @return El número convertido en Double, o null si la cadena no puede ser convertida.
     */
    private Double parseNumber(String number) {
        try {
            // Eliminar espacios en blanco y sustituir comas por puntos
            number = number.trim().replace(",", ".");

            // Devolver null si la cadena está en blanco o es nula
            if (number.isBlank()) {
                return null;
            }

            // Convertir la cadena a un número decimal
            return Double.parseDouble(number);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Obtiene el número 1 de la interfaz de usuario y lo convierte en Double.
     *
     * @return El número 1 como Double, o null si no es un número válido.
     */
    private Double getNumber1() {
        return parseNumber(number1.getText());
    }

    /**
     * Obtiene el número 2 de la interfaz de usuario y lo convierte en Double.
     *
     * @return El número 2 como Double, o null si no es un número válido.
     */
    private Double getNumber2() {
        return parseNumber(number2.getText());
    }


    /**
     * Establece el resultado en la interfaz de usuario.
     *
     * @param result El resultado de la operación a mostrar.
     */
    private void setResult(Double result) {
        this.result.setText(result.toString());
        this.result_container.setVisible(true);
    }

    /**
     * Realiza la operación de suma y muestra el resultado.
     */
    private void sum() {
        try {
            Double total = getNumber1() + getNumber2();
            setResult(total);
        } catch (NullPointerException e) {
            notValidNumberAlert();
        }
    }

    /**
     * Realiza la operación de resta y muestra el resultado.
     */
    private void substract() {
        try {
            Double total = getNumber1() - getNumber2();
            setResult(total);
        } catch (NullPointerException e) {
            notValidNumberAlert();
        }
    }

    /**
     * Realiza la operación de multiplicación y muestra el resultado.
     */
    private void multiply() {
        try {
            Double total = getNumber1() * getNumber2();
            setResult(total);
        } catch (NullPointerException e) {
            notValidNumberAlert();
        }
    }

    /**
     * Realiza la operación de división y muestra el resultado.
     */
    private void divide() {
        try {
            Double total = getNumber1() / getNumber2();
            setResult(total);
        } catch (NullPointerException e) {
            notValidNumberAlert();
        } catch (ArithmeticException e) {
            showErrorAlert("No se puede dividir por cero");
        }
    }

    /**
     * Método que maneja el evento de calcular la operación seleccionada.
     * Obtiene la operación seleccionada y la ejecuta.
     */
    @FXML
    public void calculate() {
        RadioButton selectedRadioButton = (RadioButton) operacion.getSelectedToggle();

        if (selectedRadioButton == null) {
            showErrorAlert("Selecciona una operación");
            return;
        }

        String selectedText  = selectedRadioButton.getText();
        Runnable operation = operations.get(selectedText);

        if (operation != null) {
            operation.run();
        }else {
            showErrorAlert("Operación no válida");
        }
    }

}
