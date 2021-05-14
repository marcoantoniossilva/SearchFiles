package searchfiles;

import java.io.File;

public class Search extends Thread {

    String nomeArquivo;
    File raiz;

    public Search(String nomeArquivo, File raiz) {
        this.nomeArquivo = nomeArquivo;
        this.raiz = raiz;
    }

    @Override
    public void run() {
        if (raiz.isDirectory()) {
            File[] arquivos = raiz.listFiles();
            if (arquivos != null) {
                for (File arquivo : arquivos) {

                    if (arquivo.isDirectory() && Principal.isProcurando()) {
                        Principal.iniciarBusca(nomeArquivo, arquivo);
                    } else {
                        if (arquivo.getName().equals(nomeArquivo)) {
                            Principal.encontrado(arquivo, this);
                        }
                    }
                }
            }

            Principal.removerThread(this);

//            synchronized (this) {
//
//                if (Principal.listaThreads.isEmpty() && Principal.isProcurando()) {
//                    Principal.setProcurando(false);
//                    Principal.naoEncontrou();
//                }
//            }
        }
    }
}
