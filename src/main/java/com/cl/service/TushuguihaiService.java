package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.TushuguihaiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TushuguihaiView;


/**
 * 图书归还
 *
 * @author 
 * @email 
 * @date 2024-03-12 20:10:48
 */
public interface TushuguihaiService extends IService<TushuguihaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TushuguihaiView> selectListView(Wrapper<TushuguihaiEntity> wrapper);
   	
   	TushuguihaiView selectView(@Param("ew") Wrapper<TushuguihaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TushuguihaiEntity> wrapper);
   	

}

