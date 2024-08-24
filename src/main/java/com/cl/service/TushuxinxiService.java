package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.TushuxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TushuxinxiView;


/**
 * 图书信息
 *
 * @author 
 * @email 
 * @date 2024-03-12 20:10:47
 */
public interface TushuxinxiService extends IService<TushuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TushuxinxiView> selectListView(Wrapper<TushuxinxiEntity> wrapper);
   	
   	TushuxinxiView selectView(@Param("ew") Wrapper<TushuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TushuxinxiEntity> wrapper);
   	

}

