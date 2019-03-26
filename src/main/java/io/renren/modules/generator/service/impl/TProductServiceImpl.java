package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.TProductDao;
import io.renren.modules.generator.entity.TProductEntity;
import io.renren.modules.generator.service.TProductService;


@Service("tProductService")
public class TProductServiceImpl extends ServiceImpl<TProductDao, TProductEntity> implements TProductService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
//        IPage<TProductEntity> page = this.page(
//                new Query<TProductEntity>().getPage(params),
//                new QueryWrapper<TProductEntity>()
//        );
//
//        return new PageUtils(page);
        return null;

    }

}