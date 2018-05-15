package cn.ziliang.wxapp.service.impl;

import cn.ziliang.wxapp.dao.AreaDao;
import cn.ziliang.wxapp.entity.Area;
import cn.ziliang.wxapp.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * created by ziliang on 18-5-12
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public Area getAreaByAreaId(Integer areaId) {
        return areaDao.queryAreaById(areaId);
    }

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addArea(Area area) {
        if(area.getAreaName() != null && !"".equals(area.getAreaName())){
            // 设置插入信息时间
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());

            try {
                // 插入区域信息
                int effectedNum = areaDao.insertArea(area);

                if(effectedNum > 0){
                    return true;
                }else {
                    // @Transactional 默认只会回滚 RuntimeException 类型的异常
                    throw new RuntimeException("插入区域信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("插入区域信息失败！" + e.getMessage());
            }
        }else {
            throw new RuntimeException("插入区域信息失败！");
        }
    }

    @Override
    public boolean modifyArea(Area area) {
        if(area.getAreaId() != null && area.getAreaId() > 0){
            // 修改最后一次修改时间
            area.setLastEditTime(new Date());

            try {
                // 更新区域信息
                int effectedNum = areaDao.updateArea(area);

                if(effectedNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("修改区域信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("修改区域信息失败！" + e.getMessage());
            }
        }else {
            throw new RuntimeException("修改区域信息失败！");
        }
    }

    @Override
    public boolean deleteArea(Integer areaId) {
        if(areaId > 0){
            try {
                // 删除区域信息
                int effectedNum = areaDao.deleteAreaById(areaId);

                if(effectedNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("删除区域信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("删除区域信息失败！" + e.getMessage());
            }
        }else {
            throw new RuntimeException("删除区域信息失败！");
        }
    }
}
