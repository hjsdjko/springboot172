package com.cl.dao;

import com.cl.entity.ZuoweiyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZuoweiyuyueView;


/**
 * 座位预约
 * 
 * @author 
 * @email 
 * @date 2024-03-12 20:10:47
 */
public interface ZuoweiyuyueDao extends BaseMapper<ZuoweiyuyueEntity> {
	
	List<ZuoweiyuyueView> selectListView(@Param("ew") Wrapper<ZuoweiyuyueEntity> wrapper);

	List<ZuoweiyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<ZuoweiyuyueEntity> wrapper);
	
	ZuoweiyuyueView selectView(@Param("ew") Wrapper<ZuoweiyuyueEntity> wrapper);
	

}
