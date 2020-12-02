package ru.netology.domain;

import java.util.*;

public class FileOpenManager {
    private Map<String, String> map = new HashMap<>();

    public void shouldRegisterOfNewApplication(String extension, String name) {
        map.put(extension.toLowerCase(), name);
    }

    public String shouldGetNameForSpecificExtension(String extension) {
        return map.get(extension.toLowerCase());
    }

    public void shouldDeleteApplicationBinding(String extension) {
        map.remove(extension.toLowerCase());
    }

    public Set<String> shouldGetListOfAllExtensions() {
        return map.keySet();
    }

    public Set<String> shouldGetListOfAllNames() {
        Collection<String> valueList = map.values();
        Set<String> names =new HashSet<String>(valueList);
        return names;
    }

    public boolean isMapEmpty() {
        return map.isEmpty();
    }
}
