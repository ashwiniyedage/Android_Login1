package com.example.login1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

private EditText username;
private EditText password;
private Button login;
private Text info;
private Button Sign;
private int counter=3;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=(EditText)findViewById(R.id.editText2);
        password=(EditText)findViewById((R.id.editText3));
        login=(Button)findViewById(R.id.button);
        Sign=(Button)findViewById(R.id.button2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               validate(username.getText().toString(),password.getText().toString());
               //regi();
            }
        });
        Sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(MainActivity.this,SignUp.class);
                startActivity(i1);
            }
        });


    }

    private void validate(String u_name,String u_pass)
    {

       if((u_name.equals("admin")) &&( u_pass.equals("pass")))
       {
           Intent i=new Intent(MainActivity.this,Trial.class);
           startActivity(i);
           Toast.makeText(getApplicationContext(), "Redirecting.....", Toast.LENGTH_SHORT).show();
       }
    else
       {
           Toast.makeText(getApplicationContext(), "Wrong Credential", Toast.LENGTH_SHORT).show();
           //info.setTextContent("Invalid username or password");
           counter--;
       }
    if(counter==0)
    {
        login.setEnabled(false);
    }
    }
}
