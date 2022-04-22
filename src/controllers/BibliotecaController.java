package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.Autor;


public class BibliotecaController implements Initializable {
	private ObservableList<Autor> listaAutores;
	
	private Archivos archivoNacionalidades;
	private static String ARCHIVO_NACIONALIDADES  = "nacionalidades.txt";
	private Archivos archivoAutores;
	private static String ARCHIVO_AUTORES  = "autores.txt";
	
	@FXML
	private MenuItem btnAcercaDe;
	@FXML
	private MenuItem btnAgregarAutor;
	@FXML
	private MenuItem btnSalir;
	@FXML
	private MenuItem btnGuardar;
	@FXML
	private MenuItem btnCargarDatos;
	@FXML
	private MenuItem btnAgregarLibro;
	@FXML
	private TableView<Autor> tblAutores;
	@FXML
	private TableColumn colNombreAutor;
	@FXML
	private TableColumn colNacionalidadAutor;
	@FXML
	private TableColumn colFechaNacimientoAutor;
	
	@FXML
	private void mostrarAcercaDe(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/AcercaDe.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			//stage.initStyle(StageStyle.UNDECORATED);
			stage.initStyle(StageStyle.UTILITY);
			stage.setTitle("Acerca de");
			stage.setScene(new Scene(root1));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@FXML
	private void agregarAutor(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/AutorAgregar.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			//stage.initStyle(StageStyle.UNDECORATED);
			stage.initStyle(StageStyle.UTILITY);
			stage.setTitle("Agregar Autor");
			stage.setScene(new Scene(root1));
			
			AutorAgregarController controlador = fxmlLoader.getController();
            controlador.inicializarAtributos(listaAutores);
    
			stage.showAndWait();
			
			Autor autorDevuelto = controlador.getAutor();
			if(autorDevuelto != null) {
				this.listaAutores.add(autorDevuelto);
				this.tblAutores.refresh();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
        this.listaAutores = FXCollections.observableArrayList();
        this.tblAutores.setItems(listaAutores);
        this.colNombreAutor.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colNacionalidadAutor.setCellValueFactory(new PropertyValueFactory("nacionalidad"));
        this.colFechaNacimientoAutor.setCellValueFactory(new PropertyValueFactory("fechaNacimiento"));
        
        //Manejo de archivos
        this.archivoNacionalidades = new Archivos(ARCHIVO_NACIONALIDADES);
        if(!this.archivoNacionalidades.existe()) {
        	this.archivoNacionalidades.crearArchivo();
        	System.out.println("archivo " + ARCHIVO_NACIONALIDADES + " creado");
        } else {
        	System.out.println("archivo " + ARCHIVO_NACIONALIDADES + " existe");
        }
                
        this.archivoAutores = new Archivos(ARCHIVO_AUTORES);
        if(!this.archivoAutores.existe()) {
        	this.archivoAutores.crearArchivo();
        	System.out.println("archivo " +  ARCHIVO_AUTORES + " creado");
        } else {
        	System.out.println("archivo " + ARCHIVO_AUTORES + " existe");
        }
        
        
	}
	
	@FXML
	private void salir(ActionEvent event) {
		System.out.println("salir");
		try {
		//Node source = (Node) event.getSource();
		//Stage stage = (Stage) source.getScene().getWindow();
		//stage.close();
		Platform.exit();
	     System.exit(0);
		} catch(Exception e) {
			System.out.println("error al salir");
		}

	}
	
	@FXML
	private void guardar(ActionEvent evento) {
		//guardar autores
		if(this.archivoAutores.guardarAutores(this.listaAutores)) {
			System.out.println("guardado autores exitoso");
		} else {
			System.out.println("guardado erroneo");
		}		
	}
	
	@FXML
	private void cargarDatos(ActionEvent event) {
		ArrayList<Autor> temp = this.archivoAutores.leerAutores();
		for(Autor a:temp)
			listaAutores.add(a);
        this.tblAutores.setItems(listaAutores);
	}
	
	@FXML
	private void agregarLibro(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/LibroAgregar.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			//stage.initStyle(StageStyle.UNDECORATED);
			stage.initStyle(StageStyle.UTILITY);
			stage.setTitle("Agregar Libro");
			stage.setScene(new Scene(root1));
			
			LibroAgregarController controlador = fxmlLoader.getController();
            controlador.inicializarAtributos(listaAutores);
    
			stage.showAndWait();
			/*
			Autor autorDevuelto = controlador.getAutor();
			if(autorDevuelto != null) {
				this.listaAutores.add(autorDevuelto);
				this.tblAutores.refresh();
			}
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	


}
