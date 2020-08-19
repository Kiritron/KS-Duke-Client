package space.kiritron.duke_cli;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Класс с методом получения и сравнения версий через HTTP/HTTPS.
 * @author Киритрон Стэйблкор
 * @version 1.0
 */

public class httpconn {
    /**
     * Проверка версии с помощью подключения к веб-серверу. Получает контент от веб сервера и сравнивает его с версией приложения.
     * @param URL Адрес в веб пространстве, по которому можно узнать актуальную версию приложения.
     * @param SSL_Enabled Используется ли HTTPS.
     * @param VER_APP Версия этого приложения(Не та, что на сервере).
     * @return возвращает результат проверки. OK - Всё в порядке. DIFFERENCE_FINDED - Есть различия. Другой ответ - признак ошибки.
     */

    public static String checkVersion(String URL, boolean SSL_Enabled, String VER_APP) {
        String ServerVersion = null;
        try {
            URL url = new URL(URL);
            if (SSL_Enabled) {
                HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
                if (!HTTPSConn(con).equals("CONN_ERROR") && !HTTPSConn(con).equals("ERROR")) {
                    if (Check(VER_APP, HTTPSConn(con))) {
                        ServerVersion = "OK";
                    } else {
                        ServerVersion = "DIFFERENCE_FINDED";
                    }
                } else {
                    ServerVersion = "GET_VERSION_CODE_ERROR";
                }
            } else {
                HttpURLConnection con = (HttpURLConnection)url.openConnection();
                if (!HTTPConn(con).equals("CONN_ERROR") && !HTTPConn(con).equals("ERROR")) {
                    if (Check(VER_APP, HTTPConn(con))) {
                        ServerVersion = "OK";
                    } else {
                        ServerVersion = "DIFFERENCE_FINDED";
                    }
                } else {
                    ServerVersion = "GET_VERSION_CODE_ERROR";
                }
            }

        } catch (MalformedURLException e) {
            ServerVersion = "HOST_ERROR";
        } catch (IOException e) {
            ServerVersion = "IO_ERROR";
        }
        return ServerVersion;
    }

    private static String HTTPSConn(HttpsURLConnection con) {
        if (con != null) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String out = br.readLine();
                br.close();
                return out;
            } catch (IOException e) {
                return "ERROR";
            }
        } else {
            return "CONN_ERROR";
        }
    }

    private static String HTTPConn(HttpURLConnection con) {
        if (con != null) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String out = br.readLine();
                br.close();
                return out;
            } catch (IOException e) {
                return "ERROR";
            }
        } else {
            return "CONN_ERROR";
        }
    }

    private static boolean Check(String VER_APP, String VER_FROM_SERVER) {
        if (VER_APP.equals(VER_FROM_SERVER)) {
            return true;
        } else {
            return false;
        }
    }
}
