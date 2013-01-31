import os,sys
import Image
import ImageFilter
import ImageEnhance
import cv2
import numpy
from PIL import Image
from PIL import ImageChops
from scipy import ndimage



opchoose=diffa=[[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0]];

#PIXEL BY PIXEL!
print "\n\n-----------------------Solutions Using Visual Representation-----------------------\n"
vv=[1,2,3,7,9,11]
print "\n2X2 Problems \n"
for m in (vv):
	
	print "Problem ",m," Solution is"
	o11 = Image.open(str(m)+"/1-1.gif")
	o12 = Image.open(str(m)+"/1-2.gif")
	o21 = Image.open(str(m)+"/2-1.gif")
	o1 = Image.open(str(m)+"/1.gif")
	o2 = Image.open(str(m)+"/2.gif")
	o3 = Image.open(str(m)+"/3.gif")
	o4 = Image.open(str(m)+"/4.gif")
	o5 = Image.open(str(m)+"/5.gif")
	o6 = Image.open(str(m)+"/6.gif")
	o7 = Image.open(str(m)+"/7.gif")	# modification
	o8 = Image.open(str(m)+"/8.gif") 	# modification 
	
	
	def checktransform(a,b):
		
		aa= numpy.asarray(a)
		cc= numpy.asarray(b)
		rat=round(len(numpy.where( cc <220 )[0])/len(numpy.where( aa <220 )[0]))
		
		b = numpy.asarray(b)
		
		im = numpy.asarray(a)
		diff=sum(sum(im-b))
		val=1
		#print diff
		a1 = a.transpose(Image.FLIP_LEFT_RIGHT)
		im = numpy.asarray(a1)
		if (sum(sum(im-b))<diff):
			diff=sum(sum(im-b))
			val=2
		#print diff
		im = a.transpose(Image.FLIP_TOP_BOTTOM)
		im = numpy.asarray(a1)
		if (sum(sum(im-b))<diff):
			diff=sum(sum(im-b))
			val=3
		#print diff
		im = a.transpose(Image.ROTATE_90)
		im = numpy.asarray(a1)
		if (sum(sum(im-b))<diff):
			diff=sum(sum(im-b))
			val=4
		#print diff
		im = a.transpose(Image.ROTATE_270)
		im = numpy.asarray(a1)
		if (sum(sum(im-b))<diff):
			diff=sum(sum(im-b))
			val=5
		#print diff
		'''
		if val==2:
			print "Horizontal Reflection"
		if val==3:
			print "Vertical Reflection"
		if val==1:
			print "No Transform"
		if val==4:
			print "Rotate 90"
		if val==5:
			print "Rotate -90"
		'''
		return val,rat
		
	def andser(trans,ratio,a21,v1,v2,v3,v4,v5,v6,v7,v8): 	# modification 
		
		p31 = numpy.asarray(a21)
		p1 = numpy.asarray(v1)
		p2 = numpy.asarray(v2)
		p3 = numpy.asarray(v3)
		p4 = numpy.asarray(v4)
		p5 = numpy.asarray(v5)
		p6 = numpy.asarray(v6)
		p7 = numpy.asarray(v7)
		p8 = numpy.asarray(v8)
		
		
		
		im1 = a21.transpose(Image.FLIP_LEFT_RIGHT)
		if trans==2:
			im1 = a21.transpose(Image.FLIP_LEFT_RIGHT)
			im = numpy.asarray(im1)
		if trans==3:
			im1 = a21.transpose(Image.FLIP_TOP_BOTTOM)
			im = numpy.asarray(im1)
		if trans==1:
			im = numpy.asarray(a21)
		if trans==4:
			im1 = a21.transpose(Image.ROTATE_90)
			im = numpy.asarray(im1)
		if trans==5:
			im1 = a21.transpose(Image.ROTATE_270)
			im = numpy.asarray(im1)
		diffa=[[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0]];
		diffa[0][0]=sum(sum(im-v1))
		diffa[0][1]=sum(sum(im-v2))
		diffa[0][2]=sum(sum(im-v3))
		diffa[0][3]=sum(sum(im-v4))
		diffa[0][4]=sum(sum(im-v5))
		diffa[0][5]=sum(sum(im-v6))
		diffa[0][6]=sum(sum(im-v7)) 	# modification 
		diffa[0][7]=sum(sum(im-v8)) 	# modification 
		
		diffa[1][0]=round(len(numpy.where( p1 <220 )[0])/len(numpy.where( p31 <220 )[0]))
		diffa[1][1]=round(len(numpy.where( p2 <220 )[0])/len(numpy.where( p31 <220 )[0]))
		diffa[1][2]=round(len(numpy.where( p3 <220 )[0])/len(numpy.where( p31 <220 )[0]))
		diffa[1][3]=round(len(numpy.where( p4 <220 )[0])/len(numpy.where( p31 <220 )[0]))
		diffa[1][4]=round(len(numpy.where( p5 <220 )[0])/len(numpy.where( p31 <220 )[0]))
		diffa[1][5]=round(len(numpy.where( p6 <220 )[0])/len(numpy.where( p31 <220 )[0]))
		diffa[1][6]=round(len(numpy.where( p7 <220 )[0])/len(numpy.where( p31 <220 )[0])) 	# modification 
		diffa[1][7]=round(len(numpy.where( p8 <220 )[0])/len(numpy.where( p31 <220 )[0])) 	# modification 
		
		
		for xx in range(len(diffa[0])):
			if(diffa[1][xx]!=ratio):
				diffa[0][xx]=99999
		
		#print diffa
		opchoose[m]=diffa[0]
		return diffa[0].index(min(diffa[0]))+1

		
	trans,rat=checktransform(o11,o12)
	##print trans
	ans=andser(trans,rat,o21,o1,o2,o3,o4,o5,o6,o7,o8) 	# modification 
	print ans
	

