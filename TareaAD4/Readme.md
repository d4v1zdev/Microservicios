# AD-4. Tarea en equipo. Microservicios web con Spring Boot



Enunciado

Una Empresa tiene recogido en una base de datos los pedidos solicitados por Clientes y el Comercial asociado a la venta. La tabla pedidos recoge el importe total del pedido realizado.

La aplicación la van a usar los jefes de comerciales para ver la información, tanto de clientes como de sus comerciales.

Tablas:



![Captura de pantalla 2023-02-04 a las 15.57.16](https://github.com/d4v1zdev/Microservicios/blob/main/TareaAD4/img/ventas2023_bbdd.png)



Se adjunta el script del sql (en la unidad formativa UF6) con la creación de la base de datos (ventasbbdd_2023) de las tablas, insert para pruebas y creación del usuario uventas_2023 con la password uventas.

**Ejercicio**

Crear un proyecto Spring web, con Spring data Jpa y MySql 8 para los siguientes servicios web restfull, y probar con postman:

 

| **url**         | **Descripción**                                              |
| --------------- | ------------------------------------------------------------ |
| /comercial      | @RequestMapping(“/comercial”)                                |
| /alta           | Dar de alta el comercial                                     |
| /eliminar/{id}  | Eliminar de la bbdd el comercial cuyo id coincida            |
| /uno/{id}       | Devolver los datos del comercial cuyo id coincida            |
| /bycliente/{id} | Devolver la lista de los comerciales que han atendido pedidos del cliente que coincida con ese id. |
| /conpedidos     | Devolver la lista de comerciales que han atendido algún pedido |
| /pedidos/{id}   | Devolver la lista de pedidos gestionados por el comercial que coincida con ese id. |

 

**Entrega**

Crear un proyecto con el nombre de tu grupo (GrupoXX_) Actividad_UF6. Y guardarlo en zip.

Crear un documento pdf que recoja las pruebas en postman de cada uno de los servicios rest ejecutados.

La nota se generará de acuerdo a los siguientes criterios:

- 40% : código y calidad y exactitud del código.
- 30% : documento pdf con pruebas postman.
- 30% : resultado de la ejecución de cada prueba.



