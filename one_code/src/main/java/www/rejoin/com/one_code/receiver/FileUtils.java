package www.rejoin.com.one_code.receiver;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by Administrator on 2019/1/3.
 */

public class FileUtils {

    public static void save(String str, Context context) {
        FileOutputStream output = null;
        BufferedWriter writer = null;
        try {
            output = context.openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter((output)));
            writer.write(str);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();

            }
        }
    }

    public static String show(Context context) {
        FileInputStream input = null;
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        try {
            input = context.openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(input));
            String lines = "";
            while ((lines = reader.readLine()) != null) {
                builder.append(lines);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return builder.toString();
    }
}
