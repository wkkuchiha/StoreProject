package com.store.pagehelper;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.store.mapper.TbItemMapper;
import com.store.pojo.TbItem;
import com.store.pojo.TbItemExample;

public class TestPageHelper {
   public void testPageHelper() throws Exception {
	   // ��mybatis�����÷�ҳ���
	   // ��ִ�з�ҳ֮ǰ���÷�ҳ���� ʹ��pagehelper�ľ�̬����
	   PageHelper.startPage(1, 10);
	   // ִ�в�ѯ
	   ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
	   TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);
	   TbItemExample example = new TbItemExample();
	   List<TbItem> list = itemMapper.selectByExample(example);
	   // ȡ��ҳ��Ϣ ʹ��pageinfo����ȡ
	   PageInfo<TbItem> pageInfo = new PageInfo<>(list);
	   System.out.print("�ܼ�¼��  : " + pageInfo.getTotal());
   }
}