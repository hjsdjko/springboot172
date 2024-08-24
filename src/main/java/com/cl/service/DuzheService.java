package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DuzheEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DuzheView;


/**
 * 读者
 *
 * @author 
 * @email 
 * @date 2024-03-12 20:10:47
 */
public interface DuzheService extends IService<DuzheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DuzheView> selectListView(Wrapper<DuzheEntity> wrapper);
   	
   	DuzheView selectView(@Param("ew") Wrapper<DuzheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DuzheEntity> wrapper);
   	

}

