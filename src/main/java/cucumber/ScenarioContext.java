package cucumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScenarioContext {

    private final Map<String, Object> scenarioContext = new HashMap<>();

    // Set any type of value
    public void setContext(String key, Object value) {
        scenarioContext.put(key, value);
    }

    // Get value with casting
    @SuppressWarnings("unchecked")
    public <T> T getContext(String key) {
        return (T) scenarioContext.get(key);
    }

    // Check if key is present
    public boolean containsKey(String key) {
        return scenarioContext.containsKey(key);
    }

    // Set a list with generics
    public <T> void setListContext(String key, List<T> list) {
        scenarioContext.put(key, list);
    }

    // Add a single item to a list
    @SuppressWarnings("unchecked")
    public <T> void addToListContext(String key, T value) {
        List<T> list = (List<T>) scenarioContext.get(key);
        if (list == null) {
            list = new ArrayList<>();
            scenarioContext.put(key, list);
        }
        list.add(value);
    }
    
}
