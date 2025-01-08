<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Users</title>
    <!-- Подключаем стили Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1>Users</h1>

        <!-- Форма для фильтрации -->
        <form action="/users" method="get" class="mb-4">
            <div class="input-group">
                <input
                    type="search"
                    name="term"
                    class="form-control"
                    placeholder="Search by name"
                    value="${page.getTerm()}"
                >
                <button type="submit" class="btn btn-primary">Search</button>
            </div>
        </form>

        <!-- Вывод списка пользователей -->
        <ul class="list-group">
            #if(page.getUsers().isEmpty())
                <li class="list-group-item text-muted">No users found</li>
            #else
                #for(user : page.getUsers())
                    <li class="list-group-item">
                        ${user.getFirstName()} ${user.getLastName()} - ${user.getEmail()}
                    </li>
                #end
            #end
        </ul>
    </div>
</body>
</html>

