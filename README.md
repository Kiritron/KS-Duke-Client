### **КС Дьюк [Клиент]**

##### Версия: 2.0
##### Описание
Библиотека для реализации проверки обновлений для приложения.
Поддерживается HTTP/HTTPS и SOCKET(Нужен [сервер КС Дьюк](https://bitbucket.org/kiritron/ks-diuk-server/src/master/)).

##### Использование(HTTP/HTTPS)
Импортиртируйте метод
```java
import static space.kiritron.duke_cli.httpconn.checkVersion;
```
и используйте его, заполнив данные
```java
checkVersion(URL, SSL_Verification, VER_APP);
```
```
URL(String) - Адрес в веб-пространстве, на котором
есть данные об обновлении
SSL_Verification(Boolean) - Необходимо ли проверять SSL сертификаты
VER_APP(String) - Какая версия данного приложения(Необходимо для сравнения)
```
В случае, если строки версий отличаются, будет выдан соотвествующий статус.

##### Использование(SOCKET. Сервер КС Дьюк.)
У вас должен быть сервер КС Дьюк, чтобы данный метод работал.
Если всё в порядке, то испортируйте метод
```java
import static space.kiritron.duke_cli.srvsockconn.checkVersion;
```
и используйте его, заполнив данные
```java
checkVersion(HOST, PORT, NAME_APP, VER_APP);
```
```
HOST(String) - Адрес сервера
PORT(int) - Порт
NAME_APP(String) - Имя данного приложения. У профиля приложения на сервере
должно быть такое же имя
VER_APP(String) - Какая версия данного приложения(Необходимо для сравнения)
```
В случае, если строки версий отличаются, будет выдан соотвествующий статус.

#### Приятного пользования!