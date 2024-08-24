package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YuelanshixinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YuelanshixinxiView;


/**
 * 阅览室信息
 *
 * @author 
 * @email 
 * @date 2024-03-12 20:10:47
 */
public interface YuelanshixinxiService extends IService<YuelanshixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuelanshixinxiView> selectListView(Wrapper<YuelanshixinxiEntity> wrapper);
   	
   	YuelanshixinxiView selectView(@Param("ew") Wrapper<YuelanshixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuelanshixinxiEntity> wrapper);
   	

}

