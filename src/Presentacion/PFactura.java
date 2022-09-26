package Presentacion;

import Negocio.NFactura;
import Negocio.NProducto;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public final class PFactura extends javax.swing.JFrame {

    private final NProducto np;
    private final NFactura nf;
    
    private ArrayList<Object[]> productos;
    private String id;
    private String nombre;
    private String nit;    
    private Date fecha;    
    private double monto;
    
    private boolean stdNew;
    
    public PFactura(NProducto np, NFactura nf) {
        initComponents();        
        this.np = np;
        this.nf = nf; 
        this.productos = new ArrayList();           
        this.stdNew = true;
        this.listarProductoCombo();
        this.listarFactura();
        this.initTable();
    }
    
    public void initTable() {
        int width = tableF.getSize().width;
        TableColumnModel tf = this.tableF.getColumnModel();
        tf.getColumn(0).setMaxWidth((int)(width*0.05));  tf.getColumn(0).setMinWidth((int)(width*0.05));
        tf.getColumn(1).setMaxWidth((int)(width*0.18));  tf.getColumn(1).setMinWidth((int)(width*0.18));
        tf.getColumn(2).setMaxWidth((int)(width*0.17));  tf.getColumn(2).setMinWidth((int)(width*0.17));
        tf.getColumn(3).setMaxWidth((int)(width*0.20));  tf.getColumn(3).setMinWidth((int)(width*0.20));
        tf.getColumn(4).setMaxWidth((int)(width*0.4));  tf.getColumn(4).setMinWidth((int)(width*0.4));
        this.tableF.setRowHeight(35);
        DefaultTableCellRenderer a = new DefaultTableCellRenderer();
        a.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tableF.getColumnCount(); i++) 
            tf.getColumn(i).setCellRenderer(a);           
        this.tableP.setRowHeight(35);
        width = tableP.getSize().width;
        for (int i = 0; i < tableP.getColumnCount(); i++) 
            this.tableP.getColumnModel().getColumn(i).setCellRenderer(a);   
        TableColumnModel tp = this.tableP.getColumnModel();
        tp.getColumn(0).setMaxWidth((int)(width*0.5));  tp.getColumn(0).setMinWidth((int)(width*0.5));
        tp.getColumn(1).setMaxWidth((int)(width*0.25));  tp.getColumn(1).setMinWidth((int)(width*0.25));
        tp.getColumn(2).setMaxWidth((int)(width*0.2));  tp.getColumn(2).setMinWidth((int)(width*0.2));
        tp.getColumn(3).setMaxWidth((int)(width*0.05));  tp.getColumn(3).setMinWidth((int)(width*0.05));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jcbProducto = new javax.swing.JComboBox();
        lblCategoria = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableP = new javax.swing.JTable();
        txtPrecio = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        lblPrecio = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableF = new javax.swing.JTable();
        btnRegistrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        lblNit = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtNit = new javax.swing.JTextField();
        lblMessage = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        lblprecio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestionar Factura");
        setBackground(new java.awt.Color(255, 0, 51));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jcbProducto.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jcbProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbProductoActionPerformed(evt);
            }
        });

        lblCategoria.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        lblCategoria.setForeground(new java.awt.Color(255, 255, 255));
        lblCategoria.setText("Producto");
        lblCategoria.setToolTipText("");

        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregaronClickAgregar(evt);
            }
        });

        tableP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tableP.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        tableP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio", "Cantidad", "Eliminar"
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
        jScrollPane2.setViewportView(tableP);

        txtPrecio.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        txtPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCantidad.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblPrecio.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        lblPrecio.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecio.setText("Precio");
        lblPrecio.setToolTipText("");

        lblCantidad.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        lblCantidad.setForeground(new java.awt.Color(255, 255, 255));
        lblCantidad.setText("Cantidad");
        lblCantidad.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCategoria)
                    .addComponent(jcbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblPrecio)))
                .addContainerGap(237, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblCategoria)
                        .addGap(1, 1, 1)
                        .addComponent(jcbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCantidad)
                                .addComponent(lblPrecio))
                            .addGap(3, 3, 3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Factura", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(204, 204, 204));

        tableF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tableF.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        tableF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "FECHA", "MONTO", "NIT", "NOMBRE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableFMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tableF);

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
        lblId.setText("ID");
        lblId.setToolTipText("");

        lblnombre.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        lblnombre.setForeground(new java.awt.Color(255, 255, 255));
        lblnombre.setText("Nombre");

        lblNit.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        lblNit.setForeground(new java.awt.Color(255, 255, 255));
        lblNit.setText("Nit");

        txtId.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        txtId.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtNombre.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtNit.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        txtNit.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblMessage.setBackground(new java.awt.Color(0, 0, 0));
        lblMessage.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lblMessage.setForeground(new java.awt.Color(102, 255, 153));
        lblMessage.setText("jLabel3");

        txtMonto.setEditable(false);
        txtMonto.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        txtMonto.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblprecio.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        lblprecio.setForeground(new java.awt.Color(255, 255, 255));
        lblprecio.setText("Monto");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(lblId)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(189, 189, 189)
                                .addComponent(lblnombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblNit)
                                .addGap(96, 96, 96))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addComponent(txtNit, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblprecio)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblMessage)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(btnRegistrar)
                .addGap(31, 31, 31)
                .addComponent(btnActualizar)
                .addGap(30, 30, 30)
                .addComponent(btnEliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNit)
                        .addComponent(lblprecio))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblId)
                        .addComponent(lblnombre)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(lblMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
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
        nit = txtNit.getText();
        fecha = Date.valueOf(LocalDateTime.now().toLocalDate());
        for (Object[] p : productos) 
          p[0] =((ComboBoxItem)p[0]).key ;
        nf.agregar(id, fecha, monto, nit, nombre, productos);
        productos.clear();
        this.listarFactura();
        this.listarProductosDynamic();
    }//GEN-LAST:event_onClickAgregar

    private void onClickActualizar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onClickActualizar
        if (tableF.getSelectedRow() == -1) {
            lblMessage.setText("!Seleccione un elemento de Factura");            
        } else {
            String ia = tableF.getValueAt(tableF.getSelectedRow(), 0).toString();
            id = this.txtId.getText();
            nombre = this.txtNombre.getText();
            nit = this.txtNit.getText();
            nf.actualizar(ia, id, nit, nombre);
            this.listarFactura();
            this.lblMessage.setText(nf.getDatoFactura().getMessage());
        }
    }//GEN-LAST:event_onClickActualizar

    private void tableFMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableFMousePressed
        int f = tableF.getSelectedRow();
        id = tableF.getValueAt(f, 0).toString();
        nit = tableF.getValueAt(f, 3).toString();
        nombre = tableF.getValueAt(f, 4).toString();
        productos = nf.getlistaDetalle(id);
        txtId.setText(id); 
        txtNit.setText(nit);
        txtNombre.setText(nombre);    
        this.listarProductosDynamic();
        this.stdNew = false;
        btnAgregar.setText("Nuevo");
    }//GEN-LAST:event_tableFMousePressed

    private void onClickEliminar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onClickEliminar
        int f = tableF.getSelectedRow();
        if ( f== -1) {
            lblMessage.setText("**Seleccione una fila**");                        
        } else {
            nf.eliminar(tableF.getValueAt(f, 0).toString());
            this.listarFactura();
        }
    }//GEN-LAST:event_onClickEliminar

    private void btnAgregaronClickAgregar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregaronClickAgregar
        if (!this.stdNew) {
            this.nuevaFactura();
        } else {
            ComboBoxItem cmb = ((ComboBoxItem)jcbProducto.getSelectedItem());
            Double prc = Double.valueOf(txtPrecio.getText());
            int ctd = Integer.parseInt(txtCantidad.getText());
            this.productos.add(new Object[]{cmb, prc, ctd, "X"});
            this.listarProductosDynamic();
            monto = monto + (prc * ctd);
            txtMonto.setText(String.valueOf(monto)); 
        }        
    }//GEN-LAST:event_btnAgregaronClickAgregar
    
    public void nuevaFactura() {
        this.stdNew = true;
        btnAgregar.setText("Agregar");        
        txtId.setText("");
        txtNombre.setText("");
        txtNit.setText("");
        productos.clear();
        monto = 0;
        txtMonto.setText(String.valueOf(monto));
        this.listarProductosDynamic();
    }
    
    private void tablePMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePMousePressed
        int c = tableP.getSelectedColumn();               
        if (c == 3 && stdNew) {
            int f = tableP.getSelectedRow();
            Object[] p = (Object[])productos.get(f);
            double prc = (double)p[1];
            int ctd = (int)p[2];
            productos.remove(f); 
            monto = monto - (prc * ctd);
            txtMonto.setText(String.valueOf(monto));
            this.listarProductosDynamic();          
        }
    }//GEN-LAST:event_tablePMousePressed

    private void jcbProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbProductoActionPerformed
        String id = ((ComboBoxItem) jcbProducto.getSelectedItem()).key;
        Object[] p = np.getById(id);
        txtPrecio.setText(String.valueOf((double)p[2]));
        txtCantidad.setText("1");
    }//GEN-LAST:event_jcbProductoActionPerformed

    private void listarProductoCombo() {
        jcbProducto.setModel(this.toCombo(np.getlista()));
    }

    private DefaultComboBoxModel toCombo(ArrayList<Object []> ls){
        ComboBoxItem[] le = new ComboBoxItem[ls.size()];
        for (int i = 0; i < ls.size(); i++) {
             Object[] e = ls.get(i);
             le[i] = new ComboBoxItem( (String)e[0], (String)e[1]);
        }
        if (!ls.isEmpty()) {
          double e = (double)ls.get(0)[2];
          txtPrecio.setText(String.valueOf(e));
          txtCantidad.setText("1");  
        }        
        return new DefaultComboBoxModel(le);
    }
    public void listarFactura() {
        this.limpiar();
        ArrayList<Object []> lp = nf.getlista();     
        lp.forEach((Object [] e) -> {
            ((DefaultTableModel) tableF.getModel()).addRow(e);
        });
        lblMessage.setText(nf.getDatoFactura().getMessage());
    }

    private void limpiar() {
        DefaultTableModel tablaCategoria = (DefaultTableModel) tableF.getModel();
        tablaCategoria.setRowCount(0);
        monto = 0;
        txtId.setText("");
        txtNombre.setText("");
        txtNit.setText("");
        txtMonto.setText(String.valueOf(monto));
    }
    
    public static void main(String[] args) {
        NProducto np = new NProducto();      
        NFactura nf = new NFactura();
        PFactura pg = new PFactura(np,nf);
        pg.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox jcbProducto;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblNit;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lblprecio;
    private javax.swing.JTable tableF;
    private javax.swing.JTable tableP;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtNit;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables

    private void listarProductosDynamic() {
        DefaultTableModel TP = (DefaultTableModel) tableP.getModel();
        TP.setRowCount(0);
        productos.forEach((Object[] p) -> {TP.addRow(p);});            
    }


}
