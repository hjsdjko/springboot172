package com.cl.dao;

import com.cl.entity.DiscussyuelanshixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussyuelanshixinxiView;


/**
 * 阅览室信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-03-12 20:10:48
 */
public interface DiscussyuelanshixinxiDao extends BaseMapper<DiscussyuelanshixinxiEntity> {
	
	List<DiscussyuelanshixinxiView> selectListView(@Param("ew") Wrapper<DiscussyuelanshixinxiEntity> wrapper);

	List<DiscussyuelanshixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyuelanshixinxiEntity> wrapper);
	
	DiscussyuelanshixinxiView selectView(@Param("ew") Wrapper<DiscussyuelanshixinxiEntity> wrapper);
	

}
