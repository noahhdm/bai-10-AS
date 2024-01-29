package lab.nhut.appbai10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class DangNhapClass extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_dangnhap);

        //khai báo
        Button btback = findViewById(R.id.button_dangnhap_trolai);

        //sự kiện nút trở lại
        btback.setOnClickListener(new View.OnClickListener() {

            //đi tới trang chức năng
            @Override
            public void onClick(View v) {
                Intent it = new Intent(DangNhapClass.this, MainActivity.class);
                startActivity(it);

            }
        });
    }
}
