package com.nuobao.common.repository;

import com.nuobao.common.domain.LoginLog;
import org.springframework.data.repository.CrudRepository;

/**
 * 用户日志记录Repository
 *
 * @author Xu Chengzhi
 * @date 2017-09-19 九月 22:35
 * @modify
 **/
public interface LoginLogRepository extends CrudRepository<LoginLog, String>{
}
