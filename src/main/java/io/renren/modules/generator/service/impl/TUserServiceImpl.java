package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.TUserDao;
import io.renren.modules.generator.entity.TUserEntity;
import io.renren.modules.generator.service.TUserService;


@Service("tUserService")
public class TUserServiceImpl extends ServiceImpl<TUserDao, TUserEntity> implements TUserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
//        IPage<TUserEntity> page = this.page(
//                new Query<TUserEntity>().getPage(params),
//                new QueryWrapper<TUserEntity>()
//        );
//
//        return new PageUtils(page);
        return null;
    }

}