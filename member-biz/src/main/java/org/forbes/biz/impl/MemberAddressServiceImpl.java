package org.forbes.biz.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.forbes.biz.IMemberAddressService;
import org.forbes.dal.entity.MemberAddress;
import org.forbes.dal.mapper.MemberAddressMapper;
import org.springframework.stereotype.Service;

/**
 * @author lzw
 * @date 2019/12/13 15:05
 */
@Service
public class MemberAddressServiceImpl extends ServiceImpl<MemberAddressMapper, MemberAddress> implements IMemberAddressService {

}
