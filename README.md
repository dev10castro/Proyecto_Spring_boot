# 🧠 Proyecto Spring Boot de Aprendizaje

Este proyecto es una práctica sencilla con **Spring Boot** para aprender los fundamentos de desarrollo de APIs REST, persistencia con base de datos y controladores básicos en Java.

## 🚀 Tecnologías utilizadas

- Java 24
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- H2 Database (en memoria)
- Maven
- Lombok (para evitar código repetitivo)

## 📦 Funcionalidad actual

El proyecto permite:

- Exponer un endpoint `GET /hola` que devuelve un saludo simple
- Recibir un nombre por URL con `GET /hola?nombre=David`
- Recibir un objeto JSON con nombre y apellido vía `POST /saludo`
- Guardar los saludos recibidos en base de datos (H2)
- Consultar todos los saludos guardados con `GET /saludos`
- Actualizar un saludo por su ID con `PUT /saludo/{id}`
- Eliminar un saludo con `DELETE /saludo/{id}`
- Guardar múltiples saludos con un array de JSON vía `POST /saludos`

## 🔄 Ejemplo de JSON para pruebas

```json
{
  "nombre": "David",
  "apellido": "Castro"
}
