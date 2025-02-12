package org.example;

// Representa um processo com seu espaço de endereçamento lógico
public class Process {
    private int processId;
    private int pageCount;

    public Process(int processId, int pageCount) {
        this.processId = processId;
        this.pageCount = pageCount;
    }

    public int getProcessId() {
        return processId;
    }

    public int getPageCount() {
        return pageCount;
    }
}