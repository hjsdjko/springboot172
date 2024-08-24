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


import com.cl.dao.YuelanshixinxiDao;
import com.cl.entity.YuelanshixinxiEntity;
import com.cl.service.YuelanshixinxiService;
import com.cl.entity.view.YuelanshixinxiView;

@Service("yuelanshixinxiService")
public class YuelanshixinxiServiceImpl extends ServiceImpl<YuelanshixinxiDao, YuelanshixinxiEntity> implements YuelanshixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuelanshixinxiEntity> page = this.selectPage(
                new Query<YuelanshixinxiEntity>(params).getPage(),
                new EntityWrapper<YuelanshixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuelanshixinxiEntity> wrapper) {
		  Page<YuelanshixinxiView> page =new Query<YuelanshixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YuelanshixinxiView> selectListView(Wrapper<YuelanshixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuelanshixinxiView selectView(Wrapper<YuelanshixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
