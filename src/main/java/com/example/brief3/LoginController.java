package com.example.brief3;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.impl.OfficerImpl;
import com.models.Officer;



public class LoginController{
    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageError;
    @FXML
    private TextField emailOfficer;
    @FXML
    private PasswordField passwordOfficer;
    @FXML
    private Label messageLogin;
    @FXML
    private Label emailInvalid;
    @FXML
    private Label passwordInvalid;

    private Stage stage;
    private Scene scene;

  
    @FXML
    public void loginPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void cancelButtonAction(ActionEvent event){
        Platform.exit();
    }
    public void validateLogin(ActionEvent event) throws IOException{

    	/*MututelleApplication m =new MututelleApplication();
    	   JSONParser jsonParser = new JSONParser();
           try (FileReader reader = new FileReader("C:\\Users\\adm\\Desktop\\brief3\\src\\main\\java\\com\\example\\brief3\\data.json"))
           {
               Object obj = jsonParser.parse(reader);

               JSONArray employeeList = (JSONArray) obj;
               System.out.println(employeeList);

               for (Object o : employeeList) {
                   JSONObject employee = (JSONObject) o;
                   String email = (String) employee.get("email");
                   String password = (String) employee.get("password");

                   if ((this.emailOfficer.getText().isEmpty() || this.passwordOfficer.getText().isEmpty())) {
                	   loginMessageError.setText("Please fill all the fields");
                       break;
                   } else if (email.equals(this.emailOfficer.getText()) && password.equals(this.passwordOfficer.getText())) {
                	   messageLogin.setText("Success!");
                	  
                       break;
                   } else {
                	   loginMessageError.setText("Invalide login ,Try again !");
                   }
               }


           } catch (FileNotFoundException e) {
               e.printStackTrace();
           } catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    	passwordInvalid.setText("");
    	emailInvalid.setText("");
    	loginMessageError.setText("");
    	 if(emailOfficer.getText().isBlank() == false && passwordOfficer.getText().isBlank() == false) {
             //validateLogin();
    	    	
    	        OfficerImpl officerimpl = new OfficerImpl();

    	    	   ObjectMapper objectMapper = new ObjectMapper();
    	           try {
    	                 InputStream inputStream = new FileInputStream(new File("C:\\Users\\adm\\Desktop\\brief3\\src\\main\\java\\com\\example\\brief3\\data.json"));
    	                 TypeReference<List<Officer>> typeReference = new TypeReference<List<Officer>>() {};
    	                 List<Officer> Officers = objectMapper.readValue(inputStream, typeReference);
    	                int index =  officerimpl.verifEmail(this.emailOfficer.getText().toString(), Officers);
    	                if(index == -1) {
    	                	emailInvalid.setText("Email Invalid");  	
    	                }
    	                if(index !=-1) {
    		               boolean result =  officerimpl.verifPassword(this.passwordOfficer.getText().toString(), index, Officers);
    		             
    		                if(result) {
    		                	messageLogin.setText("Success!");
    		                	emailOfficer.setText("");
    		                	passwordOfficer.setText("");
    		                	  Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
    		                      stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    		                      scene = new Scene(root);
    		                      stage.setScene(scene);
    		                      stage.show();
    		                	
    		                }
    		                else {
    		                	passwordInvalid.setText("Password invalid");
    		                }
    	                }
    	             }catch(FileNotFoundException e) {
    	                 e.printStackTrace();
    	             } catch (IOException e) {
    	                 // TODO Auto-generated catch block
    	                 e.printStackTrace();
    	             }
         }else{
             loginMessageError.setText("Please enter your username and password");

         }

       }
   
 
}