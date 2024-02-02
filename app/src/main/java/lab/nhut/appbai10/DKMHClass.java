package lab.nhut.appbai10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DKMHClass extends Activity {

    //khai báo biến
    private String tenkhoa, lophoc, mssv, hoten, monhoc, thu;
    private TextView tvmssv, tvkhoa, tvhoten, tvlop;
    private EditText ms, hten, lop;
    private Spinner spinkhoa, spinmonhoc, spinthu;
    private Button btcapnhat, btback;
    private ListView lv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_dangkymonhoc);
        //kết nối dữ liệu vào control spinner
        spinkhoa = (Spinner) findViewById(R.id.spinner_dkmh_khoa);
        spinmonhoc =(Spinner) findViewById(R.id.spinner_dkmh_chonmon);
        spinthu =(Spinner) findViewById(R.id.spinner_dkmh_chonthu);

        //tạo mảng đọc file xml
        ArrayAdapter<CharSequence> adapterkhoa = ArrayAdapter.createFromResource(this, R.array.khoa, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterqtkd = ArrayAdapter.createFromResource(this, R.array.QTKD, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterdulich = ArrayAdapter.createFromResource(this, R.array.Dulich, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adaptercokhi = ArrayAdapter.createFromResource(this, R.array.Cokhi, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adaptercntt = ArrayAdapter.createFromResource(this, R.array.CNTT, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterketoan = ArrayAdapter.createFromResource(this, R.array.Ketoan, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adaptercoban = ArrayAdapter.createFromResource(this, R.array.Coban, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adaptertcnn = ArrayAdapter.createFromResource(this, R.array.TCNN, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterngoaingu = ArrayAdapter.createFromResource(this, R.array.Ngoaingu, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterthu = ArrayAdapter.createFromResource(this, R.array.thu, android.R.layout.simple_spinner_item);

        //chọn dạng hiển thị spinner
        adapterkhoa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterqtkd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterdulich.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adaptercokhi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adaptercntt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterketoan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adaptercoban.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adaptertcnn.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterngoaingu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterthu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //đỗ dữ liệu vào spinner khoa
        spinkhoa.setAdapter(adapterkhoa);
        tenkhoa = "";

        spinkhoa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tenkhoa = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplication(), "Bạn đã chọn: "+tenkhoa, Toast.LENGTH_SHORT).show();

                //đỗ dữ liệu vào spinner môn học
                if (tenkhoa.equals("khoa QTKD"))                        spinmonhoc.setAdapter(adapterqtkd);
                else if (tenkhoa.equals("khoa Du Lịch"))                spinmonhoc.setAdapter(adapterdulich);
                else if (tenkhoa.equals("khoa Cơ Khí"))                 spinmonhoc.setAdapter(adaptercokhi);
                else if (tenkhoa.equals("khoa CNTT"))                   spinmonhoc.setAdapter(adaptercntt);
                else if (tenkhoa.equals("khoa Kế Toán"))                spinmonhoc.setAdapter(adapterketoan);
                else if (tenkhoa.equals("khoa Cơ Bản"))                 spinmonhoc.setAdapter(adaptercoban);
                else if (tenkhoa.equals("khoa Tài Chính Ngân Hàng"))    spinmonhoc.setAdapter(adaptertcnn);
                else if (tenkhoa.equals("khoa Ngoại Ngữ"))              spinmonhoc.setAdapter(adapterngoaingu);

                monhoc = "";

                spinmonhoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        monhoc = parent.getItemAtPosition(position).toString();
                        Toast.makeText(getApplication(), "Bạn đã chọn môn: "+monhoc, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {


                    }

                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        //đỗ dữ liệu vào spinner thứ
        spinthu.setAdapter(adapterthu);
        thu = "";

        spinthu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                thu = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplication(), "Bạn đã chọn: "+thu, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //lấy dữ liệu list dkmh
        lv =(ListView) findViewById(R.id.lv_dkmh);

        //lấy dữ liệu button
        btcapnhat = findViewById(R.id.button_dkmh_capnhat);
        btback = findViewById(R.id.button_dkmh_trove);

        //sự kiện nút cập nhật
        btcapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //cập nhật MSSV
                ms = findViewById(R.id.edit_dkmh_mssv);
                mssv = ms.getText().toString();
                tvmssv = findViewById(R.id.tv_dkmh_mssv);
                tvmssv.setText("MSSV: "+mssv);

                //cập nhật Khoa
                tvkhoa = findViewById(R.id.tv_dkmh_khoa);
                tvkhoa.setText(""+tenkhoa);

                //cập nhật họ tên
                hten = findViewById(R.id.edit_dkmh_hoten);
                hoten = hten.getText().toString();
                tvhoten = findViewById(R.id.tv_dkmh_hoten);
                tvhoten.setText("Họ tên: "+hoten);

                //cập nhật lớp
                lop = findViewById(R.id.edit_dkmh_nhaplop);
                lophoc = lop.getText().toString();
                tvlop = findViewById(R.id.tv_dkmh_lop);
                tvlop.setText("Lớp: "+lophoc);

                //cập nhật list dkmh
                List<String> lists = new ArrayList<>();
                lists.add(monhoc+" - "+thu);// thêm dữ liệu vào danh sách
                ArrayAdapter danhsach = new ArrayAdapter(DKMHClass.this, android.R.layout.simple_list_item_1, lists);
                lv.setAdapter(danhsach); //load dữ liệu lên list view
            }
        });

        //sự kiện nút trở lại
        btback.setOnClickListener(new View.OnClickListener() {

            //đi tới trang chức năng
            @Override
            public void onClick(View v) {
                Intent it = new Intent(DKMHClass.this, MainActivity.class);
                startActivity(it);
            }
        });

    }
}
