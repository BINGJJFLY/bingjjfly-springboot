package com.wjz.springboot.mapper.db1;

import com.wjz.springboot.domain.Version;

public interface VersionMapper {

	Version selectById(Integer id);

    void insert(Version version);
}
