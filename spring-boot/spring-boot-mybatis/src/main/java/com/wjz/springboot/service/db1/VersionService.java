package com.wjz.springboot.service.db1;

import com.wjz.springboot.domain.Version;

public interface VersionService {

    Version selectById(Integer id);

    void insert(Version version);
}
