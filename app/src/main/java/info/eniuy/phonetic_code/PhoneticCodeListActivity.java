package info.eniuy.phonetic_code;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneticCodeListActivity extends AppCompatActivity {
    private ListView phoneticCodeList; //list view
    private String[] character;
    private String[] morseCode;
    private String[] phoneticCode;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonetic_code_list);
        intent = getIntent();//intent from MainActivity.java
        character = intent.getStringArrayExtra("character");//set character
        morseCode = intent.getStringArrayExtra("morseCode");//set morse code
        phoneticCode = intent.getStringArrayExtra("phoneticCode");//set phonetic code
        phoneticCodeList = (ListView) findViewById(R.id.phoneticCodeList);//phonetic code list

        List<Map<String, String>> phoneticCodesList = new ArrayList<>();//crate include map list
        Map<String, String> listData;//create map [character,morseCode,phoneticCode]

        for (int i = 0; i < character.length; i++) {//set listData
            listData = new HashMap<String, String>();
            listData.put("character", character[i]);//String[] character
            listData.put("phoneticCode", phoneticCode[i]);//String[] phoneticCode
            listData.put("morseCode", morseCode[i]);//String[] morseCode
            phoneticCodesList.add(listData);//set phonetic code list
        }

        //create simple adapter [context,list,list row layout,list map key,list row id]
        SimpleAdapter simp = new SimpleAdapter(
                PhoneticCodeListActivity.this,
                phoneticCodesList,
                R.layout.phonetic_code_list_row,
                new String[]{"character", "phoneticCode", "morseCode"},
                new int[]{R.id.character, R.id.phonetic, R.id.morse});

        phoneticCodeList.setAdapter(simp);//set simple adapter to list view

    }//protected void onCreate
}
