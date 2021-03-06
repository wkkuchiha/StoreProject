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
	   // 在mybatis中配置分页插件
	   // 在执行分页之前配置分页条件 使用pagehelper的静态方法
	   PageHelper.startPage(1, 10);
	   // 执行查询
	   ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
	   TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);
	   TbItemExample example = new TbItemExample();
	   List<TbItem> list = itemMapper.selectByExample(example);
	   // 取分页信息 使用pageinfo对象取
	   PageInfo<TbItem> pageInfo = new PageInfo<>(list);
	   System.out.print("总记录数  : " + pageInfo.getTotal());
   }
}
