package intech.iconnect.InMessage.InProcess;



import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.util.ResourceBundle;



import com.zehon.sftp.SFTPClient;



import java.io.BufferedInputStream;

import java.io.ByteArrayInputStream;

import java.io.File;

import java.io.FileOutputStream;

import java.io.FileInputStream;

import java.io.InputStream;

import java.nio.charset.StandardCharsets;

import java.nio.file.Files;

import java.sql.Connection;

import java.sql.Statement;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.util.Arrays;

import java.util.Date;

import java.util.Scanner;

import java.util.TimerTask;



import org.apache.commons.net.ftp.FTPClient;

import org.apache.commons.net.ftp.FTPFile;



import intech.iconnect.OutMessage.OutDatabase.IC_OutMessage_DbConnection;

import intech.iconnect.OutMessage.OutUtils.IC_OutMessage_PasswordBaseEncryption;

//import intech.iconnect.OutMessage.OutDatabase.IC_OutMessage_DbConnection;

public class UCFinIntegratorFileRead extends Thread {





	private String ip;

	private String userName;

    private String password;

	private Date TimerTime;



    private String directory;

    private String backUpDirectory;

	private String path;

   // private Connection objConnection;

	//IC_OutMessage_DbConnection dbconnection = new IC_OutMessage_DbConnection();

    private FTPClient client;

    private FTPClient Ftp202covclient;

	

	private String strAllianceBkupDir;

	

	private SFTPClient sftpClient;

	private String finip;

	private String finuserName;

    private String finpassword;

    private String fin_directory;

    private String fin_directory_202COV;

    private String fin_directory_202;

    private String fin_directory_103;

    private String Alliancedirectory_202COV;

    private String strAllianceBkupDir_202COV;

    private String Swiftdirectory_202COV;

    

	private synchronized void FTPManual(String Command)

	{

		try

		{

			//String Command = "/appuser1test/swiftico/ftpfile_Pull " + ip + " " + userName + " " + password + " " + directory + " " + backUpDirectory + " " + strFileName;



			

			Runtime rt = Runtime.getRuntime();

			System.out.println("cmd"+Command);

			Process procObj = rt.exec(Command);



			procObj.waitFor();



            java.io.InputStream stderr = procObj.getErrorStream();

            java.io.InputStreamReader isr = new java.io.InputStreamReader(stderr);

            java.io.BufferedReader br = new java.io.BufferedReader(isr);

            String line = null;

            while((line = br.readLine()) != null)

			{

                System.out.println(line);

			}

		}

		catch (Exception ex) {

            System.out.println("Exception in FileRead():: Initialization :: " + ex.getMessage());

            ex.printStackTrace();

		}

	}



	private  synchronized void FTPConnection()

	{

		try 

		{

            client = new FTPClient();

            client.connect(ip);

            if (client.isConnected()) 

			{

                if (!client.login(userName, password)) 

				{

                    System.out.println("Error Invalid username or password");

                    System.exit(1);

                }

                client.changeWorkingDirectory(directory);

            }

			else 

			{

                System.out.println("Error in ftp connection");

            }



        } catch (Exception ex) {

            System.out.println("Exception in FileRead():: Initialization :: " + ex.getMessage());

            ex.printStackTrace();

		}

	}



	private synchronized void FTPDisConnection()

	{

		try

		{

			client.logout();

			client.disconnect();

			System.out.println("File transfer Logged Out.");

		}

		catch (Exception ex) {

            System.out.println("Exception in FileRead():: Initialization :: " + ex.getMessage());

            ex.printStackTrace();

        }

		

	}

	

	private synchronized void FTPConnection202COV()

	{

		try 

		{

            Ftp202covclient = new FTPClient();

            Ftp202covclient.connect(ip);

            if (Ftp202covclient.isConnected()) 

			{

                if (!Ftp202covclient.login(userName, password)) 

				{

                    System.out.println("Error Invalid username or password");

                    System.exit(1);

                }

                Ftp202covclient.changeWorkingDirectory(Alliancedirectory_202COV);

            }

			else 

			{

                System.out.println("Error in ftp connection");

            }



        } catch (Exception ex) {

            System.out.println("Exception in FileRead():: Initialization :: " + ex.getMessage());

            ex.printStackTrace();

		}

	}



	private  synchronized void FTPDisConnection202COV()

