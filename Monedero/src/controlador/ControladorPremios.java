
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import modelo.ModeloPremios;
import vista.MenuPrincipal;
import vista.Premios;
import controlador.ControladorMenu;

public class ControladorPremios implements ActionListener, PropertyChangeListener, ChangeListener, MouseListener {
    
    private ModeloPremios modelo;
    private Premios vista;
    
    public ControladorPremios(ModeloPremios modelo, Premios vista){
        this.modelo=modelo;
        this.vista=vista;
        this.vista.tablaPremios.addMouseListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
        this.vista.btnRegresar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
    }
    
    public void iniciarVista(){
        vista.pack();
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setAlwaysOnTop( true );
        vista.setLocationRelativeTo(null);
        vista.setAlwaysOnTop( false );vista.dispose();
        vista.setVisible(true);
        
        vista.setResizable(false);
        vista.setTitle("PREMIOS");
        vista.tablaPremios.setModel(modelo.cargarDatos());
        
    }
    
    public void limpiarVista(){
        vista.txtIdPremio.setText("");
        vista.txtDescrip.setText("");
        vista.txtStock.setText("");
        vista.txtPuntos.setText("");
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(vista.btnAgregar == evento.getSource()){
            modelo.agregarPremio(Integer.parseInt(vista.txtIdPremio.getText()), vista.txtDescrip.getText(), Integer.parseInt(vista.txtStock.getText()), Integer.parseInt(vista.txtStock.getText()));
                
            JOptionPane.showMessageDialog(vista, "Se insertó el registro");
            limpiarVista();
            vista.tablaPremios.setModel(modelo.cargarDatos());
        }                
        if(vista.btnCancelar == evento.getSource()){
                limpiarVista();
        }   
        if(vista.btnRegresar == evento.getSource()){
            MenuPrincipal obj = new MenuPrincipal();
            ModeloMenuPrincipal modeloMenu = new ModeloMenuPrincipal();
            ControladorMenu ControladorMenuPrincipal = new ControladorMenu (modeloMenu,obj);
            ControladorMenuPrincipal.iniciarVista();
            vista.dispose();
        }
        if(vista.btnEditar == evento.getSource()){ 
            vista.btnCancelar.setEnabled(true);
            int idSucursal = Integer.parseInt(vista.txtIdPremio.getText());
            vista.tablaPremios.setModel(modelo.buscarDatos( idSucursal));          
           // JOptionPane.showMessageDialog(null, "Registro consultado exitosamente");
        }
        if(vista.btnEditar == evento.getSource()){
            modelo.conActualizar(Integer.parseInt(vista.txtIdSucursal.getText()), vista.txtNombre.getText(),vista.txtDireccion.getText(),vista.txtTelefono.getText(),vista.txtCorreo.getText());
            vista.tablaSuc.setModel(modelo.cargarDatos());
            limpiarVista();
        }
        if(vista.btnEliminar == evento.getSource()){
            if(modelo.conEliminar(Integer.parseInt(vista.txtIdSucursal.getText()))){
                JOptionPane.showMessageDialog(null, "Registro eliminado");
                limpiarVista();
                vista.tablaSuc.setModel(modelo.cargarDatos());
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
