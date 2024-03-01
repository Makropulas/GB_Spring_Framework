## Урок 1. Системы сборки Maven и Gradle для разработки Java приложений

### [Создать проект с использованием Maven или Gradle, добавить в него несколько зависимостей и написать код, использующий эти зависимости](Homework_1/src/main/java/ru/dmalomoshin/homework1).
Пример решения:
1. Создайте новый Maven или Gradle проект, следуя инструкциям из блока 1 или блока 2.
2. Добавьте зависимости `org.apache.commons:commons-lang3:3.12.0` и `com.google.code.gson:gson:2.8.6`.
3. Создайте класс Person с полями firstName, lastName и age.
4. Используйте библиотеку commons-lang3 для генерации методов toString, equals и hashCode.
5. Используйте библиотеку gson для сериализации и десериализации объектов класса Person в формат JSON.


## Урок 2. Основы Spring. Spring Boot

### Базовое задание:
Добавить в [простое CRUD веб-приложение](Homework_2), которое было разработано на семинаре функцию удаления данных о пользователе:
1) В класс UserRepository добавить метод public void deleteById(int id)(подсказка: SQL запрос `"DELETE FROM userTable WHERE id=?"`, метод jdbc.update) - удаления записи пользователя из БД по ID.
2) В класс UserService добавить метод public void deleteById(int id)(подсказка: в нем вызывается метод userRepository.deleteById) - удаление пользователя через репозиторий.
3) В класс UserController добавить метод public String deleteUser(@PathVariable("id") int id)(с аннотацией: @GetMapping("user-delete/{id}")) (подсказка: в нем вызывается метод userService.deleteById) - перехват команды на удаление студента от браузера.

Если задание выполнено верно, то при запуске приложения по адресу http://localhost:8080/users будет работать кнопка удаления пользователя по ID.

### Задание "со звездочкой":
Реализовать метод обновления данных о пользователе.
- @GetMapping("/user-update/{id}")
- @PostMapping("/user-update")
- User update(User user)
- User getOne(int id)


## Урок 3. Использование Spring для разработки серверного приложения

Задание: [Используя Spring, создайте серверное REST приложение. Добавить функционал в приложение разработанное на семинаре:](Homework_3)

=============================== Проверка работы ===============================

Для теcтирования проекта использовать программу PostMan:
>a) Добавление пользователя - запрос :\
метод - POST\
адрес - http://localhost:8080/users/body\
тело -
```
{
"name":"Artur",
"age":23,
"email":"exam1@yandex.ru"
}
```

>b) Получение списка пользователей на сервере - запрос:\
метод - GET\
адрес - http://localhost:8080/users

>c) Проверка сортировки - запрос:\
метод - GET\
адрес - http://localhost:8080/tasks/sort

>d) Проверка фильтрации - запрос:\
метод - GET\
адрес - http://localhost:8080/tasks/filter/23

>e) Проверка среднего арифметического - запрос:\
метод - GET\
адрес - http://localhost:8080/tasks/calc

===========================================================================

### Базовое задание
1) В класс RegistrationService добавить поля UserService, NotificationService(добавить в IOC контейнер аннотацией @Autowired или через конструктор класса)
2) Разработать метод processRegistration в котором:
- создается пользователь из параметров метода
- созданный пользователь добавляется в репозиторий
- через notificationService выводится сообщение в консоль
3) В TaskController добавить обработчики filterUsersByAge()(Подсказка @GetMapping("/filter/{age}")) и calculateAverageAge (Подсказка @GetMapping("/calc"))
4) В методе filterUsersByAge параметр age получать через аннотацию @PathVariable

### Задание со звездочкой
1) В классе UserController добавить обработчик userAddFromParam извлекающий данные для создания пользователя из параметров HTTP запроса (Пример: http://localhost:8080/users/param?name=Fedor&age=25&email=aaaaa@yandex.ru)
2) Перенести репозиторий проекта с List\<User> на базу данных H2


## Урок 4. Spring MVC. Использование шаблонизатора Thymeleaf

### [Базовое задание](Homework_4):
1. Создание базового веб-приложения Spring MVC
Начните с создания простого веб-приложения с использованием Spring MVC. Это может быть простой сайт, который выводит "Привет, мир!" на главной странице. Используйте аннотацию @Controller и @RequestMapping для маршрутизации запросов на эту страницу.
2. Добавление Thymeleaf в проект
Добавьте Thymeleaf в свое веб-приложение Spring MVC. Создайте простую страницу с некоторыми переменными, которые заполняются с помощью модели Spring MVC и отображаются на странице с использованием Thymeleaf.
3. Создание формы ввода и обработка данных формы
Создайте страницу с формой ввода, используя Thymeleaf для рендеринга формы. Затем создайте контроллер Spring MVC, который обрабатывает отправку формы и выводит полученные данные. Это может быть форма для регистрации или любая другая форма, которая собирает информацию от пользователя.

>Запускать через http://localhost:8080

### [Задание "со звездочкой"](Homework_2):
Проект домашнего задания для 2 семинара (CRUD приложение USER SERVICE) переписать:
1. Использовать библиотеку Lombok:\
a) @Data - для полей классов\
b) @AllArgsConstructor - для классов с конструкторами\
c) @Log - логировать работу всех контроллеров
2. Использовать configuration-processor для работы с настройками приложения:\
a) Создать объект инкапсулирующий шаблоны запросов к базе данных H2\
b) Использовать аннотации @ConfigurationProperties и @ConfigurationPropertiesScan для заполнения полей этого класса\
с) Вынести все SQL шаблоны в настройки приложения.