vv=[4,5,6,8,10,12]
print "\n3X3 Problems \n"
for m in (vv):
	print "Problem ",m," Solution is"
	o11 = Image.open(str(m)+"/1-1.gif")
	o12 = Image.open(str(m)+"/1-2.gif")
	o13 = Image.open(str(m)+"/1-3.gif")
	o21 = Image.open(str(m)+"/2-1.gif")
	o22 = Image.open(str(m)+"/2-2.gif")
	o23 = Image.open(str(m)+"/2-3.gif")
	o31 = Image.open(str(m)+"/3-1.gif")
	o32 = Image.open(str(m)+"/3-2.gif")
	o1 = Image.open(str(m)+"/1.gif")
	o2 = Image.open(str(m)+"/2.gif")
	o3 = Image.open(str(m)+"/3.gif")
	o4 = Image.open(str(m)+"/4.gif")
	o5 = Image.open(str(m)+"/5.gif")
	o6 = Image.open(str(m)+"/6.gif")
	o7 = Image.open(str(m)+"/7.gif")
	o8 = Image.open(str(m)+"/8.gif")
	
	
	o11 = o11.resize((63,63), Image.NEAREST)
	o12 = o12.resize((63,63), Image.NEAREST)
	o13 = o13.resize((63,63), Image.NEAREST)
	o21 = o21.resize((63,63), Image.NEAREST)
	o22 = o22.resize((63,63), Image.NEAREST)
	o23 = o23.resize((63,63), Image.NEAREST)
	o31 = o31.resize((63,63), Image.NEAREST)
	o32 = o32.resize((63,63), Image.NEAREST)
	o1 = o1.resize((63,63), Image.NEAREST)
	o2 = o2.resize((63,63), Image.NEAREST)
	o3 = o3.resize((63,63), Image.NEAREST)
	o4 = o4.resize((63,63), Image.NEAREST)
	o5 = o5.resize((63,63), Image.NEAREST)
	o6 = o6.resize((63,63), Image.NEAREST)
	o7 = o7.resize((63,63), Image.NEAREST)
	o8 = o8.resize((63,63), Image.NEAREST)
	
	
	
	def checktransform(a,b,c):
		aa= numpy.asarray(a)
		cc= numpy.asarray(c)
		rat=round(len(numpy.where( cc <220 )[0])/len(numpy.where( aa <220 )[0]))
		
		
		x=b
		b = numpy.asarray(b)
		
		im = numpy.asarray(a)
		diff=sum(sum(im-b))
		val=1

		a1 = a.transpose(Image.FLIP_LEFT_RIGHT)
		im = numpy.asarray(a1)
		if (sum(sum(im-b))<diff):
			diff=sum(sum(im-b))
			val=2

		im = a.transpose(Image.FLIP_TOP_BOTTOM)
		im = numpy.asarray(a1)
		if (sum(sum(im-b))<diff):
			diff=sum(sum(im-b))
			val=3
		
		im = a.transpose(Image.ROTATE_90)
		im = numpy.asarray(a1)
		if (sum(sum(im-b))<diff):
			diff=sum(sum(im-b))
			val=4
			
		im = a.transpose(Image.ROTATE_270)
		im = numpy.asarray(a1)
		if (sum(sum(im-b))<diff):
			diff=sum(sum(im-b))
			val=5
			'''
		if val==2:
			print "Horizontal Reflection"
		if val==3:
			print "Vertical Reflection"
		if val==1:
			print "No Transform"
		if val==4:
			print "Rotate 90"
		if val==5:
			print "Rotate -90"
			'''
		val1=val
		val=0
		diff=99999
		
		c = numpy.asarray(c)
		b=x
		im = numpy.asarray(b)
		diff=sum(sum(im-c))
		val=1
	
		im = b.transpose(Image.FLIP_LEFT_RIGHT)
		im = numpy.asarray(im)
		if (sum(sum(im-c))<diff):
			diff=sum(sum(im-c))
			val=2

		im = b.transpose(Image.FLIP_TOP_BOTTOM)
		im = numpy.asarray(im)
		if (sum(sum(im-c))<diff):
			diff=sum(sum(im-c))
			val=3
		
		im = b.transpose(Image.ROTATE_90)
		im = numpy.asarray(im)
		if (sum(sum(im-c))<diff):
			diff=sum(sum(im-c))
			val=4
			
		im = b.transpose(Image.ROTATE_270)
		im = numpy.asarray(im)
		if (sum(sum(im-c))<diff):
			diff=sum(sum(im-c))
			val=5
			'''
		if val==2:
			print "Horizontal Reflection"
		if val==3:
			print "Vertical Reflection"
		if val==1:
			print "No Transform"
		if val==4:
			print "Rotate 90"
		if val==5:
			print "Rotate -90"
			'''
		
			
			
			
		return val1,val,rat
		
	def anders(ratio,tr1,tr2,v1,v2,v3,v4,v5,v6,v7,v8,o31,o32):
		
		p1 = numpy.asarray(v1)
		p2 = numpy.asarray(v2)
		p3 = numpy.asarray(v3)
		p4 = numpy.asarray(v4)
		p5 = numpy.asarray(v5)
		p6 = numpy.asarray(v6)
		p7 = numpy.asarray(v7)
		p8 = numpy.asarray(v8)
		p31 = numpy.asarray(o31)
		p32 = numpy.asarray(o32)
		
		'''
		za=0.0
		p31 = numpy.asarray(o31)
		for i in range(o31.size[0]):
			for j in range(o32.size[1]):
				if p31[i,j]<220:
					za=za+1
				
		#print za
		za1=0.0
		p5 = numpy.asarray(v2)
		for i in range(v5.size[0]):
			for j in range(v5.size[1]):
				if p5[i,j]<220:
					za1=za1+1
				
		#print za1
		#print 
		#"NUMPY ",len(numpy.where( p5 <200 )[0])
		##print round(za1/za) 
		'''
		if tr1==2:
			im2 = o31.transpose(Image.FLIP_LEFT_RIGHT)
			im3 = numpy.asarray(im2)
		if tr1==3:
			im2 = o31.transpose(Image.FLIP_TOP_BOTTOM)
			im3 = numpy.asarray(im2)
		if tr1==1:
			im3 = numpy.asarray(o31)
		if tr1==4:
			im2 = o31.transpose(Image.ROTATE_90)
			im3 = numpy.asarray(im2)
		if tr1==5:
			im2 = o31.transpose(Image.ROTATE_270)
			im3 = numpy.asarray(im2)
		
		
		
		
		
		
		
		
		
		
		if tr2==2:
			im1 = o32.transpose(Image.FLIP_LEFT_RIGHT)
			im = numpy.asarray(im1)
		if tr2==3:
			im1 = o32.transpose(Image.FLIP_TOP_BOTTOM)
			im = numpy.asarray(im1)
		if tr2==1:
			im = numpy.asarray(o32)
		if tr2==4:
			im1 = o32.transpose(Image.ROTATE_90)
			im = numpy.asarray(im1)
		if tr2==5:
			im1 = o32.transpose(Image.ROTATE_270)
			im = numpy.asarray(im1)
		diffa=[[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0]];
		diffa[0][0]=sum(sum(im-v1))
		diffa[0][1]=sum(sum(im-v2))
		diffa[0][2]=sum(sum(im-v3))
		diffa[0][3]=sum(sum(im-v4))
		diffa[0][4]=sum(sum(im-v5))
		diffa[0][5]=sum(sum(im-v6))
		diffa[0][6]=sum(sum(im-v7))
		diffa[0][7]=sum(sum(im-v8))

		diffa[1][0]=round(len(numpy.where( p1 <220 )[0])/len(numpy.where( p31 <220 )[0]))
		diffa[1][1]=round(len(numpy.where( p2 <220 )[0])/len(numpy.where( p31 <220 )[0]))
		diffa[1][2]=round(len(numpy.where( p3 <220 )[0])/len(numpy.where( p31 <220 )[0]))
		diffa[1][3]=round(len(numpy.where( p4 <220 )[0])/len(numpy.where( p31 <220 )[0]))
		diffa[1][4]=round(len(numpy.where( p5 <220 )[0])/len(numpy.where( p31 <220 )[0]))
		diffa[1][5]=round(len(numpy.where( p6 <220 )[0])/len(numpy.where( p31 <220 )[0]))
		diffa[1][6]=round(len(numpy.where( p7 <220 )[0])/len(numpy.where( p31 <220 )[0]))
		diffa[1][7]=round(len(numpy.where( p8 <220 )[0])/len(numpy.where( p31 <220 )[0]))
		
		for xx in range(len(diffa[0])):
			if(diffa[1][xx]!=ratio):
				diffa[0][xx]=99999
		
		#print diffa
		opchoose[m]=diffa[0]
		return diffa[0].index(min(diffa[0]))+1
		
		
	trans1,trans2,ratio=checktransform(o11,o12,o13)
	#print ratio
	ans=anders(ratio,trans1,trans2,o1,o2,o3,o4,o5,o6,o7,o8,o31,o32)
	print ans
	
	
	#PIXEL BY PIXEL!!!!!!!!!!!!!!!!!!!!!



