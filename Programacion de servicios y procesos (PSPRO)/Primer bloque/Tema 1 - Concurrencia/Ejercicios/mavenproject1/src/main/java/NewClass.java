
import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class NewClass extends JPanel {
  Thread hilo;
  Object objeto = new Object();
  boolean pideParar = false;
  JTextField texto;
  JProgressBar barra;
  
  public NewClass() {
    setLayout( new BorderLayout() );
    
    texto = new JTextField();
    add( texto,BorderLayout.NORTH );
    
    JPanel panelInferior = new JPanel();
    barra = new JProgressBar();
    panelInferior.setLayout( new GridLayout(0,1) );
    panelInferior.add( barra );
    panelInferior.add( new JLabel( "Cargando..." ) );

    JPanel panelBotones = new JPanel();
    JButton botonArranque = new JButton( "Arrancar" );
    botonArranque.setBackground( SystemColor.control );
    panelBotones.add( botonArranque );
    botonArranque.addActionListener( new ActionListener() {
      public void actionPerformed( ActionEvent evt ) {
	iniciaCuenta();
      }
    } );
    
    JButton botonParar = new JButton( "Parar" );
    botonParar.setBackground( SystemColor.control );
    panelBotones.add( botonParar );
    botonParar.addActionListener( new ActionListener() {
      public void actionPerformed( ActionEvent evt ) {
	detieneCuenta();
      }
    } );
    
    panelInferior.add( panelBotones );
    add( panelInferior,BorderLayout.SOUTH );
  } 
    
  public void iniciaCuenta() {
    if( hilo == null ) {
      hilo = new ThreadCarga();
      pideParar = false;
      hilo.start();
    }
  }
    
  public void detieneCuenta() {
    synchronized( objeto ) {
      pideParar = true;
      objeto.notify();
    }
  } 

    
  class ThreadCarga extends Thread {
    public void run() {
      int min = 0;
      int max = 100;

      barra.setValue( min );
      barra.setMinimum( min );
      barra.setMaximum( max );

      for (int i=min; i <= max; i++ ) {
	barra.setValue( i );
	texto.setText( ""+i );
	synchronized( objeto ) {
	  if( pideParar )
	    break;
	  try {
	    objeto.wait( 100 );
	  } catch( InterruptedException e ) {
	    // Se ignoran las excepciones
	  }
	}
      }
      hilo = null;
    }
  }
  
  public static void main( String args[] ) {
    JFrame frame = new JFrame( "Tutorial de Java, Swing" );
    
    frame.addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent evt ) {
	System.exit( 0 );
      }
    });
    
    frame.getContentPane().add( new java1428(),BorderLayout.CENTER );
    frame.setSize( 400,150 );
    frame.setVisible( true );
  }
}
