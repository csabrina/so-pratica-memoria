import org.example.MemoryManager;
import org.example.PageTable;
import org.example.Process;

// Classe principal para executar o simulador
public class Main {
    public static void main(String[] args) {
        // Inicializa o gerenciador de memória com 16 quadros
        MemoryManager memoryManager = new MemoryManager(16);

        // Cria um processo com 4 páginas
        org.example.Process process1 = new org.example.Process(1, 4);
        PageTable pageTable1 = new PageTable();

        // Aloca o processo na memória
        memoryManager.allocateProcess(process1, pageTable1);

        // Exibe o estado da memória e a tabela de páginas
        memoryManager.displayMemoryState();
        memoryManager.displayPageTable(process1, pageTable1);

        // Cria outro processo com 4 páginas
        org.example.Process process2 = new Process(2, 4);
        PageTable pageTable2 = new PageTable();

        // Aloca o segundo processo na memória
        memoryManager.allocateProcess(process2, pageTable2);

        // Exibe o estado da memória e a tabela de páginas
        memoryManager.displayMemoryState();
        memoryManager.displayPageTable(process2, pageTable2);
    }
}