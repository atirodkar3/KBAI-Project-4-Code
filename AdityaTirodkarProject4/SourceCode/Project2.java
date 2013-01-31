import java.io.IOException;

/* FINAL IMPLEMENTATION OF KBAI PROJECT $
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rosenkrantz
 */

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.*;
import javax.swing.*;

public class Project2 
{   public static int filval=0;
	public static void main(String args[])throws IOException
                  {
                       readfile t=new readfile();
                       for(int pp=1;pp<13;pp++)
                       {    
                        t.oneline(pp);
                        //System.out.println("32%");
                        breakerOfLines btl;
                        btl = new breakerOfLines();
                        btl.breaktl();
                        //System.out.println("48%");
                        String scyzer=readfile.wholefile[0];
                        String syther=scyzer.substring(0,1);
                        String sizor=scyzer.substring(2);
                        //System.out.println(syther);
                        //System.out.println(sizor);
                        arrayquest aq=new arrayquest();
                        aq.quest();
                        arrayoptions ao=new arrayoptions();
                        ao.opt();
                        measures mea=new measures();
                        mea.measure();
                        relations rel=new relations();
                        rel.relate();
                        
                        score sc=new score();
                        sc.scorer();
                        arrayoptions.opfig=null;
                        arrayquest.questfig=null;
                        breakerOfLines.j=0;
                        measures.opMeasure=null;
                        measures.questMeasure=null;
                        readfile.bx=0;
                        readfile.b=null;
                        readfile.wholefile=null;
                        relations.finans=null;
                        relations.relator=null;
                        
                       }
                  }
                         
}

class readfile
{public int countlen=0;
public static String[] wholefile;
public static String b="";
public static int bx=0;
public void oneline(int rr)throws IOException
	{   bx=rr;
                      countlen=0;
		File file = new File("2-"+rr+".txt");
		BufferedReader br=new BufferedReader(new FileReader(file));

		
		String s;
		while((s=br.readLine())!= null)
		{b=b+s;
                countlen++;

		}
       wholefile=new String[countlen];
        ////System.out.println(b);
                  }
}

class breakerOfLines
        {public static int j=0;
    public void breaktl()
    {  
  
        String onelineval="";
        
        for(int i=0;i<readfile.b.length();i++)
            {   
                char tempbreakalpha;
                tempbreakalpha = (readfile.b.charAt(i));
                String tempbreakalpha1=Character.toString(tempbreakalpha);
                if((tempbreakalpha1.equals("~")))
                    {
                       readfile.wholefile[j]=onelineval; 
                       j++;
                       onelineval="";
                    }
                else
                {    onelineval+=readfile.b.charAt(i);
                    
                }    
            }
    int i=0;
/*while(i<readfile.wholefile.length)
{//System.out.println(readfile.wholefile[i]);
i++;
}
    //System.out.println(readfile.wholefile[0]);
  */  
    
    }

}

class arrayquest
        {String wholval[]=readfile.wholefile;
    public static String[][] questfig;
    public void quest()
    {   int noques=0;
        int starlow=0;
        int starhigh=0;
        int difff=0;
        for(int i=0;i<wholval.length;i++)
        {
            if(wholval[i].substring(0,1).equals("Q"))
            {   starlow=i;
                noques++;
                
            }
            if(wholval[i].equals("//"))
            {   starhigh=i;
            }
            
        
        if(starhigh-starlow>difff)
        {
            difff=starhigh-starlow;
        }
        }
        //System.out.println(noques);
        //System.out.println(difff);
        
        questfig=new String[noques][difff];
        int kk=2;
        int jj=0;
        int ii=0;
        while (ii<noques)
        {   
            
            while(!wholval[kk].equals("Options"))
            {
                while(!wholval[kk].equals("//"))
                {   ////System.out.println("wholval"+wholval[kk]);
                    questfig[ii][jj]=wholval[kk];
                    kk++;
                    jj++;
                    ////System.out.println("wholJJJJ"+jj);
                }
                kk++;
                jj=0;
                ii++;
            }
            
            
        }
        for(int i=0;i<noques;i++)
           {    
               for(int j=0;j<difff;j++)
           {
               if(questfig[i][j]==(null))
               {
                   questfig[i][j]="zzzzzzzz";
               }
           }
               
           }
 /*  for(int i=0;i<noques;i++)
           {    //System.out.println("Fig"+(i+1));
               for(int j=0;j<difff;j++)
           {
               //System.out.println(questfig[i][j]);
           }
               
           }
    for(int m=0;m<wholval.length;m++)
    {//System.out.println(wholval[m]);
    }*/
    
    
    }
}

class arrayoptions
        {String opval[]=readfile.wholefile;
    public static String[][] opfig;
    public void opt()
    {   int noques=0;
        int starlow=0;
        int starhigh=0;
        int difff=0;
        int starter=0;
        for(int i=0;i<opval.length;i++)
            {
            if(opval[i].equals("Options"))
            { starter=i;
            }
            }
        
        for(int i=starter;i<opval.length;i++)
        {
            if(opval[i].substring(0,1).equals("V"))
            {   starlow=i;
                noques++;
                
            }
            if(opval[i].equals("/"))
            {   starhigh=i;
            }
            
        
        if(starhigh-starlow>difff)
        {
            difff=starhigh-starlow;
        }
        }
        //System.out.println(noques);
        //System.out.println(difff);
        
       opfig=new String[noques][difff];
        int kk=starter+1;
        int jj=0;
        int ii=0;
        while (ii<noques)
        {   
            
            while(!opval[kk].equals("///"))
            {   
                while(!opval[kk].equals("/"))
                {   ////System.out.println("opval"+opval[kk]);
                    opfig[ii][jj]=opval[kk];
                    kk++;
                    jj++;
                   ////System.out.println("JJJJ"+jj);
                }
                kk++;
                jj=0;
                ii++;
            }
            
            
        }
        for(int i=0;i<noques;i++)
           {    
               for(int j=0;j<difff;j++)
           {
               if(opfig[i][j]==(null))
               {
                   opfig[i][j]="zzzzzzzz";
               }
           }
               
           }
  /* for(int i=0;i<noques;i++)
           {    //System.out.println("OPTION"+(i+1));
               
               for(int j=0;j<difff;j++)
           {
               //System.out.println(opfig[i][j]);
           }
               
           }
    for(int m=0;m<opval.length;m++)
    {//System.out.println(opval[m]);
    }*/
    }
}

