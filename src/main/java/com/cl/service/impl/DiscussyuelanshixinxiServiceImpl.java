package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.DiscussyuelanshixinxiDao;
import com.cl.entity.DiscussyuelanshixinxiEntity;
import com.cl.service.DiscussyuelanshixinxiService;
import com.cl.entity.view.DiscussyuelanshixinxiView;

@Service("discussyuelanshixinxiService")
public class DiscussyuelanshixinxiServiceImpl extends ServiceImpl<DiscussyuelanshixinxiDao, DiscussyuelanshixinxiEntity> implements DiscussyuelanshixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyuelanshixinxiEntity> page = this.selectPage(
                new Query<DiscussyuelanshixinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussyuelanshixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyuelanshixinxiEntity> wrapper) {
		  Page<DiscussyuelanshixinxiView> page =new Query<DiscussyuelanshixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussyuelanshixinxiView> selectListView(Wrapper<DiscussyuelanshixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyuelanshixinxiView selectView(Wrapper<DiscussyuelanshixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
