package com.wjz.springboot.service.db1;

import com.wjz.springboot.domain.Version;
import com.wjz.springboot.mapper.db1.VersionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("versionService")
public class VersionServiceImpl implements VersionService {

    @Autowired
    private VersionMapper versionMapper;

    @Override
    public Version selectById(Integer id) {
        return versionMapper.selectById(id);
    }

    @Override
    @Transactional
    public void insert(Version version) {
        versionMapper.insert(version);
    }
}