print "\n\n"
print "-----------------------Generating Propositional Representations-----------------------\n"

print "DataSet Entered"

#print opchoose

def calc_ratio(x):
	val1=float(len(numpy.where( x <200 )[0]))
	#print val1
	val2=float(len(x)*len(x[0]))
	#print val2
	#print float(0.5/123)
	return float(val1/val2)
	
pics=[]
templates=[]
ti=[]
c1=0
for c1 in range(1,31):
	i1=Image.open("data1/"+str(c1)+".gif")
	pmat = numpy.asarray(i1)
	pics.append(i1)
	templates.append(pmat)

ti=pics.sort(key=numpy.size)
for bt in range(0,30):
	im = pics[bt]
	im.save("data/"+str(bt)+".gif")

	#print calc_ratio(pmat)
	#print templates , "Shape Number" , c1

#pics[0].show()
						
def extractor(d,parr,i):
	#parr.append("Number of Objects: 2~")
	flagg=0
	for x in range(0,len(d)):
		if (d[x]==9999):
			if (flagg==0):
				parr.append("Number of Objects: M~")
				flagg=1
				
			parr.append("Object i: "+chr(i+97)+"~")
			if(d[x-4]==0):
				parr.append("Position: Left~")		
			if(d[x-4]==1):
				parr.append("Position: Center~")
			if(d[x-4]==2):
				parr.append("Position: Right~")					
			if(d[x-4]==5):
				parr.append("Position: All~")
			
			if(d[x-3]==0):
				parr.append("Orientation: Top~")		
			if(d[x-3]==1):
				parr.append("Orientation: Middle~")
			if(d[x-3]==2):
				parr.append("Orientation: Bottom~")					
			if(d[x-3]==5):
				parr.append("Orientation: All~")
			
			parr.append("Rotation: "+str(d[x-2])+"~")
			
			if(d[x-1]==0):
				parr.append("Filled: No~")
			
			if(d[x-1]==1):
				parr.append("Filled: Yes~")
	#print parr
	return parr
					
