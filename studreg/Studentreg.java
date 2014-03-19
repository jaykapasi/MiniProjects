import java.io.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.net.*;
import java.security.*;
/*<APPLET CODE="Studentreg.class" HEIGHT=700 WIDTH=700>
</APPLET>*/
public class Studentreg extends Applet implements ActionListener,ItemListener,TextListener 
{
int flag=0;
String msg = "Hello from Java (using javascript alert)";
String str1,str2,str3,str4,str5,str6,str7,str8,str9,str10,str11,str12,str13,str14,str15,str16,str17;
Frame f1;
TextField name1,age1,eid1,no1,city1,state1,pincode1,country1,one1,two1,three1,mark1,mark2,mark3,outof1,outof2,outof3,per1,per2,per3,yop1,yop2,yop3,select2,date2,month2,year2,t;
Label name,age,eid,no,dob,address,city,state,pincode,country,qua,srno,exam,mark,outof,per,yop,one,two,three,caf;
CheckboxGroup mf;
Checkbox male,female;
Button submit,info,del,exit,exit1,update,back;
Choice date,month,year,select,name2;
TextArea adds;
Font f;
Statement stmt;
Connection con;
PreparedStatement ps;
ResultSet rs;


public void init()
{


t=new TextField(0);
f=new Font("Calibri",Font.BOLD,12);
setFont(f);
f1=new Frame("information");
f1.setSize(900,800);
f1.setVisible(false);
f1.setResizable(false);
name=new Label("Name");
name1=new TextField(15);
age=new Label("Age");
age1=new TextField(3);
eid=new Label("email id");
eid1=new TextField(20);
no=new Label("Mobile no"); 
no1=new TextField(10);
mf=new CheckboxGroup();
male=new Checkbox("Male",mf,false);
female=new Checkbox("Female",mf,false);
date =new Choice();
month =new Choice();
year =new Choice();
dob= new Label("Date of Birth");
adds = new TextArea(2,25);
address =new Label("Address");
city =new Label("City");
state =new Label("State");
pincode =new Label("Pincode");
country =new Label("Country");
city1 =new TextField(15);
state1=new TextField(15);
pincode1=new TextField(6);
country1=new TextField(15);
qua =new Label("Qualification");
srno=new Label("Sr.No");
exam=new Label("Examination");
mark=new Label("Marks Obtained");
outof=new Label("Out Of");
per=new Label("Percentage");
yop=new Label("Year Of Passing");
one=new Label("1");
two=new Label("2");
three=new Label("3");
one1=new TextField(5);
two1=new TextField(5);
three1=new TextField(5);
mark1=new TextField(5);
mark2=new TextField(5);
mark3=new TextField(5);
outof1=new TextField(5);
outof2=new TextField(5);
outof3=new TextField(5);
per1=new TextField(5);
per2=new TextField(5);
per3=new TextField(5);
yop1=new TextField(5);
yop2=new TextField(5);
yop3=new TextField(5);
caf=new Label("Courses Applied For");
select=new Choice();
submit=new Button("Submit");
exit=new Button("Exit");
info=new Button("Student Info");
exit1=new Button("Exit");
del=new Button("Delete");
update=new Button("Update");
back=new Button("Back");
select2=new TextField(12);

date2=new TextField(10);
name2=new Choice();



add (name);
add (name1);
add (age);
add (age1);
add (eid);
add (eid1);
add (no);
add (no1);
add (male);
add (female);
add (dob);
add (adds);
add (address);
add (city);
add (state);
add (country);
add (pincode);
add (city1);
add (state1);
add (pincode1);
add (country1);
add (qua);
add (srno);
add (mark);
add (outof);
add (exam);
add (per);
add (yop);
add (one);
add (two);
add (three);
add (one1);
add (mark1);
add (outof1);
add (per1);
add (yop1);
add (two1);
add (mark2);
add (outof2);
add (per2);
add (yop2);
add (three1);
add (mark3);
add (outof3);
add (per3);
add (yop3);
add (caf);
add (select);
add (submit);
add (exit);
add (info);
add (select2);



select.add("----------Select-----------");
select.add("Computer Engg");
select.add("Information Technology");
select.add("Civil Engg");
select.add("Mechanical Engg");
select.add("Electrial Engg");
select.add("EXTC Engg");
select.add("Electronics Engg");


country1.setText("INDIA");
country1.setEditable(false);
date.add("Day");
month.add("Month");
year.add("Year");

submit.addActionListener(this);
exit.addActionListener(this);
info.addActionListener(this);
exit1.addActionListener(this);
del.addActionListener(this);
update.addActionListener(this);
back.addActionListener(this);
no1.addTextListener(this);
   for(int i=1;i<=31;i++)
	{
	String s=""+i;
	date.add(s);
	}
	String mnt[] = {"1","2","3","4","5","6","7","8","9","10","11","12"};
	for(int i=0;i<12;i++)
	{
	month.add(mnt[i]);
	}
	for(int i=1980;i<=2012;i++)
	{
	String s=""+i;
	year.add(s);
	}
add (date);
add (month);
add (year);
add (date2);

name2.add("----------Select-----------");
add(t);
}
 public void textValueChanged(TextEvent e) {
 
 
 /*try {
      this.getAppletContext().showDocument(new URL("javascript:doAlert(\"" + msg +"\")"));
      }
    catch (MalformedURLException me) { 
	System.out.println(me);
	}*/
 
 }
public void itemStateChanged(ItemEvent ie)
{
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pct24","root","scott");
stmt=con.createStatement();
rs=stmt.executeQuery("select * from student where name='"+name2.getSelectedItem()+"'");

while(rs.next() && rs.getString("name")!=name2.getSelectedItem() )
{
age1.setText(rs.getString("age"));
eid1.setText(rs.getString("eid"));
no1.setText(rs.getString("mno"));
mf.setSelectedCheckbox(male);
date2.setText(rs.getString("dob"));
adds.setText(rs.getString("addr"));
city1.setText(rs.getString("city"));
pincode1.setText(rs.getString("pincode"));
state1.setText(rs.getString("state"));
country1.setText(rs.getString("country"));
one1.setText(rs.getString("exam"));
mark1.setText(rs.getString("mo"));
outof1.setText(rs.getString("outof"));
per1.setText(rs.getString("perc"));
yop1.setText(rs.getString("yop"));
select2.setText(rs.getString("caf"));
}
}
catch(Exception ex2)
{
System.out.println(ex2);
}
}
public void actionPerformed(ActionEvent ae)
{
String str=ae.getActionCommand();
if(str.equals("Submit"))
{
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pct24","root","scott");
stmt=con.createStatement();
str1=name1.getText();
str2=age1.getText();
str3=eid1.getText();
str4=no1.getText();
str5=mf.getSelectedCheckbox().getLabel();
str6=year.getSelectedItem()+"-"+month.getSelectedItem()+"-"+date.getSelectedItem();
str7=adds.getText();
str8=city1.getText();
str9=pincode1.getText();
str10=state1.getText();
str11=country1.getText();
str12=one1.getText();
str13=mark1.getText();
str14=outof1.getText();
str15=per1.getText();
str16=yop1.getText();
str17=select.getSelectedItem();
String str50="insert into student values('"+str1+"','"+str2+"','"+str3+"','"+str4+"','"+str5+"','"+str6+"','"+str7+"','"+str8+"','"+str9+"','"+str10+"','"+str11+"','"+str12+"','"+str13+"','"+str14+"','"+str15+"','"+str16+"','"+str17+"')";
stmt.executeUpdate(str50);
flag=0;
}
catch(Exception ex)
{
System.out.println("ERROR"+ex);			
}
}
if(str.equals("Exit"))
{
System.exit(0);
}
if(str.equals("Update"))
{
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pct24","root","scott");
stmt=con.createStatement();
rs=stmt.executeQuery("select * from student");
while(rs.next() && rs.getString("name")!=name2.getSelectedItem())
{
stmt.executeUpdate("update student set age='"+age1.getText()+"',eid='"+eid1.getText()+"',mno='"+no1.getText()+"',gender='"+mf.getSelectedCheckbox().getLabel()+"',dob='"+date2.getText()+"',addr='"+adds.getText()+"',city='"+city1.getText()+"',pincode='"+pincode1.getText()+"',state='"+state1.getText()+"',country='"+country1.getText()+"',exam='"+one1.getText()+"',mo='"+mark1.getText()+"',outof='"+outof1.getText()+"',perc='"+per1.getText()+"',yop='"+yop1.getText()+"',caf='"+select2.getText()+"' where name='"+name2.getSelectedItem()+"'");
}
}
catch(Exception ex4)
{
System.out.println(ex4);
}
}
if(str.equals("Student Info"))
{
f1.setVisible(true);
f1.add(update);
f1.add(del);
f1.add(exit1);
f1.add (select2);
f1.add(date2);
f1.add (name2);
f1.add (caf);
f1.add (name);
f1.add (age);
f1.add (age1);
f1.add (eid);
f1.add (eid1);
f1.add (no);
f1.add (no1);
f1.add (male);
f1.add (female);
f1.add (dob);
f1.add (adds);
f1.add (address);
f1.add (city);
f1.add (state);
f1.add (country);
f1.add (pincode);
f1.add (city1);
f1.add (state1);
f1.add (pincode1);
f1.add (country1);
f1.add (qua);
f1.add (srno);
f1.add (mark);
f1.add (outof);
f1.add (exam);
f1.add (per);
f1.add (yop);
f1.add (one);
f1.add (two);
f1.add (three);
f1.add (one1);
f1.add (mark1);
f1.add (outof1);
f1.add (per1);
f1.add (yop1);
f1.add (two1);
f1.add (mark2);
f1.add (outof2);
f1.add (per2);
f1.add (yop2);
f1.add (three1);
f1.add (mark3);
f1.add (outof3);
f1.add (per3);
f1.add (yop3);
f1.add(t);
f1.add(back);
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pct24","root","scott");
stmt=con.createStatement();
rs=stmt.executeQuery("select * from student");
if(flag==0)
{
while(rs.next())
{
name2.add(rs.getString("name"));
}
}
name2.addItemListener(this);
flag=1;
}
catch(Exception ex1)
{
System.out.println(ex1);
}

}
if(str.equals("Delete"))
{
try
{

Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pct24","root","scott");
stmt=con.createStatement();
stmt.executeUpdate("delete from student where name='"+name2.getSelectedItem()+"'");

name2.remove(name2.getSelectedIndex());
age1.setText(" ");
eid.setText(" ");
no1.setText(" ");
mf.setSelectedCheckbox(male);
date2.setText(" ");
adds.setText(" ");
city1.setText(" ");
pincode1.setText(" ");
state1.setText(" ");
country1.setText(" ");
one1.setText(" ");
mark1.setText(" ");
outof1.setText(" ");
per1.setText(" ");
yop1.setText(" ");
select2.setText(" ");

}
catch(Exception ex3)
{
System.out.println(ex3);
}

}
if(str.equals("Back"))
{
f1.setVisible(false);
add (name);
add (name1);
add (age);
add (age1);
add (eid);
add (eid1);
add (no);
add (no1);
add (male);
add (female);
add (dob);
add (adds);
add (address);
add (city);
add (state);
add (country);
add (pincode);
add (city1);
add (state1);
add (pincode1);
add (country1);
add (qua);
add (srno);
add (mark);
add (outof);
add (exam);
add (per);
add (yop);
add (one);
add (two);
add (three);
add (one1);
add (mark1);
add (outof1);
add (per1);
add (yop1);
add (two1);
add (mark2);
add (outof2);
add (per2);
add (yop2);
add (three1);
add (mark3);
add (outof3);
add (per3);
add (yop3);
add (caf);
add (select);
age1.setText("");
eid1.setText("");
no1.setText("");
mf.setSelectedCheckbox(male);
date2.setText("");
adds.setText("");
city1.setText("");
pincode1.setText("");
state1.setText("");
country1.setText("");
one1.setText("");
mark1.setText("");
outof1.setText("");
per1.setText("");
yop1.setText("");
select2.setText("--------select-------");
repaint();
}

}
public void paint(Graphics g)
{
Font font = new Font("Arial",Font.BOLD,20);
g.setFont(font);
g.setColor(Color.BLUE);
g.drawString("STUDENT REGESTRATION FORM",300,20);
name.setLocation(15,20);
name1.setLocation(80,20);
age.setLocation(20,50);
age1.setLocation(80,50);
eid.setLocation(20,80);
eid1.setLocation(80,80);
no.setLocation(10,110);
no1.setLocation(80,110);
male.setLocation(20,140);
female.setLocation(80,140);
dob.setLocation(20,170);
date.setLocation(103,170);
month.setLocation(155,170);
year.setLocation(220,170);
address.setLocation(20,200);
adds.setLocation(80,200);
city.setLocation(20,260);
pincode.setLocation(20,290);
state.setLocation(20,320);
country.setLocation(20,350);
city1.setLocation(80,260);
pincode1.setLocation(80,290);
state1.setLocation(80,320);
country1.setLocation(80,350);
qua.setLocation(20,380);
srno.setLocation(60,400);
exam.setLocation(120,400);
mark.setLocation(220,400);
outof.setLocation(340,400);
per.setLocation(430,400);
yop.setLocation(530,400);
one.setLocation(60,430);
two.setLocation(60,460);
three.setLocation(60,490);
one1.setLocation(120,430);
two1.setLocation(120,460);
three1.setLocation(120,490);
mark1.setLocation(220,430);
mark2.setLocation(220,460);
mark3.setLocation(220,490);
outof1.setLocation(340,430);
outof2.setLocation(340,460);
outof3.setLocation(340,490);
per1.setLocation(430,430);
per2.setLocation(430,460);
per3.setLocation(430,490);
yop1.setLocation(530,430);
yop2.setLocation(530,460);
yop3.setLocation(530,490);
caf.setLocation(20,520);
select.setLocation(150,520);
submit.setLocation(400,600);
exit.setLocation(500,600);
submit.setSize(80,40);
exit.setSize(80,40);
info.setSize(80,40);
info.setLocation(600,600);
exit1.setSize(80,40);
exit1.setLocation(350,600);
del.setSize(80,40);
del.setLocation(450,600);
select2.setLocation(150,520);
date2.setLocation(103,170);
name2.setLocation(80,20);
t.setLocation(1000,1000);
update.setLocation(550,600);
update.setSize(80,40);
back.setSize(80,40);
back.setLocation(650,600);
}
}


