# Prueba Técnica - Nelumbo Consultores

Este proyecto es la solución desarrollada para la prueba técnica solicitada por Nelumbo Consultores. Está implementado en **Kotlin** utilizando **Jetpack Compose**, siguiendo las mejores prácticas recomendadas por Google para el desarrollo de aplicaciones Android.

## Arquitectura del Proyecto

El proyecto implementa **Clean Architecture** junto con el patrón **MVVM** (Model-View-ViewModel), asegurando una separación de responsabilidades clara y promoviendo la escalabilidad, mantenibilidad y capacidad de prueba del código.

### Estructura de Capas

1. **UI**:
    - Implementada con **Jetpack Compose** para una interfaz de usuario declarativa y reactiva.
    - Utiliza ViewModels para interactuar con el estado y manejar la lógica de presentación.

2. **Domain**:
    - Contiene las entidades y casos de uso (Use Cases).
    - Los casos de uso gestionan la lógica de negocio principal e interactúan con la capa de **Data** mediante **Kotlin Coroutines** para realizar operaciones de manera asincrónica y eficiente.
    - Es completamente independiente de frameworks y librerías externas.

3. **Data**:
    - Maneja las fuentes de datos locales (SharedPreferences) y remotas (API).
    - Proporciona implementaciones concretas para las interfaces definidas en la capa **Domain**.

4. **DI (Dependency Injection)**:
    - Configuración de inyección de dependencias mediante **Hilt**, asegurando un ciclo de vida óptimo para los componentes y facilitando las pruebas.

## Detalles Técnicos

- **Lenguaje**: Kotlin
- **Framework UI**: Jetpack Compose
- **Arquitectura**: Clean Architecture con MVVM
- **Inyección de Dependencias**: Hilt
- **Gestión de Concurrencia**: Uso de **Kotlin Coroutines** en los casos de uso dentro de la capa **Domain** para manejar operaciones asincrónicas de manera no bloqueante.

## Pruebas

Se implementaron pruebas unitarias para garantizar la calidad del código y la correcta funcionalidad de los componentes:
- **JUnit**: Para la escritura de pruebas unitarias en la lógica de negocio y lógica de presentación.
- **MockK**: Framework utilizado para la creación de mocks y simulación de dependencias durante las pruebas.