package space.kiritron.duke_cli;

/**
 * Класс с методом получения и сравнения версий через HTTP/HTTPS.
 * @author Киритрон Стэйблкор
 * @version 1.0
 */

public class versionHandler {
    protected static boolean checkDifference(String VER_APP, String VER_FROM_SERVER) {
        if (VER_FROM_SERVER.contains(":::minor") && VER_FROM_SERVER.contains(":::major")) {
            while (VER_FROM_SERVER.contains(":::minor") && VER_FROM_SERVER.contains(":::major")) {
                VER_FROM_SERVER = VER_FROM_SERVER.replace(":::minor", "");
                VER_FROM_SERVER = VER_FROM_SERVER.replace(":::major", "");
            }
        }

        // Вообще проверять наличие :::minor выше не прям уж обязательно, так как это не проверяется методом
        // checkMajorMarker, но вдруг кому-то вздумается вписать это в ответ от сервера?

        if (!VER_APP.equals(VER_FROM_SERVER)) {
            return true;
        } else {
            return false;
        }
    }

    protected static boolean checkMajorMarker(String VER_FROM_SERVER) {
        boolean MajorMarkerDetected = false;

        if (VER_FROM_SERVER.contains(":::major")) {
            MajorMarkerDetected = true;
        }

        return MajorMarkerDetected;
    }
}
