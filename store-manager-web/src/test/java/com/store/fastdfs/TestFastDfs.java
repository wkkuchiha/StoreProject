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
	   // 项目工程中添加架包
	   // 创建一个配置文件,配置一下tracker服务器对的地址
	   // 加载配置文件
	   ClientGlobal.init("F:/StoreProject/store-manager-web/src/main/resources/resource/client.cnf");
	   // 创建一个trackerClient对象
	   TrackerClient tracker = new TrackerClient();
	   // 使用trackClient对象活的trackServer对象
	   TrackerServer trackerServer = tracker.getConnection();
	   // 创建一个StorageServer的引用 null就可以
	   StorageServer storageServer = null;
	   // 创建一个StorageClient对象，trackerServer，storageServer两个参数
	   StorageClient storageClient = new StorageClient(trackerServer,storageServer);
	   // 使用StorageClient上传对象
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
