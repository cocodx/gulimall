package com.lg.gulimall.member.dao;

import com.lg.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author liugang
 * @email 2cevening@gmail.com
 * @date 2022-06-24 00:00:12
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
