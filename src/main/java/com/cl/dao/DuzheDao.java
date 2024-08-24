package com.cl.dao;

import com.cl.entity.DuzheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DuzheView;


/**
 * 读者
 * 
 * @author 
 * @email 
 * @date 2024-03-12 20:10:47
 */
public interface DuzheDao extends BaseMapper<DuzheEntity> {
	
	List<DuzheView> selectListView(@Param("ew") Wrapper<DuzheEntity> wrapper);

	List<DuzheView> selectListView(Pagination page,@Param("ew") Wrapper<DuzheEntity> wrapper);
	
	DuzheView selectView(@Param("ew") Wrapper<DuzheEntity> wrapper);
	

}
