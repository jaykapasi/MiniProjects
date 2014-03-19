import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
/*
<applet code ="Clock4" width=1000 height=1000>
</applet>
*/
public class Clock4 extends Applet 
{
boolean d=true;
double m=1.57,s=1.57,h=3.14,angle,ang,an,sec=0,min=0,hr=0,sec1=0,min1=0,hr1=0;
int x,y,i,hor,ver,p=0,t=0,r=0,q=0,w=1,n=0,flag=0;


//TextField text1, text2,text3,text4,text5;
String s1,s2,s3,s4;
Button change,alarm;
Frame f,f1;
AudioClip aud;
public void init()
{
Scanner sc=new Scanner(System.in);
System.out.println("Enetr:\n 1 for system input :\n 2 for User Input :\n");
n=sc.nextInt();
switch(n)
{
case 1:
{
Calendar no = Calendar.getInstance();
sec=no.get(Calendar.SECOND);
min=no.get(Calendar.MINUTE);
hr = no.get(Calendar.HOUR);
//add(text1);
break;
}
case 2:
{
sec=sc.nextDouble();
min=sc.nextDouble();
hr=sc.nextDouble();
break;
}
case 3:
{
Calendar no = Calendar.getInstance();
sec=no.get(Calendar.SECOND);
min=no.get(Calendar.MINUTE);
hr = no.get(Calendar.HOUR);
System.out.println("Set Alarm Time:"); 
hr1=sc.nextDouble();
min1=sc.nextDouble();
sec1=sc.nextDouble();
flag=1;
break;
}
default :
{
System.out.println("wrong choice:");
break;
}
} 
}
public void paint(Graphics g)
{
		 Calendar now = Calendar.getInstance();
		 sec=sec;
		 min=min;
		 hr=hr;
		Graphics2D g1=(Graphics2D) g;
setBackground(Color.BLACK);
g.setColor(Color.RED);
g.drawOval(200,50,600,600);
g.setColor(Color.CYAN);
g.drawOval(250,100,500,500);
angle=-1.57142;
for(i=1;i<=12;i++)
{
angle=angle+(5*0.10466);
hor=(int) (500+200*Math.cos(-angle));
ver=(int) (340-200*Math.sin(-angle));
g.drawString(""+i,hor,ver);
}
Font myFont = new Font("TimesRoman", Font.ITALIC, 20);
g.setFont(myFont);
g.setColor(Color.YELLOW);
angle=0.1047;
angle=sec*angle+4.712389;
g1.draw(new Line2D.Double(500,340,500+180*Math.cos(-angle),340-180*Math.sin(-angle)));
ang=0.1047;
ang=4.712389+ang*min;
g.setColor(Color.RED);
g1.draw(new Line2D.Double(500,340,500+160*Math.cos(-ang),340-160*Math.sin(-ang)));
an=0.1047;
an=4.712389+an*hr*5;
g.setColor(Color.BLUE);
g1.draw(new Line2D.Double(500,340,500+130*Math.cos(-an),340-130*Math.sin(-an)));
while(d)
{
setBackground(Color.BLACK);
Clock4 c=new Clock4();
angle=0.1047;
angle=sec*angle+4.712389;
g1.draw(new Line2D.Double(500,340,500+180*Math.cos(-angle),340-180*Math.sin(-angle)));
try
{
g.setColor(Color.BLUE);
g.drawString("TIME=:"+hr+":"+min+":"+sec,150,20);
Thread.sleep(1000);
g.setColor(Color.WHITE);
g.drawString("TIME=:"+hr+":"+min+":"+sec,150,20);
}
catch(Exception e)
{
}
g.setColor(Color.WHITE);
g1.draw(new Line2D.Double(500,340,500+180*Math.cos(-angle),340-180*Math.sin(-angle)));
if(angle==10.994389)
{
g.setColor(Color.WHITE);
g1.draw(new Line2D.Double(500,340,500+160*Math.cos(-ang),340-160*Math.sin(-ang)));

min++;
ang=0.1047;
ang=4.712389+ang*min;

g.setColor(Color.RED);
g1.draw(new Line2D.Double(500,340,500+160*Math.cos(-ang),340-160*Math.sin(-ang)));
}
g.setColor(Color.WHITE);
an=0.1047;
an=4.712389+an*hr*5;
g1.draw(new Line2D.Double(500,340,500+130*Math.cos(-an),340-130*Math.sin(-an)));
g.setColor(Color.BLUE);
an=0.1047;
an=4.712389+an*hr*5;
g1.draw(new Line2D.Double(500,340,500+130*Math.cos(-an),340-130*Math.sin(-an)));
if(min>=12 && min<24)
{
an=an+2*.1047198;
}
if(now.get(Calendar.MINUTE)>=24 && now.get(Calendar.MINUTE)<36)
{
an=an+(3*.1047198);
}
if(now.get(Calendar.MINUTE)>=36&&now.get(Calendar.MINUTE)<48)
{
an=an+(4*.1047198);
}
if(now.get(Calendar.MINUTE)>=48&&now.get(Calendar.MINUTE)<60)
{
an=an+(5*.1047198);
}
if(sec==60)
{
sec=0;
}
if(min==60)
{
hr++;
min=0;
}
sec++;
if(flag==1)
{
 if(min==min1 && hr==hr1)
{
aud=getAudioClip(getCodeBase(),"M1F1-Alaw-AFsp.au");
aud.play();
flag=0;
}
}
g.setColor(Color.YELLOW);
}
}
}