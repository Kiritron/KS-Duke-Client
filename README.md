### **КС Дьюк [Клиент]**

##### Версия: 3.1
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
checkVersion(URL, SSL_Verification, checkMajor, VER_APP);
```
```
URL(String) - Адрес в веб-пространстве, на котором
есть данные об обновлении
SSL_Verification(Boolean) - Необходимо ли проверять SSL сертификаты
checkMajor - Необходимо ли проверять мажорность версии. Иначе говоря её критичность, массивность.
             Если будет установлено TRUE, то ответ от веб-сервера должен быть примерно таким
             "2.0:::major". Если ":::major" присутствует в ответе сервера и если обнаружено
             различие в версиях, то будет возвращено "DIFFERENCE_FINDED. MAJOR.", а если нет,
             то "DIFFERENCE_FINDED. MINOR.".
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
checkVersion(HOST, PORT, NAME_APP, VER_APP, checkMajor);
```
```
HOST(String) - Адрес сервера
PORT(int) - Порт
NAME_APP(String) - Имя данного приложения. У профиля приложения на сервере
должно быть такое же имя
VER_APP(String) - Какая версия данного приложения(Необходимо для сравнения)
checkMajor - Необходимо ли проверять мажорность версии. Иначе говоря её критичность, массивность.
             Если будет установлено TRUE, то ответ от сервера Дьюк должен быть примерно таким
             "2.0:::major". Если ":::major" присутствует в ответе сервера и если обнаружено
             различие в версиях, то будет возвращено "DIFFERENCE_FINDED. MAJOR.", а если нет,
             то "DIFFERENCE_FINDED. MINOR.".
```
В случае, если строки версий отличаются, будет выдан соотвествующий статус.

#### Приятного пользования!