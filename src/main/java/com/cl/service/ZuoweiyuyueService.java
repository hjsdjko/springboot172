package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZuoweiyuyueEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZuoweiyuyueView;


/**
 * 座位预约
 *
 * @author 
 * @email 
 * @date 2024-03-12 20:10:47
 */
public interface ZuoweiyuyueService extends IService<ZuoweiyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZuoweiyuyueView> selectListView(Wrapper<ZuoweiyuyueEntity> wrapper);
   	
   	ZuoweiyuyueView selectView(@Param("ew") Wrapper<ZuoweiyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZuoweiyuyueEntity> wrapper);
   	

}

