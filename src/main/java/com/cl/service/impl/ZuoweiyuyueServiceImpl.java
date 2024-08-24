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


import com.cl.dao.ZuoweiyuyueDao;
import com.cl.entity.ZuoweiyuyueEntity;
import com.cl.service.ZuoweiyuyueService;
import com.cl.entity.view.ZuoweiyuyueView;

@Service("zuoweiyuyueService")
public class ZuoweiyuyueServiceImpl extends ServiceImpl<ZuoweiyuyueDao, ZuoweiyuyueEntity> implements ZuoweiyuyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZuoweiyuyueEntity> page = this.selectPage(
                new Query<ZuoweiyuyueEntity>(params).getPage(),
                new EntityWrapper<ZuoweiyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZuoweiyuyueEntity> wrapper) {
		  Page<ZuoweiyuyueView> page =new Query<ZuoweiyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZuoweiyuyueView> selectListView(Wrapper<ZuoweiyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZuoweiyuyueView selectView(Wrapper<ZuoweiyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