	{

		try

		{

			Ftp202covclient.logout();

			Ftp202covclient.disconnect();

			System.out.println("File transfer Logged Out.");

		}

		catch (Exception ex) {

            System.out.println("Exception in FileRead():: Initialization :: " + ex.getMessage());

            ex.printStackTrace();

        }

		

	}

	

	/*

		Constructor to read property file for required credentials

	*/

    public UCFinIntegratorFileRead() 

	{

        try 

		{

        	

            ResourceBundle bundle = ResourceBundle.getBundle("IConnect_SFMS_APP");

            ip = bundle.getString("SWF_INWRDSERVERIP");

            userName = bundle.getString("SWF_INWRDSERVERUSERID");

            password = bundle.getString("SWF_INWRDSERVERPWD");

            

            finip=bundle.getString("UCFIN_INWRDSERVERIP");

        	finuserName=bundle.getString("UCFIN_INWRDSERVERUSERID");

            finpassword=bundle.getString("UCFIN_INWRDSERVERPWD");

            

            //SWF_DESTINDIR = /ssit_finoutgacknack/

            directory = bundle.getString("UC103_SWF_DESTINDIR"); 

            Alliancedirectory_202COV = bundle.getString("UC202COV_SWF_DESTINDIR");

            

            //SWF_DESTINDIR_BKUP = /bkp_ssit_finoutgacknack/

            strAllianceBkupDir = bundle.getString("UC103_SWF_DESTINDIR_BKUP");

            strAllianceBkupDir_202COV = bundle.getString("UC202COV_SWF_DESTINDIR_BKUP");



            fin_directory = bundle.getString("FIN_DESTINDIR");

            

            fin_directory_202 = bundle.getString("FIN_DESTINDIR_202");

            fin_directory_202COV = bundle.getString("FIN_DESTINDIR_202COV");

            fin_directory_103 = bundle.getString("FIN_DESTINDIR_103");

           // SWF_PRESENTDIR = /appuser1/mswift10/StoreFile/Incoming/

            backUpDirectory = bundle.getString("UC103_SWF_PRESENTDIR");

            Swiftdirectory_202COV = bundle.getString("UC202COV_SWF_PRESENTDIR");

			path = bundle.getString("UC103_SWF_EXE");

			IC_OutMessage_PasswordBaseEncryption baseEncryption = new IC_OutMessage_PasswordBaseEncryption();		    		    

			password = baseEncryption.decrypt(password);

			

			System.out.println("FTPFileRead-prop name :: "+password);

            //objConnection = IC_OutMessage_DbConnection.connectAppDB();

			//FTPConnection();

        } catch (Exception ex) {

            System.out.println("Exception in FileRead():: Initialization :: " + ex.getMessage());

            ex.printStackTrace();

        }

    }//



	/*

		Thread starts and so the processing of incoming files



	*/

    @Override

    public void run() 

