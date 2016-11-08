package intent.demo.sde.sdu.edu.intentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private Button button=null;
    private EditText editText=null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button) findViewById(R.id.mybut);
        editText=(EditText) findViewById(R.id.et);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                //显式启动
//				Intent intent=new Intent(MainActivity.this,SecondActivity.class);
//				startActivity(intent);
                //显式启动
//				Intent newIntent=new Intent();
//				newIntent.setClass(MainActivity.this,SecondActivity.class);
//				startActivity(newIntent);

                //隐式启动，与AndroidManifest.xml文件里的action对应
//				Intent intent=new Intent();
//				intent.setAction("cn.demo.intent.xxx");
//				startActivity(intent);

                //隐式启动Android内置浏览器
//				Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("tel:15966068715"));
//				startActivity(intent);

                //回传数据
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivityForResult(intent, 1);

            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==1){
            String dt=data.getStringExtra("intent-extra");
            editText.setText(dt);
        }
    }

}