class measures
{String questfag[][]=arrayquest.questfig;
 public static String questMeasure[][];
 String opfag[][]=arrayoptions.opfig;
 public static String opMeasure[][];
    void measure()
    {  //FIND NO OF OBJECTS QUESTIONS
        int hlen=0;
        for(int i=0;i<questfag.length;i++)
        {   int rlen=0;
            for(int j=0;j<questfag[0].length;j++)
            {       ////System.out.println(questfag[i][j]);
                    //if(questfag[i][j].length>6)
                {   if(questfag[i][j].substring(0,3).equals("Obj"))
                    {   
                        rlen++;
                    }
                }
            }
        if(rlen>hlen)
            {
                hlen=rlen;
            }
        }
    //System.out.println("Horizontal LEngth"+hlen);
    questMeasure=new String[questfag.length][hlen*4+2];    
       //FIND NO OF OBJECTS OPTIONS 
        hlen=0;
        for(int i=0;i<opfag.length;i++)
        {   int rlen=0;
            for(int j=0;j<opfag[0].length;j++)
            {       ////System.out.println(opfag[i][j]);
                    //if(opfag[i][j].length>6)
                   if(opfag[i][j].substring(0,2).equals("Ob"))
                    { //  //System.out.println("ENTRARE");
                        rlen++;
                    }
                
            }
        if(rlen>hlen)
            {
                hlen=rlen;
            }
        }
    //System.out.println("Horizontal LEngth"+hlen);
    opMeasure=new String[opfag.length][hlen*4+2];    
    
    
    //Put Question Values in String Array
    for(int i=0;i<questMeasure.length;i++)
    {   for(int j=0;j<questMeasure[0].length;j++)
        {   
                questMeasure[i][j]="";
            
        }
    }
    for(int i=0;i<questMeasure.length;i++)
    {   
        questMeasure[i][0]=questfag[i][0];
        questMeasure[i][1]=(questfag[i][1].substring(questfag[i][1].indexOf(":")+2));
        int count=2;
        
                    
        //int refig=0;
        //int flag=0;
        for(int j=2;j<questfag[0].length;j++)
            {   ////System.out.println("COUNT "+count);
                if(questfag[i][j].substring(0,2).equals("Ob"))
                {  
                    /*
                    String figore=questfag[i][j].substring(questfag[i][j].indexOf(":")+2);
                    for(int k=0;k<questfag[0].length;j++)
                        {
                            if(questMeasure[i][k].equals(figore))
                            {
                                refig=count;
                                count=k;
                                flag=1;
                            }*/
                            //else{
                    questMeasure[i][count]=questfag[i][j].substring(questfag[i][j].indexOf(":")+2);
                              //  }
                          //  }
                   ////System.out.println("VALUEPUTIN"+questMeasure[i][count]); 
                    int posval=0;
                    
                    if((questfag[i][j+1].substring(questfag[i][j+1].indexOf(":")+2)).equals("All"))
                            {
                                posval=5;
                            }
                    if((questfag[i][j+1].substring(questfag[i][j+1].indexOf(":")+2)).equals("Left"))
                            {
                                posval=-2;
                            }
                    if((questfag[i][j+1].substring(questfag[i][j+1].indexOf(":")+2)).equals("Right"))
                            {
                                posval=2;
                            }
                    if((questfag[i][j+1].substring(questfag[i][j+1].indexOf(":")+2)).equals("Center"))
                            {
                                posval=1;
                            }
                    
                    if((questfag[i][j+2].substring(questfag[i][j+2].indexOf(":")+2)).equals("All"))
                            {
                                posval*=5;
                            }
                    if((questfag[i][j+2].substring(questfag[i][j+2].indexOf(":")+2)).equals("Top"))
                            {
                                posval*=3;
                            }
                    if((questfag[i][j+2].substring(questfag[i][j+2].indexOf(":")+2)).equals("Bottom"))
                            {
                                posval*=-4;
                            }
                    if((questfag[i][j+2].substring(questfag[i][j+2].indexOf(":")+2)).equals("Middle"))
                            {
                                posval*=-1;
                            }
                    
                    questMeasure[i][count+1]="";
                    questMeasure[i][count+1]+=posval;
                    ////System.out.println("VALUEPUTIN"+questMeasure[i][count+1]);
                    questMeasure[i][count+2]=questfag[i][j+3].substring(questfag[i][j+3].indexOf(":")+2);
                    ////System.out.println("VALUEPUTIN"+questMeasure[i][count+2]);
                    questMeasure[i][count+3]=questfag[i][j+4].substring(questfag[i][j+4].indexOf(":")+2);
                    ////System.out.println("VALUEPUTIN"+questMeasure[i][count+3]);
                    count+=4;
        //            if(flag==1)
        //            {
          //              count=refig;
            //            refig=0;
              //          flag=0;
                //    }
                    
                    
                }
            }
             }
    
    //System.out.println("DISPLAY MEASURES");
    
  /*  for(int i=0;i<questMeasure.length;i++)
    {   for(int j=0;j<questMeasure[0].length;j++)
        {   if(questMeasure[i][j]==null)
            {
                questMeasure[i][j]="zzzzz";
            }
        }
    }*/
    
    for(int i=0;i<questMeasure.length;i++)
    {   for(int j=0;j<questMeasure[0].length;j++)
        {
            //System.out.println(questMeasure[i][j]);
        }
    }
        //Put Option Values in String Array
    for(int i=0;i<opMeasure.length;i++)
    {   for(int j=0;j<opMeasure[0].length;j++)
        {   
                opMeasure[i][j]="";
            
        }
    }
    for(int i=0;i<opMeasure.length;i++)
    {   
        
        opMeasure[i][0]=opfag[i][0];
        opMeasure[i][1]=(opfag[i][1].substring(opfag[i][1].indexOf(":")+2));
        int count=2;
        
                    
        //int refig=0;
        //int flag=0;
        for(int j=2;j<opfag[0].length;j++)
            {   ////System.out.println("COUNT "+count);
                if(opfag[i][j].substring(0,2).equals("Ob"))
                {  
                    /*
                    String figore=opfag[i][j].substring(opfag[i][j].indexOf(":")+2);
                    for(int k=0;k<opfag[0].length;j++)
                        {
                            if(opMeasure[i][k].equals(figore))
                            {
                                refig=count;
                                count=k;
                                flag=1;
                            }*/
                            //else{
                    opMeasure[i][count]=opfag[i][j].substring(opfag[i][j].indexOf(":")+2);
                              //  }
                          //  }
                  //System.out.println("VALUEPUTIN"+opMeasure[i][count]); 
                    int posval=0;
                   if((opfag[i][j+1].substring(opfag[i][j+1].indexOf(":")+2)).equals("All"))
                            {
                                posval=5;
                            }
                    if((opfag[i][j+1].substring(opfag[i][j+1].indexOf(":")+2)).equals("Left"))
                            {
                                posval=-2;
                            }
                    if((opfag[i][j+1].substring(opfag[i][j+1].indexOf(":")+2)).equals("Right"))
                            {
                                posval=2;
                            }
                    if((opfag[i][j+1].substring(opfag[i][j+1].indexOf(":")+2)).equals("Center"))
                            {
                                posval=1;
                            }
                    
                    if((opfag[i][j+2].substring(opfag[i][j+2].indexOf(":")+2)).equals("All"))
                            {
                                posval*=5;
                            }
                    if((opfag[i][j+2].substring(opfag[i][j+2].indexOf(":")+2)).equals("Top"))
                            {
                                posval*=3;
                            }
                    if((opfag[i][j+2].substring(opfag[i][j+2].indexOf(":")+2)).equals("Bottom"))
                            {
                                posval*=-4;
                            }
                    if((opfag[i][j+2].substring(opfag[i][j+2].indexOf(":")+2)).equals("Middle"))
                            {
                                posval*=-1;
                            }
                    opMeasure[i][count+1]="";
                    opMeasure[i][count+1]+=posval;
                    ////System.out.println("VALUEPUTIN"+opMeasure[i][count+1]);
                    opMeasure[i][count+2]=opfag[i][j+3].substring(opfag[i][j+3].indexOf(":")+2);
                    ////System.out.println("VALUEPUTIN"+opMeasure[i][count+2]);
                    opMeasure[i][count+3]=opfag[i][j+4].substring(opfag[i][j+4].indexOf(":")+2);
                    ////System.out.println("VALUEPUTIN"+opMeasure[i][count+3]);
                    count+=4;
        //            if(flag==1)
        //            {
          //              count=refig;
            //            refig=0;
              //          flag=0;
                //    }
                    
                    
                }
            }
             }
    
    //System.out.println("DISPLAY MEASURES");
    
  /*  for(int i=0;i<opMeasure.length;i++)
    {   for(int j=0;j<opMeasure[0].length;j++)
        {   if(opMeasure[i][j]==null)
            {
                opMeasure[i][j]="zzzzz";
            }
        }
    }*/
    
    for(int i=0;i<opMeasure.length;i++)
    {   for(int j=0;j<opMeasure[0].length;j++)
        {
            //System.out.println(opMeasure[i][j]);
        }
    }
    }
}

