import com.wavedb.common.*;
import java.lang.Thread;

public class DBTest {
	
	 public static void main(String args[]) throws Exception {    
		 WaveDBManager manager = new WaveDBManager();
		 System.out.println("open wave db");
		 
			manager.connectToWaveDB("192.168.3.102", "1433", "测试", "123456",20);
			  
	    	while(true)
	    	{
	    		Thread.currentThread().sleep(300);//毫秒  
	    		
	    		AccelerationData aData = new AccelerationData();
	            SpeedData sData = new SpeedData();     
	            OrbitData oData = new OrbitData(); 
	            SpectrumData spData =new SpectrumData();
	        	AccelerationOriginalData aoData = new AccelerationOriginalData();
	        	
	        	   
	        	if(manager.read_WaveDB(aData, sData, oData, spData,aoData,1) == -2)
	        		break;
	        	
	     
	        	if(!aData.isNullData)
	        	{
	        		System.out.println("波形数量：" + aData.aWaveNum);
	        		System.out.println("起始时间：" + aData.aStartTime);
	        		
	        		for(int i = 0;i<aData.aWaveNum;i++)
	        		{
	        			System.out.println("第"+ i + "周期：" + aData.aPeriod[i]);
	        			System.out.println("第"+ i + "波形的大小：" + aData.awSize[i] );
	        			
	        			for(int j=0;j<aData.awSize[i];j++)
	        			{
	        				System.out.println(aData.awData[i][j]);
	        			}
	        		}
	        	}
	        	
	         	if(!sData.isNullData)
	        	{
	        		System.out.println("波形数量：" + sData.sWaveNum);
	        		System.out.println("起始时间：" + sData.sStartTime);
	        		
	        		for(int i = 0;i<sData.sWaveNum;i++)
	        		{
	        			System.out.println("第"+ i + "周期：" + sData.sPeriod[i]);
	        			System.out.println("第"+ i + "波形的大小：" + sData.swSize[i] );
	        			
	        			for(int j=0;j<sData.swSize[i];j++)
	        			{
	        				System.out.println(sData.swData[i][j]);
	        			}
	        		}
	        	}
	        	
	         	
	         	if(!oData.isNullData)
	         	{
	         		System.out.println("轨迹数量：" + oData.oWaveNum);
	         		System.out.println("起始时间：" + oData.oStartTime);
	         		System.out.println("轨迹信息数：" + oData.oTrackMsgNum);
	         		
	         		for(int i = 0;i<oData.oWaveNum;i++)
	         		{
	         			System.out.println("第" + i +"轨迹有效值：" + oData.oEffectValue[i]);
	         			System.out.println("第" + i +"轨迹最大值：" + oData.oMaxValue[i]);
	         			
	         			
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
	         		System.out.println("频谱数量：" + spData.srWaveNum);
	         		System.out.println("频率个数：" + spData.srFrequencyNum);
	         		System.out.println("频率信息数：" + spData.srFrequencyMsgNum);
	         		
	         		for(int i =0;i<spData.srWaveNum;i++)
	         		{
	         			System.out.println("第" + i + "频率周期：" + spData.srPeriod[i]);
	         			System.out.println("第" + i + "频率起始频率" + spData.srFrequency0[i]);
	         			
	         			for(int j = 0;j<spData.srSize[i] ;j++)
	         			{
	         				System.out.println(spData.srData[i][j]);
	         			}
	         			
	         			for(int k = 0; k<spData.srFrequencyNum;k++)
	         			{
	         				System.out.println("第" + i + "波形频率：" + spData.srFrequencyMsg[i].srFrequency[k]);
	         				System.out.println("第" + i + "波形幅值： " + spData.srFrequencyMsg[i].srAmplitude[k]);
	         			}
	         			
	         		}
	         		
	         	}	
	         	
	         	
	         	if(!aoData.isNullData)
	        	{
	        		System.out.println("原始波形数量：" + aoData.aWaveNum);
	        		System.out.println("起始时间：" + aoData.aStartTime);
	        		
	        		for(int i = 0;i<aoData.aWaveNum;i++)
	        		{
	        			System.out.println("第"+ i + "周期：" + aoData.aPeriod[i]);
	        			System.out.println("第"+ i + "波形的大小：" + aoData.awSize[i] );
	        			
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
