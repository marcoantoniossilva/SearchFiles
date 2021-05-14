package searchfiles;

import java.io.File;
import java.util.ArrayList;

public class SearchFiles {

    static boolean procurando = true;
    static ArrayList<Search> listaThreads = new ArrayList<>();

    public static void main(String[] args) {
        if (args.length > 1) {
            
        } else {
            System.err.print("Uso incorreto do sistema, é necessário informar um nome de um arquivo e uma pasta raiz.");
        }
    }

    public static void iniciarBusca(String nomeArquivo, File raiz) {
        Search buscar = new Search(nomeArquivo, raiz);
        listaThreads.add(buscar);
        buscar.start();
    }

    static void encontrado(File arquivo, Search thread) {
        procurando = false;
        System.out.println("5Arquivo encontrado em: " + arquivo.getAbsolutePath() + " pela Thread " + thread.getId());
    }
}