def calc_diff(x,y):
	val1=0
	#if(len(x[0])!=len(y[0]) and len(x)!=len(y)):
		#print "WRONG!!!"
	for t in range(0,len(x[0])):
		for s in range(0,len(x)):
			if((x[s][t])== (y[s][t])):
				val1=float(val1+1)
	
	#val1=float(len(numpy.where( (x <150) and (y<150) )[0]))
	#print val1
	val2=float(len(y)*len(y[0]))
	#z=x-y
	#val1=float(len(numpy.where(x-y<10)[0]))
	#print val1
	#print val2
	#print float(0.5/123)
	return float(val1/val2)
	
def finder(x):
	poss=[]
	retmat=[]
	#x.show()
	b = numpy.asarray(x)
	f=0
	for i in range(0,len(templates)):
		a=numpy.asarray(templates[i])
		#print calc_ratio(a)
		ab = 60 * [0]
		index=0
		if(len(b)==len(b[0])):
			bl=len(b)-len(a)
			bh=len(b[0])-len(a[0])
		if(len(b)-len(b[0])>0):	
			bl=len(b)-len(a)+1
			bh=len(b[0])-len(a[0])
		if(len(b)-len(b[0])<0):	
			bh=len(b[0])-len(a[0])+1
			bl=len(b)-len(a)
		v=0
		w=0	
		rotation=0
		
		differ=[0,0,0,0,0,0]
		for v in range(bl+1):
				#print "in"
				for w in range(bh+1):
					
					
					c=b[v:v+len(a),w:w+len(a[0])]
					c.flags.writeable=False
					
					
					va=calc_ratio(a)
					vc=calc_ratio(c)
					if((va==vc)):
												
						
						
						rotation=90
					
						
						
						
						
						
						if (len(a)==len(b)):
							im=x
							im1=x.transpose(Image.FLIP_LEFT_RIGHT)	
							im2=x.transpose(Image.FLIP_TOP_BOTTOM)	
							im3=x.transpose(Image.ROTATE_90)	
							im4=x.transpose(Image.ROTATE_270)	
							
							b0=numpy.asarray(im)
							b1=numpy.asarray(im1)
							b2=numpy.asarray(im2)
							b3=numpy.asarray(im3)
							b4=numpy.asarray(im4)
							differ=[0,0,0,0,0]
							
							differ[0]=sum(sum(a-b0))
							differ[1]=sum(sum(a-b1))
							differ[2]=sum(sum(a-b2))
							differ[3]=sum(sum(a-b3))
							differ[4]=sum(sum(a-b4))
							valler=9999
							rotin=0
							for di in range(0,len(differ)):
								if(differ[di]<=valler and differ[0]!=0):
									rotin=di
									valler=differ[di]
								
							#rotin=differ.index(min(differ))
							#print differ
							#print "ROTATON INDEX ", rotin
							if(rotin==1):
									rotation=(-1)*rotation
									if(i==6):
										rotation=(-1)*90
										
							if(rotin==2):
									rotation=(90-rotation)+90
									if(i==6):
										rotation=(90-rotation)+180
							if(rotin==3):
								if (i==5 or i==6):
									rotation=rotation+180
								else:
									rotation=rotation+90
								
							if(rotin==4):
								if (i==5 or i==6):
									rotation=rotation-180
								else:
									rotation=rotation-90
							
							
						
						else:
							crev=c[::-1]
							crv=(len(numpy.where( crev==a )[0]))
							cv=(len(numpy.where( c==a )[0]))
							
							#if(sum(sum((crev-a)))>=sum(sum((c-a)))):
							if((crv>cv)):	
								rotation=180
							else:
								rotation=0
	
						
						#print va
						#print vc
						ycor=v
						xcor=w
						'''
						left=0
						center=1
						right=2
						
						top=1
						middle=2
						bottom=3
						
						
						lpos=0
						if(xcor<((bh)/3) and xcor+len(a[0])<2*(bh)/3):
							lpos=0
						if(xcor>((bh)/3) and xcor+len(a[0])<2*(bh)/3):
							lpos=2
						if(xcor>((bh)/3) and xcor+len(a[0])>2*(bh)/3):
							lpos=2
							
						rpos=0
						if(ycor<((bl)/3) and ycor+len(a)<2*(bl)/3):
							rpos=0
						if(ycor>((bl)/3) and ycor+len(a)<2*(bl)/3):
							rpos=2
						if(ycor>((bl)/3) and ycor+len(a)>2*(bl)/3):
							rpos=2	
						'''
						
						
						val1=0
						for t in range(0,len(a[0])):
							for s in range(0,len(a)):
								if((a[s][t]) == (c[s][t])):
									val1=float(val1+1)
		
						

						
						#if ((val1/(len(a)*len(a[0]))-calc_ratio(a))<0.5):
						if( (len(a)==len(b) and len(a[0])==len(b[0])) or (len(a)<(len(b))*0.4 and len(a[0])<(len(b[0]))*0.4) ):
							if(index>2):
								if( ((abs(ab[index-9]-xcor)>7) or (abs(ab[index-7]-ycor)>7)) and ((abs(ab[index-5]-xcor)>7) or (abs(ab[index-4]-ycor)>7)) ):
									#print i
									ab[index]=xcor	
									ab[index+1]=ycor
									ab[index+2]=rotation
									if(calc_ratio(a)>0.5):
										ab[index+3]=1
									else:
										ab[index+3]=0
									ab[index+4]=9999
									
									index=index+5
							else:
								ab[index]=xcor	
								ab[index+1]=ycor
								ab[index+2]=rotation
								if(calc_ratio(a)>0.5):
									ab[index+3]=1
								else:
									ab[index+3]=0
								ab[index+4]=9999
								index=index+5
						#	if (i==0):
						#		print ab
							retmat=ab
							f=i	
		'''
						if(a==c):
							if(index>2):
								if( ((abs(ab[index-6]-xcor)>7) or (abs(ab[index-5]-ycor)>7)) and ((abs(ab[index-3]-xcor)>7) or (abs(ab[index-2]-ycor)>7)) ):
									ab[index]=xcor	
									ab[index+1]=ycor
									ab[index+2]=rotin
									if(calc_ratio(a)>0.5):
										ab[index+3]=1
									else:
										ab[index+3]=0
									ab[index+4]=9999
									
									index=index+3
							else:
								ab[index]=xcor	
								ab[index+1]=ycor
								ab[index+2]=9999
								index=index+3
							#pics[i].show()
						'''	
				
		
		#retmat.append(ab)
		#print ab
		
		#print rotation
	a=templates[f]
	bh=len(b)
	bl=len(b[0])	
	
	for x in range(1,len(retmat),5):
		lpos=0
		
		if(retmat[x+3]!=0):
			#print f, retmat[x], bh, bl, len(a[0]), len(a)
			if(retmat[x]<((bh)/3) and retmat[x]+len(a[0])<(2*(bh)/3)):
				lpos=0
			if(retmat[x]>((bh)/3) and retmat[x]+len(a[0])<(2*(bh)/3)):
				lpos=1
			if(retmat[x]>((bh)/3) and retmat[x]+len(a[0])>(2*(bh)/3)):
				lpos=2
			if(retmat[x]<((bh)/3) and retmat[x]+len(a[0])>(2*(bh)/3)):	
				lpos=5
			retmat[x]=lpos
			if(len(a)==len(b) and len(a[0])==len(b[0])):
				retmat[x]=5
			
			
	for y in range(0,len(retmat),5):	
		rpos=0
		if(retmat[y+4]!=0):
			#print f, retmat[y], bh, bl, len(a[0]), len(a)
			if(retmat[y]<((bl)/3) and retmat[y]+len(a)<(2*(bl)/3)):
				rpos=0
			if(ycor>((bl)/3) and retmat[y]+len(a)<(2*(bl)/3)):
				rpos=1
			if(retmat[y]>((bl)/3) and retmat[y]+len(a)>(2*(bl)/3)):
				rpos=2	
			if(retmat[y]<((bl)/3) and retmat[y]+len(a)>(2*(bl)/3)):
				rpos=5
			retmat[y]=rpos
			if(len(a)==len(b) and len(a[0])==len(b[0])):
				retmat[y]=5	
	#print len(a) , len(a[0])
	#print len(b) , len(b[0])
	
	
	
	
	#print f
	return retmat,f
	
	
