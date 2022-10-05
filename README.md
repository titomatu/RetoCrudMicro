# RetoCrudMicro

Arquitectura



Principios:
La Arquitectura Hexagonal propone que nuestro dominio sea el n�cleo de las capas y que este no se acople a nada externo. En lugar de hacer uso expl�cito y mediante el principio de inversi�n de dependencias nos acoplamos a contratos (interfaces o puertos) y no a implementaciones concretas.

Pasos Ejecuci�n

mvn clean
mvn install

Realizar un Build

Realizar Ejecutar

## Modificación Severidad Logs en Tiempo Ejecución

### Consultar el nivel de severidad de Logs actual

Ejecutamos un request tipo GET

curl http://localhost:9090/actuator/loggers/edu.pica.microservices.retocrudmicro

Obtenemos una respuesta así con la severidad actual:

{"configuredLevel":"ERROR","effectiveLevel":"ERROR"}

Para cambiar el nivel de severidad de los logs ejecutamos un request tipo POST:

curl -i -X POST -H 'Content-Type: application/json' -d '{"configuredLevel": "TRACE"}' http://localhost:9090/actuator/loggers/edu.pica.microservices.retocrudmicro

En el cuerpo observamos un JSON donde el valor del campo configuredLevel establecemos la severidad deseada.

Podemos consultar nuevamente la severidad cambiada ejcutando:

curl http://localhost:9090/actuator/loggers/edu.pica.microservices.retocrudmicro

#### Creacion Archivo Docker-compose.yml

Se construye la V1 del archivo .yml donde se están creando las siguientes imágenes:

1. Se crea la imagen de K8S por medio de la Redis que es una BD distribuida en memoria que ofrece estructura de datos y imágenes para realizar consultas más rápidas y escalables
   de aqui se crea la imagen registry.k8s.io/redis:e2e.

2. Se crea la imagen de mysql:5.7 para la cual se creó en el archivo .env las varibles con los datos de conexión para ser pasados por medio de variables.

3. Se declara la dependencia que hay de Spring Boot y mysql.

4. Se realiza lectura del archivo .env para leer párametros de acceso a BD y Spring Boot y asi crear por último la imagen de la app.

5. Se definen los volumenes que se asignaran a la aplicación asociándolos por medio de los comandos stdin_open: true y tty: true.