	{

		PreparedStatement pstmt = null,pstmt1=null;

		ResultSet rs = null;

		FileOutputStream fos = null;

		FileInputStream fstream =null;

		BufferedInputStream bis =null;

		ByteArrayInputStream bais = null;

		Connection objConnection=null;

		

        try 

		{

        	

        	

        	

        	
        	

            while (true) 

			{

            	Date todayDate=new Date();

            	SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");

            	String curreantDate=formatter1.format(todayDate.getTime());

            	Date  CurrentDay_8_30=formatter1.parse(curreantDate.split("\\s")[0]+" "+"8:30:00");

            	Date  CurrentDay_12_30=formatter1.parse(curreantDate.split("\\s")[0]+" "+"12:30:00");

            	long totalminut8_30=(todayDate.getTime()-CurrentDay_8_30.getTime()) / (60000);

            	long totalminut12_30=(todayDate.getTime()-CurrentDay_12_30.getTime()) / (60000);

            	if((todayDate.compareTo(CurrentDay_8_30) >0 && totalminut8_30 < 60 ) || (todayDate.compareTo(CurrentDay_12_30) >0 && totalminut12_30 < 60))

            	{

            		objConnection = IC_OutMessage_DbConnection.connectAppDB();

            		

            	FTPConnection();

                FTPFile[] files = client.listFiles();

                System.out.println("Total no. of file found  in 103:: " + files.length);

                boolean flag = false;

				int j = 0;

			

				j=files.length>30?30:files.length;	//process max 30 files at a time

				SFTPConnection();

                for (int i=0; i<j; i++)

				{

                	  Date dt=new Date();

                	  SimpleDateFormat formatter2 = new SimpleDateFormat("yyyyMMddHHmmss");

                	  String TodaysDatetime=formatter2.format(dt);

       	        	  String fileName_103=files[i].getName().split("\\.")[0]+"_"+TodaysDatetime+".inn";

                      String fileId = "";

                      Date fileModifyTime=files[i].getTimestamp().getTime();

                      int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;

         	          String prvdate= formatter1.format(dt.getTime() - MILLIS_IN_DAY);

         	          String[] prevdateTimeArr=prvdate.split("\\s");

         	          Date PreviouseDay_12_30=formatter1.parse(prevdateTimeArr[0]+" "+"12:30:00");

         	          Date TodayDay_8_30=formatter1.parse(curreantDate.split("\\s")[0]+" "+"8:30:00");

         	          Date TodayDay_12_30=formatter1.parse(curreantDate.split("\\s")[0]+" "+"12:30:00");

         	        

         	          System.out.println(fileModifyTime);

         	          

         	         if(((dt.compareTo(CurrentDay_8_30)>0)&&(totalminut8_30 < 60 )&& (TodayDay_8_30.compareTo(fileModifyTime)>=0) && (fileModifyTime.compareTo(PreviouseDay_12_30)>0))

        	        		|| ((dt.compareTo(CurrentDay_12_30)>0)&&(totalminut12_30 < 60 )&& (TodayDay_12_30.compareTo(fileModifyTime)>=0) && (fileModifyTime.compareTo(TodayDay_8_30)>0)) )

         	        {

         	        	

					//1 by 1 file will be fetch from Allaince to Application server

                    String FtpCammand_103= path + " " + ip + " " + userName + " " + password + " " + directory + " "+ files[i].getName() +"  "+fileName_103 +" "+ backUpDirectory + " " +fileName_103 +"  " +strAllianceBkupDir +fileName_103;

					FTPManual(FtpCammand_103);

					String rdFlNm=files[i].getName();

                    System.out.println("Started processing of file :: " + fileName_103);

					String fileExt = rdFlNm.substring(rdFlNm.lastIndexOf(".")+1, rdFlNm.length()); 

					fstream = new FileInputStream(backUpDirectory+fileName_103);

                    bis = new BufferedInputStream(fstream);

                    byte[] bytes = new byte[(int) files[i].getSize()];

					bis.read(bytes);

                  //  String message = Arrays.toString(bytes);

                    String message=new String(bytes,StandardCharsets.UTF_8);

                    String MessageType="",MessageTypeIsCov="";

                    // Ensuring that size of the file is equal to no of bytes

                    if (bytes.length == files[i].getSize()) 

					{

                        File file = new File(backUpDirectory + fileName_103);

                        fos = new FileOutputStream(file);

                        fos.write(bytes);

                        fos.flush();

                        fos.close();

                        	MessageType=message.split("\\{2:")[1].substring(1, 4);

                        	

    //-------------Insert into FILE_UC_INFO Table-------------------

                         objConnection.setAutoCommit(false);

                    	pstmt = objConnection.prepareStatement("INSERT INTO INT_UC_FILE_INFO(IC_FILE_ID,IC_FILE_STATUS,IC_FILE_STRUCTURE,IC_FILE_MSG_NO,IC_APPL_ID,IC_CRE_DATE,IC_RECV_ID,IC_MSG_TYPE) values(?,?,?,?,?,sysdate,?,?)");

                        pstmt.setString(1,fileName_103);

						pstmt.setInt(2, 0);

                        bais = new ByteArrayInputStream(bytes);

                        pstmt.setAsciiStream(3, bais, bais.available());

                        pstmt.setInt(4, 1);

                        pstmt.setString(5,"SWIFT");

                        pstmt.setString(6,"IBKLINBBAXXX");

                        pstmt.setString(7,MessageType);

                        int result = pstmt.executeUpdate();

                        if (result == 1) 

						{

                            flag = true;

                            System.out.println("Data Inserted for file :: " + fileName_103+ " with file id :: " + fileId);

                        }

						bais.close();

                        pstmt.close();

                        pstmt = null;

                        objConnection.commit();

                        if(MessageType.equalsIgnoreCase("103") && (! MessageTypeIsCov.equalsIgnoreCase("COV")))

                        {

                        

                        	 sftpClient.sendFile(backUpDirectory + fileName_103,fin_directory_103);

                        	

                        }

                        

                        sftpClient.sendFile(backUpDirectory + fileName_103 ,fin_directory);



                        System.out.println("sftp file sent ");

                        

                        pstmt1 = objConnection.prepareStatement("UPDATE INT_UC_FILE_INFO  SET IC_FILE_STATUS='1' WHERE IC_FILE_ID='"+fileName_103+"'");

                        int result1 = pstmt1.executeUpdate();
                        if (result1 == 1) 

						{

                           

                            System.out.println("file successfully send");

                        }

                        objConnection.commit();

                        objConnection.setAutoCommit(true);

     					

                        

					}

					else 

					{

                        System.out.println("N");

                        //file.delete();

                    }

                   fstream.close();

                    bis.close();

				}

			}

                SFTP_DisConnection();

				FTPDisConnection();

				

				if (j==0)

	                Thread.sleep(20000);

				else

					Thread.sleep(3000);

				FTPConnection202COV();

		//==========================202cov ================================		

				

		        FTPFile[] files_202cov = Ftp202covclient.listFiles();

                System.out.println("Total no. of file found  in 202 cov :: " + files_202cov.length);

                boolean flag1 = false;

				int k = 0;

				

				k=files_202cov.length>30?30:files_202cov.length;	//process max 30 files at a time

				SFTPConnection();

                for (int i=0; i<k; i++)

				{

                    String fileId = "";

                    Date fileModifyTime=files_202cov[i].getTimestamp().getTime();

                    int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;

                	Date dt=new Date();

                    SimpleDateFormat formatter2 = new SimpleDateFormat("yyyyMMddHHmmss");

               	    String TodaysDatetime=formatter2.format(dt);

      	        	String fileName_202Cov=files_202cov[i].getName().split("\\.")[0]+"_"+TodaysDatetime+".inn";

        	        String prvdate= formatter1.format(dt.getTime() - MILLIS_IN_DAY);

        	        String[] prevdateTimeArr=prvdate.split("\\s");

        	        Date PreviouseDay_12_30=formatter1.parse(prevdateTimeArr[0]+" "+"12:30:00");

        	        Date TodayDay_8_30=formatter1.parse(curreantDate.split("\\s")[0]+" "+"8:30:00");

        	        Date TodayDay_12_30=formatter1.parse(curreantDate.split("\\s")[0]+" "+"12:30:00");

        	        

         	        if(((dt.compareTo(CurrentDay_8_30)>0) && (totalminut8_30 < 60 )&& (TodayDay_8_30.compareTo(fileModifyTime)>=0) && (fileModifyTime.compareTo(PreviouseDay_12_30)>0))

         	        		|| ((dt.compareTo(CurrentDay_12_30)>0)&&(totalminut12_30 < 60 )&& (TodayDay_12_30.compareTo(fileModifyTime)>=0) && (fileModifyTime.compareTo(TodayDay_8_30)>0)))

        	     {

        	     

         	      

                    String FtpCammand_202COV= path + " " + ip + " " + userName + " " + password + " " + Alliancedirectory_202COV+ " "+ files_202cov[i].getName() +"  "+fileName_202Cov +" "+ Swiftdirectory_202COV + " " + fileName_202Cov +" " +strAllianceBkupDir_202COV +fileName_202Cov;

					

                    FTPManual(FtpCammand_202COV);

					String rdFlNm=files_202cov[i].getName();

                    System.out.println("Started processing of file :: " + fileName_202Cov);

					String fileExt = rdFlNm.substring(rdFlNm.lastIndexOf(".")+1, rdFlNm.length()); 

					fstream = new FileInputStream(Swiftdirectory_202COV+fileName_202Cov);

                    bis = new BufferedInputStream(fstream);

                    byte[] bytes = new byte[(int) files_202cov[i].getSize()];

					bis.read(bytes);

                    String message=new String(bytes,StandardCharsets.UTF_8);

                    String MessageType="",MessageTypeIsCov="";

                    // Ensuring that size of the file is equal to no of bytes

                    if (bytes.length == files_202cov[i].getSize()) 

					{

                        File file = new File(Swiftdirectory_202COV + fileName_202Cov);

                        fos = new FileOutputStream(file);

                        fos.write(bytes);

                        fos.flush();

                        fos.close();

                        MessageType=message.split("\\{2:")[1].substring(1, 4);

                         

                          if(message.contains("{119:"))

                           {

                            	MessageTypeIsCov=message.split("\\{119:")[1].substring(0, 3);

                            }

                            if(MessageType.equalsIgnoreCase("202")&& MessageTypeIsCov.equalsIgnoreCase("COV"))

                            {

                            	MessageType="202COV";

                            	

                            }

                            System.out.println(MessageType);

    //-------------Insert into FILE_UC_INFO Table-------------------

                         objConnection.setAutoCommit(false);

                    	pstmt = objConnection.prepareStatement("INSERT INTO INT_UC_FILE_INFO(IC_FILE_ID,IC_FILE_STATUS,IC_FILE_STRUCTURE,IC_FILE_MSG_NO,IC_APPL_ID,IC_CRE_DATE,IC_RECV_ID,IC_MSG_TYPE) values(?,?,?,?,?,sysdate,?,?)");

                        pstmt.setString(1,fileName_202Cov);

						pstmt.setInt(2, 0);

                        bais = new ByteArrayInputStream(bytes);

                        pstmt.setAsciiStream(3, bais, bais.available());

                        pstmt.setInt(4, 1);

                        pstmt.setString(5,"SWIFT");

                        pstmt.setString(6,"IBKLINBBAXXX");

                        pstmt.setString(7,MessageType);

                        int result = pstmt.executeUpdate();

                        if (result == 1) 

						{

                            flag1 = true;

                            System.out.println("Data Inserted for file :: " + fileName_202Cov + " with file id :: " + fileId);

                        }

						bais.close();

                        pstmt.close();

                        pstmt = null;

                        objConnection.commit();

                   

                        if(MessageType.equalsIgnoreCase("202COV")&& MessageTypeIsCov.equalsIgnoreCase("COV"))

                        {

                        	MessageType="202COV";

                        	 sftpClient.sendFile(Swiftdirectory_202COV + fileName_202Cov,fin_directory_202COV);

                        	 

                        	

                        } 

                        sftpClient.sendFile(Swiftdirectory_202COV + fileName_202Cov,fin_directory);

                        System.out.println("sftp file sent ");

                        pstmt1 = objConnection.prepareStatement("UPDATE INT_UC_FILE_INFO  SET IC_FILE_STATUS='1' WHERE IC_FILE_ID='"+fileName_202Cov+"'");

                        int result1 = pstmt1.executeUpdate();

                        if (result1 == 1) 

						{

                           

                            System.out.println("file successfully send");

                        }

                        objConnection.commit();

                        objConnection.setAutoCommit(true);

                       

					}

					else 

					{

                        System.out.println("N");

                        //file.delete();

                    }

              

					fstream.close();

                    bis.close();

				 }

				}

				

                SFTP_DisConnection();

				//FTPDisConnection();

				FTPDisConnection202COV();

				if (k==0)

	                Thread.sleep(20000);

				else

					Thread.sleep(3000);

				

				

			}

			}

                

        }

		catch (Exception ex) 

		{

            System.out.println("exception :: " + ex.getMessage());

        }

		finally{

				

			try

			{

				if(bis!=null){

					bis.close();

					bis = null;

				}

				if(fstream!=null){

					fstream.close();

					fstream = null;

				}

				if(bais!=null){

					bais = null;

				}

				if(fos!=null){

					fos.close();

					fos = null;

				}

				if(rs!=null){

					rs.close();

					rs = null;

			

				}if(pstmt!=null){

					pstmt.close();

					pstmt = null;

				}

				if(objConnection!=null)

				{

					objConnection.close();

					objConnection=null;	

				}

			}

			catch (Exception ex) {

            System.out.println("exception :: " + ex.getMessage());

            ex.printStackTrace();

        }

			

		}

    }



    public synchronized boolean SFTPConnection()

	{

    	boolean flgGotConn=false;

		try 

		{

			

				 sftpClient = new SFTPClient(finip, finuserName, finpassword);

				 flgGotConn = true;

				 System.out.println("Connected to SFTP Server.");

			

        }

		catch (Exception ex) 

		{

             System.out.println("Exception :::: MF III :::: Constructor :::: "+ex.getMessage());

			 flgGotConn = false;

        }

		return flgGotConn;

	}

    public synchronized  boolean SFTP_DisConnection()

	{

		boolean disConnected = false;



		try

		{

			

				//sftpClient.logout();

				//sftpClient.disconnect();

				sftpClient = null;

				System.out.println("File transfer Logged Out.");

			

				disConnected= true;

		}

		catch(Exception e)

		{

			//e.printStackTrace();

			System.out.println("Connection CLose : " + e.getMessage());

		}

		return disConnected;

	}

	

}