vv=[1,2,3,7,9,11]
print "\n2X2 Problems \n"
for m in (vv):
	
	print "Problem ",m," Being Processed"
	o11 = Image.open(str(m)+"/1-1.gif")
	o12 = Image.open(str(m)+"/1-2.gif")
	o21 = Image.open(str(m)+"/2-1.gif")
	o1 = Image.open(str(m)+"/1.gif")
	o2 = Image.open(str(m)+"/2.gif")
	o3 = Image.open(str(m)+"/3.gif")
	o4 = Image.open(str(m)+"/4.gif")
	o5 = Image.open(str(m)+"/5.gif")
	o6 = Image.open(str(m)+"/6.gif")
	o7 = Image.open(str(m)+"/7.gif")	# modification
	o8 = Image.open(str(m)+"/8.gif") 	# modification

	f=open('2-'+str(m)+'.txt','w')
		
	prarray=[]
	arra=[]
	cx,sno=finder(o11)
	print "Question Figures Being Processed"
	prarray.append("8-8~")
	prarray.append("Problem "+str(m)+"~")
	prarray.append("Q11~")
	prarray=extractor(cx,prarray,sno)
	prarray.append("//~")
	#print "xXXXX"
	cx1,sno=finder(o12)
	#print cx1
	prarray.append("Q12~")
	prarray=extractor(cx1,prarray,sno)
	prarray.append("//~")
	#print "xXXXX2"
	cx2,sno=finder(o21)
	#print cx2,sno
	prarray.append("Q21~")
	prarray=extractor(cx2,prarray,sno)
	prarray.append("//~")
	#o21.show()
	prarray.append("Options~")

	##print prarray
	#print "v1"
	v1=[]
	v2=[]
	v3=[]
	v4=[]
	v5=[]
	v6=[]
	v7=[]
	v8=[]
	
	prarray.append("V1~")
	if (opchoose[m][0]!=99999):
		v1,sno=finder(o1)
		prarray=extractor(v1,prarray,sno)
	print "Options Being Processed"
	prarray.append("/~")
	#idx,row = max(enumerate(v1),key=lambda r: ( sum(r[1])==0, r[0] ) )
	##print idx,row
	##print max(sum(v1[,]))
	
	#print "v2"
	prarray.append("V2~")
	if (opchoose[m][1]!=99999):
		v2,sno=finder(o2)
		prarray=extractor(v2,prarray,sno)
	#print v2	
	
	prarray.append("/~")
	
	#print "v3"
	prarray.append("V3~")
	if (opchoose[m][2]!=99999):
		v3,sno=finder(o3)
		prarray=extractor(v3,prarray,sno)
	#print v3	
	prarray.append("/~")
	#print "v4"
	
	prarray.append("V4~")
	if (opchoose[m][3]!=99999):
		v4,sno=finder(o4)
		prarray=extractor(v4,prarray,sno)
	#print v4	
	prarray.append("/~")
	
	#print "v5"
	prarray.append("V5~")
	if (opchoose[m][4]!=99999):
		v5,sno=finder(o5)
		prarray=extractor(v5,prarray,sno)
	#print v5	
	
	prarray.append("/~")
	
	#print "v6"
	prarray.append("V6~")
	if (opchoose[m][5]!=99999):
		v6,sno=finder(o6)
		prarray=extractor(v6,prarray,sno)
	#print v6	
	
	prarray.append("/~")
	
	#print "v7"
	prarray.append("V7~")
	if (opchoose[m][6]!=99999):
		v7,sno=finder(o7)
		prarray=extractor(v7,prarray,sno)
	#print v7	
	
	prarray.append("/~")
	
	#print "v8"
	prarray.append("V8~")
	if (opchoose[m][7]!=99999):
		v8,sno=finder(o8)
		prarray=extractor(v8,prarray,sno)
	#print v8	
	
	prarray.append("/~")
	prarray.append("///~")
	
	
	for writer in range(0,len(prarray)-1):
		f.write(str(prarray[writer])+'\n')
		
	f.write(str(prarray[len(prarray)-1]))
			
	print "Problem ",m," Representation Generated \n"
	f.close()

		

