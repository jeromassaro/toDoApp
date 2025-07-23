
# ToDoApp

Aplicacion full backend de una app ToDo



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
| `id`      | `string` | **Required**. Id of item to fetch |

#### Post item

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
| `id`      | `string` | **Required**. Id of item to fetch |
| `name`      | `string` | **Required**. name task |
| `description`      | `string` | **Required**. description task |
| `status`      | `string` | **Required**. status task (open , in_progress, completed) |
| `completed`      | `bool` | **Required**. is completed? True - False |

#### Update status

```http
  Patch /task/${id}/status
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `status`      | `string` |**Required**. status task (open , in_progress, completed) |



