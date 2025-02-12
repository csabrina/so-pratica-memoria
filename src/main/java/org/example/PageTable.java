package org.example;
import java.util.HashMap;
import java.util.Map;

// Representa a tabela de páginas de um processo
public class PageTable {
    private Map<Integer, Integer> pageToFrameMap; // Mapeia páginas para quadros

    public PageTable() {
        this.pageToFrameMap = new HashMap<>();
    }

    public void addPage(int pageId, int frameId) {
        pageToFrameMap.put(pageId, frameId);
    }

    public void removePage(int pageId) {
        pageToFrameMap.remove(pageId);
    }

    public Integer getFrame(int pageId) {
        return pageToFrameMap.get(pageId);
    }

    public Map<Integer, Integer> getPageToFrameMap() {
        return pageToFrameMap;
    }
}