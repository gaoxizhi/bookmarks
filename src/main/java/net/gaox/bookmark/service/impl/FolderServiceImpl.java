package net.gaox.bookmark.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.gaox.bookmark.entity.Folder;
import net.gaox.bookmark.mapper.FolderMapper;
import net.gaox.bookmark.service.FolderService;
import org.springframework.stereotype.Service;

/**
 * <p> 文件夹表 服务实现类 </p>
 *
 * @author gaox·Eric
 * @since 2023-04-18
 */
@Service
public class FolderServiceImpl extends ServiceImpl<FolderMapper, Folder> implements FolderService {

}
