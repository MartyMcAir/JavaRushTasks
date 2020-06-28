package com.javarush.task.task39.task3911;

import java.util.*;

public class Software {
    int currentVersion;

    private Map<Integer, String> versionHistoryMap = new LinkedHashMap<>();

    public void addNewVersion(int version, String description) {
        if (version > currentVersion) {
            versionHistoryMap.put(version, description);
            currentVersion = version;
        }
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public Map<Integer, String> getVersionHistoryMap() {
        return Collections.unmodifiableMap(versionHistoryMap);
    }

    public boolean rollback(int rollbackVersion) {
        // code here ..
//        Map<Integer, String> newMap = new LinkedHashMap<>(versionHistoryMap);
//        Collections.copy( newMap, versionHistoryMap);

        // невозможно откатится до несуществующей версии ПО
        if (!versionHistoryMap.containsKey(rollbackVersion)) return false;

        // вариант с пересозданием мапы _ my
//        Map<Integer, String> newMap = new LinkedHashMap<>();
//        Iterator<Map.Entry<Integer, String>> iterator = versionHistoryMap.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<Integer, String> next = iterator.next();
//            if (next.getKey() <= rollbackVersion) {
//                newMap.put(next.getKey(), next.getValue());
//            }
//        }
//        versionHistoryMap = newMap;

        // вариант просто с удалением лишнего
//        for (int i = currentVersion; i > rollbackVersion; i--) {
//            versionHistoryMap.remove(i);
//        }

        // вариант с удалением во время интерации
//        Iterator<Map.Entry<Integer, String>> iterator = versionHistoryMap.entrySet().iterator();
//        while(iterator.hasNext()){
//            Map.Entry<Integer, String> entry = iterator.next();
//            if(rollbackVersion < entry.getKey()) iterator.remove();
//            currentVersion = rollbackVersion;
//        }

        // вариант с Stream API
        versionHistoryMap.keySet().removeIf(x -> x > rollbackVersion);


        currentVersion = rollbackVersion;
        return true;
    }
}
