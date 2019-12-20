# JavaCC
Mnc-javacc
简单语法器
## 功能要求
用流的形式读入要分析的MiniC源程序。

能够根据单词的构词规则，完成MiniC语言中的单词的解析(词法分析)，如果不符合单词的构词规则，请给出错误信息。如果源语言符合单词的词法规则，请输出<单词种别，单词自身值>二元式。（注：利用JavaCC实现）

在词法分析的基础上，构造MiniC的递归下降分析文法，利用JavaCC实现递归下降分析文法。判断源语言是否符合MiniC的语法，如果符合，输出语法树；否则，请给出语法错误信息。

在语法分析的基础上，根据属性文法制导翻译，进行语义分析，输出四元式。如果源语言不符合MiniC的语义，请指出错误信息。

在平时实习课的基础上，整个编译系统要能够翻译声明语句、数组(二维，多维)翻译，数学表达式、关系表达式、布尔表达式，if-else, for, while，do-while，switch-case，赋值等语句嵌套的分析与翻译。

实现符号表，并能够检查变量重复声明、使用时未定义错误。

## 实现扩展内容：

扩展内容：可以考虑多个函数及函数调用翻译。

扩展内容：可以添加功能，如break、continue、return语句、一维指针。

扩展内容：可以检查赋值精度错误、函数参数类型不匹配错误、静态数组元素下标越界错误、break错误、continue错误等。

扩展内容：为编译器添加界面。

### 实现的功能
(1) 采用流的形式读入要分析的MiniC源程序。

(2) 编写一个简单的编译器界面来对成果进行展示。

(3) 实现词法分析和语法分析，并将其结果输出到文件。

(4) 实现语义分析，主要有：声明语句、数学表达式、关系表达式。

(5) 实现if-else, for, while，do-while，switch-case，赋值等语句嵌套的分析与翻译。

(6) 实现符号表，能检查变量的重复声明，使用时未定义错误。

### 界面展示

![图形界面](https://github.com/suanlebanihepide/JavaCC/blob/master/gui.png)


## 设计思路

### 文法设计
#### 命名:
```
程序：Program
语句块：StateBlock
语句：Statement

条件语句：ifStatement
switch语句：SwtichStatement
while语句：whileStatement
dowhile语句：dowhileStatement
for语句：forStatement

自增自减语句：Auto
声明语句：declearStatement
赋值语句：assignStatement

类型：Type
表达式：Expression
非运算：NoBoolExpression
或运算：orStatement
与运算：andStatement
运算符：Operator
关系符：relExpresion

```
###文法：
```
<程序> ::= <类型> main_fun "(" (<类型> ID)* ")" <语句块>
<语句块>::= <语句> | { <语句块>}
<语句>::=<if语句> | <while语句> | <for语句>| <switch-case语句>|<dowhile语句>|<breadk;>|<continue;>
<声明语句> ::= <类型> ID (0,ID)*
<类型> -> int | void | double | float | char|string
<赋值语句> -> ID = <表达式>
<break语句> -> break
<if语句>::=” if ( ” <或语句>” ) ” ” { ”<语句块>” } ” [ “ else ”<语句块> ]
<while语句>::=” while ( ” <或语句>” ) ” ” { ”<语句块>” } ” 
<dowhile语句>::=” do { ” <语句块>” } ”  “ while ”<或语句> 
<for语句>::=” for ( ” <声明语句|赋值语句 > <或语句> <自增语句|赋值语句> ” ) ” ” { ”<语句块>” } ” 
<自增语句>::= <(ID”++”) | (ID”--”)> |  <(”++”ID) | (”--”ID)> 
<或语句>::= <与语句>  { ”||”<与语句> } 
<与语句>::= <非语句>  { ”&&”<非语句> } 
<非语句>::= “ ! ” <关系语句> 
<关系语句>::=<表达式语句> [ (“ > ”| “ < ”| “ >=” | “ <=” | “ == ” | “  != ” ) <表达式语句> ]

```

## 测试文件
### test1
```
int main(){
int grade=0,flag=0;
int num1=0,num2=0;
if(grade>60)
   flag=1;
else
  flag=0;

switch(flag){
 case 1:num1=num1+1;break;
default:
 num2=num2+1;

}
}
```
### test2
```
int main(){
int n=10;
int m=0;
int a=1,b=2;
for(int i=0;i<n;i++){
   if(b<a)
    while(b<a)
      b=b+2;
}
}
```
