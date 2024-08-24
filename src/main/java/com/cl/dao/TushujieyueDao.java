package com.cl.dao;

import com.cl.entity.TushujieyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TushujieyueView;


/**
 * 图书借阅
 * 
 * @author 
 * @email 
 * @date 2024-03-12 20:10:48
 */
public interface TushujieyueDao extends BaseMapper<TushujieyueEntity> {
	
	List<TushujieyueView> selectListView(@Param("ew") Wrapper<TushujieyueEntity> wrapper);

	List<TushujieyueView> selectListView(Pagination page,@Param("ew") Wrapper<TushujieyueEntity> wrapper);
	
	TushujieyueView selectView(@Param("ew") Wrapper<TushujieyueEntity> wrapper);
	

}
