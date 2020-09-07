package info.eniuy.phonetic_code;

import android.content.Intent;
import android.content.res.Resources;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String[] characters = new String[]{"#", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private String[] morseCodes = new String[]{"MORSE CODE", "・－", "－・・・", "－・－・", "－・・",
            "・", "・・－・", "－－・", "・・・・", "・・", "・－－－", "－・－", "・－・・", "－－", "－・",
            "－－－", "・－－・", "－－・－", "・－・", "・・・", "－", "・・－", "・・・－", "・－－",
            "－・・－", "－・－－", "－－・・"};
    private String[] phoneticCodes;// = new String[]{"PHONETIC CODE", "ALFA", "BRAVO", "CHARLIE", "DELTA",
    //"ECHO", "FOXTROT", "GOLF", "HOTEL", "INDIA", "JULIETT", "KILO", "LIMA", "MIKE", "NOVEMBER",
    //"OSCAR", "PAPA", "QUEBEC", "ROMEO", "SIERRA", "TANGO", "UNIFORM", "VICTOR", "WHISKEY",
    //"X―RAY", "YANKEE", "ZULU"};
    private String[] characterNumbers;// = new String[]{"#", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "."};
    private String[] morseCodeNumbers = new String[]{"MORSE CODE", "－－－－－", "・－－－－", "・・－－－",
            "・・・－－", "・・・・－", "・・・・・", "－・・・・", "－－・・・", "－－－・・", "－－－－・", "・－・"};
    private String[] phoneticCodeNumbers;// = new String[]{"PHONETIC CODE", "ZERO", "ONE", "TWO", "THREE",
    //"FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "DECIMAL"};
    private String[] characterKatakanas = new String[]{"#", "イ", "ロ", "ハ", "ニ", "ホ", "ヘ", "ト", "チ", "リ", "ヌ",
            "ル", "ヲ", "ワ", "カ", "ヨ", "タ", "レ", "ソ", "ツ", "ネ", "ナ", "ラ", "ム", "ウ", "ヰ", "ノ", "オ", "ク", "ヤ",
            "マ", "ケ", "フ", "コ", "エ", "テ", "ア", "サ", "キ", "ユ", "メ", "ミ", "シ", "ヱ", "ヒ", "モ", "セ", "ス", "ン",
            "、、", "○", "〇", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
    private String[] morseCodeKatakanas = new String[]{"MORSE CODE", "・－", "・－・－", "－・・・", "－・－・", "－・・",
            "・", "・・－・・", "・・－・", "－－・", "・・・・", "－・－－・", "・－－－", "－・－", "・－・・",
            "－－", "－・", "－－－", "－－－・", "・－－・", "－－・－", "・－・", "・・・", "－", "・・－",
            "・－・・－", "・・－－", "・－・・・", "・・・－", "・－－", "－・・－", "－・－－", "－－・・",
            "－－－－", "－・－－－", "・－・－－", "－－・－－", "－・－・－", "－・－・・", "－・・－－",
            "－・・・－", "・・－・－", "－－・－・", "・－－・・", "－－・・－", "－・・－・", "・－－－・",
            "－－－・－", "・－・－・", "・・", "・・－－・", "－－－－－", "・－－－－", "・・－－－",
            "・・・－－", "・・・・－", "・・・・・", "－・・・・", "－－・・・", "－－－・・", "－－－－・"};
    private String[] phoneticCodeKatakanas; // = new String[]{"いろはのイ", "ローマのロ", "はがきのハ", "日本(につぽん)のニ",//              "保険(ほけん)のホ", "平和(へいわ)のヘ", "東京(とうきよう)のト", "ちどりのチ", "りんごのリ", "沼津(ぬまず)のヌ",
    //"るすいのル", "尾張(をわり)のヲ", "わらびのワ", "為替(かわせ)のカ", "吉野(よしの)のヨ", "煙草(たばこ)のタ",
    //"れんげのレ", "そろばんのソ", "つるかめのツ", "ねずみのネ", "名古屋(なごや)のナ", "ラジオのラ", "無線(むせん)のム",
    //"上野(うえの)のウ", "ゐどのヰ", "野原(のはら)のノ", "大阪(おおさか)のオ", "クラブのク", "大和(やまと)のヤ",
    //"マツチのマ", "景色(けしき)のケ", "富士山(ふじさん)のフ", "子供(こども)のコ", "英語(えいご)のエ", "手紙(てがみ)のテ",
    //"朝日(あさひ)のア", "桜(さくら)のサ", "切手(きつて)のキ", "弓矢(ゆみや)のユ", "明治(めいじ)のメ", "三笠(みかさ)のミ",
    //"新聞(しんぶん)のシ", "かぎのあるヱ", "飛行機(ひこうき)のヒ", "もみじのモ", "世界(せかい)のセ", "すずめのス",
    //"おしまいのン", "だくてん", "はんだくてん"};
    private String[] characterSymbols = new String[]{".", ",", ":", "?", "\'", "-", "/", "(", ")", "\"", "=", "+", "x", "@"};
    private String[] morseCodeSymbols = new String[]{"・－・－・－", "－－・・－－", "－－－・・・", "・・－－・・",
            "・－－－－・", "－・・・・－", "－・・－・", "－・－－・", "－・－－・－", "－・・・－", "・－・－・",
            "・－・・－・", "－・・－", "・－－・－・"};
    private String[] phoneticCodeSymbols = new String[]{"Full stop (period)", "Comma", "Colon or division sign",
            "Question mark", "Apostrophe", "Hyphen or dash or subtraction sign", "Fraction bar or division sign",
            "Left-hand bracket", "Right-hand bracket", "Inverted commas (quotation marks)", "Double hyphen",
            "Cross or addition sign", "Multiplication sign", "Commercial at or at sign"};
    private Resources resources;
    private TextView phoneticCodeLabel;
    private TextView phoneticCodeNumbersLabel;
    private TextView phoneticCodeKatakanaLabel;
    private TextView phoneticCodeSymbolsLabel;
    private TextView convertCallSignLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setResources();
        openPhoneticCodeList();//click phonetic code label then open phonetic code list
        openPhoneticCodeListNumber();//click phonetic code number label then open number phonetic code list
        openPhoneticCodeListKatakana();//click phonetic code katakana label then open katakana phonetic code list
        openPhoneticCodeListSymbol();//click phonetic code symbol label then open symbol phonetic code list
        openConvertCallSign();//click convert call sign label then open convert call sign activity

    }

    private void openPhoneticCodeList() {
        setPhoneticCodeLabel();
        phoneticCodes = resources.getStringArray(R.array.phoneticCodes_array);//"ALFA", "BRAVO", "CHARLIE"
        //set click listener
        phoneticCodeLabel.setOnClickListener(view -> {//phonetic code label on click then
            /*//close this activity
              finish();*/

            //create intent main to phonetic code list activity
            Intent movePhoneticCodeList =
                    new Intent(MainActivity.this, PhoneticCodeListActivity.class);
            movePhoneticCodeList.putExtra("character", characters);
            movePhoneticCodeList.putExtra("morseCode", morseCodes);
            movePhoneticCodeList.putExtra("phoneticCode", phoneticCodes);
            startActivity(movePhoneticCodeList);//start phonetic code list activity
        });//setOnClickListener
    }//openPhoneticCodeList ()

    private void openPhoneticCodeListNumber() {
        setPhoneticCodeNumbersLabel();
        characterNumbers = resources.getStringArray(R.array.characterNumbers_array);//0,1,2,...
        phoneticCodeNumbers = resources.getStringArray(R.array.phoneticCodeNumbers_array);//zero,one,two...
        //set click listener
        phoneticCodeNumbersLabel.setOnClickListener(view -> {//phonetic code label on click then
            /*//close this activity
              finish();*/

            //create intent main to phonetic code list activity
            Intent movePhoneticCodeList =
                    new Intent(MainActivity.this, PhoneticCodeListActivity.class);
            movePhoneticCodeList.putExtra("character", characterNumbers);
            movePhoneticCodeList.putExtra("morseCode", morseCodeNumbers);
            movePhoneticCodeList.putExtra("phoneticCode", phoneticCodeNumbers);
            startActivity(movePhoneticCodeList);//start phonetic code list activity
        });//setOnClickListener
    }//openPhoneticCodeListNumber ()

    private void openPhoneticCodeListKatakana() {
        setPhoneticCodeKatakanaLabel();
        phoneticCodeKatakanas = resources.getStringArray(R.array.phoneticCodeKatakanas_array);//いろはのイ,ローマのロ
        //set click listener
        phoneticCodeKatakanaLabel.setOnClickListener(view -> {//phonetic code label on click then
            /*//close this activity
              finish();*/

            //create intent main to phonetic code list activity
            Intent movePhoneticCodeList =
                    new Intent(MainActivity.this, PhoneticCodeListActivity.class);
            movePhoneticCodeList.putExtra("character", characterKatakanas);
            movePhoneticCodeList.putExtra("morseCode", morseCodeKatakanas);
            movePhoneticCodeList.putExtra("phoneticCode", phoneticCodeKatakanas);
            startActivity(movePhoneticCodeList);//start phonetic code list activity
        });//setOnClickListener
    }//openPhoneticCodeListKatakana ()

    private void openPhoneticCodeListSymbol() {
        setPhoneticCodeSymbolsLabel();
        //set click listener
        phoneticCodeSymbolsLabel.setOnClickListener(view -> {//phonetic code label on click then
            /*//close this activity
              finish();*/

            //create intent main to phonetic code list activity
            Intent movePhoneticCodeList =
                    new Intent(MainActivity.this, PhoneticCodeListActivity.class);
            movePhoneticCodeList.putExtra("character", characterSymbols);
            movePhoneticCodeList.putExtra("morseCode", morseCodeSymbols);
            movePhoneticCodeList.putExtra("phoneticCode", phoneticCodeSymbols);
            startActivity(movePhoneticCodeList);//start phonetic code list activity
        });//setOnClickListener
    }//openPhoneticCodeListSymbol ()

    private void openConvertCallSign() {
        setConvertCallSignLabel();
        //set click listener
        convertCallSignLabel.setOnClickListener(view -> {//phonetic code label on click then
            /*//close this activity
              finish();*/

            //create intent main to convert call sign activity
            Intent moveConvertCallSign =
                    new Intent(MainActivity.this, ConvertCallSignActivity.class);
            moveConvertCallSign.putExtra("character", characters);
            moveConvertCallSign.putExtra("morseCode", morseCodes);
            moveConvertCallSign.putExtra("morseCodeNumber", morseCodeNumbers);
            startActivity(moveConvertCallSign);//start convert call sign activity
        });//setOnClickListener
    }//openConvertCallSign ()

    private void setPhoneticCodeLabel() {
        phoneticCodeLabel = findViewById(R.id.phoneticCodeLabel);
    }

    private void setPhoneticCodeNumbersLabel() {
        phoneticCodeNumbersLabel = findViewById(R.id.phoneticCodeNumbersLabel);
    }

    private void setPhoneticCodeKatakanaLabel() {
        phoneticCodeKatakanaLabel = findViewById(R.id.phoneticCodeKatakanaLabel);
    }

    private void setPhoneticCodeSymbolsLabel() {
        phoneticCodeSymbolsLabel = findViewById(R.id.phoneticCodeSymbolsLabel);
    }

    private void setConvertCallSignLabel() {
        convertCallSignLabel = findViewById(R.id.convertCallSignLabel);
    }

    private void setResources(){
        resources = getResources();//resources files
    }
}
