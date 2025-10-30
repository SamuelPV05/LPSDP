# Application Bank

**Application Bank** es un proyecto desarrollado en **Java 21** utilizando **Spring Boot** y **Maven**.  
Su objetivo es simular operaciones bancarias como creación de clientes, apertura de cuentas, depósitos, retiros y transferencias.  
La aplicación expone una **API REST**, que permite interactuar con estas operaciones mediante solicitudes HTTP.

---

## Tecnologías y Herramientas

- Java 21  
- Spring Boot  
- Maven  
- Visual Studio Code
- Swagger (OpenAPI 3)
- Thunder Client (para pruebas de la API)

### Requisitos

Antes de ejecutar el proyecto, instala:

| Herramienta | Descripción | Enlace |
|------------|-------------|-------|
| **Java SE Development Kit (JDK 21)** | Necesario para compilar y ejecutar la aplicación. | [Descargar](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) |
| **Visual Studio Code** | Editor recomendado para desarrollo. | [Descargar](https://code.visualstudio.com/) |

#### Extensiones recomendadas en VS Code
- Extension Pack for Java  
- Maven for Java  
- Spring Boot Extension Pack  
- Spring Boot Dashboard  
- Thunder Client  

---

## Preparación y Ejecución del Proyecto

### 1. Descargar y abrir el proyecto
- Clona el repositorio o descarga el ZIP desde GitHub.  
- Extrae los archivos en una carpeta local.  
- Abre VS Code y selecciona **Archivo → Abrir carpeta** para abrir el proyecto.

### 2. Configurar extensiones
- Verifica que las extensiones de Java, Maven y Spring Boot estén instaladas.  
- Esto permite compilar, ejecutar y depurar el proyecto correctamente.

### 3. Iniciar el servidor
Puedes arrancar la aplicación de dos formas:

**Opción A: Spring Boot Dashboard**  
- Abre el panel de Spring Boot.  
- Selecciona el proyecto y haz clic en **Run**.

**Opción B: Terminal**
```bash
./mvnw spring-boot:run
```
---
## Probando la API con Thunder Client

1. Abre **Thunder Client** en VS Code.  
2. Crea una nueva solicitud (**New Request**).  
3. Configura la petición:

- **Método:** POST  
- **URL:** `http://localhost:8080/api/bank/customers`  
- **Body (JSON):**
```json
{
  "id": "1",
  "name": "Juan",
  "email": "juancarlossalazar@gmail.com"
}
```
4. Presiona **Send** para crear el cliente.
5. Verifica en el navegador:
```bash
http://localhost:8080/api/bank/customers
```

## Endpoints y Operaciones

| Acción             | Método | URL                                              | Detalles                                      |
|--------------------|--------|--------------------------------------------------|-----------------------------------------------|
| Crear cliente      | POST   | /api/bank/customers                              | Añade un nuevo cliente.                       |
| Crear cuenta       | POST   | /api/bank/customers/{id_cliente}/accounts        | Vincula una cuenta a un cliente existente.    |
| Consultar cuenta   | GET    | /api/bank/accounts/{id_cuenta}                   | Obtiene la información de una cuenta.         |
| Depositar dinero   | POST   | /api/bank/accounts/{id_cuenta}/deposit?amount={monto} | Incrementa el saldo de la cuenta.        |
| Retirar dinero     | POST   | /api/bank/accounts/{id_cuenta}/withdraw?amount={monto} | Disminuye el saldo de la cuenta.        |
| Transferir dinero  | POST   | /api/bank/accounts/{id_cuenta}/transfer          | Envía dinero a otra cuenta.                   |

# Clientes

## Endpoints

- **POST** `/api/bank/customers` → Crear cliente  
- **GET** `/api/bank/customers` → Listar clientes  
- **GET** `/api/bank/customers/{id}` → Consultar cliente por ID  

---

### Ejemplo de creación de cliente (POST /api/bank/customers)

```json
{
  "id": "1",
  "name": "Juan Pérez",
  "email": "juan@example.com"
}
```
### Ejemplo de listar clientes (GET /api/bank/customers)
```json
  {
    "id": "1",
    "name": "Juan Pérez",
    "email": "juan@example.com"
  },
  {
    "id": "2",
    "name": "María Gómez",
    "email": "maria@example.com"
  }
```
### Ejemplo de consultar cliente por ID (GET /api/bank/customers/{id})
```json
{
  "id": "1",
  "name": "Juan Pérez",
  "email": "juan@example.com"
}
```
# Cuentas

## Endpoints

- **POST** `/api/bank/customers/{id}/accounts` → Crear cuenta (ahorros o corriente)  
- **GET** `/api/bank/accounts` → Listar cuentas  
- **GET** `/api/bank/accounts/{id}` → Consultar cuenta por ID  

---

### Ejemplo de creación de cuenta de ahorros (POST /api/bank/customers/{id}/accounts)

```json
{
  "type": "savings",
  "balance": { "amount": 2000.0, "currency": "USD" },
  "interestRate": 0.05
}
```
### Ejemplo de creación de cuenta corriente (POST /api/bank/customers/{id}/accounts)
```json
{
  "type": "checking",
  "balance": { "amount": 500.0, "currency": "USD" },
  "overdraftLimit": 200.0
}
```
### Ejemplo de listado de cuentas (GET /api/bank/accounts)
```json
  {
    "id": "A001",
    "customerId": "1",
    "type": "savings",
    "balance": { "amount": 2000.0, "currency": "USD" },
    "interestRate": 0.05
  },
  {
    "id": "A002",
    "customerId": "2",
    "type": "checking",
    "balance": { "amount": 500.0, "currency": "USD" },
    "overdraftLimit": 200.0
  }
```
### Ejemplo de consulta de cuenta por ID (GET /api/bank/accounts/{id})
```json
{
  "id": "A001",
  "customerId": "1",
  "type": "savings",
  "balance": { "amount": 2000.0, "currency": "USD" },
  "interestRate": 0.05
}
```
# Operaciones

## Endpoints

- **POST** `/api/bank/accounts/{id}/deposit?amount=X` → Depositar dinero  
- **POST** `/api/bank/accounts/{id}/withdraw?amount=X` → Retirar dinero  
- **POST** `/api/bank/accounts/{id}/transfer` → Transferir dinero  
- **POST** `/api/bank/accounts/{id}/apply-interest` → Aplicar intereses (solo cuentas de ahorro)  
- **GET** `/api/bank/accounts/{id}/transactions` → Consultar transacciones de una cuenta  

---

### Ejemplo de depósito (POST /api/bank/accounts/{id}/deposit?amount=X)

```json
{
  "accountId": "A001",
  "amount": 300
}
```
### Ejemplo de retiro (POST /api/bank/accounts/{id}/withdraw?amount=X)
```json
{
  "accountId": "A001",
  "amount": 150
}
```
### Ejemplo de transferencia (POST /api/bank/accounts/{id}/transfer)
```json
{
  "toAccountId": "A002",
  "amount": 300
}
```
### Ejemplo de aplicar intereses (POST /api/bank/accounts/{id}/apply-interest)
```json
{
  "accountId": "A001"
}
```
### Ejemplo de transacciones (GET /api/bank/accounts/{id}/transactions)
```json
  {
    "type": "DEP",
    "amount": { "amount": 500.0, "currency": "USD" },
    "accountId": "A001",
    "timestamp": "2025-10-30T12:30:45.123"
  },
  {
    "type": "WDR",
    "amount": { "amount": 200.0, "currency": "USD" },
    "accountId": "A001",
    "timestamp": "2025-10-30T12:35:10.456"
  }
```
---
## Notas

- La aplicación utiliza el puerto 8080 por defecto.
- Puedes usar Thunder Client, Postman u otro cliente REST para probar los endpoints.
- Si realizas cambios en el código, reinicia el servidor para que se apliquen.
- No se necesitan imágenes ni configuraciones adicionales.

---
## Pruebas con Postman

No se pudieron adjuntar las pruebas realizadas con Postman debido a las restricciones de mi equipo institucional, que impiden la instalación y ejecución de software adicional.  
Sin embargo, el proyecto fue probado y los endpoints funcionan correctamente según lo esperado.

---

## AUTOR
Con cariño, **Samuel Pérez.**
