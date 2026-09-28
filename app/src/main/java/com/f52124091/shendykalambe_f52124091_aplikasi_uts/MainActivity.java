package com.f52124091.shendykalambe_f52124091_aplikasi_uts;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listViewPigs;
    private EditText etSearch;
    private PigAdapter pigAdapter;
    private List<PigBreed> pigList;

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

        listViewPigs = findViewById(R.id.list_view_pigs);
        etSearch = findViewById(R.id.et_search);

        loadPigData();

        pigAdapter = new PigAdapter(this, pigList);
        listViewPigs.setAdapter(pigAdapter);

        listViewPigs.setOnItemClickListener((parent, view, position, id) -> {
            PigBreed selectedPig = (PigBreed) pigAdapter.getItem(position);
            Toast.makeText(MainActivity.this, "Dipilih: " + selectedPig.getName(), Toast.LENGTH_SHORT).show();
        });

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                pigAdapter.filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void loadPigData() {
        pigList = new ArrayList<>();
        pigList.add(new PigBreed(
            "Landrace",
            "Denmark",
            "Tubuh sangat panjang, warna putih bersih, telinga terkulai ke depan menutupi mata.",
            "Penghasil Daging (Bacon)",
            R.drawable.landrace
        ));
        pigList.add(new PigBreed(
            "Duroc",
            "Amerika Serikat",
            "Warna merah keemasan hingga merah gelap, telinga terkulai sedang, tubuh berotot.",
            "Penghasil Daging (Meat Type)",
            R.drawable.duroc
        ));
        pigList.add(new PigBreed(
            "Yorkshire (Large White)",
            "Inggris",
            "Warna putih seluruhnya, wajah sedikit cekung, telinga tegak, tubuh besar dan panjang.",
            "Babi Induk & Daging",
            R.drawable.yorkshire
        ));
        pigList.add(new PigBreed(
            "Berkshire",
            "Inggris",
            "Warna hitam dengan bercak putih di kaki, wajah, dan ujung ekor; telinga tegak.",
            "Penghasil Daging Berkualitas Tinggi",
            R.drawable.berkshire
        ));
        pigList.add(new PigBreed(
            "Hampshire",
            "Amerika Serikat",
            "Warna hitam dengan sabuk putih melingkari bahu dan kaki depan, telinga tegak.",
            "Penghasil Daging Tanpa Lemak",
            R.drawable.hampshire
        ));
        pigList.add(new PigBreed(
            "Pietrain",
            "Belgia",
            "Warna putih dengan bercak hitam tidak beraturan, berotot sangat padat dan punggung lebar.",
            "Penghasil Daging Punggung",
            R.drawable.pietrain
        ));
    }
}
