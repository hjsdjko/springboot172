package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.TushufenleiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TushufenleiView;


/**
 * 图书分类
 *
 * @author 
 * @email 
 * @date 2024-03-12 20:10:47
 */
public interface TushufenleiService extends IService<TushufenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TushufenleiView> selectListView(Wrapper<TushufenleiEntity> wrapper);
   	
   	TushufenleiView selectView(@Param("ew") Wrapper<TushufenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TushufenleiEntity> wrapper);
   	

}

