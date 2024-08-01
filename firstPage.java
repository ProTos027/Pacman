import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
class alpha extends Frame implements ActionListener{
    Button start,scrbrd,quit,hlp;
    Label pcman,wlcm; 
    //page 1
    alpha(){
        //frame
        setLayout(null);
        setSize(500,500);
        setVisible(true);
        setBackground(Color.black);

        //welcome
        pcman =new Label("PAC-MAN");
        pcman.setBounds(125,100,270,50);
        pcman.setForeground(Color.yellow);
        pcman.setFont(new Font("",Font.BOLD,50));

        wlcm =new Label("Welcome!!");
        wlcm.setBounds(180,175,130,40);
        wlcm.setForeground(Color.orange);
        wlcm.setFont(new Font("",Font.BOLD,25));
        add(wlcm);
        add(pcman);
        //button
        hlp = new Button("help?");
        hlp.setBounds(420,50,60,40);
        hlp.setForeground(Color.white);
        hlp.setBackground(Color.red);
        hlp.setFont(new Font("",Font.PLAIN,15));
         add(hlp);

        start = new Button("Let it begin!");
        start.setBounds(190,300,100,40);
        start.setForeground(Color.green);
        start.setFont(new Font("",Font.ITALIC,15));
         add(start);

        quit = new Button("walk away?");
        quit.setBounds(190,380,100,40);
        quit.setForeground(Color.red);
        quit.setFont(new Font("",Font.ITALIC,15));
        add(quit);

        //working
        start.addActionListener(this);
        quit.addActionListener(this);
        hlp.addActionListener(this);
    }
//working explanation of page 1
      public void actionPerformed(ActionEvent ae)
{
    String s = ae.getActionCommand();
    if(s.equals("Let it begin!"))
    {
       new beta();
    }
    if(s.equals("walk away?"))
    {
        System.exit(0);
    }
    if(s.equals("help?")){
        new help();
    }

 }
}
//help
class help extends Frame implements ActionListener{
    Label wlcm,desc1,desc2;
    Button back;
 help(){
    setLayout(null);
    setSize(500,500);
    setVisible(true);
    setBackground(Color.black);
    wlcm =new Label("To those who seek enlightment...");
    wlcm.setBounds(50,50,470,40);
    wlcm.setForeground(Color.red);
    wlcm.setFont(new Font("",Font.BOLD,25));
    add(wlcm);
    desc1 =new Label("thee canst only gain maximum wisdom");
    desc1.setBounds(50,100,450,50);
    desc1.setForeground(Color.green);
    desc1.setFont(new Font("",Font.ITALIC,15));
    add(desc1);
    desc2 =new Label(" if thou art fearless...");
    desc2.setBounds(50,150,450,50);
    desc2.setForeground(Color.green);
    desc2.setFont(new Font("",Font.ITALIC,15));
    add(desc2);
     back = new Button("return?");
    back.setBounds(150,250,200,100);
    back.setForeground(Color.cyan);
    back.setBackground(Color.blue);
    back.setFont(new Font("",Font.ITALIC,40));
    add(back);
    back.addActionListener(this);
}
    public void actionPerformed(ActionEvent ae) {
        String s = ae.getActionCommand();
        if(s.equals("return?")){
        new alpha();
    }
    
}
}
//intro
 class beta extends Frame implements ActionListener,TextListener{
    Button next;
    Label nam;
    TextField Name;
    String str;
    beta(){
        //frame
        setLayout(null);
        setSize(500,500);
        setVisible(true);
        setBackground(Color.black);
        //name
        nam =new Label("Thou nameth?");
        nam.setBounds(150,150,240,40);
        nam.setForeground(Color.red);
        nam.setFont(new Font("",Font.ITALIC,30));
        add(nam);
        //button,textfield
        next = new Button("Go Further?");
        next.setBounds(195,260,110,40);
        next.setForeground(Color.yellow);
        next.setBackground(Color.red);
        next.setFont(new Font("",Font.ITALIC,15));

        Name = new TextField();
        Name.setBounds(150,200,200,40);
        Name.setForeground(Color.black);
        add(next);
        add(Name);
        //working
        next.addActionListener(this);
        Name.addTextListener(this);
    }
// explanation of working(textfield)
 public void textValueChanged(TextEvent e){
    if(e.getSource() == Name){
       str =Name.getText();
    }
 }
 //explanation of working(button)
      public void actionPerformed(ActionEvent ae)
{
    String s = ae.getActionCommand();
    if(s.equals("Go Further?"))
    { //for game
        JFrame frame = new JFrame("welcome "+str);
        pacbody pac = new pacbody(str);
        frame.add(pac);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.getContentPane().setBackground(Color.black);
        frame.setVisible(true);
    }
    
 }
}
//end
class gamma extends Frame implements ActionListener{
    Button next;
    Label nam,score;
    gamma(int scr,String name){
        //frame
        setLayout(null);
        setSize(500,500);
        setVisible(true);
        setBackground(Color.black);
        //score
        score =new Label("thou hast shown "+scr+" points of wisdom..");
        score.setBounds(75,100,500,40);
        score.setForeground(Color.green);
        score.setFont(new Font("",Font.ITALIC,20));
        add(score);
        //name
        nam =new Label("we art proud of thou "+name+"...");
        nam.setBounds(125,150,300,40);
        nam.setForeground(Color.green);
        nam.setFont(new Font("",Font.ITALIC,20));
        add(nam);
        //button,textfield
        next = new Button("regress?");
        next.setBounds(175,260,150,40);
        next.setForeground(Color.red);
        next.setFont(new Font("",Font.ITALIC,15));
        add(next);
        //working
        next.addActionListener(this);
    }
    
 
 //explanation of working(button)
      public void actionPerformed(ActionEvent ae)
{
    String s = ae.getActionCommand();
    if(s.equals("regress?"))
    { //for game
        new alpha();
    }
    
 }

}
//game entry
class pacbody extends JPanel implements ActionListener, KeyListener{
     int x= 20; // Initial X position of body
     int y =205;
     int gx = 285;
     int gy =100;
     int k =1;
     int p=0;
     String name;
    Long starttime = System.nanoTime();
    public pacbody(String nam) {
        name=nam;
        Timer timer = new Timer(0, this); // Timer for animation
        timer.start();
        //background
        setBackground(Color.black);
        //motion control
        addKeyListener(this);
        setFocusable(true);//connection to keyboard?
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        body(g);
        repaint();
    }
    private void body(Graphics g) {
        //background
        g.setColor(Color.blue);
        g.setFont(new Font("",Font.ITALIC,25));
        g.drawString("reach the aim:", 10, 20);
        g.setColor(Color.blue);
        g.drawRect(10,50 , 460,400);
        //boundary
        //upper left
        g.setColor(Color.cyan);
        g.fillRect(10,50,150,150);
        g.setColor(Color.blue);
        g.drawRect(10,50 , 150,150);
        //lower left
        g.setColor(Color.cyan);
        g.fillRect(10,250,150,200);
        g.setColor(Color.blue);
        g.drawRect(10,250 , 150,200);
        //lower right
        g.setColor(Color.cyan);
        g.fillRect(320,300,150,150);
        g.setColor(Color.blue);
        g.drawRect(320,300 , 150,150);
        //upper right
        g.setColor(Color.cyan);
        g.fillRect(320,50,150,200);
        g.setColor(Color.blue);
        g.drawRect(320,50 , 150,200);
        //middle
        g.setColor(Color.cyan);
        g.fillRect(215,100,50,300);
        g.setColor(Color.blue);
        g.drawRect(215,100 , 50,300);
         //ghost
        g.setColor(Color.white);
        g.fillArc(gx, gy, 20, 20,0,180);
        g.fillRect(gx, gy+10, 20, 20);
        g.setColor(Color.black);
        g.fillOval(gx+4,gy+5 ,7,10);
        //pacman
        if(k%3==1)
        {
        g.setColor(Color.yellow);
        g.fillArc(x, y, 40, 40,35,290);
        }
        else if(k%3==2)
        {
        g.setColor(Color.yellow);
        g.fillArc(x, y, 40, 40,17,325);
        }
        else
        {
        g.setColor(Color.yellow);
        g.fillArc(x, y, 40, 40,0,360);
        }
        g.setColor(Color.blue);
        g.fillOval(x+13,y+7 , 10,7);
        g.setColor(Color.white);
        g.fillOval(x+15,y+9 , 5,3);
        gy += 5;
        if (gy > 380) {
        gy = 80; 
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e){}
        k++;
        
    }

