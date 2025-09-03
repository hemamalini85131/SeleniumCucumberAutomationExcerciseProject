package dataProviders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class JsonDataReader<T> {

    private List<T> dataList;
    private int currentIndex = 0;

    public JsonDataReader(String filePath, Class<T[]> clazz) {
        dataList = readJsonList(filePath, clazz);
    }

    
    public static <T> List<T> readJsonList(String filePath, Class<T[]> clazz) {
        Gson gson = new Gson();

        try (BufferedReader bufferReader = new BufferedReader(new FileReader(filePath))) {
            T[] array = gson.fromJson(bufferReader, clazz);
            return Arrays.asList(array);
        } catch (IOException e) {
            throw new RuntimeException("Error reading JSON file at: " + filePath, e);
        }
    }

  
    public T getNext() {
    	
    	
      /*  if (currentIndex < dataList.size()) {
            return dataList.get(currentIndex++);
        }
        return null;*/
    	
    	if (dataList.isEmpty()) {
            return null; // no data at all
        }

        // Reset index if it reaches the end
        if (currentIndex >= dataList.size()) {
            currentIndex = 0; // start again from first user
        }

        return dataList.get(currentIndex++);
    }

    
    public T getByField(String fieldName, String value) {
        try {
            for (T obj : dataList) {
                String fieldValue = String.valueOf(
                    obj.getClass().getField(fieldName).get(obj)
                );
                if (fieldValue.equalsIgnoreCase(value)) {
                    return obj;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Field lookup failed for: " + fieldName, e);
        }
        return null;
    }

    public List<T> getAll() {
        return dataList;
    }
}
