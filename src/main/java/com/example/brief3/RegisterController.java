package com.example.brief3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.Client;
import com.models.DialCode;
import com.models.Officer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class RegisterController implements Initializable {
	@FXML
	private Button registerClick;
	@FXML
	private TextField numeroBadge;
	@FXML
	private Label errorNumeroBadge;
	@FXML
	private TextField nomEntreprise;
	@FXML
	private Label errorNomEntreprise;
	@FXML
	private TextField prenomClient;
	@FXML
	private Label errorPrenomClient;
	@FXML
	private TextField nomClient;
	@FXML
	private Label errorNomClient;
	@FXML
	private TextField telephone;
	@FXML
	private Label errorTelephone;
	@FXML
	private TextField cin;
	@FXML
	private Label errorCIN;
	@FXML
	private TextArea adresse;
	@FXML
	private TextField email;
	@FXML
	private Label errorEmail;
	@FXML
	private DatePicker dateDebutTravail;
	@FXML
	private Label verifChamps;
	@FXML
	private ChoiceBox<String> choisePhone ;
	
	@FXML
	private TableColumn<Client, String> badge;
	@FXML
	private TableColumn<Client, String> entrepriseName;
	@FXML
	private TableColumn<Client, String> prenom;
	@FXML
	private TableColumn<Client, String> nom;
	@FXML
	private TableColumn<Client, String> tele;
	@FXML
	private TableColumn<Client, String> identite;
	@FXML
	private TableColumn<Client, String> adresseClient;
	@FXML
	private TableColumn<Client, String> emailClient;
	@FXML
	private TableColumn<Client, String> dateTravail;
	@FXML
	private TableView<Client> tableClientList;
	boolean filledCin;
	
		private Parent root;
	    private Stage stage;
	    private Scene scene;
	
	List<Client> clientList = new ArrayList<>();
	ObservableList<Client> data;
	@FXML
	private Label choixIdentite;
	@FXML
	public void cinIdentite() {
		cin.setPromptText("CIN de Client");
		cin.setVisible(true);
		choixIdentite.setText("CIN :");
		choixIdentite.setVisible(true);
		filledCin = true;
	}
	@FXML
	public void passIdentite() {
		cin.setPromptText("Passport de Client");
		cin.setVisible(true);
		choixIdentite.setText("PASSPORT :");
		choixIdentite.setVisible(true);
	}
	
	@FXML
	public void logout(ActionEvent e) throws IOException {
	    Parent root = FXMLLoader.load(getClass().getResource("welcomePage.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}
	@FXML
	public void registerButton(ActionEvent event) {
		errorCIN.setText("");
		errorNomClient.setText("");
		errorNomEntreprise.setText("");
		errorNumeroBadge.setText("");
		errorPrenomClient.setText("");
		errorTelephone.setText("");
		errorEmail.setText("");
		verifChamps.setText("");
		
		int compErr=0;
		if(numeroBadge.getText().isBlank() == true || nomEntreprise.getText().isBlank() == true || prenomClient.getText().isBlank() == true || nomClient.getText().isBlank() == true || telephone.getText().isBlank() == true || cin.getText().isBlank() == true || adresse.getText().isBlank() == true || email.getText().isBlank() == true || dateDebutTravail.getValue().toString().isBlank() == true) {
			verifChamps.setText("Svp remplire tous les champs");
			compErr++;
		}
		if(numeroBadge.getText().length() <= 10 ) {
			System.out.println("done");
			
		}
		
		else {
			compErr++;
			errorNumeroBadge.setText("max 10");
		}
		if(nomEntreprise.getText().length() <= 10) {
			System.out.println("done");
			
		}
		else {
			compErr++;
			errorNomEntreprise.setText("max 10");
		}
		if(prenomClient.getText().length() <= 10) {
			System.out.println("done");
			
		}
		else {
			compErr++;
			errorPrenomClient.setText("max 10");
		}
		if(nomClient.getText().length() <= 10) {
			System.out.println("done");
			
		}
		else {
			compErr++;
			errorNomClient.setText("max 10");
		}
		if(telephone.getText().length() <= 9) {
			System.out.println("done");
		}
		else {
			compErr++;
			errorTelephone.setText("max 10");
		}
		if(!telephone.getText().matches("[0-9]{4}")) {
			compErr++;
			errorTelephone.setText("svp enter des nombres");
		}
		if(filledCin && cin.getText().length() > 8) {
            compErr++;
            errorCIN.setText("the cin number can not have more then 8 N");
            
        }
    
        if(filledCin && !cin.getText().matches("[a-zA-Z]{2}\\d{6}")) {
            compErr++;
            errorCIN.setText("the cin must be 2 numbers and 6 L");
        }
        if(!filledCin && !cin.getText().matches("[a-zA-Z]{2}\\d{7}")) {
            compErr++;
            errorCIN.setText("the Passport must be 2 numbers and 7 L");
        }
        if(!email.getText().matches("^(.+)@(.+)$")) {
            compErr++;
        	errorEmail.setText("format invalide");
        }

		if(compErr==0)
		dataClient();
	
	}
	
	public void dataClient() {
		clientList.add(new Client(prenomClient.getText(),nomClient.getText(),email.getText(),(choisePhone.getValue() + telephone.getText()),adresse.getText(),cin.getText(),numeroBadge.getText(),nomEntreprise.getText(),dateDebutTravail.getValue().toString(),filledCin));
		System.out.println(clientList);
		data = FXCollections.<Client>observableArrayList(clientList);
		emptyChamp();
	}
	public void emptyChamp() {
		prenomClient.setText("");
		nomClient.setText("");
		nomClient.setText("");
		email.setText("");
		telephone.setText("");
		adresse.setText("");
		cin.setText("");
		numeroBadge.setText("");
		nomEntreprise.setText("");
		dateDebutTravail.getEditor().clear();
		errorCIN.setText("");
		errorNomClient.setText("");
		errorNomEntreprise.setText("");
		errorNumeroBadge.setText("");
		errorPrenomClient.setText("");
		errorTelephone.setText("");
		errorEmail.setText("");
		verifChamps.setText("");
		
		remplireTable();
	}
	
	public void remplireTable() {
		badge.setCellValueFactory(new PropertyValueFactory<Client, String>("numeroBadge"));
		entrepriseName.setCellValueFactory(new PropertyValueFactory<Client, String>("nomEntreprise"));
		prenom.setCellValueFactory(new PropertyValueFactory<Client, String>("firstname"));
		nom.setCellValueFactory(new PropertyValueFactory<Client, String>("lastname"));
		tele.setCellValueFactory(new PropertyValueFactory<Client, String>("phone"));
		identite.setCellValueFactory(new PropertyValueFactory<Client, String>("cin"));
		adresseClient.setCellValueFactory(new PropertyValueFactory<Client, String>("address"));
		emailClient.setCellValueFactory(new PropertyValueFactory<Client, String>("email"));
		dateTravail.setCellValueFactory(new PropertyValueFactory<Client, String>("dateDebut"));
		tableClientList.setItems(data);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		 JSONParser jsonParser = new JSONParser();
         try (FileReader reader = new FileReader("C:\\Users\\adm\\Desktop\\brief3\\src\\main\\java\\com\\example\\brief3\\data2.json"))
         {
             Object obj = jsonParser.parse(reader);

             JSONArray numbrePhone = (JSONArray) obj;
             System.out.println(numbrePhone);
             for (Object object : numbrePhone) {
            	 JSONObject o = (JSONObject) object;
            	 choisePhone.getItems().add((String)o.get("dial_code"));
			}

         } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
