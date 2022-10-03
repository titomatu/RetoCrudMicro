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

curl -i -X POST -H 'Content-Type: application/json' -d '{"configuredLevel": "TRACE"}' http://localhost:8085/actuator/loggers/edu.pica.microservices.retocrudmicro

En el cuerpo observamos un JSON donde el valor del campo configuredLevel establecemos la severidad deseada.

Podemos consultar nuevamente la severidad cambiada ejcutando:

curl http://localhost:9090/actuator/loggers/edu.pica.microservices.retocrudmicro



