package lab.nhut.appbai10;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import lab.nhut.appbai10.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_chucnang);
        Button bt_chucnang_dangnhap = findViewById(R.id.button_chucnang_dangnhap);
        Button bt_chucnang_dkmh = findViewById(R.id.button_chucnang_dkmh);
        //sự kiện nút chức năng đăng nhập
        bt_chucnang_dangnhap.setOnClickListener(new View.OnClickListener() {
            //đi tới trang đăng nhập
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, DangNhapClass.class);
                startActivity(it);
            }
        });

        //sự kiện nút chức năng đăng ký môn học
        bt_chucnang_dkmh.setOnClickListener(new View.OnClickListener() {
            //đi tới trang đăng ký môn học
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, DKMHClass.class);
                startActivity(it);
            }
        });

    }


}