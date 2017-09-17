package com.nuobao.bussiness.repository;

import com.nuobao.bussiness.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 19:56
 * @modify
 **/
public interface UserRepository extends CrudRepository<User, String> {

    User findByUserNo(String userNo);


}
