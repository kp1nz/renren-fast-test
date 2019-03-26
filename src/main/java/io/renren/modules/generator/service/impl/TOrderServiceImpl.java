package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.TOrderDao;
import io.renren.modules.generator.entity.TOrderEntity;
import io.renren.modules.generator.service.TOrderService;


@Service("tOrderService")
public class TOrderServiceImpl extends ServiceImpl<TOrderDao, TOrderEntity> implements TOrderService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
//        IPage<TOrderEntity> page = this.page(
//                new Query<TOrderEntity>().getPage(params),
//                new QueryWrapper<TOrderEntity>()
//        );
//
//        return new PageUtils(page);
        return null;

    }

}