package main.java.utils;

import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;

public class AssertUtils {

    /**
     * TODO.
     *
     * @param found    ---
     * @param expected ---
     */
    public static void printExpectedAndFound(String found, String expected, String stringKey) {
        byte[] ptext1 = found.getBytes(ISO_8859_1);

        String newFound = new String(ptext1, UTF_8);

        byte[] ptext2 = expected.getBytes(ISO_8859_1);
        String newExpected = new String(ptext2, UTF_8);

        LogsUtils.log("----------------Raw String Values-----------------------------------");
        LogsUtils.log("Expected:\n" + stringKey + "="
                + newExpected.replaceAll("\\r\\n|\\r|\\n|\\s+", " "));
        LogsUtils.log("   Found:\n" + stringKey
                + "=" + newFound.replaceAll("\\r\\n|\\r|\\n|\\s+", " "));
        LogsUtils.log("--------------------------------------------------------------------");

    }


}