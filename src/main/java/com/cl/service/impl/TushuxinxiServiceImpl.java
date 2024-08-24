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


import com.cl.dao.TushuxinxiDao;
import com.cl.entity.TushuxinxiEntity;
import com.cl.service.TushuxinxiService;
import com.cl.entity.view.TushuxinxiView;

@Service("tushuxinxiService")
public class TushuxinxiServiceImpl extends ServiceImpl<TushuxinxiDao, TushuxinxiEntity> implements TushuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TushuxinxiEntity> page = this.selectPage(
                new Query<TushuxinxiEntity>(params).getPage(),
                new EntityWrapper<TushuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TushuxinxiEntity> wrapper) {
		  Page<TushuxinxiView> page =new Query<TushuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<TushuxinxiView> selectListView(Wrapper<TushuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TushuxinxiView selectView(Wrapper<TushuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
