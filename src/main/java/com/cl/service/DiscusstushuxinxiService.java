package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscusstushuxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscusstushuxinxiView;


/**
 * 图书信息评论表
 *
 * @author 
 * @email 
 * @date 2024-03-12 20:10:48
 */
public interface DiscusstushuxinxiService extends IService<DiscusstushuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusstushuxinxiView> selectListView(Wrapper<DiscusstushuxinxiEntity> wrapper);
   	
   	DiscusstushuxinxiView selectView(@Param("ew") Wrapper<DiscusstushuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusstushuxinxiEntity> wrapper);
   	

}