vv=[4,5,6,8,10,12]
print "\n3X3 Problems\n"
for m in (vv):
	print "Problem ",m," Being Processed"
	o11 = Image.open(str(m)+"/1-1.gif")
	o12 = Image.open(str(m)+"/1-2.gif")
	o13 = Image.open(str(m)+"/1-3.gif")
	o21 = Image.open(str(m)+"/2-1.gif")
	o22 = Image.open(str(m)+"/2-2.gif")
	o23 = Image.open(str(m)+"/2-3.gif")
	o31 = Image.open(str(m)+"/3-1.gif")
	o32 = Image.open(str(m)+"/3-2.gif")
	o1 = Image.open(str(m)+"/1.gif")
	o2 = Image.open(str(m)+"/2.gif")
	o3 = Image.open(str(m)+"/3.gif")
	o4 = Image.open(str(m)+"/4.gif")
	o5 = Image.open(str(m)+"/5.gif")
	o6 = Image.open(str(m)+"/6.gif")
	o7 = Image.open(str(m)+"/7.gif")
	o8 = Image.open(str(m)+"/8.gif")

	f=open('2-'+str(m)+'.txt','w')
		
	prarray=[]
	arra=[]
	cx11,sno=finder(o11)
	print "Question Figures Being Processed"
	prarray.append("8-8~")
	prarray.append("Problem "+str(m)+"~")
	prarray.append("Q11~")
	prarray=extractor(cx11,prarray,sno)
	prarray.append("//~")
	#print "xXXXX"
	cx12,sno=finder(o12)
	#print cx12
	prarray.append("Q12~")
	prarray=extractor(cx12,prarray,sno)
	prarray.append("//~")
	#print "xXXXX2"
	cx13,sno=finder(o13)
	#print cx13,sno
	prarray.append("Q13~")
	prarray=extractor(cx13,prarray,sno)
	prarray.append("//~")
	
	cx21,sno=finder(o21)
	#print cx21
	prarray.append("Q21~")
	prarray=extractor(cx21,prarray,sno)
	prarray.append("//~")
	#print "xXXXX2"
	
	cx22,sno=finder(o22)
	#print cx22
	prarray.append("Q22~")
	prarray=extractor(cx22,prarray,sno)
	prarray.append("//~")
	#print "xXXXX2"
	
	cx23,sno=finder(o23)
	#print cx23
	prarray.append("Q23~")
	prarray=extractor(cx23,prarray,sno)
	prarray.append("//~")
	#print "xXXXX2"
	
	cx31,sno=finder(o31)
	#print cx31
	prarray.append("Q31~")
	prarray=extractor(cx31,prarray,sno)
	prarray.append("//~")
	#print "xXXXX2"
	
	cx32,sno=finder(o32)
	#print cx32
	prarray.append("Q32~")
	prarray=extractor(cx32,prarray,sno)
	prarray.append("//~")
	#print "xXXXX2"
	#o21.show()
	prarray.append("Options~")

	##print prarray
	print "Options Being Processed"
	v1=[]
	v2=[]
	v3=[]
	v4=[]
	v5=[]
	v6=[]
	v7=[]
	v8=[]
	
	prarray.append("V1~")
	if (opchoose[m][0]!=99999):
		v1,sno=finder(o1)
		prarray=extractor(v1,prarray,sno)
	#print v1
	prarray.append("/~")
	#idx,row = max(enumerate(v1),key=lambda r: ( sum(r[1])==0, r[0] ) )
	##print idx,row
	##print max(sum(v1[,]))
	
	#print "v2"
	prarray.append("V2~")
	if (opchoose[m][1]!=99999):
		v2,sno=finder(o2)
		prarray=extractor(v2,prarray,sno)
	#print v2	
	
	prarray.append("/~")
	
	#print "v3"
	prarray.append("V3~")
	if (opchoose[m][2]!=99999):
		v3,sno=finder(o3)
		prarray=extractor(v3,prarray,sno)
	#print v3	
	prarray.append("/~")
	#print "v4"
	
	prarray.append("V4~")
	if (opchoose[m][3]!=99999):
		v4,sno=finder(o4)
		prarray=extractor(v4,prarray,sno)
	#print v4	
	prarray.append("/~")
	
	#print "v5"
	prarray.append("V5~")
	if (opchoose[m][4]!=99999):
		v5,sno=finder(o5)
		prarray=extractor(v5,prarray,sno)
	#print v5	
	
	prarray.append("/~")
	
	#print "v6"
	prarray.append("V6~")
	if (opchoose[m][5]!=99999):
		v6,sno=finder(o6)
		prarray=extractor(v6,prarray,sno)
	#print v6	
	
	prarray.append("/~")
	
	#print "v7"
	prarray.append("V7~")
	if (opchoose[m][6]!=99999):
		v7,sno=finder(o7)
		prarray=extractor(v7,prarray,sno)
	#print v7	
	
	prarray.append("/~")
	
	#print "v8"
	prarray.append("V8~")
	if (opchoose[m][7]!=99999):
		v8,sno=finder(o8)
		prarray=extractor(v8,prarray,sno)
	#print v8	
	
	prarray.append("/~")
	prarray.append("///~")
	
	
	for writer in range(0,len(prarray)-1):
		f.write(str(prarray[writer])+'\n')
		
	f.write(str(prarray[len(prarray)-1]))
	print "Problem ",m," Representation Generated \n"		
	
	f.close()	
	
print "Representations Generated. Run .Jar File from Folder for Propositional Answers"