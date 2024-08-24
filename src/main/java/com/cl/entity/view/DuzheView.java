package com.cl.entity.view;

import com.cl.entity.DuzheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 读者
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-12 20:10:47
 */
@TableName("duzhe")
public class DuzheView  extends DuzheEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DuzheView(){
	}
 
 	public DuzheView(DuzheEntity duzheEntity){
 	try {
			BeanUtils.copyProperties(this, duzheEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
