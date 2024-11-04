package app.savefile.demoand102;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import app.savefile.demoand102.DAO.CatDAO;
import app.savefile.demoand102.DTO.CatDTO;

public class MainActivity extends AppCompatActivity {
    //1. Khai báo các đối tượng
    CatDAO catDAO;
    String TAG ="zzzzzzzzz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //2.
        catDAO = new CatDAO(this);
//hghghgh
        CatDTO objCat = new CatDTO();
        objCat.setName("Dien thoai");
        // ghi vao CSDL
        int kq = catDAO.AddRow( objCat );
        if(kq == -1){
            Log.d(TAG, "onCreate: Loi khong them duoc");
        }else{
            Log.d(TAG, "onCreate: Them thanh cong id = " + kq);
        }
        // chay ung dung vaf xem log ket qua
        ///--- lay danh sachr
        ArrayList<CatDTO> listCat = catDAO.getList();
        // dung vong lap for de xem ket qua
        for(int i =0; i< listCat.size(); i++){
            CatDTO tmp = listCat.get(i);
            Log.d(TAG, "onCreate: phan tu thu "+ i + " la: " + tmp.toString());
        }

    }
}