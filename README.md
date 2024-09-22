## Ejemplo de API Spring con Docker

Este proyecto es para tener un servicio API dockerizado por lo que facilitaría su deploy en un servidor.

**NOTA** Es importante que antes de correr el docker compose, debes usar maven para crear la carpeta target y el archivo
.jar, de lo contrario, no funcionará.

## Cómo usar

### Antes de correr docker

Debes tener instalado en tu máquina la JVM en su versión 22, ya que esta se usó para la creación de este proyecto, así
evitarás conflictos.

Correr los siguientes comandos
```mvn clean install```

Esto creará el archivo .jar necesario para ejecutar la aplicación con Docker

### correr con docker

**NOTA** Debes crear un archivo .env usando de ejemplo en archivo envExample para nombrar las variables necesarias para
levantar tu entorno.
![img.png](img.png)

Una vez generado el archivo .jar, ya puedes correr el siguiente comando:

```
docker compose up
```

Esto creará los contenedores necesarios para levantar la aplicación.

## Tabla necesaria para la correcta ejecución

Para poder que funcione el CRUD de esta API, debes generar una tabla products de la siguiente manera:

```postgresql
create table products
(
    name        varchar(50),
    description varchar(250),
    id          serial
        constraint id
            primary key
);
```

De esta forma no tendrás conflictos con los datos que le mandas a la base de datos desde la API.

Y estas son las acciones que puedes realizar:

* GET - localhost:8080/api/products
* GET - localhost:8080/api/products/{id}
* POST - localhost:8080/api/products
* PUT - localhost:8080/api/products/{id}
* DELETE - localhost:8080/api/products/{id}

Y este el JSON necesario para create y put:
```json
{
	"name": "nombre",
	"description": "descripción"
}
```

Espero te sirva! 
[Twitter](https://x.com/AngieMatiz6) -
[LinkedIn](https://www.linkedin.com/in/angie-matiz/)