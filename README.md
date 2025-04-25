# Documentación proyecto Prueba Técnica NUAM

El proyecto que aquí se presenta, contiene un backend desarrollado en springboot, utlizando JPA, Spring Validation y Java.

## Arquitectura del proyecto

La arquitectura del proyecto esta basado en la arquitectura por capas esto con el fin de tener separadas bien definidas responsabilidades dentro del proyecto:

- [x] Capa de controlador
- [x] Caoa de servicios
- [x] Capa de repositorios
- [x] Capa de modelos

Este enfoque ofrece diferentes ventajas como la separación de responsabilidades, una mayor mantenibilidad a largo plazo y una mejor base para hacer testing, pues esta arquitectura permite hacer testing con algo mas de facilidad, existe independencia entre capas y ademas ofrece flexibilidad para cambiar diferentes implementaciones sin que se afecten otras capas.

## Docker

Se creó dos archivos para la ejecución del proyecto mediante docker, asi se mantiene un centralizada la ejecución del mismo. Para ello, desde la carpeta raíz del proyecto basta con ejecutar el comando `docker-compose up --build` para poder ejecutar la creación de los dos contenedores, el `dockerfile` funciona para compilar el codigo a un .jar que ejecutará docker posteriormente, y dentro del `docker-compose.yml` se tiene la información de ejecución del dockerfile y la base de datos, que para este caso es una base de datos postgres.

## Flujo de trabajo

Para el flujo de trabajo se generaron dos principales ramas, la rama `main` y la rama `dev` para efectos practicos se manejó principalmente en la rama dev, sin embargo, para cada feature se debe crear su respectiva rama para la creación de cada seccion. Al ser un proyecto pequeño realmente se hizo muy poca separación de ramas, puesto que la relación de cada avance involucraba practicamente todas las secciones del codigo. Sin embargo, para ciertas secciones si se creo si respectiva rama con el modelo feat/{NombreRama} fix/{Nombre Rama} esto con el fin de manejar orden en cada uno.
Por otra parte, los commits tambien tenian cierta estructura, como: "feat: se crean los repositorios para producto" o "fix: se arregla orden de findAll"
