package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussyuelanshixinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussyuelanshixinxiView;


/**
 * 阅览室信息评论表
 *
 * @author 
 * @email 
 * @date 2024-03-12 20:10:48
 */
public interface DiscussyuelanshixinxiService extends IService<DiscussyuelanshixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyuelanshixinxiView> selectListView(Wrapper<DiscussyuelanshixinxiEntity> wrapper);
   	
   	DiscussyuelanshixinxiView selectView(@Param("ew") Wrapper<DiscussyuelanshixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyuelanshixinxiEntity> wrapper);
   	

}

