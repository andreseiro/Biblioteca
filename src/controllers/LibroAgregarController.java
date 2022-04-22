package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import models.Autor;
import models.TipoLibro;

public class LibroAgregarController implements Initializable{
	private static String ARCHIVO_AUTORES = "autores.txt";
	private Archivos archivoAutores;
	private ObservableList<Autor> listaAutores;
	
	@FXML
	private ComboBox<Autor> txtListaAutor;
	
	@FXML
	private TextField txtNombreLibro;
	
	@FXML
	private ComboBox<TipoLibro> txtTipoLibro;
	
	@FXML
	private TextField txtEditorial;
	
	@FXML
	private Button btnGuardar;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
	
	public void inicializarAtributos(ObservableList<Autor> listaAutores) {
		//ComboBox Autores
		this.listaAutores = listaAutores;
		this.txtListaAutor.setItems(this.listaAutores);	
		//ComboBox TipoLibro
		this.txtTipoLibro.getItems().addAll(TipoLibro.values());
	}
	
	@FXML
	private void guardarLibro(ActionEvent evento) {
		
	}

}