class relations
{   public static String[][]relator;
    public static String finans[][];
    void relate()
    {
        relator=new String[Integer.parseInt(measures.questMeasure[measures.questMeasure.length-1][0].substring(1,2))+Integer.parseInt(measures.questMeasure[measures.questMeasure.length-1][0].substring(2,3))][3*measures.questMeasure[0].length];
        
        String[][] finale=new String[4+5][3*measures.questMeasure[0].length+8];
        //System.out.println("RELATOR LENGTH"+relator.length+" "+relator[0].length);
        String[][] addup=new String[measures.questMeasure.length][measures.questMeasure[0].length];
        String[][] opaddup=new String[measures.opMeasure.length][measures.opMeasure[0].length];
        
        for(int i=0;i<addup.length;i++)
        {   for(int j=0;j<addup[0].length;j++)
        {   if(addup[i][j]==null)
            {
                addup[i][j]="";
            }
        }
        }
        
        for(int i=0;i<addup.length;i++)
        {   addup[i][0]=measures.questMeasure[i][0];
            addup[i][1]=(measures.questMeasure[i][1]);
            int coun=2;
            for(int j=2;j<addup[0].length;j+=4)
            {   int flag=0;
                for(int k=2;k<addup[0].length;k++)
                {
                    if(addup[i][k].equals(measures.questMeasure[i][j]) && !measures.questMeasure[i][j].equals(""))
                    {
                        int inch=Integer.parseInt(addup[i][k+1])+Integer.parseInt(measures.questMeasure[i][j+1]);
                        addup[i][k+1]="";
                        addup[i][k+1]+=inch;
                        
                        inch=Integer.parseInt(addup[i][k+2])+Integer.parseInt(measures.questMeasure[i][j+2]);
                        addup[i][k+2]="";
                        addup[i][k+2]+=inch;
                        
                        if(measures.questMeasure[i][j+3].equals("Yes"))
                        {
                        inch=Integer.parseInt(addup[i][k+3])+1;
                        addup[i][k+3]="";
                        addup[i][k+3]+=inch;
                        }
                    flag=1;
                    }
                    
                        //if(addup[i][k].equals(measures.questMeasure[i][j]) && !measures.questMeasure[i][j].equals(""))
                        
                
                }
                if(flag==0 && !measures.questMeasure[i][j].equals(""))
                {  addup[i][coun]=measures.questMeasure[i][j];
                            addup[i][coun+1]=measures.questMeasure[i][j+1];
                            addup[i][coun+2]=measures.questMeasure[i][j+2];
                            if(measures.questMeasure[i][j+3].equals("Yes"))
                            {
                                addup[i][coun+3]="1";
                            }
                            else
                            {
                                addup[i][coun+3]="0";
                            coun+=4;
                            }
                          
                        }
            }
        }
     
        for(int i=0;i<addup.length;i++)
        {
            for(int j=0;j<addup[0].length;j++)
            {
                //System.out.println(addup[i][j]);
            }
        }
   
        //CLUBBING VALUES INSIDE THE ARRAY
        
        
        for(int i=0;i<opaddup.length;i++)
        {   for(int j=0;j<opaddup[0].length;j++)
        {   if(opaddup[i][j]==null)
            {
                opaddup[i][j]="";
            }
        }
        }
        
        for(int i=0;i<opaddup.length;i++)
        {   opaddup[i][0]=measures.opMeasure[i][0];
            opaddup [i][1]=(measures.opMeasure[i][1]);
            int coun=2;
            for(int j=2;j<opaddup[0].length;j+=4)
            {   int flag=0;
                for(int k=2;k<opaddup[0].length;k++)
                {
                    if(opaddup[i][k].equals(measures.opMeasure[i][j]) && !measures.opMeasure[i][j].equals(""))
                    {   
                        int inch=Integer.parseInt(opaddup[i][k+1])+Integer.parseInt(measures.opMeasure[i][j+1]);
                        opaddup[i][k+1]="";
                        opaddup[i][k+1]+=inch;
                        
                        inch=Integer.parseInt(opaddup[i][k+2])+Integer.parseInt(measures.opMeasure[i][j+2]);
                        opaddup[i][k+2]="";
                        opaddup[i][k+2]+=inch;
                        
                        if(measures.opMeasure[i][j+3].equals("Yes"))
                        {
                        inch=Integer.parseInt(opaddup[i][k+3])+1;
                        opaddup[i][k+3]="";
                        opaddup[i][k+3]+=inch;
                        }
                    flag=1;
                    }
                    
                        //if(opaddup[i][k].equals(measures.opMeasure[i][j]) && !measures.opMeasure[i][j].equals(""))
                        
                
                }
                if(flag==0 && !measures.opMeasure[i][j].equals(""))
                {  opaddup[i][coun]=measures.opMeasure[i][j];
                            opaddup[i][coun+1]=measures.opMeasure[i][j+1];
                            opaddup[i][coun+2]=measures.opMeasure[i][j+2];
                            if(measures.opMeasure[i][j+3].equals("Yes"))
                            {
                                opaddup[i][coun+3]="1";
                            }
                            else
                            {
                                opaddup[i][coun+3]="0";
                            coun+=4;
                            }
                          
                        }
            }
        }
        
        
        for(int i=0;i<opaddup.length;i++)
        {
            for(int j=0;j<opaddup[0].length;j++)
            {
                //System.out.println(opaddup[i][j]);
            }
        }
        
        
        if(relator.length==5)
        {
            relator[0][0]="H1";
            relator[1][0]="V1";
            relator[2][0]="D";
            relator[3][0]="H2";
            relator[4][0]="V2";
        }
        else
        {
            relator[0][0]="H1";
            relator[1][0]="V1";
            relator[2][0]="D";
            
        }
        
        
        
        
        for(int i=0;i<relator.length;i++)
        {   for(int j=0;j<relator[0].length;j++)
        {   if(relator[i][j]==null)
            {
                relator[i][j]="";
            }
        }
        }
        
        for(int i=0;i<finale.length;i++)
        {   for(int j=0;j<finale[0].length;j++)
        {   if(finale[i][j]==null)
            {
                finale[i][j]="";
            }
        }
        }
        
        
        
        //GENERATE H1
        int count=1;
        for(int i=0;i<addup.length;i++)
        {  
               
            for(int j=0;j<addup[0].length;j++)
            {
                int k=1;
                if((addup[i][0].substring(1,2).equals("1"))&&(j-2)%4==0)
                {   int flag=0;
                    //System.out.println(relator[0][k]+" "+addup[i][j]);
                   for(k=1;k<relator[0].length;k++)
                    {
                        if(relator[0][k].equals(addup[i][j]) && !addup[i][j].equals(""))
                        {   //System.out.println("ENTRARE");
                            flag=1;
                            relator[0][k]=addup[i][j];
                         ////System.out.println("J VALUE GOING IN"+addup[i][0]+" "+j+" "+addup[i][j]);   
                        int inch=Integer.parseInt(relator[0][k+1])+Integer.parseInt(addup[i][j+1]);
                        relator[0][k+1]="";
                        relator[0][k+1]+=inch;
                        
                        inch=(Integer.parseInt(relator[0][k+2])+Integer.parseInt(addup[i][j+2]));
                        relator[0][k+2]="";
                        relator[0][k+2]+=inch;
                        
                        
                        int nocom=Integer.parseInt(addup[i][j+3]);
                        
                        if(nocom>0)
                        {//System.out.println(nocom);
                        inch=Integer.parseInt(relator[0][k+3]);
                        inch=inch+nocom;
                        relator[0][k+3]="";
                        relator[0][k+3]+=inch;
                        }
                        //System.out.println("Repeated VALUES"+" "+addup[i][0]+" "+relator[0][k]+" "+relator[0][k+1]+" "+relator[0][k+2]+" "+relator[0][k+3]+" "+k);
                        }
                        
                        
                    }
                   if(!addup[i][j].equals("")&& flag==0)
                            {
                                relator[0][count]=addup[i][j];
                            
                                int inch=Integer.parseInt(addup[i][j+1]);
                                relator[0][count+1]="";
                                relator[0][count+1]+=inch;
                                
                        
                                inch=+Integer.parseInt(addup[i][j+2]);
                                relator[0][count+2]="";
                                relator[0][count+2]+=inch;
                                System.out.println("I PUUTY HEA!"+inch);
                                
                                
                                    relator[0][count+3]=addup[i][j+3];
                                
                        
                                
                                //System.out.println("PUT IN VALUES"+" "+addup[i][0]+" "+relator[0][count]+" "+relator[0][count+1]+" "+relator[0][count+2]+" "+relator[0][count+3]+" "+count);
                                count+=4;
                            }
                }
        
            }
        }
        
        
        
        //GENERATE H2
        if(relator.length==5)
        {
        count=1;
        for(int i=0;i<addup.length;i++)
        {  
               
            for(int j=0;j<addup[0].length;j++)
            {
                int k=1;
                if((addup[i][0].substring(1,2).equals("2"))&&(j-2)%4==0)
                {   int flag=0;
                    //System.out.println(relator[3][k]+" "+addup[i][j]);
                   for(k=1;k<relator[3].length;k++)
                    {
                        if(relator[3][k].equals(addup[i][j]) && !addup[i][j].equals(""))
                        {   //System.out.println("ENTRARE");
                            flag=1;
                            relator[3][k]=addup[i][j];
                         ////System.out.println("J VALUE GOING IN"+addup[i][0]+" "+j+" "+addup[i][j]);   
                        int inch=Integer.parseInt(relator[3][k+1])+Integer.parseInt(addup[i][j+1]);
                        relator[3][k+1]="";
                        relator[3][k+1]+=inch;
                        
                        inch=(Integer.parseInt(relator[3][k+2])+Integer.parseInt(addup[i][j+2]));
                        relator[3][k+2]="";
                        relator[3][k+2]+=inch;
                        
                        
                        int nocom=Integer.parseInt(addup[i][j+3]);
                        
                        if(nocom>0)
                        {//System.out.println(nocom);
                        inch=Integer.parseInt(relator[3][k+3]);
                        inch=inch+nocom;
                        relator[3][k+3]="";
                        relator[3][k+3]+=inch;
                        }
                        //System.out.println("Repeated VALUES"+" "+addup[i][0]+" "+relator[3][k]+" "+relator[3][k+1]+" "+relator[3][k+2]+" "+relator[3][k+3]+" "+k);
                        }
                        
                        
                    }
                   if(!addup[i][j].equals("")&& flag==0)
                            {
                                relator[3][count]=addup[i][j];
                            
                                int inch=Integer.parseInt(addup[i][j+1]);
                                relator[3][count+1]="";
                                relator[3][count+1]+=inch;
                        
                                inch=+Integer.parseInt(addup[i][j+2]);
                                relator[3][count+2]="";
                                relator[3][count+2]+=inch;
                                
                                
                                
                                    relator[3][count+3]=addup[i][j+3];
                                
                        
                                
                                //System.out.println("PUT IN VALUES"+" "+addup[i][0]+" "+relator[3][count]+" "+relator[3][count+1]+" "+relator[3][count+2]+" "+relator[3][count+3]+" "+count);
                                count+=4;
                            }
                }
        
            }
        }
        }
        
        //GENERATE V1
       // if(relator.length==5)
        //{
        count=1;
        for(int i=0;i<addup.length;i++)
        {  
               
            for(int j=0;j<addup[0].length;j++)
            {
                int k=1;
                if((addup[i][0].substring(2,3).equals("1"))&&(j-2)%4==0)
                {   int flag=0;
                    //System.out.println(relator[1][k]+" "+addup[i][j]);
                   for(k=1;k<relator[1].length;k++)
                    {
                        if(relator[1][k].equals(addup[i][j]) && !addup[i][j].equals(""))
                        {   //System.out.println("ENTRARE");
                            flag=1;
                            relator[1][k]=addup[i][j];
                         ////System.out.println("J VALUE GOING IN"+addup[i][0]+" "+j+" "+addup[i][j]);   
                        int inch=Integer.parseInt(relator[1][k+1])+Integer.parseInt(addup[i][j+1]);
                        relator[1][k+1]="";
                        relator[1][k+1]+=inch;
                        
                        inch=(Integer.parseInt(relator[1][k+2])+Integer.parseInt(addup[i][j+2]));
                        relator[1][k+2]="";
                        relator[1][k+2]+=inch;
                        
                        
                        int nocom=Integer.parseInt(addup[i][j+3]);
                        
                        if(nocom>0)
                        {//System.out.println(nocom);
                        inch=Integer.parseInt(relator[1][k+3]);
                        inch=inch+nocom;
                        relator[1][k+3]="";
                        relator[1][k+3]+=inch;
                        }
                        //System.out.println("Repeated VALUES"+" "+addup[i][0]+" "+relator[1][k]+" "+relator[1][k+1]+" "+relator[1][k+2]+" "+relator[1][k+3]+" "+k);
                        }
                        
                        
                    }
                   if(!addup[i][j].equals("")&& flag==0)
                            {
                                relator[1][count]=addup[i][j];
                            
                                int inch=Integer.parseInt(addup[i][j+1]);
                                relator[1][count+1]="";
                                relator[1][count+1]+=inch;
                        
                                inch=+Integer.parseInt(addup[i][j+2]);
                                relator[1][count+2]="";
                                relator[1][count+2]+=inch;
                                
                                
                                
                                    relator[1][count+3]=addup[i][j+3];
                                
                        
                                
                                //System.out.println("PUT IN VALUES"+" "+addup[i][0]+" "+relator[1][count]+" "+relator[1][count+1]+" "+relator[1][count+2]+" "+relator[1][count+3]+" "+count);
                                count+=4;
                            }
                }
        
            }
        }
        
        //}
        //GENERATE V2
        
        if(relator.length==5)
        {
        count=1;
        for(int i=0;i<addup.length;i++)
        {  
               
            for(int j=0;j<addup[0].length;j++)
            {
                int k=1;
                if((addup[i][0].substring(2,3).equals("2"))&&(j-2)%4==0)
                {   int flag=0;
                    //System.out.println(relator[4][k]+" "+addup[i][j]);
                   for(k=1;k<relator[4].length;k++)
                    {
                        if(relator[4][k].equals(addup[i][j]) && !addup[i][j].equals(""))
                        {   //System.out.println("ENTRARE");
                            flag=1;
                            relator[4][k]=addup[i][j];
                         ////System.out.println("J VALUE GOING IN"+addup[i][0]+" "+j+" "+addup[i][j]);   
                        int inch=Integer.parseInt(relator[4][k+1])+Integer.parseInt(addup[i][j+1]);
                        relator[4][k+1]="";
                        relator[4][k+1]+=inch;
                        
                        inch=(Integer.parseInt(relator[4][k+2])+Integer.parseInt(addup[i][j+2]));
                        relator[4][k+2]="";
                        relator[4][k+2]+=inch;
                        
                        
                        int nocom=Integer.parseInt(addup[i][j+3]);
                        
                        if(nocom>0)
                        {//System.out.println(nocom);
                        inch=Integer.parseInt(relator[4][k+3]);
                        inch=inch+nocom;
                        relator[4][k+3]="";
                        relator[4][k+3]+=inch;
                        }
                        //System.out.println("Repeated VALUES"+" "+addup[i][0]+" "+relator[4][k]+" "+relator[4][k+1]+" "+relator[4][k+2]+" "+relator[4][k+3]+" "+k);
                        }
                        
                        
                    }
                   if(!addup[i][j].equals("")&& flag==0)
                            {
                                relator[4][count]=addup[i][j];
                            
                                int inch=Integer.parseInt(addup[i][j+1]);
                                relator[4][count+1]="";
                                relator[4][count+1]+=inch;
                        
                                inch=+Integer.parseInt(addup[i][j+2]);
                                relator[4][count+2]="";
                                relator[4][count+2]+=inch;
                                
                                
                                
                                    relator[4][count+3]=addup[i][j+3];
                                
                        
                                
                                //System.out.println("PUT IN VALUES"+" "+addup[i][0]+" "+relator[4][count]+" "+relator[4][count+1]+" "+relator[4][count+2]+" "+relator[4][count+3]+" "+count);
                                count+=4;
                            }
                }
        
            }
        }
        }
        
        //GENERATE D
       // if(relator.length==5)
        //{
        count=1;
        for(int i=0;i<addup.length;i++)
        {
            for(int j=0;j<addup[0].length;j++)
            {int k=1;
                String v,v1;
                String addd="";
                addd+=addup.length;
                if(relator.length==5)
                {
                v="31";
                v1="22";
                
                }
                else
                {
                v="21";
                v1="12";
                }
                
                StringBuffer sb=new StringBuffer(v);
                sb=sb.reverse();
                String sv=sb.toString();
                if(((addup[i][0].substring(1,3).equals(v)) || (addup[i][0].substring(1,3).equals(v1)) || (addup[i][0].substring(1,3).equals(sv)) )&& (j-2)%4==0)
                {   int flag=0;
                   for(k=1;k<relator[2].length;k++)
                    {
                        if(relator[2][k].equals(addup[i][j]) && !addup[i][j].equals(""))
                        {   flag=1;
                            relator[2][k]=addup[i][j];
                         ////System.out.println("J VALUE GOING IN"+addup[i][0]+" "+j+" "+addup[i][j]);   
                        int inch=Integer.parseInt(relator[2][k+1])+Integer.parseInt(addup[i][j+1]);
                        relator[2][k+1]="";
                        relator[2][k+1]+=inch;
                        
                        inch=(Integer.parseInt(relator[2][k+2])+Integer.parseInt(addup[i][j+2]));
                        relator[2][k+2]="";
                        relator[2][k+2]+=inch;
                        
                        
                        int nocom=Integer.parseInt(addup[i][j+3]);
                        
                        if(nocom>0)
                        {//System.out.println(nocom);
                        inch=Integer.parseInt(relator[2][k+3]);
                        inch=inch+nocom;
                        relator[2][k+3]="";
                        relator[2][k+3]+=inch;
                        }
                        //System.out.println("Repeated VALUES"+" "+addup[i][0]+relator[2][k]+" "+relator[2][k+1]+" "+relator[2][k+2]+" "+relator[2][k+3]);
                        }
                        
                        
                    }
                   if(!addup[i][j].equals("")&& flag==0)
                            {
                                relator[2][count]=addup[i][j];
                            
                                int inch=Integer.parseInt(addup[i][j+1]);
                                relator[2][count+1]="";
                                relator[2][count+1]+=inch;
                        
                                inch=+Integer.parseInt(addup[i][j+2]);
                                relator[2][count+2]="";
                                relator[2][count+2]+=inch;
                                
                                
                                
                                    relator[2][count+3]=addup[i][j+3];
                                
                        
                                
                                //System.out.println("PUT IN VALUES"+" "+addup[i][0]+" "+relator[2][count]+" "+relator[2][count+1]+" "+relator[2][count+2]+" "+relator[2][count+3]);
                                count+=4;
                            }
                }
        
            }
        }
        
        
        
        
        
        for(int ip=0;ip<relator[0].length;ip++)
                {
                    //System.out.println(relator[0][ip]+" ");
                }

        for(int ip=0;ip<relator[0].length;ip++)
                {
                    //System.out.println(relator[1][ip]+" ");
                }
        
        for(int ip=0;ip<relator[0].length;ip++)
                {
                    //System.out.println(relator[2][ip]+" ");
                }
        
        if(relator.length==5)
        {for(int ip=0;ip<relator[0].length;ip++)
                {
                    //System.out.println(relator[3][ip]+" ");
                }
        
        
        for(int ip1=0;ip1<relator[0].length;ip1++)
                {
                    //System.out.println(relator[4][ip1]+" ");
                }
        }
    
        finale[0][0]="H3";
        finale[1][0]="V3";
        finale[2][0]="D3";
        //GENERATE H3
        
        count=1;
        for(int i=0;i<addup.length;i++)
        {  
               
            for(int j=0;j<addup[0].length;j++)
            {
                int k=1;
                if((addup[i][0].substring(1,2).equals(addup[addup.length-1][0].substring(1,2)))&&(j-2)%4==0)
                {   int flag=0;
                    //System.out.println(finale[0][k]+" "+addup[i][j]);
                   for(k=1;k<finale[0].length;k++)
                    {
                        if(finale[0][k].equals(addup[i][j]) && !addup[i][j].equals(""))
                        {   //System.out.println("ENTRARE");
                            flag=1;
                            finale[0][k]=addup[i][j];
                         ////System.out.println("J VALUE GOING IN"+addup[i][0]+" "+j+" "+addup[i][j]);   
                        int inch=Integer.parseInt(finale[0][k+1])+Integer.parseInt(addup[i][j+1]);
                        finale[0][k+1]="";
                        finale[0][k+1]+=inch;
                        
                        inch=(Integer.parseInt(finale[0][k+2])+Integer.parseInt(addup[i][j+2]));
                        finale[0][k+2]="";
                        finale[0][k+2]+=inch;
                        
                        
                        int nocom=Integer.parseInt(addup[i][j+3]);
                        
                        if(nocom>0)
                        {//System.out.println(nocom);
                        inch=Integer.parseInt(finale[0][k+3]);
                        inch=inch+nocom;
                        finale[0][k+3]="";
                        finale[0][k+3]+=inch;
                        }
                        //System.out.println("Repeated VALUES"+" "+addup[i][0]+" "+finale[0][k]+" "+finale[0][k+1]+" "+finale[0][k+2]+" "+finale[0][k+3]+" "+k);
                        }
                        
                        
                    }
                   if(!addup[i][j].equals("")&& flag==0)
                            {
                                finale[0][count]=addup[i][j];
                            
                                int inch=Integer.parseInt(addup[i][j+1]);
                                finale[0][count+1]="";
                                finale[0][count+1]+=inch;
                        
                                inch=+Integer.parseInt(addup[i][j+2]);
                                finale[0][count+2]="";
                                finale[0][count+2]+=inch;
                                
                                
                                
                                    finale[0][count+3]=addup[i][j+3];
                                
                        
                                
                                //System.out.println("PUT IN VALUES"+" "+addup[i][0]+" "+finale[0][count]+" "+finale[0][count+1]+" "+finale[0][count+2]+" "+finale[0][count+3]+" "+count);
                                count+=4;
                            }
                }
        
            }
        }
        
        
        //GENERATE V3
       // if(relator.length==5)
        //{
        count=1;
        for(int i=0;i<addup.length;i++)
        {  
               
            for(int j=0;j<addup[0].length;j++)
            {
                int k=1;
                if((addup[i][0].substring(2,3).equals(addup[addup.length-1][0].substring(1,2)))&&(j-2)%4==0)
                {   int flag=0;
                    //System.out.println(finale[1][k]+" "+addup[i][j]);
                   for(k=1;k<finale[1].length;k++)
                    {
                        if(finale[1][k].equals(addup[i][j]) && !addup[i][j].equals(""))
                        {   //System.out.println("ENTRARE");
                            flag=1;
                            finale[1][k]=addup[i][j];
                         ////System.out.println("J VALUE GOING IN"+addup[i][0]+" "+j+" "+addup[i][j]);   
                        int inch=Integer.parseInt(finale[1][k+1])+Integer.parseInt(addup[i][j+1]);
                        finale[1][k+1]="";
                        finale[1][k+1]+=inch;
                        
                        inch=(Integer.parseInt(finale[1][k+2])+Integer.parseInt(addup[i][j+2]));
                        finale[1][k+2]="";
                        finale[1][k+2]+=inch;
                        
                        
                        int nocom=Integer.parseInt(addup[i][j+3]);
                        
                        if(nocom>0)
                        {//System.out.println(nocom);
                        inch=Integer.parseInt(finale[1][k+3]);
                        inch=inch+nocom;
                        finale[1][k+3]="";
                        finale[1][k+3]+=inch;
                        }
                        //System.out.println("Repeated VALUES"+" "+addup[i][0]+" "+finale[1][k]+" "+finale[1][k+1]+" "+finale[1][k+2]+" "+finale[1][k+3]+" "+k);
                        }
                        
                        
                    }
                   if(!addup[i][j].equals("")&& flag==0)
                            {
                                finale[1][count]=addup[i][j];
                            
                                int inch=Integer.parseInt(addup[i][j+1]);
                                finale[1][count+1]="";
                                finale[1][count+1]+=inch;
                        
                                inch=+Integer.parseInt(addup[i][j+2]);
                                finale[1][count+2]="";
                                finale[1][count+2]+=inch;
                                
                                
                                
                                    finale[1][count+3]=addup[i][j+3];
                                
                        
                                
                                //System.out.println("PUT IN VALUES"+" "+addup[i][0]+" "+finale[1][count]+" "+finale[1][count+1]+" "+finale[1][count+2]+" "+finale[1][count+3]+" "+count);
                                count+=4;
                            }
                }
            }
        }
        
        //GENERATE D3
       // if(relator.length==5)
        //{
        count=1;
        for(int i=0;i<addup.length;i++)
        {  
               
            for(int j=0;j<addup[0].length;j++)
            {
                int k=1;
                if((addup[i][0].substring(1,2).equals(addup[i][0].substring(2,3)))&&(j-2)%4==0)
                {   int flag=0;
                    //System.out.println(finale[2][k]+" "+addup[i][j]);
                   for(k=1;k<finale[2].length;k++)
                    {
                        if(finale[2][k].equals(addup[i][j]) && !addup[i][j].equals(""))
                        {   //System.out.println("ENTRARE");
                            flag=1;
                            finale[2][k]=addup[i][j];
                         ////System.out.println("J VALUE GOING IN"+addup[i][0]+" "+j+" "+addup[i][j]);   
                        int inch=Integer.parseInt(finale[2][k+1])+Integer.parseInt(addup[i][j+1]);
                        finale[2][k+1]="";
                        finale[2][k+1]+=inch;
                        
                        inch=(Integer.parseInt(finale[2][k+2])+Integer.parseInt(addup[i][j+2]));
                        finale[2][k+2]="";
                        finale[2][k+2]+=inch;
                        
                        
                        int nocom=Integer.parseInt(addup[i][j+3]);
                        
                        if(nocom>0)
                        {//System.out.println(nocom);
                        inch=Integer.parseInt(finale[2][k+3]);
                        inch=inch+nocom;
                        finale[2][k+3]="";
                        finale[2][k+3]+=inch;
                        }
                        //System.out.println("Repeated VALUES"+" "+addup[i][0]+" "+finale[2][k]+" "+finale[2][k+1]+" "+finale[2][k+2]+" "+finale[2][k+3]+" "+k);
                        }
                        
                        
                    }
                   if(!addup[i][j].equals("")&& flag==0)
                            {
                                finale[2][count]=addup[i][j];
                            
                                int inch=Integer.parseInt(addup[i][j+1]);
                                finale[2][count+1]="";
                                finale[2][count+1]+=inch;
                        
                                inch=+Integer.parseInt(addup[i][j+2]);
                                finale[2][count+2]="";
                                finale[2][count+2]+=inch;
                                
                                
                                
                                    finale[2][count+3]=addup[i][j+3];
                                
                        
                                
                                //System.out.println("PUT IN VALUES"+" "+addup[i][0]+" "+finale[2][count]+" "+finale[2][count+1]+" "+finale[2][count+2]+" "+finale[2][count+3]+" "+count);
                                count+=4;
                            }
                }
            }
        }
                
                
                for(int ip=0;ip<finale[0].length;ip++)
                {
                    //System.out.println(finale[0][ip]+" ");
                }
        
        
        for(int ip1=0;ip1<finale[0].length;ip1++)
                {
                    //System.out.println(finale[1][ip1]+" ");
                }
        for(int ip1=0;ip1<finale[0].length;ip1++)
                {
                    //System.out.println(finale[2][ip1]+" ");
                }
        
        
        finans=new String[3*opaddup.length][finale[0].length];
        
        for(int i=0;i<finans.length;i++)
        {   for(int j=0;j<finans[0].length;j++)
        {   if(finans[i][j]==null)
            {
                finans[i][j]="";
            }
        }
        }
        
        //System.out.println("MAGICCCCCCCCCCCCCCCC");
        //System.out.println( Arrays.toString( opaddup[0]) );
        
        //THIS IS WHERE THE LOOP STARTS
        for(int v=0;v<opaddup.length;v++)
        {
        System.arraycopy(opaddup[v], 0, finale[3], 0, opaddup[v].length);

        count=1;
        for(int i=1;i<finale[0].length;i=i+4)
        { 
            int flag=0;
            for(int k=2;k<finale[0].length;k=k+4)
             {  //System.out.println("I D3 VAL"+finale[0][i]+" "+finale[3][k]);
                if(finale[0][i].equals(finale[3][k]) && !finale[0][i].equals(""))
                {   
                    ////System.out.println("Values Duplicate"+" "+finale[0][i]+" "+finale[3][k]);
                    
                    flag=1;
                    ////System.out.println(finale[0][i]+" "+finale[0][i+1]+" "+finale[0][i+2]+" "+finale[0][i+3]+" "+finale[3][k]+" "+finale[3][k+1]+" "+finale[3][k+2]+" "+finale[3][k+3]);
                    int xx=Integer.parseInt(finale[3][k+1])+Integer.parseInt(finale[0][i+1]);
                    finale[3][k+1]="";
                    finale[3][k+1]+=xx;
                    
                    int inch=(Integer.parseInt(finale[3][k+2])+Integer.parseInt(finale[0][i+2]));
                        finale[3][k+2]="";
                        finale[3][k+2]+=inch;
                    
                    int nocom=Integer.parseInt(finale[0][i+3]);
                        
                        if(nocom>0)
                        {//System.out.println(nocom);
                        inch=Integer.parseInt(finale[3][k+3]);
                        inch=inch+nocom;
                        finale[3][k+3]="";
                        finale[3][k+3]+=inch;
                        }
                //System.out.println("Y");
                }
                }
                if(flag==0 && !finale[0][i].equals(""))
                {   
                    ////System.out.println(finale[0][i]+" "+count);
                     //System.out.println( Arrays.toString( finale[3]) );
                    while(!finale[3][count].equals(""))
                    {count++;
                    }
                                finale[3][count]=finale[0][i];
                                
                                int inch=Integer.parseInt(finale[0][i+1]);
                                finale[3][count+1]="";
                                finale[3][count+1]+=inch;
                        
                                inch=+Integer.parseInt(finale[0][i+2]);
                                finale[3][count+2]="";
                                finale[3][count+2]+=inch;
                                
                                
                                
                                finale[3][count+3]=finale[0][i+3];
                                count+=4; 
                                //k=finale[0].length-1;
                 }
            
        }
        System.arraycopy(finale[3], 0, finans[3*v], 0, finale[0].length);
        finans[3*v][0]+="H";
        for(int i=0;i<finale[0].length;i++)
        {
            finale[3][i]="";
        }
        
        
        System.arraycopy(opaddup[v], 0, finale[3], 0, opaddup[v].length);
        
        //System.out.println( Arrays.toString( finans[0]) );
        //System.out.println("INITIAL VALUE");
        //System.out.println( Arrays.toString( finale[3]) );
        count=1;
        for(int i=1;i<finale[1].length;i=i+4)
        { 
            int flag=0;
            for(int k=2;k<finale[1].length;k=k+4)
             {  //System.out.println("I D3 VAL"+finale[1][i]+" "+finale[3][k]);
                if(finale[1][i].equals(finale[3][k]) && !finale[1][i].equals(""))
                {   
                    ////System.out.println("Values Duplicate"+" "+finale[1][i]+" "+finale[3][k]);
                    
                    flag=1;
                    ////System.out.println(finale[1][i]+" "+finale[1][i+1]+" "+finale[1][i+2]+" "+finale[1][i+3]+" "+finale[3][k]+" "+finale[3][k+1]+" "+finale[3][k+2]+" "+finale[3][k+3]);
                    int xx=Integer.parseInt(finale[3][k+1])+Integer.parseInt(finale[1][i+1]);
                    finale[3][k+1]="";
                    finale[3][k+1]+=xx;
                    
                    int inch=(Integer.parseInt(finale[3][k+2])+Integer.parseInt(finale[1][i+2]));
                        finale[3][k+2]="";
                        finale[3][k+2]+=inch;
                    
                    int nocom=Integer.parseInt(finale[1][i+3]);
                        
                        if(nocom>0)
                        {//System.out.println(nocom);
                        inch=Integer.parseInt(finale[3][k+3]);
                        inch=inch+nocom;
                        finale[3][k+3]="";
                        finale[3][k+3]+=inch;
                        }
                //System.out.println("Y");
                }
                }
                if(flag==0 && !finale[1][i].equals(""))
                {   
                    ////System.out.println(finale[1][i]+" "+count);
                     //System.out.println( Arrays.toString( finale[3]) );
                    while(!finale[3][count].equals(""))
                    {count++;
                    }
                                finale[3][count]=finale[1][i];
                                
                                int inch=Integer.parseInt(finale[1][i+1]);
                                finale[3][count+1]="";
                                finale[3][count+1]+=inch;
                        
                                inch=+Integer.parseInt(finale[1][i+2]);
                                finale[3][count+2]="";
                                finale[3][count+2]+=inch;
                                
                                
                                
                                finale[3][count+3]=finale[1][i+3];
                                count+=4; 
                                //k=finale[1].length-1;
                 }
            
        }
    
        System.arraycopy(finale[3], 0, finans[3*v+1], 0, finale[0].length);
        finans[3*v+1][0]+="V";
        
        for(int i=0;i<finale[0].length;i++)
        {
            finale[3][i]="";
        }
        
        System.arraycopy(opaddup[v], 0, finale[3], 0, opaddup[v].length);
        
        count=1;
        for(int i=1;i<finale[2].length;i=i+4)
        { 
            int flag=0;
            for(int k=2;k<finale[2].length;k=k+4)
             {  //System.out.println("I D3 VAL"+finale[2][i]+" "+finale[3][k]);
                if(finale[2][i].equals(finale[3][k]) && !finale[2][i].equals(""))
                {   
                    ////System.out.println("Values Duplicate"+" "+finale[2][i]+" "+finale[3][k]);
                    
                    flag=1;
                    ////System.out.println(finale[2][i]+" "+finale[2][i+1]+" "+finale[2][i+2]+" "+finale[2][i+3]+" "+finale[3][k]+" "+finale[3][k+1]+" "+finale[3][k+2]+" "+finale[3][k+3]);
                    int xx=Integer.parseInt(finale[3][k+1])+Integer.parseInt(finale[2][i+1]);
                    finale[3][k+1]="";
                    finale[3][k+1]+=xx;
                    
                    int inch=(Integer.parseInt(finale[3][k+2])+Integer.parseInt(finale[2][i+2]));
                        finale[3][k+2]="";
                        finale[3][k+2]+=inch;
                    
                    int nocom=Integer.parseInt(finale[2][i+3]);
                        
                        if(nocom>0)
                        {//System.out.println(nocom);
                        inch=Integer.parseInt(finale[3][k+3]);
                        inch=inch+nocom;
                        finale[3][k+3]="";
                        finale[3][k+3]+=inch;
                        }
                //System.out.println("Y");
                }
                }
                if(flag==0 && !finale[2][i].equals(""))
                {   
                    ////System.out.println(finale[2][i]+" "+count);
                     //System.out.println( Arrays.toString( finale[3]) );
                    while(!finale[3][count].equals(""))
                    {count++;
                    }
                                finale[3][count]=finale[2][i];
                                
                                int inch=Integer.parseInt(finale[2][i+1]);
                                finale[3][count+1]="";
                                finale[3][count+1]+=inch;
                        
                                inch=+Integer.parseInt(finale[2][i+2]);
                                finale[3][count+2]="";
                                finale[3][count+2]+=inch;
                                
                                
                                
                                finale[3][count+3]=finale[2][i+3];
                                count+=4; 
                                //k=finale[2].length-1;
                 }
            
        }
     System.arraycopy(finale[3], 0, finans[3*v+2], 0, finale[0].length);
     finans[3*v+2][0]+="D";
     
    }
    //THIS IS FOR THE LOOP
    
    
     //System.out.println("FSFAFAFA");
     for(int i=0;i<finans.length;i++)
     {   //System.out.println(i);
         for(int j=0;j<finans[0].length;j++)
         {
            // System.out.println(finans[i][j]);
         }
     }

    }
}

