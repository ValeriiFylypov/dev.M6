package jdbc;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Utilities {



    public static String readSqlFromFile (String path) throws IOException {
        return Files.readString(Path.of(path));
    }

    public static <T> List<T> getListFromJson(String path, Class<T> clazz) throws IOException {

        String json = Files.readString(Path.of(path));

        TypeToken<?> type = TypeToken
                .getParameterized(List.class, clazz);

        return new Gson().fromJson(json, type.getType());
    }
}
