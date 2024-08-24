package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.TushujieyueEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TushujieyueView;


/**
 * 图书借阅
 *
 * @author 
 * @email 
 * @date 2024-03-12 20:10:48
 */
public interface TushujieyueService extends IService<TushujieyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TushujieyueView> selectListView(Wrapper<TushujieyueEntity> wrapper);
   	
   	TushujieyueView selectView(@Param("ew") Wrapper<TushujieyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TushujieyueEntity> wrapper);
   	

}

