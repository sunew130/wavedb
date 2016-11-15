import com.wavedb.common.*;
import java.lang.Thread;

public class DBTest {
	
	 public static void main(String args[]) throws Exception {    
		 WaveDBManager manager = new WaveDBManager();
		 System.out.println("open wave db");
		 
			manager.connectToWaveDB("192.168.3.102", "1433", "����", "123456",20);
			  
	    	while(true)
	    	{
	    		Thread.currentThread().sleep(300);//����  
	    		
	    		AccelerationData aData = new AccelerationData();
	            SpeedData sData = new SpeedData();     
	            OrbitData oData = new OrbitData(); 
	            SpectrumData spData =new SpectrumData();
	        	AccelerationOriginalData aoData = new AccelerationOriginalData();
	        	
	        	   
	        	if(manager.read_WaveDB(aData, sData, oData, spData,aoData,1) == -2)
	        		break;
	        	
	     
	        	if(!aData.isNullData)
	        	{
	        		System.out.println("����������" + aData.aWaveNum);
	        		System.out.println("��ʼʱ�䣺" + aData.aStartTime);
	        		
	        		for(int i = 0;i<aData.aWaveNum;i++)
	        		{
	        			System.out.println("��"+ i + "���ڣ�" + aData.aPeriod[i]);
	        			System.out.println("��"+ i + "���εĴ�С��" + aData.awSize[i] );
	        			
	        			for(int j=0;j<aData.awSize[i];j++)
	        			{
	        				System.out.println(aData.awData[i][j]);
	        			}
	        		}
	        	}
	        	
	         	if(!sData.isNullData)
	        	{
	        		System.out.println("����������" + sData.sWaveNum);
	        		System.out.println("��ʼʱ�䣺" + sData.sStartTime);
	        		
	        		for(int i = 0;i<sData.sWaveNum;i++)
	        		{
	        			System.out.println("��"+ i + "���ڣ�" + sData.sPeriod[i]);
	        			System.out.println("��"+ i + "���εĴ�С��" + sData.swSize[i] );
	        			
	        			for(int j=0;j<sData.swSize[i];j++)
	        			{
	        				System.out.println(sData.swData[i][j]);
	        			}
	        		}
	        	}
	        	
	         	
	         	if(!oData.isNullData)
	         	{
	         		System.out.println("�켣������" + oData.oWaveNum);
	         		System.out.println("��ʼʱ�䣺" + oData.oStartTime);
	         		System.out.println("�켣��Ϣ����" + oData.oTrackMsgNum);
	         		
	         		for(int i = 0;i<oData.oWaveNum;i++)
	         		{
	         			System.out.println("��" + i +"�켣��Чֵ��" + oData.oEffectValue[i]);
	         			System.out.println("��" + i +"�켣���ֵ��" + oData.oMaxValue[i]);
	         			
	         			
	         			for(int j = 0;j<2;j++)
	         			{
	         			
	         				for(int k =0 ;k<oData.owSize[i][j];k++)
	         			{
	         					System.out.println(oData.owData[i][j][k]);
	         			}
	         				
	         			}
	         			
	         		}
	         	}
	         	
	        	
	         	if(!spData.isNullData)
	         	{
	         		System.out.println("Ƶ��������" + spData.srWaveNum);
	         		System.out.println("Ƶ�ʸ�����" + spData.srFrequencyNum);
	         		System.out.println("Ƶ����Ϣ����" + spData.srFrequencyMsgNum);
	         		
	         		for(int i =0;i<spData.srWaveNum;i++)
	         		{
	         			System.out.println("��" + i + "Ƶ�����ڣ�" + spData.srPeriod[i]);
	         			System.out.println("��" + i + "Ƶ����ʼƵ��" + spData.srFrequency0[i]);
	         			
	         			for(int j = 0;j<spData.srSize[i] ;j++)
	         			{
	         				System.out.println(spData.srData[i][j]);
	         			}
	         			
	         			for(int k = 0; k<spData.srFrequencyNum;k++)
	         			{
	         				System.out.println("��" + i + "����Ƶ�ʣ�" + spData.srFrequencyMsg[i].srFrequency[k]);
	         				System.out.println("��" + i + "���η�ֵ�� " + spData.srFrequencyMsg[i].srAmplitude[k]);
	         			}
	         			
	         		}
	         		
	         	}	
	         	
	         	
	         	if(!aoData.isNullData)
	        	{
	        		System.out.println("ԭʼ����������" + aoData.aWaveNum);
	        		System.out.println("��ʼʱ�䣺" + aoData.aStartTime);
	        		
	        		for(int i = 0;i<aoData.aWaveNum;i++)
	        		{
	        			System.out.println("��"+ i + "���ڣ�" + aoData.aPeriod[i]);
	        			System.out.println("��"+ i + "���εĴ�С��" + aoData.awSize[i] );
	        			
	        			for(int j=0;j<aoData.awSize[i];j++)
	        			{
	        				System.out.println(aoData.awData[i][j]);
	        			}
	        		}
	        	}
	         	
	         	
	        	
	    	}
	    	
	    	manager.close_WaveDB();
	 }

}
