package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	Button run = new Button ("Run");
	Button n = new Button ("new");
	TextField t = new 	TextField("Enter your text here");	
	Button add = new Button ("show table");
	static ListView l = new ListView();
	 TextArea dicV = new TextArea();
	static ArrayList <String>list = new ArrayList<String>();
	static String newString="";
	WordBreak WB= new WordBreak(); 
	

	@Override
	public void start(Stage primaryStage) {
		read();
		t.setMaxSize(400, 10);
		dicV.setMaxSize(300, 500);
		run.setMinSize(50, 30);
		BorderPane p = new BorderPane();
		p.setPadding(new Insets(10,10,10,10));
		p.setTop(t);
		p.setRight(dicV);
		p.setCenter(l);
		HBox h= new HBox();
		HBox h2= new HBox();

		h2.getChildren().addAll(add);
		h.getChildren().addAll(run,n,h2);
		h.setSpacing(100);
		p.setBottom(h);
		
	
		n.setOnAction(e->{
			//list.clear();
			t.setText(" ");
		});
		add.setOnAction(e->{
			int [][] array = WordBreak.table(t.getText(), list);
			for(int i = 0; i < array.length; i++){
				for(int j=0;j<i;j++)
					dicV.appendText("    ");
				for (int k =i;k<array.length;k++)
					dicV.appendText(array[i][k]+"  ");
				dicV.appendText("\n");
		    }
			
		
			//dicV.setEditable(false);
		});
		run.setOnAction(e->{
		
			print (0,0,WB.table(t.getText(), list), t.getText()," ");
		});
		Scene scene = new Scene(p,600,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	static void print (int i,int j,int [][] a, String s,String out)
	{  				
		
		if (j==s.length() )
		{		if(newString!="")		
			l.getItems().add(newString);
			
			return;	
		} 
			if (a[i][j]==0 ) {

			print(i,j+1,a,s,out);

		}
		// true
	
		
			else {
				newString=out+" "+s.substring(i, j+1) ;
			print (j+1,j+1,a,s,out+" "+s.substring(i, j+1) );
			
			 newString="";

			print (i,j+1,a,s,out);
		}
		
	}			
	 

	static  void read()
		{	//LinkedListBooks books= new LinkedListBooks();


			String content=new String();
			try {
				File file=new File("Dic.txt");
				Scanner scan=new Scanner(file);
				while(scan.hasNextLine()) {
					content=scan.nextLine();
				//	System.out.println(content);

				//	String [] array=content.split(" ");
					list.add(content.trim());

				}
				scan.close(); 
			}
			catch (Exception e) {
				System.out.println(e);
			}


		}
	public static void main(String[] args) {
			launch(args);
		
	}
}
