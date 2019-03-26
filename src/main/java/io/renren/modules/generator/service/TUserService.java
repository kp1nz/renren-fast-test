package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.TUserEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-26 14:26:50
 */
public interface TUserService extends IService<TUserEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

