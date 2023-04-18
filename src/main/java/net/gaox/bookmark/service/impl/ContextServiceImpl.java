package net.gaox.bookmark.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.gaox.bookmark.config.InfoUtil;
import net.gaox.bookmark.entity.Context;
import net.gaox.bookmark.mapper.ContextMapper;
import net.gaox.bookmark.model.dto.ContextDTO;
import net.gaox.bookmark.model.vo.ContextVO;
import net.gaox.bookmark.service.ContextService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p> 内容表 服务实现类 </p>
 *
 * @author gaox·Eric
 * @since 2023-04-19
 */
@Service
public class ContextServiceImpl extends ServiceImpl<ContextMapper, Context> implements ContextService {

    @Override
    public ContextVO get(Integer version) {
        LambdaQueryWrapper<Context> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Context::getSession, InfoUtil.getSessionId()).orderByDesc(Context::getVersion);
        if (null != version) {
            wrapper.eq(Context::getVersion, version);
        } else {
            wrapper.last("limit 1");
        }
        Context one = getOne(wrapper);
        ContextVO vo = ContextVO.from(one);
        return vo;
    }

    @Override
    public Integer saveOne(ContextDTO dto) {
        Context context = new Context();
        context.setContext(dto.getContext());
        String sessionId = InfoUtil.getSessionId();
        context.setSession(sessionId);
        LambdaQueryWrapper<Context> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Context::getSession, sessionId);
        long count = count(wrapper);
        if (0 < count) {
            return null;
        }
        save(context);
        context = getById(context.getId());
        return context.getVersion();
    }

    @Override
    public Integer updateOne(ContextDTO dto) {
        Context context = new Context();
        context.setContext(dto.getContext());
        String sessionId = InfoUtil.getSessionId();
        context.setSession(sessionId);
        LambdaQueryWrapper<Context> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Context::getSession, sessionId).orderByDesc(Context::getVersion).last("limit 1");
        Context one = getOne(wrapper);
        if (null == one) {
            return null;
        }
        Integer version = one.getVersion();
        version++;
        context.setVersion(version);
        save(context);
        return version;
    }

    @Override
    public List<Integer> listVersion() {

        LambdaQueryWrapper<Context> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(Context::getVersion).eq(Context::getSession, InfoUtil.getSessionId());
        List<Context> list = list(wrapper);
        if (CollectionUtils.isEmpty(list)) {
            return Collections.EMPTY_LIST;
        }
        List<Integer> versions = list.stream().map(Context::getVersion).collect(Collectors.toList());
        return versions;
    }
}
