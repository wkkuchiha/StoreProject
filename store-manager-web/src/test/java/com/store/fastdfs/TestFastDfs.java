package com.store.fastdfs;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import com.store.utils.FastDFSClient;

public class TestFastDfs {
   @Test	
   public void uploadFile() throws Exception {
	   // ��Ŀ���������Ӽܰ�
	   // ����һ�������ļ�,����һ��tracker�������Եĵ�ַ
	   // ���������ļ�
	   ClientGlobal.init("F:/StoreProject/store-manager-web/src/main/resources/resource/client.cnf");
	   // ����һ��trackerClient����
	   TrackerClient tracker = new TrackerClient();
	   // ʹ��trackClient������trackServer����
	   TrackerServer trackerServer = tracker.getConnection();
	   // ����һ��StorageServer������ null�Ϳ���
	   StorageServer storageServer = null;
	   // ����һ��StorageClient����trackerServer��storageServer��������
	   StorageClient storageClient = new StorageClient(trackerServer,storageServer);
	   // ʹ��StorageClient�ϴ�����
	   String[] strings = storageClient.upload_file("C:/Users/Administrato/Desktop/app_launch_fg","jpg" , null);
       for (String string : strings) {
    	   System.out.print(string);
       }
   }
   
   @Test
   public void testFastDfsClient() throws Exception {
	   FastDFSClient fastDFSClient = new FastDFSClient("F:/StoreProject/store-manager-web/src/main/resources/resource/client.cnf");
	   String string = fastDFSClient.uploadFile("C:/Users/Administrato/Desktop/app_launch_fg.jpg");
       System.out.print(string);
   }
}