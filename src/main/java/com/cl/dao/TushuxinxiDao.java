package com.cl.dao;

import com.cl.entity.TushuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TushuxinxiView;


/**
 * 图书信息
 * 
 * @author 
 * @email 
 * @date 2024-03-12 20:10:47
 */
public interface TushuxinxiDao extends BaseMapper<TushuxinxiEntity> {
	
	List<TushuxinxiView> selectListView(@Param("ew") Wrapper<TushuxinxiEntity> wrapper);

	List<TushuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<TushuxinxiEntity> wrapper);
	
	TushuxinxiView selectView(@Param("ew") Wrapper<TushuxinxiEntity> wrapper);
	

}
