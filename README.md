# ToDoApp

Repositorio que contiene una aplicacion backend de manejo de tareas. 
El servidor proporciona una API para interactuar con la base de datos y manejar las operaciones CRUD para las tareas.

## Tecnologias Utilizadas

- Java
- SpringBoot
- SpringData
- ApiREST
- MySQL

## API Reference

#### Get all task

```http
  GET /task
```

#### Get item

```http
  GET /task/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Required**. Id of task to fetch |

#### Create item

```http
  Post /task
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`      | `string` | **Required**. name task |
| `description`      | `string` | **Required**. description task |
| `status`      | `string` | **Required**. status task (open , in_progress, completed) |
| `completed`      | `bool` | **Required**. is completed? True - False |

#### Update item

```http
  Patch /task/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Required**. Id of the task to fetch |
| `name`      | `string` | **Required**. name task |
| `description`      | `string` | **Required**. description task |
| `status`      | `string` | **Required**. status task (open , in_progress, completed) |
| `completed`      | `bool` | **Required**. is completed? True - False |

#### Delete Item

```http
  Delete /task/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` |**Required**. id of the task that we want to delete |

#### Update status

```http
  Patch /task/${id}/status
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `status`      | `string` |**Required**. status task (open , in_progress, completed) |


#### Get item by status

```http
  GET /task/?status=COMPLETED
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `status`      | `status` | **Required**. Status that we want to fetch |
