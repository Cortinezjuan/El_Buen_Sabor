<p align="center"><img width="50%" src="https://github.com/FernandoCabrera06/El_Buen_Sabor_Frontend/blob/develop/src/assets/images/logoREADME.png"></p>

Este es el proyecto final de Laboratorio de Computación IV para la Tecnicatura Universitaria en Programación de la UTN Regional Mendoza.
Es una aplicación web responsive, que implementa un sistema de gestión de pedidos para un local de comida rápida. Utiliza una capa para los
datos (una base de datos de tipo relacional MySQL) y para resolver la lógica de negocio una API REST que resuelve todos las peticiones de los
clientes. Y por último, una interfaz gráfica de usuario de tipo responsive, con una landing page y un catáogo para navegar y realizar pedidos.
Logueandose como administrador se obtiene acceso a la administración y gestión de los articulos manufacturados en el catálogo, los insumos,
pedidos y facturación del local.  


<h1 align="center">Backend 🧮🖇️</h1>

Proyecto de tipo API REST, realizado en lenguaje Java con SpringBoot. La arquitectura está dividida en cuatro capas:

    🔸Entidad: aca se encuentran todos los modelos/objetos del proyecto.
  
    🔸DTO: realizados a partir de los modelos para la transferencia de objetos entre cliente/servidor.
  
    🔸Servicio: contiene toda la lógica de negocio del proyecto.
  
    🔸Repositorio: es la capa de acceso a los datos y la interacción con la base de datos.
  
    🔸Controlador: todos los endpoints encargados de resolvers las peticiones del cliente al servidor. 
  

## Requisitos para correr 📋

✅ IDE para Java, de preferencia IntelliJ IDEA 2022.1.2 o similar. 

✅ Motor y administrador de BD como MySQL Workbench 8.0 CE o XAMPP Control Panel con SQLyog Community


## Herramientas 🔧

📌 Desarrollo en JAVA 8 (v1.8.0.333) 

📌 SpringBoot (v2.7.0)

📌 MySQL (version 8.0.28 )

📌 Pluggins para JPA e Hibernate


## Ejecución 🕹️

_Localmente_

1️⃣ Abrir el proyecto ubicado dentro de la carpeta El_Buen_Sabor con IntelliJ IDEA

2️⃣ Configurar conexión a base de datos y guardar cambios en archivo application.properties en la ruta:
```
src\main\resources\application.properties
```
3️⃣ Ejecutar el motor de base de datos deseado o alguno de los recomendados (MySQL Workbench o XAMMP y SQLyog)

4️⃣ Dirigirse al método main y ejecutarlo. Ruta: 
```
src/main/java/ElbuensaborApplication
```
5️⃣ Descargar el proyecto [frontend](https://github.com/FernandoCabrera06/El_Buen_Sabor_Frontend) y continuar instrucciones.


## Repositorios del proyecto 💾
[BACKEND](https://github.com/Cortinezjuan/El_Buen_Sabor) ➖ [FRONTEND](https://github.com/FernandoCabrera06/El_Buen_Sabor_Frontend) ➖ [MERCADO PAGO](https://github.com/Cortinezjuan/elBuenSaborMP)


## Colaboradores 🧑‍💻

| <a href="https://github.com/FernandoCabrera06" target="_blank"><img width="60%" src="https://github.com/FernandoCabrera06/El_Buen_Sabor_Frontend/blob/main/src/assets/images/Fernando%20Cabrera.png"></a> | <a href="https://github.com/Cortinezjuan" target="_blank"><img width="60%" src="https://github.com/FernandoCabrera06/El_Buen_Sabor_Frontend/blob/main/src/assets/images/Juan%20Cortinez.jpg"></a> | <a href="https://github.com/LuciaScripponi" target="_blank"><img width="60%" src="https://github.com/FernandoCabrera06/El_Buen_Sabor_Frontend/blob/main/src/assets/images/Cintia%20Lucia%20Scripponi.png"></a> |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|&nbsp;&nbsp;&nbsp;&nbsp;Cabrera Fernando Damián|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cortinez Juan José|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Scripponi Cintia Lucía|  
