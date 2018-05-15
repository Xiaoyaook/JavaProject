package cn.ziliang.wxapp.dao;

import cn.ziliang.wxapp.entity.Area;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created by ziliang on 18-5-10
 */
@Repository
public interface AreaDao {
    /**
     * 列出区域信息
     *
     * @return
     */
    List<Area> queryArea();

    /**
     * 根据查询某一个区域信息
     *
     * @param id
     * @return
     */
    Area queryAreaById(Integer id);

    /**
     * 插入一个区域信息
     *
     * @param area 区域
     * @return
     */
    int insertArea(Area area);

    /**
     * 更新区域信息
     *
     * @param area
     * @return
     */
    int updateArea(Area area);

    /**
     * 删除某一个区域信息
     *
     * @param id
     * @return
     */
    int deleteAreaById(Integer id);
}
