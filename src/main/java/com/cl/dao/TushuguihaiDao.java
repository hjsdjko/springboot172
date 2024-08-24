package com.cl.dao;

import com.cl.entity.TushuguihaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TushuguihaiView;


/**
 * 图书归还
 * 
 * @author 
 * @email 
 * @date 2024-03-12 20:10:48
 */
public interface TushuguihaiDao extends BaseMapper<TushuguihaiEntity> {
	
	List<TushuguihaiView> selectListView(@Param("ew") Wrapper<TushuguihaiEntity> wrapper);

	List<TushuguihaiView> selectListView(Pagination page,@Param("ew") Wrapper<TushuguihaiEntity> wrapper);
	
	TushuguihaiView selectView(@Param("ew") Wrapper<TushuguihaiEntity> wrapper);
	

}
