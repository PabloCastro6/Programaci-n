<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculadora IMC</title>
</head>
<body>
    <h2>¿De quién quieres calcular el IMC?</h2>

    <form action="calculaIMC" method="POST">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required>

        <button type="submit">Calcular IMC</button>
    </form>
</body>
</html>

