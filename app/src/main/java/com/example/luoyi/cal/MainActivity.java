package com.example.luoyi.cal;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private boolean opEnd = false;//说明输入的是数字还是运算符
    public static final int PLUS = 0;//在等于操作中，判断执行什么操作
    public static final int MINUS = 1;
    public static final int MULTIPLY = 2;
    public static final int DIVIDE = 3;
    public int current0p = 0;    //用于接收以上四个整型常量
    public static double result1=0,result2=0;
    static Boolean flag1=true;  //用于标志输入负数时与减号的区别
    static Boolean flag2=false;  //用于累加
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button zero=(Button)findViewById(R.id.button18);  //程序中各个控件
        Button one=(Button)findViewById(R.id.button13);
        Button tow=(Button)findViewById(R.id.button14);
        Button three=(Button)findViewById(R.id.button15);
        Button four=(Button)findViewById(R.id.button9);
        Button five=(Button)findViewById(R.id.button10);
        Button six=(Button)findViewById(R.id.button11);
        Button seven=(Button)findViewById(R.id.button5);
        Button eight=(Button)findViewById(R.id.button6);
        Button nine=(Button)findViewById(R.id.button7);
        Button cBtton=(Button)findViewById(R.id.button2);
        Button equal=(Button)findViewById(R.id.button20);
        Button plus=(Button)findViewById(R.id.button16);
        Button minus=(Button)findViewById(R.id.button12);
        Button multiply=(Button)findViewById(R.id.button8);
        Button divide=(Button)findViewById(R.id.button4);
        Button point=(Button)findViewById(R.id.button19);
        Button backButton=(Button)findViewById(R.id.button3);
        Button finish=(Button)findViewById(R.id.button1);
        Button binary=(Button)findViewById(R.id.button17);
        final TextView textView=(TextView)findViewById(R.id.textView1);   //显示控件

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {    //按键“0”的事件监听以及事件处理方法
            @Override
            public void onClick(View v) {
                if(opEnd==false)
                {
                    textView.setText("");
                }
                textView.setText(textView.getText() + "0");
                opEnd = true;
                if(textView.getText().toString().length()>=2) {
                    if (textView.getText().toString().charAt(0) == '0' && textView.getText().toString().charAt(1) == '0') {
                        textView.setText("");
                        Toast.makeText(MainActivity.this, "请不要重复输入“0”！", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(opEnd==false)
                {
                    textView.setText("");
                }
                textView.setText(textView.getText()+"1");
                opEnd = true;
            }
        });

        tow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(opEnd==false)
                {
                    textView.setText("");
                }
                textView.setText(textView.getText()+"2");
                opEnd = true;
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(opEnd==false)
                {
                    textView.setText("");
                }
                textView.setText(textView.getText()+"3");
                opEnd = true;
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(opEnd==false)
                {
                    textView.setText("");
                }
                textView.setText(textView.getText()+"4");
                opEnd = true;
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(opEnd==false)
                {
                    textView.setText("");
                }
                textView.setText(textView.getText()+"5");
                opEnd = true;
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(opEnd==false)
                {
                    textView.setText("");
                }
                textView.setText(textView.getText()+"6");
                opEnd = true;
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(opEnd==false)
                {
                    textView.setText("");
                }
                textView.setText(textView.getText()+"7");
                opEnd = true;
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(opEnd==false)
                {
                    textView.setText("");
                }
                textView.setText(textView.getText()+"8");
                opEnd = true;
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(opEnd==false)
                {
                    textView.setText("");
                }
                textView.setText(textView.getText()+"9");
                opEnd = true;

            }
        });

        cBtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
                opEnd=false;
                flag2=false;   //在累加过程中用户清零，则会把result1清零，因为result1是静态变量
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView.getText().toString()==""||textView.getText().toString()=="-")
                {
                    Toast.makeText(MainActivity.this,"请输入数字！",Toast.LENGTH_SHORT).show();
                }
                else {
                    if(flag2==true)  //累加开始
                    {
                        result2=Double.parseDouble(textView.getText().toString());
                        result1=result1+result2;
                        opEnd = false;
                        current0p = PLUS;
                    }
                    else {
                        result1 = Double.parseDouble(textView.getText().toString());
                        opEnd = false;
                        current0p = PLUS;
                        flag2 = true;
                    }
                }
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView.getText().toString()=="")
                {
                    textView.setText("-");
                    opEnd=true;
                    flag1=false;
                    current0p=MINUS;
                }
               else
                {
                    if(textView.getText().toString()=="-")
                    {
                        Toast.makeText(MainActivity.this,"请不要重复输入“-”！",Toast.LENGTH_SHORT).show();
                    }else {
                        flag1 = true;
                        result1 = Double.parseDouble(textView.getText().toString());
                        opEnd = false;
                        current0p = MINUS;
                    }
                }
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView.getText().toString()==""||textView.getText().toString()=="-")
                {
                    Toast.makeText(MainActivity.this,"请输入数字！",Toast.LENGTH_SHORT).show();
                }
                else {
                    result1 = Double.parseDouble(textView.getText().toString());
                    opEnd = false;
                    current0p = MULTIPLY;
                }
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView.getText().toString()==""||textView.getText().toString()=="-")
                {
                    Toast.makeText(MainActivity.this,"请输入数字！",Toast.LENGTH_SHORT).show();
                }
                else {
                    result1 = Double.parseDouble(textView.getText().toString());
                    opEnd = false;
                    current0p = DIVIDE;
                }
            }
        });

        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {  //小数点
                if(textView.getText().toString()==""||textView.getText().toString()=="-")
                {
                    Toast.makeText(MainActivity.this,"请输入数字！",Toast.LENGTH_SHORT).show();
                }
                else {
                    String tmp = textView.getText().toString();
                    if (tmp.equals("")) {
                        return;
                    }
                    if (tmp.indexOf(".") != -1) {
                        return;
                    }
                    tmp = tmp + ".";
                    textView.setText(tmp);
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {    //数字清除一位
                String s = textView.getText().toString();
                textView.setText("");// 重置参数
                for (int i = 0; i < s.length() - 1; i++)
                {
                    char a = s.charAt(i);
                    textView.setText(textView.getText().toString() + a);
                }

            }
        });

        binary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {    //二进制转换事件
                if(textView.getText().toString()==""||textView.getText().toString()=="-")  //判断是否输入数字
                {
                    Toast.makeText(MainActivity.this,"请输入数字！",Toast.LENGTH_SHORT).show();
                }
                else {
                    String s = textView.getText().toString();
                    if(s.charAt(0)=='-')
                    {
                        Toast.makeText(MainActivity.this,"Sorry！负数暂时不支持进制转换！",Toast.LENGTH_SHORT).show(); //进制转换限制
                    }
                    else {
                        for (int i = 0; i < s.length(); i++)   //查看文本框中是否输入小数
                        {
                            char a = s.charAt(i);
                            if (a == '.') {
                                textView.setText("");
                                Toast.makeText(MainActivity.this, "Sorry！小数暂时不支持进制转换！", Toast.LENGTH_SHORT).show(); //进制转换限制
                                opEnd = false;
                                return;
                            }
                        }
                        double o = Double.parseDouble(s);
                        textView.setText(Integer.toBinaryString((int) o));
                        opEnd = false;
                    }
                }
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   //按键“=”的事件处理机制
                if(textView.getText().toString()==""||textView.getText().toString()=="-")
                {
                    Toast.makeText(MainActivity.this,"请输入数字！",Toast.LENGTH_SHORT).show();
                }
                else if(textView.getText().toString().charAt(textView.getText().toString().length()-1)=='.')//测试最后一位是否是小数点（输入错误）
                {
                    Toast.makeText(MainActivity.this,"格式错误！",Toast.LENGTH_SHORT).show();
                }
                else {
                    double a;
                    int b;
                    DecimalFormat df = new DecimalFormat("###.000"); //精确小数点后3位
                    if (opEnd = true) {
                        result2 = Double.parseDouble(textView.getText().toString()); //被加数
                        switch (current0p) {
                            case PLUS:     //加法
                                a = result1 + result2;
                                b = (int) a;
                                if (a == b) {   //判断结果是否为整数
                                    textView.setText(b + "");
                                } else {
                                    if(a>0&&a<1)
                                    {
                                        textView.setText("0"+df.format(a));
                                    }
                                    else {
                                        textView.setText(df.format(a));
                                    }
                                }
                                current0p=6;  //用于当重复按“=”时跳转到6，使其数字不变
                                flag2=false;
                                break;
                            case MINUS:   //减法
                                if (flag1 == false) {
                                    a = Double.parseDouble(textView.getText().toString());//转换此时textView上的负数
                                    textView.setText(a + "");
                                } else {
                                    a = result1 - result2;
                                    b = (int) a;
                                    if (a == b) {
                                        textView.setText(b + "");
                                    } else {
                                        if(a>0&&a<1)
                                        {
                                            textView.setText("0"+df.format(a));
                                        }
                                        else {
                                            textView.setText(df.format(a));
                                        }
                                    }
                                }
                                current0p=6;  //用于当重复按“=”时跳转到6，使其数字不变
                                break;
                            case MULTIPLY:  //乘法
                                a = result1 * result2;
                                b = (int) a;
                                if (a == b) {
                                    textView.setText(b + "");
                                } else {
                                    if(a>0&&a<1)
                                    {
                                        textView.setText("0"+df.format(a));
                                    }
                                    else {
                                        textView.setText(df.format(a));
                                    }
                                }
                                current0p=6;  //用于当重复按“=”时跳转到6，使其数字不变
                                break;
                            case DIVIDE:   //除法
                                if (result2 == 0) {
                                    textView.setText("被除数不能为零");
                                    break;
                                }
                                a = result1 / result2;
                                b = (int) a;
                                if (a == b) {
                                    textView.setText(b + "");
                                } else {
                                    if(a>0&&a<1)
                                    {
                                        textView.setText("0"+df.format(a));
                                    }
                                    else {
                                        textView.setText(df.format(a));
                                    }
                                }
                                current0p=6;  //用于当重复按“=”时跳转到6，使其数字不变
                                break;
                            case 6:
                                textView.setText(textView.getText());
                                break;
                        }
                    }
                    opEnd = false;
                }
            }

        });
    }
}
