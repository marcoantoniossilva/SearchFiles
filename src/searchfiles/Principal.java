package searchfiles;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoNomeArquivo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoProcurarEm = new javax.swing.JTextField();
        botaoProcurar = new javax.swing.JButton();
        botaoSelecionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Procurar arquivos");

        jLabel2.setText("Nome do arquivo:");

        jLabel3.setText("Procurar em:");

        campoProcurarEm.setEditable(false);

        botaoProcurar.setText("Procurar");
        botaoProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoProcurarActionPerformed(evt);
            }
        });

        botaoSelecionar.setText("Selecionar");
        botaoSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSelecionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(campoProcurarEm)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botaoSelecionar))
                            .addComponent(campoNomeArquivo))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(175, Short.MAX_VALUE)
                .addComponent(botaoProcurar)
                .addGap(167, 167, 167))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoNomeArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoProcurarEm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoSelecionar))
                .addGap(18, 18, 18)
                .addComponent(botaoProcurar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoProcurarActionPerformed
        if (verificarCampos()) {
            setProcurando(true);
            listaThreads.clear();
            botaoProcurar.setText("Procurando...");
            String nomeArquivo = campoNomeArquivo.getText();
            File raiz = new File(campoProcurarEm.getText());
            if (raiz.exists()) {
                iniciarBusca(nomeArquivo, raiz);
            } else {
                System.err.print("A pasta raiz informada não existe!\n" + raiz.getAbsolutePath());
            }
        } else {
            JOptionPane.showMessageDialog(this, "É necessário informar o nome do arquivo para ser pesquisado e um local para pesquisar.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoProcurarActionPerformed

    private void botaoSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSelecionarActionPerformed
        JFileChooser fc = new JFileChooser();
        // restringe a amostra a diretorios apenas
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setDialogTitle("Selecionar pasta raiz");
        fc.setApproveButtonText("Selecionar Pasta");
        fc.setMultiSelectionEnabled(false);
        int res = fc.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            campoProcurarEm.setText(fc.getSelectedFile().getPath());
        }
    }//GEN-LAST:event_botaoSelecionarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton botaoProcurar;
    private javax.swing.JButton botaoSelecionar;
    private static javax.swing.JTextField campoNomeArquivo;
    private javax.swing.JTextField campoProcurarEm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

    private boolean verificarCampos() {
        if (campoNomeArquivo.getText().isEmpty()) {
            return false;
        }
        if (campoProcurarEm.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    public static void iniciarBusca(String nomeArquivo, File raiz) {
        Search buscar = new Search(nomeArquivo, raiz);
        adicionarThread(buscar);
        buscar.start();
    }

    static void encontrado(File arquivo, Search thread) {
        setProcurando(false);
        botaoProcurar.setText("Procurar");
        for (String chave : listaThreads.keySet()) {
            if (listaThreads.get(chave) != null) {
                listaThreads.get(chave).interrupt();
            }
        }
        try {
            Runtime.getRuntime().exec("explorer " + arquivo.getParent());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro de IO: " + ex.getMessage());
        }
        JOptionPane.showMessageDialog(null, "Arquivo encontrado em: " + arquivo.getAbsolutePath() + " pela Thread " + thread.getId(), "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
    }

    static void naoEncontrou() {
        botaoProcurar.setText("Procurar");
        JOptionPane.showMessageDialog(null, "Arquivo não localizado: " + campoNomeArquivo.getText(), "Não encontrou!", JOptionPane.ERROR_MESSAGE);
        
    }

    static void adicionarThread(Search search) {
        listaThreads.put(search.getName(), search);
    }

    static void removerThread(Search search) {
        listaThreads.remove(search.getName(), search);
        if (Principal.listaThreads.isEmpty() && Principal.isProcurando()) {
            Principal.setProcurando(false);
            Principal.naoEncontrou();
        }
        search.interrupt();
    }

    static synchronized boolean isProcurando() {
        return procurando;
    }

    static synchronized void setProcurando(boolean procurando) {
        Principal.procurando = procurando;
    }
    static int qtdnodemodules = 0;

    static boolean procurando = true;
    //static List<Search> listaThreads = new ArrayList<>();
    static Map<String, Search> listaThreads = new ConcurrentHashMap<String, Search>();
}
