
# Calculadora en JavaFX

Proyecto para la asignatura de Entornos de Desarrollo, que consiste en recrear una calculadora sencilla para hacer operaciones entre dos números y manejar los posibles errores.


## Funciones del controlador

#### `showErrorAlert(String message)`

Muestra un cuadro de diálogo de error con el mensaje proporcionado. Útil para notificar al usuario sobre errores durante la ejecución de la aplicación.

#### `notValidNumberAlert()`

Muestra un cuadro de diálogo de error indicando que los números ingresados no son válidos o están en blanco.

#### `parseNumber(String number)`

Convierte una cadena de texto en un número decimal (Double). Elimina los espacios en blanco y reemplaza las comas por puntos. Devuelve null si la cadena no puede ser convertida.

#### `getNumber1()`

Obtiene el primer número ingresado por el usuario desde la interfaz de usuario y lo convierte en un Double. Retorna null si el número no es válido.

#### `getNumber2()`

Obtiene el segundo número ingresado por el usuario desde la interfaz de usuario y lo convierte en un Double. Retorna null si el número no es válido.

#### `setResult(Double result)`

Establece el resultado de la operación en la interfaz de usuario para que sea visible para el usuario.

#### `sum()`

Realiza la operación de suma utilizando los dos números ingresados por el usuario y muestra el resultado en la interfaz de usuario.

#### `substract()`

Realiza la operación de resta utilizando los dos números ingresados por el usuario y muestra el resultado en la interfaz de usuario.

#### `multiply()`

Realiza la operación de multiplicación utilizando los dos números ingresados por el usuario y muestra el resultado en la interfaz de usuario.

#### `divide()`

Realiza la operación de división utilizando los dos números ingresados por el usuario y muestra el resultado en la interfaz de usuario. Muestra un mensaje de error si se intenta dividir por cero.

#### `calculate()`

Método que maneja el evento de calcular la operación seleccionada por el usuario. Obtiene la operación seleccionada y la ejecuta.


## Interfaz de la Aplicación

![App Screenshot](https://raw.githubusercontent.com/MarioPB05/javafx-calculator/master/screenshots/app.png)


## Autor

- [@marioperdiguero](https://github.com/MarioPB05)

