package com.example.unitec.quanlynhanvien;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.system.ErrnoException;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.unitec.quanlynhanvien.DAO.PhongBanDAO;
import com.example.unitec.quanlynhanvien.DTO.PhongBanDTO;

import java.io.EOFException;
import java.io.IOException;

public class PhongBanActivity extends AppCompatActivity {
    ListView listPhongBan;
    LinearLayout linearLayout;
    EditText txtThemPhongBan;
    Button btnThemPhongBan;
    PhongBanDAO dbPhongBan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phong_ban);
        listPhongBan = (ListView) findViewById(R.id.listPhongBan);
        linearLayout = (LinearLayout)findViewById(R.id.layout_phongban) ;


        registerForContextMenu(listPhongBan);
        registerForContextMenu(linearLayout);

        dbPhongBan = new PhongBanDAO(this);
    }
    /**
     * Menu click vào list view danh sach phong ban de chinh sua danh sach phòng ban
     *
     * */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_chucnang,menu);
        menu.setHeaderTitle("TÙY CHỌN");
        menu.setHeaderIcon(R.drawable.system);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.menuXoaPhongBan:
                break;
            case R.id.menuThemPhongBan:
                Dialog dialog = new Dialog(this);
                dialog.setTitle("THÊM PHÒNG BAN");
                dialog.setContentView(R.layout.layout_dangki);
                dialog.setCanceledOnTouchOutside(false);
                dialog.setContentView(R.layout.themphongban_layout);
                txtThemPhongBan = (EditText)dialog.findViewById(R.id.textPersonnal);
                btnThemPhongBan =(Button)dialog.findViewById(R.id.btnThemPhongBan);
                dialog.show();

                btnThemPhongBan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        PhongBanDTO phongBanDTO = new PhongBanDTO();
                        phongBanDTO.setTenPhongBan(txtThemPhongBan.getText().toString());
                        Log.d("du lieu ------------",phongBanDTO.getTenPhongBan());

                        dbPhongBan.themPhongBan(phongBanDTO);

                        Toast.makeText(getApplicationContext(),"SUCCESS",Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case R.id.menuSuaPhongBan:
                break;
        }
        return super.onContextItemSelected(item);
    }


    /**
     * Menu lua chon chế độ xem
     * */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuphongban,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.menuHeThong:
               
                break;
            case R.id.menuPhongBan:
               
                break;
            case R.id.menuLienLac:
                
                break;
            case R.id.menuNhanVien:
               
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
