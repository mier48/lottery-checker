# Lottery Checker

[![Version: 1.0](https://img.shields.io/badge/Version-1.0-blue.svg)](./README.md)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](./LICENSE)

**Lottery Checker** es un proyecto desarrollado en **Kotlin** que permite escanear décimos de la Lotería de Navidad de España y comprobar automáticamente si tienen premio. Es una herramienta simple y eficiente para los jugadores que desean verificar sus números sin complicaciones.

> **Estado del proyecto**: En desarrollo. Algunas funcionalidades pueden estar incompletas o no implementadas.

## Características

- **Escaneo de décimos**: Usa la cámara del dispositivo o una imagen para capturar el número del décimo.
- **Comprobación automática**: Conecta con las bases de datos oficiales para verificar si el décimo tiene premio.
- **Interfaz intuitiva**: Diseñado para facilitar la interacción del usuario con opciones claras.
- **Rendimiento optimizado**: Procesa la información rápidamente, incluso con múltiples números.

## Tecnologías Utilizadas

- **Lenguaje**: Kotlin
- **Frameworks**:
  - Ktor o Spring Boot (para futuras integraciones con APIs externas).
- **Bibliotecas**: OpenCV o similar (para reconocimiento de texto en imágenes).
- **Herramientas de Construcción**: Gradle

## Instalación

### Requisitos previos

1. **JDK 11 o superior**: Asegúrate de tener instalado Java Development Kit (JDK).
2. **Gradle**: Para gestionar dependencias.
3. **Dependencias adicionales**:
   - OpenCV o una biblioteca de OCR como Tesseract.

### Pasos de Instalación

1. Clona este repositorio:
   ```bash
   git clone https://github.com/mier48/lottery-checker.git
   cd lottery-checker
   ```

2. Construye el proyecto usando Gradle:
   ```bash
   ./gradlew build
   ```

3. Ejecuta la aplicación:
   ```bash
   ./gradlew run
   ```

## Uso

### Funcionalidades Actuales

1. **Escaneo de números**:
   - Permite capturar el número del décimo desde una imagen.
   - Verifica la validez del número.

2. **Comprobación de premios**:
   - Consulta si el número escaneado tiene algún premio.
   - Muestra el resultado de forma clara.

> **Nota**: Estas funcionalidades están en desarrollo y pueden no estar completamente funcionales.

### Ejemplo de Ejecución

Al ejecutar la aplicación, puedes interactuar con las opciones disponibles para escanear y verificar números.

```kotlin
fun main() {
    println("Bienvenido a Lottery Checker")
    println("Seleccione una opción:")
    println("1. Escanear décimo")
    println("2. Comprobar premios")
    // Más opciones próximamente...
}
```

## Contribuciones

¡Contribuciones, reportes de errores y sugerencias son bienvenidos! Siéntete libre de abrir un _issue_ o enviar un _pull request_.

### Planes Futuros

- **Integración con APIs oficiales**: Consulta automática de resultados de la Lotería de Navidad.
- **Soporte para múltiples sorteos**: Más allá de la Lotería de Navidad.
- **Aplicación móvil**: Implementación multiplataforma usando herramientas como Kotlin Multiplatform o Compose Multiplatform.

## Licencia

Este proyecto está licenciado bajo la [Licencia MIT](./LICENSE).

---
