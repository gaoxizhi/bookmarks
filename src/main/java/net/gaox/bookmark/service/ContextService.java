package net.gaox.bookmark.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.gaox.bookmark.entity.Context;
import net.gaox.bookmark.model.dto.ContextDTO;
import net.gaox.bookmark.model.vo.ContextVO;

import java.util.List;

/**
 * <p> 内容表 服务类 </p>
 *
 * @author gaox·Eric
 * @since 2023-04-19
 */
public interface ContextService extends IService<Context> {

    /**
     * 获取 默认最后版本
     *
     * @param version 版本
     * @return context
     */
    ContextVO get(Integer version);
    /**
     * 保存
     *
     * @param context 实体对象
     * @return version
     */
    Integer saveOne(ContextDTO context);

    /**
     * 更新
     *
     * @param context 实体对象
     * @return version
     */
    Integer updateOne(ContextDTO context);

    /**
     * 获取版本列表
     *
     * @return list
     */
    List<Integer> listVersion();
}
