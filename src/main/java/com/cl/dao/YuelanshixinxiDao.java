package com.cl.dao;

import com.cl.entity.YuelanshixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YuelanshixinxiView;


/**
 * 阅览室信息
 * 
 * @author 
 * @email 
 * @date 2024-03-12 20:10:47
 */
public interface YuelanshixinxiDao extends BaseMapper<YuelanshixinxiEntity> {
	
	List<YuelanshixinxiView> selectListView(@Param("ew") Wrapper<YuelanshixinxiEntity> wrapper);

	List<YuelanshixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<YuelanshixinxiEntity> wrapper);
	
	YuelanshixinxiView selectView(@Param("ew") Wrapper<YuelanshixinxiEntity> wrapper);
	

}
