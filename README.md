# AUTO_FRONT_SCREENPLAY - Financial Management

Este repositorio contiene la automatización de pruebas de interfaz de usuario (UI) para el módulo de Gestión de Transacciones Financieras, utilizando el patrón **Screenplay** y **Serenity BDD**.

## 🚀 Misión del Proyecto
Este proyecto forma parte del **Taller Semana 5: Maestría en Automatización**. El objetivo es demostrar la implementación del patrón Screenplay para crear pruebas robustas, escalables y fáciles de mantener, aplicando el principio de responsabilidad única en cada componente.

## 🛠️ Stack Tecnológico
*   **Lenguaje**: Java 17+
*   **Patrón de Diseño**: Screenplay (Actors, Tasks, Actions, Questions, UI)
*   **Framework**: Serenity BDD + Cucumber
*   **Gestión de Dependencias**: Gradle
*   **Navegador**: Google Chrome (Configurado vía `serenity.conf`)

## 📁 Estructura del Proyecto
```text
src/test/java/com/automation/
│
├── screenplay/
│   ├── tasks/         # Tareas (Acciones de negocio: Login, Register, AddTransaction)
│   ├── questions/     # Validaciones (Consultas a la UI: TransactionList)
│   └── ui/            # Mapeo de elementos (Targets de Serenity)
│
├── steps/
│   └── definitions/   # Implementación de los pasos de Cucumber (Step Definitions)
│
└── runners/           # Clase ejecutora de las pruebas
```

## 📋 Prerrequisitos
*   Java JDK 17 o superior.
*   Navegador Google Chrome.
*   Conexión a internet (para descarga automática de dependencias y binarios del driver).

## 🏃 Instrucciones de Ejecución
Para ejecutar la suite de pruebas completa y generar los reportes de Serenity, utiliza el siguiente comando:

```bash
./gradlew clean test aggregate
```

*(En Windows, si no usas Bash, utiliza `.\gradlew clean test aggregate`)*

## 📊 Living Documentation (Reportes)
Al finalizar los tests, puedes visualizar el reporte detallado (con capturas de pantalla de cada acción) en:
`target/site/serenity/index.html`

## ✅ Criterios de Calidad Aplicados
*   **Responsabilidad Única (SRP)**: Cada tarea se enfoca en una sola acción de negocio.
*   **Código Limpio**: Nomenclatura semántica y ausencia de código comentado.
*   **Separación de Preocupaciones**: Los localizadores están aislados de la lógica de las tareas.

## 👨‍💻 Autor
*   **Estudiante**: Elian / Luis (Maestría en Automatización)
*   **Entrega**: Taller Semana 5
