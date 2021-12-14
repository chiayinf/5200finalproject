package com.nu.seattlecrimedashboard.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nu.seattlecrimedashboard.dao.mapper.GroupActionInformationMapper;
import com.nu.seattlecrimedashboard.dao.mapper.OffenseCategoryMapper;
import com.nu.seattlecrimedashboard.model.GroupActionInformation;
import com.nu.seattlecrimedashboard.model.OffenseCategory;
import org.springframework.stereotype.Service;

@Service
public class OffenseCategoryService extends ServiceImpl<OffenseCategoryMapper, OffenseCategory>  {

}
