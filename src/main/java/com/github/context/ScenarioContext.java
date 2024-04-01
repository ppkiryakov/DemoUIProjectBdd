package com.github.context;

import java.util.HashMap;

public class ScenarioContext {
    private static ThreadLocal<HashMap<String, Object>> contextMap = ThreadLocal.withInitial(HashMap::new);

    public static synchronized void setContext(String key, Object value) {
        contextMap.get().put(key, value);
    }

    public static Object getContext(String key) {
        return contextMap.get().get(key);
    }

    public static synchronized void clearContext() {
        contextMap.get().clear();
    }

    public boolean containsContext(String key) {
        return contextMap.get().containsKey(key);
    }


}
