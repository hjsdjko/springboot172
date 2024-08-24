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


import com.cl.dao.DuzheDao;
import com.cl.entity.DuzheEntity;
import com.cl.service.DuzheService;
import com.cl.entity.view.DuzheView;

@Service("duzheService")
public class DuzheServiceImpl extends ServiceImpl<DuzheDao, DuzheEntity> implements DuzheService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DuzheEntity> page = this.selectPage(
                new Query<DuzheEntity>(params).getPage(),
                new EntityWrapper<DuzheEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DuzheEntity> wrapper) {
		  Page<DuzheView> page =new Query<DuzheView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DuzheView> selectListView(Wrapper<DuzheEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DuzheView selectView(Wrapper<DuzheEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
