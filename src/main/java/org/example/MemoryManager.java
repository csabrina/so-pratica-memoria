package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Gerencia a memória física e a alocação de páginas
public class MemoryManager {
    private List<MemoryFrame> physicalMemory;
    private FIFOReplacement fifoReplacement;
    private int frameCount;

    public MemoryManager(int frameCount) {
        this.frameCount = frameCount;
        this.physicalMemory = new ArrayList<>();
        this.fifoReplacement = new FIFOReplacement();

        // Inicializa a memória física com quadros livres
        for (int i = 0; i < frameCount; i++) {
            physicalMemory.add(new MemoryFrame(i));
            fifoReplacement.addFrame(i);
        }
    }

    public boolean allocateProcess(Process process, PageTable pageTable) {
        for (int pageId = 0; pageId < process.getPageCount(); pageId++) {
            int frameId = findFreeFrame();
            if (frameId == -1) {
                frameId = fifoReplacement.replace(); // Substitui a página mais antiga
                deallocateFrame(frameId);
            }

            physicalMemory.get(frameId).allocate(process.getProcessId(), pageId);
            pageTable.addPage(pageId, frameId);
            fifoReplacement.addFrame(frameId); // Atualiza a fila FIFO
        }
        return true;
    }

    private int findFreeFrame() {
        for (MemoryFrame frame : physicalMemory) {
            if (frame.isFree()) {
                return frame.getFrameId();
            }
        }
        return -1; // Nenhum quadro livre encontrado
    }

    private void deallocateFrame(int frameId) {
        MemoryFrame frame = physicalMemory.get(frameId);
        frame.deallocate();
    }

    public void displayMemoryState() {
        System.out.println("Estado da Memória Física:");
        for (MemoryFrame frame : physicalMemory) {
            System.out.printf("Quadro %d: Processo %d, Página %d, Livre: %b%n",
                    frame.getFrameId(), frame.getProcessId(), frame.getPageId(), frame.isFree());
        }
    }

    public void displayPageTable(Process process, PageTable pageTable) {
        System.out.printf("Tabela de Páginas do Processo %d:%n", process.getProcessId());
        for (Map.Entry<Integer, Integer> entry : pageTable.getPageToFrameMap().entrySet()) {
            System.out.printf("Página %d -> Quadro %d%n", entry.getKey(), entry.getValue());
        }
    }
}