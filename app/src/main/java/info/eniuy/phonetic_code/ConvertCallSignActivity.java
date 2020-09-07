package info.eniuy.phonetic_code;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.res.Resources;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class ConvertCallSignActivity extends AppCompatActivity implements TextWatcher {
    private String[] characters;
    private String[] phoneticCodes;
    private String[] characterNumbers;
    private String[] phoneticCodeNumbers;
    private String[] morseCodes;
    private String[] morseCodeNumbers;
    private TextView errorMessage;
    private TextView yourCallSignValue;
    private TextView yourPhoneticCodeValue;
    private TextView yourMorseCodeValue;
    private ClipboardManager clipboardManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_call_sign);
        Resources resources = getResources();//resources files
        Intent intent = getIntent();//intent from MainActivity.java
        copyYourPhoneticCodeValue();//copy yourPhoneticCodeValue to clipboard
        copyYourMorseCodeValue();//copy yourMorseCodeValue to clipboard
        characters = intent.getStringArrayExtra("character");//set characters A,B,C...
        characterNumbers = resources.getStringArray(R.array.characterNumbers_array);//0,1,2,...
        phoneticCodes = resources.getStringArray(R.array.phoneticCodes_array);//"ALFA", "BRAVO", "CHARLIE"
        phoneticCodeNumbers = resources.getStringArray(R.array.phoneticCodeNumbers_array);//zero,one,two...
        morseCodes = intent.getStringArrayExtra("morseCode");
        morseCodeNumbers = intent.getStringArrayExtra("morseCodeNumber");
        EditText editCallSign = findViewById(R.id.editCallSign);//edit text field
        editCallSign.addTextChangedListener(this);// set text change listener
        errorMessage = findViewById(R.id.errorMessage);//error massage field
        yourCallSignValue = findViewById(R.id.yourCallSignValue);//call sign field
        yourPhoneticCodeValue = findViewById(R.id.yourPhoneticCodeValue);//phonetic code field
        yourMorseCodeValue = findViewById(R.id.yourMorseCodeValue);//morse code field


    }

    private void copyYourPhoneticCodeValue() {
        //Set field
        TextView yourPhoneticCodeValue = findViewById(R.id.yourPhoneticCodeValue);//phonetic code field;
        clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);// call clipboardManager
        //onLongClick(View v)
        yourPhoneticCodeValue.setOnLongClickListener(v -> {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("yourPhoneticCodeValue", yourPhoneticCodeValue.getText()));
            Toast.makeText(getApplicationContext(), getString(R.string.copiedToClipboard), Toast.LENGTH_SHORT).show();
            return true;
        });//yourPhoneticCodeValue.setOnLongClickListener(new View.OnLongClickListener()
    }//copyYourPhoneticCodeValue()

    private void copyYourMorseCodeValue() {
        //Set field
        TextView yourMorseCodeValue = findViewById(R.id.yourMorseCodeValue);//morse code field
        clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);// call clipboardManager
        //onLongClick(View v)
        yourMorseCodeValue.setOnLongClickListener(v -> {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("yourPhoneticCodeValue", yourMorseCodeValue.getText()));
            Toast.makeText(getApplicationContext(), getString(R.string.copiedToClipboard), Toast.LENGTH_SHORT).show();
            return true;
        });//yourMorseCodeValue.setOnLongClickListener(new View.OnLongClickListener()
    }//copyYourMorseCodeValue()


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override //after text edited
    public void afterTextChanged(Editable s) {
        // on change text to upper case string
        String inputStr = s.toString().toUpperCase();
        //connect characters and characterNumbers
        ArrayList<String> letterList = new ArrayList<>(Arrays.asList(characters));
        ArrayList<String> letterList2 = new ArrayList<>(Arrays.asList(characterNumbers));
        letterList.addAll(letterList2);
        //connect phoneticCodes and phoneticCodeNumbers
        ArrayList<String> phoneticList = new ArrayList<>(Arrays.asList(phoneticCodes));
        ArrayList<String> phoneticList2 = new ArrayList<>(Arrays.asList(phoneticCodeNumbers));
        phoneticList.addAll(phoneticList2);
        //connect morseCodes and morseCodeNumbers
        ArrayList<String> morseList = new ArrayList<>(Arrays.asList(morseCodes));
        ArrayList<String> morseList2 = new ArrayList<>(Arrays.asList(morseCodeNumbers));
        morseList.addAll(morseList2);

        String letter1 = "";//text field 1st character
        String letter2 = "";//text field 2nd character
        String letter3 = "";//text field 3rd character
        String letter4 = "";//text field 4th character
        String letter5 = "";//text field 5th character
        String letter6 = "";//text field 6th character
        String phonetic1 = ""; //phonetic letter1
        String phonetic2 = ""; //phonetic letter2
        String phonetic3 = ""; //phonetic letter3
        String phonetic4 = ""; //phonetic letter4
        String phonetic5 = ""; //phonetic letter5
        String phonetic6 = ""; //phonetic letter6
        String morse1 = "";//morse code 1st
        String morse2 = "";//morse code 2nd
        String morse3 = "";//morse code 3rd
        String morse4 = "";//morse code 4th
        String morse5 = "";//morse code 5th
        String morse6 = "";//morse code 6th
        // count characters less or equal 6
        if (inputStr.length() > 6) {//over 6 characters
            errorMessage.setText(R.string.errorMaxCharacter);
            yourCallSignValue.setText("");
            yourPhoneticCodeValue.setText("");
            yourMorseCodeValue.setText("");
        }//if(inputStr.length() >6)
        else if (inputStr.length() == 0) {// characters =0
            errorMessage.setText("");
            yourCallSignValue.setText("");
            yourPhoneticCodeValue.setText("");
            yourMorseCodeValue.setText("");
        } else {//less than 6 characters
            if (inputStr.matches("^[A-Z0-9]+$")) {//if("^[A-Z0-9]+$")
                if (inputStr.length() == 1) {
                    //set letter values
                    letter1 = inputStr;
                } else if (inputStr.length() == 2) {
                    letter1 = inputStr.substring(0, 1);
                    letter2 = inputStr.substring(1, 2);
                } else if (inputStr.length() == 3) {
                    letter1 = inputStr.substring(0, 1);
                    letter2 = inputStr.substring(1, 2);
                    letter3 = inputStr.substring(2, 3);
                } else if (inputStr.length() == 4) {
                    letter1 = inputStr.substring(0, 1);
                    letter2 = inputStr.substring(1, 2);
                    letter3 = inputStr.substring(2, 3);
                    letter4 = inputStr.substring(3, 4);
                } else if (inputStr.length() == 5) {
                    letter1 = inputStr.substring(0, 1);
                    letter2 = inputStr.substring(1, 2);
                    letter3 = inputStr.substring(2, 3);
                    letter4 = inputStr.substring(3, 4);
                    letter5 = inputStr.substring(4, 5);
                }
                if (inputStr.length() == 6) {
                    letter1 = inputStr.substring(0, 1);
                    letter2 = inputStr.substring(1, 2);
                    letter3 = inputStr.substring(2, 3);
                    letter4 = inputStr.substring(3, 4);
                    letter5 = inputStr.substring(4, 5);
                    letter6 = inputStr.substring(5);
                }
                for (int i = 0; i < letterList.size(); i++) {
                    //set phonetic values

                    if (letter1.equals(letterList.get(i))) {
                        phonetic1 = phoneticList.get(i);
                        morse1 = morseList.get(i);
                    }
                    if (letter2.equals(letterList.get(i))) {
                        phonetic2 = phoneticList.get(i);
                        morse2 = morseList.get(i);
                    }
                    if (letter3.equals(letterList.get(i))) {
                        phonetic3 = phoneticList.get(i);
                        morse3 = morseList.get(i);
                    }
                    if (letter4.equals(letterList.get(i))) {
                        phonetic4 = phoneticList.get(i);
                        morse4 = morseList.get(i);
                    }
                    if (letter5.equals(letterList.get(i))) {
                        phonetic5 = phoneticList.get(i);
                        morse5 = morseList.get(i);
                    }
                    if (letter6.equals(letterList.get(i))) {
                        phonetic6 = phoneticList.get(i);
                        morse6 = morseList.get(i);
                    }
                }
                errorMessage.setText("");
                yourCallSignValue.setText(inputStr);
                yourPhoneticCodeValue.setText(new StringBuilder()
                        .append(phonetic1).append(" ")
                        .append(phonetic2).append(" ")
                        .append(phonetic3).append(" ")
                        .append(phonetic4).append(" ")
                        .append(phonetic5).append(" ")
                        .append(phonetic6).toString());
                yourMorseCodeValue.setText(new StringBuilder()
                        .append(morse1).append(" ")
                        .append(morse2).append(" ")
                        .append(morse3).append(" ")
                        .append(morse4).append(" ")
                        .append(morse5).append(" ")
                        .append(morse6).toString());
            } else {//if(!"^[A-Z0-9]+$")
                errorMessage.setText(R.string.errorCharacterCheck);
                yourCallSignValue.setText("");
                yourPhoneticCodeValue.setText("");
                yourPhoneticCodeValue.setText("");
                yourMorseCodeValue.setText("");
            }//if(!"^[A-Z0-9]+$")
        }//if(inputStr.length() < 6)
    }
}