class score
{
    String[] man=new String[relations.relator[0].length];
    String[] man1=new String[relations.finans[0].length];
    String[][] relat=relations.relator;
    String[][] fina=relations.finans;
    
    public void scorer()
    {
        for(int i=0;i<relations.relator.length;i++)
        {
            System.out.println( Arrays.toString( relations.relator[i]) );
        }
        
        for(int i=0;i<relations.finans.length;i++)
        {
            //System.out.println( Arrays.toString( relations.finans[i]) );
        }
        int mul=0;
        if(relat.length==5)
        {
            mul=3;
        }    
        else
        {
            mul=2;
        }
        
        int finalscore[]=new int[fina.length];
        //Calculate Hscore
        System.arraycopy(relat[0], 0, man, 0, relat[0].length);
        for(int i=0;i<man.length;i++)
        {
            if (man[i]==null)
            {
                man[i]="";
            }
        }
        //System.out.println( "MAN "+Arrays.toString( man) );
        //System.arraycopy(fina[6], 0, man1, 0, relat.length);
        for(int b=0;b<fina.length;b=b+3)
        {
        int hscore=0;
        for(int i=3;i<fina[b].length;i=i+4)
        {   
            for(int j=2;j<man.length;j=j+4)
            {   if(!man[j].equals("") && !fina[b][i].equals(""))
            {   
                //System.out.println(Integer.parseInt(man[j+2])*relat.length+" "+fina[b][i+2]);
               //System.out.println(man[j]+" "+man[j+1]+" "+man[j+2]+" "+fina[b][i]+" "+fina[b][i+1]+" "+fina[b][i+2]+" ");
                //hscore-=Math.abs(Integer.parseInt(man[j])-Integer.parseInt(fina[b][i]));
                if((Math.abs(Integer.parseInt(man[j])-(Integer.parseInt(fina[b][i])))<2) && man[j+1].equals(fina[b][i+1]))
                { //
                hscore+=100;
                if(fina[b][i-1].equals(man[j-1]))
                {
                    hscore+=1;
                }
                else
                {
                    hscore--;
                }
                fina[b][i]="";
                fina[1][i+1]="";
                fina[2][i+2]="";
                
                
                }
                else 
                {   //System.out.println(man[j+2]+" "+fina[b][i+2]);
                    if(!man[j+2].equals("0"))
                    {   
                        if(Integer.parseInt(fina[b][i+2])==Integer.parseInt(man[j+2])*mul ||(man[j+2].equals(fina[b][i+2])))
                        {
                            hscore+=2;
                        }
                        else
                    
                    if(man[j+1].equals(fina[b][i+1]))        
                    {
                        hscore+=2;
                    }
                    else if(Math.abs(Integer.parseInt(man[j+1])) == Math.abs(Integer.parseInt(fina[b][i+1])))   
                    {
                        hscore+=2;
                    }
                            
                            
                    if((man[j+2].equals(fina[b][i+2])))
                    {
                    hscore+=10;
                    }
                    }
                    
                    }
                    }
            }
            
        }
        finalscore[b]=hscore;
        //System.out.println(hscore);
    }
    
        //Calculate VScore
        System.arraycopy(relat[1], 0, man, 0, relat[0].length);
        for(int i=0;i<man.length;i++)
        {
            if (man[i]==null)
            {
                man[i]="";
            }
        }
        //System.out.println( "MAN "+Arrays.toString( man) );
        //System.arraycopy(, 0, man1, 0, relat.length);
        for(int b=1;b<fina.length;b=b+3)
        {
        int vscore=0;
        for(int i=3;i<fina[b].length;i=i+4)
        {   
            for(int j=2;j<man.length;j=j+4)
            {   if(!man[j].equals("") && !fina[b][i].equals(""))
            {   
                //System.out.println(Integer.parseInt(man[j+2])*relat.length+" "+fina[b][i+2]);
               //System.out.println(man[j]+" "+man[j+1]+" "+man[j+2]+" "+fina[b][i]+" "+fina[b][i+1]+" "+fina[b][i+2]+" ");
                //hscore-=Math.abs(Integer.parseInt(man[j])-Integer.parseInt(fina[b][i]));
                
                if((Math.abs(Integer.parseInt(man[j])-(Integer.parseInt(fina[b][i])))<2) && man[j+1].equals(fina[b][i+1]) && (man[j+2].equals(fina[b][i+2])))
                {
                vscore+=200;
                if(fina[b][i-1].equals(man[j-1]))
                {
                    vscore+=1;
                }
                else
                {
                    vscore--;
                }
                fina[b][i]="";
                fina[1][i+1]="";
                fina[2][i+2]="";
                }
                else 
                {   //System.out.println(man[j+2]+" "+fina[b][i+2]);
                    if(!man[j+2].equals("0"))
                    {   
                        if(Integer.parseInt(fina[b][i+2])==Integer.parseInt(man[j+2])*mul ||(man[j+2].equals(fina[b][i+2])))
                        {
                           vscore+=2;
                        }
                        else
                            
                    
                    if((man[j+2].equals(fina[b][i+2])))
                    {
                    vscore+=10;
                    }
                    }
                    
                    }
                    }
            }
            
        }
        finalscore[b]=vscore;
        //System.out.println(vscore);
    }
    
        //Calculate DScore
        System.arraycopy(relat[2], 0, man, 0, relat[0].length);
        for(int i=0;i<man.length;i++)
        {
            if (man[i]==null)
            {
                man[i]="";
            }
        }
        //System.out.println( "MAN "+Arrays.toString( man) );
        //System.arraycopy(, 0, man1, 0, relat.length);
        for(int b=2;b<fina.length;b=b+3)
        {
        int dscore=0;
        for(int i=3;i<fina[b].length;i=i+4)
        {   
            for(int j=2;j<man.length;j=j+4)
            {   if(!man[j].equals("") && !fina[b][i].equals(""))
            {   
                //System.out.println(Integer.parseInt(man[j+2])*relat.length+" "+fina[b][i+2]);
               //System.out.println(man[j]+" "+man[j+1]+" "+man[j+2]+" "+fina[b][i]+" "+fina[b][i+1]+" "+fina[b][i+2]+" ");
                //hscore-=Math.abs(Integer.parseInt(man[j])-Integer.parseInt(fina[b][i]));
                if((Math.abs(Integer.parseInt(man[j])-(Integer.parseInt(fina[b][i])))<2) && man[j+1].equals(fina[b][i+1]) && (man[j+2].equals(fina[b][i+2])))
                {
                dscore+=100;
                if(fina[b][i-1].equals(man[j-1]))
                {
                    dscore+=1;
                }
                else
                {
                    dscore-=200;
                }
                fina[b][i]="";
                fina[1][i+1]="";
                fina[2][i+2]="";
                }
                 
                {   //System.out.println(man[j+2]+" "+fina[b][i+2]);
                    
                    if(!man[j+2].equals("0")&&man[j+2].equals(""))
                    {   
                        if(Integer.parseInt(fina[b][i+2])==Integer.parseInt(man[j+2])*mul ||(man[j+2].equals(fina[b][i+2])))
                        {
                           dscore+=2;
                        }
                        else
                            
                   
                        
                    if((man[j+2].equals(fina[b][i+2])))
                    {
                    dscore+=10;
                    }
                    }
                    
                    }
                    }
            }
        }
        finalscore[b]=dscore;
        //System.out.println(dscore);
    }
                
    
        System.out.println( "finale!!! "+Arrays.toString(finalscore) );
    //System.out.println(relat.length);
    
    int maxval=0;
    int maxpos=0;
    for(int i=0;i<finalscore.length;i=i+3)
    {   if(relations.relator.length==5)
        {
            if(finalscore[i]+finalscore[i+1]+finalscore[i+2]>=maxval)
            {
                maxval=finalscore[i]+finalscore[i+1]+finalscore[i+2];
                maxpos=i;
                //System.out.println(maxval);
            }
        }
        else
        {
            if(finalscore[i]>=maxval)
            {
                maxval=finalscore[i];
                maxpos=i;
                //System.out.println(maxval);
            }
        }
    
    
    
    }
    
    //System.out.println((maxpos/3)+1);
    int cc=(maxpos/3)+1;
    String anse="Answer of Problem "+readfile.bx+" is Option "+cc;
             JOptionPane.showMessageDialog(null,anse);
    
   
    
    }
}