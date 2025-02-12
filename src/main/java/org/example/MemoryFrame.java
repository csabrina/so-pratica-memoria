package org.example;

// Representa um quadro de memória física
public class MemoryFrame {
    private int frameId;
    private boolean isFree;
    private int processId;
    private int pageId;

    public MemoryFrame(int frameId) {
        this.frameId = frameId;
        this.isFree = true;
        this.processId = -1;
        this.pageId = -1;
    }

    public boolean isFree() {
        return isFree;
    }

    public void allocate(int processId, int pageId) {
        this.processId = processId;
        this.pageId = pageId;
        this.isFree = false;
    }

    public void deallocate() {
        this.processId = -1;
        this.pageId = -1;
        this.isFree = true;
    }

    public int getFrameId() {
        return frameId;
    }

    public int getProcessId() {
        return processId;
    }

    public int getPageId() {
        return pageId;
    }
}