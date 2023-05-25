/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BibliotecaIU;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author alumno
 */
public class BibliotecaIU extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {

        biblioIU();
        
        
    }

    public void biblioIU(){
        
        
        Stage escenario = new Stage();
        Label l1 = new Label("ISBN");
        Label l2 = new Label("Nombre");
        Label l3 = new Label("Fecha (formato dd/MM/uuuu");
        Label l4 = new Label("Autores (Mas de un autor, separado por\"-\")");

        TextField tField1 = new TextField();
        TextField tField2 = new TextField();
        TextField tField3 = new TextField();
        TextField tField4 = new TextField("Formato Autor: 1erApellido 2Apellido, Nombre");
        
        
        
        
        
        Button boton1 = new Button("addLibro");
        Button boton2 = new Button("deleteLibro");
        Button boton3 = new Button("modificarLibro");
        Button boton4 = new Button("cargarLibro");
        
        
        boton1.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            try {
                agregarLibro(tField1, tField2, tField3, tField4);
            } catch (FileNotFoundException ex) {
            }
        });
        

//        EventHandler<MouseEvent> e = (MouseEvent event) -> {
//            if(event.getEventType()==MouseEvent.MOUSE_CLICKED){
//                try {
//                    agregarLibro(tField1, tField2, tField3, tField4);
//                } catch (FileNotFoundException ex) {
//                }
//            }
//        };


//        EventHandler<MouseEvent> e = new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                if(event.getEventType() == MouseEvent.MOUSE_CLICKED){
//                    try {
//                        agregarLibro(tField1, tField2, tField3, tField4);
//                    } catch (FileNotFoundException ex) {
//                        Logger.getLogger(BibliotecaIU.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            }
//        };
        

        
        HBox layoutH = new HBox(10,boton1,boton2,boton3,boton4);
        
        VBox layoutV = new VBox(20, l1,tField1,l2,tField2,l3,tField3,l4,tField4,layoutH);
        Scene escena = new Scene(layoutV, 500, 500);
        escenario.setScene(escena);
        escenario.show();
        
        
        
        
        
        
    }
    
    private void agregarLibro(TextField t1,TextField t2,TextField t3,TextField t4) throws FileNotFoundException{
        
        List<Autor> aux = new ArrayList<>();
        String [] arr = t4.getText().split(",");
        if(arr.length>1){
            for(String f:arr)
                aux.add(new Autor(f));
        }else{
            aux.add(new Autor(t4.getText()));
        }
        
        LocalDate aux2 = LocalDate.parse(t3.getText(), DateTimeFormatter.ofPattern("dd/MM/uuuu"));
        
        Libro libro = new Libro(t1.getText(), t3.getText(), aux2, aux);
        
        BibliotecaPersistente.addLibro(libro);
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