    public void keyReleased(KeyEvent e) { {
        int score1,s = e.getKeyCode();
        if(s == 38){
            y -= 10;
            //y restriction
            if ((y<50)||((x<=160)&&((y<=200)||(y>=210)))||((x>=280)&&((y<=250)||(y>=260)))||((x>=175)&&(x<=265)&&(y>=60)&&(y<=400))) {
            y +=10; 
        }
    }
        if(s == 40){
            y += 10;
            //y restriction
            if ((y >410)||((x<=160)&&((y<=200)||(y>=210)))||((x>=280)&&((y<=250)||(y>=260)))||((x>=175)&&(x<=265)&&(y>=60)&&(y<=400))) {
            y -= 10; 
        }
    }
        if(s == 37){
            x -= 10;
            //x restriction
            if ((x <30)||((x<=160)&&((y<=200)||(y>=210)))||((x>=280)&&((y<=250)||(y>=260)))||((x>=175)&&(x<=265)&&(y>=60)&&(y<=400))) {
            x += 10; 
        }
    }
        if(s == 39){
            x += 10;
            //x restriction
            if ((x >420)||((x<=160)&&((y<=200)||(y>=210)))||((x>=280)&&((y<=250)||(y>=260)))||((x>=175)&&(x<=265)&&(y>=60)&&(y<=400))) {
            x -= 10; 
        }
    }
         if(((gx <= (x+35))&&(gy <= (y+35))&&(gy >= y)&&(gx >= x))||((x>=420)&&(y>=250)&&(y<=300)))
         {
        Long endtime = System.nanoTime();
        score1 =1000-p*7-(int)(( endtime - starttime)/1000000000)*5;
        new gamma(score1,name);}
       else{
        p+=1;
    } // Redraw

}
}

    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {}
    public void actionPerformed(ActionEvent e) {}
}
//main 
public class firstPage{
    public static void main(String[] args){
       // calls page 1
        new alpha();
    }  
}