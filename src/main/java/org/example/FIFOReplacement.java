package org.example;

import java.util.Queue;
import java.util.LinkedList;

// Implementa o algoritmo de substituição FIFO
public class FIFOReplacement {
    private Queue<Integer> queue;

    public FIFOReplacement() {
        this.queue = new LinkedList<>();
    }

    public int replace() {
        return queue.poll(); // Remove e retorna o quadro mais antigo
    }

    public void addFrame(int frameId) {
        queue.add(frameId); // Adiciona um novo quadro à fila
    }
}