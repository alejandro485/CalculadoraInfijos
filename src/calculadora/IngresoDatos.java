/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * la wea
 */
package calculadora;

/**
 *
 * @author richard
 */
public class IngresoDatos extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	static boolean validacionCero;
    private static String evaluarPost(String pos) {
        String[] post = pos.split("");
        Pila En = new Pila();
        Pila Op = new Pila();
        String numero="";
        for (int i = post.length-1; i >0; i--) {
            if(" ".equals(post[i])){
                System.out.println("dato: ("+numero+")");
                En.insertar(numero);
                numero="";
            }
            else{
                numero=post[i]+numero;
            }
        }
        En.insertar(numero);
        System.out.println("dato: ("+numero+")");
        
        String operadores = "+-*/%^";
        while (!En.isEmpty()) {
            if (operadores.contains("" + En.peek())) {
                Op.insertar(evaluar(En.Retirar(), Op.Retirar(), Op.Retirar()) + "");
            } else {
                String v=En.Retirar();
                Op.insertar(v);
            }
        }
        return Op.peek();
    }

    private static double evaluar(String op, String n2, String n1) {
        double num1 = Double.parseDouble(n1);
        double num2 = Double.parseDouble(n2);
        if (op.equals("+")) {
            return (num1 + num2);
        }
        if (op.equals("-")) {
            return (num1 - num2);
        }
        if (op.equals("*")) {
            return (num1 * num2);
        }
        if (op.equals("/")) {
            if(num2==0){
                validacionCero=true;
                System.out.print("Cero dividiendo");
            }
            return (num1 / num2);
        }
        if (op.equals("%")) {
            return (num1 % num2);
        }
        if (op.equals("^")) {
            return (Math.pow(num1, num2));
        }
        return 0;

    }

    private static int pref(String op) {
        int prf = 99;
        if (op.equals("^")) {
            prf = 5;
        }
        if (op.equals("*") || op.equals("/") || op.equals("%")) {
            prf = 4;
        }
        if (op.equals("+") || op.equals("-")) {
            prf = 3;
        }
        if (op.equals(")")) {
            prf = 2;
        }
        if (op.equals("(")) {
            prf = 1;
        }
        return prf;
    }

    private static String depurar(String s) {
        s = s.replaceAll("\\s+", "");
        s = "(" + s + ")";
        String simbols = "+-*/%^()";
        String str = "";

        for (int i = 0; i < s.length(); i++) {
            if (simbols.contains("" + s.charAt(i))) {
                str += " " + s.charAt(i) + " ";
            } else {
                str += s.charAt(i);
            }
        }
        return str.replaceAll("\\s+", "");
    }

    /**
     * Creates new form IngresoDatos
     */
    public IngresoDatos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextCadena = new javax.swing.JTextField();
        jButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextRES = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Calculadora");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(39, 39, 39))
        );

        jLabel2.setText("Digite Expresión sin espacios: ");

        jLabel3.setText("Operadores:  ");

        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("+ - / * % ^ ()");

        jTextCadena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCadenaActionPerformed(evt);
            }
        });

        jButton.setText("Calcular valor y posfijo ");
        jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addComponent(jLabel2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jTextCadena, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jButton)))
                .addContainerGap(171, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextCadena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jButton)
                .addGap(20, 20, 20))
        );

        jTextField1.setBackground(new java.awt.Color(212, 203, 200));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextRES.setBackground(new java.awt.Color(212, 203, 200));
        jTextRES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextRESActionPerformed(evt);
            }
        });

        jLabel5.setText("POSTFIJO:");

        jLabel6.setText("RESULTADO:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextRES, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextRES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(0, 59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextCadenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCadenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCadenaActionPerformed
    boolean validacionOperador(String c){
        String operadores = "+-*/%^()";
        return (operadores.contains("" + c.charAt(0)));
    }
    private void jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActionPerformed
        // TODO add your handling code here:
        validacionCero=false;
        String cadena = depurar(jTextCadena.getText());
        System.out.println("Entrante ("+cadena+")");
        while(cadena.contains("(-")){
            int index=cadena.indexOf("(-");
            int index2=cadena.indexOf(")", index);
            String dato=cadena.substring(index+2, index2);
            System.out.println("----------"+dato);
            cadena=cadena.replace("(-"+dato+")","(0-"+dato+")");
        }
        System.out.println("Salida ("+cadena+")");
        String[] arrayInfix = cadena.split("");
        Pila E = new Pila();
        Pila O = new Pila();
        Pila S = new Pila();
        String numero="";
        for (int i = arrayInfix.length - 1; i >= 0; i--) {
            if(validacionOperador(arrayInfix[i])){
                if(numero!=""){
                    E.insertar(numero);
                    numero="";
                }
                E.insertar(arrayInfix[i]);
            }
            else{
                numero=arrayInfix[i]+numero;
            }
        }
        
            while (!E.isEmpty()) {
                switch (pref(E.peek())) {
                    case 1:
                        O.insertar(E.Retirar());
                        break;
                    case 3:
                        case 5:
                    case 4:
                        while (pref(O.peek()) >= pref(E.peek())) {
                            S.insertar(O.Retirar());
                        }
                        O.insertar(E.Retirar());
                        break;
                    case 2:
                        while (!O.peek().equals("(")) {
                            S.insertar(O.Retirar());
                        }
                        O.Retirar();
                        E.Retirar();
                        break;
                     
                        
                    default:
                        S.insertar(E.Retirar());
                    break;
                }
            }
            String infix = cadena.replace("", "");
            String bb=S.armarPost();
            System.out.println("Expresion infija:" + infix);
            bb=bb.replace("|", " ");
            System.out.println(" -("+bb+")- ");
            jTextField1.setText(bb);
            String v=evaluarPost(bb);
            if(validacionCero){
               jTextRES.setText("Error: Division por 0"); 
            }
            else{
                jTextRES.setText(v);
            }
           
        


    }//GEN-LAST:event_jButtonActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextRESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextRESActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextRESActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IngresoDatos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresoDatos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresoDatos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresoDatos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresoDatos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextCadena;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextRES;
    // End of variables declaration//GEN-END:variables
}
