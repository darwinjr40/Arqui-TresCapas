package Presentacion;

import Dato.DCategoria;
import Dato.DProducto;
import Negocio.NCategoria;
import Negocio.NProducto;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public final class PProducto extends javax.swing.JFrame {

    private final NProducto np;
    private final NCategoria nc;
    
    private String id;
    private String nombre;
    private double precio;
    private String categoria;
    
    public PProducto(NProducto np, NCategoria nc) {
        initComponents();
        this.np = np;
        this.nc = nc;       
        this.listarCategoria();
        this.listarProducto();   
        
        this.tableP.setRowHeight(35);//modifica alto de las columnas
        this.tableP.getColumnModel().getColumn(0).setMaxWidth(50);
        this.tableP.getColumnModel().getColumn(2).setMinWidth(98);
        this.tableP.getColumnModel().getColumn(2).setMaxWidth(100);
        DefaultTableCellRenderer a = new DefaultTableCellRenderer();
        a.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tableP.getColumnCount(); i++) {
            this.tableP.getColumnModel().getColumn(i).setCellRenderer(a);            
        }                
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        lblMessage = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        lblprecio = new javax.swing.JLabel();
        jcbCategoria = new javax.swing.JComboBox();
        lblCategoria = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableP = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestionar Producto");
        setBackground(new java.awt.Color(255, 0, 51));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        txtId.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        txtId.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtNombre.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClickAgregar(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClickActualizar(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClickEliminar(evt);
            }
        });

        lblId.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        lblId.setForeground(new java.awt.Color(255, 255, 255));
        lblId.setText("ID :");

        lblnombre.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        lblnombre.setForeground(new java.awt.Color(255, 255, 255));
        lblnombre.setText("Nombre :");

        lblMessage.setBackground(new java.awt.Color(0, 0, 0));
        lblMessage.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lblMessage.setForeground(new java.awt.Color(102, 255, 153));
        lblMessage.setText("jLabel3");

        txtPrecio.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        txtPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblprecio.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        lblprecio.setForeground(new java.awt.Color(255, 255, 255));
        lblprecio.setText("Precio :");

        jcbCategoria.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N

        lblCategoria.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        lblCategoria.setForeground(new java.awt.Color(255, 255, 255));
        lblCategoria.setText("Categoria :");
        lblCategoria.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblnombre)
                                            .addComponent(lblprecio)
                                            .addComponent(lblId)))
                                    .addComponent(lblCategoria, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtId)
                                    .addComponent(txtNombre)
                                    .addComponent(txtPrecio)
                                    .addComponent(jcbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnRegistrar)
                                .addGap(33, 33, 33)
                                .addComponent(btnActualizar)
                                .addGap(35, 35, 35)
                                .addComponent(btnEliminar))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lblMessage)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblId))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblnombre))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblprecio))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblCategoria))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jcbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar))
                .addGap(26, 26, 26)
                .addComponent(lblMessage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tableP.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        tableP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "PRECIO", "CATEGORIA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablePMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tableP);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    

    

    private void onClickAgregar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onClickAgregar
        id = txtId.getText();
        nombre = txtNombre.getText();
        precio = Double.valueOf(this.txtPrecio.getText());
        categoria = ((ComboBoxItem) jcbCategoria.getSelectedItem()).key;
        np.agregar(id, nombre, precio, categoria);
        this.listarProducto();
    }//GEN-LAST:event_onClickAgregar

    private void onClickActualizar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onClickActualizar
        if (tableP.getSelectedRow() == -1) {
            lblMessage.setText("**Seleccione una fila**");            
        } else {
            String ia = tableP.getValueAt(tableP.getSelectedRow(), 0).toString();
            id = this.txtId.getText();
            nombre = this.txtNombre.getText();
            precio = Double.valueOf(this.txtPrecio.getText());
            categoria = ((ComboBoxItem)jcbCategoria.getSelectedItem()).key;
            np.actualizar(ia ,id, nombre, precio, categoria);
            this.listarProducto();
        }
    }//GEN-LAST:event_onClickActualizar

    private void tablePMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePMousePressed
        int f = tableP.getSelectedRow();
        txtId.setText( tableP.getValueAt(f, 0).toString() ); 
        txtNombre.setText( tableP.getValueAt(f, 1).toString());
        txtPrecio.setText( tableP.getValueAt(f, 2).toString());
        jcbCategoria.setSelectedItem(((ComboBoxItem)tableP.getValueAt(f,3)));
    }//GEN-LAST:event_tablePMousePressed

    private void onClickEliminar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onClickEliminar
        if (tableP.getSelectedRow() == -1) {
            lblMessage.setText("**Seleccione una fila**");                        
        } else {
            np.eliminar(txtId.getText());
            this.listarProducto();
        }
    }//GEN-LAST:event_onClickEliminar

    private void listarCategoria() {
        jcbCategoria.setModel(this.toCombo(nc.getlista()));
    }

    private DefaultComboBoxModel toCombo(ArrayList<Object []> ls){         
        ComboBoxItem[] le = new ComboBoxItem[ls.size()];
        for (int i = 0; i < ls.size(); i++) {
            Object[] e = ls.get(i);
            le[i] = new ComboBoxItem( (String)e[0], (String)e[1]);
        }
        return new DefaultComboBoxModel(le);
    }
    public void listarProducto() {
        ArrayList<Object []> lp = np.getlista();
        this.limpiar();
        lp.forEach((e) -> {
            e[3] = this.getCategoria((String)e[3]);
            ((DefaultTableModel) tableP.getModel()).addRow(e);
        });
        lblMessage.setText(np.getDato().getMessage());
    }

    
    private ComboBoxItem getCategoria(String id){
        int i = 0, n = jcbCategoria.getItemCount();
        while (i < n && !id.equals(((ComboBoxItem)jcbCategoria.getItemAt(i)).key)) {i++;}
        return (i >= n)? null : ((ComboBoxItem) jcbCategoria.getItemAt(i)); 
    }
    

    private void limpiar() {
        DefaultTableModel tablaCategoria = (DefaultTableModel) tableP.getModel();
        tablaCategoria.setRowCount(0);
        txtId.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
    }
    
    public static void main(String[] args) {
        NProducto np = new NProducto(new DProducto("", "", 0, ""));      
        NCategoria nc = new NCategoria(new DCategoria("", ""));
        PProducto pg = new PProducto(np,nc);
        pg.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcbCategoria;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lblprecio;
    private javax.swing.JTable tableP;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables


}
