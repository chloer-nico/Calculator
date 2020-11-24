package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Path;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.out;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonClear, buttonDel, btnSwitch,
            btnSquare, buttonDivide, buttonMultiply,
            buttonSub, buttonAdd, buttonEqual, buttonPoint,buttonLeftP,buttonRightP;
    EditText text;
    int clear = 0;
    //用来检测括号是否匹配
    int leftP=0;
    int rightP=0;
    //存储操作数
    Stack<Double> NumStack;
    //存储运算符
    Stack<Character> OpStack;
    //用来检测的字符串
    String testString="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(this);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(this);

        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(this);

        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(this);

        button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(this);

        button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(this);

        buttonClear = (Button) findViewById(R.id.btnClear);
        buttonClear.setOnClickListener(this);

        buttonDel = (Button) findViewById(R.id.btnDel);
        buttonDel.setOnClickListener(this);

        btnSwitch = (Button) findViewById(R.id.btnSwitch);
        btnSwitch.setOnClickListener(this);

        btnSquare = (Button) findViewById(R.id.btnSquare);
        btnSquare.setOnClickListener(this);


        buttonDivide = (Button) findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(this);

        buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener(this);

        buttonSub = (Button) findViewById(R.id.buttonSub);
        buttonSub.setOnClickListener(this);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(this);

        buttonEqual = (Button) findViewById(R.id.buttonEqual);
        buttonEqual.setOnClickListener(this);

        buttonPoint = (Button) findViewById(R.id.buttonPoint);
        buttonPoint.setOnClickListener(this);

        buttonLeftP = (Button) findViewById(R.id.btnLeftP);
        buttonLeftP.setOnClickListener(this);

        buttonRightP = (Button) findViewById(R.id.btnRightP);
        buttonRightP.setOnClickListener(this);

        text = (EditText) findViewById(R.id.text);
    }

    @Override
    public void onClick(View v) {
        String str = text.getText().toString();

        switch (v.getId()){
            case R.id.button0:
                //初始为0
                if (str.equals("0")) {
                    str = "0";
                } else {
                    str += "0";
                }
                text.setText(str);
                break;
            case R.id.button1:
                if (str.equals("0")) {
                    str = "1";
                } else {
                    str += "1";
                }
                text.setText(str);
                break;
            case R.id.button2:
                if (str.equals("0")) {
                    str = "2";
                } else {
                    str += "2";
                }
                text.setText(str);
                break;
            case R.id.button3:
                if (str.equals("0")) {
                    str = "3";
                } else {
                    str += "3";
                }
                text.setText(str);
                break;
            case R.id.button4:
                if (str.equals("0")) {
                    str = "4";
                } else {
                    str += "4";
                }
                text.setText(str);
                break;
            case R.id.button5:
                if (str.equals("0")) {
                    str = "5";
                } else {
                    str += "5";
                }
                text.setText(str);
                break;
            case R.id.button6:
                if (str.equals("0")) {
                    str = "6";
                } else {
                    str += "6";
                }
                text.setText(str);
                break;
            case R.id.button7:
                if (str.equals("0")) {
                    str = "7";
                } else {
                    str += "7";
                }
                text.setText(str);
                break;
            case R.id.button8:
                if (str.equals("0")) {
                    str = "8";
                } else {
                    str += "8";
                }
                text.setText(str);
                break;
            case R.id.button9:
                if (str.equals("0")) {
                    str = "9";
                } else {
                    str += "9";
                }
                text.setText(str);
                break;
            case R.id.btnDel:
                if (str.length() > 1) {
                    //字符串切割不包括结尾
                    str = str.substring(0, str.length() - 1);
                } else {
                    str = "0";
                }
                text.setText(str);
                break;
            case R.id.btnClear:
                str = "0";
                text.setText(str);
                leftP=0;
                rightP=0;
                break;
            case R.id.buttonPoint:
                //判断小数点前面是否为数字，不是数字报错
                testString="";
                testString+=str.charAt(str.length()-1);
                if(!isInt(testString)){
                    Toast.makeText(MainActivity.this, "小数点前面不为数字", Toast.LENGTH_SHORT).show();
                }
                else {
                    str += ".";
                }
                text.setText(str);
                break;
            case R.id.buttonAdd:
                testString="";
                testString+=str.charAt(str.length()-1);
                if(!isInt(testString) && str.charAt(str.length()-1)!=')'){
                    Toast.makeText(MainActivity.this, "+号前面不为数字或）", Toast.LENGTH_SHORT).show();
                }
                else {
                    str += "+";
                }
                text.setText(str);
                break;
            case R.id.buttonSub:
                testString="";
                testString+=str.charAt(str.length()-1);
                if(!isInt(testString) && str.charAt(str.length()-1)!=')'){
                    Toast.makeText(MainActivity.this, "-号前面不为数字或）", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(str.charAt(0)=='0'){
                        str = "-";
                    }else {
                        str+='-';
                    }
                }
                text.setText(str);
                break;
            case R.id.buttonMultiply:
                testString="";
                testString+=str.charAt(str.length()-1);
                if(!isInt(testString) && str.charAt(str.length()-1)!=')' ){
                    Toast.makeText(MainActivity.this, "×号前面不为数字或）", Toast.LENGTH_SHORT).show();
                }
                else {
                    str += "×";
                }
                text.setText(str);
                break;
            case R.id.buttonDivide:
                testString="";
                testString+=str.charAt(str.length()-1);
                if(!isInt(testString) && str.charAt(str.length()-1)!=')' ){
                    Toast.makeText(MainActivity.this, "÷号前面不为数字或）", Toast.LENGTH_SHORT).show();
                }
                else {
                    str += "÷";
                }
                text.setText(str);
                break;
                //求根
            case R.id.btnSquare:
                //只有正数才能开根号运算，且为纯数字
                if(!isInt(str) && !isDouble(str)){
                    Toast.makeText(MainActivity.this, "只有正数且不能带表达式的数能开根号", Toast.LENGTH_SHORT).show();
                    //清空
                    text.setText("0");
                }
                else{
                    //直接运算显示结果，不放入栈中
                    double x=Double.parseDouble(str);
                    x=Math.sqrt(x);
                    //保留9位小数
                    String square = String.format("%.9f", x);
                    //整数开根有多余0，去掉,至少2个0全部去掉
                    square=square.replaceAll("0{2,}$","");
                    //去掉最后一位的小数点
                    square= square.replaceAll("[.]$", "");
                    text.setText(square);
                }
                break;
                //正负转换,只有纯数字才能正负转换，可以为负值
            case R.id.btnSwitch:
                //开头为负号，转换直接去掉
                if(str.charAt(0)=='-'){
                    //判断中间是否为有符号，有符号不转
                    if(!isNegInt(str) && !isNegDouble(str)){
                        Toast.makeText(MainActivity.this, "必须为整数或小数", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        text.setText(str.substring(1,str.length()));
                    }
                }
                else{
                    if(!isNegInt(str) && !isNegDouble(str)){
                        Toast.makeText(MainActivity.this, "必须为整数或小数", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        //最开头加上-号
                        text.setText("-"+str);
                    }
                }
                break;
                //左括号
            case R.id.btnLeftP:
                //开头可以输（
                if (str.length() == 1) {
                    str = "(";
                    leftP++;
                }
                else{
                    //左括号前面不能是数字,也不是是）,输入失败
                    testString="";
                    testString+=str.charAt(str.length()-1);
                    if(isInt(testString) || str.charAt(str.length()-1)==')'){
                        Toast.makeText(MainActivity.this, "左括号前面不能是数字或者）!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        str += "(";
                        text.setText(str);
                        leftP++;
                    }
                }
                text.setText(str);
                break;
                //右括号
            case R.id.btnRightP:
                rightP++;
                //不能先输右括号
                if(rightP>leftP) {
                    Toast.makeText(MainActivity.this, "不能先输）!", Toast.LENGTH_SHORT).show();
                    text.setText("0");
                    leftP=0;
                    rightP=0;
                    break;
                }
                if (str.length() == 1) {
                    str = "0";
                    Toast.makeText(MainActivity.this, "开头不能是）", Toast.LENGTH_SHORT).show();
                }
                //右括号前面必须是数字
                else if(!Character.isDigit(str.charAt(str.length() - 1))) {
                    Toast.makeText(MainActivity.this, "右括号前面不是数字!", Toast.LENGTH_SHORT).show();
                }
                else {
                    str += ")";
                }
                text.setText(str);
                break;
            case R.id.buttonEqual:
                //判断表达式最后一位必须是数字
                testString="";
                testString+=str.charAt(str.length()-1);
                if(!isInt(testString) && str.charAt(str.length()-1)!=')'){
                    Toast.makeText(MainActivity.this, "表达式最后一位必须是数字或者）！", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(leftP!=rightP){
                        Toast.makeText(MainActivity.this, "括号不匹配！", Toast.LENGTH_SHORT).show();
                        text.setText('0');
                        leftP=0;
                        rightP=0;
                        break;
                    }
                    //开始计算
                    Double result=calculate(str.toString().trim());
                    String strResult=result.toString();
                    //保留五位有效数字
                        String formatResult=String.format("%.5f",result);
                        //至少2个0全部去掉
                        formatResult=formatResult.replaceAll("0{2,}$","");
                        //去掉最后一位的小数点
                        formatResult= formatResult.replaceAll("[.]$", "");
                        text.setText(formatResult);
                }
                clear=1;
                break;
            default:break;
        }
    }
    /**
     *判断是否为整数,必须是正数,即不带任何符号
     **/
    public boolean isInt(String string){
        Pattern pattern1=Pattern.compile("^[0-9]*$");
        Matcher result=pattern1.matcher(string);
        Log.i("isNum", String.valueOf(result.matches()));
        if(result.matches()){
            return true;
        }
        return false;
    }
    /**
     *判断是否为小数，必须是正数，即不带任何符号
     **/
    public boolean isDouble(String string){
        // \\d转义\d，数字出现1次或多次，\\.匹配点
        Pattern pattern1=Pattern.compile("^\\d+\\.\\d+$");
        Matcher result=pattern1.matcher(string);
        Log.i("isNum", String.valueOf(result.matches()));
        if(result.matches()){
            return true;
        }
        return false;
    }
    /**
     *判断是否为整数，可以是负数
     **/
    public boolean isNegInt(String string){
        Pattern pattern1=Pattern.compile("^-?[0-9]*$");
        Matcher result=pattern1.matcher(string);
        Log.i("isNum", String.valueOf(result.matches()));
        if(result.matches()){
            return true;
        }
        return false;
    }
    /**
     *判断是否为小数，可以是负数
     **/
    public boolean isNegDouble(String string){
        // \\d转义\d，数字出现1次或多次，\\.匹配点,开头-表示为负值，？表示可以出现0次或1次
        Pattern pattern1=Pattern.compile("^-?\\d+\\.\\d+$");
        Matcher result=pattern1.matcher(string);
//        Log.i("isNum", String.valueOf(result.matches()));
        if(result.matches()){
            return true;
        }
        return false;
    }
    /**
     * 判断右运算符优先级
     * */
    int rp(char op){
        switch (op){
            case '+':
            case '-':
                return 2;
            case '×':
            case '÷':
                return 4;
            case '(':
                return 6;
            case ')':
                return 1;
            default:
                return 0;
        }
    }
    /**
     * 判断左运算符优先级
     * */
    int lp(char op){
        switch (op){
            case '+':
            case '-':
                return 3;
            case '×':
            case '÷':
                return 5;
            case '(':
                return 1;
            case ')':
                return 6;
            default:
                return 0;
        }
    }
    /**
     * 运算一次小的运算
     * */
    double operate(char theta, double a, double b) {  //根据运算符和数字计算答案
        switch (theta) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '×':
                return a * b;
            case '÷':
                return a / b;
            default:
                return 0;
        }
    }
    /**
     *进行结果计算
     **/
    double calculate(String str){
        //清空栈
        NumStack=new Stack();
        OpStack= new Stack();
        double result=0.0;
        //开头是－号，+一个0
        if(str.charAt(0)=='-'){
            str="0"+str;
        }
        //（96）-0这样的情况，在-前面要插一个0
        StringBuffer sb = new StringBuffer(str);
        for (int i = 0; i < str.length() - 1; ++i) {
            if (!Character.isDigit(str.charAt(i)) && str.charAt(i + 1) == '-') {
                //(89)-3，不能变成(89)0-3
                if(str.charAt(i)!=')'){
                    sb.insert(i + 1, "0");
                }

            }
        }
        char top ='#';
        str=sb.toString()+"=";
        Log.i("运算表达式：",str);
        //以#开始,#碰到=就结束运算，#用来位移判断优先级
        OpStack.push('#');
        double a=0.0,b=0.0;

        //开始处理
        out.println("处理开始");
        for(int i=0;i<str.length();i++){
            out.println("for循环一次");
//            out.println("i="+i+"  str[i]="+str.charAt(i));
            out.println("OpStack= "+OpStack);
            out.println("NumStack= "+NumStack);
            char ch=str.charAt(i);

            if(Character.isDigit(ch)){
                out.println("数字ch="+ch+"下一个为"+str.charAt(i+1));
                //存放一个连续的数字
                double temp=0.0;
                StringBuffer sb1=new StringBuffer();
                sb1.append(ch);


                //连续的数字或者小数点合并一起入栈
                int pointNum=0;
                while(Character.isDigit(str.charAt(i+1)) || str.charAt(i+1)=='.'){
                    out.println("数字连续：当前为"+str.charAt(i)+"下一个为"+str.charAt(i+1));
                    if(str.charAt(i+1)=='.'){
                        pointNum++;
                    }
                    sb1.append(str.charAt(i+1));
                    i++;
                    //连起来
                    if(pointNum>1){
                        Toast.makeText(MainActivity.this, "小数点个数错误!", Toast.LENGTH_SHORT).show();
                        return  0;
                    }
                }

                //重新定位ch
                ch=str.charAt(i);
                out.println("stringbuffer:sb1="+sb1);
                temp=Double.parseDouble(sb1.toString());
                out.println("入栈数："+temp);
                NumStack.push(temp);
                //清空temp和sb1
                sb1=new StringBuffer();
                temp=0.0;
            }

            //操作符
            if(!Character.isDigit(str.charAt(i))){
                //除去一些非法情况
                //(8)9，右括号后面不能跟数字
                if(str.charAt(i)==')' && Character.isDigit(str.charAt(i+1))){
                    Toast.makeText(MainActivity.this, "右括号后面不能跟数字!", Toast.LENGTH_SHORT).show();
                    return 0;
                }
                out.println("top="+top+"   ch="+ch);
                top=OpStack.pop();
                OpStack.push(top);
                //比右边的运算符优先级低就不做操作
                if(lp(top)<rp(ch)) {

                }else{
                    //入栈高优先级的运算符
                    while (lp(top)>=rp(str.charAt(i))){
                        //结束
                        if(top=='#' && str.charAt(i)=='='){
                            //peek返回栈顶但不移除
                            out.println("result:"+NumStack.peek());
                            String strRe= String.valueOf(NumStack.peek());
                            //0作除数的时候栈会返回Infinity
                            if(strRe.contains("Infinity")){
                                Toast.makeText(MainActivity.this, "0不能做除数!", Toast.LENGTH_SHORT).show();
                                return 0;
                            }
                            return NumStack.pop();
                        }

                        //当左右括号相遇时，跳过右括号，删除左括号
                        else if(top=='(' && str.charAt(i)==')'){
                            out.println("左右括号相遇");
                            //跳过右括号
                            i++;
                            OpStack.pop();

                            top=OpStack.pop();
                            OpStack.push(top);
                        }
                        else{
                            //运算一次表达式
                            a=NumStack.pop();
                            b=NumStack.pop();
                            NumStack.push(operate(top,b,a));
                            out.println("运算："+b+top+a);
                                OpStack.pop();
                                top=OpStack.pop();
                                OpStack.push(top);
                            }
                        }
                    }
                OpStack.push(str.charAt(i));
                }
            }
        return result;
    }
}