## Урок 5. Spring Data для работы с базами данных

### [Базовое задание](Homework_5):
Условие:\
Вам предстоит создать приложение для управления списком задач с использованием Spring Boot и Spring Data JPA. Требуется реализовать следующие функции:

- Добавление задачи. Подсказка метод в контроллере: @PostMapping public Task addTask(@RequestBody Task task)
- Просмотр всех задач. Подсказка метод в контроллере: @GetMapping public List<Task> getAllTasks()
- Просмотр задач по статусу (например, "завершена", "в процессе", "не начата"). Подсказка метод в контроллере: @GetMapping("/status/{status}") public List<Task> getTasksByStatus(@PathVariable TaskStatus status)
- Изменение статуса задачи. Подсказка метод в контроллере: @PutMapping("/{id}") public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task)
- Удаление задачи. Подсказка метод в контроллере:@DeleteMapping("/{id}") public void deleteTask(@PathVariable Long id)

Репозитроий подсказка public interface TaskRepository extends JpaRepository<Task, Long>

Структура задачи(класс Task):
- ID (автоинкрементное)(тип Long)
- Описание (не может быть пустым)(тип String)
- Статус (одно из значений: "не начата", "в процессе", "завершена")(Тип TaskStatus )
- Дата создания (автоматически устанавливается при создании задачи)(Тип LocalDateTime)

Подсказка понадобится энумератор: enum TaskStatus {NOT_STARTED, IN_PROGRESS, COMPLETED;}

### [Задание "со звездочкой"](Homework_5_additional):
[Текст задания](Homework_5_additional/StrongHomeTask.txt)


## Урок 6. Проектирование и реализация API для серверного приложения

### [Базовое задание](Homework_6):
Условие:

**Важно!** В проекте используем обязательно Spring Data и Lombok!

Разработайте небольшое веб-приложение на Spring Boot, которое будет представлять из себя сервис для учета личных заметок. Приложение должно поддерживать следующие функции:

**Все методы контроллера возвращают ResponseEntity**(как на семинаре)
1. Добавление заметки. (Подсказка @PostMapping )
2. Просмотр всех заметок.(Подсказка @GetMapping )
3. Получение заметки по id. (Подсказка @GetMapping("/{id}") )
4. Редактирование заметки.(Подсказка @PutMapping("/{id}") )
5. Удаление заметки.(Подсказка @DeleteMapping("/{id}") )

Структура заметки:
- ID (автоинкрементное)(тип - Long)
- Заголовок (не может быть пустым)(тип - String)
- Содержимое (не может быть пустым)(тип - String)
- Дата создания (автоматически устанавливается при создании заметки)(тип - LocalDateTime)


## Урок 7. Spring Security. Работа с JWT. Защита от основных видов атак

### [Базовое задание](Homework_7):

Вам необходимо создать Spring Boot приложение, которое управляет доступом к ресурсам в зависимости от роли пользователя. У вас должно быть два типа пользователей: USER и ADMIN.
1. Создайте ресурс /private-data, доступный только для аутентифицированных пользователей с ролью ADMIN.
2. Создайте ресурс /public-data, доступный для всех аутентифицированных пользователей независимо от их роли.
3. Реализуйте форму входа для аутентификации пользователей с использованием стандартных средств Spring Security.
4. Если неаутентифицированный пользователь пытается получить доступ к /private-data, он должен быть перенаправлен на форму входа.

> Пароль к user и admin - `password`


## Урок 8. Spring AOP, управление транзакциями

### [Базовое задание](Homework_8):

Домашнее задание выполнить для одного из пройденных семинаров в проекте с Базой Данных.
Вам необходимо разработать механизм регистрации действий пользователя в вашем Spring Boot приложении. Используйте Spring AOP для создания журнала действий, в котором будет сохраняться информация о том, какие методы сервиса вызывались, кем и с какими параметрами.

1. Создайте аннотацию `@TrackUserAction`.
2. Реализуйте aspect, который будет регистрировать действия пользователя, когда вызывается метод, отмеченный этой аннотацией.
3. Примените аннотацию `@TrackUserAction` к нескольким методам в слое сервиса.
4. Результаты регистрации в консоль


## Урок 9. Spring Cloud. Микросервисная архитектура

### [Базовое задание](Homework_9):

Добавить в один из Ваших проектов сделанных ранее ApiGateWay и Eureka. В проекте обязательно должна быть Spring Data.

`За основу взяты Homework_5 и Homework_8`

>Проверка работоспособности:\
>http://localhost:8080/books \
>http://localhost:8080/tasks


## Урок 10. Spring Testing. JUnit и Mockito для написания тестов

### [Базовое задание](Homework_10):

По аналогии с примерами показанными на семинаре, добавить модульное тестирование и интеграционное для одного из своих проектов(так же протестировать один из методов сервиса).

`За основу взят Homework_6. В проекте переработаны сервис и контроллер, а также, добавлены исключения`

>[Модульные тесты](Homework_10/src/test/java/ru/dmalomoshin/homework10/service/NoteServiceTest.java) \
>[Интеграционные тесты](Homework_10/src/test/java/ru/dmalomoshin/homework10/NoteIntegrationTests.java)

